import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.io.PrintWriter;
//import java.util.ArrayList;
//import java.util.Scanner;

public class RootGUI extends JPanel
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
	JPanel questionPane2 = new JPanel();	
	JPanel inputPowerPanel = new JPanel();
	JPanel inputPowerPanel2 = new JPanel();
	JPanel addAndSubtractButtonPanel = new JPanel();
	JPanel answerPanel = new JPanel();
	JPanel clearPanel = new JPanel();
	// a JLabel is a text string that is given a String value
	// and is placed in its corresponding JPanel or JButton
	JLabel titleLabel = new JLabel();
	JLabel questionLabel = new JLabel();
	JLabel questionLabelSmall = new JLabel();	
	JLabel inputPowerAnswer = new JLabel();
	JLabel inputPower = new JLabel();
	JLabel add5Label = new JLabel();
	JLabel subtract5Label = new JLabel();
	JLabel answerLabel = new JLabel();
	JLabel nextNumberLabel = new JLabel();
	// three JButtons are created. When pushed, each button calls
	// its corresponding actionPerformed() method from the class created
	// for each button. This method executes the method code, performing
	// what the button is to do.
	JButton solveButton = new JButton();
//	JButton subtract5Button = new JButton();
	JButton clearButton = new JButton();
	//a JTextField creates a location where the client can place
	// text
	JTextField inputPowerAnswerText = new JTextField(15);
	JTextField inputPowerText = new JTextField(15);	
	private static final long serialVersionUID = 1L;
	
	public RootGUI() //constructor; Variables are given initial values
	{
		// set panel layouts
		// panels could be LEFT, or RIGHT justified.
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		questionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		questionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		inputPowerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		inputPowerPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		addAndSubtractButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		answerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		clearPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		// set Label fonts. You can use other numbers besides 30,20
		// or 15 for the font size. There are other fonts.
		Font quizBigFont = new Font("Helvetica Bold", Font.BOLD, 30);
		Font quizMidFont = new Font("Helvetica Bold", Font.BOLD, 20);
		Font quizSmallFont = new Font("Helvetica Bold", Font.BOLD, 15);
		titleLabel.setFont(quizBigFont);
		questionLabel.setFont(quizMidFont);
		questionLabelSmall.setFont(quizSmallFont);
		inputPowerAnswer.setFont(quizMidFont);
		inputPower.setFont(quizMidFont);
		add5Label.setFont(quizSmallFont);
		subtract5Label.setFont(quizSmallFont);
		answerLabel.setFont(quizBigFont);
		nextNumberLabel.setFont(quizSmallFont);
		inputPowerAnswerText.setFont(quizMidFont);
		inputPowerText.setFont(quizMidFont);
		// labels are given string values
		titleLabel.setText("Find the root!\n");
		questionLabel.setText("Please enter integers and solve for X");
		questionLabelSmall.setText("when (X^\"Root\"=\"Power Answer\")");
		inputPowerAnswer.setText("Power Answer:");
		inputPower.setText("              Root:");
		solveButton.setText(" SOLVE ");
//		subtract5Button.setText("Subtract 5");
		answerLabel.setText("");
		clearButton.setText(" CLEAR ");
		// the 3 buttons are connected to their classes
		solveButton.addActionListener(new solveButton());
//		subtract5Button.addActionListener(new subtract5Button());
		clearButton.addActionListener(new clearButton());
		// Labels, buttons and textFields are added to their
		// panels
		titlePanel.add(titleLabel);
		questionPanel.add(questionLabel);
		questionPane2.add(questionLabelSmall);
		// inputPowerPanel has 2 items added
		inputPowerPanel.add(inputPowerAnswer);
		inputPowerPanel.add(inputPowerAnswerText);
		// inputPowerPanel2 has 2 items added
		inputPowerPanel2.add(inputPower);
		inputPowerPanel2.add(inputPowerText);
		// submitPanel has two items added
		addAndSubtractButtonPanel.add(solveButton);
//		addAndSubtractButtonPanel.add(subtract5Button);
		answerPanel.add(answerLabel);
		clearPanel.add(clearButton);
		// The panels are added in the order that they should appear.
		// Throughout the declarations and initializations variables were
		// kept in this order to aid in keeping them straight
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(titlePanel);
		add(questionPanel);
		add(questionPane2);
		add(inputPowerPanel);
		add(inputPowerPanel2);
		add(addAndSubtractButtonPanel);
		add(answerPanel);
		add(clearPanel);
		/**
		 * The method writeToFile() is called from the constructor.
		 * One could call a read method from the constructor.
		 */
//		writeToFile();
	}// constructor
	
	
	
	/**
	 * This method writes 4 lines to a file. Eclipse puts the file in
	 * the folder of the project but not in the src folder. Put any
	 * file that you want read in the same place so that Eclipse can
	 * find it.
	 */
//	private void writeToFile()
//	{
//		String fileName = "textFile.txt";
//		String line = null;
//		int count;
//		Scanner scan = new Scanner(System.in);
//		PrintWriter textStream = TextFileIO.createTextWrite(fileName);
//		System.out.println("Enter 4 lines of text:");
//		for (count = 1; count <= 4; count++)
//		{
//			line = scan.nextLine();
//			textStream.println(count + " " + line);
//		}
//		textStream.close( ); // did not require error handling
//		System.out.println("Four lines were written to " + fileName);
//		scan.close();
//	}

	
	/**
	 * display() is called from main to get things going
	 */
	public void display()
	{ // A JFrame is where the components of the screen
		// will be put.
		JFrame theFrame = new JFrame("Root GUI");
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
//	private void doSomething()
//	{
//		for(int x = 1; x <= 10; x++)
//			System.out.println(" in doSomething method x is " + x);
//	}

	
	/**
	 * This class has one method that is called when the solveButton
	 * is pushed. It retrieves the string from the JTextField
	 * inputPowerAnswerText, converts it to an integer and manipulates the
	 * number.
	 * NOTE: a string of integers can be formed by creating a string
	 * with one of the numbers and then concatenating the other integers
	 * to form the string.
	 */
	
	
	class solveButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			RootClass rootGUIGame = new RootClass();
			System.out.println(" in solveButton class");
//			doSomething();// other methods can be called
			rootGUIGame.setPowerAnswer(Integer.parseInt(inputPowerAnswerText.getText()));
			rootGUIGame.setPower(Integer.parseInt(inputPowerText.getText()));
			rootGUIGame.findZ();
			answerLabel.setText(rootGUIGame.getFinalSolution());// answerLabel gets a new value
		}
	}
	
	
//	class subtract5Button implements ActionListener
//	{
//		public void actionPerformed(ActionEvent e)
//		{
//			System.out.println(" in subtract5Botton class");
//			int number = Integer.parseInt(inputPowerAnswerText.getText());
//			number = number - 5;
//			String stringNumber = "" + number;
//			answerLabel.setText(stringNumber);
//			inputPowerAnswerText.setText(stringNumber);
//		}
//	}
	
	
	/**
	 * this method resets the values of inputPowerAnswerText and answerLable
	 */
	class clearButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			inputPowerAnswerText.setText("");// erases the values of this JTextField
			inputPowerText.setText("");// erases the values of this JTextField
			answerLabel.setText("");// erases the value of this JLabel
		}
	}

}