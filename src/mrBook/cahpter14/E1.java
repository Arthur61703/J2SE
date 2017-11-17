package mrBook.cahpter14;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class E1 {

	public static void main(String[] args) {
//		List<String> list = new LinkedList<String>();
//		for(int i = 1; i<=20; i++){
//			list.add("a");
//		}
//		list.remove(10);
//		Iterator<String> it = list.iterator();
//		while(it.hasNext()){
//			System.out.print(it.next());
//		}
//		for(String a:list){
//			System.out.print(a+" ");
//		}
		
		Set<String> set = new HashSet<String>();
		for(int i = 1; i<=20; i++){
			set.add("b");
		}
		for(String b:set){
			System.out.print(b+" ");
		}
		
		
	}

}
