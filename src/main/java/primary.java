import java.io.IOException;
import javafx.fxml.FXML;

public class primary {

    @FXML
    private void switchToCPU() throws IOException {
        Main.setRoot("cpuTest");
    }
    @FXML
    private void switchToRAM() throws IOException {
        Main.setRoot("ramTest");
    }
}