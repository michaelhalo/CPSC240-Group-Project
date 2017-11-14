import java.util.Calendar;

/**
 *
 * @author Michael
 */
public class Reservation extends Room{

    private User user; //user class not written yet
    private Calendar dateTime;
    
    public void setUser(User user) {
    	this.user = user;
    }
    
    public User getUser() {
    	return this.user;
    }
    
    public void setDateTime(Calendar dateTime) {
    	this.dateTime = dateTime;
    }
    
    public Calendar getDateTime() {
    	return this.dateTime;
    }
    
    public void printReservation(){
        
    }
}
