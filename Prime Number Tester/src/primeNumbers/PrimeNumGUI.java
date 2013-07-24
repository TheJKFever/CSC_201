package primeNumbers;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

public class PrimeNumGUI extends JPanel {
	private static final long serialVersionUID = 1L;
	
// Create GUI Variables //
// Create JPanels //
	JPanel titlePanel = new JPanel();
	JPanel questionPanel = new JPanel();
	JPanel inputPrime = new JPanel();
	JPanel answerPanel = new JPanel();
	JPanel allPrimesPanel = new JPanel();
	JPanel buttonsPanel = new JPanel();
// Create JLabel to put in JPanels //
	JLabel titleLabel = new JLabel();
	JLabel questionLabel = new JLabel();
	JLabel inputPrimeLabel = new JLabel();
	JLabel answerLabel = new JLabel();
	JLabel allPrimesLabel = new JLabel();
// Create JButtons to call functions //
	JButton findPrimesButton = new JButton();
	JButton clearButton = new JButton();
// Create JTextField for user to enter text //
	JTextField inputPrimeText = new JTextField(15);
	
	public PrimeNumGUI() // Constructor; Variables are initialized //
	{
		// Set panel layouts (LEFT, RIGHT, or Center justified)
		titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		questionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		inputPrime.setLayout(new FlowLayout(FlowLayout.CENTER));
		answerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		allPrimesPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

		// Set Label fonts //
		Font bigFont = new Font("Helvetica Bold", Font.BOLD, 30);
		Font midFont = new Font("Helvetica Bold", Font.BOLD, 20);
		Font smallFont = new Font("Helvetica Bold", Font.BOLD, 15);
		titleLabel.setFont(bigFont);
		questionLabel.setFont(midFont);
		inputPrimeLabel.setFont(midFont);
		answerLabel.setFont(smallFont);
		allPrimesLabel.setFont(midFont);
		findPrimesButton.setFont(midFont);
		clearButton.setFont(midFont);

		// labels are given string values //
		titleLabel.setText("Prime Number Tester\n");
		questionLabel.setText("Enter a number to test if it's a prime number?");
		inputPrimeLabel.setText("");		
		answerLabel.setText("");
		allPrimesLabel.setText("");		
		findPrimesButton.setText("Test For Prime");
		clearButton.setText("CLEAR");

		// the buttons are connected to their classes
		findPrimesButton.addActionListener(new findPrimesButton());
		clearButton.addActionListener(new clearButton());

		// Labels, buttons, and textFields are added to their panels //
		titlePanel.add(titleLabel);
		questionPanel.add(questionLabel); 
		inputPrime.add(inputPrimeLabel);
		inputPrime.add(inputPrimeText);
		answerPanel.add(answerLabel);
		allPrimesPanel.add(allPrimesLabel);
		buttonsPanel.add(findPrimesButton);
		buttonsPanel.add(clearButton);

		// The panels are added in the order that they should appear.
		// Throughout the declarations and initializations variables were
		// kept in this order to aid in keeping them straight
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(titlePanel);
		add(questionPanel);
		add(inputPrime);
		add(answerPanel);
		add(allPrimesPanel);
		add(buttonsPanel);
	}// constructor
	
	
	/**display() is called from main to get things going*/
	public void display()
	{ // A JFrame is where the components of the screen will be put.
		JFrame theFrame = new JFrame("Prime Number GUI");
		// When the frame is closed it will exit to the previous window that called it.
		theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// puts the panels in the JFrame
		theFrame.setContentPane(this);
		// sets the dimensions in pixels
		theFrame.setPreferredSize(new Dimension(600, 380));
		theFrame.pack();
		// make the window visible
		theFrame.setVisible(true);
	}
	
	/** This method is called when the findPrime is pushed. It retrieves the string from the JTextField
	 * inputPrimeText, converts it to an integer and tests for Prime. */	
	class findPrimesButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{	
			PrimeNumTester primeNumGUIGame = new PrimeNumTester();
			try {
				allPrimesLabel.setText(primeNumGUIGame.findNextPrime(Integer.parseInt(inputPrimeText.getText())));
				
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}// allPrimesLabel gets a new value
			
			if (primeNumGUIGame.getIsPrime() == true){
				answerLabel.setText("!! "+inputPrimeText.getText()+" is a prime number !!");
			}
			else {
				answerLabel.setText("Sorry, "+inputPrimeText.getText()+" is not a prime number.");
			}
			answerLabel.setText(answerLabel.getText()+"\n"+"The prime numbers that divide evenly into "+inputPrimeText.getText()+" are: ");
		}
	}
		
	/**this method resets the values of inputPowerAnswerText and answerLable */
	class clearButton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			inputPrimeText.setText("");// erases the values of this JTextField
			answerLabel.setText("");//erases the values in answerLabel
			allPrimesLabel.setText("");// erases the value of this JLabel
		}
	}

}