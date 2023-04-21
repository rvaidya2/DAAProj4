JAVAC=javac
JAVA=java
JFLAGS=
SOURCES=Main.java
CLASSFILES=$(SOURCES:.java=.class)
MAINCLASS=Main

.PHONY: all clean

all: $(CLASSFILES)

clean:
	rm -f $(CLASSFILES)

%.class: %.java
	$(JAVAC) $(JFLAGS) $<

run: $(CLASSFILES)
	$(JAVA) $(MAINCLASS)

