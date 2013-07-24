package sunriseProgram;

import javax.swing.JApplet;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;
import java.awt.FontMetrics;

public class SunriseGUI extends JApplet
{
	private static final long serialVersionUID = 1L;
	private static File sunriseDataFile = new File("C:/Hard Drive/Programming Projects/CSC_201_Class_Projects/sunriseData.txt");
	int count = 19;	
	int forColor = 1;
	Image img;
	int[] monthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	String[] timesOfDay = {"4:00 AM", "5:00 AM", "6:00 AM", "7:00 AM", "8:00 AM", "4:00 PM", "5:00 PM", "6:00 PM", "7:00 PM", "8:00 PM"};
	String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
		
	public void init() {
	    this.setSize(800, 640);
	    try { img = getImage
			(new URL("file:/C:/Hard Drive/Programming Projects/CSC_201_Class_Projects/src/sunriseProgram/Sunrise.jpg")); 
		} catch (Exception e) { System.out.println(e.toString());}
	}
	     
	public void paint (Graphics page)
	{
		//Draw background image
		page.drawImage(img, 0, 0, getWidth() , getHeight(), this); 		
		graph(page);
		try {
			plot(page);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		key(page);
	}
	
	public void graph(Graphics page)
	{
		int x;
		//Add Title
		page.setColor(Color.WHITE);
		page.setFont(new Font("Arial", Font.BOLD, 28));
		String title = "GRAPH OF SUNRISE AND SUNSET DATA";
		FontMetrics fm = page.getFontMetrics();
        x = getWidth()/2 - fm.stringWidth(title)/2;
 		page.drawString(title, x, 40);
 		
 		//add Veritcal axis labels
 		page.setFont(new Font("Arial", Font.PLAIN, 12));
 		x=60; 
 		for (String times:timesOfDay){
 			{	page.drawString(times, 5, x);}
 			x+=60;
 		}
 		
 		//add Horizontal axis labels
 		x=79; 
 		for (String month:months){
 			{	page.drawString(month, x, 615);}
 			x+=61;
 		}
		
		//vertical white lines
		page.setColor(Color.WHITE);
		x=60;
		page.drawLine(60, 55, 60, 595);
		for(int days:monthDays)
		{ 	x = x + (days*2);
			page.drawLine(x, 55, x, 595);
		}
		
		//Horizontal white lines
		page.setColor(Color.WHITE);
		for(x=55; x < 630; x+=60)
		{	page.drawLine(60, x, 790, x);
		}
	}
	
	public void plot(Graphics page) throws FileNotFoundException {
		Scanner readFile = new Scanner(sunriseDataFile);
	// Plot Sunrise
		int day;
		for (day=0;day<365;day++){
			setNewColor(page, 10);
			int timeOfPoint=55;
			readFile.nextInt();
			timeOfPoint = timeOfPoint + ((readFile.nextInt()-4)*60);
			timeOfPoint = timeOfPoint + readFile.nextInt();
			page.fillOval ((60+(day*2)), timeOfPoint, 2, 2); // circle
						
	// Plot Sunset	
			setNewColor(page, 6);
			timeOfPoint=355;
			timeOfPoint = timeOfPoint + ((readFile.nextInt()-16)*60);
			timeOfPoint = timeOfPoint + readFile.nextInt();
			page.fillOval ((60+(day*2)), timeOfPoint, 2, 2); // circle
		}
		readFile.close();
	}
	
	public void key(Graphics page) {
	// Draw Key box
		page.setColor(new Color( .9f, .9f, .9f, .9f));
		int boxWidth=200;
		int boxHeight=80;
		int topLeftOfBoxX = getWidth()/2 - boxWidth/2;
		int topLeftOfBoxY = getHeight()/2 - boxHeight/2;
		page.fillRect(topLeftOfBoxX, topLeftOfBoxY, boxWidth, boxHeight);
	// Add two lines
		setNewColor(page, 10);//color of Sunrise
		page.fillRect(topLeftOfBoxX+30, topLeftOfBoxY+(boxHeight/3), 60, 3);
		setNewColor(page, 6);//color of Sunset
		page.fillRect(topLeftOfBoxX+30, topLeftOfBoxY+((boxHeight*2)/3), 60, 3);
	
	// Add Key Text
		setNewColor(page, 1);
		page.setFont(new Font("Arial", Font.PLAIN, 16));
 		page.drawString("Sunrise", topLeftOfBoxX+110, topLeftOfBoxY+(boxHeight/3)+7);
 		page.drawString("Sunset", topLeftOfBoxX+110, topLeftOfBoxY+((boxHeight*2)/3)+7);
	}	
	
	private void setNewColor(Graphics page, int forColor)
	{
		switch (forColor)
		{
		case 1:
			page.setColor(Color.BLACK);
			break;
		case 2:
			page.setColor(Color.BLUE);
			break;
		case 3:
			page.setColor(Color.CYAN);
			break;
		case 4:
			page.setColor(Color.DARK_GRAY);
			break;
		case 5:
			page.setColor(Color.GRAY);
			break;
		case 6:
			page.setColor(Color.GREEN);
			break;
		case 7:
			page.setColor(Color.LIGHT_GRAY);
			break;
		case 8:
			page.setColor(Color.DARK_GRAY);
			break;
		case 9:
			page.setColor(Color.MAGENTA);
			break;
		case 10:
			page.setColor(Color.ORANGE);
			break;
		case 11:
			page.setColor(Color.PINK);
			break;
		case 12:
			page.setColor(Color.YELLOW);
			break;
		case 13:
			page.setColor(Color.WHITE);
			break;
		}
	}
}