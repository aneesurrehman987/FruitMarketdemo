package controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class Checkout implements Initializable {

    @FXML
    private ListView<String> listView;
    @FXML
    private Label myLable;
    String[] items = {"Pizza","Sishi","Ramen"};
    String currentitems;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
listView.getItems().addAll(items);
listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
    @Override
    public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
        currentitems=listView.getSelectionModel().getSelectedItem();
        String Checkout = "Checkout List";
        myLable.setText(Checkout);
    }
});
    }
}
