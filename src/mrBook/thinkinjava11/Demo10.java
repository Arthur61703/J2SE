package mrBook.thinkinjava11;

import java.util.*;

public class Demo10 {

	public static void main(String[] args) {
		Set<Person> set = new TreeSet<Person>();
		Person person1 = new Person("jinrui",35);
		Person person2 = new Person("sunjiajia",26);
		Person person3 = new Person("znn",18);
		Person person4 = new Person("znn2",18);
		
		set.add(person1);
		set.add(person2);
		set.add(person3);
		set.add(person4);
		
		Iterator<Person> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}

	}

}
