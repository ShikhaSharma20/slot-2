package first.slot2jdbc;

public class hrDao {

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.Statement;

	import first.slot2jdbc.hrEmployes;

	public class hrDao {
		Connection con=null;
		// Here we connect our program with database
		public void connect()throws Exception {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/company","root","Mukul@321");	
			
		}
		 public int addEmploye(hrEmployes b1)throws Exception {
			                                            // Here we we perform operations related to addition of employee
			    String query = "select * from employes where eName = '"+b1.eName+"'";
		    	Statement stm = con.createStatement();
				ResultSet set = stm.executeQuery(query);
			if(set.next()) {
					return -1;
				}
			else {	
		       	String query2="insert into employes(eName,eDomain,eLocation,eSal,ePhone) values(?,?,?,?,?)";
			    PreparedStatement pst=con.prepareStatement(query2); 
			    pst.setString(1,b1.eName);              //  we enter name of the employe's at 1st column in the  database
			    pst.setString(2, b1.eDomain);           // we enter Domain of the employe's at 2st column in the database
		    	pst.setString(3, b1.eLocation);         //  we enter Location of the employe's at 3rd column in  the database
		     	pst.setInt   (4, b1.eSalary);           //  we enter salary of the employe's at 4th column in the database
			    pst.setString(5, b1.ePhone);            //  we enter phone number of the employe's at 5th column in the database
			                                       
			int count=pst.executeUpdate();              //  we update all informations of user into the database
			return count;
			
	     	}}
		    public int removeEmploye(int eId)throws Exception{
				                                    
			                                            //  we we perform operations to remove employee
			    Statement stm = con.createStatement();
				ResultSet set = stm.executeQuery("select * from employes where eId="+eId);
			if(set.next()) {
			    set.close();	
				Statement Deletestm = con.createStatement();
				Deletestm.executeUpdate("DELETE FROM employes WHERE eId="+eId);
				return 1;
				}
				else {
					return 0;}
				                                       
			}
			                                            //  we we performing  operations  to hike to employee
		    public int hikeToEmploye(int eId,int hike)throws Exception{
				
			    Statement ps = con.createStatement();
				ResultSet set = ps.executeQuery("select * from employes where eId ="+eId);
			if(set.next()) {
				Statement hikeStm = con.createStatement();
				int salary = set.getInt(5);
			    salary = salary+((salary*hike)/100);
			    hikeStm.executeUpdate("update employes set eSal = "+salary+" where eId ="+eId);
			    return salary;
				}
				
			else 
			    return 0;
			}
		
			}