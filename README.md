# FirstGame
This was my first try at Java for game developement. It was done over a weekend around 10 years back. 
Please feel free to compile this and convert it to a executable jar.
Linux users would need to make this executable before playing with it.

To generate executable jar
1. Navigate to /FirstGame/PhilipsSpaceRover/ folder.
2. javac collision/*.java
3. jar cvfm PhilipsSpaceRover.jar META-INF/MANIFEST.MF collision/*
4. chmod +x PhilipsSpaceRover.jar # only for linux computers
5. java -jar PhilipsSpaceRover.jar # to run from cli; alternatively we can double click the file.

To improve on
1. Make it a gradle project so that it does all build activities with a regular build (no dependence on enviroment or chance of human error).
2. externalize properties.
3. add unit tests
4. Make it a gradle CI build so every change saved will run the unit test.
5. Upgrade to latest gradle project for performance features.
