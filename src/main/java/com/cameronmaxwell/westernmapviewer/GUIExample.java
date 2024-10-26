package com.cameronmaxwell.westernmapviewer;

import java.awt.Desktop;
import java.util.ArrayList;
import java.util.Stack;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * GUI component of the project 
 * 
 * @author Cameron Maxwell
 * @version 1.0
 */
public class GUIExample extends javax.swing.JFrame {

    /** creates BufferedImage for the map */
    private BufferedImage mapImage;
    
    /** stack that stores previous map selections for the back button */
    private Stack<int[]> previousMaps;
    /** sets the current map state for the back button */
    private int[] mapState = null;
    
    /** create jLabel for the selector label */
    private JLabel selector = new JLabel();
    
    /** names of the various buildings */
    private String[] buildingNames = {"Middlesex College", "Advanced Facility for Avian Research", "Staging Building"};
    
    /** names of the various layers */
    private String[] layerNames = {"Accessibility", "Washrooms", "Map Legend", "User-Defined POIs", "Favourites", "Classrooms", "Entry/Exit Points", "Labs", "Navigation", "Restaurants"};
    
    /** names of the various maps for MC */
    private String[] mcMapNames = {"Floor 0", "Floor 1", "Floor 2", "Floor 3", "Floor 4"};
    /** names of the various maps for AFAR */    
    private String[] afarMapNames = {"Floor 1", "Floor 2"};
    /** names of the various maps for STAB */    
    private String[] stabMapNames = {"Floor 1", "Floor 2"};
        
    /** keep track of the current map names to be used (by default set to Middlesex College - mcMapNames) */
    private String[] currentMapNames = mcMapNames;
   
    /** locations of map files for MC */
    private String[] mcMapFiles = {"maps/MC0_Base.png", "maps/MC1_Base.png", "maps/MC2_Base.png", "maps/MC3_Base.png", "maps/MC4_Base.png"};
    /** locations of map files for AFAR */
    private String[] afarMapFiles = {"maps/AFAR1_Base.png", "maps/AFAR2_Base.png"};
    /** locations of map files for STAB */
    private String[] stabMapFiles = {"maps/STAB1_Base.png", "maps/STAB2_Base.png"};
    
    /** set the file name for the load and save methods */
    private String fileName = "src/resources/data/POIs.json";
        
    /** keep track of the current map file paths to be used for displaying */
    private String[] currentMapFile;
    
    /** keep track of the current POI list index (by default set to -1 so methods know when no POI is selected) */
    private int currentPOIIndex = -1;
    
    /** keep track of the current map selected (by default set to Middlesex College - index 0) */
    private int currentBuildingIndex = 0;
    
    /** keep track of the current map (floor) selected */
    private int currentMapIndex = 0;
    
    /** keep track of the current POIs in the particular map selected to be listed in the POI list */
    private ArrayList<POI> currentPOIs = new ArrayList<POI>();
    
    /** keep track of x and y values each time a click occurs on map */
    private int x, y;
    
    /** keep track of if the program is in developer mode or not */
    boolean devMode = false;
    
    /**
     * Constructor. Creates new form NewJFrame.
     */
    public GUIExample() {
        // initialize components
        initComponents();
        
        //hide back button when there is nothing to go back to
        backButton.setVisible(false);

        // initialize stack
        previousMaps = new Stack<int[]>();

        // by default, have POI list be empty
        String[] empty = {""};
        POIList.setListData(empty);
        
        // by default, have Middlesex College map names appear
        mapList.setListData(mcMapNames);
        
        // adds the layer names to the JList components
        poiLayerList.setListData(layerNames);
        
        // try to load the selector.png image used for the mouse selector
        try {
            selector.setIcon(new ImageIcon(ImageIO.read(GUIExample.class.getClassLoader().getResource("imgs/select.png"))));
        } catch (IOException e) {
            System.out.println("Error reading poi.png");
            System.out.println(e.getMessage());
            System.out.println("Your class path is: " + System.getProperty("java.class.path"));
        }
        
        // add selector to layered map pane
        layeredMapPane.add(selector, 10);
        
        // sets layered map pane for the map
        layeredMapPane.setLayer(map, 0); 

        // keep selector hidden until shown
        selector.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * 
     * All code in initCompoents was generated by NetBeans. If you are using
     * the NetBeans GUI editor don't change this manually.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mapScrollPane = new javax.swing.JScrollPane();
        layeredMapPane = new javax.swing.JLayeredPane();
        map = new javax.swing.JLabel();
        controlPanel = new javax.swing.JPanel();
        searchTextField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        mapControlLabel = new javax.swing.JLabel();
        mapListScrollPane = new javax.swing.JScrollPane();
        mapList = new javax.swing.JList<>();
        mapShowButton = new javax.swing.JButton();
        poiLayerControlLabel = new javax.swing.JLabel();
        poiLayerScrollPane = new javax.swing.JScrollPane();
        poiLayerList = new javax.swing.JList<>();
        buildingSelect = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        POIList = new javax.swing.JList<>();
        mapControlLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        helpButton = new javax.swing.JButton();
        saveButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        backButton = new javax.swing.JButton();
        aboutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        mapScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        mapScrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        map.setText("No Map Loaded Yet!");
        map.setToolTipText("");
        map.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mapMouseClicked(evt);
            }
        });

        layeredMapPane.setLayer(map, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layeredMapPaneLayout = new javax.swing.GroupLayout(layeredMapPane);
        layeredMapPane.setLayout(layeredMapPaneLayout);
        layeredMapPaneLayout.setHorizontalGroup(
            layeredMapPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layeredMapPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(map)
                .addContainerGap(1049, Short.MAX_VALUE))
        );
        layeredMapPaneLayout.setVerticalGroup(
            layeredMapPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layeredMapPaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(map)
                .addContainerGap(1028, Short.MAX_VALUE))
        );

        mapScrollPane.setViewportView(layeredMapPane);

        controlPanel.setPreferredSize(new java.awt.Dimension(300, 717));

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        mapControlLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        mapControlLabel.setText("Maps");

        mapListScrollPane.setViewportView(mapList);

        mapShowButton.setText("Show");
        mapShowButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mapShowButtonActionPerformed(evt);
            }
        });

        poiLayerControlLabel.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        poiLayerControlLabel.setText("POI Layers");

        poiLayerList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                poiLayerListValueChanged(evt);
            }
        });
        poiLayerScrollPane.setViewportView(poiLayerList);

        buildingSelect.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        buildingSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Middlesex College", "Advanced Facility for Avian Research", "Staging Building" }));
        buildingSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buildingSelectActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 1, 22)); // NOI18N
        jLabel2.setText(Weather.temp);

        jLabel3.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        jLabel3.setText(Weather.conditions);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/weatherDefaultIcon.png"))); // NOI18N

        POIList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        POIList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        POIList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                POIListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(POIList);

        mapControlLabel1.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        mapControlLabel1.setText("POIs");

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buildingSelect, 0, 0, Short.MAX_VALUE)
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(controlPanelLayout.createSequentialGroup()
                                .addComponent(mapListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mapShowButton, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
                            .addGroup(controlPanelLayout.createSequentialGroup()
                                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(poiLayerControlLabel)
                                    .addGroup(controlPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel2)))
                                    .addComponent(poiLayerScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(controlPanelLayout.createSequentialGroup()
                                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(searchButton))
                                    .addComponent(mapControlLabel)
                                    .addGroup(controlPanelLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(mapControlLabel1)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                .addComponent(buildingSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addGap(12, 12, 12)
                .addComponent(mapControlLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addGap(18, 18, 18)
                .addComponent(mapControlLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mapShowButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mapListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(poiLayerControlLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(poiLayerScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addContainerGap())
        );

        jButton1.setText("jButton1");

        helpButton.setText("Help");
        helpButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        helpButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        helpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpButtonActionPerformed(evt);
            }
        });

        saveButton.setText("Save");
        saveButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        saveButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        removeButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        addButton.setText("Add");
        addButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        backButton.setText("Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        aboutButton.setText("About");
        aboutButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        aboutButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        aboutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(controlPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mapScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1013, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(editButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(removeButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(saveButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(helpButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(aboutButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(editButton)
                            .addComponent(addButton)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(helpButton)
                                .addComponent(saveButton)
                                .addComponent(removeButton))
                            .addComponent(backButton)
                            .addComponent(aboutButton))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mapScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 805, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(controlPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Method for when the add button is clicked.
     * @param evt add button clicked event
     */
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        // if user has not selected desired location yet, do not let them add a POI
        if (x + y == 0) {
            JOptionPane.showMessageDialog(this, "Please select a location first\nbefore trying to add a POI.", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        // call the add POI method
        addPOI();
    }//GEN-LAST:event_addButtonActionPerformed

    /**
     * Method for when the remove button is clicked.
     * @param evt remove button click event
     */
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed
        // if no POIs currently listed, user cannot remove
        if (currentPOIs.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Cannot remove a POI as there\nare no POIs to remove.", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        // if no selection has been made, user cannot remove
        else if (currentPOIIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select a POI from the list\nbefore attempting to remove.", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        // call the remove POI method
        removePOI();
    }//GEN-LAST:event_removeButtonActionPerformed

    /**
     * Method for when the edit button is clicked.
     * @param evt edit button click event
     */
    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // if no POIs currently listed, user cannot edit
        if (currentPOIs.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Cannot edit a POI as there\nare no POIs to edit.", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        // if no selection has been made, user cannot edit
        else if (currentPOIIndex == -1) {
            JOptionPane.showMessageDialog(this, "Please select a POI from the list\nbefore attempting to remove.", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        // call the edit POI method
        editPOI();
    }//GEN-LAST:event_editButtonActionPerformed

    /**
     * Method for when the save button is clicked.
     * @param evt save button click event
     */
    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // saves all POIs in the POI list to the JSON file
        WesternMapViewer.savePOIs(fileName);
        // notifies user about a successful save
        JOptionPane.showMessageDialog(this, "Save was successful!", "Save", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_saveButtonActionPerformed

    /**
     * Method for when the help button is clicked.
     * @param evt help button click event
     */
    private void helpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpButtonActionPerformed
        if (Desktop.isDesktopSupported()) {
            try {
                File helpFile = new File("src/resources/help/helpPage.pdf");
                Desktop.getDesktop().open(helpFile);
            } catch (IOException e) {
                System.err.println("Error reading help file.");
            }
        }
    }//GEN-LAST:event_helpButtonActionPerformed

    /**
     * Method for when the system exit button is pressed on the window.
     * @param evt system exit button click event
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int result = JOptionPane.showConfirmDialog(null,"Are you sure you would like to exit?\nPlease save any unsaved changes before exiting.", "Warning!", JOptionPane.YES_NO_OPTION);
        // if user choses to exit, save the POIs and exit the program
        if (result == JOptionPane.YES_OPTION) {
            dispose();
        }
        // if user choses to go back, set the close to do nothing
        else {
            setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * Method for when the various building options in the building drop down are selected.
     * @param evt building in drop down menu click event
     */
    private void buildingSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buildingSelectActionPerformed
        // set the current building index to what is selected
        currentBuildingIndex = buildingSelect.getSelectedIndex();
        //Adds the map names and layer names to the JList components depending on the building selected
        if (currentBuildingIndex == 0) {
            currentMapNames = mcMapNames;
        }
        else if (currentBuildingIndex == 1) {
            currentMapNames = afarMapNames;
        }
        else {
            currentMapNames = stabMapNames;
        }
        // sets map list
        mapList.setListData(currentMapNames);
        // clears list of current POIs
        currentPOIs.clear();
    }//GEN-LAST:event_buildingSelectActionPerformed
    
    /**
     * Method that is run when various layers are selected in the layer list.
     * @param evt layer in layer list click event
     */
    private void poiLayerListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_poiLayerListValueChanged
        // get array of the current layer selected
        int[] indicies = poiLayerList.getSelectedIndices();
    }//GEN-LAST:event_poiLayerListValueChanged

    /**
     * Method that is run when the map show button is clicked.
     * @param evt show map button click event
     */
    private void mapShowButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mapShowButtonActionPerformed
        URL mapFile;
        //get what item in the map list is selected
        currentMapIndex = mapList.getSelectedIndex(); 
        // determine which map file array to set as current depending on building selected
        if (currentBuildingIndex == 0) {
            currentMapFile = mcMapFiles;
        }
        else if (currentBuildingIndex == 1) {
            currentMapFile = afarMapFiles;
        }
        else {
            currentMapFile = stabMapFiles;
        }
        
        // if the map index selected is in bounds, attempt to display
        if(currentMapIndex < currentMapFile.length) {
            //This trys to find the location of the map file.
            //if mapFile is null, it could not find the file (not on class path?)
            mapFile = GUIExample.class.getClassLoader().getResource(currentMapFile[currentMapIndex]);
            //try to load the map image and set it on the map icon
            try {
                mapImage = ImageIO.read(mapFile);
                map.setIcon(new ImageIcon(mapImage));
                map.setText("");
                
                if (mapState != null){
                    previousMaps.push(mapState);
                    backButton.setVisible(true);
                }
                mapState = new int[]{currentBuildingIndex, currentMapIndex};
            } catch (IOException e) {
                // handle exception...
                // you will have to come up with a better way to deal with errors
                System.out.println("Error reading " + currentMapFile[currentMapIndex]);
                System.out.println(e.getMessage());
                System.out.println("Your class path is: " + System.getProperty("java.class.path"));
                if(mapFile != null)
                System.out.println("URL: " + mapFile.toString());
            }

            // on map change, make the selector invisible
            selector.setVisible(true);

            // clears layer selection
            poiLayerList.clearSelection();
            
            // clears old map's list of current POIs
            currentPOIs.clear();

            // update the POI list on a map change
            updateCurrentPOIList();
        }
    }//GEN-LAST:event_mapShowButtonActionPerformed

    /**
     * This method runs when the search button is pressed.
     * @param evt search button click event
     */
    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        //Search is not implmented yet so just show a pop up.
        JOptionPane.showMessageDialog(this, "The search is not implmented yet but you input: " + searchTextField.getText(), "Search", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_searchButtonActionPerformed

    /**
     * This method keeps a constant record of the x and y coordinates of each click on the map.
     * @param evt click on map JLabel event
     */
    private void mapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mapMouseClicked
        x = evt.getX();
        y = evt.getY();
        selector.setBounds(x-10, y-24, 50,50);
        selector.setVisible(true);
    }//GEN-LAST:event_mapMouseClicked

    /**
     * This method runs when a POI in the POI list is clicked.
     * @param evt POI in POI list click event
     */
    private void POIListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_POIListValueChanged
        currentPOIIndex = POIList.getSelectedIndex();
    }//GEN-LAST:event_POIListValueChanged

    /**
     * This method runs when the back button is clicked.
     * @param evt back button click event
     */
    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        // gets previous map from the stack
        mapState = previousMaps.pop();
        // adjusts display and building index to match the previous map
        buildingSelect.setSelectedIndex(mapState[0]);
        currentBuildingIndex = mapState[0];

        // determine which map file array and names to set as current depending on building selected
        if (currentBuildingIndex == 0) {
            currentMapNames = mcMapNames;
            currentMapFile = mcMapFiles;
        }
        else if (currentBuildingIndex == 1) {
            currentMapNames = afarMapNames;
            currentMapFile = afarMapFiles;
        }
        else {
            currentMapNames = stabMapNames;
            currentMapFile = stabMapFiles;
        }
        // sets map list
        mapList.setListData(currentMapNames);

        URL mapFile;
        // adjusts display and map index to match the previous map
        mapList.setSelectedIndex(mapState[1]);
        currentMapIndex = mapState[1];
        
        // if the map index selected is in bounds, attempt to display
        if(currentMapIndex < currentMapFile.length) {
            //This trys to find the location of the map file.
            //if mapFile is null, it could not find the file (not on class path?)
            mapFile = GUIExample.class.getClassLoader().getResource(currentMapFile[currentMapIndex]);
            //try to load the map image and set it on the map icon
            try {
                mapImage = ImageIO.read(mapFile);
                map.setIcon(new ImageIcon(mapImage));
                map.setText("");
            } catch (IOException e) {
                // handle exception...
                // you will have to come up with a better way to deal with errors
                System.out.println("Error reading " + currentMapFile[currentMapIndex]);
                System.out.println(e.getMessage());
                System.out.println("Your class path is: " + System.getProperty("java.class.path"));
                if(mapFile != null)
                System.out.println("URL: " + mapFile.toString());
            }

            // on map change, make the selector invisible
            selector.setVisible(true);

            // clears layer selection
            poiLayerList.clearSelection();
            
            // clears old map's list of current POIs
            currentPOIs.clear();

            // update the POI list on a map change
            updateCurrentPOIList();
        }
        // makes the back button invisble if there is nothing to go back too
        if (previousMaps.empty()){
            backButton.setVisible(false);
        }
    }//GEN-LAST:event_backButtonActionPerformed

    /**
     * This method runs when the about button is clicked.
     * @param evt about button clicked event
     */
    private void aboutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutButtonActionPerformed
        // displays a simple about screen
        JOptionPane.showMessageDialog(this, "Welcome to Campus Map Navigation!\n\nVersion: 1.0\n\nRelease Date: June 12, 2024\n\nAuthor:\nCameron Maxwell", "About", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_aboutButtonActionPerformed
    
    /**
     * This method updates the current POI list.
     */
    private void updateCurrentPOIList() {
        // first, clear the list of current POIs so that it can be made again
        currentPOIs.clear();
        // adds the correct POIs to the POI list depending on which building/map is selected
        for (int i = 0; i < WesternMapViewer.listOfPOIs.size(); i++) {
            POI currentPOI = WesternMapViewer.listOfPOIs.get(i);
            if (currentBuildingIndex == 0 && currentPOI.buildingName.equals("Middlesex College")) {
                if (currentMapIndex == 0 && currentPOI.mapName.equals("Floor 0")) { currentPOIs.add(currentPOI); }
                else if (currentMapIndex == 1 && currentPOI.mapName.equals("Floor 1")) { currentPOIs.add(currentPOI); }
                else if (currentMapIndex == 2 && currentPOI.mapName.equals("Floor 2")) { currentPOIs.add(currentPOI); }
                else if (currentMapIndex == 3 && currentPOI.mapName.equals("Floor 3")) { currentPOIs.add(currentPOI); }
                else if (currentMapIndex == 4 && currentPOI.mapName.equals("Floor 4")) { currentPOIs.add(currentPOI); }
            }
            else if (currentBuildingIndex == 1 && currentPOI.buildingName.equals("Advanced Facility for Avian Research")) { 
                if (currentMapIndex == 0 && currentPOI.mapName.equals("Floor 1")) { currentPOIs.add(currentPOI); }
                else if (currentMapIndex == 1 && currentPOI.mapName.equals("Floor 2")) { currentPOIs.add(currentPOI); }
            }
            else if (currentBuildingIndex == 2 && currentPOI.buildingName.equals("Staging Building")) {
                if (currentMapIndex == 0 && currentPOI.mapName.equals("Floor 1")) { currentPOIs.add(currentPOI); }
                 else if (currentMapIndex == 1 && currentPOI.mapName.equals("Floor 2")) { currentPOIs.add(currentPOI); }
            }
        }
        // extracts POI names from each current POI in arraylist into an array to display
        String[] currentPOIsNames = new String[currentPOIs.size()];
        for (int i = 0; i < currentPOIs.size(); i++) {
            currentPOIsNames[i] = currentPOIs.get(i).poiName;
        }
        // displays names of POIs
        POIList.setListData(currentPOIsNames);
    }
        
    /**
     * This method adds a POI to the current POI list and to the global POI list.
     */
    private void addPOI() {
        // variables for data to be entered
        boolean builtIn;
        boolean favourite;
        JTextField namePOI = new JTextField();
        JTextField roomNumber = new JTextField();
        JTextField roomName = new JTextField();
        JTextField layers = new JTextField();
        JTextField description = new JTextField();
        // ask if POI will be built-in
        int poiBuiltIn = JOptionPane.showConfirmDialog(this, "Will your new POI be built-in?", "Add", JOptionPane.YES_NO_OPTION);
        if (poiBuiltIn == JOptionPane.YES_OPTION) {
            // if in dev mode, let user add the POI
            if (devMode == true) {
                builtIn = true;
            }
            // if not in dev mode, kick out of add
            else {
                JOptionPane.showMessageDialog(this, "This action is not allowed\nwhen not in developer mode", "Error", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
        }
        // if user says no, mark builtIn as false
        else {
            builtIn = false;
        }
        // ask for metadata of new POI
        Object[] message = {    
            "POI Name:", namePOI,
            "Room Number:", roomNumber,
            "Room Name:", roomName,
            "Layers:", layers,
            "Description:", description 
        };
        int poiData = JOptionPane.showConfirmDialog(null, message, "Add", JOptionPane.OK_CANCEL_OPTION);
        // if user choses to cancel, kick out of add
        if (poiData == JOptionPane.CANCEL_OPTION) {
            return;
        }
        // ask if POI will be a favourite, then update favourite variable accordingly
        int poiFavourite = JOptionPane.showConfirmDialog(this, "Will your new POI be a favourite?", "Add", JOptionPane.YES_NO_OPTION);
        if (poiFavourite == JOptionPane.YES_OPTION) {
            favourite = true;
        }
        else {
            favourite = false;
        }
        // lastly, create POI and add it to main list of POIs
        POI newPOI = new POI(buildingNames[currentBuildingIndex], currentMapNames[currentMapIndex], favourite, description.getText(), x, y, Integer.parseInt(roomNumber.getText()), roomName.getText(), namePOI.getText(), layers.getText(), builtIn);
        WesternMapViewer.listOfPOIs.add(newPOI);
        // update POI list after change
        updateCurrentPOIList();    
    }
    
    /**
     * This method removes a POI from the current POI list and the global POI list.
     */
    private void removePOI() {
        // find the POI in the current list of POIs and make a new POI object from it
        int index = POIList.getSelectedIndex();
        POI removePOI = currentPOIs.get(index);
        // check if POI is built-in and user is not in developer mode
        if (removePOI.isBuiltIn == true && devMode == false) {
            JOptionPane.showMessageDialog(this, "This action is not allowed\nwhen not in developer mode", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        // search global POI list for the matching POI, then remove it
        for (int i = 0; i < WesternMapViewer.listOfPOIs.size(); i++) {
            if (removePOI.equals(WesternMapViewer.listOfPOIs.get(i))) {
                WesternMapViewer.listOfPOIs.remove(i);
             }
        }
        // inform the user of a successful removal
        JOptionPane.showMessageDialog(this, "POI successfully removed.", "Remove", JOptionPane.INFORMATION_MESSAGE);
        // finally, update the current POI list to complete the removal
        updateCurrentPOIList();
    }

    /**
     * This method edits a POI in the current POI list and in the global POI list.
     */
    private void editPOI() {
        // variables for data to be entered
        boolean favourite;
        JTextField namePOI = new JTextField();
        JTextField roomNumber = new JTextField();
        JTextField roomName = new JTextField();
        JTextField layers = new JTextField();
        JTextField description = new JTextField();
        // get the index of the current POI selection
        int index = POIList.getSelectedIndex();        
        // make a new POI object to manipulate
        POI oldPOI = currentPOIs.get(index);
        // prevent user from editing a built-in POI when not in developer mode
        if (oldPOI.isBuiltIn == true && devMode == false) {
            JOptionPane.showMessageDialog(this, "Cannot edit a built-in POI\nwhen not in developer mode.", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        // ask for metadata of new POI, while showing the current metadata of the POI for comparison
        Object[] message = {    
            "POI Name:" + " (Currently: " + oldPOI.poiName + ")", namePOI,
            "Room Number:" + " (Currently: " + oldPOI.roomNumber + ")", roomNumber,
            "Room Name:" + " (Currently: " + oldPOI.roomName + ")", roomName,
            "Layers:" + " (Currently: " + oldPOI.layers + ")", layers,
            "Description:" + " (Currently: " + oldPOI.description + ")", description,
        };
        int poiData = JOptionPane.showConfirmDialog(null, message, "Edit", JOptionPane.OK_CANCEL_OPTION);
        // if user choses to cancel, kick out of add
        if (poiData == JOptionPane.CANCEL_OPTION) {
            return;
        }
        // ask if edited POI will be a favourite, then update favourite variable accordingly
        int poiFavourite = JOptionPane.showConfirmDialog(this, "Will the POI be a favourite?\n(Currently: " + oldPOI.favourite + ")", "Edit", JOptionPane.YES_NO_OPTION);
        if (poiFavourite == JOptionPane.YES_OPTION) {
            favourite = true;
        }
        else {
            favourite = false;
        }
        // create new POI from edits
        POI editedPOI = new POI(oldPOI.buildingName, oldPOI.mapName, favourite, description.getText(), x, y, Integer.parseInt(roomNumber.getText()), roomName.getText(), namePOI.getText(), layers.getText(), oldPOI.isBuiltIn);
        // remove unedited POI and add new edited POI to global list of POIs
        for (int i = 0; i < WesternMapViewer.listOfPOIs.size(); i++) {
            if (oldPOI.poiName.equals(WesternMapViewer.listOfPOIs.get(i).poiName)) {
                WesternMapViewer.listOfPOIs.remove(i);
             }
        }
        // add edited POI to the global POI list
        WesternMapViewer.listOfPOIs.add(editedPOI);
        // finally, update the current POI list
        updateCurrentPOIList();
    }
    
    /**
     * Main method of the GUI component. Entirely generated by NetBeans
     * @param args args for main method
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIExample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIExample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIExample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIExample.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIExample().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> POIList;
    private javax.swing.JButton aboutButton;
    private javax.swing.JButton addButton;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> buildingSelect;
    private javax.swing.JPanel controlPanel;
    private javax.swing.JButton editButton;
    private javax.swing.JButton helpButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLayeredPane layeredMapPane;
    private javax.swing.JLabel map;
    private javax.swing.JLabel mapControlLabel;
    private javax.swing.JLabel mapControlLabel1;
    private javax.swing.JList<String> mapList;
    private javax.swing.JScrollPane mapListScrollPane;
    private javax.swing.JScrollPane mapScrollPane;
    private javax.swing.JButton mapShowButton;
    private javax.swing.JLabel poiLayerControlLabel;
    private javax.swing.JList<String> poiLayerList;
    private javax.swing.JScrollPane poiLayerScrollPane;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    // End of variables declaration//GEN-END:variables
}
