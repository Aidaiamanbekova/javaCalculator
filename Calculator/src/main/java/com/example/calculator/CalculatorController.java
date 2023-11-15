package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
    @FXML
    private TextField inputField;

    private Calculator calculator = new Calculator();
    private boolean isNewInput = true;

    @FXML
    public void digitButtonClicked(ActionEvent event) {
        if (isNewInput) {
            inputField.clear();
            isNewInput = false;
        }

        Button button = (Button) event.getSource();
        inputField.appendText(button.getText());
    }

    @FXML
    public void operatorButtonClicked(ActionEvent event) {
        if (!inputField.getText().isEmpty()) {
            calculator.setOperand1(Double.parseDouble(inputField.getText()));
            isNewInput = true;

            Button button = (Button) event.getSource();
            calculator.setOperator(button.getText().charAt(0));
        }
    }

    @FXML
    public void equalsButtonClicked(ActionEvent event) {
        if (!inputField.getText().isEmpty()) {
            try {
                calculator.setOperand2(Double.parseDouble(inputField.getText()));
                calculator.calculate();
                inputField.setText(String.valueOf(calculator.getResult()));
                isNewInput = true;
            } catch (DivisionByZeroException e) {
                inputField.setText("Error: Division by zero");
                isNewInput = true;
            }
        }
    }

    @FXML
    public void clearButtonClicked(ActionEvent event) {
        inputField.clear();
        calculator.setOperand1(0);
        calculator.setOperand2(0);
        calculator.setOperator('\0');
        isNewInput = true;
    }
}
