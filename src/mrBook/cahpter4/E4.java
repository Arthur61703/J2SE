package mrBook.cahpter4;

import org.junit.Test;

public class E4 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		String s = "abcd";
		for(int i = 0; i<10000; i++){
			s = s+i;	
		}
//		System.out.print(s);// result : abcd1
		long end = System.currentTimeMillis();
		System.out.println(end-start);

	}
//	@Test
	public void fun1(){//测试发现StringBuffer 比String快很多
		long start = System.currentTimeMillis();
		
		StringBuffer sb = new StringBuffer();
		sb.append("abcd");
		for(int i = 0; i<10000; i++){
			sb.append(i);	
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		System.out.println(sb);
	}
	
	@Test
	public void fun2(){
		long start = System.currentTimeMillis();
		String s = "abcd";
		for(int i = 0; i<10000; i++){
			s = s+i;	
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		System.out.println(s);
	}

}
