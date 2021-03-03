# William Faunce
#
# A simple Makefile for compiling java programs.
# To compile a user can simply type
#
# make
#
# at the command line.  To remove all of the files that were built and leave
# only the source files, a user can type
#
# make clean
#
# at the command line.


# The top level directory
rootdir = .

# Where the source files are
CLASSPATH = $(rootdir)/src/

# List of source files
sourcelist = $(shell find $(rootdir) -name '*.java' | sed "s,[.]/,,g")

default: all

all:
    # Compile source files
	@javac -cp $(CLASSPATH) $(sourcelist)
	# lexaard executable made
	@echo "java -cp" $(CLASSPATH) lexaard > lexaard
	@chmod +x lexaard

clean:
	rm lexaard
    # Remove all the class files in the classpath
	@-find $(rootdir) \( -name "*~" -o -name "*.class" -o -name "runTests" \) -exec rm '{}' \;
