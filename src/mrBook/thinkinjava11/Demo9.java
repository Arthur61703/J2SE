package mrBook.thinkinjava11;

import java.util.*;

public class Demo9 {

	public static void main(String[] args) {
		primeNumber(6);

	}
	
	public static void primeNumber(int n){
		Set<Integer> a = new HashSet<Integer>();
		int j = n;
        for (int x = 2; x <= j; x++)
        {
            if(j%x == 0)
            {
                j/=x;
                a.add(x);
                x--;        //为了防止该整数有多个相同质因数最终只能输出一个的情况
            }
        }
        
        Integer[] arr = a.toArray(new Integer[0]);//非常重要，转换成自己想要的数组类型
        
        int total = 1;
        for(int i = 0; i<arr.length;i++){
        	total = total+arr[i];
        	System.out.println(arr[i]);
        }
        if(n==total){
        	System.out.println(n+"是完数");
        }else{
        	System.out.println(n+"不是完数");
        }
        
	}

}
