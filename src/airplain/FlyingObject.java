package airplain;
import java.awt.image.BufferedImage; 

/**敌机对象**/
public abstract class FlyingObject {  
    protected int x;    // x坐标
    protected int y;    // y坐标
    protected int width;    // 高  
    protected int height;   // 宽
    protected BufferedImage image;   //敌机的样子图片

    public int getX() {  
        return x;  
    }  

    public void setX(int x) {  
        this.x = x;  
    }  

    public int getY() {  
        return y;  
    }  

    public void setY(int y) {  
        this.y = y;  
    }  

    public int getWidth() {  
        return width;  
    }  

    public void setWidth(int width) {  
        this.width = width;  
    }  

    public int getHeight() {  
        return height;  
    }  

    public void setHeight(int height) {  
        this.height = height;  
    }  

    public BufferedImage getImage() {  
        return image;  
    }  

    public void setImage(BufferedImage image) {  
        this.image = image;  
    }  

    
 /*****************以上是定义飞行物对象属性*******************************************/  
    
    
 /******************飞行物必须具有移动步数，位置，是否越界属性****************************/   
    /** 
     * 检查是否出界   				抽象方法，在类中没有方法体的方法，抽象方法必须被实现！！！！
     * @return true 表示出界
     */  
    public abstract boolean outOfBounds();  

    
    
    
    
    /** 
     * 次抽象方法用于表示自己移动一步
     */  
    public abstract void step();  

    
    
    
 
    /** 
     * 此方法用于检查自己是否被敌机击中
     * @param Bullet
     * @return true 表示被击中
     */  
    public boolean shootBy(Bullet bullet){  //创建子弹对象时初始化子弹的位置
        int x = bullet.x;  //子弹的x坐标
        int y = bullet.y;  //子弹的y坐标 
        /****this.x和this.y表示当前飞行物下角的位置，x和y表示子弹的位置，画坐标图即可明白此句话表示飞行物被击中******/
        return this.x<x && x<this.x+width && this.y<y && y<this.y+height;  
    }  

}