import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Address extends JPanel{
	private JTextField tName, tAddress, tPhone, tEmail;
	private String name="", address="", email="";
	private long phone=-1;
	private int xb=100, yb=20,wb=90, hb=30;
	int spx=40; //space between button and textField
	int spy=20; //space between lines
	private int xt=xb+wb+spx, yt=20, wt=180, ht=30;
	private static final long serialVersionUID = -3017242459715155066L;
	public Address(){
		setBackground(Color.lightGray);
		setBorder(new EmptyBorder(5,5,5,5));
		setLayout(null);
		addComponents();
		
	}
	private void createButton(String s){
		JButton b=new JButton(s);
		b.setBounds(xb,yb,wb,hb);
		add(b);
	}
	private JTextField createText(){
		JTextField t=new JTextField();
		t.setBounds(xt,yt,wt,ht);
		add(t);
		return t;
		
	}
	private void nextLine(){
		yb+=hb+spy;
		yt+=ht+spy;
	}
	private void addComponents(){
		createButton("Nume");
		tName=createText();
		nextLine();
		createButton("Adresa");
		tAddress=createText();
		nextLine();
		createButton("Telefon");
		tPhone=createText();
		nextLine();
		createButton("Email");
		tEmail=createText();
		nextLine();
		JButton bSave=new JButton("Salveaza");
		int xs=xb+10, ys=yb+20;
        bSave.setBounds(xs,ys,120,50);
        bSave.setBackground(Color.darkGray);
        bSave.setOpaque(true);
        bSave.setForeground(Color.white);
        add(bSave);
        JButton bSearch=new JButton("Cauta");
		xs+=140;
        bSearch.setBounds(xs,ys,120,50);
        bSearch.setBackground(Color.darkGray);
        bSearch.setOpaque(true);
        bSearch.setForeground(Color.white);
        add(bSearch);
        //add functionality for buttons:
        bSave.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		save();
        	}
        });
	}
	public void save(){
		name=tName.getText();
		address=tAddress.getText();
		email=tEmail.getText();
		phone=0;
		String p=tPhone.getText();
		boolean w=true;
		try{
			phone=Integer.parseInt(p);
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Introduceti un telefon corect");
		}
		if(name.equals("")) { JOptionPane.showMessageDialog(null, "Introduceti un nume"); w=false;}
		if(p.length()<10) { JOptionPane.showMessageDialog(null, "Telefonul contine mai putin de 10 cifre"); w=false; }
		if(w) { JOptionPane.showMessageDialog(null, "Contact salvat"); clear(); }
		}
	public void clear(){
		tName.setText("");
		tAddress.setText("");
		tPhone.setText("");
		tEmail.setText("");
	}

}
