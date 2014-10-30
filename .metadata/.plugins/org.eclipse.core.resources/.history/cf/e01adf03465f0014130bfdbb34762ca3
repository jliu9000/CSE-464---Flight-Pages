package flight.bizlogic;

public class FlightRecord {
	private String sSource;
	private String sDestination;
	private String sDateOfTravel; 
	private String sClass;
	private int nSeats;
	private String sDepartureTime;
	private String sArrivalTime;
	private int nNumberOfStops;
	private double dCost;
	private int nID;
	
	public FlightRecord(){}
	
	
	//THE FOLLOWING WILL MOST LIKELY BE DEPRECIATED AFTER HW2, DO NOT USE!!! ==================================
	//IF YOU HAVE CHANGES ADD IT ABOVE THIS SECTION  ==========================================================
	
	public FlightRecord(String sSource, String sDestination, String sDateOfTravel, int nSeats,
			String sClass){ 
		this.sSource = sSource;
		this.sDestination = sDestination;
		this.sDateOfTravel = sDateOfTravel;
		this.nSeats = nSeats;
		this.sClass = sClass;
		fillRecord();
	}
	
	public FlightRecord(int nID, String sSource, String sDestination, String sDateOfTravel, int nSeats,
			String sClass, String sDepartureTime, String sArrivalTime, int nNumberOfStops, double dCost){ 
		this.nID = nID;
		this.sSource = sSource;
		this.sDestination = sDestination;
		this.sDateOfTravel = sDateOfTravel;
		this.nSeats = nSeats;
		this.sClass = sClass;
		this.sDepartureTime = sDepartureTime;
		this.sArrivalTime = sArrivalTime;
		this.nNumberOfStops = nNumberOfStops;
		this.dCost = dCost;
		
	}
	
	
	//fill missing fields w/ random numbers
	private void fillRecord(){
		int nHour;
		int dMin;
		nID = (int) Math.round(Math.random()*1000);
		nHour = (int) Math.round(Math.random() * 11) + 1;
		dMin =  (int) Math.round(Math.random() * 60);
		sDepartureTime =  nHour +":" +dMin +" " +(Math.random() > .5 ? "AM" : "PM");
		nHour = (int) Math.round(Math.random() * 11) + 1;
		dMin = (int) Math.round(Math.random() * 60);
		sArrivalTime =  nHour +":" +dMin +" " +(Math.random() > .5 ? "AM" : "PM");
		nNumberOfStops = (int) Math.round(Math.random() * 4);
		dCost =  Math.round(Math.random() * 1000) + 50;
	}
	
	

	public String getDepartureTime() {
		return sDepartureTime;
	}


	public String getArrivalTime() {
		return sArrivalTime;
	}


	public int getNumberOfStops() {
		return nNumberOfStops;
	}


	public double getCost() {
		return dCost;
	}


	public int getID() {
		return nID;
	}



	public String getSource() {
		return sSource;
	}

	public String getDestination() {
		return sDestination;
	}

	public String getDateOfTravel() {
		return sDateOfTravel;
	}

	public String getFlightClass() {
		return sClass;
	}

	public int getSeats() {
		return nSeats;
	}
	// END DEPRECIATED SECTION ============================================================================================
	
	

	// USE THE GETTERS/SETTERS BELOW FOR HW2 ==============================================================================

	public String getsSource() {
		return sSource;
	}


	public void setsSource(String sSource) {
		this.sSource = sSource;
	}


	public String getsDestination() {
		return sDestination;
	}


	public void setsDestination(String sDestination) {
		this.sDestination = sDestination;
	}


	public String getsDateOfTravel() {
		return sDateOfTravel;
	}


	public void setsDateOfTravel(String sDateOfTravel) {
		this.sDateOfTravel = sDateOfTravel;
	}


	public String getsClass() {
		return sClass;
	}


	public void setsClass(String sClass) {
		this.sClass = sClass;
	}


	public int getnSeats() {
		return nSeats;
	}
	


	public void setnSeats(int nSeats) {
		this.nSeats = nSeats;
	}


	public String getsDepartureTime() {
		return sDepartureTime;
	}


	public void setsDepartureTime(String sDepartureTime) {
		this.sDepartureTime = sDepartureTime;
	}


	public String getsArrivalTime() {
		return sArrivalTime;
	}


	public void setsArrivalTime(String sArrivalTime) {
		this.sArrivalTime = sArrivalTime;
	}


	public int getnNumberOfStops() {
		return nNumberOfStops;
	}


	public void setnNumberOfStops(int nNumberOfStops) {
		this.nNumberOfStops = nNumberOfStops;
	}


	public double getdCost() {
		return dCost;
	}


	public void setdCost(double dCost) {
		this.dCost = dCost;
	}


	public int getnID() {
		return nID;
	}


	public void setnID(int nID) {
		this.nID = nID;
	}
	

	
	
	
	
}
