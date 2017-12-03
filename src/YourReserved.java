import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Bryan on 12/3/2017.
 */
public class YourReserved {

    public void yourReservedGUI(ArrayList<Reservation> reservationList, User user){
        Pane pane = new Pane();

        Stage stage = new Stage();

        stage.setTitle("Your Reservations");

        stage.setScene(new Scene(pane, 325,450));


        final int ROW_HEIGHT = 24 * 5;

        ObservableList<String> reservations = FXCollections.observableArrayList();

        Reservation resTemp;
        User userTemp;

        for(int i = 0; i<reservationList.size();i++) {
            resTemp = reservationList.get(i);
            userTemp = resTemp.getUser();

            if(userTemp.getName().equals(user.getName()))
                reservations.add(reservationList.get(i).printReservation());
        }


        ListView reservationView = new ListView(reservations);
        reservationView.setLayoutX(20);
        reservationView.setLayoutY(20);
        reservationView.setPrefWidth(275);
        reservationView.setPrefHeight(reservations.size()*ROW_HEIGHT);

        pane.getChildren().addAll(reservationView);

        stage.show();
}
}
