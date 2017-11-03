import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by Bryan on 11/3/2017.
 */
public class MainMenu {

    public void MainMenuGUI(){

        Pane pane = new Pane();

        Stage stage = new Stage();

        stage.setTitle("Main Menu");

        stage.setScene(new Scene(pane, 700, 500));

        stage.show();

    }

}
