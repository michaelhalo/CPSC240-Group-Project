import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;


public class MainMenu {

    public void MainMenuGUI(User user, ArrayList<Room> rooms, ArrayList<Reservation> reservations, ArrayList<User> users){

        CalendarGUI calendar = new CalendarGUI();
        MakeReserv makeReserv = new MakeReserv();
        YourReserved yourReserved = new YourReserved();
        AdminChange adminChange = new AdminChange();
        AdminDelete adminDelete = new AdminDelete();

        Pane pane = new Pane();

        Stage stage = new Stage();

        stage.setTitle("Main Menu");

        if(user.getAdmin() == false)
            stage.setScene(new Scene(pane, 600, 200));

        else
            stage.setScene(new Scene(pane, 900, 200));


        Button schedule = new Button("View next weeks reservations");
        schedule.setLayoutX(185);
        schedule.setLayoutY(100);

        Button reservedRooms = new Button("View your reserved rooms");
        reservedRooms.setLayoutX(385);
        reservedRooms.setLayoutY(100);

        Button makeReservation = new Button("Make reservation");
        makeReservation.setLayoutX(50);
        makeReservation.setLayoutY(100);


        Button changeRes = new Button("Change a reservation");
        changeRes.setLayoutX(560);
        changeRes.setLayoutY(100);

        Button delete = new Button("Delete a user");
        delete.setLayoutX(750);
        delete.setLayoutY(100);



        schedule.setOnAction((ActionEvent event) -> {

            calendar.calendarOpenGUI(reservations);

        });

        makeReservation.setOnAction((ActionEvent event) -> {

            makeReserv.makeReservationGUI(rooms, user, reservations);

        });

        reservedRooms.setOnAction((ActionEvent event) -> {

            yourReserved.yourReservedGUI(reservations, user);

        });

        changeRes.setOnAction((ActionEvent event) -> {

            adminChange.adminChangeGUI(reservations, rooms);

        });

        delete.setOnAction((ActionEvent event) -> {

            adminDelete.adminDeleteGUI(users);

        });


        if(user.getAdmin() == false)
            pane.getChildren().addAll(schedule, reservedRooms, makeReservation);
        else
            pane.getChildren().addAll(schedule, reservedRooms, makeReservation, changeRes, delete);

        stage.show();

    }

}
