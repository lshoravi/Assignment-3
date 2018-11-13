all:
	javac -cp p:/assignment3/classes  *.java

run:
	java -cp .:$BASE_DIR ParserDriver

clean:
	rm -r *.class
