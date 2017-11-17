package mrBook.cahpter12;

public class Student {
	public void speak(int m) throws MyException{
		if(m>100)
			throw new MyException("参数过大");
	}
}
