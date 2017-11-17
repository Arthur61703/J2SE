package mrBook.thinkinjava11;

public class Person implements Comparable<Object> {
	/**存入TreeSet集合的元素自身必须具备可比性，通过实现Comparable借口完成**/
	private String name;
	private int age;
	
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int compareTo(Object o) {
		
		Person person = (Person) o;
		if(this.age>person.age){//优先按年龄比较
			return 1;
		}else if(this.age<person.age){
			return -1;
			
		}else{//其次按姓名比较
			
			if(this.name.compareTo(person.name)==0){
				return 0;
			}else if(this.name.compareTo(person.name)>0){
				return 1;
			}else{
				
				return -1;
			}
		}
	}

}
