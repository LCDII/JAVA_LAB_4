package visual.lab_4;

import visual.lab_4.CpuLib.Executor;
import visual.lab_4.CpuLib.FCpu;
import visual.lab_4.CpuLib.ICpu;
import visual.lab_4.CpuLib.Prog;

import java.util.ArrayList;

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




    public String getRegister(String register)
    {
        return String.valueOf(cpu.getRegister(register));
    }
}

