import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import bench.CPU.DigitsOfPi;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import timer.FileData;
import timer.Timer;

public class cpuTest implements Initializable {

    private int k;
    private long timetaken;
    @FXML
    public TableView<Iteration> table;
    @FXML
    private ChoiceBox value;
    @FXML
    private TableColumn<Iteration,String> timeC;
    @FXML
    private TableColumn<Iteration,Integer> digitsC;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        value.getItems().addAll(160, 32000,64000,128000,25600,512000,10000,2000000,4000000,8000000,16000000,32000000);
        digitsC.setCellValueFactory(new PropertyValueFactory<Iteration,Integer>("digits"));
        timeC.setCellValueFactory(new PropertyValueFactory<Iteration,String>("Time"));
        table.setItems(getList());
    }
    @FXML
    private void backToPrimary() throws IOException {
        Main.setRoot("primary");
    }
    @FXML
    public void test() throws IOException {
       // digitsC.setCellFactory(new );
        DigitsOfPi d = new DigitsOfPi();
        k=Integer.parseInt(String.valueOf(value.getValue()));
        Timer t = new Timer();
        t.start();
        d.Digits(k);
        timetaken=t.stop();
        addInTable();

    }
    ObservableList<Iteration> getList(){
        ObservableList<Iteration> it = FXCollections.observableArrayList();
        //it.add(new Iteration("11","12"));
        return it;
    }
    public void addInTable(){
        System.out.println("miki");
        Iteration row= new Iteration();
        row.setDigits(k);
        row.setTime(timetaken);
        table.getItems().add(row);

    }
}