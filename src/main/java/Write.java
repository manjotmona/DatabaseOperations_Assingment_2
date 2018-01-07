

/**
 * Created by manjot on 6/1/18.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class Write {
  Connection conn = null;
  Statement stmt = null;

  public java.sql.Time getCurrentTimeStamp() {
    java.util.Date today = new java.util.Date();
    return new java.sql.Time(today.getTime());
  }

  /**
   * This method Writes ioerations in Database.
   */
  public void write_method() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/calculator", "root", "root");
    } catch (Exception e) {
      System.out.println(e);
    }
    int num1;
    int num2;
    int res;
    char choice;
    Scanner scan = new Scanner(System.in);
    do {
      System.out.print("a. Addition\n");
      System.out.print("b. Subtraction\n");
      System.out.print("c. Multiplication\n");
      System.out.print("d. Division\n");
      System.out.print("e. Power\n");
      System.out.print("f. Absolute\n");
      System.out.print("g. Modulus\n");
      System.out.print("h. Maximum of 2 numbers\n");
      System.out.print("i. Minimum of 2 numbers\n");
      System.out.print("j. Exit\n\n");
      System.out.print("Enter Your Choice : ");
      choice = scan.next().charAt(0);
      switch (choice) {
        case 'a' : System.out.print("Enter Two Number : ");
          num1 = scan.nextInt();
          num2 = scan.nextInt();
          res = num1 + num2;
          try {
            String insertTablesql = "INSERT INTO operations"
                + "(timestamp, left_operand, right_operand, operator, result) VALUES"
                + "(?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertTablesql);
            preparedStatement.setTime(1,getCurrentTimeStamp());
            preparedStatement.setInt(2,num1);
            preparedStatement.setInt(3,num2);
            preparedStatement.setString(4, "Addition");
            preparedStatement.setInt(5,res);
            preparedStatement .executeUpdate();
          } catch (Exception e) {
            System.out.println(e);
          }
          System.out.print("Result = " + res);
          System.out.print("Adiition Entry added in operation table");
          break;
        case 'b' :
          System.out.print("Enter Two Number : ");
          num1 = scan.nextInt();
          num2 = scan.nextInt();
          res = num1 - num2;
          try {
            String insertTablesql = "INSERT INTO operations"
                + "(timestamp, left_operand, right_operand, operator, result) VALUES"
                + "(?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertTablesql);
            preparedStatement.setTime(1,getCurrentTimeStamp());
            preparedStatement.setInt(2,num1);
            preparedStatement.setInt(3,num2);
            preparedStatement.setString(4, "Subtraction");
            preparedStatement.setInt(5,res);
            preparedStatement .executeUpdate();
          } catch (Exception e) {
            System.out.println(e);
          }
          System.out.print("Result = " + res);
          System.out.print("One Subtraction Entry added in operation table");
          break;
        case 'c' :
          System.out.print("Enter Two Number : ");
          num1 = scan.nextInt();
          num2 = scan.nextInt();
          res = num1 * num2;
          try {
            String insertTablesql = "INSERT INTO operations"
                + "(timestamp, left_operand, right_operand, operator, result) VALUES"
                + "(?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertTablesql);
            preparedStatement.setTime(1,getCurrentTimeStamp());
            preparedStatement.setInt(2,num1);
            preparedStatement.setInt(3,num2);
            preparedStatement.setString(4, "Multiplication");
            preparedStatement.setInt(5,res);
            preparedStatement .executeUpdate();
          } catch (Exception e) {
            System.out.println(e);
          }
          System.out.print("Result = " + res);
          System.out.print("One Multiplication Entry added in operation table");
          break;
        case 'd' :
          System.out.print("Enter Two Number : ");
          num1 = scan.nextInt();
          num2 = scan.nextInt();
          res = num1 / num2;
          try {
            String insertTablesql = "INSERT INTO operations"
                + "(timestamp, left_operand, right_operand, operator, result) VALUES"
                + "(?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertTablesql);
            preparedStatement.setTime(1,getCurrentTimeStamp());
            preparedStatement.setInt(2,num1);
            preparedStatement.setInt(3,num2);
            preparedStatement.setString(4, "");
            preparedStatement.setString(4, "Division");
            preparedStatement.setInt(5,res);
            preparedStatement .executeUpdate();
          } catch (Exception e) {
            System.out.println(e);
          }
          System.out.print("Result = " + res);
          System.out.print("One Division Entry added in operation table");
          break;
        case 'e' :
          System.out.print("Enter Two Number : ");
          num1 = scan.nextInt();
          num2 = scan.nextInt();
          res = (int)Math.pow((double)num1,(double)num2);
          try {
            String insertTablesql = "INSERT INTO operations"
                + "(timestamp, left_operand, right_operand, operator, result) VALUES"
                + "(?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertTablesql);
            preparedStatement.setTime(1,getCurrentTimeStamp());
            preparedStatement.setInt(2,num1);
            preparedStatement.setInt(3,num2);
            preparedStatement.setString(4, "Power");
            preparedStatement.setInt(5,res);
            preparedStatement .executeUpdate();
          } catch (Exception e) {
            System.out.println(e);
          }
          System.out.print("Result = " + res);
          System.out.print("Power Entry added in operation table");
          break;
        case 'f' :
          System.out.print("Enter a Number : ");
          num1 = scan.nextInt();
          res = Math.abs(num1);
          try {
            String insertTablesql =
                "INSERT INTO operations"
                    + "(timestamp, left_operand, operator, result) VALUES" + "(?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertTablesql);
            preparedStatement.setTime(1, getCurrentTimeStamp());
            preparedStatement.setInt(2, num1);
            preparedStatement.setString(3, "Absolute");
            preparedStatement.setInt(4, res);
            preparedStatement.executeUpdate();
          } catch (Exception e) {
            System.out.println(e);
          }
          System.out.print("Result = " + res);
          System.out.print("Absolute Entry added in operation table");
          break;
        case 'g' :
          System.out.print("Enter Two Number : ");
          num1 = scan.nextInt();
          num2 = scan.nextInt();
          res = num1 % num2;
          try {
            String insertTablesql = "INSERT INTO operations"
                + "(timestamp, left_operand, right_operand, operator, result) VALUES"
                + "(?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertTablesql);
            preparedStatement.setTime(1,getCurrentTimeStamp());
            preparedStatement.setInt(2,num1);
            preparedStatement.setInt(3,num2);
            preparedStatement.setString(4, "Modulus");
            preparedStatement.setInt(5,res);
            preparedStatement .executeUpdate();
          } catch (Exception e) {
            System.out.println(e);
          }
          System.out.print("Result = " + res);
          System.out.print("One Modulus Entry added in operation table");
          System.out.print("Result = " + res);
          break;
        case 'h' :
          System.out.print("Enter Two Number : ");
          num1 = scan.nextInt();
          num2 = scan.nextInt();
          res = (num1 > num2) ? num1 : num2;
          try {
            String insertTablesql = "INSERT INTO operations"
                + "(timestamp, left_operand, right_operand, operator, result) VALUES"
                + "(?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertTablesql);
            preparedStatement.setTime(1,getCurrentTimeStamp());
            preparedStatement.setInt(2,num1);
            preparedStatement.setInt(3,num2);
            preparedStatement.setString(4, "Maximum");
            preparedStatement.setInt(5,res);
            preparedStatement .executeUpdate();
          } catch (Exception e) {
            System.out.println(e);
          }
          System.out.print("Result = " + res);
          System.out.print("One Maximum Entry added in operation table");
          break;
        case 'i' :
          System.out.print("Enter Two Number : ");
          num1 = scan.nextInt();
          num2 = scan.nextInt();
          res = (num1 < num2) ? num1 : num2;
          try {
            String insertTablesql = "INSERT INTO operations"
                + "(timestamp, left_operand, right_operand, operator, result) VALUES"
                + "(?,?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(insertTablesql);
            preparedStatement.setTime(1,getCurrentTimeStamp());
            preparedStatement.setInt(2,num1);
            preparedStatement.setInt(3,num2);
            preparedStatement.setString(4, "Minimum");
            preparedStatement.setInt(5,res);
            preparedStatement .executeUpdate();
          } catch (Exception e) {
            System.out.println(e);
          }
          System.out.print("Result = " + res);
          System.out.print("One Minimum Entry added in operation table");
          break;
        case 'j' :
          try {
            conn.close();
          } catch (Exception e) {
            System.out.println(e);
          }
          System.exit(0);
          break;
        default : System.out.print("Wrong Choice!!!");
          break;
      }
      System.out.print("\n---------------------------------------\n");
    } while (choice != 'j');

  }
}
