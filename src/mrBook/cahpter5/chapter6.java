package mrBook.cahpter5;

public class chapter6 {
	public static void main(String[] args){
		int num1=1,num2=10;
		int i = 0;
		int j = 0;
		int[] s = new int[num2-num1+1];
		int[] arr = new int[6];
		
		for(i=0; i<num2;i++){
			s[i] = num1+(int)(Math.random()*(num2-num1));
			System.out.print(s[i]+" ");
			if(j<6 && s[i]%2==0){
				arr[j]=s[i];
				j++;
			}
		}
		
		
		System.out.println();
		for(int a: arr){
			System.out.print(a+" ");
		}
	}
}
