package airplain;

import java.awt.Font;  
import java.awt.Color;  
import java.awt.Graphics;  
import java.awt.event.MouseAdapter;  
import java.awt.event.MouseEvent;  
import java.util.Arrays;  
import java.util.Random;  
import java.util.Timer;  
import java.util.TimerTask;  
import java.awt.image.BufferedImage;  

import javax.imageio.ImageIO;  
import javax.swing.ImageIcon;  
import javax.swing.JFrame;  
import javax.swing.JPanel;  

public class ShootGame extends JPanel {  
    public static final int WIDTH = 485; // 面板宽
    public static final int HEIGHT = 860; // 面板高
    
    /** 游戏状态: START RUNNING PAUSE GAME_OVER */  
    private int state;  
    private static final int START = 0;  
    private static final int RUNNING = 1;  
    private static final int PAUSE = 2;  
    private static final int GAME_OVER = 3;  

    private int score = 0; // 得分
    private Timer timer; // 定时器  ？？？？？
    private int intervel = 1000 / 100; // 时间间隔

    public static BufferedImage background;  //	BufferedImage类用法，加载图片进内存
    public static BufferedImage start;  
    public static BufferedImage airplane;  
    public static BufferedImage bee;  
    public static BufferedImage bullet;  
    public static BufferedImage hero0;  
    public static BufferedImage hero1;  
    public static BufferedImage pause;  
    public static BufferedImage gameover;  

    private FlyingObject[] flyings = {}; // 飞行物数量
    private Bullet[] bullets = {}; // 子弹数组
    private Hero hero = new Hero(); // 英雄机

    static { //  BufferedImage类用法，加载图片进内存，通过静态代码块，初始化只加载一次！！！
        try {  
            background = ImageIO.read(ShootGame.class.getResource("background.png"));  
            start = ImageIO.read(ShootGame.class.getResource("start.png"));  
            airplane = ImageIO.read(ShootGame.class.getResource("airplane.png"));  
            bee = ImageIO.read(ShootGame.class.getResource("bee.png"));  
            bullet = ImageIO.read(ShootGame.class.getResource("bullet.png"));  
            hero0 = ImageIO.read(ShootGame.class.getResource("hero0.png"));  
            hero1 = ImageIO.read(ShootGame.class.getResource("hero1.png"));  
            pause = ImageIO.read(ShootGame.class.getResource("pause.png"));  
            gameover = ImageIO.read(ShootGame.class.getResource("gameover.png"));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  

    /**画*/  
    @Override  
    public void paint(Graphics g) {  //输入画笔对象
    	
        g.drawImage(background, 0, 0, null); // 画背景图 ，了解drawImage方法及其参数
        paintHero(g); // 画英雄机 
        paintBullets(g); // 画子弹
        paintFlyingObjects(g); // 画飞行物
        paintScore(g); // 画分数
        paintState(g); // 画游戏状态
    }  

    /****/  
    public void paintHero(Graphics g) {  
        g.drawImage(hero.getImage(), hero.getX(), hero.getY(), null);  
    }  

    /**画子弹**/  
    public void paintBullets(Graphics g) {  
        for (int i = 0; i < bullets.length; i++) {  
            Bullet b = bullets[i];  
            g.drawImage(b.getImage(), b.getX() - b.getWidth() / 2, b.getY(),  
                    null);  
        }  
    }  

    /****/  
    public void paintFlyingObjects(Graphics g) {  
        for (int i = 0; i < flyings.length; i++) {  
            FlyingObject f = flyings[i];  
            g.drawImage(f.getImage(), f.getX(), f.getY(), null);  
        }  
    }  

    /** ������ */  
    public void paintScore(Graphics g) {  
        int x = 10; // 分数显示位置
        int y = 25; // 分数显示位置
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 22); // 分数显示字体
        g.setColor(new Color(0xFF0000));  //设置字体颜色
        g.setFont(font); // 设置字体
        g.drawString("SCORE:" + score, x, y); // drawString 方法
        y=y+20; // y坐标增加20  
        g.drawString("LIFE:" + hero.getLife(), x, y); // 画命 
    }  

    /**游戏状态**/  
    public void paintState(Graphics g) {  
        switch (state) {  
        case START: // 启动页面
            g.drawImage(start, 0, 0, null);  
            break;  
        case PAUSE: // 暂定页面
            g.drawImage(pause, 0, 0, null);  
            break;  
        case GAME_OVER: // 结束页面
            g.drawImage(gameover, 0, 300, null);  
            break;  
        }  
    }  

    public static void main(String[] args) {  
    	
        JFrame frame = new JFrame("Fly");// 面板对象
        ShootGame game = new ShootGame(); 
        frame.add(game); // 将主类添加到面板中
        frame.setSize(WIDTH, HEIGHT); // 设置面板大小
        frame.setAlwaysOnTop(true); // 出现总是居上
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 使用默认关闭操作
        frame.setIconImage(new ImageIcon("images/icon.jpg").getImage()); // 设置窗体的图标，此处采用默认图标
        frame.setLocationRelativeTo(null); // 设置窗体出现的初始位置
        frame.setVisible(true);

        game.action(); // 启动执行
    }  

    /** ����ִ�д��� */  
    public void action() {  
        // 鼠标监听
        MouseAdapter l = new MouseAdapter() {  
            @Override  
            public void mouseMoved(MouseEvent e) { // 鼠标移动
                if (state == RUNNING) { // 运行状态下移动英雄机--随鼠标位置 
                    int x = e.getX(); 
                    int y = e.getY();  
                    hero.moveTo(x, y);
                }  
            }  

            @Override
            public void mouseEntered(MouseEvent e) { // 鼠标进入
                if (state == PAUSE) { // 鼠标进入就进入运行状态
                    state = RUNNING; 
                }  
            }  

            @Override
            public void mouseExited(MouseEvent e) { // 鼠标退出
                if (state == RUNNING) { // 鼠标移走就进入暂停画面
                    state = PAUSE;  
                }  
            }  

            @Override
            public void mouseClicked(MouseEvent e) { // 鼠标点击事件
                switch (state) {  
                case START:  
                    state = RUNNING;
                    break;  
                case GAME_OVER:
                    flyings = new FlyingObject[0]; // 清空飞行物
                    bullets = new Bullet[0]; // 清空子弹
                    hero = new Hero(); // 清空英雄机
                    score = 0; // 清空分数
                    state = START; // 重置状态为开始
                    break;  
                }  
            }  
        };  
        this.addMouseListener(l); // 处理鼠标点击
        this.addMouseMotionListener(l); // 处理鼠标滑动

        timer = new Timer(); // 请自行百度Timer类的用法
        
        timer.schedule(new TimerTask() {
            @Override
            public void run() { 
                if (state == RUNNING) {
                    enterAction(); // 生成敌机飞行物进入
                    stepAction(); // 飞行物移动
                    shootAction(); // 英雄机射击事件
                    bangAction(); // 
                    outOfBoundsAction(); // ɾ��Խ������Ｐ�ӵ�  
                    checkGameOverAction(); // �����Ϸ����  
                } 
                repaint(); // �ػ棬����paint()����  
            }

        }, intervel, intervel);  
    }  

    int flyEnteredIndex = 0; //

    /**生成敌机**/  
    public void enterAction() {  
        flyEnteredIndex++;  //飞行物产生的时间间隔
        if (flyEnteredIndex % 40 == 0) { // 每隔40s产生一个飞行物  
            FlyingObject obj = nextOne();
            flyings = Arrays.copyOf(flyings, flyings.length + 1);  //用Arrays.copyOf实现数组长度自增
            flyings[flyings.length - 1] = obj;
        }  
    }  

    /**？？？？？*/  
    public void stepAction() {  
    	
    	/*****这里没看懂******/
        for (int i = 0; i < flyings.length; i++) { // 遍历此时敌机数量
            FlyingObject f = flyings[i];  
            f.step();
        }  

        for (int i = 0; i < bullets.length; i++) { // 让子弹飞起来
            Bullet b = bullets[i];
            b.step();  
        }  
        hero.step(); // 切换英雄机
    }  

    /**此段代码何用？？？**/  
//    public void flyingStepAction() {  
//        for (int i = 0; i < flyings.length; i++) {  
//            FlyingObject f = flyings[i];  
//            f.step();  
//        }  
//    }  

    int shootIndex = 0;

    /** ��� */  
    public void shootAction() {  
        shootIndex++;  
        if (shootIndex % 30 == 0) { // 每30s执行一次 
            Bullet[] bs = hero.shoot(); // 发射子弹，单或双
            /***bullets.length是当前屏幕中存在的子弹数**/
            /***bs.length是当前屏幕中每次发射子弹数目**/
            bullets = Arrays.copyOf(bullets, bullets.length + bs.length); // 数组自增，bullets增长长度随子弹数量进行变化
            System.arraycopy(bs, 0, bullets, bullets.length - bs.length,bs.length); // ？？？？？
        }  
    }

    /** �ӵ����������ײ��� */  
    public void bangAction() {  
        for (int i = 0; i < bullets.length; i++) { // 遍历当前屏幕中的子弹数量
            Bullet b = bullets[i];  
            bang(b); // 子弹消失  
        }  
    }  

    /** ɾ��Խ������Ｐ�ӵ� */  
    public void outOfBoundsAction() {  
        int index = 0; // ����  
        FlyingObject[] flyingLives = new FlyingObject[flyings.length]; // ���ŵķ�����  
        for (int i = 0; i < flyings.length; i++) {  
            FlyingObject f = flyings[i];  
            if (!f.outOfBounds()) {  
                flyingLives[index++] = f; // ��Խ�������  
            }  
        }  
        flyings = Arrays.copyOf(flyingLives, index); //

        index = 0; // ��������Ϊ0  
        Bullet[] bulletLives = new Bullet[bullets.length];  
        for (int i = 0; i < bullets.length; i++) {  
            Bullet b = bullets[i];  
            if (!b.outOfBounds()) {  
                bulletLives[index++] = b;  
            }  
        }  
        bullets = Arrays.copyOf(bulletLives, index); //
    }  

    /** �����Ϸ���� */  
    public void checkGameOverAction() {  
        if (isGameOver()==true) {  
            state = GAME_OVER; //
        }  
    }

    /** �����Ϸ�Ƿ���� */  
    public boolean isGameOver() {  

        for (int i = 0; i < flyings.length; i++) {  
            int index = -1;  
            FlyingObject obj = flyings[i];  
            if (hero.hit(obj)) { // ���Ӣ�ۻ���������Ƿ���ײ  
                hero.subtractLife(); // ����  
                hero.setDoubleFire(0); // ˫���������  
                index = i; // ��¼���ϵķ���������  
            }  
            if (index != -1) {  
                FlyingObject t = flyings[index];  
                flyings[index] = flyings[flyings.length - 1];  
                flyings[flyings.length - 1] = t; // ���ϵ������һ�������ｻ��  

                flyings = Arrays.copyOf(flyings, flyings.length - 1); // ɾ�����ϵķ�����  
            }  
        }  

        return hero.getLife() <= 0;  
    }  

    /** �ӵ��ͷ�����֮�����ײ��� */  
    public void bang(Bullet bullet) {  
        int index = -1; // ���еķ���������  
        for (int i = 0; i < flyings.length; i++) {  //遍历所有的敌机
            FlyingObject obj = flyings[i];  
            if (obj.shootBy(bullet)) { // 击中敌机
                index = i; // ��¼�����еķ����������  
                break;  
            }  
        }  
        if (index != -1) { // �л��еķ�����  
            FlyingObject one = flyings[index]; // index记录的是被击中的敌机

            FlyingObject temp = flyings[index]; // ？？？
            flyings[index] = flyings[flyings.length - 1];  
            flyings[flyings.length - 1] = temp;  

            flyings = Arrays.copyOf(flyings, flyings.length - 1); // 飞行物数量减一个

            // 飞行物中有得分的，也有奖励生命值和双倍火力的，击杀可以得到
            if (one instanceof Enemy) { // 判断此飞行物是不是敌机
                Enemy e = (Enemy) one;
                score += e.getScore(); 
            } else {//如果集中的是
                Award a = (Award) one;  
                int type = a.getType(); // award借口定义的非常巧妙
                switch (type) {  
                case Award.DOUBLE_FIRE:  //通过类名调用成员变量
                    hero.addDoubleFire(); //给double_fire赋值，火力值为40
                    break;  
                case Award.LIFE:  
                    hero.addLife(); // ���ü���  
                    break;  
                }  
            }  
        }  
    }  

    /** 
     * ������ɷ����� 
     *  
     * @return ��������� 
     */  
    public static FlyingObject nextOne() {  
        Random random = new Random();
        int type = random.nextInt(20); // [0,20)  
        /***此处可以控制小蜜蜂与打飞机出现的比例***/
        if (type < 10) {  
            return new Bee();  //生成小蜂蜜
        } else {  
            return new Airplane();  //生成大飞机
        }  
    }  

}