import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Address extends JPanel{
	private JTextField tName, tAddress, tPhone, tEmail;
	private String name, address, email, phone;
	private String file;
	private int gxb=0, gyb=0;
	private int gxt=1, gyt=0;
	private static final long serialVersionUID = -3017242459715155066L;
	private PersonDatab pd;
	private ArrayList personList;
	public Address(){
		name="";
		address="";
		email="";
		phone="";
		file="contacts.accdb";
		pd=new PersonDatab(file);
		personList=new ArrayList();
		setBackground(Color.gray);
		setBorder(new EmptyBorder(30,10,30,10));
		setLayout(new GridBagLayout());
		addComponents();
		
	}
	private void createButton(String s){
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.gridx=gxb;
		gbc.gridy=gyb;
		gbc.insets=new Insets(5,5,5,5);
		JButton b=new JButton(s);
		add(b,gbc);
		gyb++;
	}
	private JTextField createText(){
		JTextField t=new JTextField(20);
		GridBagConstraints gbc=new GridBagConstraints();
	    gbc.gridx=gxt;
	    gbc.gridy=gyt;
	    gbc.insets=new Insets(5,5,5,5);
	    gbc.gridwidth=2;
	    gbc.fill=GridBagConstraints.HORIZONTAL;
	    add(t,gbc);
	    gyt++;
		return t;
		
	}

	private void addComponents(){
		createButton("Nume");
		tName=createText();
	
		createButton("Adresa");
		tAddress=createText();
		
		createButton("Telefon");
		tPhone=createText();
	
		createButton("Email");
		tEmail=createText();
		
		JButton bSave=new JButton("Salveaza");
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.gridy=++gyb;
		gbc.gridx=1;
        add(bSave,gbc);
        
        JButton bSearch=new JButton("Cauta nume");
        GridBagConstraints gbc2=new GridBagConstraints();
        gbc2.gridy=gyb;
        gbc2.gridx=2;
		add(bSearch,gbc2);

		JButton bUpdate=new JButton("Update");
        GridBagConstraints gbc3=new GridBagConstraints();
        gbc3.gridy=gyb;
        gbc3.gridx=3;
		add(bUpdate,gbc3);
		
        //add functionality for buttons:
       bSave.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		save();
        	}
        }); 
       bSearch.addActionListener(new ActionListener(){
       	public void actionPerformed(ActionEvent e){
       		search();
       	}
       }); 
	}
	public void save(){
		name=tName.getText();
		name=name.toUpperCase();
		address=tAddress.getText();
		email=tEmail.getText();
		phone=tPhone.getText();
		boolean w=true;
		try{
			long nr=Long.parseLong(phone);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Introduceti un telefon corect");
			
		}
		if(name.equals("")) { JOptionPane.showMessageDialog(null, "Introduceti un nume"); w=false;}
		if(phone.length()<10&&!phone.equals("")) { JOptionPane.showMessageDialog(null, "Telefonul contine mai putin de 10 cifre"); w=false; }
		if(w){ PersonInfo p=new PersonInfo(name,address,phone,email); pd.saveP(p); clear(); } 
		}
	public void search(){
		name=tName.getText();
		name=name.toUpperCase();
		if(name.equals("")) { JOptionPane.showMessageDialog(null, "Introduceti un nume pentru a cauta"); }
		else { personList.clear();  personList=pd.searchP(name); 
		Object[] selectionValues=personList.toArray();
		PersonInfo p0=(PersonInfo) personList.get(0);
		Object selection=JOptionPane.showInputDialog(null,"Rezultatele cautarii:","Agenda",JOptionPane.QUESTION_MESSAGE,null, selectionValues,p0);
		PersonInfo sel=(PersonInfo) selection;
		System.out.println(sel);
		tName.setText(sel.getName());
		tAddress.setText(sel.getAddress());
		tPhone.setText(sel.getPhone());
		tEmail.setText(sel.getEmail());
		}
	}
	public void clear(){
		tName.setText("");
		tAddress.setText("");
		tPhone.setText("");
		tEmail.setText("");
	}

}
