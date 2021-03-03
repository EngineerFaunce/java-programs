# Lexaard Interpreter
#### By William Faunce

The following program is an interpreter for the language Lexaard (language for exploring automata
and related doodads).

## Project Composition
The project is composed of the following source files:
* lexaard.java
    * This is the main application for running the lexaaard interpreter.
    
* FSA.java
    * A class file for creating a finite state automaton. Has data members for 
      name, identifier, alphabet, and state-transition table
      
* Doodad.java
    * A class file that is basically just a representation of a String variable. Contains
      members for a "variable" name and its value.

## Compiling
Using the included Makefile, the user can compile the program by running `make` in a Terminal.
This will compile each `.java` file in the `src` directory.

To remove the compiled files, the user can run `make clean`.

## Description
The language consists primarily of newline-terminated statements, with exceptions
noted below. Each statement and each line of the input, consists of whitespace-
separated tokens, where whitespace is a nonempty sequence of any mix of spaces and
tabs. Whitespace at the beginning and end of a line is permitted but not required. The
first token of each statement is a verb that determines how the rest of the statement
is interpreted. The language uses only an easily printable subset of the 7-bit ASCII
character set (letters, digits, punctuation, space, tab, newline) and is case-sensitive.

The language has three types of objects: symbols, strings, and automata. Symbols are
unquoted strings (sequences of characters) that follow the typical rules for identifiers
in a language such as Java or C. Examples: x, m101, my first automaton. Strings use
the familiar quoted representation. Examples: "x", "am I a string?". FSA
are represented as suggested by the following two equivalent representations of the
automaton M 1 from page 36 of the textbook. (For clarity, we use |_| to denote a space
character. There is a single newline character terminating each line, and a single blank
line that terminates each representation.)

## Commands

| Command | Description |
|---|---|
| quit          | Exit the interpreter completely. The interpreter must also exit at the end of standard input. |
| print x       | Print the external representation of the object named x. It is not an error if x is undefined; print nothing in this case. FSA should be printed in a well- formatted manner (but it is not strictly incorrect to print them in a different, valid manner).|
| define x v    | Define the name x to be the object represented by v. |
| run x i       | Run the automaton named x on the input string literal i. It is an error if x is not defined to be an automaton. The output is a single line containing accept or eject depending on whether the automaton accepts or rejects the input. |
| run x n       | As above, except n is the name of a previously defined string that is used as input to the automaton.

## Example Input
```
define x "01011"
print x
define x "1101011"
print x
define m1 fsa
m1orwhatever
0  1
q1 q1 q2
*q2 q1 q2

print m1
run m1 "000101010010"
run m1 "0001010100101"
run m1 "0001010100100"
run m1 x
quit
```

## Example Output

```
01011
1101011
m1orwhatever
    0  1
 q1 q1 q2
*q2 q1 q2

reject
accept
reject
accept
```