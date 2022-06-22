package com.example.cng457desktopapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class ConcertsController {

    /**
     * Button to add new concert
     */
    @FXML
    private Button add;

    /**
     * Date Picker for the start date of the concert
     */
    @FXML
    private DatePicker date;

    /**
     * Text Field for concert description
     */
    @FXML
    private TextField description;

    /**
     * Text Field for concert duration
     */
    @FXML
    private TextField duration;

    /**
     * Combo Box for showing the festivals
     */
    @FXML
    private ComboBox festival;

    /**
     * Text Field for concert name
     */
    @FXML
    private TextField name;

    /**
     * Text Field for concert performer
     */
    @FXML
    private TextField performer;

    /**
     * Method for adding a new concert
     * @param event Clicking on the add button
     */
    @FXML
    void addConcert(ActionEvent event) throws IOException {

    }

    /**
     * Method for initializing the window
     * @param event Opening the window
     */
    @FXML
    void initialize(ActionEvent event) throws IOException, ParseException {
        String response = "";
        HttpURLConnection connection = (HttpURLConnection)(new URL("http://localhost:8080/getallfestivals")).openConnection();
        connection.setRequestMethod("GET");
        int responsecode = connection.getResponseCode();
        if (responsecode == 200) {
            Scanner scanner;
            for(scanner = new Scanner(connection.getInputStream()); scanner.hasNextLine(); response = response + scanner.nextLine()) {
            }

            scanner.close();
        }

        JSONParser parser = new JSONParser();
        JSONArray array = (JSONArray)parser.parse(response);

        for(int i = 0; i < array.size(); ++i) {
            try {
                JSONObject temp = (JSONObject)array.get(i);
                this.festival.getItems().add(temp.get("festivalid"));
            } catch (Exception var12) {
                String response2 = "";
                HttpURLConnection connection2 = (HttpURLConnection)(new URL("http://localhost:8080/getfestival/" + array.get(i))).openConnection();
                connection2.setRequestMethod("GET");
                int responsecode2 = connection2.getResponseCode();
                if (responsecode2 == 200) {
                    Scanner scanner;
                    for(scanner = new Scanner(connection2.getInputStream()); scanner.hasNextLine(); response2 = response2 + scanner.nextLine()) {
                    }

                    scanner.close();
                }

                JSONObject object = (JSONObject)parser.parse(response2);
                this.festival.getItems().add(object.get("festivalid"));
            }
        }
    }

}
