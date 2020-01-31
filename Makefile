
Classes = \
		Animal.java \
		Species.java \
		Tiger.java \
		Penguin.java \
		Text_IO.java \
		Turtle.java \
		Zoo.java
main : 
	javac $(Classes)

clean:
	rm *.class