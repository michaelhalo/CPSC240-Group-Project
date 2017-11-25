import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
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

        stage.setScene(new Scene(pane, 850, 500));

        AvailableRooms availableRooms = new AvailableRooms();


        Button enter = new Button("Enter");
        enter.setLayoutX(390);
        enter.setLayoutY(420);


        Label selectLabel = new Label("Select what you are looking for.");
        selectLabel.setLayoutX(360);
        selectLabel.setLayoutY(50);



        final int ROW_HEIGHT = 24;


        //Have "anything" be an option

        //Make an object to the class with all the equipment options and use it to return an array with strings of each equipment in it.

        ObservableList<String> equipment = FXCollections.observableArrayList();

        //make a for loop that adds everything from the array to the observable list

        ListView equipmentView = new ListView(equipment);
        equipmentView.setLayoutX(50);
        equipmentView.setLayoutY(150);
        equipmentView.setPrefWidth(150);
        equipmentView.setPrefHeight(equipment.size() * ROW_HEIGHT);

        Label chosenEquipment = new Label("Chosen equipment: \n");
        chosenEquipment.setLayoutX(215);
        chosenEquipment.setLayoutY(150);

        ArrayList equipmentList = new ArrayList();


        //Make an object to the class with all the seating options and use it to return an array with strings of each seating type in it.

        ObservableList<String> seatings = FXCollections.observableArrayList();

        //make a for loop that adds everything from the array to the observable list

        ListView seatingTypeView = new ListView(seatings);
        seatingTypeView.setLayoutX(350);
        seatingTypeView.setLayoutY(150);
        seatingTypeView.setPrefWidth(150);
        seatingTypeView.setPrefHeight(seatings.size() * ROW_HEIGHT);

        Label chosenSeating = new Label("Chosen seating types: \n");
        chosenSeating.setLayoutX(515);
        chosenSeating.setLayoutY(150);

        ArrayList seatingList = new ArrayList();


        //Group size means max size. I don't think we should bother setting ranges of sizes.

        TextField groupSize = new TextField();
        groupSize.setLayoutX(650);
        groupSize.setLayoutY(150);
        groupSize.setPromptText("Room capacity");

        Text notNumberError = new Text("You need to enter a positive integer");
        notNumberError.setLayoutX(630);
        notNumberError.setLayoutY(125);
        notNumberError.setFill(Color.RED);



        pane.getChildren().addAll(enter, selectLabel, equipmentView, seatingTypeView, groupSize, chosenEquipment, chosenSeating);

        stage.show();


        equipmentView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if(equipmentList.contains(equipmentView.getSelectionModel().getSelectedItem()))
                    equipmentList.remove(equipmentView.getSelectionModel().getSelectedItem());

                else
                    equipmentList.add(equipmentView.getSelectionModel().getSelectedItem());

                String equipmentsString = "";

                for(int i = 0; i < equipmentList.size(); i++)
                    equipmentsString += equipmentList.get(i) + "\n";

                chosenEquipment.setText("Chosen equipment: \n" + equipmentsString);

            }
        });



        seatingTypeView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                if(seatingList.contains(seatingTypeView.getSelectionModel().getSelectedItem()))
                    seatingList.remove(seatingTypeView.getSelectionModel().getSelectedItem());

                else
                    seatingList.add(seatingTypeView.getSelectionModel().getSelectedItem());

                String seatingString = "";

                for(int i = 0; i < seatingList.size(); i++)
                    seatingString += seatingList.get(i) + "\n";

                chosenSeating.setText("Chosen seating types: \n" + seatingString);

            }
        });


        enter.setOnAction((ActionEvent event) -> {

            pane.getChildren().remove(notNumberError);

            int group = 0;
            boolean valid = true;

            try{
                group = Integer.parseInt(groupSize.getText());
            }
            catch(Exception ex){
                pane.getChildren().add(notNumberError);
                valid = false;
            }

            if(valid) {
                availableRooms.availableRoomsGUI(equipmentList, seatingList, group);
                stage.close();
            }
        });











    }

}

