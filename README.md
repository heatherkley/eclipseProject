# eclipseProject

How to run the test on Mac OR Windows: 

Open in an IDE (eclipse) and run the Tests class (src/main/java/eclipseproject/Tests.java). 

IMPORTANT: The Spotify desktop or toolbar ICON must be visible at all times on the screen while the test is running
(pin spotify application to toolbar or have the spotify desktop shortcut shown at all times while the application is open (no full screen mode)

NOTE: the JRE System Library may need to be deleted and readded through the configure build path as a workspace default if there's a warning.



Assumptions/Restrictions:

Assumption: The GUI components are stable and not frequently changing.
Assumption: Logs into the application successfully.
Assumption: The test will be run using the most current version that contains the most up-to-date GUI (1.0.29.92).
Assumption: Spotify will have access to communicate on network (windows firewall).
Assumption: The test will fail if any popups interfere while running.

Scenarios Covered:

a. Valid Login
b. Invalid Login
c. Search for Artist
d. Search for Song and Play the song
e. Create new Radio Station