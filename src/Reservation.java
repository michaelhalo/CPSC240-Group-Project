import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author Michael
 * @version 2.0
 */
public class Reservation extends Room implements java.io.Serializable{

    private String date, time;
    private User user;
    private String building;
    private String roomNumber;


    public void setUser(User user) {
        this.user = user;
    }
    public User getUser() {
        return this.user;
    }


    public void setDate(String date){
        this.date = date;
    }
    public String getDate(){
        return this.date;
    }


    public void setTime(String time){
        this.time = time;
    }
    public String getTime(){
        return this.time;
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




    public String printReservation(){

        User temp = this.getUser();

        return "User: " + temp.getName() + "\nBuilding: " + this.getBuilding()
                + "\nRoom: " + this.getRoomNumber() + "\nDate: " + this.getDate()
                + "\nTime: " + this.getTime();
    }


    public String toString() {
        String info = super.toString();
        info = info + ", \n" + user.toString();
        return info;
    }

    public String toShortString() {
        String info = this.user.getName() + " " + this.getBuilding() + " " + this.getRoomNumber();
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