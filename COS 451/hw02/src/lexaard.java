import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class lexaard {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);      // for reading user input
        String[] input;                             // stores user input
        String command;                             // the command that the user entered
        String[] arguments;                         // arguments for command

        boolean found_flag;                 // boolean indicating object is found in List data
        int dataPos = 0;                           // for finding the position of an object in List data

        boolean loop_flag = true;                   // boolean indicating that loop should continue

        // list containing FSAs and Doodads
        List<Object> data = new ArrayList<Object>();

        System.out.print("Lexaard Interpreter\n\n");
        System.out.println("Enter a command (help for more info): ");
        // main loop
        while(true) {
            // reads the user's input into an array
            input = scan.nextLine().split("\\s+");
            // first string is the command the user wants to run
            command = input[0];
            // any additional input are arguments for the command
            arguments = Arrays.copyOfRange(input, 1, input.length);

            switch(command) {
                case "quit":
                    System.exit(0);

                case "print":
                    for (Object object : data) {
                        if (object instanceof FSA) {
                            if (((FSA) object).getName().equals(arguments[0])) {
                                System.out.println(((FSA) object).printFSA());
                            }
                        }
                        else if (object instanceof Doodad) {
                            if (((Doodad) object).getName().equals(arguments[0])) {
                                System.out.println(((Doodad) object).getValue());
                            }
                        }
                        else {
                            System.out.println();
                        }
                    }
                    break;

                case "define":
                    // search already stored data to see if object already exists
                    found_flag = false;
                    for (int i=0; i < data.size(); i++) {
                        if (data.get(i) instanceof FSA) {
                            if (((FSA) data.get(i)).getName().equals(arguments[0])) {
                                found_flag = true;
                                dataPos = i;
                                break;
                            }
                        }
                        else {
                            if (((Doodad) data.get(i)).getName().equals(arguments[0])) {
                                found_flag = true;
                                dataPos = i;
                                break;
                            }
                        }
                    }

                    // case where input is a string
                    if (arguments[1].startsWith("\"")) {
                        arguments[1] = arguments[1].replace("\"", "");

                        // if data already contains the Doodad, modify it
                        // else, initialize one and add it to List data
                        if (found_flag) {
                            ((Doodad) data.get(dataPos)).setValue(arguments[1]);
                        }
                        else {
                            data.add(new Doodad(arguments[0], arguments[1]));
                        }
                    }
                    // case where input is an FSA
                    else {
                        // first, read FSA identifier
                        String[] tempInput = scan.nextLine().split("\\s+");
                        String tempId = tempInput[0];

                        // next, read FSA alphabet
                        tempInput = scan.nextLine().split("\\s+");
                        List<String> tempAlphabet = new ArrayList<String>(Arrays.asList(tempInput));

                        // finally, read FSA state-transition table
                        List<List<String>> tempTable = new ArrayList<List<String>>();
                        while (loop_flag) {
                            tempInput = scan.nextLine().split("\\s+");
                            if (tempInput[0].isEmpty()) {
                                loop_flag = false;
                            }
                            else {
                                List<String> tempRow = new ArrayList<String>(Arrays.asList(tempInput));
                                tempTable.add(tempRow);
                            }
                        }

                        // if data already contains the FSA, modify it
                        // else, initialize one and add it to List data
                        if (found_flag) {
                            ((FSA) data.get(dataPos)).setIdentifier(tempId);
                            ((FSA) data.get(dataPos)).setAlphabet(tempAlphabet);
                            ((FSA) data.get(dataPos)).setTransitionTable(tempTable);
                        }
                        else {
                            data.add(new FSA(arguments[0], tempId, tempAlphabet, tempTable));
                        }
                    }
                    break;

                case "run":
                    // TODO: branching run command
                    // getting position in List data of the FSA we're running a test against
                    found_flag = false;
                    for (int i=0; i < data.size(); i++) {
                        if (data.get(i) instanceof FSA) {
                            if (((FSA) data.get(i)).getName().equals(arguments[0])) {
                                found_flag = true;
                                dataPos = i;
                                break;
                            }
                        }
                    }

                    // checking if input is a given string or Doodad stored inside List data
                    String testCase = "";
                    if (arguments[1].startsWith("\"")) {
                        testCase = arguments[1].replace("\"", "");
                    }
                    else {
                        for (Object object : data) {
                            if (object instanceof Doodad) {
                                if (((Doodad) object).getName().equals(arguments[1])) {
                                    testCase = ((Doodad) object).getValue();
                                    break;
                                }
                            }
                        }
                    }

                    if (found_flag) {
                        runFSA(((FSA)data.get(dataPos)), testCase);
                    }
                    break;

                case "help":
                    System.out.println("Available commands:");
                    System.out.println("define - define and object");
                    System.out.println("print - print an object");
                    System.out.println("run - run an automaton with a parameter");
                    System.out.println("quit - quits the application");
                    break;

                default:
                    System.out.printf("\"%s\" is an invalid command.\n", command);
            }
        }
    }

    public static void runFSA(FSA automaton, String testCase) {
        String[] test = testCase.split("(?!^)");

        List<List<String>> table = automaton.getTransitionTable();
        List<String> alphabet = automaton.getAlphabet();

        String current_state = table.get(0).get(0);
        String accept_state = "";
        String step;
        for (List<String> list : table) {
            if (list.get(0).contains("*")) {
                accept_state = list.get(0).replace("*", "");
                System.out.print("");
            }
        }
        int row, column, count;
        row = column = count = 0;

        while (count < test.length) {
            step = test[count];
            System.out.print("");
            for (int i=0; i < alphabet.size(); i++) {
                if (alphabet.get(i).equals(step)) {
                    column = i;
                }
            }

            // since a list in table contains the state along with its output state values
            // we need to offset column by 1
            current_state = table.get(row).get(column+1);
            count++;
            System.out.print("");

            // update which row in the state-transition table we'll read on next loop
            for (int j=0; j < table.size(); j++) {
                if (table.get(j).get(0).contains(current_state)) {
                    row = j;
                }
            }
        }

        if (current_state.equals(accept_state)) {
            System.out.println("accept");
        }
        else {
            System.out.println("reject");
        }
    }
}
