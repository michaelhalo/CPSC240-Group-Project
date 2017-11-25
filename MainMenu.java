import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;


public class MainMenu {

    public void MainMenuGUI(){

        CalendarGUI calendar = new CalendarGUI();
        MakeReserv makeReserv = new MakeReserv();

        Pane pane = new Pane();

        Stage stage = new Stage();

        stage.setTitle("Main Menu");

        stage.setScene(new Scene(pane, 600, 200));

        Button schedule = new Button("View next weeks reservations");
        schedule.setLayoutX(185);
        schedule.setLayoutY(100);

        Button reservedRooms = new Button("View your reserved rooms");
        reservedRooms.setLayoutX(385);
        reservedRooms.setLayoutY(100);

        Button makeReservation = new Button("Make reservation");
        makeReservation.setLayoutX(50);
        makeReservation.setLayoutY(100);


        schedule.setOnAction((ActionEvent event) -> {

            calendar.calendarOpenGUI();

        });

        makeReservation.setOnAction((ActionEvent event) -> {

            makeReserv.makeReservationGUI();
            // Make a window where you choose criteria for a room

        });


        pane.getChildren().addAll(schedule, reservedRooms, makeReservation);

        stage.show();

    }

}
