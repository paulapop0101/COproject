import java.awt.*;
import java.io.IOException;

import bench.CPU.DigitsOfPi;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import timer.FileData;
import timer.Timer;

public class cpuTest {


    @FXML
    private ChoiceBox value;

    @FXML
    public void initialize() { value.getItems().addAll(16000, 32000,64000,128000,25600,512000,10000,2000000,4000000,8000000,16000000,32000000);
    }
    @FXML
    private void backToPrimary() throws IOException {
        Main.setRoot("primary");
    }
    @FXML
    public void test() {
        DigitsOfPi d = new DigitsOfPi();
        int k=Integer.parseInt(String.valueOf(value.getValue()));
        Timer t = new Timer();
        t.start();
        d.Digits(k);
    }

    public void addtable(){
        System.out.println("miki");
        TableView<FileData> table = new TableView<>();
        TableColumn fileNameCol = new TableColumn("File Name");
        final ObservableList<FileData> data = FXCollections.observableArrayList(
                new FileData(16000, 33),
                new FileData(3200, 44)
        );
        Label label = new Label("File Data:");
        fileNameCol.setCellValueFactory(new PropertyValueFactory<>("fileName"));
        table.setItems(data);
        TableColumn pathCol = new TableColumn("Path");
        pathCol.setCellValueFactory(new PropertyValueFactory("path"));
        TableColumn sizeCol = new TableColumn("Size");
        sizeCol.setCellValueFactory(new PropertyValueFactory("size"));
        TableColumn dateCol = new TableColumn("Date Modified");
        dateCol.setCellValueFactory(new PropertyValueFactory("dateModified"));
        dateCol.setPrefWidth(100);
        //Adding data to the table
        ObservableList<String> list = FXCollections.observableArrayList();
        table.setItems(data);
        table.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        table.getColumns().addAll(fileNameCol, pathCol, sizeCol, dateCol);
        //Setting the size of the table
        table.setMaxSize(350, 200);
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        // vbox.setPadding(new Insets(10, 50, 50, 60));
        vbox.getChildren().addAll(label, table);
        //Setting the scene
        // creating a scene for adding vBox

    }
}