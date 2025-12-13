package visual.lab_4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class StatisticsController implements IObserver{
    @FXML
    private Label mostFrequentCommand;
    @FXML
    private Label memoryRange;
    @FXML
    private Label orderOfCommandFreaquency;

    private ProgViewModel progViewModel = ProgViewModel.getInstance();

    @FXML
    public void initialize()
    {
        event();
        progViewModel.addObserver(this);
    }

    @Override
    public void event() {
        mostFrequentCommand.setText(progViewModel.getMostFreaquentCommand() == null? "-" : progViewModel.getMostFreaquentCommand().toString());
        memoryRange.setText(String.valueOf(progViewModel.getMemoryRange()));
        orderOfCommandFreaquency.setText(progViewModel.getCommandsByFreaquency().toString());
    }
}
