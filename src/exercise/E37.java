package exercise;

import java.util.*;

public class E37 {
	/***��n����Χ��һȦ��˳���źš��ӵ�һ���˿�ʼ��������1��3��������������3�����˳�Ȧ�ӣ���������µ���ԭ���ڼ��ŵ���λ��***/
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=1; i<=100;i++){
			list.add(i);
		}
		
		List list2 = countNum(list);
		System.out.println(list2.size());

	}

	public static List countNum(List<Integer> list) {
		
		for(int j=0;j<list.size();j++){
			
			int k = list.get(j);
			if(k%3==0){
				list.remove(j);
			}
		}
		int size = list.size();
//		System.out.println(size);
		list.clear();
		
		for(int i = 0; i<size;i++){
			list.add(i);
		}
		
		if(size>2){
			return countNum(list);
		}else{
			return list;
			
		}
	}

}
