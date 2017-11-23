import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



/**
 * Created by Bryan on 11/3/2017.
 */
public class SignIn {


    public void signInGUI(Stage stage, Pane pane){

        MainMenu mainMenu = new MainMenu();

        Button openMainMenu = new Button("Sign In");
        openMainMenu.setLayoutX(350);
        openMainMenu.setLayoutY(325);

        pane.getChildren().add(openMainMenu);

        openMainMenu.setOnAction((ActionEvent event) -> {

            mainMenu.MainMenuGUI();

            stage.close();
        });

        stage.show();

    }


}
