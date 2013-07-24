/**@author Jon Koehmstedt
 * Feb 21, 2013
 * Class Projects/Employee.java
 */
package employeeCompany;
import java.util.Scanner;
import java.io.*;

public class File_Employee extends Employee {

	public void readInputFile(Scanner read){
		setName(read.nextLine());
		setHourlyRate(read.nextDouble());
		if (getHourlyRate()<=0){
			System.out.println("Please enter an hourly rate greater than 0");
			System.exit(0);
		}
		setHoursWorked(read.nextDouble());
		if (getHoursWorked()<=0){
			System.out.println("Please enter work hours greater than 0 and less than 100");
			System.exit(0);
		}
		setNumDependants(read.nextInt());
		if ((getNumDependants()<0)||(getNumDependants()>15)){
			System.out.println("Please enter a number of dependants between 0 and 15");
			System.exit(0);
		}
		setYTDFederal(read.nextDouble());
		if(getYTDFederal()<0){
			System.out.println("Please enter a YTD Federal Tax of 0 or greater");
			System.exit(0);
		}
		setYTDState(read.nextDouble());
		if(getYTDState()<0){
			System.out.println("Please enter a YTD State Tax of 0 or greater");
			System.exit(0);
		}
		setYTDLocal(read.nextDouble());	
		if(getYTDLocal()<0){
			System.out.println("Please enter a YTD Local Tax of 0 or greater");
			System.exit(0);
		}	
	}


	public void writeOutputFile(PrintWriter textStream){
		String output;
		output= "\nEmployee: "+getName()+"\n" +
				"Hours Worekd: "+getHoursWorked()+"\n" +
				"Hourly Rate: "+toMoney(getHourlyRate())+"\n" +
				"Gross Wages: "+toMoney(getGrossWages())+"\n" +
				"\tCurrent\tYr. To Date\n" +
				"Federal\t"+toMoney(getNewFederal())+"\t"+toMoney(getYTDFederal())+"\n" +
				"State\t"+toMoney(getNewState())+"\t"+toMoney(getYTDState())+"\n" +
				"Local\t"+toMoney(getNewLocal())+"\t"+toMoney(getYTDLocal())+"\n" +
				"Deducations: "+toMoney(getNewDeductions())+"\t"+toMoney(getTotalDeductions())+"\n" +
				"Net Pay: "+toMoney(getNetPay())+"\n";
		textStream.println(output);
	}	

}
