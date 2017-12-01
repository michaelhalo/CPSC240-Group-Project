import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author Michael
 * @version 2.0
 */
public class Reservation extends Room implements java.io.Serializable{

   private User user; 
   private OurDateTime dateTime;
   
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
      info = info + ", \n" + user.toString() + ",\n" + dateTime.toString();
      return info;
   }
   
   public String toShortString() {
      String info = this.user.getName() + " " + this.getBuilding() + " " + this.getRoomNumber() + " " + this.dateTime.toString();
      return info;
   }
   
   public void saveReservations(ArrayList reservations){
   
      try{
         FileOutputStream fileOut = new FileOutputStream("Reservations.txt", false);
         ObjectOutputStream output = new ObjectOutputStream(fileOut);
      
         for(int i = 0; i < reservations.size(); i++) {
            output.writeObject(reservations.get(i));
         }
      
         fileOut.close();
         output.close();
      }
      catch(Exception ex){
      
      }
   
   }

   public ArrayList getReservations(){
   
      ArrayList<Reservation> reservations = new ArrayList<>();
   
      boolean EOF = true;
   
      try {
         FileInputStream fileIn = new FileInputStream("Reservations.txt");
         ObjectInputStream input = new ObjectInputStream(fileIn);
      
         while(EOF) {
            try {
               Reservation reservation = (Reservation)input.readObject();
               reservations.add(reservation);
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
   
   saveReservations(reservations);
   return reservations;
   
   }

}
