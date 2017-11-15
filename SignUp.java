import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by Bryan on 11/12/2017.
 */
public class SignUp {

    public void signUpGUI(){

        Pane pane = new Pane();

        Stage stage = new Stage();

        stage.setTitle("Sign Up");

        stage.setScene(new Scene(pane, 320, 300));

        TextField username = new TextField("Username");
        username.setLayoutX(90);
        username.setLayoutY(100);

        TextField password = new TextField("Password");
        password.setLayoutX(90);
        password.setLayoutY(150);

        Button enter = new Button("Enter");
        enter.setLayoutX(130);
        enter.setLayoutY(210);

        pane.getChildren().addAll(username, password, enter);

        stage.show();

    }

}
