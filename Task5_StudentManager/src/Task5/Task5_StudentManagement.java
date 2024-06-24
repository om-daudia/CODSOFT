
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
import static javafx.application.Platform.exit;




import java.util.Scanner;
import static javafx.application.Platform.exit;
import java.sql.*;

class Student {

    Connection con;     //Connection object declaration
    Scanner sc = new Scanner(System.in);

    //Student Constructor used to connect Database
    Student() {
        try {
            //load the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //connect database
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "admin#mysql");

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    //Insert Record
    protected void Add_Student() {

        try {
            //Insert query
            String qry_insert = "insert into student_tab(s_rollno, s_name, s_std, s_contact, s_address) values(?,?,?,?,?)";

            PreparedStatement st_insert = con.prepareStatement(qry_insert);

            //Get values from user
            System.out.print("Enter Student Roll No. : ");
            int roll = Integer.parseInt(sc.nextLine());
            System.out.print("Enter Student Name : ");
            String name = sc.nextLine();
            System.out.print("Enter Student Standard : ");
            int std = Integer.parseInt(sc.nextLine());
            System.out.print("Enter Student Contact Number : ");
            String con = sc.nextLine();
            System.out.print("Enter Student Address : ");
            String add = sc.nextLine();

            //set values
            st_insert.setInt(1, roll);
            st_insert.setString(2, name);
            st_insert.setInt(3, std);
            st_insert.setString(4, con);
            st_insert.setString(5, add);

            st_insert.executeUpdate();      //Execute

            System.out.println("\n---------Record Inserted----------------");

        } catch (Exception e) {
            System.out.println("Insert ERROR : " + e.toString());
        }
    }

    //Update Record
    //Update Record Based On Student Id and Student Name
    protected void Update_Student() {
        try {
            //Update query
            String qry_update = "update student_tab set s_name = ?, s_std = ?, s_contact = ?, s_address = ? where s_rollno = ? and s_Id = ?";

            PreparedStatement st_update = con.prepareStatement(qry_update);

            //Get values from user
            System.out.print("Enter Student ID. : ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Enter Student Roll No. : ");
            int roll = Integer.parseInt(sc.nextLine());
            System.out.print("Enter Student Name : ");
            String name = sc.nextLine();
            System.out.print("Enter Student Standard : ");
            int std = Integer.parseInt(sc.nextLine());
            System.out.print("Enter Student Contact Number : ");
            String con = sc.nextLine();
            System.out.print("Enter Student Address : ");
            String add = sc.nextLine();

            //set values
            st_update.setString(1, name);
            st_update.setInt(2, std);
            st_update.setString(3, con);
            st_update.setString(4, add);
            st_update.setInt(5, roll);
            st_update.setInt(6, id);

            st_update.executeUpdate();      //Execute

            System.out.println("Record Updated");

        } catch (Exception e) {
            System.out.println("Update ERROR : " + e.toString());
        }
    }

    //Remove Student
    //Delete Record Based On Student Id and Student Name
    protected void Delete_Student() {
        try {
            //Delete query           
            String qry_Del = "delete from student_tab where s_Id = ? and s_name = ?";

            PreparedStatement st_Del = con.prepareStatement(qry_Del);

            //Get values from user
            System.out.print("Enter Student ID. : ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Enter Student Name : ");
            String name = sc.nextLine();

            //set values
            st_Del.setInt(1, id);
            st_Del.setString(2, name);

            st_Del.executeUpdate();     //Execute

            System.out.println("Record Deleted");

        } catch (Exception e) {
            System.out.println("Delete ERROR : " + e.toString());
        }
    }

    //Searching Student 
    protected void Search_Student() {
        try {
            //select query
            String qry_Search = "select * from student_tab where s_Id = ? and s_name = ?";

            PreparedStatement st_Search = con.prepareStatement(qry_Search);

            //Get values from user
            System.out.print("Enter Student ID. : ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.print("Enter Student Name : ");
            String name = sc.nextLine();

            st_Search.setInt(1, id);
            st_Search.setString(2, name);

            ResultSet set = st_Search.executeQuery();

            if (set.next() == true) {
                System.out.println(set.getInt(1) + "|" + set.getInt(2) + "|" + set.getString(3) + "|" + set.getInt(4) + "|" + set.getString(5) + "|" + set.getString(6));
            } else {
                System.out.println("This Name Of Student Does Not Exists");
            }
        } catch (Exception e) {
            System.out.println("Searching ERROR : " + e.toString());
        }
    }

    //Display All Student Details
    protected void display() {
        try {
            //select query
            String qry_dis = "select * from student_tab";

            Statement st_dis = con.createStatement();
            ResultSet set = st_dis.executeQuery(qry_dis);

            while (set.next()) {
                System.out.println(set.getInt(1) + " | " + set.getInt(2) + " | " + set.getString(3) + " | " + set.getInt(4) + " | " + set.getString(5) + " | " + set.getString(6));
            }
        } catch (Exception e) {
            System.out.println("Display ERROR : " + e.toString());
        }
    }

}

public class Task5_StudentManagement {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sel;
        
        //creating object of Student class which have all the methods 
        Student stud = new Student();
        
        //Infinite while loop for menu
        while (true) {
            System.out.println("1 : Add Student \n 2 : Update Data \n 3 : Remove Student \n 4 : Search Student \n 5 : Display All Student Ditails \n 6 : EXIT");
            System.out.print("Enter Your Option : ");
            sel = Integer.parseInt(sc.nextLine());

            switch (sel) {
                case 1:     //case 1 for Add Student Record
                    stud.Add_Student();
                    break;

                case 2:     //case 2 for Modify Student Record
                    stud.Update_Student();
                    break;

                case 3:     //case 3 for Remove Student Record
                    stud.Delete_Student();
                    break;

                case 4:     //case 4 for Searcing Student Record
                    stud.Search_Student();
                    break;

                case 5:     //ase 5 for Display All Student Records
                    stud.display();
                    break;

                case 6:     //case 6 for Terminate The Program
                    exit();     
                    break;
            }
        }
    }
}
