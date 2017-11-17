package mrBook.cahpter4;

public class E2 {

	public static void main(String[] args) {
		int N = 5;
		for(int x = 0; x<N ; x++){
			for(int z=x; z<N; z++){
				System.out.print(" ");
			}
			for(int y = 0; y<=x; y++){
				System.out.print("**");
			}
			System.out.println();
		}
	}

}
