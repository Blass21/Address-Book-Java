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
import javax.swing.JPanel;
import javax.swing.JTextField;


public class AddressBookGUI extends JPanel implements ActionListener{
ArrayList personList;
JLabel jlbName, jlbAddress, jlbPhone, jlbEmail;
JTextField jtfName, jtfAddress, jtfPhone, jtfEmail;
JButton Save, Delete, Clear, Update, Search, Forward, Back, Exit;
String name, address, email;
int phone;
int recNr;
public AddressBookGUI(){
	name="";
	address="";
	email="";
	phone=-1;
	recNr=-1;
	personList=new ArrayList();
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
	add(jlbName,gbc1);
	GridBagConstraints gbc2=new GridBagConstraints();
	gbc2.gridx=1;
	gbc2.gridy=0;
	gbc2.gridwidth=2;
	gbc2.insets=new Insets(5,5,5,5);
	gbc2.fill=GridBagConstraints.BOTH;
	add(jtfName,gbc2);
	GridBagConstraints gbc3=new GridBagConstraints();
	gbc3.gridx=0;
	gbc3.gridy=1;
	add(jlbAddress,gbc3);
	GridBagConstraints gbc4=new GridBagConstraints();
	gbc4.gridx=1;
	gbc4.gridy=1;
	gbc4.gridwidth=2;
	gbc4.insets=new Insets(5,5,5,5);
	gbc4.fill=GridBagConstraints.BOTH;
	add(jtfAddress,gbc4);
	GridBagConstraints gbc5=new GridBagConstraints();
	gbc5.gridx=0;
	gbc1.gridy=2;
	gbc1.insets=new Insets(5,5,5,5);
	add(jlbPhone,gbc5);
	GridBagConstraints gbc6=new GridBagConstraints();
	gbc6.gridx=1;
	gbc6.gridy=2;
	gbc6.gridwidth=2;
	gbc6.insets=new Insets(5,5,5,5);
	gbc6.fill=GridBagConstraints.BOTH;
	add(jtfPhone,gbc6);
	GridBagConstraints gbc7 = new GridBagConstraints();
	gbc7.gridx = 0;
	gbc7.insets = new Insets(5, 5, 5, 5);
	gbc7.gridy = 3;
	add(jlbEmail, gbc7);
	GridBagConstraints gbc8 = new GridBagConstraints();
	gbc8.gridx = 1;
	gbc8.gridy = 3;
	gbc8.gridwidth = 2;
	gbc8.insets = new Insets(5, 5, 5, 5);
	gbc8.fill = GridBagConstraints.BOTH;
	add(jtfEmail, gbc8);
	GridBagConstraints gbc9 = new GridBagConstraints();
	gbc9.gridx = 0;
	gbc9.gridy = 4;
	gbc9.insets = new Insets(5, 5, 5, 5);
	add(Save, gbc9);
	GridBagConstraints gbc10 = new GridBagConstraints();
	gbc10.gridx = 1;
	gbc10.gridy = 4;
	gbc10.insets = new Insets(5, 5, 5, 5);
	add(Delete, gbc10);
	GridBagConstraints gbc11 = new GridBagConstraints();
	gbc11.gridx = 2;
	gbc11.gridy = 4;
	gbc11.insets = new Insets(5, 5, 5, 5);
	add(Update, gbc11);
	GridBagConstraints gbc12 = new GridBagConstraints();
	gbc12.gridx = 0;
	gbc12.gridy = 5;
	gbc12.insets = new Insets(5, 5, 5, 5);
	add(Back, gbc12);
	GridBagConstraints gbc13 = new GridBagConstraints();
	gbc13.gridx = 1;
	gbc13.gridy = 5;
	gbc13.insets = new Insets(5, 5, 5, 5);
	add(Search, gbc13);
	GridBagConstraints gbc14 = new GridBagConstraints();
	gbc14.gridx = 2;
	gbc14.gridy = 5;
	gbc14.insets = new Insets(5, 5, 5, 5);
	add(Forward, gbc14);
	GridBagConstraints gbc15 = new GridBagConstraints();
	gbc15.gridx = 1;
	gbc15.insets = new Insets(5, 5, 5, 5);
	gbc15.gridy = 6;
	add(Clear, gbc15);
	
}
public static void createGUI(){
	JFrame frame=new JFrame("Address Book");
	frame.setSize(300,300);
	frame.setResizable(false);;
	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	AddressBookGUI content=new AddressBookGUI();
	content.setLayout(new GridBagLayout());
	frame.add(content);
	
}
public void actionPerformed(ActionEvent e){

}
public static void main(String[] args) {
    //Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            createGUI(); 
        }
    });
}
}
