import java.awt.EventQueue;

import javax.swing.JFrame;


public class Launcher extends JFrame{
   
	public Launcher(){
		
		setContentPane(new Address());
		setResizable(false);
		setTitle("Address Book");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run(){
				JFrame frame=new Launcher();
				frame.setSize(500,500);
				frame.setVisible(true);
			}
		});
		
	}
}
