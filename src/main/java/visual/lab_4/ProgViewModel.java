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
    private HibernateCommandDAO commandDAO;

    private ProgViewModel()
    {
        observers = new ArrayList<>();
        programm = new Prog();
        cpu = FCpu.build();
        executor = new Executor(cpu, programm);
        commandDAO = new HibernateCommandDAO();
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

    public void addCommand(Command command)
    {
        commandDAO.add(command);
        programm.add(command);
        notifyObservers();
    }
    public void removeCommand(int index)
    {
        commandDAO.remove(programm.getElem(index));
        programm.removeAt(index);
        notifyObservers();
    }
    public void resetAll()
    {
        cpu = FCpu.reBuild();
        if(programm.isEmpty())
            programm.setCurrentInstructionIndex(-1);
        else
            programm.setCurrentInstructionIndex(0);
        executor.setCpu(cpu);
        notifyObservers();
    }
    public void executeAll()
    {
        try {
            executor.run();
        }catch (CpuException e)
        {
            System.out.println(e.getMessage());
        }
        notifyObservers();
    }
    public void executeOne()
    {
        try
        {
            executor.executeOne();
        }catch (CpuException e)
        {
            System.out.println(e.getMessage());
        }
        notifyObservers();
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

    public int getCurrenUnstructionIndex()
    {
        return programm.getCurrentInstructionIndex();
    }
    public void setCurrenUnstructionIndex(int i)
    {
        programm.setCurrentInstructionIndex(i);
    }
    public List<CommandType> getCommandsByFreaquency()
    {
        return programm.commandsByFreaquency();
    }

    public void bubleUp(int index)
    {
        //programm.bubleUp(index);
        commandDAO.swap(programm.getElem(index), programm.getElem(index-1));
        notifyObservers();
    }

    public void pushDown(int index)
    {
        //programm.pushDown(index);
        commandDAO.swap(programm.getElem(index), programm.getElem(index+1));
        notifyObservers();
    }


    public List<Command> getProgramList()
    {
        programm.clear();
        for(Command c : commandDAO.getCommands())
        {
            programm.add(c);
        }
        return commandDAO.getCommands();
    }
}

