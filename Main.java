import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by Bryan on 10/31/2017.
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{

        SignIn signIn = new SignIn();

        Pane pane = new Pane();

        stage.setTitle("Sign In");

        stage.setScene(new Scene(pane, 1000, 500));

        signIn.signInGUI(stage, pane);

    }

    public static void main (String[]args){
        launch(args);
    }
}
