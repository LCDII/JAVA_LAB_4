package visual.lab_4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import visual.lab_4.CpuLib.CpuException;

public class RegistersController implements IObserver
{
    private ProgViewModel progViewModel = ProgViewModel.getInstance();
    @FXML private Label registerA;
    @FXML private Label registerB;
    @FXML private Label registerC;
    @FXML private Label registerD;

    @Override
    public void event() {
        try
        {
            registerA.setText(progViewModel.getRegister("a"));
            registerB.setText(progViewModel.getRegister("b"));
            registerC.setText(progViewModel.getRegister("c"));
            registerD.setText(progViewModel.getRegister("d"));
        }
        catch (CpuException e)
        {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    public void initialize()
    {
        event();
        progViewModel.addObserver(this);

    }

}
