all:
	javac org/ioopm/calculator/ast/*.java
	javac org/ioopm/calculator/parser/*.java

run:
	java org/ioopm/calculator/parser/ParserDriver

clean:
	rm -r  org/ioopm/calculator/ast/*.class
	rm -r  org/ioopm/calculator/parser/*.class
