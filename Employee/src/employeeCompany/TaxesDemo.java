package employeeCompany;
import java.util.Scanner;


public class TaxesDemo

{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		//Variables
		int numberOfEmployees, i; //count
		
		Company clerk = new Company( );
		Employee person = new Employee();// one Employee
		
		System.out.println("Enter number of Employees:");
		numberOfEmployees = scan.nextInt( );
		for(i = 0; i < numberOfEmployees; i++)
		{
			person.readInput();
			person.calculateData();
			person.writeOutput();
			clerk.collectDataForReport(person);
		}
		clerk.printDataReport();
		scan.close();
	}
}
