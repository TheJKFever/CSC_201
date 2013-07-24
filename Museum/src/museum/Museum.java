package museum;

import java.util.ArrayList;
import java.util.Scanner;

public class Museum {
	private String museumName;
	private String museumFileName;
	private ArrayList<Painting> paintingArray = new ArrayList<Painting>();

// Constructor	
	public Museum(String museum, String paintingFile){
		this.museumName = museum;
		this.museumFileName=paintingFile;
	}

//	Add all paintings in file to paintingArray
	public void readFile(Scanner read){
		int numOfPaintings = Integer.parseInt(read.nextLine().trim());
		for (int i=0;i<numOfPaintings;i++){
			Painting newPainting = new Painting();
			newPainting.readPainting(read);
			paintingArray.add(newPainting);
		}
	}

/*Option Methods*/
// Genre Option
	public ArrayList<Painting> genre(String genre){
		ArrayList<Painting> selectPaintingArray = new ArrayList<Painting>();
		for (Painting thisPainting: paintingArray){
			if(genre.equals(thisPainting.paintingGenre))
				selectPaintingArray.add(thisPainting);
		}
		return selectPaintingArray;
	}
	
// Country Option
	public ArrayList<Painting> country(String desiredCountry){
		ArrayList<Painting> selectPaintingArray = new ArrayList<Painting>();
		for (Painting thisPainting: paintingArray){
			if(desiredCountry.equals(thisPainting.paintingCountry))
				selectPaintingArray.add(thisPainting);
		}
		return selectPaintingArray;
	}
	
// Year Option
	public ArrayList<Painting> datePainted(double start, double end){
		ArrayList<Painting> selectPaintingArray = new ArrayList<Painting>();
		for (Painting thisPainting: paintingArray){
			if((start<thisPainting.paintingYear)&&(end>thisPainting.paintingYear))
				selectPaintingArray.add(thisPainting);
		}
		return selectPaintingArray;
	}
	
// Painting Option
	public ArrayList<Painting> painter(String paintersName){
		ArrayList<Painting> selectPaintingArray = new ArrayList<Painting>();
		for (Painting thisPainting: paintingArray){
			if(paintersName.equals(thisPainting.paintingPainter))
				selectPaintingArray.add(thisPainting);
		}
		return selectPaintingArray;
	}

// Size Option
	public ArrayList<Painting> size(double start, double end){
		ArrayList<Painting> selectPaintingArray = new ArrayList<Painting>();
		for (Painting thisPainting: paintingArray){
			if((start<thisPainting.paintingSize)&&(end>thisPainting.paintingSize))
				selectPaintingArray.add(thisPainting);
		}
		return selectPaintingArray;
	}
	
// Medium Option
	public ArrayList<Painting> medium(String desiredMedium){
		ArrayList<Painting> selectPaintingArray = new ArrayList<Painting>();
		for (Painting thisPainting: paintingArray){
			if(desiredMedium.equals(thisPainting.paintingMedium))
				selectPaintingArray.add(thisPainting);
		}
		return selectPaintingArray;
	}
		
	public String toString(){
		return ""+museumName;
	}
	
	public String getFileName(){
		return museumFileName;
	}
	
	public ArrayList<Painting> getPaintingArray(){
		return paintingArray;
	}

}//Museum class

