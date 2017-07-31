package studentdataentry;

import java.io.File;

import javax.swing.JFileChooser;

public class DataEntry{
	
	
	public static File openFile(){
		JFileChooser my_chooser = new JFileChooser();
		File my_file = null;
		int ret_val = my_chooser.showOpenDialog(null);
		
		if(ret_val == JFileChooser.APPROVE_OPTION){
			my_file = my_chooser.getSelectedFile();
		}
		
		return my_file;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		openFile();
	}	
	
}
