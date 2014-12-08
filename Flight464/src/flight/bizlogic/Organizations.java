package flight.bizlogic;

import java.sql.SQLException;

import flight.data.DbData;

public class Organizations {
	private String sName;
	private String sAddress;
	private String sUserName;
	DbData dbData = new DbData();
	
	public Organizations(String sUserName){
		this.sUserName = sUserName;
		String[] temp;
		try {
			String t = dbData.getOrganizationDetails(sUserName);
			if (t != null){
				temp = dbData.getOrganizationDetails(sUserName).split(",");
				sName = temp[0];
				sAddress = temp[1];
			}

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//.printStackTrace();
		}
		
	}
	
	
	public boolean addOrgInfo(String sName, String sAddress){
		boolean bAdded = false;
		this.sName = sName;
		this.sAddress = sAddress;
		try {
			dbData.updateOrganization(sName, sAddress, sUserName);
			bAdded = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		return bAdded;
	}
	
	
	
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	
	
}
