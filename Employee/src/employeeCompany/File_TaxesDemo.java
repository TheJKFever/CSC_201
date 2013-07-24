package employeeCompany;
import java.util.Scanner;
import java.io.*;

public class File_TaxesDemo

{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		Scanner scanFile = TextFileIO.createTextRead("in.txt");
		PrintWriter outStream = TextFileIO.createTextWrite("out.txt");
		
		//Variables
		int numberOfEmployees, i; //count
		
		File_Company company = new File_Company();
		File_Employee employee = new File_Employee();
		
		System.out.println("Enter number of Employees:");
		numberOfEmployees = scanFile.nextInt();
		scanFile.nextLine();
		for(i = 0; i < numberOfEmployees; i++)
		{
			employee.readInputFile(scanFile);
			employee.calculateData();
			employee.writeOutputFile(outStream);
			employee.writeOutput();
			company.collectDataForReport(employee);
		}
		System.out.println();
		company.printDataReport();
		company.printDataReportFile(outStream);
		outStream.close();
		scanFile.close();
		scan.close();
	}
}
