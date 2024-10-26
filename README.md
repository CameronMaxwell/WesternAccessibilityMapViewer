Summary: This application's purpose is to allow users to navigate and explore interior spaces at Western University using the floor plans of all buildings that Western provides. In summary, the application allows users to scroll through individual floor plans belonging to particular buildings, locate possible points of interest (classrooms, labs, etc.) in the buildings, and create/save their own user-created points of interest in the buildings.

Required Libraries and Tools: Git (latest version 2.40.0) Java (version 19) Apache Maven (latest version 3.9.1) JSON.simple (version 1.1) Google Gson (version 2.10) JUnit (version 5.6.0)

How to Build the Software:

Open the project at its root directory in NetBeans
Right-click the top folder in the "Projects" window called "GIS_Project" > Build with Dependencies
Navigate to root of project in file explorer
Goto the target folder
Move "GIS_Project-1.0-SNAPSHOT-jar-with-dependencies.jar" up one directory (into the project root)
How to Run the Built Software (on Windows 10):

Update Windows
Update the system's Java installation
Install a PDF viewer
Move "GIS_Project-1.0-SNAPSHOT-jar-with-dependencies.jar" into the project root folder if it's not there already
Execute "GIS_Project-1.0-SNAPSHOT-jar-with-dependencies.jar"
User Guide (from the "Help Page" in the application): Browsing Maps: - First, select a building in the drop-down menu located in the top left-hand corner of the program. - Next, select the desired map in the map list that appears after selecting a building. - Finally, press the “show” button right of the map list to display the chosen map. Scrolling Maps: - When viewing a map in the application, use the vertical and horizontal scroll bars to scroll through the map images. POI Discovery: - To discover the various POIs on a given map, refer to the POI list on the left side of the application. All POIs that belong to the selected map will be listed. Adding POIs: - To add a POI, first select a location on a specific map. - Next, click the “Add” button near the top of the application. - Finally, fill out the metadata for the new POI. Editing POIs: - To edit a POI, first select a POI from the POI list. - Next, click the “Edit” button near the top of the application. - Finally, fill out the new metadata for the edited POI. Removing POIs: - To remove a POI, simply select a POI from the POI list and then select the “Remove” button near the top of the application. Saving Data: - To save your changes, select the “Save” button near the top of the application.

Enabling editor mode: In GUIExample.java set devMode to true.
