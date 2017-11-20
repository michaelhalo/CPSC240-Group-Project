import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class MainMenu {

    public void MainMenuGUI(){

        CalendarGUI calendar = new CalendarGUI();

        Pane pane = new Pane();

        Stage stage = new Stage();

        stage.setTitle("Main Menu");

        stage.setScene(new Scene(pane, 400, 200));

        Button schedule = new Button("View schedule");
        schedule.setLayoutX(50);
        schedule.setLayoutY(100);

        Button reservedRooms = new Button("View your reserved rooms");
        reservedRooms.setLayoutX(200);
        reservedRooms.setLayoutY(100);


        schedule.setOnAction((ActionEvent event) -> {

            calendar.calendarOpenGUI();

        });


        pane.getChildren().addAll(schedule, reservedRooms);

        stage.show();

    }

}
