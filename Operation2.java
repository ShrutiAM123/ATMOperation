import java.util.*;
import java.sql.*;
public class Operation2 extends DBCON2 {
     int newbalance =0;
     int balance =0;
     Scanner sc = new Scanner(System.in);
      void checkBalance()
      {
         try
         {
               System.out.println("Enter your pin..");
               Scanner sc = new Scanner(System.in);
               int pin = sc.nextInt(); 
               String checkBalanceQuery ="select * from  AtmOperation where pin="+pin;
             //String checkBalanceQuery = "select * from AtmOperation";
//             PreparedStatement pst2 =con.prepareStatement(checkBalanceQuery);
//             pst2.executeUpdate();
//             System.out.println("Current Account Balance...");
             
              Statement stmt = con.createStatement();
        
              ResultSet rs = stmt.executeQuery(checkBalanceQuery);
              
              System.out.println("Current Account Balance...");
              
              while(rs.next())
              {
                 System.out.print(" "+rs.getInt(1));
                 System.out.print(" "+rs.getInt(2));
                 //System.out.print(" "+rs.getInt(3));
                 balance = rs.getInt("balance");
                System.out.print(" "+balance);
                 System.out.print("\n");
                
              }
         }
         catch(Exception e)
         {
             System.out.println(e);
         }
      }    
      void withdraw()
      {
          try
          {
              Scanner sc  = new Scanner(System.in);

              System.out.println("Enter your pin..");
              int pin = sc.nextInt(); 
              System.out.println("Enter amount to withdraw..");
             int ammount = sc.nextInt();
              
              
              String checkBalanceQuery ="select *  from AtmOperation where pin="+pin;
             
             
              Statement stmt = con.createStatement();
        
              ResultSet rs = stmt.executeQuery(checkBalanceQuery);
             
              
              while(rs.next())
             {
                rs.getInt(1);
                rs.getInt(2);
                balance = rs.getInt("balance");
                //System.out.print(" "+balance);
               
              
             }
              if(ammount<=balance)
              {
                 
             
                   balance = balance - ammount;
                   
                   String updateQuery ="update AtmOperation set balance ="+balance+" where pin="+pin;
        
                   PreparedStatement  pst4 = con.prepareStatement(updateQuery);
                   
                   pst4.executeUpdate();
                   System.out.println("\nPassbook Update Successfully..");
              }
              else{
                 System.out.println("Insufficient balance..."); 
              }
             
          }
          catch(Exception e){
              System.out.println(e);
          }
      }
       void deposit()
       {
          try
          {
              
              System.out.println("Enter amount for deposit..");
              int amount = sc.nextInt();
             
               System.out.println("Enter your pin..");
               int pin = sc.nextInt();
          
              String checkBalanceQuery ="select *  from AtmOperation where pin="+pin;
             
             
              Statement stmt = con.createStatement();
        
              ResultSet rs = stmt.executeQuery(checkBalanceQuery);
             
              
              while(rs.next())
             {
                rs.getInt(1);
                rs.getInt(2);
                balance = rs.getInt("balance");
                //System.out.print(" "+balance);
              }
                   balance = balance + amount;
                   String updateQuery ="update AtmOperation set balance ="+balance+" where pin="+pin;
        
                   PreparedStatement  pst5 = con.prepareStatement(updateQuery);
                   
                   pst5.executeUpdate();
                   System.out.println("Thanks");
          }
          catch(Exception e){
              System.out.println(e);
          }
      }
      
    public static void main(String[] args){
        
    Operation2 obj = new Operation2();
        while(true)
        {
            System.out.println("\nEnter 1 for Deposit");
            System.out.println("Enter 2 for withdraw");
            System.out.println("Enter 3 to checkBalance");
            System.out.println("Enter 4 for Exit");
            
            
            System.out.println("Choose the operation you want to perform....");
            
            java.util.Scanner sc = new java.util.Scanner(System.in);
            int choice = sc.nextInt();
           // System.out.println("Enter your Choice"+" "+choice);
            switch(choice)
            {
                case 1:
                        obj.deposit();
                        break;
                case 2:
                        obj.withdraw();
                        break;
                case 3:
                        obj.checkBalance();
                        break;
                case 4:
                       System.exit(0);
                default:
                      System.out.println("Invalid input...");
            }
        }
}

}