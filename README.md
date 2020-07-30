# CUBESHOTS
A rhythmic game written in Java using Slick2D library (based from the tutorial and game Wave© by RealTutsGML). Copyright goes to the owners of the music that was used in the game code (just for testing purposes)
# Libraries
Slick2D
# Notes
The code will not work properly if you didn't follow these:
1. Edit the main code's (game_.java) run configuration's VM options to -Djava.library.path="path to Slick2D library"
2. Add paths of the libraries and resources_ used.
# Building
You need JarSplice to compile the code (sorry i'm so lazy), so follow the instructions carefully.
1. Make sure ".idea\artifacts\CUBESHOTS__release_alpha__jar.xml" exist.
2. Build > Build Artifacts > CUBESHOTS (release alpha).jar > Build
3. Open JarSplice then Add Jars > Import CUBESHOTS (release alpha).jar, all Slick2D jars
4. Leave natives blank.
5. Input main class "gamemakerstudio.game_"
6. Create Fat Jar.
7. Copy resources_ folder to the same directory of the created fat jar.
# Installation (for non-programmers)
Download the latest release (and the resources_, too).
