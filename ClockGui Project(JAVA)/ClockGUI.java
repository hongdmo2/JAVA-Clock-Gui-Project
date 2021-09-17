import javax.swing.*;
import java.awt.*;

public class ClockGUI extends JFrame{  
	JMenuBar menuBar;
	public ClockGUI(String title, int height, int width) {
		setTitle(title);
		setSize(height,width);
		setLocation  (400,200);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1,2));
		menuBar  = new JMenuBar();
		createFileMenu();
		setJMenuBar(menuBar);  //Set Menu bar into 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}		//Constructor
	private void createFileMenu( ) {
		JMenuItem   item;

		JMenu fileMenu = new JMenu("File");  
		JMenu editMenu = new JMenu("Edit");
		FileMenuHandler fmh  = new FileMenuHandler(this);
		EditMenuHandler emh = new EditMenuHandler(this);
		
		item = new JMenuItem("Open");    //Add 'open' into item class
		item.addActionListener( fmh );
		fileMenu.add( item );			//Add 'open' item into the file menu

		fileMenu.addSeparator();           //add a horizontal separator line

		item = new JMenuItem("Quit");       //Add 'Quit' into item class
		item.addActionListener( fmh );		//add Actionlistener 
		fileMenu.add( item );				//Add 'quit' item into the file menu
		
		item = new JMenuItem("Search");
		item.addActionListener(emh);
		editMenu.add(item);

		menuBar.add(fileMenu);
		menuBar.add(editMenu);

	} 
}
