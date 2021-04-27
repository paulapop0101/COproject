import java.io.IOException;
import javafx.fxml.FXML;

public class ramTest {

    @FXML
    private void backToPrimary() throws IOException {
        Main.setRoot("primary");
    }
}