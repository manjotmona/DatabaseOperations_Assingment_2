/**
 * Created by pallavi on 6/1/18.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DBoperations {
  /**
   * This is the main class.
   */
  public static void main(String []args) {
    char choice;
    Scanner scan = new Scanner(System.in);
    do {
      System.out.print("a. Write Operations in Table\n");
      System.out.print("b. Read all Operations from Table\n");
      System.out.print("c. Read specific Operation from Table\n");
      System.out.print("d. Exit\n\n");
      System.out.print("Enter Your Choice : ");
      choice = scan.next().charAt(0);
      switch (choice) {
        case 'a' :
          Write wr = new Write();
          wr.write_method();
          break;
        case 'b' :
          System.out.println("Selecting all Database Entries:");
          try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/calculator","root","root");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from operations");
            while (rs.next()) {
              System.out.println(
                  rs.getInt(1) + "  " + rs.getTime(2) + "  " + rs.getInt(3) + "  " + rs.getInt(4)
                      + "  " + rs.getString(5) + "  " + rs.getInt(6));
            }
            con.close();
          } catch (Exception e) {
            System.out.println(e);
          }
          break;
        case 'c' :
          System.out.println("Enter Operator:");
          String op = scan.next();
          try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/calculator","root","root");
            PreparedStatement statement
                = con.prepareStatement("select * from operations where operator = ?");
            statement.setString(1, op);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
              System.out.println(
                  rs.getInt(1) + "  " + rs.getTime(2) + "  " + rs.getInt(3) + "  " + rs.getInt(4)
                      + "  " + rs.getString(5) + "  " + rs.getInt(6));
            }
            con.close();
          } catch (Exception e) {
            System.out.println(e);
          }
          break;
        case 'd' :
          System.exit(0);
          break;
        default :
          System.out.print("Wrong Choice!!!");
          break;
      }
      System.out.print("\n---------------------------------------\n");
    } while (choice != 'd');
  }
}
