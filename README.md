## Zoo.java

<p>
	&nbsp; A "Zoo" simulation.
	<br>
	&nbsp; My first design goal was to demonstrate polymorphism through inheritance. Inheritance can be a valuable tool which must be used judiciously, so I chose to implement it in as minimal context as necessary. 
</p>

<p>
	<br>
	&nbsp; My second design goal was to demonstrate features of Java 8 that borrow from the functional paradigm, including the 'stream' wrapper, the 'select' function, and the use of pipes. 
</p>

  <p>
 	&nbsp; The only interaction the user has with the program is at the command line. The main method (nested in the Zoo class) is a test driver; it's possible to add an interactive GUI to create a turn-by-turn game.
  </p>


## How to Compile and Run
### Compilation
<p>
	<ul>
		<li>
			Download or clone.
		</li>
		<li>
			Open terminal window and invoke makefile with:
			<br> <em> make </br>
		</li>
	</ul>
</p>

### Run
<p>
	<ul>
		<li>
			In terminal, navigate to program directory.
		</li>
		<li>
			Invoke java program with four integer-arguments.
			<br> The arguments represent the starting state of the Zoo.
			<br> <em> java Zoo &lt;money&gt; &lt;penguins&gt; &lt;tigers&gt; &lt;turtles&gt;</em>		</li>
	</ul>
</p>

### Example
<p>
Here's the last turn and end state and the code that invoked it.
<br> <em> java Zoo 100000 6 5 50</em>
</p>

<div>
	<img src="/example.png">
</div>
  
