package mrBook.thinkinjava11;

import java.util.*;


public class Test12 {

	public static void main(String[] args) {
		Gerbil spot = new Gerbil(001);
		Gerbil tome = new Gerbil(002);
		
		Map<String,Gerbil> petMap = new HashMap<String,Gerbil>();
		petMap.put("spot", spot);
		petMap.put("tome", tome);
		Set<String> key = petMap.keySet();
		Iterator<String> it = key.iterator();
		while(it.hasNext()){
			String num = it.next();
			System.out.println(num);
			petMap.get(num).hop();
		}
		

	}

}
