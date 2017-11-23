import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Bryan on 11/20/2017.
 */
public class MakeReserv {

    public void makeReservationGUI() {

        Pane pane = new Pane();

        Stage stage = new Stage();

        stage.setTitle("Make a reservation");

        stage.setScene(new Scene(pane, 850, 700));





        ObservableList<String> buildings = FXCollections.observableArrayList("BUILDING1", "BUILDING2");

        ComboBox buildingBox = new ComboBox(buildings);
        buildingBox.setLayoutX(50);
        buildingBox.setLayoutY(250);
        buildingBox.setValue("Buildings");






        String roomTest = "ROOM1";

        ObservableList<String> rooms = FXCollections.observableArrayList(roomTest, "ROOM2");

        ComboBox roomBox = new ComboBox(rooms);
        roomBox.setLayoutX(200);
        roomBox.setLayoutY(250);
        roomBox.setValue("Rooms");





        ArrayList equipmentList = new ArrayList();

        equipmentList.add("THING1");
        equipmentList.add("THING2");
        equipmentList.add("THING3");


        ObservableList<String> equipment = FXCollections.observableArrayList();

        for(int i = 0; i < equipmentList.size(); i++)
            equipment.add((String)equipmentList.get(i));

        ComboBox equipmentBox = new ComboBox(equipment);
        equipmentBox.setLayoutX(350);
        equipmentBox.setLayoutY(250);
        equipmentBox.setValue("Equipment");



        ObservableList<String> seatings = FXCollections.observableArrayList();

        ComboBox seatingTypeBox = new ComboBox(seatings);

        seatingTypeBox.getItems().addAll("SEATINGS1", "SEATINGS2", "SEATINGS3");

        seatingTypeBox.setLayoutX(500);
        seatingTypeBox.setLayoutY(250);
        seatingTypeBox.setValue("Seatings");




        TextField groupSize = new TextField();
        groupSize.setLayoutX(650);
        groupSize.setLayoutY(250);
        groupSize.setPromptText("Room capacity");




        pane.getChildren().addAll(buildingBox, roomBox, equipmentBox, seatingTypeBox, groupSize);

        stage.show();
    }

}

