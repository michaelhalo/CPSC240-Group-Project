import java.util.ArrayList;

/**
 * @author Brian Walsh
 */
public class Calendar {

	private ArrayList<Reservation> reservationList = new ArrayList<Reservation>();
	
	public void addReservation(Reservation res) {
		this.reservationList.add(res);
	}
	
	public void removeReservation(Reservation res) {
		this.reservationList.remove(res);
	}
	
	public void printReservations() {		
		for(Reservation reservation: reservationList) {
			System.out.println(reservation.toString());
		}
	}
}
