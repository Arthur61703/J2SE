package exercise;

public class E13 {

	public static void main(String[] args) {
		for(int i=0; i<1000000; i++){
			
			int a = (int)Math.sqrt(i+100);
			int b = (int)Math.sqrt(i+268);
			
			if(((i+100)==Math.pow(a, 2))&&((i+268)==Math.pow(b, 2))){
				System.out.print(i+" ");
			}
		}

	}

}
