package com.dan_owens;
import java.util.Set;
import picocli.CommandLine;

@CommandLine.Command(name = "blind75", mixinStandardHelpOptions = true)
public class blind75 implements Runnable{
    @CommandLine.Parameters(paramLabel = "<command>", defaultValue="ls", index="0")
    private String command;

    @CommandLine.Parameters(paramLabel = "<problem name>", index="1")
    private String problemName;


    @CommandLine.Parameters(paramLabel = "<input>", index="2")
    private String input;


    void ls() {
        Set<String> problems = ProblemFactory.getProblems();
        for (String problem : problems) {
            System.out.println(problem);
        }
    }

    void runProblem(){
        Problem problem = ProblemFactory.get(problemName);
        if (problem == null) {
            System.err.println("Could not find problem");
            System.exit(1);
        }
        try {
        System.out.println(problem.run(problemName));
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(1);
        }
    }

    public void run() {
        if(command.equals("ls"))
            ls();
        else if(command.equals("run")){
            runProblem();
        }
    }

    public static void main(String[] args){
        int exitCode = new CommandLine(new blind75()).execute(args);
        System.exit(exitCode);
    }
}