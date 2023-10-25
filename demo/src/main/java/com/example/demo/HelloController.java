package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private TextField textField;
    @FXML
    private Text savedNumbers;
    private String firstNumber = "";
    private String currentNumber = "";
    private String calculationType;

    public Controller() {
    }

    @FXML
    void addAction(ActionEvent event) {
        this.calculationSetup("+");
    }

    @FXML
    void minusAction(ActionEvent event) {
        this.calculationSetup("-");
    }

    @FXML
    void divideAction(ActionEvent event) {
        this.calculationSetup("/");
    }

    @FXML
    void multiplicationAction(ActionEvent event) {
        this.calculationSetup("*");
    }

    public void calculationSetup(String calculationType) {
        this.calculationType = calculationType;
        this.firstNumber = this.currentNumber;
        this.currentNumber = "";
        this.savedNumbers.setText(this.firstNumber + " " + calculationType);
    }

    @FXML
    void calculate(ActionEvent event) {
        int firstNumberInt = Integer.parseInt(this.firstNumber);
        int secondNumberInt = Integer.parseInt(this.currentNumber);
        int calculatedNumber;
        switch (this.calculationType) {
            case "+":
                calculatedNumber = firstNumberInt + secondNumberInt;
                this.savedNumbers.setText(this.firstNumber + " + " + this.currentNumber + " = " + calculatedNumber);
                this.textField.setText(String.valueOf(calculatedNumber));
                break;
            case "-":
                calculatedNumber = firstNumberInt - secondNumberInt;
                this.savedNumbers.setText(this.firstNumber + " - " + this.currentNumber + " = " + calculatedNumber);
                this.textField.setText(String.valueOf(calculatedNumber));
                break;
            case "/":
                double calculatedNumber = (double)firstNumberInt / (double)secondNumberInt;
                this.savedNumbers.setText(this.firstNumber + " / " + this.currentNumber + " = " + calculatedNumber);
                this.textField.setText(String.valueOf(calculatedNumber));
                break;
            case "*":
                calculatedNumber = firstNumberInt * secondNumberInt;
                this.savedNumbers.setText(this.firstNumber + " * " + this.currentNumber + " = " + calculatedNumber);
                this.textField.setText(String.valueOf(calculatedNumber));
        }

    }

    @FXML
    void clearTextField(ActionEvent event) {
        this.currentNumber = "";
        this.textField.setText("");
        this.savedNumbers.setText("");
    }

    @FXML
    void button0Clicked(ActionEvent event) {
        if (!this.currentNumber.equals("")) {
            this.addNumber("0");
        }

    }

    @FXML
    void button1Clicked(ActionEvent event) {
        this.addNumber("1");
    }

    @FXML
    void button2Clicked(ActionEvent event) {
        this.addNumber("2");
    }

    @FXML
    void button3Clicked(ActionEvent event) {
        this.addNumber("3");
    }

    @FXML
    void button4Clicked(ActionEvent event) {
        this.addNumber("4");
    }

    @FXML
    void button5Clicked(ActionEvent event) {
        this.addNumber("5");
    }

    @FXML
    void button6Clicked(ActionEvent event) {
        this.addNumber("6");
    }

    @FXML
    void button7Clicked(ActionEvent event) {
        this.addNumber("7");
    }

    @FXML
    void button8Clicked(ActionEvent event) {
        this.addNumber("8");
    }

    @FXML
    void button9Clicked(ActionEvent event) {
        this.addNumber("9");
    }

    public void updateTextField() {
        this.textField.setText(this.currentNumber);
    }

    public void addNumber(String number) {
        this.currentNumber = this.currentNumber + number;
        this.updateTextField();
    }
}