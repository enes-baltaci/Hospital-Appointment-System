package Login_Scr;

public class Employee extends Person {

	public String title;
	
	public Employee(String title, String name, String surname) {
		super(name, surname);
		this.title = title;
	}
}