package airplain;

/****子弹也是飞行物，飞行物必须具有位置和移动属性*******/
public class Bullet extends FlyingObject {  
    private int speed = 6;  // 定义子弹移动的速度 

    /***初始化子数据，定义子弹的位置和图片***/  
    public Bullet(int x,int y){  
        this.x = x;  
        this.y = y;  
        this.image = ShootGame.bullet;  
    }  

    /**移动步数**/  
    @Override  
    public void step(){     
        y=y-speed;  
    }  

    /**表示子弹越界**/  
    @Override  
    public boolean outOfBounds() {  
        return y<-height;  
    }  

}
