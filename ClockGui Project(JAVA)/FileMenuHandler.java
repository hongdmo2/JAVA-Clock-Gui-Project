

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
public class FileMenuHandler implements ActionListener {
	private JFrame jframe;
	private static ClockList cl;   //Define ClockList cl as static field since this data will be used 
									//after opening a text file until exit.
	public FileMenuHandler (JFrame jf) {
		jframe = jf;
	}
	public void actionPerformed(ActionEvent event) {
		String menuName = event.getActionCommand();
		if (menuName.equals("Open")) {    //If an user click open, then...
			JFileChooser fc = new JFileChooser();  //file chooser
			fc.setCurrentDirectory(new java.io.File("C:"));
			fc.showOpenDialog(fc);
			File file = fc.getSelectedFile();
			
			UnsortedClockList ul = new UnsortedClockList(); 
			ul.add(file);  //the file will be read by add method and create unsorted list
			SortedClockList sl = new SortedClockList(); 
			sl.add(ul);    //sorted list will be made using unsorted list.
			setList(sl);
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(1,2));
			Container myContentPane = jframe.getContentPane();  //container to contain text area. 
			
			JTextArea left = new JTextArea();
			JTextArea right = new JTextArea();
			
			myContentPane.add(left);
			myContentPane.add(right);
			
			left.append(ul.toString());   //Print out object using toString method
			left.append("\n");

			right.append(sl.toString());
			right.append("\n");


			panel.add(left);
			panel.add(right);
			
			jframe.add(panel);
		
		}
		else if (menuName.equals("Quit")) {   //If an user click quit, then...
			System.exit(0);
		}
	} //actionPerformed
	//Getter, Setter for sending Clocklist data to EditMenuHandler
	public void setList(ClockList l) {
		cl = l;
	} 
	public static ClockList getList(){
		return cl;
	} 
}