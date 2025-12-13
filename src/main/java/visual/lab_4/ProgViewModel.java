package visual.lab_4;

import visual.lab_4.CpuLib.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ProgViewModel {

    static ProgViewModel instance;
    public static ProgViewModel getInstance()
    {
        if(instance == null)
        {
            instance = new ProgViewModel();
        }
        return instance;
    }
    private Prog programm;
    private ArrayList<IObserver> observers;
    private ICpu cpu;// we need it only for draw registers
    private Executor executor;//do all with instructions

    private ProgViewModel()
    {
        observers = new ArrayList<>();
        programm = new Prog();
        cpu = FCpu.build();
        executor = new Executor(cpu, programm);
    }

    public void addObserver(IObserver observer)
    {
        observers.add(observer);
    }

    private void notifyObservers() {
        for (IObserver o : observers) {
            o.event();
        }
    }




    public String getRegister(String register)
    {
        return String.valueOf(cpu.getRegister(register));
    }

    public List<Integer> getAllMemory()
    {
        return Arrays.stream(cpu.getAllMemory())
                // превращаем в IntStream
                .boxed()
                // упаковываем примитивы в Integer
                .collect(Collectors.toList());
    }

    public int getMemoryRange()
    {
        return programm.MemoryRange();
    }
    public CommandType getMostFreaquentCommand()
    {
        return programm.mostFreaquentCommand();
    }

    public List<CommandType> getCommandsByFreaquency()
    {
        return programm.commandsByFreaquency();
    }
}

