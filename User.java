import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Brian Walsh
 */
public class User implements Serializable{

    String name;
    String password;
    int userId;
    boolean admin;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public boolean getAdmin() {
        return this.admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public String toString() {
        String adminYesNo;
        if(admin) adminYesNo = "Yes"; else adminYesNo = "No";

        String info = ("Class name: " + this.getClass().getSimpleName() + ", \n" +
                "Name: " + this.name + ",\n" +
                "Password: " + this.password + ",\n" +
                "Admin: " + adminYesNo);
        return info;
    }

    public void saveUsers(ArrayList users){

        try{
            FileOutputStream fileOut = new FileOutputStream("Users.txt", false);
            ObjectOutputStream output = new ObjectOutputStream(fileOut);

            for(int i = 0; i < users.size(); i++) {
                output.writeObject(users.get(i));
            }

            fileOut.close();
            output.close();
        }
        catch(Exception ex){

        }

    }

    public ArrayList getUsers(){

        ArrayList<User> users = new ArrayList<>();

        boolean EOF = true;

        try {
            FileInputStream fileIn = new FileInputStream("Users.txt");
            ObjectInputStream input = new ObjectInputStream(fileIn);

            while(EOF) {
                try {
                    User user = (User)input.readObject();
                    users.add(user);
                } catch (Exception ex) {
                    EOF = false;
                }
            }

            input.close();
            fileIn.close();
        }
        catch(Exception ex){
            System.out.println(ex);
        }


        saveUsers(users);
        return users;
    }

}