package mrBook.cahpter10.chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.*;

public class GuiChat extends JFrame{
	private static final int DEFAULT_PORT = 8899;
	
	private JLabel stateLB;
	private JTextArea centerTextArea;
	private JPanel southPanel;
	private JTextArea inputTextArea;
	private JPanel bottomPanel;
	private JTextField ipTextField;
	private JTextField remotePortTF;
	private JButton sendBT;
	private JButton clearBT;
	private DatagramSocket datagramSocket;
	
	private void setUpUI(){
		setTitle("GUI����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		setResizable(false);
		setLocationRelativeTo(null);//???
		
		stateLB = new JLabel("��ǰ��δ��������");
		stateLB.setHorizontalAlignment(JLabel.RIGHT);
		centerTextArea = new JTextArea();
		centerTextArea.setEditable(false);
		centerTextArea.setBackground(new Color(211,211,211));
		
		southPanel = new JPanel(new BorderLayout());
		inputTextArea = new JTextArea(5,20);
		bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,5,5));
		ipTextField = new JTextField("127.0.0.1",8);
		remotePortTF = new JTextField(String.valueOf(DEFAULT_PORT),3);
		sendBT = new JButton("����");
		clearBT = new JButton("����");
		bottomPanel.add(ipTextField);
		bottomPanel.add(remotePortTF);
		bottomPanel.add(sendBT);
		bottomPanel.add(clearBT);
		southPanel.add(new JScrollPane(inputTextArea),BorderLayout.CENTER);
		southPanel.add(bottomPanel,BorderLayout.SOUTH);
		add(stateLB,BorderLayout.NORTH);
		add(new JScrollPane(centerTextArea),BorderLayout.CENTER);
		add(southPanel,BorderLayout.SOUTH);
		setVisible(true);	
	}
	
	private void setListener(){
		sendBT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				final String ipAddress = ipTextField.getText();
				final String remotePort = remotePortTF.getText();
				
				if(ipAddress==null||ipAddress.trim().equals("")||remotePort==null||remotePort.trim().equals("")){
					JOptionPane.showMessageDialog(GuiChat.this, "������IP��ַ�Ͷ˿ں�");
					return;
				}
				
				if(datagramSocket==null||datagramSocket.isClosed()){
					JOptionPane.showMessageDialog(GuiChat.this, "�������ɹ�");
					return;
				}
				
				String sendContent = inputTextArea.getText();
				byte[] buf = sendContent.getBytes();
				centerTextArea.append("�Ҷ�"+ipAddress+":"+remotePort+"˵:\n"+inputTextArea.getText()+"\n\n");
				centerTextArea.setCaretPosition(centerTextArea.getText().length());
				try {
					datagramSocket.send(new DatagramPacket(buf,buf.length,InetAddress.getByName(ipAddress),Integer.parseInt(remotePort)));
					inputTextArea.setText("");
				} catch (NumberFormatException e1) {
					
					e1.printStackTrace();
				} catch (UnknownHostException e1) {
					
					e1.printStackTrace();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
			}
		});
		
		clearBT.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				centerTextArea.setText("");
			}});
	}
	
	
	private void initSocket(){
		int port = DEFAULT_PORT;
		while(true){
			
			try {
				if(datagramSocket!=null && !datagramSocket.isClosed()){
					datagramSocket.close();
				}
				port = Integer.parseInt(JOptionPane.showInputDialog(this,"������˿ں�","�˿ں�",JOptionPane.QUESTION_MESSAGE));
				if(port<1||port>65535){
					throw new RuntimeException("�˿ںų�����Χ");
				}
				
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "����Ķ˿ڲ���ȷ��������1~65535֮�����");
				continue;
			}
			
			try {
				datagramSocket = new DatagramSocket(port);
				startListener();
				stateLB.setText("����"+port+"�˿ڼ���");
				break;
			} catch (SocketException e) {
				
				JOptionPane.showMessageDialog(this,"�˿��ѱ�ռ�ã���������ö˿�");
				stateLB.setText("��ǰ��δ��������");
			}
		}
	}

	private void startListener() {
		new Thread(){
			private DatagramPacket p;
			public void run(){
				byte[] buf = new byte[1024];
				
				p = new DatagramPacket(buf,buf.length);
				while(!datagramSocket.isClosed()){
					try {
						datagramSocket.receive(p);
						centerTextArea.append(p.getAddress().getHostAddress()+":"+((InetSocketAddress)p.getSocketAddress()).getPort()+"����˵:\n"+new String(p.getData(),0,p.getLength())+"\n\n");
						centerTextArea.setCaretPosition(centerTextArea.getText().length());
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		}.start();
	}
	
	
	public GuiChat(){
		setUpUI();
		initSocket();
		setListener();
	}
	
	public static void main(String[] args){
		new GuiChat();
	}
	
	
}
