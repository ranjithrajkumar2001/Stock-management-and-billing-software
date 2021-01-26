package bootathon;
import java.sql.*;
import java.util.*;
public class Database {
		
	public Database() {
			//Load DB by reflection concept

	}
	final boolean login(String userName,String password){
			//check if user name exists in DB
			//check if user enter valid credentials
                        
                        try{
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
                            Statement st=con.createStatement();
                            String query="select * from admin_ where username=? and password=?";
                            PreparedStatement ps=con.prepareStatement(query);
                            ps.setString(1,userName);
                            ps.setString(2,password);
                            ResultSet rs=ps.executeQuery();
                            while(rs.next())
                            {
                                if(userName.equals(rs.getString("Username"))&& password.equals(rs.getString("Password")))
                                {
                                   // System.out.println("connected");
                                    con.close();
                                    return true;
                                }
                            }
                               
                        }
                        catch(Exception e)
                        {
                            System.out.print(e);
                        }
                        
		return false;
	}
	final boolean  addUser(String name,String userName, String password, String rePassword) {
			//User name Should not repeat
			//Mail ID Should be Valid
			//Password and re Password field need to Match
                        if(name.equals("") || userName.equals("") || password.equals("") || rePassword.equals(""))
                        {
                            return false;
                        }
                        try
                        {
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
                            Statement st=con.createStatement();
                            if(password.equals(rePassword))
                            {
                                String q="insert into admin_ values(?,?,?)";
                                PreparedStatement ps=con.prepareStatement(q);
                               
                                ps.setString(1,userName);
                                ps.setString(2,password);
                                ps.setString(3,name);
                                ps.executeUpdate();
                                //System.out.println("Sucessfully added");
                                con.close();
                                return true;                          
                            }
                            else
                            {
                               // System.out.println("password doesn't match");
                                con.close();
                                return false;
                            }
                        }
                        
                        catch(Exception e)
                        {
                            //System.out.print(e);
                            return false;
                        }
	}
        final boolean deleteuser(String username,String name,String password)
        {
            if(name.equals("") || username.equals("") || password.equals(""))
            {
                return false;
            }
             try{
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
                            Statement st=con.createStatement();
                            String query="delete from admin_ where username=? and name=? and password=?";
                            PreparedStatement ps=con.prepareStatement(query);
                            ps.setString(1,username);
                            ps.setString(2, name);
                            ps.setString(3,password);
                            int res=ps.executeUpdate();
                            //System.out.print(res);
                            con.close();
                            if(res>=1)
                            {
                                System.out.print("Succesfully deleted");
                                return true;
                            }
                            else
                            {
                                System.out.print("Enter valid username");
                                return false;
                            }
             }
             catch(Exception e)
             {
                 
             }
            
            return false;
        }
	final ArrayList<String> brandNames() {
		ArrayList<String> blist = new ArrayList<>( );
                   
                        try{
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
                            Statement st=con.createStatement();
                            String query="select * from Brand_";
                            PreparedStatement ps=con.prepareStatement(query);
                            ResultSet rs=ps.executeQuery();
                            while(rs.next())
                            {
                                blist.add(rs.getString("Brandname"));
                            }
                            //System.out.print(blist);
                            con.close();
                        }
                        catch(Exception e)
                        {
                            //System.out.println(e);
                        }
		return blist;
	}
	final boolean addBrand(String brandName) {
			//Brand name must be unique
                        
                         try{
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
                            Statement st=con.createStatement();
                            String q="insert into Brand_ values(?)";
                            PreparedStatement ps=con.prepareStatement(q);
                            ps.setString(1,brandName);
                            ps.executeUpdate();
                            //System.out.print("Successfully added");
                            con.close();
                            return true;                    
                         }
                         catch(Exception e)
                         {
                             //System.out.print(e);
                             return false;
                         }
                        
		
	}
	final boolean deleteBrand(String brandname) {
			//if brand name exist
                         try{
                            Class.forName("com.mysql.jdbc.Driver");
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
                            Statement st=con.createStatement();
                            String query="delete from brand_ where brandname=?";
                            PreparedStatement ps=con.prepareStatement(query);
                            ps.setString(1,brandname);
                            ps.executeUpdate();
                            String q="delete from dieselspare_ where brandname=?";
                            PreparedStatement p=con.prepareStatement(q);
                            p.setString(1,brandname);
                            p.executeUpdate();
                            String qu="delete from petrolspare_ where brandname=?";
                            PreparedStatement pr=con.prepareStatement(qu);
                            pr.setString(1,brandname);
                            pr.executeUpdate();
                            con.close();
                            return true;  
                         } 
                         catch(Exception e)
                         {
                             //System.out.print(e);
                             return false;
                         }
                        
	}
        final ArrayList<String> spare(String type,String brandname)
        {
            ArrayList<String> slist=new ArrayList<>(); 
            if(type.equalsIgnoreCase("petrol")){
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
                Statement st=con.createStatement();
                String query="select sparename from petrolspare_ where brandname=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,brandname);
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                   slist.add(rs.getString("sparename"));
                           
                }
                System.out.println(slist);
                con.close();
            }
            catch(Exception e)
            {
                System.out.print(e);
            }
            return  slist;
            }
            else
            {
                try
                {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
                Statement st=con.createStatement();
                String query="select sparename from dieselspare_ where brandname=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,brandname);
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                    slist.add(rs.getString("sparename"));      
                }
                System.out.print(slist);
                con.close();
                }
                catch(Exception e)
                {
                    System.out.print(e);
                }
            }
            return slist;
        }
        final ArrayList<String> spareview(String sparename,String brand,String type)
        {
            ArrayList<String> slist=new ArrayList<>(); 
            if(type.equalsIgnoreCase("petrol")){
            try
                {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
                Statement st=con.createStatement();
                String query="select * from petrolspare_ where brandname=? and sparename=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,brand);
                ps.setString(2,sparename);
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                    if(brand.equals(rs.getString("brandname"))&& sparename.equals(rs.getString("sparename")))
                        {
                            slist.add(rs.getString("sparename"));
                            slist.add(rs.getString("brandname"));
                            slist.add(rs.getString("vehiclesupported"));
                            slist.add(rs.getString("quantity"));
                            slist.add(rs.getString("cost"));
                            con.close();
                            System.out.println(slist);
                            return slist;
                        }
                    else
                    {
                        System.out.println("unavailable");
                    }
                }
            }
            catch(Exception e)
            {
              System.out.print(e);
            }
            
            }
            else
            {
                try
                {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
                Statement st=con.createStatement();
                String query="select * from dieselspare_ where brandname=? and sparename=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,brand);
                ps.setString(2,sparename);
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                    if(brand.equals(rs.getString("brandname"))&& sparename.equals(rs.getString("sparename")))
                        {
                            slist.add(rs.getString("sparename"));
                            slist.add(rs.getString("brandname"));
                            slist.add(rs.getString("vehiclesupported"));
                            slist.add(rs.getString("quantity"));
                            slist.add(rs.getString("cost"));
                            con.close();
                            //System.out.println(slist);
                            return  slist;
                       
                        }
                }
            }
                catch(Exception e)
                {
                    System.out.print(e);
                }
                
            }
            return slist;
        }
	final boolean addspare(String sparename,String type,String vehicletype,String quantity,String cost,String brandname,String threshold)
        {
            
             if(type.equalsIgnoreCase("petrol")){
             try
            {
                
                int x=Integer.parseInt(quantity);
                int y=Integer.parseInt(cost);
                int z=Integer.parseInt(threshold);
                System.out.println(x+" "+y);
                if(x<0 || y<0 || z<0)
                {
                    return false;
                }
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
                Statement st=con.createStatement();
                String q="insert into petrolspare_ values(?,?,?,?,?,?)";
                PreparedStatement p=con.prepareStatement(q);
                p.setString(1,sparename);
                p.setString(2,brandname);
                p.setString(3,vehicletype);
                p.setString(4,quantity);
                p.setString(5,cost);
                p.setString(6,threshold);
                p.executeUpdate();
                con.close();
                System.out.print("sucessfullyadded");
                return true;  
            }
             catch(Exception e)
             {
                  return false;
             }
            }
            else
            {
                try{
                int x=Integer.parseInt(quantity);
                int y=Integer.parseInt(cost);
                int z=Integer.parseInt(threshold);
                System.out.println(x+" "+y);
                if(x<0 || y<0 || z<0)
                {
                    return false;
                }
            
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
                Statement st=con.createStatement();
               String q="insert into dieselspare_ values(?,?,?,?,?,?)";
                PreparedStatement p=con.prepareStatement(q);
                p.setString(1,sparename);
                p.setString(2,brandname);
                p.setString(3,vehicletype);
                p.setString(4,quantity);
                p.setString(5,cost);
                p.setString(6,threshold);
                p.executeUpdate();
                con.close();
                System.out.print("sucessfullyadded");
                return true;
                }
                catch(Exception e)
                {
                    return false;
                }
            }
        }  
        final boolean deletespare(String sparename,String brand,String type)
        {
            if(type.equalsIgnoreCase("petrol")){
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
                Statement st=con.createStatement();
                String query="delete from petrolspare_ where sparename=? and brandname=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,sparename);
                ps.setString(2, brand);
                int res=ps.executeUpdate();
                System.out.println(res);
                //System.out.print(res);
                if(res>=1)
                {
                System.out.println("Sucessfully deleted");
                con.close();
                return true;
                }
                else
                {
                       System.out.println(res);
                    System.out.println("No such spare available");
                    return false;
                }
            }
            catch(Exception e)
            {
                System.out.print(e);
                return false;
            }
            }
            else
            {
                  try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
                Statement st=con.createStatement();
                String query="delete from dieselspare_ where sparename=? and brandname=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,sparename);
                ps.setString(2, brand);
                int res=ps.executeUpdate();
                System.out.print(res);
                if(res>=1)
                {
                System.out.println("Sucessfully deleted");
                con.close();
                return true;
                }
                else
                {
                    System.out.println("No such spare available");
                    return false;
                }
            }
            catch(Exception e)
            {
                System.out.print(e);
                return false;
            }
            }
        }
        final ArrayList<String> sparedret(String sparename,String brand,String type)
        {
            ArrayList<String> slist=new ArrayList<>();
            if(type.equalsIgnoreCase("petrol")){
            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
                Statement st=con.createStatement();
                String query="select sparename,vehiclesupported,quantity,cost,threshold from petrolspare_ where sparename=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,sparename);
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                    slist.add(rs.getString("sparename"));
                    slist.add(rs.getString("vehiclesupported"));
                    slist.add(rs.getString("quantity"));
                    slist.add(rs.getString("cost"));
                    slist.add(rs.getString("threshold"));
                    con.close();
                    System.out.println(slist);
                    return slist;
                }
            }
            catch(Exception e)
            {
                System.out.print(e);
            }
            return slist;
            }
            else
            {
               try
            {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
                Statement st=con.createStatement();
                String query="select sparename,vehiclesupported,quantity,cost,threshold from dieselspare_ where sparename=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,sparename);
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                    slist.add(rs.getString("sparename"));
                    slist.add(rs.getString("vehiclesupported"));
                    slist.add(rs.getString("quantity"));
                    slist.add(rs.getString("cost"));
                    slist.add(rs.getString("threshold"));
                    con.close();
                    System.out.println(slist);
                    return slist;
                }
            }
            catch(Exception e)
            {
                System.out.print(e);
            }
            return slist;  
            }
        }
        final boolean update(String sparename,String type,String vehicletype,String quantity,String cost,String brandname,String threshold)
        {
            
            if(type.equalsIgnoreCase("petrol")){
             try
            {
                int x=Integer.parseInt(quantity);
                int y=Integer.parseInt(cost);
                int z=Integer.parseInt(threshold);
                System.out.println(x+" "+y);
                if(x<0 || y<0 || z<0)
                {
                    return false;
                }
                Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
                Statement st=con.createStatement();
                String q="update petrolspare_ set vehiclesupported=?,quantity=?,cost=?,threshold=? where brandname=? and sparename=?";
                PreparedStatement p=con.prepareStatement(q);
                p.setString(1,vehicletype);
                p.setString(2,quantity);
                p.setString(3,cost);
                p.setString(4,threshold);
                p.setString(5,brandname);
                p.setString(6,sparename);
                p.executeUpdate();
                con.close();
                System.out.print("sucessfullyUpdated");
                return true;  
            }
             catch(Exception e)
             {
                  return false;
             }
            }
            else
            {
                try{
                    
                 int x=Integer.parseInt(quantity);
                int y=Integer.parseInt(cost);
                int z=Integer.parseInt(threshold);
                System.out.println(x+" "+y);
                if(x<0 || y<0 || z<0)
                {
                    return false;
                }
              Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
                Statement st=con.createStatement();
                String q="update dieselspare_ set vehiclesupported=?,quantity=?,cost=?,threshold=? where brandname=? and sparename=?";
                PreparedStatement p=con.prepareStatement(q);
                p.setString(1,vehicletype);
                p.setString(2,quantity);
                p.setString(3,cost);
                p.setString(4,threshold);
                p.setString(5,brandname);
                p.setString(6,sparename);
                p.executeUpdate();
                con.close();
                System.out.print("sucessfullyUpdated");
                return true;  
                }
                catch(Exception e)
                {
                    return false;
                }
            }
        } 
        final int quantity(String sparename,String brandname,String type)
        {
            int x=0;
            if(type.equalsIgnoreCase("petrol")){
            try
            {
             Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
                Statement st=con.createStatement();
                String query="select quantity from petrolspare_ where sparename=? and brandname=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,sparename);
                ps.setString(2,brandname);
                ResultSet rs=ps.executeQuery();
                while(rs.next())
                {
                 x=Integer.parseInt(rs.getString("quantity"));
                 con.close();
                 return x;
                }
            }
            catch(Exception e)
            {
                System.out.print(e);
            }
           
            }
            else
            {
                try
                {
                 Class.forName("com.mysql.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
                Statement st=con.createStatement();
                String query="select quantity from dieselspare_ where sparename=? and brandname=?";
                PreparedStatement ps=con.prepareStatement(query);
                ps.setString(1,sparename);
                ps.setString(2,brandname);
                ResultSet rs=ps.executeQuery();
                while(rs.next()){
                x=Integer.parseInt(rs.getString("quantity"));
                con.close();
                return x;
                }
                }
                catch(Exception e)
                {
                    System.out.print(e);
                }
                
            }
            return x;
        }
        final boolean jobcard(String brand,String type,String spare)
        {
            if(spare.equals("") || type.equals("") || brand.equals(""))
            {
                return false;
            }
            try{
              Class.forName("com.mysql.jdbc.Driver");
              Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
              Statement st=con.createStatement();
              String query="insert into jobcard_ values(?,?,?)";
              PreparedStatement ps=con.prepareStatement(query);
              ps.setString(1,spare);
              ps.setString(2,brand);
              ps.setString(3,type);
              ps.executeUpdate();
              con.close();
              return true;
            }
            catch(Exception e)
            {
                System.out.print(e);
            }
            return false;
        }
        final ArrayList<String> sparelist()
        {
            ArrayList<String> slist=new ArrayList<>();
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
            Statement st=con.createStatement();
            String query="select * from jobcard_";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                slist.add(rs.getString("sparename"));
            }
            }
            catch(Exception e)
            {
                System.out.print(e);
            }
            System.out.println(slist);
            return slist;
        }
         final ArrayList<String> finishspare(String sparename)
        {
            ArrayList<String> slist=new ArrayList<>();
            try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
            Statement st=con.createStatement();
            String query="select * from jobcard_ where Sparename=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1,sparename);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
            {
                slist.add(rs.getString("Sparename"));
                slist.add(rs.getString("Brandname"));
                slist.add(rs.getString("Type"));
            }
            con.close();
            }
            catch(Exception e)
            {
                System.out.print(e);
            }
            System.out.println(slist);
            return slist;
        }
         final boolean delete(String Sparename)
         {
             try
             {
               Class.forName("com.mysql.jdbc.Driver");
              Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
              Statement st=con.createStatement();  
              String query="delete from jobcard_ where Sparename=?";
              PreparedStatement ps=con.prepareStatement(query);
              ps.setString(1,Sparename);
              int r= ps.executeUpdate();
              if(r>=1)
              {
              con.close();
              System.out.println("1");
              return true;
              }
              else
              {
                  return false;
              }
             }
             catch(Exception e)
             {
                System.out.print(e); 
             }
             return false;
         }
        final boolean checkout(String sparename,String brandname,String type,String quantity)
        {
            int x=Integer.parseInt(quantity);
            int balance;
            
            try
            {
              Class.forName("com.mysql.jdbc.Driver");
              Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
              Statement st=con.createStatement();  
              String query="insert into checkout_ values(?,?,?,?)";
              PreparedStatement ps=con.prepareStatement(query);
              ps.setString(1,sparename);
              ps.setString(2,brandname);
              ps.setString(3,type);
              ps.setString(4,quantity);
              ps.executeUpdate();
              if(type.equalsIgnoreCase("petrol")){
              String q="select quantity from petrolspare_ where sparename=? and brandname=?";
              PreparedStatement p=con.prepareStatement(q);
              p.setString(1,sparename);
              p.setString(2,brandname);
              ResultSet rs=p.executeQuery();
              while(rs.next())
              {
                 
                  int y=Integer.parseInt(rs.getString("quantity"));
                  balance=y-x;
                  String temp=String.valueOf(balance);
                 //  System.out.println(y+""+x+" "+balance);
                  String query3="update petrolspare_ set quantity=? where brandname=? and sparename=?";
                  PreparedStatement p3=con.prepareStatement(query3);
                  p3.setString(1,temp);
                  p3.setString(2,brandname);
                  p3.setString(3,sparename);
                  p3.executeUpdate();
                  con.close();
                  //System.out.println("success");
                  return true;
              }
              }
              else{
              String q="select quantity from dieselspare_ where sparename=? and brandname=?";
              PreparedStatement p=con.prepareStatement(q);
              p.setString(1,sparename);
              p.setString(2,brandname);
              ResultSet rs=p.executeQuery();
              while(rs.next())
              {
                  int y=Integer.parseInt(rs.getString("quantity"));
                  balance=y-x;
                  String temp=String.valueOf(balance);
                 // System.out.println(y+""+x+" "+balance);
                  String query3="update dieselspare_ set quantity=? where brandname=? and sparename=?";
                  PreparedStatement p3=con.prepareStatement(query3);
                  p3.setString(1,temp);
                  p3.setString(2,brandname);
                  p3.setString(3,sparename);
                  p3.executeUpdate();
                  con.close();
                //  System.out.println("success");
                  return true;
              }
              }
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
            return false;
        }
        final ArrayList<String> notipetrol()
        {
            ArrayList<String> plist=new ArrayList<>();
            try{
              Class.forName("com.mysql.jdbc.Driver");
              Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
              Statement st=con.createStatement(); 
              String query="select * from petrolspare_";
              PreparedStatement p=con.prepareStatement(query);
              ResultSet rs=p.executeQuery();
              while(rs.next())
              {
                  int a=Integer.parseInt(rs.getString("quantity"));
                  int b=Integer.parseInt(rs.getString("threshold"));
                  if(a<b)
                  {
                      plist.add(rs.getString("sparename")+"."+rs.getString("brandname"));
                  }
              }
              System.out.print(plist);
              return plist;
            }
            catch(Exception e)
            {
                System.out.print(e);
            }
            
            return  plist;
        }
          final ArrayList<String> notidiesel()
        {
            ArrayList<String> dlist=new ArrayList<>();
            try{
              Class.forName("com.mysql.jdbc.Driver");
              Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
              Statement st=con.createStatement(); 
              String query="select * from dieselspare_";
              PreparedStatement p=con.prepareStatement(query);
              ResultSet rs=p.executeQuery();
              while(rs.next())
              {
                  int a=Integer.parseInt(rs.getString("quantity"));
                  int b=Integer.parseInt(rs.getString("threshold"));
                  if(a<b)
                  {
                      dlist.add(rs.getString("sparename")+"."+rs.getString("brandname"));
                  }
              }
              System.out.print(dlist);
              return dlist;
            }
            catch(Exception e)
            {
                System.out.print(e);
            }
            return dlist;
        }
          final String[][] analyse()
          {
         
              String[][] analyse=new String[0][0];
              int count=0;
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bootathon","db","java");
                    Statement st=con.createStatement();
                    String query="select * from checkout_";
                    PreparedStatement p=con.prepareStatement(query);
                    ResultSet rs=p.executeQuery();
                    while(rs.next())
                    {
                        count++;
                    }
                    int iter=0;
                    analyse=new String[count][4];
                    String query2="select * from checkout_";
                    p=con.prepareStatement(query2);
                    ResultSet r=p.executeQuery();
                    while(r.next())
                    {
                        analyse[iter][0]=r.getString("sparename");
                        analyse[iter][1]=r.getString("brandname");
                        analyse[iter][2]=r.getString("type");
                        analyse[iter][3]=r.getString("quantity");
                        iter++;
                    }
                   
                    return analyse;
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
              
              return analyse;
          }
//	public static void main(String[] args) {
//              Database db=new Database();
//              db.login("pechi","ranjithr2k");
//              db.addUser("raja","raja23","2997", "2997");
//              db.brandNames();
                //db.addBrand();
//              db.deleteBrand("Toyoto");
               // db.spare("petrol", "toyoto");
             //  db.addspare("brake","diesel","i20" ,"5","80000","Audi");
         //    db.deletespare("airfilter2","toyoto","diesel");
//             db.deleteuser("jiji","jim","111");
              //  db.spareview("oilfilter","MARUTHI","petrol");
               //db.sparedret("brake","Audi","diesel");
              // db.update("airfilter","diesel","fortuner","4", "3000", "toyoto","3");
              // db.quantity("oilfilter","Tata","petrol");
         //     db.sparelist();
          // db.delete("oilfilter");
         // ArrayList<String> s=db.finishspare("Airfilter");
         // System.out.println(s);
        // db.checkout("oil filter","Toyoto","petrol","2");
        //   db.notipetrol();
      //  db.notidiesel();
//           String[][] a= db.analyse();
//            for(int i=0;i<a.length;i++)
//            {
//                System.out.println(a[i][0]+" "+a[i][1]+" "+a[i][2]+" "+a[i][3]);
//            }
         //   db.login("pechimuthu","PechiBoy");
	//}
}