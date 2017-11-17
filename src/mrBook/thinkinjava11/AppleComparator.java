package mrBook.thinkinjava11;

import java.util.Comparator;

public class AppleComparator implements Comparator<Apple> {

	@Override
	public int compare(Apple a1, Apple a2) {
		if(a1.getA()!=a2.getA()){
			return 1;
		}else{
			return 0;
		}
		
	}
}
