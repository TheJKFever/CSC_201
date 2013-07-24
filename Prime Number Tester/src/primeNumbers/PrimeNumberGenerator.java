package primeNumbers;

import java.util.ArrayList;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class PrimeNumberGenerator {

	private static ArrayList<Integer> primeNumberArray;
	private static File primeNumbersFile = new File("primeNumbers.txt");
	
	private static boolean isPrime(int testNum){
		for (int i=0; i<primeNumberArray.size(); i++){
			if (testNum % primeNumberArray.get(i) == 0){
				return false;
			}
		}
		return true;
	}

public static void main (String[] args) throws FileNotFoundException{
	int numTester = 5;
	primeNumberArray = new ArrayList<Integer>(0);
	primeNumberArray.add(2);
	primeNumberArray.add(3);
	
	do { if (isPrime(numTester))
			primeNumberArray.add(numTester);
		numTester +=2 ;
	} while (numTester<3164);

	PrintWriter writeToFile = new PrintWriter(primeNumbersFile);	
	writeToFile.print("1 ");
	for (int i=0; i<primeNumberArray.size(); i++){
		writeToFile.print(""+primeNumberArray.get(i)+" ");
	}	
	writeToFile.close();
	
	
}//main

}//class