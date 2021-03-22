# mow-it-now

This application is about a Area, containing mowers that can move inside it (and mow).
The mower has (x,y) position and orientation (N,E,S,W) and can receive instructions (A,D,G) to go forward, turn right or turn left
## How to use:
Clone the project and create a Maven project from it

run `mvn clean install` to download dependencies

Once you can start the application : it will launch some product price calculation

The principal method is `App.read(String input)` : it will take dimensions of the area and mowers setting in the next lines

The result will be the final positions of the mowers after executing the instructions

Enjoy ;)
