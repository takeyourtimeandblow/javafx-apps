package org.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class OrderController {


    @FXML private CheckBox choose1;
    @FXML private CheckBox choose2;
    @FXML private CheckBox choose3;
    @FXML private CheckBox choose4;
    @FXML private CheckBox choose5;
    @FXML private CheckBox choose6;

    private ArrayList<CheckBox> checkBoxArrayList;
    private StringBuilder checkString;

    @FXML
    private Label checkLabel;

    @FXML
    protected void onActionPrintCheck(){
        checkString = new StringBuilder();
        checkBoxArrayList.forEach(checkBox -> {
            if (checkBox.isSelected()){
                checkString.append(checkBox.getText()).append("\n");
            }
        });
        try {
            checkLabel.setText(checkString.toString());
        } catch (NullPointerException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    protected void initialize(){
        checkBoxArrayList = new ArrayList<>();
        checkBoxArrayList.add(choose1);
        checkBoxArrayList.add(choose2);
        checkBoxArrayList.add(choose3);
        checkBoxArrayList.add(choose4);
        checkBoxArrayList.add(choose5);
        checkBoxArrayList.add(choose6);

    }
    
}
