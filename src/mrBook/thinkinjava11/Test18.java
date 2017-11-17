package mrBook.thinkinjava11;

import java.util.*;


public class Test18 {

	public static void main(String[] args) {
		Random rand = new Random(50);
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		Map<Integer,Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();
		for(int i=0; i<20; i++){
			map.put(i, rand.nextInt(20));
			linkedHashMap.put(i, map.get(i));
//			System.out.println(linkedHashMap);
		}
		///////////////////////////////////////////////////////////获取是有序的
		//Set<Integer> set = linkedHashMap.keySet();
		
		System.out.print(linkedHashMap+" ");
		
		System.out.println();
		////////////////////////////////////////////////////////////////
		
		System.out.print(map+" ");
		
		/////////////////////////////////////////////////////////////////

	}

}
