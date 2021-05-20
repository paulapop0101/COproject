
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import bench.CPU.DigitsOfPi;
import bench.CPU.Spigot2;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import timer.Timer;
import logging.TimeUnit;

public class cpuTest implements Initializable {

    public int k;
    @FXML
    public NumberAxis y;
    @FXML
    public LineChart<Number,Number> LineChart;
    @FXML
    public NumberAxis nr;
    public Button generatechart;
    public TableColumn<Iteration,Integer> score1;
    public TableColumn<Iteration, Integer> score2;
    //  private LineChart<>
    private long timetaken;
    public double newtime;
    public int i=0;

    private long timetaken2;
    public double newtime2;

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
        value.getItems().addAll(512,1000,1600,3200,6400,12800,25600,32000,50000,64000,70000);
        digitsC.setCellValueFactory(new PropertyValueFactory<Iteration,Integer>("digits"));
        Spigot1.setCellValueFactory(new PropertyValueFactory<Iteration,Integer>("Time1"));
        Spigot2.setCellValueFactory(new PropertyValueFactory<Iteration,Integer>("Time2"));
        score1.setCellValueFactory(new PropertyValueFactory<Iteration,Integer>("Score1"));
        score2.setCellValueFactory(new PropertyValueFactory<Iteration,Integer>("Score2"));

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
      //  System.out.println(k);
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
    List<Integer> digits = new ArrayList<>();
    List<Double> time1= new ArrayList<>();
    List<Double> time2= new ArrayList<>();
    ObservableList<Iteration> getList(){
        ObservableList<Iteration> it = FXCollections.observableArrayList();
        return it;
    }
             // i=1
    //digits

    XYChart.Series<Number,Number> series= new XYChart.Series<>();
    XYChart.Series<Number,Number> series1=new XYChart.Series<>();
    public void addInTable(){
        i++;
        Iteration row= new Iteration();
        row.setDigits(k);
        row.setTime1(newtime);
        row.setTime2(newtime2);
        row.setScore1(k/newtime);
        row.setScore2(k/newtime2);
        table.getItems().add(row);
        digits.add(k);
        time1.add((double) newtime);
        time2.add((double) newtime2);

        series.setName("Spigot 1");
        series1.setName("Spigot 2");
        for (int j=0;j<i;j++)
            series.getData().addAll(new XYChart.Data<>(digits.get(j),time1.get(j)));

        for (int j=0;j<i;j++)
            series1.getData().addAll(new XYChart.Data<>(digits.get(j),time2.get(j)));
        LineChart.getData().addAll(series,series1);

    }

}