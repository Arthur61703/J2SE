package airplain;
import java.util.Random;

public class Airplane extends FlyingObject implements Enemy {
	
    private int speed = 6;  //飞机移动速度，只定义了y方向的速度

    /*************************初始化图片的五个基本参数*****************************************/
    public Airplane(){
    	
        image = ShootGame.airplane;
        width = image.getWidth();
        height = image.getHeight();
        y = -height;          
        Random rand = new Random();
        x = rand.nextInt(ShootGame.WIDTH - width);
    }

    /**************************设定三个特征值：得分，越界，移动**********************************/
    @Override
    public int getScore() {  
        return 5;
    }
    @Override
    public boolean outOfBounds() {   
        return y>ShootGame.HEIGHT;
    }
    @Override
    public void step() {   
        y += speed;
    }

}