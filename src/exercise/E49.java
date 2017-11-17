package exercise;

public class E49 {
	
	public static void main(String[] args) {
//		position();/**计算子串在字符串中出现的位置，使用的方法是indexof()**/
		connection();
	}

	public static void connection() {
		String str1 = "jin";
		String str2 = "rui";
		StringBuffer sb = new StringBuffer();
		sb.append(str1);
		sb.append(str2);
//		String new_str = str1+str2;
		System.out.println("after connnection:"+sb);
	}

	public static void position() {
		String str = "jinhhhhhhyuandddddjinddfegyuanllkjinrui";
		String sub_str = "jin";
		int start = 0;
		int index = 0;
		int count = 0;
		while((index = str.indexOf(sub_str, start))!=-1){
			count++;
			start = index + sub_str.length();
		}
		System.out.println(count);
	}

}
