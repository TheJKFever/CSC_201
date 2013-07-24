import java.util.Scanner;

public class BottleFraction extends Bottle {

public static Scanner keyboard = new Scanner(System.in);
	
	private Fraction frac;
	
	//Constructors
	public BottleFraction(){
		super();
		frac = new Fraction();
	}
	
	public BottleFraction(int bottleIn, int numeratorIn, int denominatorIn){
		super(bottleIn);
		frac = new Fraction (numeratorIn, denominatorIn);
	}	
	
	public BottleFraction add(BottleFraction BottleFractionToAdd){
		BottleFraction answer = new BottleFraction();
		answer.frac = this.frac.add(BottleFractionToAdd.frac);
		answer.setAmount(this.add(BottleFractionToAdd.getAmount()).getAmount()); 
		return answer;
	}
	
	public BottleFraction subtract(BottleFraction BottleFractionToSubtract){
		BottleFraction answer = new BottleFraction();
		answer.frac = frac.subtract(BottleFractionToSubtract.frac);
		answer.setAmount(this.subtract(BottleFractionToSubtract.getAmount()).getAmount()); 		
		return answer;
	}
		
	public BottleFraction multiply(BottleFraction BottleFractionToMultiplyBy){
		BottleFraction answer = new BottleFraction();
		answer.frac = frac.multiply(BottleFractionToMultiplyBy.frac);
		answer.setAmount(this.multiply(BottleFractionToMultiplyBy.getAmount()).getAmount()); 		
		return answer;
	}
		
	public BottleFraction divide(BottleFraction BottleFractionToDivideBy){
		BottleFraction answer = new BottleFraction();
		answer.frac = frac.divide(BottleFractionToDivideBy.frac);
		answer.setAmount(this.divide(BottleFractionToDivideBy.getAmount()).getAmount());
		return answer;
	}
		
	public Fraction getFrac(){
		return frac;
	}
	
	public void read(){
		frac.read();
		System.out.print("Please enter the Bottle amount: ");
		setAmount(keyboard.nextInt());
	}
	
	public String toString(){
		return ""+getAmount()+" "+frac.toString();
	}
	
	//tests if two Bottle Fractions equal each other on all instance variables
	public boolean equals(BottleFraction otherBottleFraction){
		boolean equals = true;
		if (!frac.equals(otherBottleFraction.frac))
			equals = false;
		if (getAmount()!=otherBottleFraction.getAmount())
			equals = false;
		return equals;
	}

	//tests if this BottleFraction is greater than parameter Bottle Fraction
	public boolean greaterThan(Fraction testFrac){
		boolean greaterThan;
		if (Fraction.getValue(frac)>Fraction.getValue(testFrac))
			greaterThan = true;
		else
			greaterThan = false;
		return greaterThan;
	}
	
	public boolean greaterThan(BottleFraction testBottle){
		boolean greaterThan;
		if (getAmount()>testBottle.getAmount())
			greaterThan = true;
		else
			greaterThan = false;
		return greaterThan;
	}	
	
}//BottleFraction Class