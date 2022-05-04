package P3;

import java.util.ArrayList;
import java.util.List;

public class Person {
	private List<Person> Frind;
	private final String Name;
	
	public Person(String name) {
		this.Name=name;
		this.Frind=new ArrayList<>();
	}
	
	public String name() {
		return Name;
	}
	public List<Person> frind() {
		return Frind;
	}
	
	public int AddFrind(Person name) {
		if(Frind.contains(name)) {
			return Frind.indexOf(name);
		}
		else {
		Frind.add(name);
		return Frind.indexOf(name);//返回加入的新朋友的下标
	}}
}
