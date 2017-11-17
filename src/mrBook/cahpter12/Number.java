package mrBook.cahpter12;

public class Number {
	public int count(int a,int b) throws Exception{
		int max = a*b;
		if(max > 10000){
			throw new Exception("计算结果过大！！！");
		}
		return max;
	}
}
