import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AddressBook implements ActionListener{
ArrayList personList;
Container pane;
JFrame frame;
JLabel jlbName, jlbAddress, jlbPhone, jlbEmail;
JTextField jtfName, jtfAddress, jtfPhone, jtfEmail;
JButton Save, Delete, Clear, Update, Search, Forward, Back;
String name, address, email;
int phone;
int recNr;
public AddressBook(){
	name="";
	address="";
	email="";
	phone=-1;
	recNr=-1;
	personList=new ArrayList(); 
	createGUI();
	}

	
public void createGUI(){
	frame=new JFrame("Address Book");
	pane=frame.getContentPane();
	pane.setLayout(new GridBagLayout());
	arrangeComp();
	frame.setSize(300,300);
	frame.setResizable(false);
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
}
//lots of repetitive code
public void arrangeComp(){
	jlbName=new JLabel("Name");
	jlbAddress=new JLabel("Address");
	jlbPhone=new JLabel("Phone");
	jlbEmail=new JLabel("Email");
	jtfName=new JTextField(20);
	jtfAddress=new JTextField(20);
	jtfPhone=new JTextField(20);
	jtfEmail=new JTextField(20);
	Save = new JButton("Save");
	Delete = new JButton("Delete");
	Clear = new JButton("Clear");
	Update = new JButton("Update");
	Search = new JButton("Search");
	Forward = new JButton(">>");
	Back = new JButton("<<"); 
	GridBagConstraints gbc1=new GridBagConstraints();
	gbc1.gridx=0;
	gbc1.gridy=0;
	gbc1.insets=new Insets(5,5,5,5);
	pane.add(jlbName,gbc1);
	GridBagConstraints gbc2=new GridBagConstraints();
	gbc2.gridx=1;
	gbc2.gridy=0;
	gbc2.gridwidth=2;
	gbc2.insets=new Insets(5,5,5,5);
	gbc2.fill=GridBagConstraints.BOTH;
	pane.add(jtfName,gbc2);
	GridBagConstraints gbc3=new GridBagConstraints();
	gbc3.gridx=0;
	gbc3.gridy=1;
	pane.add(jlbAddress,gbc3);
	GridBagConstraints gbc4=new GridBagConstraints();
	gbc4.gridx=1;
	gbc4.gridy=1;
	gbc4.gridwidth=2;
	gbc4.insets=new Insets(5,5,5,5);
	gbc4.fill=GridBagConstraints.BOTH;
	pane.add(jtfAddress,gbc4);
	GridBagConstraints gbc5=new GridBagConstraints();
	gbc5.gridx=0;
	gbc1.gridy=2;
	gbc1.insets=new Insets(5,5,5,5);
	pane.add(jlbPhone,gbc5);
	GridBagConstraints gbc6=new GridBagConstraints();
	gbc6.gridx=1;
	gbc6.gridy=2;
	gbc6.gridwidth=2;
	gbc6.insets=new Insets(5,5,5,5);
	gbc6.fill=GridBagConstraints.BOTH;
	pane.add(jtfPhone,gbc6);
	GridBagConstraints gbc7 = new GridBagConstraints();
	gbc7.gridx = 0;
	gbc7.insets = new Insets(5, 5, 5, 5);
	gbc7.gridy = 3;
	pane.add(jlbEmail, gbc7);
	GridBagConstraints gbc8 = new GridBagConstraints();
	gbc8.gridx = 1;
	gbc8.gridy = 3;
	gbc8.gridwidth = 2;
	gbc8.insets = new Insets(5, 5, 5, 5);
	gbc8.fill = GridBagConstraints.BOTH;
	pane.add(jtfEmail, gbc8);
	GridBagConstraints gbc9 = new GridBagConstraints();
	gbc9.gridx = 0;
	gbc9.gridy = 4;
	gbc9.insets = new Insets(5, 5, 5, 5);
	pane.add(Save, gbc9);
	GridBagConstraints gbc10 = new GridBagConstraints();
	gbc10.gridx = 1;
	gbc10.gridy = 4;
	gbc10.insets = new Insets(5, 5, 5, 5);
	pane.add(Delete, gbc10);
	GridBagConstraints gbc11 = new GridBagConstraints();
	gbc11.gridx = 2;
	gbc11.gridy = 4;
	gbc11.insets = new Insets(5, 5, 5, 5);
	pane.add(Update, gbc11);
	GridBagConstraints gbc12 = new GridBagConstraints();
	gbc12.gridx = 0;
	gbc12.gridy = 5;
	gbc12.insets = new Insets(5, 5, 5, 5);
	pane.add(Back, gbc12);
	GridBagConstraints gbc13 = new GridBagConstraints();
	gbc13.gridx = 1;
	gbc13.gridy = 5;
	gbc13.insets = new Insets(5, 5, 5, 5);
	pane.add(Search, gbc13);
	GridBagConstraints gbc14 = new GridBagConstraints();
	gbc14.gridx = 2;
	gbc14.gridy = 5;
	gbc14.insets = new Insets(5, 5, 5, 5);
	pane.add(Forward, gbc14);
	GridBagConstraints gbc15 = new GridBagConstraints();
	gbc15.gridx = 1;
	gbc15.insets = new Insets(5, 5, 5, 5);
	gbc15.gridy = 6;
	pane.add(Clear, gbc15);
	Save.addActionListener(this);
	Delete.addActionListener(this);
	Update.addActionListener(this);
	Search.addActionListener(this);
	Forward.addActionListener(this);
	Back.addActionListener(this);
	Clear.addActionListener(this);
}
public void actionPerformed(ActionEvent e){
 if(e.getSource()==Save){
	 savePerson();
	 clear();
 }
 else if(e.getSource()==Delete){
	 deletePerson();
	 clear();
 }
 else if(e.getSource()==Update){
	 updatePerson();
	 clear();
 }
 else if(e.getSource()==Search){
	 searchPerson();
	 clear();
 }
 else  if(e.getSource()==Forward){
	 next();
	 clear();
 }
 else  if(e.getSource()==Back){
	 previous();
	 clear();
 }
 else  if(e.getSource()==Clear){
	 clear();
 }
}
public void savePerson(){
	name=jtfName.getText();
	name=name.toUpperCase();
	address=jtfAddress.getText();
	try{
		phone=Integer.parseInt(jtfPhone.getText());
	}
	catch(Exception e) {
		JOptionPane.showMessageDialog(null, "Please enter a valid phone number");
	}
	email=jtfEmail.getText();
	if(name.equals("")){
		JOptionPane.showMessageDialog(null, "Please enter person name");
	}
	else
	{
		Person person=new Person(name,address,phone,email);
		//pd.savePerson(person);
		JOptionPane.showMessageDialog(null, "Person Saved");
	}
}
public void deletePerson(){
	
}
public void updatePerson(){
	
}
public void searchPerson(){
	
}
public void next(){
	
}
public void previous() {
	
}
public void clear(){

		jtfName.setText("");
		jtfAddress.setText("");
		jtfPhone.setText("");
		jtfEmail.setText("");
		recNr = -1;
		personList.clear();
		Forward.setEnabled(true);
		Back.setEnabled(true);
	
}
public static void main(String[] args) {
    new AddressBook();
}

}
