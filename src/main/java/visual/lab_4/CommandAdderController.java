package visual.lab_4;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import visual.lab_4.CpuLib.Command;
import visual.lab_4.CpuLib.CommandType;

public class CommandAdderController
{
    @FXML
    private ComboBox<CommandType> CommandTypeBox;
    @FXML
    private TextField instructionArgs;
    @FXML
    private Button executeInstruction;
    @FXML
    private Button resetProgramm;
    @FXML
    private Button executeAll;
    @FXML
    private Button addInstructionInProggramm;

    private ProgViewModel progViewModel = ProgViewModel.getInstance();

    @FXML
    public void initialize()
    {
        CommandTypeBox.getItems().addAll(CommandType.values());
    }

    @FXML
    public void onAdd()
    {
        CommandType commandType = CommandTypeBox.getValue();
        String arguments = instructionArgs.getText();
        String[] resultArguments;
        if(arguments.isBlank() || arguments == null)
        {
            resultArguments = new String[0];
        }
        else
        {
            resultArguments = arguments.trim().split("\\s+");
        }
        progViewModel.addCommand(new Command(commandType, resultArguments));
        instructionArgs.clear();
    }
    @FXML
    public void onResetAll()
    {
        progViewModel.resetAll();
    }
    @FXML
    public void onExecuteOne()
    {
        progViewModel.executeOne();
    }

    @FXML
    public void onExecuteAll()
    {
        progViewModel.executeAll();
    }

}
