//Unsorted clock List.


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

class IllegalClockException extends IllegalArgumentException{
	   IllegalClockException(){
	      super();
	   }
	   IllegalClockException(String message){
	      super(message);
	   }
	   
	}
	public class UnsortedClockList extends ClockList{ //Extends of the clockList class
	   public UnsortedClockList() {    //Default constructor
	      ClockNode cn = new ClockNode();
	      first = cn;
	      last = cn;
	      size = 0;
	   }
	      
	   public void add (File filename) throws IllegalClockException{ 
	      BufferedReader reader;
	      try {
	         reader = new BufferedReader(new FileReader(filename));
	         //Initialize variables
	         String line = "";
	         while (true) {
	            line = reader.readLine();
	            
	            
	            
	            if (line == null) {  //If the line does not exist, 
	                     //stop the while loop.
	               break;
	            }
	            
	            StringTokenizer st = new StringTokenizer(line, ":");  //Token is :
	            if (st.countTokens()<3)
	            	System.out.println(": number of tokens are less than 3: "+line);
	            else
	            {
	            int second = 0;
	            int minute = 0;
	            int hour = 0;
	            try {
	                hour = Integer.parseInt(st.nextToken());
	                minute = Integer.parseInt(st.nextToken());
	                second = Integer.parseInt(st.nextToken());  
	                
	                try {
	                   if (hour>24||minute>59||second>59){
	                      throw new IllegalClockException();
	                   }else {
	                   Clock c = new Clock(hour, minute, second);            //Create clock c
	                   
	                   append(c);               //A new object of clock will be located behind an added node using append method (add last)
	                   }
	                } 
	                
	                catch(IllegalClockException e){
	                   System.out.println(e + ": Invalid number , skipping");
	                }
	            } catch (Exception e) {
	               System.out.println(e + ": Invalid format, skipping"); //If the line does not have the number of token properly,
	            }                        //the line will be excepted. 
	            }
	         }
	         reader.close();
	      } catch (IOException e) {
	         e.printStackTrace();
	      }
	      	this.first = super.getFirst();
	      	this.last = super.getLast();
	      	this.size = super.getSize();
	      
	      }
	   
	public String toString() {
		if(first == null) {
			return "[]";
		}
		ClockNode temp = first;
		String str = "[Unsorted ClockList]\n";
		while(temp.next != null) {
			str += temp.data +"'\n";
			temp = temp.next;
		}
		str += temp.data;
		return str+"\n";
		
	}
}