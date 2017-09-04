package sample;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class Controller {

    public Button enterButton;
    public TextField enterTextField;
    public Label printLabel;

    private HashMap<Integer, Integer> hashMap = new HashMap<>();

    public void printHashMap(){
        printLabel.setText("");
        for (Integer i : hashMap.keySet()){
           printLabel.setText("The number " + i + " occurs " + hashMap.get(i) + " times.");
        }
    }

    public void enterKey(int value){
        if (hashMap.containsKey(value)){
            printLabel.setText("");
            hashMap.put(value, hashMap.get(value)+1);
            enterTextField.setText("");
        }
        else if (value<-1){
            printLabel.setText("Sorry, you have entered non-positive value. Try again");
            enterTextField.setText("");
        }
        else if (value==-1){
            printLabel.setText("");
            String myString = "";
            for (Integer i : hashMap.keySet()){
                myString += "The number " + i + " occurs " + hashMap.get(i) + " time(s).\n";
            }
            printLabel.setText(myString);
            enterTextField.setText("");
        }
        else if (!hashMap.containsKey(value)){
            printLabel.setText("");
            hashMap.put(value,1);
            enterTextField.setText("");
        }
    }

    public void clickButton(){
        int myNum = Integer.parseInt(enterTextField.getText());
        enterKey(myNum);
    }
    public void enterButtonPressed(javafx.scene.input.KeyEvent event){
        switch (event.getCode()){
            case ENTER:
                clickButton();
        }
    }
}
