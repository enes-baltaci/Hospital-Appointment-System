package Login_Scr;

import java.util.ArrayList;
import java.util.HashMap;

public class Doctors {
	
	private HashMap<String, ArrayList<Employee>> departments = new HashMap<String, ArrayList<Employee>>();
	
	public Employee allDrs[] = {new Employee("Dr.", "Leigh ", "Rose"), new Employee("Prof. Dr.", "Raquel", "Hopkins"), new Employee("Assoc. Prof. Dr.", "Glen", "Hampton"), new Employee("Dr.", "Nicole", "Rios"),
								new Employee("Prof. Dr.", "Christina", "Harmon"), new Employee("Assoc. Prof. Dr.", "Lance", "Kennedy"), new Employee("Dr.", "Forrest", "Ramos"), new Employee("Dr.", "Philip", "Baker"),
								new Employee("Dr.", "Kenneth", "Cannon"), new Employee("Assoc. Prof. Dr.", "Theodore", "Dixon"), new Employee("Dr.", "Preston", "Martinez"),
								new Employee("Assoc. Prof. Dr.", "Shawna", "Adams"), new Employee("Dr.", "Andrew", "Garcia"), new Employee("Assoc. Prof. Dr.", "Denise", "Patterson"),
								new Employee("Assoc. Prof. Dr.", "Florence", "Joseph"), new Employee("Assoc. Prof. Dr.", "Lynn", "Tran"), new Employee("Dr.", "Desiree", "Perkins"), new Employee("Prof. Dr.", "Laurie", "Warren"),
								new Employee("Dr.", "Rachael", "Morris"), new Employee("Dr.", "Marilyn", "Carpenter"), new Employee("Prof. Dr.", "Freddie", "Knight"), new Employee("Dr.", "Christie", "Barnett"),
								new Employee("Dr.", "Dixie", "Barber"), new Employee("Prof. Dr.", "Dave", "Green"), new Employee("Dr.", "Thomas", "Ross"), new Employee("Dr.", "Leona", "Rogers"),
								new Employee("Dr.", "Kristy ", "Lamb"), new Employee("Prof. Dr.", "Laurence", "Moore"), new Employee("Assoc. Prof. Dr.", "Mae", "Watson"),
								new Employee("Dr.", "Martin", "Hammond"), new Employee("Assoc. Prof. Dr.", "Dexter", "Casey"),  new Employee("Dr.", "Pedro", "Vega"), new Employee("Prof. Dr.", "Kayla", "Diaz"),
								new Employee("Dr.", "Scott", "Goodwin"), new Employee("Assoc. Prof. Dr.", "Clara", "Porter")};
	
	HashMap<String, ArrayList<Employee>> getDep()
	{
		int counter = 0, j = 0;
		Clinics clinicName = new Clinics();
		String deps[] = clinicName.clinic;
		
		for (int i = 0; i < deps.length; i++) {
			ArrayList<Employee> temp = new ArrayList<Employee>();
			counter = 0;
			while (counter < 3) {
				temp.add(allDrs[j]);
				counter++; j++;
				if (j == allDrs.length) j = 0;
			}
			departments.put(deps[i], temp);
		}
		return departments;
	}
}