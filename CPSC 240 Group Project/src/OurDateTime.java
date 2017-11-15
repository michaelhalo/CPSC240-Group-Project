import java.util.Calendar;

public class OurDateTime{

	private Calendar dateTime = Calendar.getInstance();

	public void setDateTime(int year, int month, int date, int hour, int minute) {
		this.dateTime.set(year, month, date, hour, minute);
	}
	
	public int getYear() {
		return this.dateTime.get(Calendar.YEAR);
	}
	
}
