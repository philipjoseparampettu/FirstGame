# FirstGame
This was my first try at Java for game developement. It was done over a weekend around 10 years back. 
Please feel free to compile this and convert it to a executable jar.
Linux users would need to make this executable before playing with it.

To generate executable jar
1. Navigate to /FirstGame/PhilipsSpaceRover/ folder
2. javac collision/*.java
3. jar cvfm PhilipsSpaceRover.jar META-INF/MANIFEST.MF collision/*
4. chmod +x PhilipsSpaceRover.jar # only for linux computers
5. java -jar PhilipsSpaceRover.jar # to run from cli; alternatively we can double click the file.
