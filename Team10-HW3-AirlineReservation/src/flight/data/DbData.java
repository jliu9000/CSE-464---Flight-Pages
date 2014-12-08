package flight.data;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.util.*;
import flight.bizlogic.*;
import java.text.*;




public class DbData {

	private Connection conn;
	private String conHost;
	private String conDB;
	private String conUser;
	private String conPassword;
	
	
	
	public DbData(){
		
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
	
	
	public String getUserCredentials(String sUsername) throws SQLException{
		
		
		ArrayList<Object> param =  new ArrayList<Object>();
		param.add(sUsername);
		String sUsernamePass;
			
		ResultSet rs1 = queryDB("SELECT * FROM khanish.Users Where email=?",param);
		
		if (rs1 != null){
			rs1.next();
			sUsernamePass = rs1.getString("password");
		}
		else sUsernamePass=null;
		conn.close();
		return sUsernamePass;
	}
	
	
	public boolean addUser(String sUserName, int sPassword) throws SQLException{
		
		
		ArrayList<Object> param =  new ArrayList<Object>();
		param.add(sUserName);
		param.add(sPassword);
		//System.out.println(sUserName + sPassword);
		int rs = updateDB("Insert INTO khanish.Users (email,password) VALUES (?,?)",param);
		
		//System.out.println("What #rows returned by the RS1 in insert: " + rs);
		conn.close();
		return true;
	}
	
	public List<FlightRecord> searchFlights(String sSource,String sDestination, String sDateStart, int nNumSeats,String sClass) throws SQLException{
		List<FlightRecord> lReturnResults = new ArrayList<FlightRecord>();
		String dbClassString = "";
		
		ArrayList<Object> param =  new ArrayList<Object>();
		param.add(sSource);
		param.add(sDestination);

		if (sClass.equals("first")){
			dbClassString = "first_class_reserved";
		}
		if (sClass.equals("economy")){
			dbClassString = "economy_reserved";
		}
		if (sClass.equals("business")){
			dbClassString = "business_reserved";
		}
		
		param.add(nNumSeats);
		param.add(sDateStart);
		
		//System.out.println("start call");
		
		
		String queryString = "SELECT * FROM cse464.flights WHERE source = ? AND destination = ? AND "+ dbClassString + " >= ? AND departure >= ? ORDER BY departure LIMIT 100"; 
		
		ResultSet rs = queryDB(queryString,param);
		FlightRecord rf;
		if (rs != null){
			while (rs.next()){
				
				rf = new FlightRecord();
				rf.setnID(rs.getInt("id"));

				rf.setsSource(rs.getString("source"));
				rf.setsDestination(rs.getString("destination"));
				rf.setsDateOfTravel(rs.getString("departure").split(" ")[0]);	
				rf.setsDepartureTime(rs.getString("departure").split(" ")[1].replace(":00.0", ""));
				rf.setsArrivalTime(rs.getString("arrival").split(" ")[1].replace(":00.0", ""));
				rf.setdCost(Math.round((100 + Math.random() * 1000)*100)/100);

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
	public double completeTransaction(int nUserId, int nAccountId, int nRoutingNumber, double dCost) throws SQLException{
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
		
		param.clear();
		param.add(dRemainingBalance);
		param.add(nAccountId);
		param.add(nRoutingNumber);
		queryString = "Update khanish.Accounts SET Balance=? WHERE HolderId=? AND RoutingNumber=?";
		
		updateDB(queryString,param);
		
		
		conn.close();
		
		return dRemainingBalance;
	}

	public double getBalance(int nRoutingNumber, int nAccountNumber) throws SQLException{
		double dCurrentBalance = 0;
		
		ArrayList<Object> param =  new ArrayList<Object>();
		param.add(nRoutingNumber);
		param.add(nAccountNumber);
		System.out.println("start call");
			
		String queryString = "Select * from khanish.Accounts WHERE HolderId=? AND RoutingNumber=?"; 
		
		ResultSet rs = queryDB(queryString,param);
		if (rs != null){
			rs.next();
			dCurrentBalance=rs.getInt("Balance");			
		} else {
			dCurrentBalance=0;
		}
		
		conn.close();
		
		return dCurrentBalance;
	}
	
	public FlightRecord GetFlight(int nFlightId, String sClass) throws SQLException{
		String q = "Select * from cse464.flights WHERE id = ?";
		ArrayList<Object> param = new ArrayList<Object>();
		param.add(nFlightId);
		FlightRecord rf = new FlightRecord();
		ResultSet rs = queryDB(q, param);
		
		if (rs != null){
			
				rf = new FlightRecord();
				rs.next();
				rf.setnID(rs.getInt("id"));

				rf.setsSource(rs.getString("source"));
				rf.setsDestination(rs.getString("destination"));
				rf.setsDateOfTravel(rs.getString("departure").split(" ")[0]);	
				rf.setsDepartureTime(rs.getString("departure").split(" ")[1].replace(":00.0", ""));
				rf.setsArrivalTime(rs.getString("arrival").split(" ")[1].replace(":00.0", ""));
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
				
				
			
			
			
		}
		conn.close();
		return rf;
	}
	
	public boolean AddBooking(int nFlightID,int nNumSeats,String sSeatingClass,int nAccountId,int nUserId,double dTotalCost, String sDateOfFlight) throws SQLException{
		ArrayList<Object> param =  new ArrayList<Object>();
		String queryString = "insert into khanish.Bookings (BookingDate, FlightID,SeatingClass, Number_of_seats,AccountId, UserId,TotalCost, DateOfFlight) VALUES (?,?,?,?,?,?,?,?)"; 
		
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date( date.getTime() );
		
		
		param.add(sqlDate);
		param.add(nFlightID);
		param.add(sSeatingClass);
		param.add(nNumSeats);
		param.add(nAccountId);
		param.add(nUserId);
		param.add(dTotalCost);
		param.add(sDateOfFlight);

		int rs = updateDB(queryString,param);
		
		conn.close();
		return true;
	}
	
	public ArrayList GetBookings (int nUserId) throws SQLException{
		ArrayList<FlightRecord> al = new ArrayList<FlightRecord>();
		ArrayList<Object> param =  new ArrayList<Object>();
		String queryString = "SELECT FlightId, DateOfFlight FROM khanish.Bookings WHERE UserId = ?"; 
		param.add(nUserId);
		
		ResultSet rs = queryDB(queryString,param);
		FlightRecord rf;
		if (rs != null){
			while (rs.next()){
				
				rf = new FlightRecord();
				rf.setnID(rs.getInt("FlightId"));
				rf.setsDateOfTravel(rs.getString("DateOfFlight"));				
				al.add(rf);
				
				//System.out.println(rs.getRow());
			}
		}		
		//System.out.println("num rows returned: " + lReturnResults.size());
		conn.close();
		
		return al;
	}
	
	public int getUserId (String UserName) throws SQLException{
		ArrayList<Object> param =  new ArrayList<Object>();
		String queryString = "SELECT * FROM khanish.Users WHERE email = ?"; 
		param.add(UserName);
		
		ResultSet rs = queryDB(queryString,param);
		if (rs != null){
			while (rs.next()){
				
				return rs.getInt("userId");
			}
		}		
		//System.out.println("num rows returned: " + lReturnResults.size());
		return 0;
	}

}
