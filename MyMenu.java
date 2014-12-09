import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class MyMenu extends JFrame {
	//attributes
	private JMenuBar menubar;
	private JButton saveButton;
	private JButton openButton;
	private JTextArea textArea;
	
	//instance of Trainee class
	Trainee t1 = new Trainee();
	
	//event handler
	MyHandler handler = new MyHandler();
	Container cPane;
	
	//GUI constructor
	public MyMenu(){		
		setTitle("Training Application");
		setSize(300,350);
		setLocation(300,250);
		cPane = getContentPane();
        cPane.setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//creating JMenuBar
		menubar = new JMenuBar();
		setJMenuBar(menubar);
		//creating two JMenu
		createFileMenu();
		createTraineeMenu();
		//creating two buttons
		saveButton = new JButton("SAVE");
        cPane.add(saveButton);
        saveButton.addActionListener(handler);    
        openButton = new JButton("OPEN");
        cPane.add(openButton);
		openButton.addActionListener(handler);
		//creating JTextArea
		textArea = new JTextArea();
		cPane.add(textArea);
		textArea.setEditable(false); 
		textArea.setVisible(false);
		Color c = new Color(0,0,0,100);
        textArea.setBackground(c);
		
	}
	//constructing File JMenu and JMenuItems
	public void createFileMenu(){
		JMenu filemenu = new JMenu("File");
		menubar.add(filemenu);
		JMenuItem New = new JMenuItem("New");
		filemenu.add(New);
		New.addActionListener(handler);
		filemenu.addSeparator();
		JMenuItem quit = new JMenuItem("Quit");
		filemenu.add(quit);
		quit.addActionListener(handler);
	
	}
	//constructing Trainee JMenu and JMenuItems
	public void createTraineeMenu(){
		JMenu traineeMenu = new JMenu("Trainee");
		menubar.add(traineeMenu);
		JMenuItem add = new JMenuItem("Add");
		traineeMenu.add(add);
		add.addActionListener(handler);
		JMenuItem display = new JMenuItem("Display");
		traineeMenu.add(display);
		display.addActionListener(handler);
		JMenuItem bmi = new JMenuItem("BMI");
		traineeMenu.add(bmi);
		bmi.addActionListener(handler);
		JMenuItem bmr = new JMenuItem("BMR");
		traineeMenu.add(bmr);
		bmr.addActionListener(handler);	
			
	}
	// Main method
	public static void main(String args[]){
		
		MyMenu menu = new MyMenu();
		menu.setVisible(true);
	
	}
	
	
	
	
	//event handler
		public class MyHandler implements ActionListener{
		public void actionPerformed(ActionEvent e){
		
		if(e.getSource() == openButton ){ 
		try{                        //modified code from ch12TestObjectInputStream
			
		File in = new File("trainee.dat");
		FileInputStream  inStream = new FileInputStream(in);
		ObjectInputStream oin = new ObjectInputStream(inStream);
		
		Trainee t1;
		t1  = (Trainee) oin.readObject();
		oin.close();
		
        textArea.setText(t1.toString());
        
		}//end try
		catch(Exception exc)
		{
			JOptionPane.showInputDialog("Open did not work ");			
		}//end catch
		saveButton.setVisible(false);
		openButton.setVisible(false);
		textArea.setVisible(true);
		}//end if
		
		else if(e.getSource() == saveButton ){
			                                            //modified code from ch12TestObjectOutputStream
		try{
		
		File out = new File("trainee.dat");
		FileOutputStream  outStream	= new FileOutputStream(out);
		ObjectOutputStream oos = new ObjectOutputStream(outStream);
        oos.writeObject(t1);
		oos.close();
		}//end try

		
		catch (Exception ex) {
         ex.printStackTrace();
        }//end catch

		}////end if
		else if(e.getActionCommand().equals("New"))
		t1 = new Trainee();
		else if(e.getActionCommand().equals("Quit"))
			System.exit(0);
		else if(e.getActionCommand().equals("Add")){
			textArea.setVisible(false);
    		t1.setName(JOptionPane.showInputDialog("Enter name: "));
    		t1.setAge(Double.parseDouble(JOptionPane.showInputDialog("Enter age: ")));
    		t1.setGender(JOptionPane.showInputDialog("Enter gender: ").charAt(0));
    		t1.setWeight(Double.parseDouble(JOptionPane.showInputDialog("Enter weight in pounds: ")));
    		t1.setHeight(Double.parseDouble(JOptionPane.showInputDialog("Enter height in inches: ")));
    		saveButton.setVisible(true);
			openButton.setVisible(true);
			
			}
		else if(e.getActionCommand().equals("Display")){
		
			textArea.setText(t1.toString());
			saveButton.setVisible(true);
			openButton.setVisible(true);
			textArea.setVisible(true);
		
		}
		else if(e.getActionCommand().equals("BMI"))
			JOptionPane.showMessageDialog(null,"Your Body Mass Index is " + ((t1.getWeight()/(t1.getHeight()*t1.getHeight()))* 703),"BMI Calculator",JOptionPane.INFORMATION_MESSAGE);
		else if(e.getActionCommand().equals("BMR"))
			JOptionPane.showMessageDialog(null,"Your Basal Metabolic Rate is " + ((66 + ((6.23* t1.getWeight())+ (12.7 * t1.getHeight())))-(6.8* t1.getAge())),"Calorie Calculator",JOptionPane.INFORMATION_MESSAGE);	
		
			
	}	
	}
	
	
}