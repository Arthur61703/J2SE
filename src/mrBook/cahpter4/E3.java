package mrBook.cahpter4;

public class E3 {

	public static void main(String[] args) {
		int N = 15;
		double[] f = new double[N];
		f= factorial(N);
		sum(f);
		System.out.println(sum(f));

	}

	private static double sum(double[] n) {
		double add = 0;
		for(int i = 0; i<n.length; i++){
			add +=n[i];
		}
		return add;
	}

	private static double[] factorial(int n) {
		int fac = 1;
		int i = 1;
		double[] f = new double[n];
		while(i<=n){
			fac = fac*i;
			f[i-1] = 1.0/fac;
//			System.out.println(f[i-1]);
			i++;
		}
		return f;
	}

}
