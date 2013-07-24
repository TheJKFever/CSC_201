

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListDemo {
	public static void main(String[] args)
	{
		ArrayList<Fraction> fracArray = new ArrayList<Fraction>();
		ArrayList<Bottle> bottleArray = new ArrayList<Bottle>();
		Bottle b = new Bottle(3);
		fracArray.add(new Fraction(1,2));
		fracArray.add(new Fraction(1,3));
		fracArray.add(new Fraction(1,5));
		fracArray.add(new Fraction(1,6));
		bottleArray.add(new Bottle(2));
		bottleArray.add(b);
		String fractions = "";
		for(Fraction fraction: fracArray)
		{
			fractions = fractions + fraction.toString() + "\n";
		}
		System.out.println("first array\n" + fractions);
		fracArray.clear();
		fracArray = practice(bottleArray);
		fractions = "";
		for(Fraction fraction: fracArray)
		{
			fractions = fractions + fraction.toString() + "\n";
		}
		System.out.println("second array\n" + fractions);
		readString();
	}

	private static ArrayList<Fraction> practice(ArrayList<Bottle> bottleArray)
	{
		ArrayList<Fraction> fracArray = new ArrayList<Fraction>();
		int num, den;
		Fraction f;
		for(Bottle bottle: bottleArray)
		{
			num = bottle.getAmount();
			den = num + 2;
			f = new Fraction(num, den);
			fracArray.add(f);
		}
		return fracArray;
	}
	private static void readString()
	{
		String example ="1  5 14 9";	
		Scanner scanLine = new Scanner(example);
		while(scanLine.hasNextInt())
		{
			int choice = scanLine.nextInt();
			System.out.println("choice is " + choice);
		}
		scanLine.close();
	}
}