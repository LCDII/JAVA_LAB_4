package visual.lab_4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class MainFrameController {

    @FXML
    AnchorPane registersPlaceHolder;

    @FXML
    public void initialize() {
        try
        {
            AnchorPane registers = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("registers-frame.fxml")));
            registersPlaceHolder.getChildren().add(registers);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
