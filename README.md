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
1. Add a .ignore file so that classes and jar files dont get pushed.
2. Make it a gradle project so that it does all build activities with a regular build (no dependence on enviroment or chance of human error).
2. Externalize properties.
3. Add unit tests.
4. Make it a gradle CI build so every change saved will run the unit test.
5. Upgrade to latest gradle project for performance features.

Important : Use https://github.blog/2022-11-15-the-journey-of-your-work-has-never-been-clearer/ for tracking tasks!
