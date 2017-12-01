import java.util.ArrayList;
import java.io.*;

/**
 * @author Brian Walsh
 */
public class Room{

	private String building;
	private String roomNumber;
	private ArrayList<String> equipment;
	private String seatingType;
	private int capacity;

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
   
  public void saveRooms(ArrayList rooms){
   
      try{
         FileOutputStream fileOut = new FileOutputStream("Rooms.txt", false);
         ObjectOutputStream output = new ObjectOutputStream(fileOut);
      
         for(int i = 0; i < rooms.size(); i++) {
            output.writeObject(rooms.get(i));
         }
      
         fileOut.close();
         output.close();
      }
      catch(Exception ex){
      
      }
   
   }

   public ArrayList getRooms(){
   
      ArrayList<Room> rooms = new ArrayList<>();
   
      boolean EOF = true;
   
      try {
         FileInputStream fileIn = new FileInputStream("Rooms.txt");
         ObjectInputStream input = new ObjectInputStream(fileIn);
      
         while(EOF) {
            try {
               Room room = (Room)input.readObject();
               rooms.add(room);
            } 
            catch (Exception ex) {
               EOF = false;
            }
         }
      
         input.close();
         fileIn.close();
      }
      catch(Exception ex){
         System.out.println(ex);
      }
   
   saveRooms(rooms);
   return rooms;
   }
   
}//class bracket