package mrBook.thinkinjava11;

public class Gerbil {
    private int gerbilNumber;

    public int getGerbilNumber() {
        return gerbilNumber;
    }

    public void setGerbilNumber(int gerbilNumber) {
        this.gerbilNumber = gerbilNumber;
    }
    /**自定义构造方法**/
    public Gerbil(int gerbilNumber) {
        setGerbilNumber(gerbilNumber);
    }

    public void hop() {
        System.out.println("gerbilNumber==" + gerbilNumber);
    }
}