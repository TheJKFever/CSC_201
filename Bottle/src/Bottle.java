/**@author Jon Koehmstedt
 * Jan 22, 2013
 * Class Projects/Bottle.java
 */

import java.util.Scanner;

public class Bottle {
	
	public static Scanner keyboard = new Scanner(System.in);
	private int amount;
	
	//Constructors
	public Bottle(){
		amount=0;
	}
	
	public Bottle(int initialAmount){
		amount=initialAmount;
	}
	
	//Set method
	public void read(){
		amount = keyboard.nextInt();
	}
	
	public void setAmount(int x){
		amount=x;
	}
	
	//Get method
	public int getAmount(){
		return amount;
	}
	
	//Add Methods
	public Bottle add(Bottle addThisBottle){
		Bottle answerBottle = new Bottle();
		answerBottle.amount = amount + addThisBottle.amount;
		return answerBottle;
	}
	
	public Bottle add(int addThis){
		Bottle answerBottle = new Bottle();
		answerBottle.amount = amount + addThis;
		return answerBottle;
	}
	
	//Subtract Methods
	public Bottle subtract(Bottle subtractThisBottle){
		Bottle answerBottle = new Bottle();
		answerBottle.amount = amount - subtractThisBottle.amount;
		if (amount<0)
		{	System.out.println("Error: amount less than zero.");
			System.exit(0);
			return answerBottle;
		}
		else
			return answerBottle;
	}
	
	public Bottle subtract(int subtractThis){
		Bottle answerBottle = new Bottle();
		answerBottle.amount = amount - subtractThis;
		if (answerBottle.amount<0)
		{	System.out.println("Error: amount less than zero.");
			System.exit(0);
			return answerBottle;
		}
		else
			return answerBottle;
	}
	
	//Multiplication Method
	public Bottle multiply(Bottle multiplyByThisBottle){
		Bottle answerBottle = new Bottle();
		answerBottle.amount = amount*multiplyByThisBottle.amount;
		return answerBottle;
	}
	
	public Bottle multiply(int multiplyByThis){
		Bottle answerBottle = new Bottle();
		answerBottle.amount = amount*multiplyByThis;
		return answerBottle;
	}
	
	//Divide Method
	public Bottle divide(Bottle divideByThisBottle){
		Bottle answerBottle = new Bottle();
		answerBottle.amount = (int)(Math.round(amount/divideByThisBottle.amount));
		return answerBottle;
	}
	
	public Bottle divide(int divideByThis){
		Bottle answerBottle = new Bottle();
		answerBottle.amount = (int)(Math.round(amount/divideByThis));
		return answerBottle;
	}
	
	public String toString(){
		String amountString = ""+amount;
		return amountString;
	}
	
	
	public static void main(String[] args) {
		// 
		Scanner scan = new Scanner(System.in);
		int x;
		
		Bottle bottle1 = new Bottle();
		Bottle bottle2 = new Bottle();
		Bottle bottle3 = new Bottle();
		Bottle bottle4 = new Bottle();
		Bottle bottleAve = new Bottle();
		
		System.out.println("please enter a number for bottle1:");
		bottle1.read();
		System.out.println("bottle1 is this value " + bottle1);
		System.out.println("please enter a number for bottle2:");
		bottle2.read();
		System.out.println("please enter a number for bottle3:");
		bottle3.read();
		System.out.println("please enter a number for bottle4:");
		bottle4.read();
		
		bottleAve = bottleAve.add(bottle1);
		bottleAve = bottleAve.add(bottle2);
		bottleAve = bottleAve.add(bottle3);
		bottleAve = bottleAve.add(bottle4);
		bottleAve = bottleAve.divide(4);
		System.out.println("the 4 bottle average is about: " + bottleAve);
		
		if (bottle1.equals(bottle3))
			{
			System.out.println("bottle1 and bottle3 are equal");
			}
		else
			{
			System.out.println("bottle1 and bottle3 are not equal");
			}
		
		System.out.println("Enter an integer to add to bottle 1");
		x = scan.nextInt();
		bottle2=bottle1.add(x);
		System.out.println("adding your number " + x +
		" to  bottle1 gives " + bottle2);
		
		bottle2 = bottle1.add(bottle3);
		System.out.print("adding the number " + bottle3 + " to ");
		System.out.println("bottle1  gives " + bottle2);
		scan.close();

	}

}