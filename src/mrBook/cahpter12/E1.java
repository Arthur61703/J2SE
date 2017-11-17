package mrBook.cahpter12;

public class E1 {

	public static void main(String[] args) {
		Student stu = new Student();
		try {
			stu.speak(2000);
			
		} catch (MyException e) {
			
			System.out.println(e.toString());;
		}
	}

}
