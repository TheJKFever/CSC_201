package museum;
import java.util.Scanner;

public class Painting {	
	String paintingPainter, paintingName, paintingGenre, paintingMedium, paintingCountry;
	int paintingYear;
	double paintingSize;	
	
//read in all data for one painting from a file	
	public void readPainting(Scanner read){
		read.nextLine().trim();
		paintingPainter = read.nextLine().trim();
		paintingName = read.nextLine().trim();
		paintingYear = Integer.parseInt(read.nextLine().trim());
		paintingSize = Double.parseDouble(read.nextLine().trim());
		paintingGenre = read.nextLine().trim();
		paintingMedium = read.nextLine().trim();
		paintingCountry = read.nextLine().trim();
	}

//GET Methods
	public String getPaintingPainter(){
		return paintingPainter;
	}
	
	public String getPaintingName(){
		return paintingName;
	}

	public int getPaintingYear(){
		return paintingYear;
	}

	public double getPaintingSize(){
		return paintingSize;
	}

	public String getPaintingGenre(){
		return paintingGenre;
	}

	public String getPaintingMedium(){
		return paintingMedium;
	}

	public String getPaintingCountry(){
		return paintingCountry;
	}

//SET Methods	
	public void setPaintingPainter(String newPaintingPainter){
		paintingPainter = newPaintingPainter;
	}

	public void setPaintingName(String newPaintingName){
		paintingName = newPaintingName;
	}

	public void setPaintingYear(int newPaintingYear){
		paintingYear = newPaintingYear;
	}

	public void setPaintingSize(double newPaintingSize){
		paintingSize = newPaintingSize;
	}

	public void setPaintingGenre(String newPaintingGenre){
		paintingGenre = newPaintingGenre;
	}

	public void setPaintingMedium(String newPaintingMedium){
		paintingMedium = newPaintingMedium;
	}

	public void setPaintingCountry(String newPaintingCountry){
		paintingCountry = newPaintingCountry;
	}
	
//	toString Method
	public String toString(){
		return (""+paintingPainter+"          "+paintingYear+" "+paintingName+"\n" +
				"   "+paintingGenre+"       "+paintingMedium+"       "+paintingCountry+"             "+paintingSize);
	}

}//Class