import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class CalendarGUI {

    public void calendarOpenGUI(ArrayList<Reservation> reservationList){

        Pane pane = new Pane();

        Stage stage = new Stage();

        stage.setTitle("Reservations");

        stage.setScene(new Scene(pane, 325, 450));

        final int ROW_HEIGHT = 24 * 5;

        ObservableList<String> reservations = FXCollections.observableArrayList();

        for(int i = 0; i < reservationList.size(); i++)
            reservations.add(reservationList.get(i).printReservation());

        ListView reservationView = new ListView(reservations);
        reservationView.setLayoutX(20);
        reservationView.setLayoutY(20);
        reservationView.setPrefWidth(275);
        reservationView.setPrefHeight(reservations.size() * ROW_HEIGHT);

        pane.getChildren().addAll(reservationView);

        stage.show();

    }

}
