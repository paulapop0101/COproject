import java.io.IOException;

import bench.CPU.DigitsOfPi;
import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class cpuTest {

    @FXML
    private ChoiceBox value;
    @FXML
    public void initialize() { value.getItems().addAll(16000, 32000,64000,128000,256000,512000,1000000,2000000,4000000,8000000,16000000,32000000);
    }
    @FXML
    private void backToPrimary() throws IOException {
        Main.setRoot("primary");
    }
    @FXML
    private void test() throws IOException {
        DigitsOfPi d = new DigitsOfPi();
        int k=Integer.parseInt(String.valueOf(value.getValue()));
        d.Digits(k);

    }
}