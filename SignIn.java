import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;


public class SignIn {


    public void signInGUI(Stage stage, Pane pane){

        MainMenu openMainMenu = new MainMenu();
        SignUp openSignUp = new SignUp();
        CalendarGUI calendarGuest = new CalendarGUI();

        TextField usernameTextField = new TextField();
        usernameTextField.setPromptText("Username");
        usernameTextField.setLayoutX(30);
        usernameTextField.setLayoutY(80);

        TextField passwordTextField = new TextField();
        passwordTextField.setPromptText("Password");
        passwordTextField.setLayoutX(30);
        passwordTextField.setLayoutY(130);

        Button signIn = new Button("Sign In");
        signIn.setLayoutX(50);
        signIn.setLayoutY(180);

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

            openMainMenu.MainMenuGUI();

            stage.close();
        });


        signUp.setOnAction((ActionEvent event) -> {

            openSignUp.signUpGUI(users);

        });

        guest.setOnAction((ActionEvent event) -> {

            calendarGuest.calendarOpenGUI();

        });




        stage.show();

    }


}
