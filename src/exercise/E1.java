package exercise;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class E1 extends JPanel {
	
	private Timer timer;

	public static void main(String[] args) {
		
		JFrame jr = new JFrame("金锐");
		jr.setSize(400, 400);
		jr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String path = "D:/Users/King/workspace/J2SE/src/airplain/bee.png";
		jr.setIconImage(new ImageIcon(path).getImage());//可以自定义图标，不添加表示默认图标
		
		jr.setVisible(true);//没有这句话显示不出来图标
		
		E1 e1 = new E1();
		jr.add(e1);//必须继承JPanel成为一个commponent才能添加
		e1.action();
	
	}
	 public void action(){
		 MouseAdapter ma = new MouseAdapter(){
			 @Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("黄菁媛");
			}
			 
			 @Override
			public void mousePressed(MouseEvent e) {
				
				 System.out.println("Press");
			}
			 
			 @Override
			public void mouseMoved(MouseEvent e) {
				 int x = e.getX();
				 int y = e.getY();
				 System.out.println("x="+x+",y="+y);
			}
			 
			 
		 };
		 
		 this.addMouseListener(ma);
		 this.addMouseMotionListener(ma);
		 
		 timer = new Timer();
		 timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				if(true){
					Random random = new Random();
					int num = random.nextInt(2);
					System.out.println("Miss huang,Je t'aime "+num);
				}
				repaint();//这个是什么方法？
			}
		}, 1000, 1000);
		 
	 }
}
