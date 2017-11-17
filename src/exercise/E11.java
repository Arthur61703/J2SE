package exercise;

public class E11 {

	public static void main(String[] args) {
		int count=0;
		for(int a=1; a<=4;a++){
			for(int b=1; b<=4;b++){
				if(b!=a){
					
					for(int c=1; c<=4; c++){
						if(c!=b&&c!=a){
							System.out.print(a+""+b+""+c+" ");
							count++;
						}
						
					}
					
				}
			}
		}
		System.out.println();
		System.out.println(count);

	}

}
