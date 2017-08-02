package studentdataentry;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DataEntry extends JFrame{
	
	DoublyLinkedList list = new DoublyLinkedList();
	public static File openFile(){
		JFileChooser my_chooser = new JFileChooser();
		File my_file = null;
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV FILES", "csv");
		my_chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		my_chooser.setFileFilter(filter);
		int ret_val = my_chooser.showOpenDialog(null);
		if(ret_val == JFileChooser.APPROVE_OPTION){
			my_file = my_chooser.getSelectedFile();
			System.out.println("Selected file: " + my_file.getAbsolutePath());
		}
		return my_file;
	}
	
	public static DoublyLinkedList readFile(File finp) throws FileNotFoundException{
		DoublyLinkedList list = new DoublyLinkedList();
		Scanner my_scanner = new Scanner(finp);
		String curr_line;
		String[] line_split = new String[3];
		while(my_scanner.hasNext()){
			curr_line = my_scanner.next();
			line_split = curr_line.split(",");
			list.insertNode(new Student(line_split[0], line_split[1], line_split[2]));
		}
		return list;
	}

	public DataEntry(){
		setTitle("Data Entry Program");
		setSize(400,400);
		JPanel panel = new JPanel();
		JButton open_button = new JButton("Open File");
		JButton add_button = new JButton("Add Student");
		JButton search_button = new JButton("Search Student");
		JButton del_button = new JButton("Delete Student");
		JButton print_button = new JButton("Print all Student Records");
		
		add_button.setEnabled(false);
		search_button.setEnabled(false);
		del_button.setEnabled(false);
		print_button.setEnabled(false);
		
		open_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				File finp = openFile();
				try {
					list = readFile(finp);
					//System.out.println(list.toString());
					add_button.setEnabled(true);
					search_button.setEnabled(true);
					del_button.setEnabled(true);
					print_button.setEnabled(true);
				} catch (FileNotFoundException e1) {
					System.out.println("File cannot be opened.");
				}
			}
		} );
		
		add_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String str1 = JOptionPane.showInputDialog("Enter the new student name: ", "");
				String str2 = JOptionPane.showInputDialog("Enter the new student major: ", "");
				String str3 = JOptionPane.showInputDialog("Enter the new student ID: ", "");
				Student n = new Student(str1,str2,str3);
				list.insertNode(n);
				JOptionPane.showMessageDialog(panel, "\nNew Student Added" + n.toString());
				System.out.println(list.toString());
			}
		} );
		
		search_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String str1 = JOptionPane.showInputDialog("Enter the new student name you wish to search for: ", "");
				Student res = list.searchNode(str1);
				if(res != null) JOptionPane.showMessageDialog(panel, "Student was found!");
				else JOptionPane.showMessageDialog(panel, "Student was not found.");
				
			}
		});
		
		del_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				String str1 = JOptionPane.showInputDialog("Enter the new student name you wish to delete: ", "");
				Student res = list.deleteNode(str1);
				if(res != null) JOptionPane.showMessageDialog(panel, "The following student record was deleted:\n " + res.toString());
				else JOptionPane.showMessageDialog(panel, "Error in deleting the requested student.");
			}
		});
		
		print_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				JPanel p = new JPanel();
				JTextArea area = new JTextArea(list.toString());
				area.setFont(new Font("Arial", Font.BOLD, 18));
				
				area.setEditable(false);
				JScrollPane s = new JScrollPane(area);
				s.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
				p.add(s);
				JFrame frame = new JFrame();
				frame.add(p);
				frame.pack();
				frame.setVisible(true);
			}
		});
		
		
		panel.add(open_button);
		panel.add(add_button);
		panel.add(search_button);
		panel.add(del_button);
		panel.add(print_button);
		this.getContentPane().add(panel);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		DataEntry d = new DataEntry();
	}	
	
}
