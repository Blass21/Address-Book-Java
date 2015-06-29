import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


public class PersonDatab {
private Connection con;
private String url;
private ArrayList<PersonInfo> plist;
public PersonDatab(String file){
	plist=new ArrayList<PersonInfo>();
	url="jdbc:ucanaccess://";
	url+=System.getProperty("user.home");
	url+=System.getProperty("file.separator")+"Desktop"+System.getProperty("file.separator")+file;
	System.out.println(url);
	getConnection(url);
}
private Connection getConnection(String url){
	try{
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	}
	catch(java.lang.ClassNotFoundException e){
		System.err.println("ClassNotFoundException: "+e.getMessage());
	}
	try{
		con=DriverManager.getConnection(url);
	}
	catch(SQLException ex){
		System.err.println("SQLException: "+ex.getMessage());
	}
	return con;
}
protected void saveP(PersonInfo p){
	try{
		String sql="INSERT INTO Person(name,address, phone, email) VALUES (?,?,?,?)";
	    PreparedStatement ps=con.prepareStatement(sql);
	    ps.setString(1, p.getName());
	    ps.setString(2, p.getAddress());
	    ps.setString(3, p.getPhone());
	    ps.setString(4, p.getEmail());
	    ps.executeUpdate();
	}
	catch(Exception e){
		System.out.println(e);
	}
	
}
protected ArrayList<PersonInfo> searchP(String n){
	try{
		String sql="Select * FROM Person WHERE name LIKE '%"+n+"%'";
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery(sql);
		String name="", address="", email="", phone="";
		while(rs.next()){
			name=rs.getString("name");
			address=rs.getString("address");
			phone=rs.getString("phone");
			email=rs.getString("email");
			PersonInfo person=new PersonInfo(name,address,phone,email);
			plist.add(person);
			
	
		}
		
	}
	catch(Exception e){
		System.out.println(e.getMessage());
	}
	PersonInfo p2=new PersonInfo("x","y","c","a");
	plist.add(p2);
	PersonInfo p3=new PersonInfo("sd","q","l","f");
	plist.add(p3);
	return plist;
	
}
}
