JAVAC = javac
JAVA = java
JFLAGS = -g

# Define the source files and their dependencies
SRC = Main.java Prim.java Kruskal.java
DEPENDENCIES = Prim.class Kruskal.class

all: $(SRC:.java=.class)

%.class: %.java
	$(JAVAC) $(JFLAGS) $<

Main.class: $(DEPENDENCIES)

run: Main.class
	$(JAVA) Main

clean:
	$(RM) *.class
