/**@author Jon Koehmstedt
 * Feb 21, 2013
 * Class Projects/Employee.java
 */
package employeeCompany;

import java.util.Scanner;

public class Employee {

	Scanner keyboard = new Scanner(System.in);
	private String name;
	private double hoursWorked, hourlyRate, grossWages, projectedIncome;
	private double newFederal, yTDFederal, newState, yTDState, newLocal, yTDLocal;
	private double newDeductions, totalDeductions, netPay;
	private int numDependants;

		
	public void recordWorkedHours(){
		do {System.out.println("How many hours did you work this week: ");
		setHoursWorked(keyboard.nextDouble());
		} while ((hoursWorked<=0)||(hoursWorked>100));
	}
	

	public void calculateData(){
		calcGrossWages();
		calcProjectedIncome();
		calcLocalTax();
		calcFederalTax();
		calcStateTax();
		calcYTD();
		calcDeductionsNetPay();
	}	
		
	//calculate grossWages
	private void calcGrossWages(){
		if (hoursWorked>40)
			grossWages = (((hoursWorked-40)*(hourlyRate*1.5))+(40*hourlyRate));
		else
			grossWages = (hoursWorked*hourlyRate);
	}
	
	//calculate Projected Income
	private void calcProjectedIncome(){
		double gWagesTemp = 0;
		if (hoursWorked>40)
			gWagesTemp = (40*hourlyRate);
		else
			gWagesTemp = (hoursWorked*hourlyRate);
		projectedIncome = ((gWagesTemp-(15*numDependants))*52);
	}
	
	//calculate Local Tax
	private void calcLocalTax(){
		newLocal = (0.015*grossWages);
		if ((yTDLocal+newLocal)>517.5)
			newLocal=(517.5-yTDLocal);
	}
	
	//calculate Federal Tax
	private void calcFederalTax(){
		if (projectedIncome<20000)
			newFederal = (grossWages*0.1);
		else if (projectedIncome<40000)
			newFederal = (grossWages*0.2);
		else
			newFederal = (grossWages*0.3);
	}
	
	//calculate State Tax
	private void calcStateTax(){
		if (projectedIncome<30000)
			newState = (grossWages*0.05);
		else
			newState = (grossWages*0.1);
	}
	
	//Year-to-date calculations
	private void calcYTD(){
		yTDFederal=yTDFederal+newFederal;
		yTDState=yTDState+newState;
		yTDLocal=yTDLocal+newLocal;
	}
		
	//calculate new and total Deductions & Net Pay
	private void calcDeductionsNetPay(){
		newDeductions = (newLocal+newFederal+newState);
		totalDeductions = (yTDLocal+yTDFederal+yTDState);
		netPay = grossWages - newDeductions;
	}

	
	public void readInput(){
		System.out.println("Please enter employee name: ");
		setName(keyboard.nextLine());
		do {System.out.println("Please enter hourly wage: ");
		setHourlyRate(keyboard.nextDouble());
		} while (hourlyRate<=0);
		recordWorkedHours();
		getDependants();
		do {System.out.println("Please enter the Year-to-date Federal tax: ");
		yTDFederal = keyboard.nextDouble();
		} while (yTDFederal<=0);
		do {System.out.println("Please enter the Year-to-date State tax: ");
		yTDState = keyboard.nextDouble();
		} while (yTDState<=0);
		do {System.out.println("Please enter the Year-to-date Local tax: ");
		yTDLocal = keyboard.nextDouble();
		} while (yTDLocal<=0);
		keyboard.nextLine();
	}

	public void getDependants(){
		do {System.out.println("How many dependants do you claim: ");
		numDependants = keyboard.nextInt();
		} while ((numDependants<0)||(numDependants>15));
	}	

//GETTERS	
	public String getName(){
		return name;
	}
	public double getHoursWorked(){
		return hoursWorked;
	}
	public double getHourlyRate(){
		return hourlyRate;
	}
	public double getProjectedIncome(){
		return projectedIncome;
	}
	public int getNumDependants(){
		return numDependants;
	}
	public double getNewFederal(){
		return newFederal;
	}
	public double getYTDFederal(){
		return yTDFederal;
	}
	public double getNewState(){
		return newState;
	}
	public double getYTDState(){
		return yTDState;
	}
	public double getNewLocal(){
		return newLocal;
	}
	public double getNewDeductions(){
		return newDeductions;
	}
	public double getYTDLocal(){
		return yTDLocal;
	}
	public double getTotalDeductions(){
		return totalDeductions;
	}
	public double getNetPay(){
		return netPay;
	}
	public double getGrossWages(){
		return grossWages;
	}

//SETTERS
	public void setName(String newName){
		name = newName;
	}
	public void setHoursWorked(double newHoursWorked){
		hoursWorked=newHoursWorked;
	}
	public void setHourlyRate(double newHourlyRate){
		hourlyRate=newHourlyRate;
	}
	public void setProjectedIncome(double newprojectedIncome){
		projectedIncome=newprojectedIncome;
	}
	public void setNumDependants(int newNumDependants){
		numDependants=newNumDependants;
	}
	public void setNewFederal(double newNewFederal){
		newFederal=newNewFederal;
	}
	public void setYTDFederal(double newYTDFederal){
		yTDFederal=newYTDFederal;
	}
	public void setNewState(double newNewState){
		newState=newNewState;
	}
	public void setYTDState(double newYTDState){
		yTDState=newYTDState;
	}
	public void setNewLocal(double newNewLocal){
		newLocal=newNewLocal;
	}
	public void setNewDeductions(double newNewDeductions){
		newDeductions=newNewDeductions;
	}
	public void setYTDLocal(double newYTDLocal){
		yTDLocal=newYTDLocal;
	}
	public void setTotalDeductions(double newTotalDeductions){
		totalDeductions=newTotalDeductions;
	}
	public void setNetPay(double newNetPay){
		netPay=newNetPay;
	}
	public void setGrossWages(double newGrossWages){
		grossWages=newGrossWages;
	}	
	
	public void writeOutput(){
		String output;
		output= "\nEmployee: "+name+"\n" +
				"Hours Worekd: "+hoursWorked+"\n" +
				"Hourly Rate: "+toMoney(hourlyRate)+"\n" +
				"Gross Wages: "+toMoney(grossWages)+"\n" +
				"\tCurrent\tYr. To Date\n" +
				"Federal\t"+toMoney(newFederal)+"\t"+toMoney(yTDFederal)+"\n" +
				"State\t"+toMoney(newState)+"\t"+toMoney(yTDState)+"\n" +
				"Local\t"+toMoney(newLocal)+"\t"+toMoney(yTDLocal)+"\n" +
				"Deducations: "+toMoney(newDeductions)+"\t"+toMoney(totalDeductions)+"\n" +
				"Net Pay: "+toMoney(netPay)+"\n";
		System.out.println(""+output);
	}
	
	public static String toMoney(double dub){
		int tempInt = (int)(dub*100);
		String zero="";
		if ((tempInt%10==0)||(tempInt%100==0)){
				zero="0";
		}
		double tempDouble = ((double)tempInt)/100;
		String negative="";
		if (tempDouble<0)
			{negative="-";
			tempDouble = tempDouble*(-1);}
		String tempString = ""+negative+"$"+tempDouble+zero;
		return tempString;
	}
	
	

}
