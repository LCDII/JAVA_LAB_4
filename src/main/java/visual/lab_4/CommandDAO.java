package visual.lab_4;

import visual.lab_4.CpuLib.Command;

import java.util.ArrayList;

public class CommandDAO {
    ArrayList<Command> allCommands = new ArrayList<>();

    public ArrayList<Command> getCommands() {
        return allCommands;
    }

    public void add(Command cmd)
    {
        allCommands.add(cmd);
    }
    public void remove(Command cmd)
    {
        allCommands.remove(cmd);
    }

    public void swap(Command cmd1, Command cmd2)
    {

    }
}


