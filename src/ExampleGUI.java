import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintWriter;
//import java.util.ArrayList;
import java.util.Scanner;

public class ExampleGUI extends JPanel
{
	/**
	 * 
	 */
	
	// ***Variables are created ***
	// GUIs are made up of JPanels. Panels are created
	// here and named appropriately to describe what will
	// be placed in each of them.
	JPanel titlePanel = new JPanel();
	JPanel questionPanel = new JPanel();
	JPanel inputNumberPanel = new JPanel();
	JPanel addAndSubtractButtonPanel = new JPanel();
	JPanel answerPanel = new JPanel();
	JPanel nextNumberPanel = new JPanel();
	// a JLabel is a text string that is given a String value
	// and is placed in its corresponding JPanel or JButton
	JLabel titleLabel = new JLabel();
	JLabel questionLabel = new JLabel();
	JLabel inputNumberLabel = new JLabel();
	JLabel add5Label = new JLabel();
	JLabel subtract5Label = new JLabel();
	JLabel answerLabel = new JLabel();
	JLabel nextNumberLabel = new JLabel();
	// three JButtons are created. When pushed, each button calls
	// its corresponding actionPerformed() method from the class created
	// for each button. This method executes the method code, performing
	// what the button is to do.
	JButton add5Button = new JButton();
	JButton subtract5Button = new JButton();
	JButton nextNumberButton = new JButton();
	//a JTextField creates a location where the client can place
	// text
	JTextField inputTextField = new JTextField(15);
	private static final long serialVersionUID = 1L;
	
	public ExampleGUI() //constructor; Variables are given initial values
	{
		// set panel layouts
		// panels could be LEFT, or RIGHT justified.
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		questionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		inputNumberPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		addAndSubtractButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		answerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		nextNumberPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		// set Label fonts. You can use other numbers besides 30,20
		// or 15 for the font size. There are other fonts.
		Font quizBigFont = new Font("Helvetica Bold", Font.BOLD, 30);
		Font quizMidFont = new Font("Helvetica Bold", Font.BOLD, 20);
		Font quizSmallFont = new Font("Helvetica Bold", Font.BOLD, 15);
		titleLabel.setFont(quizBigFont);
		questionLabel.setFont(quizMidFont);
		inputNumberLabel.setFont(quizMidFont);
		add5Label.setFont(quizSmallFont);
		subtract5Label.setFont(quizSmallFont);
		answerLabel.setFont(quizBigFont);
		nextNumberLabel.setFont(quizSmallFont);
		inputTextField.setFont(quizMidFont);
		// labels are given string values
		titleLabel.setText("Add or Subtract Five");
		questionLabel.setText("Please enter an integer number.");
		inputNumberLabel.setText("Number:");
		add5Button.setText(" Add 5 ");
		subtract5Button.setText("Subtract 5");
		answerLabel.setText("");
		nextNumberButton.setText(" New Number ");
		// the 3 buttons are connected to their classes
		add5Button.addActionListener(new add5Button());
		subtract5Button.addActionListener(new subtract5Button());
		nextNumberButton.addActionListener(new nextNumberButton());
		// Labels, buttons and textFields are added to their
		// panels
		titlePanel.add(titleLabel);
		questionPanel.add(questionLabel);
		// inputNumberPanel has 2 items added
		inputNumberPanel.add(inputNumberLabel);
		inputNumberPanel.add(inputTextField);
		// submitPanel has two items added
		addAndSubtractButtonPanel.add(add5Button);
		addAndSubtractButtonPanel.add(subtract5Button);
		answerPanel.add(answerLabel);
		nextNumberPanel.add(nextNumberButton);
		// The panels are added in the order that they should appear.
		// Throughout the declarations and initializations variables were
		// kept in this order to aid in keeping them straight
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(titlePanel);
		add(questionPanel);
		add(inputNumberPanel);
		add(addAndSubtractButtonPanel);
		add(answerPanel);
		add(nextNumberPanel);
		/**
		 * The method writeToFile() is called from the constructor.
		 * One could call a read method from the constructor.
		 */
		writeToFile();
	}// constructor
	
	
	
	/**
	 * This method writes 4 lines to a file. Eclipse puts the file in
	 * the folder of the project but not in the src folder. Put any
	 * file that you want read in the same place so that Eclipse can
	 * find it.
	 */
	private void writeToFile()
	{
		String fileName = "textFile.txt";
		String line = null;
		int count;
		Scanner scan = new Scanner(System.in);
		PrintWriter textStream = TextFileIO.createTextWrite(fileName);
		System.out.println("Enter 4 lines of text:");
		for (count = 1; count <= 4; count++)
		{
			line = scan.nextLine();
			textStream.println(count + " " + line);
		}
		textStream.close( ); // did not require error handling
		System.out.println("Four lines were written to " + fileName);
		scan.close();
	}

	
	/**
	 * display() is called from main to get things going
	 */
	public void display()
	{ // A JFrame is where the components of the screen
		// will be put.
		JFrame theFrame = new JFrame("GUI Example");
		// When the frame is closed it will exit to the
		// previous window that called it.
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// puts the panels in the JFrame
		theFrame.setContentPane(this);
		// sets the dimensions in pixels
		theFrame.setPreferredSize(new Dimension(600, 380));
		theFrame.pack();
		// make the window visible
		theFrame.setVisible(true);
	}

	
	/**
	 * method doSomething is called from an actionPerformend method
	 * demonstrating calling methods that can do work for you.
	 */
	private void doSomething()
	{
		for(int x = 1; x <= 10; x++)
			System.out.println(" in doSomething method x is " + x);
	}

	
	/**
	 * This class has one method that is called when the add5Button
	 * is pushed. It retrieves the string from the JTextField
	 * inputTextField, converts it to an integer and manipulates the
	 * number.
	 * NOTE: a string of integers can be formed by creating a string
	 * with one of the numbers and then concatenating the other integers
	 * to form the string.
	 */
	
	
	class add5Button implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println(" in add5Button class");
			doSomething();// other methods can be called
			int number = Integer.parseInt(inputTextField.getText());
			number = number + 5;
			String stringNumber = "" + number;
			answerLabel.setText(stringNumber);// answerLabel gets a new value
			inputTextField.setText(stringNumber);
		}
	}
	
	
	class subtract5Button implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println(" in subtract5Botton class");
			int number = Integer.parseInt(inputTextField.getText());
			number = number - 5;
			String stringNumber = "" + number;
			answerLabel.setText(stringNumber);
			inputTextField.setText(stringNumber);
		}
	}
	
	
	/**
	 * this method resets the values of inputTextField and answerLable
	 */
	class nextNumberButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			inputTextField.setText("");// erases the values of this JTextField
			answerLabel.setText("");// erases the value of this JLabel
		}
	}
}