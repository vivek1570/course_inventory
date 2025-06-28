MAIN ?=JavaMysql_1
CLASSPATH=.:mysql-connector-j-9.3.0.jar
SRC=$(MAIN).java

.PHONY:run compile clean

compile:
	@echo "Compiling $(SRC)..."
	javac -cp $(CLASSPATH) $(SRC)

run:
	@echo "Running the file $(SRC)..."
	java -cp $(CLASSPATH) $(MAIN)

class:
	rm -f *.class