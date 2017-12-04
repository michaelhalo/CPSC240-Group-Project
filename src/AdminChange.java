import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Bryan on 12/1/2017
 */
public class AdminChange {

    boolean ready = false;

    public void adminChangeGUI(ArrayList<Reservation> reservationList, ArrayList<Room> rooms) {

        ready = false;

        ChangeScreen changeScreen = new ChangeScreen();

        Pane pane = new Pane();

        Stage stage = new Stage();

        stage.setTitle("Choose reservation to change");

        stage.setScene(new Scene(pane, 600, 600));

        final int ROW_HEIGHT = 24 * 5;

        ObservableList<String> reservations = FXCollections.observableArrayList();

        for(int i = 0; i < reservationList.size(); i++)
            reservations.add(reservationList.get(i).printReservation());

        ListView reservationView = new ListView(reservations);
        reservationView.setLayoutX(20);
        reservationView.setLayoutY(20);
        reservationView.setPrefWidth(275);
        reservationView.setPrefHeight(15 * ROW_HEIGHT);
   

        Button change = new Button("Change");
        change.setLayoutX(450);
        change.setLayoutY(300);

        reservationView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                ready = true;

            }
        });


        change.setOnAction((ActionEvent event) -> {

            if(ready){
                String printed = (String)reservationView.getSelectionModel().getSelectedItem();

                Reservation reservation;
                for(int i = 0; i < reservationList.size(); i++){
                    reservation = reservationList.get(i);
                    if(reservation.printReservation().equals(printed)){
                        changeScreen.changeScreenGUI(rooms, reservation.getUser(), reservationList, i);
                        stage.close();
                        break;
                    }
                }

            }

        });


        pane.getChildren().addAll(reservationView, change);

        stage.show();

    }
}
