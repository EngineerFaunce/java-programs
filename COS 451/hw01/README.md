## Description

This program reads in a graph and outputs the clique from pile A
and the independent set from pile B.

The input is a parenthesized list of elements. Each element is a
parenthesized identifier or parenthesized pair of identifiers.
In the former case, it represents a vertex with the given
identifier. In the latter case, it represents an edge between
nodes with the given identifiers. There are no ordering
constraints, so a vertex may be presented after an edge that
uses it. Further, nodes that are mentioned in edges are
implicitly assumed to exist, even if they are not explicitly provided in the input.

## Project Composition

The project is composed of the following classes:

- Main.java     - Main program for getting user input and printing to standard output.
- Graph.java    - Data class containing a list of vertices and list of edges, along with various methods.
- Edge.java     - Data class containing two nodes (vertices) and various methods.

## Compiling

The project may be compiled by using the included Makefile and typing `make` in a terminal.

## Example Inputs

The input may contain arbitrary whitespace (including none, except when needed to separate identifiers).

```
Input 1: ((a b) (b c) (b) (c a) (a))

Input 2: ((a) (b c) (d a) (c d) (c e) (f g) (h))
```

