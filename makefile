all:
	javac -cp classes  *.java

run:
	java -cp classes org.ioopm.calculator.parser.ParserDriver

clean:
	rm -r *.class
