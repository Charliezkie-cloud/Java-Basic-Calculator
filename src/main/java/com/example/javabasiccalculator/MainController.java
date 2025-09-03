package com.example.javabasiccalculator;

import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MainController {
    @FXML
    private VBox historyBox;
    @FXML
    private TextField operandsInput;
    @FXML
    private Label operandDisplayLabel;

    double firstOperand = 0.00;
    char operator = '0';
    double secondOperand = 0.00;

    private double performCaculations() {
        switch (operator) {
            case '+':
                return firstOperand + secondOperand;
            case '-':
                return firstOperand - secondOperand;
            case '*':
                return firstOperand * secondOperand;
            case '/':
                return firstOperand / secondOperand;
            default:
                return 0;
        }
    }

    @FXML
    private void equalsOnClicked() {
        secondOperand = Double.parseDouble(operandsInput.getText());
        double result = performCaculations();
        operandsInput.setText(String.valueOf(result));

        operandDisplayLabel.setText(String.valueOf(firstOperand) + " " + (operator == '/' ? '÷' : operator) + " " + String.valueOf(secondOperand) + " = " + String.valueOf(result));

        Label memoryLabel = new Label(String.valueOf(firstOperand) + " + " + String.valueOf(secondOperand) + " = " + String.valueOf(result));
        memoryLabel.setFont(Font.font("Segoe UI", 16));
        memoryLabel.setWrapText(true);
        memoryLabel.setCursor(Cursor.HAND);

        memoryLabel.setOnMouseClicked(event -> {
            String[] operands = memoryLabel.getText().split(String.valueOf("\\" + (operator == '/' ? '÷' : operator)));

            firstOperand = Double.parseDouble(operands[0]);
            secondOperand = Double.parseDouble(operands[1].split("=")[0]);

            switch (memoryLabel.getText()) {
                case "+":
                    operator = '+';
                    break;
                case "-":
                    operator = '-';
                    break;
                case "*":
                    operator = '*';
                    break;
                case "/":
                    operator = '/';
                    break;
            }

            operandsInput.setText(String.valueOf(result));
            operandDisplayLabel.setText(String.valueOf(firstOperand) + " " + (operator == '/' ? '÷' : operator) + " " + String.valueOf(secondOperand) + " = " + String.valueOf(result));
        });

        historyBox.getChildren().add(memoryLabel);
    }

    @FXML
    private void operandsInputOnTyped() {
        try {
            if (operandsInput.getText() != "") {
                if (operator == '0') {
                    operandDisplayLabel.setText(String.valueOf(Double.parseDouble(operandsInput.getText())));
                } else {
                    operandDisplayLabel.setText(String.valueOf(firstOperand) + " " + operator + " " + String.valueOf(Double.parseDouble(operandsInput.getText())));
                }
            }
        } catch (NumberFormatException e) {
            if (firstOperand == 0) {
                operandDisplayLabel.setText("Error");
            } else if (secondOperand == 0) {
                operandDisplayLabel.setText(String.valueOf(firstOperand) + " " + operator + " " + " Error");
            }
        }
    }

    @FXML
    private void addOnClicked() {
        firstOperand = Double.parseDouble(operandsInput.getText());
        operandDisplayLabel.setText(String.valueOf(firstOperand) + " + ");
        operator = '+';
        operandsInput.setText("");
    }

    @FXML
    private void substractOnClicked() {
        firstOperand = Double.parseDouble(operandsInput.getText());
        operandDisplayLabel.setText(String.valueOf(firstOperand) + " - ");
        operator = '-';
        operandsInput.setText("");
    }

    @FXML
    private void multiplyOnClicked() {
        firstOperand = Double.parseDouble(operandsInput.getText());
        operandDisplayLabel.setText(String.valueOf(firstOperand) + " x ");
        operator = '*';
        operandsInput.setText("");
    }

    @FXML
    private void divideOnClicked() {
        firstOperand = Double.parseDouble(operandsInput.getText());
        operandDisplayLabel.setText(String.valueOf(firstOperand) + " ÷ ");
        operator = '/';
        operandsInput.setText("");
    }

    @FXML
    private void clearHistoryOnClicked() {
        historyBox.getChildren().removeAll();
    }

    @FXML
    private void clearOnClicked() {
        operandsInput.appendText("");
    }

    @FXML
    private void allClearOnClicked() {
        firstOperand = 0;
        operator = '0';
        secondOperand = 0;
        operandsInput.appendText("");
    }

    @FXML
    private void keyPeriodOnClicked() {
        operandsInput.appendText(".");
    }

    @FXML
    private void key0OnClicked() {
        operandsInput.appendText("0");
    }

    @FXML
    private void key1OnClicked() {
        operandsInput.appendText("1");
    }

    @FXML
    private void key2OnClicked() {
        operandsInput.appendText("2");
    }

    @FXML
    private void key3OnClicked() {
        operandsInput.appendText("3");
    }

    @FXML
    private void key4OnClicked() {
        operandsInput.appendText("4");
    }

    @FXML
    private void key5OnClicked() {
        operandsInput.appendText("5");
    }

    @FXML
    private void key6OnClicked() {
        operandsInput.appendText("6");
    }

    @FXML
    private void key7OnClicked() {
        operandsInput.appendText("7");
    }

    @FXML
    private void key8OnClicked() {
        operandsInput.appendText("8");
    }

    @FXML
    private void key9OnClicked() {
        operandsInput.appendText("9");
    }
}
