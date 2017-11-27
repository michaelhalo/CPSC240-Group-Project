/**
 *
 * @author Michael
 * @version 2.0
 */
public class Reservation extends Room{

    private User user;
    private OurDateTime startTime;
    private OurDateTime endTime;
    
    public void setUser(User user) {
    	this.user = user;
    }
    
    public User getUser() {
    	return this.user;
    }
    
    public void setDateTime(OurDateTime dateTime) {
    	this.dateTime = dateTime;
    }
    
    public OurDateTime getDateTime() {
    	return this.dateTime;
    }
    
    public void printReservation(){
        
    }
    
    public String toString() {
    	String info = super.toString();
    	info = info + ", \n" + user.toString() + ",\n" + "Start time: " + startTime.toString() + ", \n" + "End time: " + endTime.toString();
    	return info;
    }
    
    public String toShortString() {
    	String info = this.user.getName() + ", " + this.getBuilding() + " " + this.getRoomNumber() + ", " + this.startTime.toString() + " - " + this.endTime.toString();
    	return info;
    }
}
