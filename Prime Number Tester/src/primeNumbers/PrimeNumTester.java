package primeNumbers;

import java.io.*;
import java.util.Scanner;
import java.lang.Math;
import java.io.FileNotFoundException;

public class PrimeNumTester {
	private static Scanner keyboard = new Scanner(System.in);
	private static File primeNumbersFile = new File("primeNumbers.txt");
	private boolean isPrime = true;
	private int testInputNum;
	
	public String findNextPrime(int inputNum) throws FileNotFoundException{
		int tempNum = inputNum;
		String output = "";
		Scanner readFile = new Scanner(primeNumbersFile);
		int nextPrime = readFile.nextInt();//pulls in "2" for nextPrime
		while (nextPrime <= Math.sqrt((double)(tempNum))){
			if (tempNum % nextPrime == 0){
				isPrime = false;				
				output = (output+nextPrime+", ");
				tempNum = tempNum/nextPrime;
			}
			else 
				nextPrime = readFile.nextInt();
		}
		if (isPrime==false){
			output = (output+"& "+inputNum+".");			
		}
		else {
			output = (output+"Only "+inputNum+".");
		}
	
		readFile.close();
		return output;
	}	

	public void setTestInputNum(int newTestInputNum){
		testInputNum = newTestInputNum;
	}

	public int getInputNum(){
		return testInputNum;
	}

	public boolean getIsPrime(){
		return isPrime;
	}
	
public static void main (String[] args) throws FileNotFoundException{
//	Scanner keyboard = new Scanner(System.in);
	
	PrimeNumTester primeTester = new PrimeNumTester();
	
	System.out.println("Enter a number to test if it's a prime number");
	primeTester.setTestInputNum(keyboard.nextInt());
	String allPrimes = primeTester.findNextPrime(primeTester.getInputNum());
	if (primeTester.isPrime == true){
		System.out.println("!! "+primeTester.getInputNum()+" is a prime number !!");
	}
	else {
		System.out.println("Sorry, "+primeTester.getInputNum()+" is not a prime number.");
	}
	System.out.println("The prime numbers that divide evenly into "+primeTester.getInputNum()+" are: ");
	System.out.println(allPrimes);
}


}//class