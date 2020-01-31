## Zoo.java

<p>
	&nbsp; A "Zoo" simulation.
	<br>
	&nbsp; My first design goal was to demonstrate polymorphism through a minimalistic form of inheritance. Inheritance can be a valuable tool, but it must be used judiciously. 
</p>

<p>
	&nbsp; A "Zoo" simulation.
	<br>
	&nbsp; My second design goal was to demonstrate the use of some features of Java 8 that borrow from the functional programming paradigm, including the 'stream' wrapper, the 'select' function, and the use of pipes. 
</p>



## How to Compile
<p>
Download or clone, then invoke the makefile by opening a terminal window and typing 'make' (without the quotes).
Then, invoke in the following manner: <br>
  java Zoo &lt;int&gt; &lt;int&gt; &lt;int&gt; &lt;int&gt; <br>
  The first in is the amount of money with which the Zoo begins operation. <br>
  The other three ints are the number of penguins, tigers, and turtles that you want to purchase before opening day. <br>
  example: java Zoo 100000 3 3 3
  </p>
  
  <p>
  The only interaction the user has with the program is at the command line. The purpose of the main method (nested in the Zoo class) was merely to test the other classes; it would be possible to add an interactive GUI to create a turn-by-turn game.
  </p>
