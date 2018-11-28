all:
	javac org/ioopm/calculator/ast/*.java
	javac org/ioopm/calculator/parser/*.java
	javac org/ioopm/calculator/Calculator.java


run: all
	java org/ioopm/calculator/Calculator

clean:
	rm -r  org/ioopm/calculator/ast/*.class
	rm -r  org/ioopm/calculator/parser/*.class
	rm -r  *.class

test: all
	javac Test.java
	java Test
