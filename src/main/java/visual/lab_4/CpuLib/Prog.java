package visual.lab_4.CpuLib;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Prog implements Iterable<Command>{

    private ArrayList<Command> a;
    private int CurrentInstructionIndex;


    public CommandType mostFreaquentCommand()
    {
        return a.stream().
                collect(Collectors.groupingBy(Command::getType, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public int getAddressOfCommand(Command cmd) {
        int res;
        if(cmd.getType() == CommandType.INIT)
            res = Integer.parseInt(cmd.getArgs()[0]);
        else if(cmd.getType() == CommandType.LD|| cmd.getType() == CommandType.ST)
            res = Integer.parseInt(cmd.getArgs()[1]);
        else res = -1;
        return res;
    }
    public int MemoryRange()
    {
        return a.stream().map(this::getAddressOfCommand)
                .filter(mem -> mem != -1)
                .mapToInt(Integer::intValue)
                .max().orElse(0)
                -
                a.stream().map(this::getAddressOfCommand)
                        .filter(mem -> mem != -1)
                        .mapToInt(Integer::intValue)
                        .min()
                        .orElse(0)
                +1;//because of indexes
    }

    public List<CommandType> commandsByFreaquency()
    {
        return a.stream().collect(Collectors
                        .groupingBy(Command::getType, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<CommandType, Long>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Prog()
    {
        a = new ArrayList<>();
        CurrentInstructionIndex = 0;
    }
    public Prog(ArrayList<Command> list)
    {
        a = list;
        CurrentInstructionIndex = 0;
    }
    public int getCurrentInstructionIndex()
    {
        return CurrentInstructionIndex;
    }
    public void setCurrentInstructionIndex(int i)
    {
        if(i >= a.size())
            throw new RuntimeException();
        CurrentInstructionIndex = i;
    }
    public void incrementCurrentInstruction()
    {
        CurrentInstructionIndex++;
    }
    public void add(Command command)
    {
        a.add(command);
    }
    public void removeAt(int index) {
        if (index < 0 || index >= a.size()) throw new RuntimeException();
        a.remove(index);
    }

    public boolean isEmpty()
    {
        return a.isEmpty();
    }

    public Command getElem(int ind)
    {
        return a.get(ind);
    }

    public void clear()
    {
        a.clear();
    }
    public int size()
    {
        return a.size();
    }

    public void bubleUp(int index)
    {
        if(index == 0 || a.size() < 2)
            return ;
        Collections.swap(a, index, index-1);
    }

    public void pushDown(int index)
    {
        if(index == a.size()-1 || a.size() < 2)
            return;
        Collections.swap(a, index, index+1);
    }

    @Override
    public Iterator<Command> iterator() {
        return a.iterator();
    }

}
