import java.util.HashMap;

/**
 * @author Brian Walsh
 */
public class RoomList {

	private HashMap<String, Room> roomList = new HashMap<String, Room>();
	
	public void addRoom(Room room) {
		roomList.put(room.toShortString(), room);
	}
	
	public void removeRoom(Room room) {
		roomList.remove(room.toShortString());
	}
	
}
