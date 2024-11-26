package org.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField firstField;
    @FXML
    private TextField secondField;
    @FXML
    private Rectangle rectangle;

    private boolean evenClick = false;

    ///////////////////////////
    @FXML
    private CheckBox checkBox;
    @FXML
    private Circle circle;
    @FXML
    private CheckBox checkProgress;
    @FXML
    private ProgressBar progress;
    @FXML
    private CheckBox checkPass;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField textFieldPass;

    @FXML
    protected void onHelloButtonClick() {
        String text;
        if(!evenClick){
            text = firstField.getText();
            firstField.clear();
            secondField.setText(text);
            welcomeText.setText("down");
            evenClick = true;
            rectangle.setRotate(90);
        } else {
            text = secondField.getText();
            secondField.clear();
            firstField.setText(text);
            welcomeText.setText("up");
            evenClick = false;
            rectangle.setRotate(0);
        }

    }
    @FXML
    protected void onBoxChecked(){
        if(checkBox.isSelected()){
            circle.setFill(new Color(1.0, 0.0, 0.0, 1.0));
            checkBox.setText("uncheck to make it blue");
        }
        else {
            circle.setFill(new Color(0.0, 0.0, 1.0, 1.0));
            checkBox.setText("check to make it red");

        }
    }
    @FXML
    protected void onCheckProgressChecked(){
        if(checkProgress.isSelected()){
            new Thread(() -> {
                double num = 0.1;
                while (progress.getProgress() < 1.0){
                    progress.setProgress(num);
                    num+=0.1;
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();

        } else {
            new Thread(() -> {
                double num = progress.getProgress();
                while(progress.getProgress() > 0.1){
                    progress.setProgress(num);
                    num-=0.1;

                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }).start();
        }
    }
    @FXML
    protected void onPassChecked(){
        passwordField.visibleProperty().bind(checkPass.selectedProperty().not());
        textFieldPass.visibleProperty().bind(checkPass.selectedProperty());

    }
    @FXML
    protected void onKeyTypedPass(){
        textFieldPass.setText(passwordField.getText());
    }
    @FXML
    protected void onKeyTypedTextPass(){
        passwordField.setText(textFieldPass.getText());
    }


}