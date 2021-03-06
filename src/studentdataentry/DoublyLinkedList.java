package studentdataentry;

public class DoublyLinkedList {
	private int count;
	private Student first_node, last_node;
	
	public DoublyLinkedList(){
		this.first_node = null;
		this.last_node = null;
		this.count = 0;
	}
	
	public int getCount() {  return this.count; }
	public Student getFirstNode(){ return this.first_node; }
	public Student getLastNode() { return this.last_node; }
	
	public void insertNode(Student student){
		Student prev_node = null;
		Student curr_node = this.first_node;

		while(curr_node != null && student.compareTo(curr_node) >= 0){
			prev_node = curr_node;
			curr_node = curr_node.getNextNode();
		}
		if(prev_node == null){
			this.first_node = student;
			this.first_node.setNextNode(curr_node);
			if(curr_node != null) {
				curr_node.setPreviousNode(this.first_node);
			}
		}
		else{
			prev_node.setNextNode(student);	
			student.setPreviousNode(prev_node);
			student.setNextNode(curr_node);
			if(curr_node != null){
				curr_node.setPreviousNode(student);
			}
		}
		
		
		this.count += 1;
	}
	
	public Student searchNode(String name){
		Student curr_node = this.first_node;
		Student final_node = null;
		while(curr_node != null){
			if(curr_node.getName().toLowerCase().equals(name.toLowerCase())){
				System.out.println("LAST NAME " + curr_node.getName() + " FOUND");
				final_node = curr_node;
				break;
			}
			curr_node = curr_node.getNextNode();
		}
		if(final_node == null) System.out.println("LAST NAME NOT FOUND");
		return final_node;
	}
	
	public Student deleteNode(String name){
		Student curr_node = this.first_node;
		Student next_node, prev_node;
		boolean isFound = false;
		while(curr_node != null){
			if(curr_node.getName().toLowerCase().equals(name.toLowerCase())){
				next_node = curr_node.getNextNode();
				prev_node = curr_node.getPreviousNode();
				if(prev_node != null) {
					next_node.setPreviousNode(prev_node);	
				}
				else {
					curr_node = next_node;
				}
				if(next_node == null) {
					prev_node.setNextNode(null);
				}
				else {
					prev_node.setNextNode(next_node);
				}
				isFound = true;
				this.count -= 1;
				break;
			}
			curr_node = curr_node.getNextNode();
		}
		
		return curr_node;
	}
	
	public String toString(){
		String str = "";
		int count = 1;
		Student curr_node = this.first_node;
		while(curr_node != null){
			// [ George / Computer Science / 01 ] -- [ ]
			str += "[ ";
			str += curr_node.toString();
			str += " ] -- \n";
			/*
			if(curr_node.getPreviousNode() != null){
				str += "\nPREVIOUS NODE: " + curr_node.getPreviousNode().getName();
			}
			if(curr_node.getNextNode() != null){
				str += "\nNEXT NODE: " + curr_node.getNextNode().getName();
			}
			*/
			curr_node = curr_node.getNextNode();
			count += 1;
		}
		return str;
	}
	
}
