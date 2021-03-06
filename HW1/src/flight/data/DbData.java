package flight.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.*;
import flight.bizlogic.*;
import java.text.*;




public class DbData {

	private Connection conn;
	private String conHost;
	private String conDB;
	private String conUser;
	private String conPassword;
	
	
	
	public DbData(String host, String db, String user, String password){
		conHost = host;
		conDB = db;
		conUser = user;
		conPassword = password;
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
			System.out.println("final query: "+ps);
			
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
	
	
	public List<String> getUserCredentials() throws SQLException{
		
		ResultSet rs1 = queryDBNoParams("SELECT * FROM khanish.Users");
		List<String> lEmailList = new ArrayList<String>();
				
		//test stuff
		rs1.last();
		System.out.println("number of results: " + rs1.getRow());
		rs1.beforeFirst();
		//end test stuff
				
		if (rs1 != null){
			while (rs1.next()){
				lEmailList.add(rs1.getString("email"));
				//System.out.println("email: "+rs1.getString("email"));
			}
		}
		conn.close();
		return lEmailList;
	}
	
	public boolean addUser(String sUserName, String sPassword, java.util.Date dDOB) throws SQLException{
		
		
		ArrayList<Object> param =  new ArrayList<Object>();
		param.add(sUserName);
		param.add(sPassword);
		param.add(dDOB);
		//System.out.println(sUserName + sPassword);
		int rs = updateDB("Insert INTO khanish.Users (email,password) VALUES (?,?)",param);
		
		System.out.println("What #rows returned by the RS1 in insert: " + rs);
		conn.close();
		return true;
	}
	
	public List<FlightRecord> searchFlights(String sSource,String sDestination, String sDateOfTravel,int nNumSeats,String sClass) throws SQLException{
		List<FlightRecord> lReturnResults = new ArrayList<FlightRecord>();
		String dbClassString = "";
		
		ArrayList<Object> param =  new ArrayList<Object>();
		param.add(sSource);
		param.add(sDestination);

		if (sClass == "first"){
			dbClassString = "first_class_reserved";
		}
		if (sClass == "economy"){
			dbClassString = "economy_reserved";
		}
		if (sClass == "business"){
			dbClassString = "business_reserved";
		}
		
		param.add(nNumSeats);
		param.add(sDateOfTravel);
		
		System.out.println("start call");
		
		
		String queryString = "SELECT * FROM cse464.flights WHERE source = ? AND destination = ? AND "+ dbClassString + " > 0 AND "+ dbClassString +" < ? AND departure >= ?"; 
		
		ResultSet rs = queryDB(queryString,param);
		FlightRecord rf;
		if (rs != null){
			while (rs.next()){
				rf = new FlightRecord();
				rf.setsSource(rs.getString("source"));
				rf.setsDestination(rs.getString("destination"));
				rf.setsDateOfTravel(rs.getString("departure"));	
				
				switch (sClass) {
	            case "first": 	rf.setsClass("first");
	            				rf.setnSeats(rs.getInt("first_class_reserved"));
	            				break;
	            case "economy": rf.setsClass("economy");
								rf.setnSeats(rs.getInt("economy_reserved"));
								break;
	            case "business":rf.setsClass("business");
								rf.setnSeats(rs.getInt("business_reserved"));
								break;
	            default: rf.setnSeats(0);
	                     break;
				}//end switch				
				
				lReturnResults.add(rf);
				
				//System.out.println(rs.getRow());
			}
		}		
		//System.out.println("num rows returned: " + lReturnResults.size());
		conn.close();
		return lReturnResults;		
	}
	
	//assume theres only one account with each user
	public int completeTransaction(int nUserID,int nCost) throws SQLException{
		int nCurrentBalance = 0;
		int nRemainingBalance = 0; 
		
		ArrayList<Object> param =  new ArrayList<Object>();
		param.add(nUserID);
		System.out.println("start call");
			
		String queryString = "Select * from khanish.Accounts WHERE HolderId=?"; 
		
		ResultSet rs = queryDB(queryString,param);
		if (rs != null){
			while (rs.next()){
				
				nCurrentBalance=rs.getInt("Balance");
				System.out.println(nCurrentBalance);
			}
		}
		
		nRemainingBalance = nCurrentBalance - nCost;
		
		param.clear();
		param.add(nRemainingBalance);
		param.add(nUserID);
		queryString = "Update khanish.Accounts SET Balance=? WHERE HolderId=?";
		
		updateDB(queryString,param);
		
		
		conn.close();
		
		return nRemainingBalance;
	}
	
	public boolean AddBooking(int nFlightID,int nNumSeats,String sSeatingClass,int nAccountId,int nUserId,int nTotalCost) throws SQLException{
		ArrayList<Object> param =  new ArrayList<Object>();
		String queryString = "insert into khanish.Bookings (BookingDate, FlightID,SeatingClass, Number_of_seats,AccountId, UserId,TotalCost) VALUES (?,?,?,?,?,?,?)"; 
		
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date( date.getTime() );
		
		
		param.add(sqlDate);
		param.add(nFlightID);
		param.add(sSeatingClass);
		param.add(nNumSeats);
		param.add(nAccountId);
		param.add(nUserId);
		param.add(nTotalCost);

		int rs = updateDB(queryString,param);
		
	
		return true;
	}
}
