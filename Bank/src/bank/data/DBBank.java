package bank.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.util.*;
import java.text.*;




public class DBBank {

	private Connection conn;
	private String conHost;
	private String conDB;
	private String conUser;
	private String conPassword;
	
	
	
	public DBBank(){
		
		conHost = DBCredentials.host;
		conDB = DBCredentials.db;
		conUser = DBCredentials.user;
		conPassword = DBCredentials.password;
	}
	
	
	public void initiateConnection(){

		conn = null;

		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			//System.out.println("Driver Loaded");
		}catch(Exception x){
			System.out.println("Unable to load the driver class");
		}


		try{
			String connString = String.format("jdbc:mysql://%s:3306/%s?user=%s&password=%s", conHost, conDB, conUser, conPassword);
			conn = DriverManager.getConnection(connString);
			System.out.println("Connected to Database");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("Couldn't get Connection");
			
		}
		
	}
	
	public <T> ResultSet queryDB(String query, ArrayList<T> sqlParam) throws SQLException{
		initiateConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			ps = conn.prepareStatement(query);

			int i = 1;
			for (T a : sqlParam){
				//System.out.println(a.getClass());
				if (a.getClass() == String.class){
					ps.setString(i, (String)a);
					System.out.println(String.format("I'm a String!  %d - %s", i, (String) a));
				}else if(a.getClass() == Integer.class){
					ps.setInt(i, (Integer)a);
					System.out.println(String.format("I'm an Integer!  %d - %d", i, (Integer) a));
				}else if(a.getClass() == Double.class){
					ps.setDouble(i, (Double)a);
					System.out.println(String.format("I'm a Double!  %d - %f", i, (Double) a));
				}else if (a.getClass() == Timestamp.class){
					ps.setTimestamp(i, (Timestamp)a);
					System.out.println(String.format("I'm a DateTime!  %d - %s", i, a.toString()));
				}
				i++;
			}
			//System.out.println("final query: "+ps);
			
			rs = ps.executeQuery();
		}catch (SQLException e){

			e.printStackTrace();
			
			return null;
		}
		return rs;
	}

	public ResultSet queryDBNoParams(String query) throws SQLException {
		initiateConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
		}catch (SQLException e){
			
			e.printStackTrace();
			return null;
		}
		
		return rs;
	}
	
	public int updateDBNoParams(String query) throws SQLException {
		initiateConnection();
		PreparedStatement ps = null;
		int rs = 0;
		try{
			ps = conn.prepareStatement(query);
			rs = ps.executeUpdate();
		}catch (SQLException e){
			
			e.printStackTrace();
			return 0;
		}
		
		return rs;
	}
	public <T> int updateDB(String query, ArrayList<T> sqlParam) throws SQLException {
		initiateConnection();
		PreparedStatement ps = null;
		int rs;
		try{
			ps = conn.prepareStatement(query);

			int i = 1;
			for (T a : sqlParam){
				//System.out.println(a.getClass());
				if (a.getClass() == String.class){
					ps.setString(i, (String)a);
					//System.out.println(String.format("I'm a String!  %d - %s", i, (String) a));
				}else if(a.getClass() == Integer.class){
					ps.setInt(i, (Integer)a);
					//System.out.println(String.format("I'm an Integer!  %d - %d", i, (Integer) a));
				}else if(a.getClass() == Double.class){
					ps.setDouble(i, (Double)a);
					//System.out.println(String.format("I'm a Double!  %d - %f", i, (Double) a));
				}else if (a.getClass() == Timestamp.class){
					ps.setTimestamp(i, (Timestamp)a);
					//System.out.println(String.format("I'm a DateTime!  %d - %s", i, a.toString()));
				}else if ( a.getClass() == Date.class){
					ps.setDate(i, (Date)a);
				}
				i++;
			}
			rs = ps.executeUpdate();
		}catch (SQLException e){

			e.printStackTrace();
			
			return 0;
		}
		return rs;
	}
	
	
	public boolean completeTransaction(int nAccountId, int nRoutingNumber, double dCost) throws SQLException{
		double dCurrentBalance = 0;
		double dRemainingBalance = 0; 
		
		ArrayList<Object> param =  new ArrayList<Object>();
		param.add(nAccountId);
		param.add(nRoutingNumber);
		//System.out.println("start call");
			
		String queryString = "Select * from khanish.Accounts WHERE HolderId=? AND RoutingNumber=?"; 
		
		ResultSet rs = queryDB(queryString,param);
		if (rs != null){
			while (rs.next()){
				
				dCurrentBalance=rs.getDouble("Balance");
				System.out.println(dCurrentBalance);
			}
		}
		
		dRemainingBalance = dCurrentBalance - dCost;
		if (dRemainingBalance < 0){
			return false;
		} else {
			param.clear();
			param.add(dRemainingBalance);
			param.add(nAccountId);
			param.add(nRoutingNumber);
			queryString = "Update khanish.Accounts SET Balance=? WHERE HolderId=? AND RoutingNumber=?";
			
			updateDB(queryString,param);
		}
		
		conn.close();
		
		return true;
	}
	
	
}