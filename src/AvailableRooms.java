import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import java.util.Calendar;
import java.util.ArrayList;

/**
 * Created by Bryan on 11/22/2017.
 */
public class AvailableRooms {

    Calendar calendar = Calendar.getInstance();
    boolean validDnT = true;
    boolean roomChosen = false;

    public void availableRoomsGUI(ArrayList equipmentList, String seating, int groupSize, ArrayList<Room> roomList, User user, ArrayList<Reservation> reservations) {

        Pane pane = new Pane();

        Stage stage = new Stage();

        stage.setTitle("Available Rooms");

        stage.setScene(new Scene(pane, 900, 700));

        final int ROW_HEIGHT = 24;
        roomChosen = false;



        Label roomLabel = new Label("Rooms");
        roomLabel.setLayoutX(310);
        roomLabel.setLayoutY(50);

        ObservableList<String> rooms = FXCollections.observableArrayList();


        ArrayList<Room> validRooms = matchCriteria(equipmentList, seating, groupSize, roomList);
        Room tempRoom;

        for(int i = 0; i < validRooms.size(); i++){
            tempRoom = validRooms.get(i);
            rooms.add(tempRoom.printRoom());
        }


        ListView roomView = new ListView(rooms);
        roomView.setLayoutX(300);
        roomView.setLayoutY(75);
        roomView.setPrefWidth(200);
        roomView.setPrefHeight(rooms.size() * ROW_HEIGHT);

        Label roomError = new Label("You must select a room to make a reservation.");
        roomError.setLayoutX(600);
        roomError.setLayoutY(425);




        Button enter = new Button("Enter");
        enter.setLayoutX(700);
        enter.setLayoutY(650);

        Button back = new Button("Go Back");
        back.setLayoutX(100);
        back.setLayoutY(650);




        Label setDate = new Label("Set the date you want to reserve this room.");
        setDate.setLayoutX(50);
        setDate.setLayoutY(550);

        TextField month = new TextField();
        month.setLayoutX(50);
        month.setLayoutY(600);
        month.setPrefWidth(50);
        month.setPromptText("Month");
        month.clear();

        TextField day = new TextField();
        day.setLayoutX(125);
        day.setLayoutY(600);
        day.setPrefWidth(50);
        day.setPromptText("Day");
        day.clear();

        TextField year = new TextField();
        year.setLayoutX(200);
        year.setLayoutY(600);
        year.setPrefWidth(75);
        year.setPromptText("Year");
        year.clear();

        Text dateError = new Text("You must enter a date.");
        dateError.setLayoutX(150);
        dateError.setLayoutY(585);
        dateError.setFill(Color.RED);




        Label setTime = new Label("Set the time you want to reserve this room.");
        setTime.setLayoutX(350);
        setTime.setLayoutY(550);

        TextField hour = new TextField();
        hour.setLayoutX(400);
        hour.setLayoutY(600);
        hour.setPrefWidth(50);
        hour.setPromptText("Hour");
        hour.clear();

        TextField minute = new TextField();
        minute.setLayoutX(475);
        minute.setLayoutY(600);
        minute.setPrefWidth(50);
        minute.setPromptText("Minute");
        minute.clear();

        Text timeError = new Text("Minute and hour must be filled in.");
        timeError.setLayoutX(275);
        timeError.setLayoutY(585);
        timeError.setFill(Color.RED);


        String equipmentString = "";
        for(int i = 0; i < equipmentList.size(); i++)
            equipmentString = equipmentString + equipmentList.get(i) + "\n";

        Label criteria = new Label("Your criteria: \nSeating type: " + seating + " \nEquipment: " + equipmentString + " Group size: " + groupSize);
        criteria.setLayoutX(525);
        criteria.setLayoutY(75);

        Label roomInfo = new Label("Room information: \nRoom name:  \nBuilding name:  \nSeating type:  \nEquipment:  \nGroup size: \nCriteria met: ");
        roomInfo.setLayoutX(725);
        roomInfo.setLayoutY(75);



        roomView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                String clicked = (String)roomView.getSelectionModel().getSelectedItem();

                roomInfo.setText("Room information: \n" + clicked);

                roomChosen = true;

            }
        });


        enter.setOnAction((ActionEvent event) -> {
            pane.getChildren().remove(roomError);
            pane.getChildren().remove(timeError);
            pane.getChildren().remove(dateError);
            validDnT = true;

            if(!roomChosen)
                pane.getChildren().add(roomError);

            if(hour.getText().equals("") || minute.getText().equals("")){
                timeError.setText("You must set a time.");
                pane.getChildren().add(timeError);
                validDnT = false;
            }

            else if((Integer.parseInt(hour.getText()) < 1 || Integer.parseInt(hour.getText()) > 24)
                    || (Integer.parseInt(minute.getText()) < 0 || Integer.parseInt(minute.getText()) > 59)){
                timeError.setText("You must set an appropriate time.");
                pane.getChildren().add(timeError);
                validDnT = false;
            }


            if(month.getText().equals("") || day.getText().equals("") || year.getText().equals("")){
                dateError.setText("You must set a date.");
                pane.getChildren().add(dateError);
                validDnT = false;
            }


            else {
                int maxDay = calendar.getActualMaximum(Integer.parseInt(month.getText()));
                int minYear = Calendar.getInstance().get(Calendar.YEAR);
                int userMonth = Integer.parseInt(month.getText());
                int userDay = Integer.parseInt(day.getText());
                int userYear = Integer.parseInt(year.getText());


                if ((userYear % 400 == 0) || ((userYear % 4 == 0) && (userYear % 100 != 0))) {
                    if (userMonth == 2)
                        maxDay = 29;
                }


                if (userDay < 1 || userDay > maxDay || userMonth < 1 || userMonth > 12 || userYear < minYear) {
                    dateError.setText("You must set a valid date.");
                    pane.getChildren().add(dateError);
                    validDnT = false;
                }

                if (userYear > (minYear + 1)) {
                    dateError.setText("The year must be set to be within 1 year from this year.");
                    pane.getChildren().remove(dateError);
                    pane.getChildren().add(dateError);
                    validDnT = false;
                }
            }


            if(roomChosen && validDnT){

                String roomName = (String)roomView.getSelectionModel().getSelectedItem();
                String buildingString = "", roomString = "";


                if(roomName.contains("B12")){
                    buildingString = "Trinkle";
                    roomString = "B12";
                }
                else if(roomName.contains("B7")){
                    buildingString = "Trinkle";
                    roomString = "B7";
                }
                else if(roomName.contains("B6")){
                    buildingString = "Trinkle";
                    roomString = "B6";
                }
                else if(roomName.contains("B5")){
                    buildingString = "Trinkle";
                    roomString = "B5";
                }
                else if(roomName.contains("B8")){
                    buildingString = "Trinkle";
                    roomString = "B8";
                }


                else if(roomName.contains("348")){
                    buildingString = "Hurley Convergence Center";
                    roomString = "348";
                }
                else if(roomName.contains("349")){
                    buildingString = "Hurley Convergence Center";
                    roomString = "349";
                }
                else if(roomName.contains("328")){
                    buildingString = "Hurley Convergence Center";
                    roomString = "328";
                }
                else if(roomName.contains("327")){
                    buildingString = "Hurley Convergence Center";
                    roomString = "327";
                }
                else if(roomName.contains("211")){
                    buildingString = "Hurley Convergence Center";
                    roomString = "211";
                }


                else if(roomName.contains("210")){
                    buildingString = "Woodard";
                    roomString = "210";
                }
                else if(roomName.contains("212")){
                    buildingString = "Woodard";
                    roomString = "212";
                }
                else if(roomName.contains("129")){
                    buildingString = "Woodard";
                    roomString = "129";
                }
                else if(roomName.contains("128")){
                    buildingString = "Woodard";
                    roomString = "128";
                }
                else if(roomName.contains("350")){
                    buildingString = "Woodard";
                    roomString = "350";
                }


                String date = month.getText() + " / " + day.getText() + " / " + year.getText();

                String time = hour.getText() + " : " + minute.getText();



                Reservation reservation = new Reservation();

                reservation.setUser(user);
                reservation.setDate(date);
                reservation.setTime(time);
                reservation.setBuilding(buildingString);
                reservation.setRoomNumber(roomString);

                reservations.add(reservation);

                reservation.saveReservations(reservations);

                stage.close();
            }


        });




        MakeReserv makeReserv = new MakeReserv();
        back.setOnAction((ActionEvent event) -> {

            makeReserv.makeReservationGUI(roomList, user, reservations);
            stage.close();

        });



        pane.getChildren().addAll(roomView, roomLabel, back, criteria,
                roomInfo, enter, setDate, day, month, year, setTime, hour, minute);

        stage.show();
    }


    public ArrayList<Room> matchCriteria(ArrayList equipmentList, String seating, int groupSize, ArrayList<Room> rooms){

        ArrayList<Room> roomView = new ArrayList<>();
        ArrayList<String> equipmentTemp;
        Room room;
        int met = 0;

        for(int i = 0; i < rooms.size(); i ++){
            met = 0;
            room = rooms.get(i);
            if(room.getSeatingType().equals(seating))
                met++;
            if(room.getCapacity() > groupSize)
                met++;

            equipmentTemp = room.getEquipment();
            for(int j = 0; j < equipmentTemp.size(); j++){
                if(equipmentList.contains(equipmentTemp.get(j)))
                    met++;
            }

            if(met > 0)
                roomView.add(room);

        }

        return roomView;
    }

}















