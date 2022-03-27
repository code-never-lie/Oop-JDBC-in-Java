JDBC (Java Databse Connectivity)

package :  java.sql  (API)
           javax.sql 

How to Connect DB with Java?

1- Create Data Soure Name (DSN)

JavaApplication -->JDBc-->DSN-->Driver(ODBC)-->Database

odbcad32

2- Java Application Steps
   i) Load Driver

    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");

   ii) Establish Connection with db

   Connection con=
DriverManager.createConnection("jdbc:odbc:Lahore");
        con.setAutoCommit(false);
  iii)create Statement Object (for SQL)

     Statement stmt= con.createStatement();


  iv) run Query
 String qry="insert into user values("Hafiz","123")"

     stmt.executeUpdate(qry);

 iv) Commit Transaction
     con.commit();

........................................................
Example: Establish Connection with database.
DSN : Lahore
Table : user(username, password)



import java.sql.*;
import java.sql.*;
class MyDb{
private Connection con;
MyDb() {
 try {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   con=DriverManager.getConnection("jdbc:odbc:Lahore");
   System.out.print("Connection Established ....");
  }catch (Exception e ) { System.out.print(e);}
}


}

class Test{
public static void main(String o[]){
MyDb db=new MyDb();

}
}
.............................................................
Example: insert row into database

import java.sql.*;
import java.sql.*;
class MyDb{
private Connection con;
private Statement stmt;
MyDb() {
 try {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   con=DriverManager.getConnection("jdbc:odbc:Lahore");
   stmt=con.createStatement();
   con.setAutoCommit(false);
   System.out.print("Connection Established ....");
  }catch (Exception e ) { System.out.print(e);}
}
void insertRow(String username,String password){
String qry="insert into user values('"+username+"','"+password+"')";
   try{
    stmt.executeUpdate(qry);
    con.commit();
    System.out.print("Successfully Saved");
   }catch (Exception e ) { System.out.print(e);}

} 


}

class Test{
public static void main(String o[]){
MyDb db=new MyDb();
String username=o[0];
String password=o[1];
db.insertRow(username, password);
}
}
.........................................................................
Example: Retrive  rows from database using SQL

import java.sql.*;
import java.sql.*;
class MyDb{
private Connection con;
private Statement stmt;
private ResultSet rs;
MyDb() {
 try {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   con=DriverManager.getConnection("jdbc:odbc:Lahore");
   stmt=con.createStatement();
   con.setAutoCommit(false);
   System.out.print("Connection Established ....\n");
  }catch (Exception e ) { System.out.print(e);}
}
void insertRow(String username,String password){
String qry="insert into user values('"+username+"','"+password+"')";
   try{
    stmt.executeUpdate(qry);
    con.commit();
    System.out.print("Successfully Saved");
   }catch (Exception e ) { System.out.print(e);}

} 
void retrieveRow(String qry){
     try {
        rs=stmt.executeQuery(qry);
        while (rs.next()){
System.out.println("\n"+rs.getString("username") + "\t"+rs.getString("password"));

        }

     }catch (Exception e ) { System.out.print(e);}

}

}

class Test{
public static void main(String o[]){
MyDb db=new MyDb();
String qry=o[0]; // enter sql query as Command Line Argument
db.retrieveRow(qry);
}
}
................................................................................
    ResultSetMetaData 
 For meta information related to result set
................................................................................
    Resultset  rs=stmt.executeQuery(qry);                  
    ResultSetMetaData  meta=rs.getMetaData();
    int col=meta.getColumnCount();
    while (rs.next()){
        for(int i=1;i<=col;i++)
            System.out.print(rs.getString(i)+"\t");
        System.out.print("\n");
    }

.............................................................................        
Example: Retrive  rows(generic Logic) using ResultSetMatadata 

import java.sql.*;
import java.sql.*;
class MyDb{
private Connection con;
private Statement stmt;
private ResultSet rs;
MyDb() {
 try {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   con=DriverManager.getConnection("jdbc:odbc:Lahore");
   stmt=con.createStatement();
   con.setAutoCommit(false);
   System.out.print("Connection Established ....\n");
  }catch (Exception e ) { System.out.print(e);}
}
void insertRow(String username,String password){
String qry="insert into user values('"+username+"','"+password+"')";
   try{
    stmt.executeUpdate(qry);
    con.commit();
    System.out.print("Successfully Saved");
   }catch (Exception e ) { System.out.print(e);}

} 
void retrieveRow(String qry){
     try {
        rs=stmt.executeQuery(qry);
        ResultSetMetaData  meta=rs.getMetaData();
    int col=meta.getColumnCount();
    for (int i=1;i<=col;i++)    
        System.out.print(meta.getColumnName(i)+"\t");

    System.out.print("\n"); 
    while (rs.next()){
        for(int i=1;i<=col;i++)
            System.out.print(rs.getString(i)+"\t");
        System.out.print("\n");
    }
     }catch (Exception e ) { System.out.print(e);}


}

}

class Test{
public static void main(String o[]){
MyDb db=new MyDb();
String qry=o[0];
db.retrieveRow(qry);
}
}
.....................................................
Example: Login Problem 
- boolean isLogin(username, password) added into MyDb class

import java.sql.*;
import java.sql.*;
class MyDb{
private Connection con;
private Statement stmt;
private ResultSet rs;
MyDb() {
 try {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   con=DriverManager.getConnection("jdbc:odbc:Lahore");
   stmt=con.createStatement();
   con.setAutoCommit(false);
   System.out.print("Connection Established ....\n");
  }catch (Exception e ) { System.out.print(e);}
}
void insertRow(String username,String password){
String qry="insert into user values('"+username+"','"+password+"')";
   try{
    stmt.executeUpdate(qry);
    con.commit();
    System.out.print("Successfully Saved");
   }catch (Exception e ) { System.out.print(e);}

} 
void retrieveRow(String qry){
     try {
        rs=stmt.executeQuery(qry);
        ResultSetMetaData  meta=rs.getMetaData();
    int col=meta.getColumnCount();
    for (int i=1;i<=col;i++)    
        System.out.print(meta.getColumnName(i)+"\t");

    System.out.print("\n"); 
    while (rs.next()){
        for(int i=1;i<=col;i++)
            System.out.print(rs.getString(i)+"\t");
        System.out.print("\n");
    }
     }catch (Exception e ) { System.out.print(e);}
}
boolean isLogin(String username,String password){
 String qry="select * from user where username='"+username+"' and password='"+password+"'";
try {
rs=stmt.executeQuery(qry);

   if (rs.next())
       return true;
    else 
       return false;
} catch (Exception e ) { }
  return false;  

}
}
class Test{
public static void main(String o[]){
MyDb db=new MyDb();
String username=o[0];
String password=o[1];
if (db.isLogin(username,password))
   System.out.println("Successfully Login");
else
    System.out.println("Invalid username/password");
}
}
.......................................................................
Example : Login Problem (again with prepared statement)
 - prepaid statement is very usefull class for parameterized query
 - Compile once by sql Compiler
 Advantage
 - Improve performance
.......................................................................

import java.sql.*;
import java.sql.*;
class MyDb{
private Connection con;
private Statement stmt;
private ResultSet rs;
MyDb() {
 try {
   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
   con=DriverManager.getConnection("jdbc:odbc:Lahore");
   stmt=con.createStatement();
   con.setAutoCommit(false);
   System.out.print("Connection Established ....\n");
  }catch (Exception e ) { System.out.print(e);}
}
void insertRow(String username,String password){
String qry="insert into user values('"+username+"','"+password+"')";
   try{
    stmt.executeUpdate(qry);
    con.commit();
    System.out.print("Successfully Saved");
   }catch (Exception e ) { System.out.print(e);}

} 
void retrieveRow(String qry){
     try {
        rs=stmt.executeQuery(qry);
        ResultSetMetaData  meta=rs.getMetaData();
    int col=meta.getColumnCount();
    for (int i=1;i<=col;i++)    
        System.out.print(meta.getColumnName(i)+"\t");

    System.out.print("\n"); 
    while (rs.next()){
        for(int i=1;i<=col;i++)
            System.out.print(rs.getString(i)+"\t");
        System.out.print("\n");
    }
     }catch (Exception e ) { System.out.print(e);}
}
boolean isLogin(String username,String password){
 String qry="select * from user where username='"+username+"' and password='"+password+"'";
try {
rs=stmt.executeQuery(qry);

   if (rs.next())
       return true;
    else 
       return false;
} catch (Exception e ) { }
  return false;  

}
boolean isLoginPrepared(String username,String password){
 String qry="select * from user where username=? and password=?";
try {
PreparedStatement st=con.prepareStatement(qry);
st.setString(1,username);
st.setString(2,password);

rs=st.executeQuery();

   if (rs.next())
       return true;
    else 
       return false;
} catch (Exception e ) { }
  return false;  

}

}
class Test{
public static void main(String o[]){
MyDb db=new MyDb();
String username=o[0];
String password=o[1];
if (db.isLoginPrepared(username,password))
   System.out.println("Successfully Login");
else
    System.out.println("Invalid username/password");
}
}

...................................................................................................

Example insert, delete, changepassword


import java.sql.*;
class MyDatabase{
MyDatabase (){
 try {
  Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
  con=DriverManager.getConnection("jdbc:odbc:pakamis");
  System.out.println("Connected with DB");
  stmt= con.createStatement();
  con.setAutoCommit(false);
  }catch (Exception e ) { 
         System.out.println("Problem with Connection");
         e.printStackTrace();
 }

}
boolean insert(String userName, String password){
   String qry="insert into user values('"+userName+"','"+password+"')";
   boolean flag=true;
  try {
   stmt.executeUpdate(qry);   
   con.commit();
   System.out.println("Record Saved");
   return flag; 
   }catch (SQLException e){
    System.out.println("Problem with Query");
         e.printStackTrace();
 }
  return flag;  
}

boolean changePassword(String userName, String oldPassword,String newPassword){
   String qry ="Select * from user where username='"+userName+"' and password='"+oldPassword+"'";
 System.out.println(qry);
 boolean flag=true;
try {
   ResultSet rs=stmt.executeQuery(qry);
   if (!rs.next()){
     System.out.println("Incorrect Username/password");
     flag=false;
     return flag;
   } 
   else { 

   qry="update user set password='"+newPassword+"' where username='"+userName+"'";
   
   stmt.executeUpdate(qry);   
   con.commit();
   System.out.println("Password Changed");
   return flag; 
   
 }//end else
 }catch (SQLException e){
    System.out.println("Problem with Query");
         e.printStackTrace();
 }
  return flag;  
}

boolean remove(String userName){
String qry="delete from user where username='"+userName+"'";
 try {
  int i=stmt.executeUpdate(qry);
  if (i==1){
    System.out.println("Successfully Deleted");    
    con.commit();
  }
  else
  System.out.println(userName+ " Row not found");    
 } catch (Exception e ) {
         System.out.println("Problem with Query");
         e.printStackTrace();
 }
 return true;
}

Connection con;
Statement stmt;
ResultSet rs;
}


class Test{
public static void main(String o[]){
MyDatabase db= new MyDatabase();
String userName=o[0];

  db.remove(userName);

}
}

...................................................................
Assignment

problem :Bank 
         Role : manager, clerk, customer

 manager  can  
          - create user   10
          - update user   20
          - deactivate user account  20
          - active user account  40
          - create new role  50
          - dr        60
          - cr     70
          - view balance  80

clerk  can
         - view balance   80
         - cr              70
         - dr              60
         - print account statement 120
customer  can
         - view balance   90
         - crossDeposit   100
       

AssManager can
          - create user   10
          - update user   20
          - deactivate user account  20
          - active user account  40 
          - grant rights        110
          - revoke rights

           
 
   user(username, password,Role,        active)
           a        123     1           y
           b        xyz     3           y
           c        34      2           y
           d        12      3           n
    
   Role 
    (rollid, Title)
      1    manager
      2    clerk
      3    customer 
      4    Assmanager
  UserRigths
     rollid     rid
      1         10
      1         20
      1         30
      2         30
      4         10
      4         20
      4         110
      3         120
 Rights
   rid      Title 
   10         create user
    20         
      

  account(acode,username,balance)
           1       b      2000

  transaction (tid,acode, amt,  date,    type)
                10  1      2000  3-sep    cr
  
                11  1      1000  4-sep    dr













   




