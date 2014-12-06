package flight.bizlogic;

public class Clients {
	
	
	private User oUser;
	private Organizations oOrg;
	public Clients(){}
	public Clients(User usr, Organizations org){
		oUser = usr;
		oOrg = org;
	}
	
	public User getoUser() {
		return oUser;
	}
	public void setoUser(User oUser) {
		this.oUser = oUser;
	}
	public Organizations getoOrg() {
		return oOrg;
	}
	public void setoOrg(Organizations oOrg) {
		this.oOrg = oOrg;
	}
	
}
