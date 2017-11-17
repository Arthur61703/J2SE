package mrBook.cahpter11;

public class OuterClass {
	
	public OuterClass doit(){
		return new OuterClass(){
			public int getValue(){
				return 5;
				}
			};
		}
}
