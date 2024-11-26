package org.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.TextField;

public class CalculatorController {
    @FXML
    private TextField textField;
    @FXML
    private Label messages;

    //Functions//
    //Text//

    @FXML
    protected void onActionTextField(){
        calculate();
    }
    @FXML
    protected void onKeyTypedTextField(KeyEvent event) {
        if (Character.isLetter(event.getCharacter().charAt(0))) {
            event.consume();
            textField.deletePreviousChar();

        }
    }

    @FXML
    public void cClearAll() {
        textField.setText("");
    }
    @FXML
    public void cDiv() {
        textField.setText(textField.getText() + "/");
    }
    @FXML
    public void cTimes() {
        textField.setText(textField.getText() + "*");
    }
    @FXML
    public void cClear() {
        textField.deletePreviousChar();
    }
    @FXML
    public void cSeven() {
        textField.setText(textField.getText() + "7");
    }
    @FXML
    public void cEight() {
        textField.setText(textField.getText() + "8");
    }
    @FXML
    public void cNine() {
        textField.setText(textField.getText() + "9");
    }
    @FXML
    public void cMinus() {
        textField.setText(textField.getText() + "-");
    }
    @FXML
    public void cFour() {
        textField.setText(textField.getText() + "4");
    }
    @FXML
    public void cFive() {
        textField.setText(textField.getText() + "5");
    }
    @FXML
    public void cSix() {
        textField.setText(textField.getText() + "6");
    }
    @FXML
    public void cPlus() {
        textField.setText(textField.getText() + "+");
    }
    @FXML
    public void cOne() {
        textField.setText(textField.getText() + "1");
    }
    @FXML
    public void cTwo() {
        textField.setText(textField.getText() + "2");
    }
    @FXML
    public void cThree() {
        textField.setText(textField.getText() + "3");
    }
    @FXML
    public void cZero() {
        textField.setText(textField.getText() + "0");
    }
    @FXML
    public void cDot() {
        textField.setText(textField.getText() + ".");
    }
    @FXML
    public void cEnter() {
        calculate();
    }

    protected void calculate() throws IllegalArgumentException {
        try {
            textField.setText(String.valueOf(CalculatorLogic.evaluateExpression(textField.getText())));
        } catch (Exception e) {
            messages.setText(e.getMessage());
            throw new RuntimeException(e);

        }
    }
}
