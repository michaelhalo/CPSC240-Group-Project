import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Bryan on 12/3/2017.
 */
public class ChangeScreen {

    boolean equipmentBoolean = false, seatingBoolean = false;

    public void changeScreenGUI(ArrayList<Room> rooms, User user, ArrayList<Reservation> reservations, int index) {

        Pane pane = new Pane();

        Stage stage = new Stage();

        stage.setTitle("Choose criteria for reservation change");

        stage.setScene(new Scene(pane, 850, 500));

        ChangeRoom changeRoom = new ChangeRoom();


        Button enter = new Button("Enter");
        enter.setLayoutX(390);
        enter.setLayoutY(420);


        Label selectLabel = new Label("Select what you are looking for.");
        selectLabel.setLayoutX(360);
        selectLabel.setLayoutY(50);



        final int ROW_HEIGHT = 24;

        ObservableList<String> equipment = FXCollections.observableArrayList();

        equipment.add("Projector");
        equipment.add("Smart board");
        equipment.add("TVs");
        equipment.add("Computers");

        ListView equipmentView = new ListView(equipment);
        equipmentView.setLayoutX(50);
        equipmentView.setLayoutY(150);
        equipmentView.setPrefWidth(150);
        equipmentView.setPrefHeight(equipment.size() * ROW_HEIGHT);

        Label chosenEquipment = new Label("Chosen equipment: \n");
        chosenEquipment.setLayoutX(215);
        chosenEquipment.setLayoutY(150);

        ArrayList equipmentList = new ArrayList();

        ObservableList<String> seatings = FXCollections.observableArrayList();

        seatings.add("Tables");
        seatings.add("Desks");
        seatings.add("Chairs");
        seatings.add("Auditorium seating");

        ListView seatingTypeView = new ListView(seatings);
        seatingTypeView.setLayoutX(350);
        seatingTypeView.setLayoutY(150);
        seatingTypeView.setPrefWidth(150);
        seatingTypeView.setPrefHeight(seatings.size() * ROW_HEIGHT);




        TextField groupSize = new TextField();
        groupSize.setLayoutX(650);
        groupSize.setLayoutY(150);
        groupSize.setPromptText("Room capacity");
        groupSize.clear();

        Text notNumberError = new Text("You need to enter a positive integer");
        notNumberError.setLayoutX(630);
        notNumberError.setLayoutY(125);
        notNumberError.setFill(Color.RED);



        pane.getChildren().addAll(enter, selectLabel, equipmentView, seatingTypeView, groupSize, chosenEquipment);

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

                if(equipmentList.size() == 0)
                    equipmentBoolean = false;
                else
                    equipmentBoolean = true;
            }
        });



        seatingTypeView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                seatingBoolean = true;

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

            if(valid && equipmentBoolean && seatingBoolean) {
                changeRoom.changeRoomGUI(equipmentList, (String)seatingTypeView.getSelectionModel().getSelectedItem(), group, rooms, user, reservations, index);
                stage.close();
            }
        });











    }


}
