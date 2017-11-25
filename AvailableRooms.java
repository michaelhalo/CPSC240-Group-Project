import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Bryan on 11/22/2017.
 */
public class AvailableRooms {

    public void availableRoomsGUI(ArrayList equipmentList, ArrayList seatingList, int groupSize) {


        Pane pane = new Pane();

        Stage stage = new Stage();

        stage.setTitle("Available Rooms");

        stage.setScene(new Scene(pane, 650, 650));

        final int ROW_HEIGHT = 24;


        //Selecting a building name narrows down the rooms presented to just rooms in that building.

        //Displays all rooms with at least one requirement met, with more requirements being listed at the top.

        //Clicking a room shows all of the information of that room, including times available.

        //User sets what day and time they want it. Do we just let them set ranges for time?

        ObservableList<String> buildings = FXCollections.observableArrayList("Building name here - # rooms");

        //Make an array that has objects of each building? Have the number of rooms that meet the criteria be a variable that the object has.

        ListView buildingView = new ListView(buildings);
        buildingView.setLayoutX(75);
        buildingView.setLayoutY(75);
        buildingView.setPrefWidth(150);
        buildingView.setPrefHeight(buildings.size() * ROW_HEIGHT);


        ObservableList<String> rooms = FXCollections.observableArrayList("Room name here - building name-  # requirements met");

        //Make an array with objects of all rooms that meet the criteria.

        ListView roomView = new ListView(rooms);
        roomView.setLayoutX(500);
        roomView.setLayoutY(250);
        roomView.setPrefWidth(150);
        roomView.setPrefHeight(buildings.size() * ROW_HEIGHT);



        Label equipment = new Label("Equipment in room: \n");
        equipment.setLayoutX(0);
        equipment.setLayoutY(0);

        Label seatings = new Label("Seating types: \n");
        seatings.setLayoutX(0);
        seatings.setLayoutY(0);

        //Make a label showing all the criteria the user chose.


        buildingView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //When a building is chosen, make the room list only be filled with rooms from that building.
            }
        });


        roomView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                //When a room is chosen, show information of that room. Allow the user to choose that room and then choose a time?
                //How will that work? Will they go to another screen? Are there limits to when you can reserve it?
            }
        });


        pane.getChildren().addAll(buildingView, roomView);

        stage.show();
    }
}
