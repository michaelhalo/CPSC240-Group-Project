import java.util.ArrayList;
import java.io.*;

/**
 * @author Brian Walsh
 */
public class RoomList implements Serializable{

	private ArrayList<Room> roomList = new ArrayList<Room>();
	
	public void addRoom(Room room) {
		roomList.add(room);
	}
	
	public void removeRoom(Room room) {
		roomList.remove(room);
	}
	
   public void saveRooms(){
   
      try{
         FileOutputStream fileOut = new FileOutputStream("Rooms.txt", false);
         ObjectOutputStream output = new ObjectOutputStream(fileOut);
      
         for(int i = 0; i < this.roomList.size(); i++) {
            output.writeObject(this.roomList.get(i));
         }
      
         fileOut.close();
         output.close();
      }
      catch(Exception ex){
      
      }
   
   }

   public ArrayList getRooms(){
   
      boolean EOF = true;
   
      try {
         FileInputStream fileIn = new FileInputStream("Rooms.txt");
         ObjectInputStream input = new ObjectInputStream(fileIn);
      
         while(EOF) {
            try {
               Room room = (Room)input.readObject();
               this.roomList.add(room);
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
   
   saveRooms();
   return this.roomList;
   }
   
}
