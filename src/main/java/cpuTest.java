
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import bench.CPU.DigitsOfPi;
import bench.CPU.Spigot2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import timer.Timer;
import logging.TimeUnit;

public class cpuTest implements Initializable {

    private int k;
    private long timetaken;
    private double newtime;

    private long timetaken2;
    private double newtime2;

    @FXML
    public TableView<Iteration> table;
    @FXML
    private ChoiceBox value;

    @FXML
    private TableColumn<Iteration,Integer> digitsC;

    @FXML
    private TableColumn<Iteration,Integer> Spigot1;
    @FXML
    private TableColumn<Iteration,Integer> Spigot2;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        value.getItems().addAll(160, 32000,64000,128000,25600,512000,10000,2000000,4000000,8000000,16000000,32000000);
        digitsC.setCellValueFactory(new PropertyValueFactory<Iteration,Integer>("digits"));
        Spigot1.setCellValueFactory(new PropertyValueFactory<Iteration,Integer>("Time1"));
        Spigot2.setCellValueFactory(new PropertyValueFactory<Iteration,Integer>("Time2"));
        table.setItems(getList());
    }
    @FXML
    private void backToPrimary() throws IOException {
        Main.setRoot("primary");
    }
    @FXML
    public void test() {
        DigitsOfPi d = new DigitsOfPi();
        k=Integer.parseInt(String.valueOf(value.getValue()));
        Timer t = new Timer();
        t.start();
        d.Digits(k);
        timetaken=t.stop();
        newtime= TimeUnit.toTimeUnit(timetaken,TimeUnit.Sec);

        Spigot2 pi=new Spigot2(k);
        t.start();
        pi.calculatePi();
        timetaken2=t.stop();
        newtime2= TimeUnit.toTimeUnit(timetaken2,TimeUnit.Sec);

        addInTable();

    }
    ObservableList<Iteration> getList(){
        ObservableList<Iteration> it = FXCollections.observableArrayList();
        return it;
    }
    public void addInTable(){
        Iteration row= new Iteration();
        row.setDigits(k);
        row.setTime1(newtime);
        row.setTime2(newtime2);
        table.getItems().add(row);

    }
}