
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EditMenuHandler implements ActionListener{
	JFrame jframe;
	public EditMenuHandler(JFrame jf) {
		jframe = jf;
	} //constructor
	public void actionPerformed(ActionEvent e) {
		String menuName = e.getActionCommand();
		if(menuName.equals("Search")) {
			ClockList list = new SortedClockList();
			list = FileMenuHandler.getList();  //list can be defined by a get method because using static field variale.
			int hour=0;
			hour = Integer.parseInt(JOptionPane.showInputDialog("Input Clock hour to search")); //read hour value to sort from an user
			createText(list,hour); 
		} 
	} //actionPerformed
	public void createText(ClockList cl, int hour) { //Add new text area with new container as making a new panel, and print sorted result.
		JPanel panel = new JPanel();
		Container content = jframe.getContentPane();   
		JTextArea text = new JTextArea();
		panel.setLayout(new GridLayout(1,1));
		content.add(text);	//add text to container
		text.append(cl.toStringForSearch(hour));  //print sorting result out using toStringForSearch at ClockList class
		panel.add(text); 
		jframe.add(panel);
	} //createText
}//EditMenuHandler

