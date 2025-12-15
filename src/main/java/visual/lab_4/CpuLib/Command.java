package visual.lab_4.CpuLib;

import jakarta.persistence.*;

import java.util.Arrays;


@Entity
@Table(name = "Program")
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "CommandType", nullable = false)
    private String[] args;
    @Column(name = "Arguments", nullable = false)
    private CommandType type;

    public Command()
    {
        //надо
    }

    public Command(CommandType type, String... args) {
        this.type = type;
        this.args = args;
    }

    public CommandType getType() {
        return type;
    }

    public String[] getArgs() {
        return args;
    }

    public int getId()
    {
        return id;
    }

    public String toString() {
        String s = Arrays.toString(args);
        return "Command{args=" + s + ", type=" + String.valueOf(type) + "}";
    }

    public void setType(CommandType type) {
        this.type = type;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }
}