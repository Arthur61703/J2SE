package exercise;

public class Magic {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		int n=10;
		String res = magic(n,sb);
		char[] cha = res.toCharArray();
		
		for(int i = cha.length-1; i>=0; i--){
			
			System.out.print(cha[i]);
		}
		
	}

	private static String magic(int n, StringBuffer sb) {
		
		while(n>0){
			if(n%2==0){
				sb.append("2");
				n = (n-2)/2;
			}else{
				sb.append("1");
				n = (n-1)/2;
			}
		}
		
		return sb.toString();
	}
	
	

}
