import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CalendarGUI {

    //Add argument that checks if someone is a guest or not
    public void calendarOpenGUI(){

        Pane pane = new Pane();

        Stage stage = new Stage();

        Date today = new Date();

        SimpleDateFormat simpleDateformat = new SimpleDateFormat("EEEE");

        stage.setTitle("Calendar");

        stage.setScene(new Scene(pane, 1000, 700));

        Button day1Label = new Button();
        day1Label.setLayoutX(100);
        day1Label.setLayoutY(80);

        Button day2Label = new Button();
        day2Label.setLayoutX(100);
        day2Label.setLayoutY(160);

        Button day3Label = new Button();
        day3Label.setLayoutX(100);
        day3Label.setLayoutY(240);

        Button day4Label = new Button();
        day4Label.setLayoutX(100);
        day4Label.setLayoutY(320);

        Button day5Label = new Button();
        day5Label.setLayoutX(100);
        day5Label.setLayoutY(400);

        Button day6Label = new Button();
        day6Label.setLayoutX(100);
        day6Label.setLayoutY(480);

        Button day7Label = new Button();
        day7Label.setLayoutX(100);
        day7Label.setLayoutY(560);

        Label dayListed = new Label("Select a day");
        dayListed.setLayoutX(450);
        dayListed.setLayoutY(80);

        Label roomsThisDay = new Label("Select a day and then a room");
        roomsThisDay.setLayoutX(750);
        roomsThisDay.setLayoutY(80);


        Line lineLeft = new Line();
        lineLeft.setStartX(320);
        lineLeft.setStartY(0);
        lineLeft.setEndX(333);
        lineLeft.setEndY(700);

        Line lineRight = new Line();
        lineRight.setStartX(650);
        lineRight.setStartY(0);
        lineRight.setEndX(666);
        lineRight.setEndY(700);


        ArrayList days = new ArrayList();

        days.clear();

        days.add("Sunday");
        days.add("Monday");
        days.add("Tuesday");
        days.add("Wednesday");
        days.add("Thursday");
        days.add("Friday");
        days.add("Saturday");


        String day1;

        day1 = simpleDateformat.format(today);

        int index = 0;


        if(day1.equals("Sunday")){
            index = 0;
        }
        if(day1.equals("Monday")){
            index = 1;
        }
        if(day1.equals("Tuesday")){
            index = 2;
        }
        if(day1.equals("Wednesday")){
            index = 3;
        }
        if(day1.equals("Thursday")){
            index = 4;
        }
        if(day1.equals("Friday")){
            index = 5;
        }
        if(day1.equals("Saturday")){
            index = 6;
        }


        for(int i = 0; i < 7; i++){

            if(index == 7)
                index = 0;

            if(i == 0)
                day1Label.setText(days.get(index) + " (Today)");
            if(i == 1)
                day2Label.setText((String)days.get(index));
            if(i == 2)
                day3Label.setText((String)days.get(index));
            if(i == 3)
                day4Label.setText((String)days.get(index));
            if(i == 4)
                day5Label.setText((String)days.get(index));
            if(i == 5)
                day6Label.setText((String)days.get(index));
            if(i == 6)
                day7Label.setText((String)days.get(index));

            index++;
        }

        //Make an object that can call a method to get available rooms for each day here

        day1Label.setOnAction((ActionEvent event) -> {

            //Make a call to another class to get all available rooms for this day and put the names into a string and display it.

            dayListed.setText(day1);

        });

        day2Label.setOnAction((ActionEvent event) -> {

            dayListed.setText(day2Label.getText());

        });

        day3Label.setOnAction((ActionEvent event) -> {

            dayListed.setText(day3Label.getText());
        });

        day4Label.setOnAction((ActionEvent event) -> {

            dayListed.setText(day4Label.getText());
        });

        day5Label.setOnAction((ActionEvent event) -> {

            dayListed.setText(day5Label.getText());

        });

        day6Label.setOnAction((ActionEvent event) -> {

            dayListed.setText(day6Label.getText());
        });

        day7Label.setOnAction((ActionEvent event) -> {

            dayListed.setText(day7Label.getText());

        });



        pane.getChildren().addAll(day1Label, day2Label, day3Label, day4Label, day5Label, day6Label, day7Label, dayListed, roomsThisDay, lineLeft, lineRight);

        stage.show();

    }

}
