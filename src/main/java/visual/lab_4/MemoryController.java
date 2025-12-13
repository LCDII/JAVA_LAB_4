package visual.lab_4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;

import java.util.List;

public class MemoryController implements IObserver{
    private final int amountOfElements = 1024;
    private final int amountOfColumns = 8;

    private GridPane mem;
    @FXML
    private ScrollPane memoryScrollPane;
    private ProgViewModel progViewModel = ProgViewModel.getInstance();

    @FXML
    public void initialize() {
        mem = new GridPane();


        for (int i = 0; i < amountOfElements; i++) {
            Label memoryElement = new Label("[--] : 0");
            memoryElement.setId("memory_element_" + i);


            int col = i % amountOfColumns;
            int row = i / amountOfColumns;
            this.mem.add(memoryElement, col, row);
        }
        memoryScrollPane.setContent(mem);
        event();
        progViewModel.addObserver(this);
    }

    @Override
    public void event() {
        List<Integer> cpuMemory = progViewModel.getAllMemory();
        for(int i = 0; i< cpuMemory.size(); i++) {
            Label memoryElement = (Label) this.mem.lookup("#memory_element_" + i);//поиск по id
            if(memoryElement != null) memoryElement.setText("[" + String.valueOf(i) + "] : " + String.valueOf(cpuMemory.get(i)));
        }
    }
}
