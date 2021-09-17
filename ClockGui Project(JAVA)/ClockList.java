

//clockList abstract class



public abstract class ClockList {
	protected ClockNode first;
	protected ClockNode last;
	protected int size = 0;
	public ClockList() {
		ClockNode cn = new ClockNode();
		first = cn;
		last = cn;
		size = 0;
	}
	public void append(Clock c) {   //add a new node into the last of linked list
		ClockNode n = new ClockNode(c);   //Create a new node.
		if(size == 0) { //if a new node is the first element of the list.
			last = n;   //last will be a new node
			first = n;  //first will be a new node
			size++;
			
		} 
		
			last.next = n;   // the next node of the pointed last node.
			
			last = n;        // The last node will be the new node. 
			size++;		     // size  + 1 
			
		}
	public String toStringForSearch(int hour) {
		if(first == null) {
			return "[]";
		}
		ClockNode temp = first;
		String str = "***[Sorting Result]***\n";
		while(temp.next != null){
			if(temp.data.gethour()<=hour) {
				str += temp.data +"'\n";
			}
			temp = temp.next;
		}
		return str +"\n";
	}
	public ClockNode getFirst() {
		return this.first;
	}
	public ClockNode getLast() {
		return this.last;
	}
	public int getSize() {
		return this.size;
	}
	
	
	public String toString() {   //Print out using toString method
		if(first == null) {
			return "[]";
		}
		ClockNode temp = first;
		String str = "[";
		while(temp.next != null) {
			str += temp.data +"'";
			temp = temp.next;
		}
		str += temp.data;
		return str +"]";
	}
}
