package flight.bizlogic;

import java.util.ArrayList;

public class FlightRecordList {
	private ArrayList<FlightRecord> _lFlightRecord;
	private int nCurrentRecord = 0;
	private int FlightId;
	private int Date;
	private int getIdAndIncrement;
	
	public void setFlightRecordList(ArrayList<FlightRecord> fr) {
		_lFlightRecord = fr;
	}
	
	public int getFlightId(){
		return _lFlightRecord.get(nCurrentRecord).getnID();
	}
	
	public String getDate(){
		return _lFlightRecord.get(nCurrentRecord).getsDateOfTravel();
	}
	
	public String getDepartureTime(){
		return _lFlightRecord.get(nCurrentRecord).getsDepartureTime();
	}
	
	public String getArrivalTime(){
		return _lFlightRecord.get(nCurrentRecord).getsArrivalTime();
	}
	
	public int getNumberOfStops(){
		return _lFlightRecord.get(nCurrentRecord).getnNumberOfStops();
	}
	
	public double getCost(){
		return _lFlightRecord.get(nCurrentRecord).getdCost();
	}
	
	public int getIdAndIncrement(){
		nCurrentRecord++;
		return _lFlightRecord.get(nCurrentRecord-1).getnID();
	}
	
	public String getsClass(){
		return _lFlightRecord.get(nCurrentRecord).getsClass();
	}
	
	public int getLength(){
		return _lFlightRecord.size();
	}




	
}
