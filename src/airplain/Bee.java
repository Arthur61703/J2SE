package airplain;
import java.util.Random; 

public class Bee extends FlyingObject implements Award{  
    private int xSpeed = 1;   //x方向移动速度
    private int ySpeed = 2;   //y方向移动速度
    private int awardType;    //奖励类型

    /**设定飞行物基本参数*/  
    public Bee(){  
        image = ShootGame.bee;
        width = image.getWidth();  
        height = image.getHeight();  
        y = -height;  
        Random rand = new Random();  
        x = rand.nextInt(ShootGame.WIDTH - width);  
        awardType = rand.nextInt(2);   //奖励0分或1分
    }  

    /**返回的分数**/  
    public int getType(){  
        return awardType;
    }  

    /**每隔飞行物定义越界处理**/  
    @Override  
    public boolean outOfBounds() {  
        return y>ShootGame.HEIGHT; 
    }  

    /**定义小蜜蜂飞行轨迹**/  
    @Override  
    public void step() {        
        x += xSpeed;  
        y += ySpeed;  
        if(x > ShootGame.WIDTH-width){   //如果小蜜蜂触右边，就往回反弹 
            xSpeed = -1;  
        }  
        if(x < 0){  //如果小蜜蜂触左边，就往回反弹 
            xSpeed = 1;  
        }  
    }  
}
