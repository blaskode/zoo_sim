# zoo_sim
A "Zoo Simulator" written in Java written to demonstrate polymorphism using (minimalistic) inheritance, and use of streams with the ArrayList container class.

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
