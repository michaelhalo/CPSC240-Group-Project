import java.util.ArrayList;

public class Room {

	private String building;
	private String roomNumber;
	private ArrayList<String> equipment;
	private String seatingType;
	private int capacity;
	
	private String getBuilding() {
		return this.building;
	}
	
	private void setBuilding(String building) {
		this.building = building;
	}
	
	private String getRoomNumber() {
		return this.roomNumber;
	}
	
	private void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	private ArrayList<String> getEquipment(){
		return this.equipment;
	}
	
	private void setEquipment(ArrayList<String> equipment) {
		this.equipment = equipment;
	}
	
	private void addEquipment(String equipmentItem) {
		this.equipment.add(equipmentItem);
	}
	
	private String getSeatingType() {
		return this.seatingType;
	}
	
	private void setSeatingType(String seatingType) {
		this.seatingType = seatingType;
	}
	
	private int getCapacity() {
		return this.capacity;
	}
	
	private void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
