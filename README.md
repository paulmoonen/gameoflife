# Game of Life
<pre>
A traditional math pastime.
Simple rules can produce amazing patterns in time and space...

This program opens up a window with an empty, clickable area, and several buttons below.

The cells ( in a 30 x 30 grid ) can be either 'alive' (dark grey) or 'dead' (light grey).
Click a spot in the clickable area, to toggle the status of the cell right there, 
and go on like this to make all kinds of patterns and clusters of 'alive' cells.
( lumpiness is good! )
This is the first generation of 'alive' cells.

( if you are lazy, just hit the 'Random' button to seed a nice random pattern )

A simple set of rules, using the statuses of the neighbouring cells, 
determines whether a specific cell will come alive, will stay alive 
or will die, in the next generation. 

Click on the 'Next Generation' button to see what will happen to any pattern.

Buttons:

Random:             fill with a random pattern of 'alive' and 'dead' cells
Invert:             make all 'dead' cells 'alive', and all 'alive' cells 'dead'
Clear:              make all cells 'dead'
Next Generation:    show the next generation, a new pattern that descends from the current one
Run / Pause:        start or interrupt the flow of new patterns

Some patterns die away quickly.
Some patterns will expand, or pulsate, or move around and stay active for many generations.
Some patterns will eventually become stable.  

The 30 x 30 grid works just like the road map of a doughnut:
The top and bottom rows touch like neighbours, the left and right columns behave in the same way.
When a pattern crawls away across one edge of the screen, it simultaneously emerges 
on the exact opposite side.

This program is made with Java version openjdk 11.0.15 
</pre>











