package exercise;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class E10 extends E2{
	
	public static void main(String[] args) {
		int[] arr  =new int[1];
		for(int i = 0; i<10; i++){
			
			arr = Arrays.copyOf(arr, arr.length+1);
			System.out.println(arr.length);		
		}
		
		Map map = new HashMap();
		Map table = new Hashtable();
	}

	private static double function(int n) {
		if(n==1){
			return 1+1.0/2;
		}else {
			
			return (function(n-1)+1/Math.pow(2, n));
		}
		
	}

}
