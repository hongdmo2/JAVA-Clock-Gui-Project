//Sorted Linked List class



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.File;


public class SortedClockList extends ClockList{  //Extends of the ClockList class
	public SortedClockList() {      //Default constructor
		ClockNode cn = new ClockNode();   
		first = cn;
		last = cn;
		size = 0;
	}
	
	
	public void add(ClockList c) {    //Sorted addition
		
		ClockNode node = c.first;
		
		
		while(node.next != null) {
				
			selectionSort(node.data);   //A new object of clock will be located in proper location
			node = node.next;        //Move to next node.
			if(node.next == null) {
				
				selectionSort(node.data);
				//In case of the last, selectionSort will be operated.  
				}
			
			
			}
		}  
		
	/*public void add(ClockList c) {    //Sorted addition
			Clock clock = new Clock();
			ClockNode node = new ClockNode();
			node = c.first;
			System.out.println("aaaaa"+c.first);
			while(node.next != null) {
				
				System.out.println("aa"+clock.toString());
								
				clock = node.data; 
				selectionSort(clock);   //A new object of clock will be located in proper location
				node = node.next;        //Move to next node.
				if(node.next == null) {
					
					selectionSort(clock);
					//In case of the last, selectionSort will be operated.  
					}
				
				
				}
			}  */
	
	
	
/*
	public void add(File filename) { 
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
				int second = 0;
				int minute = 0;
				int hour = 0;
				try {
					second = Integer.parseInt(st.nextToken());
					minute = Integer.parseInt(st.nextToken());
					hour = Integer.parseInt(st.nextToken());		            
					Clock c = new Clock(second, minute, hour); //Create clock c
					selectionSort(c);   //A new object of clock will be located in proper location
					
				} catch (Exception e) {  
					System.out.println(e + ": Invalid format, skipping"); //If the line does not have the number of token properly,
				}								//the line will be excepted. 
				
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	*/
	
	
	
	public void selectionSort(Clock c)   //Sorting method
	   { 

	      ClockNode new_node = new ClockNode(c);
	      ClockNode current = first; 

	      if (size == 0 || first.data.gethour() > new_node.data.gethour()) {    //add the new node in front of the first node if the node is the first element or the new node is less than or equal the first node. 
	         new_node.next = first; 
	            first = new_node; 
	            size++;
	      }
	      else 
	      { 
	         while (true) 
	         {  //Searching until that the current node will be the last or finding that a new node will be less than another node.  
	            if(current.next.data == null)
	               break;
	            else if(current.next.data.gethour()>new_node.data.gethour()) 
	            {
	               break;
	            }
	            else if(current.next.data.gethour()==new_node.data.gethour()) 
	            {
	               if(current.next.data.getminute()>new_node.data.getminute()) 
	               {
	                  break;
	               }
	               else if(current.next.data.getminute()==new_node.data.getminute()) 
	               {
	                  if(current.next.data.getsecond()>new_node.data.getsecond()) 
	                  {
	                     break;
	                  }
	               }
	               current = current.next; 
	            }
	            else 
	            {
	               current = current.next; 
	            }//the current node will be a next node
	         }
	         new_node.next = current.next;  //The next of new node will be assigned the next of current by the while loop logic. 
	         current.next = new_node;      // The new node will be located behind the current node by the while loop logic.
	         size++;
	      } 
	   }
	


	       
	         
	    
	
		
	
	public String toString() {
		if(first == null) {
			return "[]";
		}
		ClockNode temp = first;
		String str = "[Sorted ClockList]\n";
		while(temp.next != null) {
			str += temp.data +"'\n";
			temp = temp.next;
		}
		return str +"\n";
	}
}
