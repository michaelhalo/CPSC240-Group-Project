import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception{

        SignIn signIn = new SignIn();

        Pane pane = new Pane();

        stage.setTitle("Sign In");

        stage.setScene(new Scene(pane, 700, 300));

        signIn.signInGUI(stage, pane);

    }

    public static void main (String[]args){
        launch(args);
    }
}
