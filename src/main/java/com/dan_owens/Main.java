package com.dan_owens;

public class Main {
    public static void main(String[] args) {
        System.out.println(args.length);  
        Problem problem = ProblemFactory.get(args[0]);
        if(problem == null){
            System.out.println("Could not find problem");
            return;
        }
        try{
            System.out.println(problem.run(args[1]));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return;
        }
    }         

    public static void error(){
        System.out.println("Usage: blind75 [ProblemName] [Input]");
    }
}