package visual.lab_4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import visual.lab_4.CpuLib.Command;
import visual.lab_4.CpuLib.CommandType;

public class CommandController {
    @FXML
    private Label commandTypeT;
    @FXML
    private Label arguments;

    private int index;

    private ProgViewModel progViewModel = ProgViewModel.getInstance();


    public void setCommand(Command command)
    {
        StringBuilder args = new StringBuilder();
        args.append(command.getType().name());
        for (String s : command.getArgs())
            args.append(" ").append(s);
        commandTypeT.setText(command.getType().toString());
        arguments.setText(args.toString());

        if (index == progViewModel.getCurrenUnstructionIndex()) {
            commandTypeT.setStyle("-fx-text-fill: red; -fx-font-weight: bold;");
        } else {
            commandTypeT.setStyle("");
        }
    }

    @FXML
    public void initialize() {
        index = progViewModel.getCurrenUnstructionIndex();
    }


    @FXML
    public void onDelete()
    {
        progViewModel.removeCommand(index);
    }
    @FXML
    public void onUp()
    {

    }
    @FXML
    public void onDown()
    {

    }

}
