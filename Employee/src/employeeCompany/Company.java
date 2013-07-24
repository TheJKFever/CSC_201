/**@author Jon Koehmstedt
 * Feb 21, 2013
 * Class Projects/Employee.java
 */

package employeeCompany;
import java.util.Scanner;

public class Company {

	Scanner keyboard = new Scanner(System.in);
	private String name;
	private double newFederal, yTDFederal, newState, yTDState, newLocal, yTDLocal;
	private double newDeductions, totalDeductions, netPay, grossWages;
	
	
	public Company(){
		name = "Phillips, Inc";
		yTDState = 0;
		yTDLocal = 0;
		yTDFederal = 0;
		totalDeductions = 0;
		newState = 0;
		newDeductions = 0;
		newLocal = 0;
		newFederal = 0;
		netPay = 0;
		grossWages = 0;
		}
	
	public void collectDataForReport(Employee emp){
			yTDState = yTDState + emp.getYTDState();
			yTDLocal = yTDLocal + emp.getYTDLocal();
			yTDFederal = yTDFederal + emp.getYTDFederal();
			totalDeductions = totalDeductions + emp.getTotalDeductions();
			newState = newState + emp.getNewState();
			newDeductions = newDeductions + emp.getNewDeductions();
			newLocal = newLocal + emp.getNewLocal();
			newFederal = newFederal + emp.getNewFederal();
			netPay = netPay + emp.getNetPay();
			grossWages = grossWages + emp.getGrossWages();
		}

	public void printDataReport(){
		String output;
		output= ""+name+"\n" +
				"Weekly summery\n" +
				"\tCurrent\tYr. To Date\n" +
				"Federal\t"+toMoney(newFederal)+"\t"+toMoney(yTDFederal)+"\n" +
				"State\t"+toMoney(newState)+"\t"+toMoney(yTDState)+"\n" +
				"Local\t"+toMoney(newLocal)+"\t"+toMoney(yTDLocal)+"\n" +
				"Deducations   "+toMoney(newDeductions)+"\t"+toMoney(totalDeductions)+"\n" +
				"Gross Wages: "+toMoney(grossWages)+"\n" +
				"Net Pay: "+toMoney(netPay)+"\n\n";
		System.out.println(""+output);
	}
	
	
	public String setName(String S){
		return name = S;
	}
	
	public String getName(){
		return name;
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
	
	public double getYTDLocal(){
		return yTDLocal;
		}
	
	public double getNewDeductions(){
		return newDeductions;
		}
	
	public double getTotalDeductions(){
		return totalDeductions;
		}
	
	public double getGrossWages(){
		return grossWages;
		}
	
	public double getNetPay(){
		return netPay;
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
