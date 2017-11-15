import java.util.HashMap;

/**
 * @author Brian Walsh
 */
public class Calendar {//requires caution with duplicate info in res.toShortStrings and reservations must be removed, edited, then added again

	private HashMap<String, Reservation> reservationList = new HashMap<String, Reservation>();
	
	public void addReservation(Reservation res) {
		this.reservationList.put(res.toShortString(), res);
	}
	
	public void removeReservation(Reservation res) {
		this.reservationList.remove(res.toShortString());
	}
	
	public void printReservations() {		
		for(Reservation reservation: reservationList.values()) {
			System.out.println(reservation.toString());
		}
	}
}
