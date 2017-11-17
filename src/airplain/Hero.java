package airplain;
import java.awt.image.BufferedImage;  

public class Hero extends FlyingObject{  
	/***定义英雄机属性****/
    private BufferedImage[] images = {};  //英雄机图片 ，有多张
    private int index = 0;                //英雄机图片的索引

    private int doubleFire;   // 双倍火力
    private int life;   // 生命数

    /**初始化数据，通过继承获得FlyingObject中的字段**/  
    public Hero(){
    	
        life = 3;   //3条命
        doubleFire = 0;   //双倍火力
        images = new BufferedImage[]{ShootGame.hero0, ShootGame.hero1}; // 直接静态调用主类中的属性值
        image = ShootGame.hero0;   //初始时为hero0图片
        width = image.getWidth(); //
        height = image.getHeight(); 
        x = 150;  
        y = 400;  
    }  

    /** 获取双倍火力 **/  
    public int isDoubleFire() {  
        return doubleFire;  
    }  

    /**设置双倍火力，给doubleFire赋值 */  
    public void setDoubleFire(int doubleFire) {  
        this.doubleFire = doubleFire;  
    }  

    
    
    /**加火力*/  
    public void addDoubleFire(){  
        doubleFire = 40;  
    }  

    /**加生命 */  
    public void addLife(){
        life++;  
    }  

    /** 减生命**/  
    public void subtractLife(){
        life--;  
    }  

    /**获得生命值*/  
    public int getLife(){  
        return life;  
    }  

    /** 移动位置？？？  */  
    public void moveTo(int x,int y){     
        this.x = x - width/2;  
        this.y = y - height/2;  
    }  

    /**越界*/  
    @Override  
    public boolean outOfBounds() {  
        return false;    
    }  

    /** 发射子弹，分双倍火力和单倍火力*/  
    public Bullet[] shoot(){  
    	
        int xStep = width/4;      //子弹发射位置
        int yStep = 20; 
        if(doubleFire>0){
            Bullet[] bullets = new Bullet[2];
            /***两个子弹间距 1/2的机宽***/
            bullets[0] = new Bullet(x+xStep,y-yStep);  //y-yStep(子弹距飞机的位置)
            bullets[1] = new Bullet(x+3*xStep,y-yStep); //
            return bullets;  
        }else{
            Bullet[] bullets = new Bullet[1];  
            bullets[0] = new Bullet(x+2*xStep,y-yStep);    
            return bullets;  
        }  
    }  

    /**移动*/  
    @Override  
    public void step() {  
        if(images.length>0){  
            image = images[index/10%images.length];  //index莫伊2，产生奇数和偶数
            index++;
        }  
    }  

    /** 碰撞算法**/  
    public boolean hit(FlyingObject other){  

        int x1 = other.x - this.width/2;                 //x最小距离？？
        int x2 = other.x + this.width/2 + other.width;   //x最大距离？？
        int y1 = other.y - this.height/2;                //y最小距离？？ 
        int y2 = other.y + this.height/2 + other.height; //y最大距离？？

        int herox = this.x + this.width/2;               //英雄机的x中心位置
        int heroy = this.y + this.height/2;              //英雄机的y中心位置

        return herox>x1 && herox<x2 && heroy>y1 && heroy<y2;   //此区间范围表示碰撞了
    }  

}
