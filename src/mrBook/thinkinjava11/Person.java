package mrBook.thinkinjava11;

public class Person implements Comparable<Object> {
	/**����TreeSet���ϵ�Ԫ���������߱��ɱ��ԣ�ͨ��ʵ��Comparable������**/
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
		if(this.age>person.age){//���Ȱ�����Ƚ�
			return 1;
		}else if(this.age<person.age){
			return -1;
			
		}else{//��ΰ������Ƚ�
			
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
