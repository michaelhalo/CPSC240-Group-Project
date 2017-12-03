import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Bryan on 12/1/2017.
 */
public class AdminDelete {

    boolean ready = false;

    public void adminDeleteGUI(ArrayList<User> users){

        Pane pane = new Pane();

        Stage stage = new Stage();

        stage.setTitle("Delete a user");

        stage.setScene(new Scene(pane, 550, 450));


        Label chosen = new Label("Choose a user to delete.");
        chosen.setLayoutX(330);
        chosen.setLayoutY(200);

        Button delete = new Button("Delete");
        delete.setLayoutX(340);
        delete.setLayoutY(230);



        final int ROW_HEIGHT = 24;

        ObservableList<String> reservations = FXCollections.observableArrayList();

        User userTemp;
        for(int i = 0; i < users.size(); i++){
            userTemp = users.get(i);
            reservations.add(userTemp.getName());
        }

        ListView reservationView = new ListView(reservations);
        reservationView.setLayoutX(20);
        reservationView.setLayoutY(20);
        reservationView.setPrefWidth(275);
        reservationView.setPrefHeight(18 * ROW_HEIGHT);

        pane.getChildren().addAll(reservationView, delete, chosen);

        ready = false;
        reservationView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                String userName = (String)reservationView.getSelectionModel().getSelectedItem();
                ready = true;
                chosen.setText(userName);

            }
        });


        delete.setOnAction((ActionEvent event) -> {

            String userName = (String)reservationView.getSelectionModel().getSelectedItem();

            if(ready){
                User user;
                for(int i = 0; i < users.size(); i ++){
                    user = users.get(i);
                    if(user.getName().equals(userName)){
                        users.remove(user);
                        user.saveUsers(users);
                        stage.close();
                        break;
                    }
                }
            }
        });


        stage.show();

    }

}
