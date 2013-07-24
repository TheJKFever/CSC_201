import java.util.Scanner;
import java.io.*;
public class TextFileIO
{
	public static void main(String[] args)
   	{
	String fileName = "textFile.txt";
	String line = null;
	int count;
	Scanner scan = new  Scanner(System.in);
	PrintWriter textStream =TextFileIO.createTextWrite(fileName);
	System.out.println("Enter 4 lines of text:");
	for (count = 1; count <= 4; count++)
	{
		line = scan.nextLine();
		textStream.println(count + " " + line);
     	}
  	textStream.close( ); // did not require error handling
     	System.out.println("Those lines were written to " + fileName);
     	System.out.println();
     	System.out.print("Now we will read them from " + fileName + " using the ");
     	System.out.println("Scanner class." );
     	Scanner scanFile = TextFileIO.createTextRead(fileName);// scan a file
     	for (count = 1; count <= 4; count++)
	{
     		count = scanFile.nextInt();
     		line = scanFile.nextLine();
     		System.out.println(count + line);
	}
     	scan.close();

     }

public static PrintWriter  createTextWrite(String S)
{
	PrintWriter TStream = null;
	try
	{
		TStream = new PrintWriter(new FileOutputStream(S));
	}
	catch(FileNotFoundException e)
	{
		System.out.println("Error opening the file in createTextWrite");
	  	System.exit(0);
	}
	return TStream;
 	}


  	public static Scanner  createTextRead(String S)
	{
		Scanner textFile = null;
  		try
       	{
               textFile = new Scanner(new File(S));
       	}
       	catch(FileNotFoundException e)
       	{
              System.out.println("File not found");
       	  System.out.println("or could not be opened.");
       	}
       	return textFile;
   	}



}