package first.slot2jdbc;

package first.slot2jdbc;

import static java.lang.System.out;

import java.util.Scanner;

import first.slot2jdbc.hrEmployes;
import first.slot2jdbc.hrDao;

public class hrMain {

	public static void main(String[] args) throws Exception {
		
		Scanner PS=new Scanner(System.in);                    // Here we create Scanner object as PS
		hrDao dao=new hrDao();
		hrEmployes b1=new hrEmployes();
		out.println("\t\t\t\t------WELCOME TO HR MANAGMENT SYSTEM ------");
		out.println("**Please Select Operation : \nPRESS :1 FOR ADD EMPLOYE  \nPRESS :2 FOR REMOVE EMPLOYE \nPRESS :3 FOR GIVE HIKE TO EMPLOYE ");
		int op=PS.nextInt();
	
        // Here we perform operations related to add employee
	 switch(op) {
     case 1->{
        out.println(" ---Please enter employe details to ADD EMPLOYE--- ");
        out.print("Enter Employe's Name : ");
            String eName=PS.next();                           // Here we read employe's name from HR
        out.print("Enter employes's Domain : ");
            String eDomain=PS.next();                         // Here we read user's Domain from HR
        out.print("Enter employes's Location : ");
            String eLocation=PS.next();                       // Here we read user's Location from HR
        out.print("Enter employes's Salary : ");
            int esalary=PS.nextInt();                         // Here we read user's Salary from HR
        out.print("Enter  employes's PhoneNumber : ");  
            String ePhone=PS.next();                          // Here we read user's phone number from HR
                                        
               
         b1.eName=eName;
         b1.eDomain=eDomain;
         b1.eLocation=eLocation;
         b1.eSalary=esalary;
         b1.ePhone=ePhone;


        dao.connect();                                         // Here we connect our program from database
        int res=dao.addEmploye(b1);
    if(res==1) {
        out.println("\t\t\t-----Employe added successfully-----");
               }
    else {
        out.println("\t\t\t------EMPLOYE ALREADY EXIST------");
         }
		 }
     
     // Here we perform operations related to Remove employee
    case 2->{
	    dao.connect();
	    out.println("\t\t\t-------Enter users Id------");
	    int eId=PS.nextInt();
	    int result=dao.removeEmploye(eId);
	if(result==1)
		out.println("\t\t\t------Employe Removed successfully------");
	else
		out.println("\t\t\t-------EMPLOYE DOES NOT EXIST------");
		}
    
    // Here we perform operations related to Give Hike to the employee
    case 3->{
	    dao.connect();
	    int amt,id;
		out.print("\nEnter Employe's Id  : ");
		id = PS.nextInt();
		out.print("Enter Percentage for Salary Hike : ");
		amt =PS.nextInt();
		int ret = dao.hikeToEmploye(id,amt);
	if(ret>0)
		out.println("\nUpdated Salary of Employe : "+ret);	
	else
		out.println("\nEmploye does not Exist");	   
		}
		}}}