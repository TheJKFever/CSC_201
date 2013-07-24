/**@author Jon Koehmstedt
 * Mar 5, 2013
 * Class Projects/PowerOfZ.java
 */

import java.util.Scanner;

public class RootClass {

	Scanner keyboard = new Scanner(System.in);
	private int powerAnswer, power;
	private double testAnswer, testVariable=1, finalSolution;
	
	public RootClass(){
		powerAnswer = 1;
		power = 1;
	}
	
	public void setRootValues(){
		do {System.out.println("Please enter the output result of power: ");
		powerAnswer = keyboard.nextInt();
		if ((powerAnswer<=1)&&(powerAnswer>=-1))
			System.out.println("Please enter only an output result either greater than 1 or less than -1");
		} while ((powerAnswer<=1)&&(powerAnswer>=-1));
		boolean valid=true;
		do {System.out.println("Please enter the power that our variable will be multiplied by: ");
		power = keyboard.nextInt();
		if ((powerAnswer<0)&&(power%2==0))
			{valid=false;
			System.out.println("Since the answer is negative, please input only an odd number for the power.");
			}
		else
			valid=true;
		} while (valid==false);
	}
	
	public void findZ(){
		do {
			testVariable=testVariable+0.0000001;
			testAnswer=testVariable;
			if (power>1){
				for (int i=1;i<power;i++){
					testAnswer=testAnswer*testVariable;
				}
			}
		} while (testAnswer<Math.abs(powerAnswer));
		finalSolution=testVariable;	
	}
	
	public void setPowerAnswer(int newValue){
		powerAnswer=newValue;
	}
	
	public void setPower(int newValue){
		power=newValue;
	}
	
	public String getFinalSolution(){
		String preface;
		if (powerAnswer<0)
			preface=" -";
		else
			preface=" +/-";
		return (""+preface+finalSolution);
	}
	
	public void printAnswer(){
		String preface;
		if (powerAnswer<0)
			preface=" -";
		else
			preface=" +/-";
		System.out.println(""+preface+finalSolution);
	}
	
	
	public static void main(String[] args) {
		// 
		RootClass rootDemo = new RootClass();
		rootDemo.setRootValues();
		rootDemo.findZ();
		rootDemo.printAnswer();
		
	}

}
