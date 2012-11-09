/* Program Name    :  EmployeeRunner.java
 * Summary Info    :  Used with Employee.java, creates employees and calls for the employee's information to be printed
 * Programmer      :  Patrick Dorin
 * Date due        :  01/11/2012
 * Date completed  :  01/11/2012
 */

public class EmployeeRunner {
	public static void main(String[] args){
		Employee emp1 = new Employee("Curtis", "Brubaker", 20.5f, 35, 3, 'F');
		Employee emp2 = new Employee("Jeffrey", "Nowak", 14.00f, 40, 7, 'F');
		Employee emp3 = new Employee("Daniel","Michels", 8.25f, 45, 4, 'F');
		Employee emp4 = new Employee("Jose", "Osteen", 25.75f, 20, 1, 'P');
		Employee emp5 = new Employee("Eunice", "Rosado", 9.00f, 30, 2, 'P');
		
		
		emp1.employeeInfo();
		emp2.employeeInfo();
		emp3.employeeInfo();
		emp4.employeeInfo();
		emp5.employeeInfo();
	}
}
