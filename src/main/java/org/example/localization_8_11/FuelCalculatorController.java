package org.example.localization_8_11;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import java.util.ResourceBundle;
import java.util.Locale;

public class FuelCalculatorController {
    @FXML
    private Label distanceLabel;
    @FXML
    private TextField distanceField;
    @FXML
    private Label fuelLabel;
    @FXML
    private TextField fuelField;
    @FXML
    private Button calculateButton;
    @FXML
    private Label resultLabel;

    private ResourceBundle bundle;

    @FXML
    public void initialize() {
        setLocale(Locale.ENGLISH); // Default locale
    }

    public void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle("org.example.localization_8_11.messages", locale);
        distanceLabel.setText(bundle.getString("distance.label"));
        fuelLabel.setText(bundle.getString("fuel.label"));
        calculateButton.setText(bundle.getString("calculate.button"));
        resultLabel.setText("");
    }

    @FXML
    protected void onCalculateButtonClick() {
        try {
            double distance = Double.parseDouble(distanceField.getText());
            double fuel = Double.parseDouble(fuelField.getText());
            double consumption = (fuel / distance) * 100;
            resultLabel.setText(String.format(bundle.getString("result.label"), consumption));
        } catch (NumberFormatException e) {
            resultLabel.setText(bundle.getString("invalid.input"));
        }
    }
}