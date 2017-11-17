package exercise;

public class Magic3 {

	public static void main(String[] args) {
		String s = "aaabbaaac";
		int count = 1;
		char c = s.charAt(0);
		for(int i = 0; i<s.length(); i++){
			if(c!=s.charAt(i)){
				count++;
				c = s.charAt(i);
			}
		}
		
		double average = (double)s.length()/count;
		System.out.println(average);

	}

}
