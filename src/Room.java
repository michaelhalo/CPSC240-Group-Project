import java.util.ArrayList;

/**
 * @author Brian Walsh
 */
public class Room{

	private String building;
	private String roomNumber;
	private ArrayList<String> equipment;
	private String seatingType;
	private int capacity;
	private int criteria;

	public Room(){
      this.building = "University Center (Default)";
      this.roomNumber = "Room 112 (Default)";
	}

	public Room(String building, String roomNumber, ArrayList equipment, String seatingType, int capacity){
		this.building = building;
		this.roomNumber = roomNumber;
		this.equipment = equipment;
		this.seatingType = seatingType;
		this.capacity = capacity;
	}

	public String getBuilding() {
		return this.building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getRoomNumber() {
		return this.roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public ArrayList<String> getEquipment(){
		return this.equipment;
	}

	public void setEquipment(ArrayList<String> equipment) {
		this.equipment = equipment;
	}

	public void addEquipment(String equipmentItem) {
		this.equipment.add(equipmentItem);
	}

	public String getSeatingType() {
		return this.seatingType;
	}

	public void setSeatingType(String seatingType) {
		this.seatingType = seatingType;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setCriteria(int criteria){
		this.criteria = criteria;
	}

	public int getCriteria(){
		return this.criteria;
	}

	public String printRoom(){

		ArrayList<String> equipmentList = this.getEquipment();
		String equipmentString = "";

		for(int i = 0; i < equipmentList.size(); i++)
			equipmentString = equipmentString + equipmentList.get(i) + "\n";

		String roomString = "Room name: " + this.getRoomNumber() + " \nBuilding name: " + this.getBuilding() + " \nSeating type: " + this.getSeatingType() + " \nEquipment: " + equipmentString + " Group size: " + this.getCapacity();

		return roomString;
	}


	public String toString() {

		String items = "";
		for(String e: this.equipment) {
			items = items + ", " + e;
		}

		String info = ("Class name: " + this.getClass().getSimpleName() + ", \n" +
				"Room location: " + this.building + " Room # " + this.roomNumber + ", \n" +
				"Seating is: " + this.capacity + " seats of the " + this.seatingType + " type, \n" +
				"Room contains: " + items.trim() + ".");
		return info;
	}

	public String toShortString() {
		String info = this.building + " #" + this.roomNumber;
		return info;
	}
}