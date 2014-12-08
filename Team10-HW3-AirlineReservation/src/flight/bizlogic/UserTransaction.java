package flight.bizlogic;

public class UserTransaction {
	private int nFlightId;
	private FlightRecord SelectedRecord = null;
	private String sAccountHolder;
	
	private int nRoutingNumber;
	private int nAccountNumber;
	private int nSeatsPurchased;
	private double dTransactionCost;
	
	
	
	
	public double getdTransactionCost(){
		return dTransactionCost;
	}
	
	public void setdTransactionCost(int cost){
		this.dTransactionCost = cost;
	}
	
	public int getnFlightId() {
		return nFlightId;
	}


	public void setnFlightId(int nFlightId) {
		this.nFlightId = nFlightId;
	}


	public FlightRecord getSelectedRecord() {
		return SelectedRecord;
	}


	public void setSelectedRecord(FlightRecord selectedRecord) {
		SelectedRecord = selectedRecord;
	}


	public String getsAccountHolder() {
		return sAccountHolder;
	}


	public void setsAccountHolder(String sAccountHolder) {
		this.sAccountHolder = sAccountHolder;
	}


	public int getnRoutingNumber() {
		return nRoutingNumber;
	}


	public void setnRoutingNumber(int nRoutingNumber) {
		this.nRoutingNumber = nRoutingNumber;
	}


	public int getnAccountNumber() {
		return nAccountNumber;
	}


	public void setnAccountNumber(int nAccountNumber) {
		this.nAccountNumber = nAccountNumber;
	}


	public int getnSeatsPurchased() {
		return nSeatsPurchased;
	}


	public void setnSeatsPurchased(int nSeatsPurchased) {
		this.nSeatsPurchased = nSeatsPurchased;
	}


	//SelectedRecord setters and getters
	public String getsSource() {
		return SelectedRecord.getsSource();
	}


	public void setsSource(String sSource) {
		this.SelectedRecord.setsSource(sSource);
	}


	public String getsDestination() {
		return SelectedRecord.getsDestination();
	}


	public void setsDestination(String sDestination) {
		this.SelectedRecord.setsDestination(sDestination);
	}


	public String getsDateOfTravel() {
		return SelectedRecord.getsDateOfTravel();
	}


	public void setsDateOfTravel(String sDateOfTravel) {
		SelectedRecord.setsDateOfTravel(sDateOfTravel);
	}


	public String getsClass() {
		return SelectedRecord.getsClass();
	}


	public void setsClass(String sClass) {
		SelectedRecord.setsClass(sClass);
	}


	public int getnSeats() {
		return SelectedRecord.getnSeats();
	}
	


	public void setnSeats(int nSeats) {
		SelectedRecord.setnSeats(nSeats);
	}


	public String getsDepartureTime() {
		return SelectedRecord.getsDepartureTime();
	}


	public void setsDepartureTime(String sDepartureTime) {
		SelectedRecord.setsDepartureTime(sDepartureTime);
	}


	public String getsArrivalTime() {
		return SelectedRecord.getsArrivalTime();
	}


	public void setsArrivalTime(String sArrivalTime) {
		SelectedRecord.setsArrivalTime(sArrivalTime);
	}


	public int getnNumberOfStops() {
		return SelectedRecord.getnNumberOfStops();
	}
	
	public void setnNumberOfStops(int nNumberOfStops){
		SelectedRecord.setnNumberOfStops(nNumberOfStops);
	}

}
