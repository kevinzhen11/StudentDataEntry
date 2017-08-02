package studentdataentry;

public class Student{
	private String name, major, id;
	private Student next_node, prev_node;
	
	public Student(){ }
	
	public Student(String name, String major, String id){
		this.name = new String(name);
		this.major = new String(major);
		this.id = new String(id);
		next_node = null;
		prev_node = null;
	}
	
	public String getName() { return this.name; }
	public String getMajor() { return this.major; }
	public String getID() { return this.id; }	
	public Student getNextNode() { return this.next_node; }
	public Student getPreviousNode() { return this.prev_node; }
	
	public void setName(String name) { this.name = name; }
	public void setMajor(String major) { this.major = major; }
	public void setID(String id) { this.id = id;}
	public void setNextNode(Student next) { this.next_node = next; }
	public void setPreviousNode(Student prev) { this.prev_node = prev; }
	
	public String toString(){
		return this.name + "\n Major: " + this.major + "\n Student ID: " 
	+ this.id;
	}

	public int compareTo(Student student){
		String str1 = this.name.toLowerCase();
		String str2 = student.getName().toLowerCase();
		int res = str1.compareTo(str2);
		if(res < 0) return -1;
		if(res > 0) return 1;
		return 0;
	}
	
}
