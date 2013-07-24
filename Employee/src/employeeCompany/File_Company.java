/**@author Jon Koehmstedt
 * Feb 21, 2013
 * Class Projects/Employee.java
 */

package employeeCompany;
import java.io.*;

public class File_Company extends Company{

	
	public void printDataReportFile(PrintWriter textStream){
		String output;
		output= ""+getName()+"\n" +
				"Weekly summery\n" +
				"\tCurrent\tYr. To Date\n" +
				"Federal\t"+toMoney(getNewFederal())+"\t"+toMoney(getYTDFederal())+"\n" +
				"State\t"+toMoney(getNewState())+"\t"+toMoney(getYTDState())+"\n" +
				"Local\t"+toMoney(getNewLocal())+"\t"+toMoney(getYTDLocal())+"\n" +
				"Deducations   "+toMoney(getNewDeductions())+"\t"+toMoney(getTotalDeductions())+"\n" +
				"Gross Wages: "+toMoney(getGrossWages())+"\n" +
				"Net Pay: "+toMoney(getNetPay())+"\n\n";
		textStream.println(output);
	}
		
}
