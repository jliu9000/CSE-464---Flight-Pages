package flight.bizlogic;

import java.sql.SQLException;

import flight.data.DbData;

public class User {
	private String username;
	private int nUserId;
	private String sHashedPass;
	private String sFullName;
	
	DbData dbData = new DbData();
	
	public User(){}
	public User(String sUserName){
		username = sUserName;
		try {
			sHashedPass = dbData.getUserCredentials(sUserName);
		} catch (SQLException e1) {
			
			//e1.printStackTrace();
		}
		
		try {
			String t = dbData.getUserIdandFullName(sUserName);
			if (t != null){
				String[] temp = t.split(",");
				nUserId = Integer.parseInt(temp[0]);
				sFullName = temp[1];
			}
		} catch (SQLException e) {
			System.out.println("errors");
			//e.printStackTrace();
			sFullName = "";
			nUserId = -1;
		}
	}
	
	public boolean VerifyPassword(String sPasswordUnHashed){
		boolean bVerified = false;
		
		int hashPass = sPasswordUnHashed.hashCode();
		String sHassPass = String.valueOf(hashPass);
		
		if(sHashedPass != null && sHassPass.equals(sHashedPass)){
			bVerified= true;
			
		}
		
		return bVerified;
	}

	public boolean addUser(String username, int password, String fullname){
		try {
			dbData.addUser(username, password, fullname);
			this.username = username;
			sHashedPass = String.valueOf(password);
			sFullName = fullname;
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			return false;
		}
	} 
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getnUserId() {
		return nUserId;
	}
	public void setnUserId(int nUserId) {
		this.nUserId = nUserId;
	}
	public String getsFullName() {
		return sFullName;
	}
	public void setsFullName(String sFullName) {
		this.sFullName = sFullName;
	}
	
	
}
