import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by Bryan on 11/12/2017.
 */
public class SignUp extends User {

    public void signUpGUI(ArrayList<User> users) {

            Pane pane = new Pane();

            Stage stage = new Stage();

            stage.setTitle("Sign Up");

            stage.setScene(new Scene(pane, 320, 300));


            TextField username = new TextField();
            username.setLayoutX(90);
            username.setLayoutY(100);
            username.setPromptText("Username");

            Text error = new Text("This username is taken");
            error.setLayoutX(85);
            error.setLayoutY(65);
            error.setFill(Color.RED);

            PasswordField password = new PasswordField();
            password.setLayoutX(90);
            password.setLayoutY(150);
            password.setPromptText("Password");

            Button enter = new Button("Enter");
            enter.setLayoutX(130);
            enter.setLayoutY(210);


            enter.setOnAction((ActionEvent event) -> {

                String newName = username.getText();
                String newPassword = password.getText();
                boolean unique = true;
                User temp;

                if (password.getText().equals("") && username.getText().equals("")) {
                    error.setText("Please enter a username and password");
                    error.setLayoutX(75);
                    pane.getChildren().remove(error);
                    pane.getChildren().add(error);
                    unique = false;
                } else if (username.getText().equals("")) {
                    error.setText("Please enter a username");
                    error.setLayoutX(85);
                    pane.getChildren().remove(error);
                    pane.getChildren().add(error);
                    unique = false;
                } else if (password.getText().equals("")) {
                    error.setText("Please enter a password");
                    error.setLayoutX(85);
                    pane.getChildren().remove(error);
                    pane.getChildren().add(error);
                    unique = false;
                }

                for (int i = 0; i < users.size(); i++) {
                    temp = users.get(i);
                    if (newName.equals(temp.getName())) {
                        error.setText("This username is taken");
                        error.setLayoutX(85);
                        pane.getChildren().remove(error);
                        pane.getChildren().add(error);
                        unique = false;
                    }
                }

                if (unique) {
                    pane.getChildren().remove(error);
                    username.clear();
                    password.clear();

                    User newUser = new User();

                    newUser.setName(newName);
                    newUser.setPassword(newPassword);
                    newUser.setAdmin(false);
                    newUser.setUserId(1); //Is an ID necessary?

                    users.add(newUser);

                    if (users.size() != 0) {
                        for (int i = 0; i < users.size(); i++)
                            System.out.println(users.get(i).getName());
                    }

                    saveUsers(users);
                    stage.close();
                }

            });


            pane.getChildren().addAll(username, password, enter);

            stage.show();

        }

    }


