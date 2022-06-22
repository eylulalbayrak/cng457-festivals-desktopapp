package com.example.cng457desktopapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class StatisticsController {


    @FXML
    private CheckBox longest_concert;

    @FXML
    private CheckBox popular_Fest;

    @FXML
    private Button show_concert;

    @FXML
    private Button show_fest;

    @FXML
    private ListView test_concert;

    @FXML
    private ListView text_fest;

    @FXML
    void showLongestConcerts(ActionEvent event) throws IOException, ParseException {
        String response = "";
        HttpURLConnection connection = (HttpURLConnection)(new URL("http://localhost:8080/longestconcerts")).openConnection();
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
                this.test_concert.getItems().add(temp.get("eventid"));
            } catch (Exception var12) {
                String response2 = "";
                HttpURLConnection connection2 = (HttpURLConnection)(new URL("http://localhost:8080/getconcert/" + array.get(i))).openConnection();
                connection2.setRequestMethod("GET");
                int responsecode2 = connection2.getResponseCode();
                if (responsecode2 == 200) {
                    Scanner scanner;
                    for(scanner = new Scanner(connection2.getInputStream()); scanner.hasNextLine(); response2 = response2 + scanner.nextLine()) {
                    }

                    scanner.close();
                }

                JSONObject object = (JSONObject)parser.parse(response2);
                this.test_concert.getItems().add(object.get("eventid"));
            }
        }
    }

    @FXML
    void showPopularFestivals(ActionEvent event) throws IOException, ParseException {
        String response = "";
        HttpURLConnection connection = (HttpURLConnection)(new URL("http://localhost:8080/popularfestivals")).openConnection();
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
                this.text_fest.getItems().add(temp.get("festivalid"));
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
                this.text_fest.getItems().add(object.get("festivalid"));
            }
        }
    }
}
