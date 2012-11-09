/* Program Name    :  Employee.java
 * Summary Info    :  Class for employee information
 * Programmer      :  Patrick Dorin
 * Date due        :  01/11/2012
 * Date completed  :  01/11/2012
 */

public class Employee {
	private String firstName;
	private String lastName;
	private float hourlyPay;
	private float hrsWorked;
	private int exemptions;
	private char status;

	//Default constructor
	public Employee(){
		firstName = "N/A";
		lastName = "N/A";
		hourlyPay = 0;
		hrsWorked = 0;
		exemptions = 0;
		status = '-';
	}

	//6 Parameter constructor
	public Employee(String fn, String ln, float hp, float hw, int e, char s){
		firstName = fn;
		lastName = ln;
		hourlyPay = hp;
		hrsWorked = hw;
		exemptions = e;
		status = s;
	}

	//Sets
	public void setFirstName(String fn){
		firstName = fn;	
		return;			
	}
	public void setLastName(String ln){
		lastName = ln;
		return;
	}
	public void setHourlyPay(float hp){
		hourlyPay = hp;
		return;
	}
	public void setHrsWorked(float hw){
		hrsWorked = hw;
		return;
	}
	public void setExemptions(int e){
		exemptions = e;
		return;
	}
	public void setStatus(char s){
		status = s;
		return;
	}

	//Gets
	public String getFirstName(){
		return firstName;		
	}
	public String getLastName(){
		return lastName;
	}
	public float getHourlyPay(){
		return hourlyPay;
	}
	public float getHrsWorked(){
		return hrsWorked;	
	}
	public int getExemptions(){
		return exemptions;
	}
	public char getStatus(){
		return status;
	}

	/*
	 *Summary Info :   Calculates the gross pay, giving 1.5 to employees working over 40 hours 
	 *Parameters   :   N/A
	 *Return type  :   float
	 */

	public float grossPay(){
		float overTime;
		float overTimePay;
		float pay;

		overTime = hrsWorked - 40;
		overTimePay = (hourlyPay * .5f) + hourlyPay;

		if(overTime > 0){
			pay = overTime * overTimePay + hourlyPay* 40;
		}
		else{
			pay = hourlyPay * hrsWorked;
		}

		return pay;
	}
	/*
	 *Summary Info :   Calculates the tax withholding amount
	 *Parameters   :   N/A
	 *Return type  :   float
	 */
	public float withholding(){
		float grossPay;
		float medical;
		float annualized;
		float taxPercent = 0;
		float taxWithholdings;
				
		grossPay = grossPay();
		
		if(status == 'F'){
			medical = grossPay * .05f;
			grossPay = grossPay - medical;
		}
		
		annualized = grossPay * 52;
		
		if(annualized > 45000){
			if(exemptions > 5){
				taxPercent = .20f;
			}
			else if(exemptions > 2 && exemptions < 5){
				taxPercent = .13f;
			}
			else{
				taxPercent = .07f;
			}
		}
		
		else if(annualized > 15000 && annualized < 45000){
			if(exemptions > 5){
				taxPercent = .15f;
			}
			else if(exemptions > 2 && exemptions < 5){
				taxPercent = .10f;
			}
			else{
				taxPercent = .05f;
			}

		}
		else{
			taxPercent = 0;
		}
	
		taxWithholdings = grossPay * taxPercent;
		return taxWithholdings;
		
	}
	/*
	 *Summary Info :   If employee is full time, they receive 1 hour of vacation for every 11 hour worked
	 *Parameters   :   N/A
	 *Return type  :   int
	 */

	public int vacationTime(){
		int v;
		if(status == 'F'){
			v = (int) (hrsWorked / 11);
			return v;
		}
		else{
			return 0;
		}
		
	}

	/*
	 *Summary Info :   Prints out all employee information
	 *Parameters   :   N/A
	 *Return type  :   void
	 */

	public void employeeInfo(){
		float grossPay = grossPay();
		float withholding = withholding();
		int vacationTime = vacationTime();
		System.out.printf("Name: \t\t%s %s\nHourly pay: \t$%.2f \nHours worked: \t%.2f \nExemptions: \t%d \nStatus: " +
						"\t%c \nGross Pay: \t$%.2f  \nWithholding: \t$%.2f \nVacation Time: \t%d hours\n\n", firstName, lastName, hourlyPay, hrsWorked, 
						exemptions,	status, grossPay, withholding, vacationTime);
		return;
	}
}	

