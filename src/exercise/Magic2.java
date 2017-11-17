package exercise;

public class Magic2 {

	public static void main(String[] args) {
		int n = 1000;
		String str = String.valueOf(n);/**int---string**/
		String temp1 = "";
		String temp2 = "";
		char[] cha = str.toCharArray();/***string---char[]**/
		char[] cha_rev = new char[cha.length];
		int sum = 0;
		for(int i = 0; i<cha.length; i++){
			cha_rev[i] = cha[cha.length-i-1];
			
			temp1 = String.valueOf(cha_rev[i]);
			temp2 = String.valueOf(cha[i]);
			
			sum += (int) ((Integer.parseInt(temp1)+Integer.parseInt(temp2))*Math.pow(10, i));
			
		}
		System.out.println(sum);
		
	}

}
