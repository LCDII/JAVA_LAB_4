package visual.lab_4;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import visual.lab_4.CpuLib.Command;

import javax.lang.model.AnnotatedConstruct;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class CommandStorageController implements IObserver{

    @FXML
    private VBox commandsBox;

    private ProgViewModel progViewModel = ProgViewModel.getInstance();

    @FXML
    public void initialize()
    {
        progViewModel.addObserver(this);
        event();
    }

    @Override
    public void event() {
        commandsBox.getChildren().clear();
        List<Command> commands = progViewModel.getProgramList();

        for(Command c: commands)
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("command-frame.fxml"));
            CommandController commandController = new CommandController();
            loader.setController(commandController);
            try
            {
                AnchorPane pane = loader.load();
                commandController.setCommand(c);
                commandsBox.getChildren().add(pane);
            }
            catch (IOException e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
