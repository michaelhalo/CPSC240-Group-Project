import java.util.Calendar;

/**
 * @author Brian Walsh
 */
public class OurDateTime{

	private Calendar dateTime = Calendar.getInstance();
	
	public OurDateTime(int year, int month, int date, int hour, int minute) {
		this.dateTime.set(year, month, date, hour, minute);
	}

	public void setDateTime(int year, int month, int date, int hour, int minute) {
		this.dateTime.set(year, month, date, hour, minute);
	}
	
	public int getYear() {
		return this.dateTime.get(Calendar.YEAR);
	}
	
	public void setYear(int year) {
		this.dateTime.set(Calendar.YEAR, year);
	}

	public int getMonth() {
		return this.dateTime.get(Calendar.YEAR);
	}
	
	public void setMonth(int month) {
		this.dateTime.set(Calendar.MONTH, month);
	}
	
	public int getDate() {
		return this.dateTime.get(Calendar.DATE);
	}

	public void setDate(int date) {
		this.dateTime.set(Calendar.DATE, date);
	}
	
	public int getHour() {
		return this.dateTime.get(Calendar.HOUR_OF_DAY);
	}
	
	public void setHour(int hour) {
		this.dateTime.set(Calendar.HOUR_OF_DAY, hour);
	}

	public int getMinute() {
		return this.dateTime.get(Calendar.MINUTE);
	}
	
	public void setMinute(int minute) {
		this.dateTime.set(Calendar.MINUTE, minute);
	}

	public String toString() {
		String info = this.dateTime.get(Calendar.HOUR_OF_DAY) + ":" + this.dateTime.get(Calendar.MINUTE) + " on " + 
					  this.dateTime.get(Calendar.MONTH) + "/" + this.dateTime.get(Calendar.DATE) + "/" + this.dateTime.get(Calendar.YEAR);
		return info;
	}
	
}

