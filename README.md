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

Steps to create gradle project:
1. philip@philip-Lenovo-B50-70:~/workspace/repositories/git/github/FirstGame/PhilipsSpaceRover$ ~/gradlew init
2. Select type of project to generate: 2 (Application)
3. Select implementation language: : 3 Java
4. Split functionality across multiple subprojects?: 1. no
5. Generate build using new APIs and behavior: no
6. Select test framework: 4: JUnit Jupiter
7. Project name (default: PhilipsSpaceRover): collision
8. Source package (default: collision):
9.> Task :init
Get more help with your project: https://docs.gradle.org/7.5.1/samples/sample_building_java_applications.html
10. To take a build:
  a)  ./gradlew run
  b) to do a continous build for every change (useful!) ./gradlew -t  run
  c) to make into jar file : ./gradlew clean jar
  
  pending : current jar does not run on double clicking.


