package museum;
//import java.io.PrintWriter;
import java.util.Scanner;

public class CreateExhibition{

	public static void main(String[] args){
		Scanner keyboard = new Scanner(System.in);
		System.out.println("This program creates art exhibits.");
		System.out.println("Would you like to create a new exhibition?");
		System.out.println("Enter yes or no.");
		while(keyboard.next().toLowerCase().equals("yes")) {
			Exhibition exhibition = new Exhibition();
			String theExhibitionList = exhibition.paintingsChosen();
			System.out.println(theExhibitionList);
			System.out.println("Would you like to create a new exhibition?");
		}
		keyboard.close();
    }//main
}//class
