/**@author Jon Koehmstedt
 * Jan 24, 2013
 * Class Projects/Fraction.java
 */

/* This is a class that will take a numerator and a denominator
 * and make a fraction out of it. It will add, subtract, multiply, divide, and compare fractions.
 */

import java.util.Scanner;

public class Fraction {
	
	public static Scanner keyboard = new Scanner(System.in);
	
	private int numerator, denominator;
	
	//Constructors
	public Fraction(){
	numerator = 0;
	denominator = 1;
	}
	
	public Fraction(int numeratorIn, int denominatorIn){
	set(numeratorIn, denominatorIn);
	}
	
	public Fraction add(Fraction fractionToAdd){
		Fraction newFraction = new Fraction();
		newFraction.numerator = (fractionToAdd.denominator*numerator)+(denominator*fractionToAdd.numerator);
		newFraction.denominator = (denominator*fractionToAdd.denominator);
		newFraction.set(newFraction.numerator, newFraction.denominator);
		return newFraction;
	}

	public Fraction add(int intToAdd){
		Fraction newFraction = new Fraction();
		newFraction.numerator = numerator+(numerator*intToAdd);
		newFraction.set(newFraction.numerator, denominator);
		return newFraction;
	}
	
	public Fraction subtract(Fraction fractionToSubtract){
		Fraction newFraction = new Fraction();
		newFraction.numerator = (fractionToSubtract.denominator*numerator)-(denominator*fractionToSubtract.numerator);
		newFraction.denominator = (denominator*fractionToSubtract.denominator);
		newFraction.set(newFraction.numerator, newFraction.denominator);
		return newFraction;
	}
	
	public Fraction subtract(int intToSubtract){
		Fraction newFraction = new Fraction();
		newFraction.numerator = numerator-(numerator*intToSubtract);
		newFraction.set(newFraction.numerator, denominator);
		return newFraction;
	}
	
	public Fraction multiply(Fraction fractionToMultiplyBy){
		Fraction newFraction = new Fraction();
		newFraction.numerator = numerator*fractionToMultiplyBy.numerator;
		newFraction.denominator = denominator*fractionToMultiplyBy.denominator;
		newFraction.set(newFraction.numerator, newFraction.denominator);
		return newFraction;
	}
	
	public Fraction multiply(int intToMultiplyBy){
		Fraction newFraction = new Fraction();
		newFraction.numerator = numerator*intToMultiplyBy;
		newFraction.set(newFraction.numerator, denominator);
		return newFraction;
	}
	
	public Fraction divide(Fraction fractionToDivideBy){
		Fraction newFraction = new Fraction();
		newFraction.numerator = numerator*fractionToDivideBy.denominator;
		newFraction.denominator = denominator*fractionToDivideBy.numerator;
		newFraction.set(newFraction.numerator, newFraction.denominator);
		return newFraction;
	}
	
	public Fraction divide(int intToDivideBy){
		Fraction newFraction = new Fraction();
		newFraction.denominator = denominator*intToDivideBy;
		newFraction.set(numerator, newFraction.denominator);
		return newFraction;
	}
	
	public Fraction reciprocal(){
		Fraction newFraction = new Fraction();
		newFraction.numerator = denominator;
		newFraction.denominator = numerator;
		return newFraction;
	}
	
	//reads in the values for the fraction
	public void read(){
		//takes in numerator and makes sure it's an int
		String numeratorS = "a";
		while (isInt(numeratorS)==false){
			System.out.print("Please enter a numerator for this fraction: ");
			numeratorS = keyboard.next();
			if (isInt(numeratorS)==false)
				System.out.println("this is not an integer");
			else
				numerator = Integer.parseInt(numeratorS);
		}
		//takes in denominator and makes sure it's an int
		String denominatorS = "a";
		while (isInt(denominatorS)==false){
			System.out.print("Please enter a denominator for this fraction: ");
			denominatorS = keyboard.next();
			if (isInt(denominatorS)==false)
				System.out.println("this is not an integer");
			else
				denominator = Integer.parseInt(denominatorS);
		}
		set(numerator, denominator);
	}
	
	public void set(int numeratorIn,int denominatorIn){
		if (denominatorIn==0){
			System.out.println("Error: denominator cannot be 0");
			System.exit(0);}
		if (getSign(numeratorIn, denominatorIn)=='+')
			numerator = Math.abs(numeratorIn);
		else
			numerator = (-1)*Math.abs(numeratorIn);
		denominator = Math.abs(denominatorIn);
		int gCD = greatestCommonDivisor(numeratorIn, denominatorIn);
		numerator = numerator/gCD;
		denominator = denominator/gCD;
	}

	public boolean equals(Fraction otherFraction){
		boolean equals = true;
		if (numerator!=otherFraction.numerator)
			equals = false;
		if (denominator!=otherFraction.denominator)
			equals = false;
		return equals;
	}
	
	public boolean greaterThan(Fraction otherFraction){
		boolean equals;
		if (getValue(this)>getValue(otherFraction))
			equals = true;
		else
			equals = false;
		return equals;
	}
	
	public String toString(){
		String output;
		if (denominator==1)
			output = ""+numerator;
		else
			output = ""+numerator+"/"+denominator;
		return output;
	}
	
	//PRIVATE Methods
	//finds the greatest common divisor
	private int greatestCommonDivisor(int a, int b)
	// post: Function Value == Greatest common divisor of a and b
	{	a = Math.abs(a);
		b = Math.abs(b);
		int temp = a % b;
		while (temp > 0)
		{	a = b;
			b = temp;
			temp = a % b;
		}// ASERT: b == Greatest common divisor of a <entry> and b <entry>
		return b;
	}
	
	public static double getValue(Fraction a){
		double trueValue = (((double)a.numerator)/((double)(a.denominator)));
		return trueValue;
	}
	
	public int getNumerator(){
		return numerator;
	}
	
	public int getDenominator(){
		return denominator;
	}
	
	private char getSign(int numeratorIn, int denominatorIn){
		char sign='+';
		if (((numeratorIn<0)&&(denominatorIn<0))||((numeratorIn>=0)&&(denominatorIn>=0)))
			sign = '+';
		else if (((numeratorIn>=0)&&(denominatorIn<0))||((numeratorIn<0)&&(denominatorIn>=0)))
			sign = '-';
		return sign;
	}
	
	private boolean isInt(String str)  
	{  
	  try  
	  { Integer.parseInt(str);}  
	  catch(NumberFormatException nfe)  
	  {return false;}
	  return true;  
	}
	
/*	public void add(int numeratorI, int denominatorI){
		numeratorI = (fractionToAdd.denominator*numerator)+(denominator*fractionToAdd.numerator);
		denominatorI = (denominator*fractionToAdd.denominator);
		set (numerator, denominator);
		return this;
*/
	
	//main Class Tester
	public static void main(String[] args) {
		// 
		
		boolean tryagain = false;
		
		Fraction test1 = new Fraction(1,2);
		System.out.println("Fraction test1 is: "+test1);		
		Fraction test2 = new Fraction(-1,3);
		System.out.println("Fraction test2 is: "+test2);
		System.out.println();
			
		do {
		System.out.println("Please enter a fraction to test: ");
		Fraction userF = new Fraction();
		userF.read();
		System.out.println();
		System.out.println("Your fraction is: "+userF);
		System.out.println("ADDITION:");
		System.out.println("If you add Fraction test1 you get: "+userF.add(test1));
		System.out.println("If you add Fraction test2 you get: "+userF.add(test2));
		System.out.println("SUBTRACTION");
		System.out.println("If you subtract Fraction test1 you get: "+userF.subtract(test1));
		System.out.println("If you subtract Fraction test2 you get: "+userF.subtract(test2));
		System.out.println("MULTIPLICATION");
		System.out.println("If you multiply by Fraction test1 you get: "+userF.multiply(test1));
		System.out.println("If you multiply by Fraction test2 you get: "+userF.multiply(test2));
		System.out.println("DIVISION");
		System.out.println("If you divide by Fraction test1 you get: "+userF.divide(test1));
		System.out.println("If you divide by Fraction test2 you get: "+userF.divide(test2));		
		System.out.println("Would you like to try again?");
		if (keyboard.next().toLowerCase().equals("yes"));
			tryagain = true;
		} while (tryagain);
		
	}


}