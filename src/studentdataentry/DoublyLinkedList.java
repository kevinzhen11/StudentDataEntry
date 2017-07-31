package studentdataentry;

public class DoublyLinkedList {
	private int count;
	private Student first_node, last_node;
	
	public DoublyLinkedList(){
		this.first_node = new Student();
		this.last_node = new Student();
		this.count = 0;
	}
	
	public int getCount() {  return this.count; }
	public Student getFirstNode(){ return this.first_node; }
	public Student getLastNode() { return this.last_node; }
	
	public void insertNode(Student student, int position){
		if(position == 1){
			
		}
		
	}
}
