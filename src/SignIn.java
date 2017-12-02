import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;

import java.util.ArrayList;


public class SignIn {

    User temp = new User();

    public void signInGUI(Stage stage, Pane pane){


        ArrayList<Room> rooms = makeRooms();


        MainMenu openMainMenu = new MainMenu();
        SignUp openSignUp = new SignUp();
        CalendarGUI calendarGuest = new CalendarGUI();

        TextField usernameTextField = new TextField();
        usernameTextField.setPromptText("Username");
        usernameTextField.setLayoutX(30);
        usernameTextField.setLayoutY(80);

        PasswordField passwordTextField = new PasswordField();
        passwordTextField.setPromptText("Password");
        passwordTextField.setLayoutX(30);
        passwordTextField.setLayoutY(130);

        Button signIn = new Button("Sign In");
        signIn.setLayoutX(50);
        signIn.setLayoutY(180);

        Text signInError = new Text("Enter your username and password.");
        signInError.setLayoutX(30);
        signInError.setLayoutY(60);
        signInError.setFill(Color.RED);



        Button signUp = new Button("Sign Up");
        signUp.setLayoutX(300);
        signUp.setLayoutY(180);

        Button guest = new Button("View schedule as a guest");
        guest.setLayoutX(500);
        guest.setLayoutY(180);

        pane.getChildren().addAll(usernameTextField, passwordTextField, signIn, signUp, guest);


        User user = new User();

        ArrayList<User> users = user.getUsers();


        signIn.setOnAction((ActionEvent event) -> {
            pane.getChildren().remove(signInError);
            boolean valid = false;

            if(usernameTextField.getText().equals("") || passwordTextField.getText().equals("")){
                signInError.setText("Enter your username and password.");
                pane.getChildren().add(signInError);
            }

            else{
                for(int i = 0; i < users.size(); i++){
                    temp = users.get(i);
                    if(temp.getName().equals(usernameTextField.getText()) && temp.getPassword().equals(passwordTextField.getText())){
                        valid = true;
                        break;
                    }
                }
            }

            if(valid){

                openMainMenu.MainMenuGUI(temp, rooms);

                stage.close();

            }
        });


        signUp.setOnAction((ActionEvent event) -> {

            openSignUp.signUpGUI(users);

        });

        guest.setOnAction((ActionEvent event) -> {

            calendarGuest.calendarOpenGUI(rooms);

        });




        stage.show();

    }

    public ArrayList<Room> makeRooms(){

        //Please give each building name and room name in the Room object initializers appropriate names. THe buildings should have names of actual UMW buildings, but the rooms can have whatever name.
        //Leave the Arraylist and Room object names as they are.

        ArrayList room1 = new ArrayList();
        room1.add("Projector");
        Room b1Room1 = new Room("Trinkle", "B12", room1, "Tables", 10);


        ArrayList room2 = new ArrayList();
        room2.add("Smart board");
        Room b1Room2 = new Room("Trinkle", "B7", room2, "Desks", 34);


        ArrayList room3 = new ArrayList();
        room3.add("Computers");
        room3.add("Smart board");
        Room b1Room3 = new Room("Trinkle", "B6", room3, "Tables", 25);


        ArrayList room4 = new ArrayList();
        room4.add("TV");
        room4.add("Projector");
        room4.add("Smart board");
        room4.add("Computers");
        Room b1Room4 = new Room("Trinkle", "B5", room4, "Auditorium", 50);


        ArrayList room5 = new ArrayList();
        room5.add("TV");
        room5.add("Projector");
        Room b1Room5 = new Room("Trinkle", "B8", room5, "Chairs", 9);




        ArrayList room6 = new ArrayList();
        room6.add("Computers");
        Room b2Room1 = new Room("Hurley Convergence Center", "348", room6, "Chairs", 15);


        ArrayList room7 = new ArrayList();
        room7.add("TV");
        Room b2Room2 = new Room("Hurley Convergence Center", "349", room7, "Tables", 16);


        ArrayList room8 = new ArrayList();
        room8.add("Computers");
        room8.add("Projector");
        Room b2Room3 = new Room("Hurley Convergence Center", "328", room8, "Tables", 18);


        ArrayList room9 = new ArrayList();
        room9.add("TV");
        Room b2Room4 = new Room("Hurley Convergence Center", "327", room9, "Desks", 24);


        ArrayList room10 = new ArrayList();
        room10.add("Smart board");
        room10.add("Computers");
        Room b2Room5 = new Room("Hurley Convergence Center", "211", room10, "Desks", 35);




        ArrayList room11 = new ArrayList();
        room11.add("TV");
        room11.add("Projector");
        room11.add("Computers");
        Room b3Room1 = new Room("Woodard", "211", room11, "Auditorium", 45);


        ArrayList room12 = new ArrayList();
        room12.add("TV");
        Room b3Room2 = new Room("Woodard", "212", room12, "Chairs", 31);


        ArrayList room13 = new ArrayList();
        room13.add("Projector");
        Room b3Room3 = new Room("Woodard", "129", room13, "Desks", 38);


        ArrayList room14 = new ArrayList();
        room14.add("TV");
        room14.add("Smart board");
        Room b3Room4 = new Room("Woodard", "128", room14, "Desks", 10);


        ArrayList room15 = new ArrayList();
        room15.add("TV");
        room15.add("Computers");
        Room b3Room5 = new Room("Woodard", "349", room15, "Tables", 6);




        ArrayList<Room> roomList = new ArrayList<>();

        roomList.add(b1Room1);
        roomList.add(b1Room2);
        roomList.add(b1Room3);
        roomList.add(b1Room4);
        roomList.add(b1Room5);

        roomList.add(b2Room1);
        roomList.add(b2Room2);
        roomList.add(b2Room3);
        roomList.add(b2Room4);
        roomList.add(b2Room5);

        roomList.add(b3Room1);
        roomList.add(b3Room2);
        roomList.add(b3Room3);
        roomList.add(b3Room4);
        roomList.add(b3Room5);




        return roomList;

    }

}
