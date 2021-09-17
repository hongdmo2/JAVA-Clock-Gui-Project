//ClockNode class
//Initialize a node using this class.



public class ClockNode {
	protected Clock data;
	protected ClockNode next;
	public ClockNode() {    //no argument constructor.
		this.data = null;
		this.next = null;
		
	}
	public ClockNode(Clock c) {
		this.data = c;
		this.next = null;
	}
	
	public ClockNode(Clock c, ClockNode next) {
		this.data = c;
		this.next = next;
		
	}
	public String toString() {
		return String.valueOf(this.next.data);
	}
}
