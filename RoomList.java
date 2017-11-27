import java.util.ArrayList;

/**
 * @author Brian Walsh
 */
public class RoomList {

	private ArrayList<Room> roomList = new ArrayList<Room>();
	
	public void addRoom(Room room) {
		roomList.add(room);
	}
	
	public void removeRoom(Room room) {
		roomList.remove(room);
	}
	
}
