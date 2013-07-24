package museum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import employeeCompany.TextFileIO;

public class Exhibition {
	Scanner keyboard = new Scanner(System.in);
	Scanner scanSingleLine;// = new Scanner (singleLine);
	
//Declare Museums Variables
	Museum corcoran;// = new Museum("Corcoran", "corcoran.txt");
	Museum nationalGallery;// = new Museum("nationalGallery", "nationalGallery.txt");
	Museum philipsCollection;// = new Museum("philipsCollection", "philipsCollection.txt"); 
	Museum portraitGallery;// = new Museum("portraitGallery", "portraitGallery.txt");
//Declare ArrayLists Variable
	String theExhibitionList="The exhibition is drawn from these museums:\n";
	private ArrayList<Museum> museumsUsed;// = new ArrayList<Museum>();
	private ArrayList<Painting> exhibitionPaintingsArray;// = new  ArrayList<Painting>();
//Static ArrayLists
	public static ArrayList<Museum> museumsOptions;// = new ArrayList<Museum>();    
    private static ArrayList<String> allPainters;// = new ArrayList<String>();    
    
// Constructor Data   
    public Exhibition() {	
    	//	Museums Objects
    	corcoran = new Museum("Corcoran", "corcoran.txt");
    	nationalGallery = new Museum("nationalGallery", "nationalGallery.txt");
    	philipsCollection = new Museum("philipsCollection", "philipsCollection.txt"); 
    	portraitGallery = new Museum("portraitGallery", "portraitGallery.txt");
    	//	ArrayList Objects
    	museumsUsed = new ArrayList<Museum>();
//    	paintingsFromOneMuseumArray = new ArrayList<Painting>();
    	exhibitionPaintingsArray = new  ArrayList<Painting>();
    	museumsOptions = new ArrayList<Museum>(); 
	    	museumsOptions.add(corcoran);
	    	museumsOptions.add(nationalGallery);
	   		museumsOptions.add(philipsCollection);
	   		museumsOptions.add(portraitGallery);
   		allPainters = new ArrayList<String>();    
   			allPainters.addAll(Arrays.asList("Angelico", "Bacciarelli", "Baldovinetti", "Bellini", "Botticelli", "Brouwer", "Carpaccio", "Cimabue", "Corot", "Correggio", "David", "Degas", "El Greco", "El Grenara", "Gainsborough", "Gauguin", "Ghirlandajo", "Giorg", "Giotto", "Goya", "Jan Fyt", "La Tour", "Lely", "Leo Vincia", "Leonardo Da Vinci", "Magnasco", "Manet", "Mantegna", "Martini", "Memling", "Metsis", "Metsys", "Murillo", "Pisanello", "Raphael", "Rembrandt", "Renoir", "Ribera", "Rubens", "Tiepolo", "Tintoretto", "Titcomian", "Titian", "Trobitian", "Tura", "Uccello", "Van Der Hoveven", "Van Der Weyden", "Van Dyck", "Van Gogh", "Velasquez", "Veronese", "Zurab", "Zurranian"));
    }
    
	private int selectTopic() {	
		System.out.println("Now that you have chosen the museums,\n" +
				"please choose an exhibition topic\n" +
				"and enter its number.");
		System.out.println("1) Painter");
		System.out.println("2) Year painted");
		System.out.println("3) Size");
		System.out.println("4) Medium");
		System.out.println("5) Country");
		System.out.println("6) Genre");
		int choice = keyboard.nextInt();
		keyboard.nextLine();
		return choice;
	}
    	
	public String paintingsChosen() {
		getMuseumsForTheExhibition();
		int topicSelection = selectTopic();
		String paintingList=null;
		switch (topicSelection)
		{
		case 1:// painter
			String painter = getPainter();
			theExhibitionList = theExhibitionList + "The paintings by " + painter + " are: \n";
			paintingList = painter(painter, museumsUsed);
			break;
		case 2:// Year painted
			String yearPainted = getYear();
			String singleLine = ""+yearPainted;
			scanSingleLine = new Scanner(singleLine);
			double startYear = scanSingleLine.nextDouble();
			double endYear = scanSingleLine.nextDouble();
			theExhibitionList = theExhibitionList + "The paintings from " + startYear + " to " + endYear + " are: \n";
			paintingList = yearPainted(startYear, endYear, museumsUsed);
			break;		
		case 3:// Size
			String paintingDimensions = getSize();
			singleLine = new String(""+paintingDimensions);
			scanSingleLine = new Scanner(singleLine);
			double startSize = scanSingleLine.nextDouble();
			double endSize = scanSingleLine.nextDouble();
			theExhibitionList = theExhibitionList + "The paintings from " + startSize + " to " + endSize + " are: \n";
			paintingList = paintingSize(startSize, endSize, museumsUsed);
			break;
		case 4:// Medium
			String medium = getMedium();
			theExhibitionList = theExhibitionList + "The paintings produced with " + medium + " are: \n";
			paintingList = medium(medium, museumsUsed);
			break;
		case 5:// Country
			String country = getCountry();
			theExhibitionList = theExhibitionList + "The paintings painted in " + country + " are: \n";
			paintingList = country(country, museumsUsed);
			break;
		case 6:// Genre
			String genre = getGenre();
			theExhibitionList = theExhibitionList + "The paintings that fit into the " + genre + " genre are: \n";
			paintingList = genre(genre, museumsUsed);
			break;
		}// switch
		return theExhibitionList + paintingList;
	}

	private void getMuseumsForTheExhibition() {
		//Display museum options
		System.out.println("For this exhibition, from which Museums would\n" +
				"you like the art work be drawn?");
		System.out.println("Please enter their numbers all on one line seperated by spaces.");
		for (int i=0;i<museumsOptions.size();i++){
			System.out.println("   " + (i+1) + ") " + museumsOptions.get(i));
		}
		String singleLine = keyboard.nextLine();
		scanSingleLine = new Scanner(singleLine);
		int i=0;
		while (scanSingleLine.hasNextInt()){
			museumsUsed.add(museumsOptions.get(scanSingleLine.nextInt()-1));
			theExhibitionList=theExhibitionList + museumsUsed.get(i)+"\n";
			i++;
		}	
	}
		
/*TOPICS OPTIONS*/
//Painter Option
	private String getPainter(){
		System.out.println("Please choose the Painter\n" +
				"and enter the Painter name exactly as displayed.");
		// get unique Painters
		ArrayList<String> uniquePainter = new ArrayList<String>();
		for (Museum x: museumsUsed){
			Scanner currentMuseumFileScan = TextFileIO.createTextRead(x.getFileName());
			x.readFile(currentMuseumFileScan);
			for (Painting currentPaintings: x.getPaintingArray()){
				if(!uniquePainter.contains(currentPaintings.getPaintingPainter())){
					uniquePainter.add(currentPaintings.getPaintingPainter());
				}
			}
		}
		Collections.sort(uniquePainter);
		int nextLine = 0;
		int count=1;
		for (int i=0;i<uniquePainter.size();i++){
			System.out.print(""+count+") "+uniquePainter.get(i)+"\t");
			count+=1;
			nextLine+=1;
			if (nextLine==4){
				System.out.println();
				nextLine = 0;
			}
		}
		System.out.println();
		return keyboard.next();
	}	
	private String painter(String paintersName, ArrayList<Museum> museumArray) {
		String output="";
		for (Museum x: museumArray){
			Scanner currentMuseumFileScan = TextFileIO.createTextRead(x.getFileName());
			x.readFile(currentMuseumFileScan);
			for (Painting p: x.painter(paintersName)){
				exhibitionPaintingsArray.add(p);
			}
		}
		for (Painting x: exhibitionPaintingsArray){
			output = output + "\n\n"+ x;
		}
		return (output+"\n\n");		
	}

//Year Option
	private String getYear(){
		System.out.println("Please enter the year range of the Paintings you would like in this exhibit.\n" +
				"Enter a year range between 1500 and 2013 (\"1850 2000\"");
		return keyboard.nextLine();
	}
	private String yearPainted(double startyear, double endyear, ArrayList<Museum> museumArray) {
		String output="";
		for (Museum x: museumArray){
			Scanner currentMuseumFileScan = TextFileIO.createTextRead(x.getFileName());
			x.readFile(currentMuseumFileScan);
			for (Painting p: x.datePainted(startyear, endyear)){
				exhibitionPaintingsArray.add(p);
			}
		}
		for (Painting p: exhibitionPaintingsArray){
			output = output + "\n\n"+p;
		}
		return (output+"\n\n");		
	}
	
//Size Option
	private String getSize(){
		System.out.println("Please enter the size range of the Paintings you would like in this exhibit.\n" +
				"Enter sizes range between 1 and 30 (\"3.5 6.0\")");
		return keyboard.nextLine();
	}	
	private String paintingSize(double startSizeUsed, double endSizeUsed, ArrayList<Museum> museumArray) {
		String output="";
		for (Museum x: museumArray){
			Scanner currentMuseumFileScan = TextFileIO.createTextRead(x.getFileName());
			x.readFile(currentMuseumFileScan);
			for (Painting p: x.size(startSizeUsed, endSizeUsed)){
				exhibitionPaintingsArray.add(p);
			}
		}
		for (Painting p: exhibitionPaintingsArray){
			output = output + "\n\n"+p;
		}
		return (output+"\n\n");		
	}

//Medium Option
	private String getMedium(){
		System.out.println("Please choose the Medium\n" +
				"and enter it exactly as displayed.");
		// get unique mediums
		ArrayList<String> uniqueMedium = new ArrayList<String>();
		for (Museum x: museumsUsed){
			Scanner currentMuseumFileScan = TextFileIO.createTextRead(x.getFileName());
			x.readFile(currentMuseumFileScan);
			for (Painting currentPaintings: x.getPaintingArray()){
				if(!uniqueMedium.contains(currentPaintings.getPaintingMedium())){
					uniqueMedium.add(currentPaintings.getPaintingMedium());
				}
			}
		}
		Collections.sort(uniqueMedium);
		int count=1;
		for (int i=0;i<uniqueMedium.size();i++){
			System.out.println(""+count+") "+uniqueMedium.get(i));
			count+=1;
		}
		
		return keyboard.next();
	}
	private String medium(String mediumUsed, ArrayList<Museum> museumArray) {
		String output="";
		for (Museum x: museumArray){
			Scanner currentMuseumFileScan = TextFileIO.createTextRead(x.getFileName());
			x.readFile(currentMuseumFileScan);
			for (Painting p: x.medium(mediumUsed)){
				exhibitionPaintingsArray.add(p);
			}
		}
		for (Painting p: exhibitionPaintingsArray){
			output = output + "\n\n"+p;
		}
		return (output+"\n\n");		
	}

//Country Option
	private String getCountry(){
		System.out.println("Please choose the Country\n" +
				"and enter it exactly as displayed.");
		// get unique mediums
		ArrayList<String> uniqueCountry = new ArrayList<String>();
		for (Museum x: museumsUsed){
			Scanner currentMuseumFileScan = TextFileIO.createTextRead(x.getFileName());
			x.readFile(currentMuseumFileScan);
			for (Painting currentPaintings: x.getPaintingArray()){
				if(!uniqueCountry.contains(currentPaintings.getPaintingCountry())){
					uniqueCountry.add(currentPaintings.getPaintingCountry());
				}
			}
		}
		Collections.sort(uniqueCountry);
		int count=1;
		for (int i=0;i<uniqueCountry.size();i++){
			System.out.println(""+count+") "+uniqueCountry.get(i));
			count+=1;
		}
		return keyboard.next();
	}	
	private String country(String countryUsed, ArrayList<Museum> museumArray) {
		String output="";
		for (Museum x: museumArray){
			Scanner currentMuseumFileScan = TextFileIO.createTextRead(x.getFileName());
			x.readFile(currentMuseumFileScan);
			for (Painting p: x.country(countryUsed)){
				exhibitionPaintingsArray.add(p);
			}
		}
		for (Painting x: exhibitionPaintingsArray){
			output = output + "\n\n"+ x;
		}
		return (output+"\n\n");		
	}

//Genre Option
	private String getGenre(){
		System.out.println("Please choose the Genre\n" +
				"and enter it exactly as displayed.");
		// get unique mediums
		ArrayList<String> uniqueGenre = new ArrayList<String>();
		for (Museum x: museumsUsed){
			Scanner currentMuseumFileScan = TextFileIO.createTextRead(x.getFileName());
			x.readFile(currentMuseumFileScan);
			for (Painting currentPaintings: x.getPaintingArray()){
				if(!uniqueGenre.contains(currentPaintings.getPaintingGenre())){
					uniqueGenre.add(currentPaintings.getPaintingGenre());
				}
			}
		}
		Collections.sort(uniqueGenre);
		int count=1;
		for (int i=0;i<uniqueGenre.size();i++){
			System.out.println(""+count+") "+uniqueGenre.get(i));
			count+=1;
		}
		return keyboard.next();
	}
	private String genre(String genreUsed, ArrayList<Museum> museumArray) {
		String output="";
		for (Museum x: museumArray){
			Scanner currentMuseumFileScan = TextFileIO.createTextRead(x.getFileName());
			x.readFile(currentMuseumFileScan);
			for (Painting p: x.genre(genreUsed)){
				exhibitionPaintingsArray.add(p);
			}
		}
		for (Painting p: exhibitionPaintingsArray){
			output = output + "\n\n"+p;
		}
		return (output+"\n\n");		
	}
	
	
}//class