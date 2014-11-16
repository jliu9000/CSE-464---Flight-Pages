package flight.bizlogic;

public class FlightRecord {
	private String sSource;
	private String sDestination;
	private String sDateOfTravel; 
	private String sClass;
	private int nSeats;
	private int nQueuedSeats;
	private String sDepartureTime;
	private String sArrivalTime;
	private int nNumberOfStops;
	private double dCost;
	private int nID;

	
	public FlightRecord(){}
	
	public int getnQueuedSeats(){
		return nQueuedSeats;
	}
	
	public void setnQueuedSeats(int nQueuedSeats){
		this.nQueuedSeats = nQueuedSeats;
	}
	
	
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
