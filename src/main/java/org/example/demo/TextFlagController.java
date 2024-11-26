package org.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleGroup;

public class TextFlagController {
    public RadioButton red1;
    public RadioButton green1;
    public RadioButton blue1;
    public RadioButton red2;
    public RadioButton green2;
    public RadioButton blue2;
    public RadioButton red3;
    public RadioButton blue3;
    public RadioButton green3;
    @FXML
    private Button draw;

    private ToggleGroup group1;
    private ToggleGroup group2;
    private ToggleGroup group3;


    @FXML
    protected void drawAction(){
            String color1 = ((RadioButton) group1.getSelectedToggle()).getText();
            String color2 = ((RadioButton) group2.getSelectedToggle()).getText();
            String color3 = ((RadioButton) group3.getSelectedToggle()).getText();
            String message = String.format("Colors: %s, %s, %s", color1, color2, color3);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
            alert.setTitle("Result");
            alert.showAndWait();
    }

    @FXML
    public void initialize(){
        group1 = new ToggleGroup();
        group2 = new ToggleGroup();
        group3 = new ToggleGroup();

        red1.setToggleGroup(group1);
        green1.setToggleGroup(group1);
        blue1.setToggleGroup(group1);

        red2.setToggleGroup(group2);
        green2.setToggleGroup(group2);
        blue2.setToggleGroup(group2);

        red3.setToggleGroup(group3);
        green3.setToggleGroup(group3);
        blue3.setToggleGroup(group3);
    }
}



/*public class TextFlagApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Текстовый флаг");

        // Создание панели
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Цвета для первой полосы
        Label label1 = new Label("Цвет первой полосы:");
        grid.add(label1, 0, 0);
        ToggleGroup group1 = new ToggleGroup();
        RadioButton color1Red = new RadioButton("Красный");
        color1Red.setToggleGroup(group1);
        RadioButton color1Green = new RadioButton("Зеленый");
        color1Green.setToggleGroup(group1);
        RadioButton color1Blue = new RadioButton("Синий");
        color1Blue.setToggleGroup(group1);
        grid.add(color1Red, 0, 1);
        grid.add(color1Green, 0, 2);
        grid.add(color1Blue, 0, 3);

        // Цвета для второй полосы
        Label label2 = new Label("Цвет второй полосы:");
        grid.add(label2, 1, 0);
        ToggleGroup group2 = new ToggleGroup();
        RadioButton color2Red = new RadioButton("Красный");
        color2Red.setToggleGroup(group2);
        RadioButton color2Green = new RadioButton("Зеленый");
        color2Green.setToggleGroup(group2);
        RadioButton color2Blue = new RadioButton("Синий");
        color2Blue.setToggleGroup(group2);
        grid.add(color2Red, 1, 1);
        grid.add(color2Green, 1, 2);
        grid.add(color2Blue, 1, 3);

        // Цвета для третьей полосы
        Label label3 = new Label("Цвет третьей полосы:");
        grid.add(label3, 2, 0);
        ToggleGroup group3 = new ToggleGroup();
        RadioButton color3Red = new RadioButton("Красный");
        color3Red.setToggleGroup(group3);
        RadioButton color3Green = new RadioButton("Зеленый");
        color3Green.setToggleGroup(group3);
        RadioButton color3Blue = new RadioButton("Синий");
        color3Blue.setToggleGroup(group3);
        grid.add(color3Red, 2, 1);
        grid.add(color3Green, 2, 2);
        grid.add(color3Blue, 2, 3);

        // Кнопка для рисования флага
        Button drawButton = new Button("Нарисовать");
        grid.add(drawButton, 1, 4);

        // Обработчик события для кнопки
        drawButton.setOnAction(e -> {
            String color1 = ((RadioButton) group1.getSelectedToggle()).getText();
            String color2 = ((RadioButton) group2.getSelectedToggle()).getText();
            String color3 = ((RadioButton) group3.getSelectedToggle()).getText();
            String message = String.format("Выбранные цвета: %s, %s, %s", color1, color2, color3);
            Alert alert = new Alert(Alert.AlertType.INFORMATION, message);
            alert.setTitle("Результат");
            alert.showAndWait();
        });

        // Создание сцены и отображение окна
        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}*/

