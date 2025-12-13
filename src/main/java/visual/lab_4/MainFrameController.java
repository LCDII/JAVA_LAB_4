package visual.lab_4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class MainFrameController {

    @FXML
    private AnchorPane registersPlaceHolder;
    @FXML
    private AnchorPane memoryPlaceHolder;
    @FXML
    private AnchorPane statisticsPlaceHolder;

    @FXML
    public void initialize() {
        try
        {
            AnchorPane registers = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("registers-frame.fxml")));
            registersPlaceHolder.getChildren().add(registers);

            ScrollPane memory = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("memory-frame.fxml")));
            memoryPlaceHolder.getChildren().add(memory);

            AnchorPane statistics = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("statistics-frame.fxml")));
            statisticsPlaceHolder.getChildren().add(statistics);
        }
        catch(IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}
