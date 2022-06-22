package com.example.cng457desktopapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Main page
 */
public class MainPageController {

    /**
     * Radio Button for adding concert
     */
    @FXML
    private RadioButton add_concert;

    /**
     * Radio Button for adding festival run
     */
    @FXML
    private RadioButton add_festivalrun;

    /**
     * Button for continuing the next windows
     */
    @FXML
    private Button cont;

    /**
     * Radio Button for statistics
     */
    @FXML
    private RadioButton stats;

    /**
     * Method for selecting a menu to go to
     * @param event Clicking on continue
     * @throws IOException
     * @throws IOException
     */
    @FXML
    void newButtonClick(ActionEvent event) throws IOException, IOException {

        if(add_concert.isSelected()){
            Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("concert.fxml"));
            Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
            s.setTitle("CNG 457 - Phase 4");
            s.setScene(new Scene(root, 300, 600));
            s.show();
        }

        else if(add_festivalrun.isSelected()){
            Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("festivalrun.fxml"));
            Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
            s.setTitle("CNG 457 - Phase 4");
            s.setScene(new Scene(root, 300, 350));
            s.show();
        }

        else if(stats.isSelected()){
            Parent root = (Parent) FXMLLoader.load(this.getClass().getResource("statistics.fxml"));
            Stage s = (Stage)((Node)event.getSource()).getScene().getWindow();
            s.setTitle("CNG 457 - Phase 4");
            s.setScene(new Scene(root, 640, 400));
            s.show();
        }

    }
}