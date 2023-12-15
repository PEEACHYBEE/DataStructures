package Prelim.GroupProject2_GoogleClassroomGUI.Menu;
import Prelim.GroupProject2_GoogleClassroomGUI.ReferenceClasses.topicDetails;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;

/**
 * The Classroom class represents a graphical user interface for managing
 * course topics and materials. It extends the JFrame class and provides a
 * set of components and functionality for adding, updating, and deleting
 * topics and materials.
 */
public class Classroom extends JFrame{

    // Declare private member variables for various GUI components
    private JFrame frame, newFrame, materialFrame, deleteFrame, updateFrame, deleteMaterialFrame, updateMaterialFrame;
    private JPanel mainPanel, topicPanel, headerPanel, materialPanel, materialBoxPanel, deletePanel, updatePanel, deleteMaterialPanel, updateMaterialPanel;
    private JLabel courseNameLabel, courseNumberLabel, topicNameLabel, materialNameLabel, updateLabel, updateMaterialLabel;
    private RoundButton addButton, deleteButton, updateButton, confirmAddButton, clearButton,
            addMaterialButton, removeMaterialButton, updateMaterialButton, confirmDeleteButton,
            confirmUpdateButton, confirmAddMaterial, confirmDeleteMaterialButton, confirmUpdateMaterialButton;
    private RoundJTextField courseNameTextField, courseNumberTextField, topicNameTextField, materialTextField, updateTextField, updateMaterialTextField;

    private JComboBox<String> topicDropdown, topicDropForOthers, materialDropdown, addMaterialDropdown;
    private int y = 200;
    private int yOfMaterial = 10;
    private int xOfMaterial = 200;

    // Create linked lists to store topic and material details
    private LinkedList<topicDetails> mainLinkedList = new LinkedList<>();
    private LinkedList<topicDetails> subLinkedList = new LinkedList<>();
    private LinkedList<String> topicNamesList = new LinkedList<>();
    private LinkedList<String> materialNamesList = new LinkedList<>();
    private LinkedList<JPanel> topicPanels = new LinkedList<>();

    /**
     * Constructs a new Classroom object and initializes the graphical user interface
     * for managing course topics and materials.
     */

    public Classroom() {
        // Create and configure the main application frame
        frame = new JFrame();
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(850, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Welcome to SLU Classroom");
        frame.setLocationRelativeTo(null);

        // Create the main panel and set its layout and background color
        mainPanel = new JPanel();
        mainPanel.setLayout(null);
        Color yellow = new Color(255,242,178);
        mainPanel.setBackground(yellow);
        frame.add(mainPanel);

        // Set the application icon
        Image Icon = Toolkit.getDefaultToolkit().getImage("picture/classroomPicture.png");
        frame.setIconImage(Icon);

        // Create and configure the title label
        JLabel title = new JLabel("SLU Classroom");
        title.setFont(new Font("Comic Sans", Font.BOLD, 50));
        title.setBounds(230,5,500,100);
        Color blue = new Color(1, 98, 175);
        title.setForeground(blue);
        mainPanel.add(title);

        // Create and configure the "ADD TOPIC" button
        addButton = new RoundButton("ADD TOPIC");
        addButton.addActionListener(new ButtonHandler());
        addButton.setBounds(170, 98, 120, 25); //Adjust the button's position
        mainPanel.add(addButton);

        // Create and configure the "DELETE TOPIC" button
        deleteButton = new RoundButton("DELETE TOPIC");
        deleteButton.addActionListener(new ButtonHandler());
        deleteButton.setBounds(360, 98, 120, 25); //Adjust the button's position
        mainPanel.add(deleteButton);

        // Create and configure the "UPDATE TOPIC" button
        updateButton = new RoundButton("UPDATE TOPIC");
        updateButton.addActionListener(new ButtonHandler());
        updateButton.setBounds(540, 98, 120, 25); //Adjust the button's position
        mainPanel.add(updateButton);

        // Create the header panel for topic buttons and set its background color and border
        headerPanel = new JPanel();
        Color lightBlue = new Color(102,155,188); //162 214 249
        headerPanel.setBackground(lightBlue);
        headerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); //Add a black border
        headerPanel.setBounds(140, 90,550,40);
        mainPanel.add(headerPanel);

        // Create and configure the "ADD MATERIAL" button
        addMaterialButton = new RoundButton("ADD MATERIAL");
        addMaterialButton.addActionListener(new ButtonHandler());
        addMaterialButton.setBounds(160, 140, 140, 25);
        mainPanel.add(addMaterialButton);

        // Create and configure the "DELETE MATERIAL" button
        removeMaterialButton = new RoundButton("DELETE MATERIAL");
        removeMaterialButton.addActionListener(new ButtonHandler());
        removeMaterialButton.setBounds(350, 140,140,25);
        mainPanel.add(removeMaterialButton);

        // Create and configure the "UPDATE MATERIAL" button
        updateMaterialButton = new RoundButton("UPDATE MATERIAL");
        updateMaterialButton.addActionListener(new ButtonHandler());
        updateMaterialButton.setBounds(530,140,145,25);
        mainPanel.add(updateMaterialButton);

        // Create and configure the material dropdown
        materialDropdown = new JComboBox<>();
        materialDropdown.addItem("Select Material");
        materialDropdown.setBounds(166, 200, 150 , 25);

        addMaterialDropdown = new JComboBox<>();
        addMaterialDropdown.addItem("Select Material");
        addMaterialDropdown.setBounds(166, 226, 150 , 25);
        //mainPanel.add(addMaterialDropdown);

        // Create and configure the topic dropdown
        topicDropdown = new JComboBox<>();
        topicDropdown.addItem("Select Topic");
        topicDropdown.setBounds(166, 180, 130 , 25);

        // Add topics to the dropdown as needed
        for (topicDetails topic : mainLinkedList) {
            topicDropdown.addItem(topic.getTopicName());
        }

        //Delete Topic Dropdown List in Delete Frame
        topicDropForOthers = new JComboBox<>();
        topicDropForOthers.addItem("Select Topic");

        // Add an ItemListener to the topicDropForOthers dropdown
        topicDropForOthers.addItemListener(new ItemListener() {
            /**
             * Handles the item state change event when the selection in a JComboBox changes.
             * This method is specifically designed to respond to the selection change event
             * of a topic selection JComboBox and calls the "mDropdown" method to populate
             * a material dropdown based on the selected topic.
             * @param e An ItemEvent representing the item state change event.
             */
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    mDropdown(); // Call mDropdown() when the topic selection changes
                }
            } // end of itemStateChanged method
        });
    }

    /**
     * The ButtonHandler class implements ActionListener to handle button clicks
     * and perform various actions in response to button events.
     */
    class ButtonHandler implements ActionListener {
        /**
         * Handles button click events and performs corresponding actions.
         * @param e An ActionEvent representing the button click event.
         */
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == addButton) {
                newFrame = new JFrame("SLU Classroom");
                JPanel newPanel = new JPanel();
                newPanel.setLayout(null);

                Color yellow = new Color(255, 242, 178);
                newPanel.setBackground(yellow);

                newFrame.setResizable(false);
                newFrame.setVisible(true);
                newFrame.setLocationRelativeTo(null);
                newFrame.setSize(450, 300);
                newFrame.add(newPanel);
                newFrame.setLocationRelativeTo(null);

                JLabel addTitle = new JLabel("Input the subject's details");
                addTitle.setBounds(100, 30, 400, 30);
                addTitle.setFont(new Font("Comic Sans", Font.BOLD, 20));
                newPanel.add(addTitle);

                courseNameLabel = new JLabel("Course Name: ");
                courseNameLabel.setBounds(80, 80, 100, 25);
                newPanel.add(courseNameLabel);

                courseNameTextField = new RoundJTextField(20);
                courseNameTextField.setBounds(210, 80, 150, 25);
                newPanel.add(courseNameTextField);

                courseNumberLabel = new JLabel("Course Number: ");
                courseNumberLabel.setBounds(80, 110, 100, 25);
                newPanel.add(courseNumberLabel);

                courseNumberTextField = new RoundJTextField(20);
                courseNumberTextField.setBounds(210, 110, 150, 25);
                newPanel.add(courseNumberTextField);

                topicNameLabel = new JLabel("Topic Name: ");
                topicNameLabel.setBounds(80, 140, 100, 25);
                newPanel.add(topicNameLabel);

                topicNameTextField = new RoundJTextField(20);
                topicNameTextField.setBounds(210, 140, 150, 25);
                newPanel.add(topicNameTextField);

                confirmAddButton = new RoundButton("ADD TOPIC");
                confirmAddButton.addActionListener(new ButtonHandler());
                confirmAddButton.setBounds(110, 190, 100, 25);
                newPanel.add( confirmAddButton);

                clearButton = new RoundButton("CLEAR");
                clearButton.setBounds(240, 190, 100, 25);
                newPanel.add(clearButton);

                Image Icon = Toolkit.getDefaultToolkit().getImage("picture/classroomPicture.png");
                newFrame.setIconImage(Icon);

                confirmAddButton.addActionListener(new ActionListener() {

                    /**
                     * Handles the action event when the "ADD TOPIC" button is clicked. This method creates
                     * a new topic panel with the entered details, adds it to the main GUI, and updates related data structures.
                     * @param e An ActionEvent representing the button click event.
                     */
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Reset the vertical position for materials within the new topic panel
                        yOfMaterial = 10;

                        // Close the previous frame
                        newFrame.dispose();

                        // Create a new panel for the topic and set its properties
                        topicPanel = new JPanel();
                        Color lightBlue = new Color(202, 240, 248);
                        topicPanel.setBackground(lightBlue);
                        topicPanel.setLayout(null);
                        topicPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
                        topicPanel.setBounds(90, y, 650, 80);

                        // Increment the vertical position for the next topic panel
                        y += 90;

                        // Create a new topic based on user input
                        topicDetails newTopic = new topicDetails(courseNameTextField.getText(),
                                courseNumberTextField.getText(),
                                topicNameTextField.getText());

                        // Add the new topic to the mainLinkedList
                        mainLinkedList.add(newTopic);

                        // Add the new topic's name to the topic dropdown for others
                        topicDropForOthers.addItem(newTopic.getTopicName());

                        // Add the new topic's name to the list of material names
                        materialNamesList.add(newTopic.getTopicName());

                        // Update the main list and sublist dropdowns
                        mainListSubListDropdowns();

                        // Create labels for the course name, course number, and topic name
                        courseNameLabel = new JLabel("Course Name: " + courseNameTextField.getText());
                        courseNameLabel.setBounds(10, -5, 150, 50);

                        courseNumberLabel = new JLabel("Course Number: " + courseNumberTextField.getText());
                        courseNumberLabel.setBounds(10, 15, 150, 50);

                        topicNameLabel = new JLabel("Topic Name: " + topicNameTextField.getText());
                        topicNameLabel.setBounds(10, 35, 150, 50);

                        // Add the labels to the new topic panel
                        topicPanel.add(courseNameLabel);
                        topicPanel.add(courseNumberLabel);
                        topicPanel.add(topicNameLabel);

                        // Add the new topic panel to the list of topic panels
                        topicPanels.add(topicPanel);

                        // Add the new topic panel to the main panel and refresh the GUI
                        mainPanel.add(topicPanel);
                        mainPanel.revalidate();
                        mainPanel.repaint();


                    } // end of actionPerformed method for add topic
                });

            } else if (e.getSource() == deleteButton) {
                deleteFrame = new JFrame("SLU Classroom");
                deletePanel = new JPanel();
                deletePanel.setLayout(null);
                deleteFrame.setVisible(true);

                Image Icon = Toolkit.getDefaultToolkit().getImage("picture/classroomPicture.png");
                deleteFrame.setIconImage(Icon);

                Color yellow = new Color(255, 242, 178);
                deletePanel.setBackground(yellow);

                deleteFrame.setResizable(false);
                deleteFrame.setVisible(true);
                deleteFrame.setSize(450, 300);
                deleteFrame.add(deletePanel);
                deleteFrame.setLocationRelativeTo(null);

                JLabel addTitle = new JLabel("Delete a chosen topic");
                addTitle.setBounds(110, 20, 400, 30);
                addTitle.setFont(new Font("Comic Sans", Font.BOLD, 20));
                deletePanel.add(addTitle);

                tDropdown();
                topicDropForOthers.setBounds(160, 70, 120, 25);
                deletePanel.add(topicDropForOthers);


                confirmDeleteButton = new RoundButton("DELETE");
                confirmDeleteButton.setBounds(160, 210, 100, 25);
                deletePanel.add(confirmDeleteButton);
                confirmDeleteButton.addActionListener(new ActionListener() {

                    /**
                     * Handles the action event when the "DELETE" button is clicked for topics.
                     * This method allows the user to delete a selected topic and updates the GUI accordingly.
                     * @param e An ActionEvent representing the button click event.
                     */
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Object selectedTopicItem = topicDropForOthers.getSelectedItem();
                        if (selectedTopicItem != null) {
                            String selectedTopicValue = selectedTopicItem.toString();

                            // Locate the selected topic in the mainLinkedList
                            topicDetails topicToDelete = null;
                            for (topicDetails topic : mainLinkedList) {
                                if (topic.getTopicName().equals(selectedTopicValue)) {
                                    topicToDelete = topic;
                                    break;
                                }
                            }

                            // Validate if the matching topic is found
                            if (topicToDelete != null) {
                                // Remove the topic from the mainLinkedList
                                mainLinkedList.remove(topicToDelete);

                                // Remove the selected item from topicDropForOthers
                                topicDropForOthers.removeItem(selectedTopicItem);
                            }
                        }
                        // Find the corresponding topic panel in the list
                        JPanel panelToRemove = null;
                        for (JPanel topicPanel : topicPanels) {
                            String selectedTopicValue = selectedTopicItem.toString();
                            // Extract the topic name label from the panel and adjust the index as needed
                            JLabel topicNameLabel = (JLabel) topicPanel.getComponent(2);
                            if (topicNameLabel != null && topicNameLabel.getText().endsWith(selectedTopicValue)) {
                                panelToRemove = topicPanel;
                                break;
                            }
                        }
                        if (panelToRemove != null) {
                            // Remove the panel from the list and mainPanel
                            topicPanels.remove(panelToRemove);
                            mainPanel.remove(panelToRemove);

                            // Refresh the GUI
                            mainPanel.revalidate();
                            mainPanel.repaint();
                        } else {
                            JOptionPane.showMessageDialog(null, "Please select a valid topic.");
                        }
                    } // end of actionPerformed method for delete topic
                });
            } else if (e.getSource() == updateButton) {
                updateFrame = new JFrame("SLU Classroom");
                updatePanel = new JPanel();
                updatePanel.setLayout(null);
                updateFrame.setVisible(true);

                Image Icon = Toolkit.getDefaultToolkit().getImage("picture/classroomPicture.png");
                updateFrame.setIconImage(Icon);

                Color yellow = new Color(255, 242, 178);
                updatePanel.setBackground(yellow);

                updateFrame.setResizable(false);
                updateFrame.setVisible(true);
                updateFrame.setSize(450, 350);
                updateFrame.add(updatePanel);
                updateFrame.setLocationRelativeTo(null);

                JLabel addTitle = new JLabel("Rename a chosen topic");
                addTitle.setBounds(110, 20, 400, 30);
                addTitle.setFont(new Font("Comic Sans", Font.BOLD, 20));
                updatePanel.add(addTitle);

                confirmUpdateButton = new RoundButton("RENAME");
                confirmUpdateButton.setBounds(180, 250, 100, 25);
                updatePanel.add(confirmUpdateButton);

                updateLabel = new JLabel("Rename: ");
                updateLabel.setBounds(120, 200, 100, 25);
                updatePanel.add(updateLabel);

                updateTextField = new RoundJTextField(20);
                updateTextField.setBounds(180, 200, 150, 25);
                updatePanel.add(updateTextField);

                tDropdown();
                topicDropForOthers.setBounds(160, 70, 120, 25);
                updatePanel.add(topicDropForOthers);

                confirmUpdateButton.addActionListener(new ActionListener() {
                    /**
                     * Handles the action event when the "RENAME" button is clicked for topics.
                     * This method allows the user to rename a selected topic and updates the GUI accordingly.
                     * @param e An ActionEvent representing the button click event.
                     */
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        Object selectedTopicItem = topicDropForOthers.getSelectedItem();
                        if (selectedTopicItem != null) {
                            String selectedTopicValue = selectedTopicItem.toString();

                            // Prompt the user for the new topic name using a dialog or input box
                            String newTopicName = updateTextField.getText();

                            if (newTopicName != null && !newTopicName.isEmpty()) {
                                // Locate the selected topic in the mainLinkedList
                                topicDetails selectedTopic = null;
                                for (topicDetails topic : mainLinkedList) {
                                    if (topic.getTopicName().equals(selectedTopicValue)) {
                                        selectedTopic = topic;
                                        break;
                                    }
                                }

                                // Update the selected topic's name in mainLinkedList
                                if (selectedTopic != null) {
                                    selectedTopic.setTopicName(newTopicName);
                                    System.out.println("Topic renamed successfully.");

                                    // Update the text of the corresponding JLabel in the GUI
                                    for (JPanel topicPanel : topicPanels) {
                                        JLabel topicNameLabel = (JLabel) topicPanel.getComponent(2);
                                        if (topicNameLabel != null && topicNameLabel.getText().endsWith(selectedTopicValue)) {
                                            topicNameLabel.setText("Topic Name: " + newTopicName);
                                            break;
                                        }
                                    }

                                    // Update the topicDropForOthers JComboBox
                                    topicDropForOthers.removeItem(selectedTopicValue);
                                    topicDropForOthers.addItem(newTopicName);
                                } else {
                                    JOptionPane.showMessageDialog(null, "Selected material not found in the topic");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "You didn't enter anything. Please provide valid input.");
                            }
                        }
                    } // end of actionPerformed method for rename topic
                });

            }   else if (e.getSource() == addMaterialButton) {
                materialFrame = new JFrame("SLU Classroom");
                materialPanel = new JPanel();
                materialPanel.setLayout(null);
                materialFrame.setVisible(true);

                Image Icon = Toolkit.getDefaultToolkit().getImage("picture/classroomPicture.png");
                materialFrame.setIconImage(Icon);

                Color yellow = new Color(255, 242, 178);
                materialPanel.setBackground(yellow);

                materialFrame.setResizable(false);
                materialFrame.setVisible(true);
                materialFrame.setSize(450, 350);
                materialFrame.add(materialPanel);
                materialFrame.setLocationRelativeTo(null);

                JLabel addTitle = new JLabel("Input the material");
                addTitle.setBounds(130, 20, 400, 30);
                addTitle.setFont(new Font("Comic Sans", Font.BOLD, 20));
                materialPanel.add(addTitle);

                materialNameLabel = new JLabel("Material:");
                materialNameLabel.setBounds(120, 200, 100, 25);
                materialPanel.add(materialNameLabel);

                materialTextField = new RoundJTextField(20);
                materialTextField.setBounds(180, 200, 150, 25);
                materialPanel.add(materialTextField);

                confirmAddMaterial = new RoundButton("ADD MATERIAL");
                confirmAddMaterial.addActionListener(new ButtonHandler());
                confirmAddMaterial.setBounds(160, 250, 120, 25);
                materialPanel.add(confirmAddMaterial);

                tDropdown();
                topicDropForOthers.setBounds(160, 70, 120, 25);
                materialPanel.add(topicDropForOthers);

                confirmAddMaterial.addActionListener(new ActionListener() {

                    /**
                     * Handles the action event when the "ADD MATERIAL" button is clicked.
                     * This method adds a new material to a selected topic and updates the GUI accordingly.
                     * @param e An ActionEvent representing the button click event.
                     */
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Close the previous frame
                        materialFrame.dispose();

                        // Get the selected topic from the mainLinkedList based on the dropdown selection
                        int selectedTopicIndex = topicDropForOthers.getSelectedIndex();

                        // Check if a topic is selected (index > 0) and if the index is valid
                        if (selectedTopicIndex > 0 && selectedTopicIndex <= mainLinkedList.size()) {
                            // Adjust the index to match the list's index (subtract 1)
                            selectedTopicIndex--;

                            // Get the selected topic from the mainLinkedList
                            topicDetails selectedTopic = mainLinkedList.get(selectedTopicIndex);

                            // Add the material to the selected topic's subLinkedList
                            String materialToAdd = materialTextField.getText();
                            selectedTopic.getSubLinkedList().add(materialToAdd);

                            // Update the sublinked list dropdown with materials from the selected topic
                            updateSubListDropdown(selectedTopic.getSubLinkedList());

                            // Create a small text box with the label of the inputted material
                            createAndAddMaterialPanel(materialToAdd, selectedTopic);

                        } else {
                            // Handle the case when no topic is selected or an invalid index is selected
                            JOptionPane.showMessageDialog(null, "Please select a valid topic.");
                        }
                    }
                }); // end of actionPerformed method for add material

            } else if (e.getSource() == removeMaterialButton) {
                deleteMaterialFrame = new JFrame("SLU Classroom");
                deleteMaterialPanel = new JPanel();
                deleteMaterialPanel.setLayout(null);
                deleteMaterialFrame.setVisible(true);

                Image Icon = Toolkit.getDefaultToolkit().getImage("picture/classroomPicture.png");
                deleteMaterialFrame.setIconImage(Icon);

                Color yellow = new Color(255, 242, 178);
                deleteMaterialPanel.setBackground(yellow);

                deleteMaterialFrame.setResizable(false);
                deleteMaterialFrame.setVisible(true);
                deleteMaterialFrame.setSize(450, 300);
                deleteMaterialFrame.add(deleteMaterialPanel);
                deleteMaterialFrame.setLocationRelativeTo(null);

                JLabel addTitle = new JLabel("Delete a chosen material");
                addTitle.setBounds(110, 20, 400, 30);
                addTitle.setFont(new Font("Comic Sans", Font.BOLD, 20));
                deleteMaterialPanel.add(addTitle);

                tDropdown();
                topicDropForOthers.setBounds(160, 70, 120, 25);
                deleteMaterialPanel.add(topicDropForOthers);

                mDropdown();
                materialDropdown.setBounds(160, 100, 120, 25);
                deleteMaterialPanel.add(materialDropdown);

                confirmDeleteMaterialButton = new RoundButton("DELETE");
                confirmDeleteMaterialButton.setBounds(160, 210, 100, 25);
                deleteMaterialPanel.add(confirmDeleteMaterialButton);

                confirmDeleteMaterialButton.addActionListener(new ActionListener() {
                    /**
                     * Handles the action event when the "DELETE MATERIAL" button is clicked.
                     * This method deletes a material from a selected topic and updates the GUI accordingly.
                     * @param e An ActionEvent representing the button click event.
                     */
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Get the selected topic from the mainLinkedList based on the dropdown selection
                        int selectedTopicIndex = topicDropForOthers.getSelectedIndex();

                        // Check if a topic is selected (index > 0) and if the index is valid
                        if (selectedTopicIndex > 0 && selectedTopicIndex <= mainLinkedList.size()) {
                            // Adjust the index to match the list's index (subtract 1)
                            selectedTopicIndex--;

                            // Get the selected topic from the mainLinkedList
                            topicDetails selectedTopic = mainLinkedList.get(selectedTopicIndex);

                            // Get the selected material from the sublinked list dropdown
                            String selectedMaterial = (String) materialDropdown.getSelectedItem();

                            // Check if a material is selected (index > 0) and if it exists in the sublinked list
                            if (selectedMaterial != null && !selectedMaterial.equals("Select Material") &&
                                    selectedTopic.getSubLinkedList().contains(selectedMaterial)) {
                                // Remove the selected material from the sublinked list
                                selectedTopic.getSubLinkedList().remove(selectedMaterial);

                                // Update the sublinked list dropdown with materials from the selected topic
                                updateSubListDropdown(selectedTopic.getSubLinkedList());

                                // Remove the material box from the selected topic's panel
                                removeMaterialPanel(selectedTopic, selectedMaterial);
                            } else {
                                // Handle the case when no material is selected or the selected material doesn't exist
                                JOptionPane.showMessageDialog(null, "Please select a valid material to delete.");
                            }
                        } else {
                            // Handle the case when no topic is selected or an invalid index is selected
                            JOptionPane.showMessageDialog(null, "Please select a valid topic.");
                        }
                    }
                }); // end of actionPerformed method for delete material

            } else if (e.getSource() == updateMaterialButton) {
                updateMaterialFrame = new JFrame("SLU Classroom");
                updateMaterialPanel = new JPanel();
                updateMaterialPanel.setLayout(null);
                updateMaterialFrame.setVisible(true);

                Image Icon = Toolkit.getDefaultToolkit().getImage("picture/classroomPicture.png");
                updateMaterialFrame.setIconImage(Icon);

                Color yellow = new Color(255, 242, 178);
                updateMaterialPanel.setBackground(yellow);

                updateMaterialFrame.setResizable(false);
                updateMaterialFrame.setVisible(true);
                updateMaterialFrame.setSize(450, 350);
                updateMaterialFrame.add(updateMaterialPanel);
                updateMaterialFrame.setLocationRelativeTo(null);

                JLabel addTitle = new JLabel("Rename a chosen material");
                addTitle.setBounds(110, 20, 400, 30);
                addTitle.setFont(new Font("Comic Sans", Font.BOLD, 20));
                updateMaterialPanel.add(addTitle);

                confirmUpdateMaterialButton = new RoundButton("RENAME");
                confirmUpdateMaterialButton.setBounds(180, 250, 100, 25);
                updateMaterialPanel.add(confirmUpdateMaterialButton);

                updateMaterialLabel = new JLabel("Rename: ");
                updateMaterialLabel.setBounds(120, 200, 100, 25);
                updateMaterialPanel.add(updateMaterialLabel);

                updateMaterialTextField = new RoundJTextField(20);
                updateMaterialTextField.setBounds(180, 200, 150, 25);
                updateMaterialPanel.add(updateMaterialTextField);

                tDropdown();
                topicDropForOthers.setBounds(160, 70, 120, 25);
                updateMaterialPanel.add(topicDropForOthers);

                mDropdown();
                materialDropdown.setBounds(160, 100, 120, 25);
                updateMaterialPanel.add(materialDropdown);

                confirmUpdateMaterialButton.addActionListener(new ActionListener() {
                    /**
                     * Handles the action event when the "UPDATE MATERIAL" button is clicked.
                     * This method deletes a material from a selected topic and updates the GUI accordingly.
                     * @param e An ActionEvent representing the button click event.
                     */
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Get the selected topic from the mainLinkedList based on the dropdown selection
                        int selectedTopicIndex = topicDropForOthers.getSelectedIndex();

                        // Check if a topic is selected (index > 0) and if the index is valid
                        if (selectedTopicIndex > 0 && selectedTopicIndex <= mainLinkedList.size()) {
                            // Adjust the index to match the list's index (subtract 1)
                            selectedTopicIndex--;

                            // Get the selected topic from the mainLinkedList
                            topicDetails selectedTopic = mainLinkedList.get(selectedTopicIndex);

                            // Get the selected material from the material dropdown
                            String selectedMaterial = materialDropdown.getSelectedItem().toString();

                            // Get the new material name from the text field
                            String newMaterialName = updateMaterialTextField.getText();

                            // Find and update the material name in the selected topic's subLinkedList
                            if (selectedTopic.getSubLinkedList().contains(selectedMaterial)) {
                                int materialIndex = selectedTopic.getSubLinkedList().indexOf(selectedMaterial);
                                selectedTopic.getSubLinkedList().set(materialIndex, newMaterialName);

                                // Update the sublinked list dropdown with materials from the selected topic
                                updateSubListDropdown(selectedTopic.getSubLinkedList());

                                // Find the corresponding material box panel and update its label
                                updateMaterialPanelLabel(selectedTopic, selectedMaterial, newMaterialName);
                            } else {
                                // Handle the case when the selected material is not found
                                JOptionPane.showMessageDialog(null, "Selected material not found in the topic.");
                            }
                        } else {
                            // Handle the case when no topic is selected or an invalid index is selected
                            JOptionPane.showMessageDialog(null, "Please select a valid topic.");
                        }
                    }
                }); // end of actionPerformed method for update material
            }
        }
    } // end of ButtonHandler method

    /**
     * The updateSubListDropdown method updates a JComboBox with a list of materials.
     * It clears the existing items in the JComboBox, adds a default item, and then
     * adds the materials provided in the argument to the JComboBox.
     * @param materials A LinkedList of materials to populate the JComboBox with.
     */
    private void updateSubListDropdown(LinkedList<String> materials) {
        // Clear the current items in the JComboBox
        materialDropdown.removeAllItems();

        // Add "Select Material" as the default item
        materialDropdown.addItem("Select Material");

        // Populate the material dropdown with materials from the provided list
        for (String material : materials) {
            materialDropdown.addItem(material);
        }
    } // end of updateSubListDropdown method

    /**
     * The mainListSubListDropdowns method updates JComboBoxes with data from main and sublists.
     * It clears and populates the topicDropdown and materialDropdown based on the selected topic
     * from the mainLinkedList and also updates the addMaterialDropdown with materials from materialNamesList.
     */
    private void mainListSubListDropdowns() {
        //Update topic dropdown
        topicDropdown.removeAllItems();
        topicDropdown.addItem("Select Topic");

        // Populate topic dropdown with topics from mainLinkedList
        for (topicDetails topic : mainLinkedList) {
            topicDropdown.addItem(topic.getTopicName());
        }

        // Check if a topic is selected
        if (topicDropdown.getSelectedIndex() > 0) {
            int selectedTopicIndex = topicDropdown.getSelectedIndex() - 1;

            // Ensure the selectedTopicIndex is within bounds
            if (selectedTopicIndex >= 0 && selectedTopicIndex < mainLinkedList.size()) {
                topicDetails selectedTopic = mainLinkedList.get(selectedTopicIndex);

                // Clear and populate the material dropdown with materials from the selected topic
                materialDropdown.removeAllItems();
                materialDropdown.addItem("Select Material");

                //Populate the material dropdown with materials from the selected topic
                for (String material : selectedTopic.getMaterials()) {
                    materialDropdown.addItem(material);
                }
            }
        } else {
            // Clear material dropdown if no topic is selected
            materialDropdown.removeAllItems();
            materialDropdown.addItem("Select Material");
        }

        // Clear and populate the addMaterialDropdown with materials from materialNamesList
        addMaterialDropdown.removeAllItems();
        addMaterialDropdown.removeAllItems();
        addMaterialDropdown.addItem("Select Material");
        for (String materialName : materialNamesList) {
            addMaterialDropdown.addItem(materialName);
        }
    } // end of mainListSubListDropdowns method

    /**
     * The mDropdown method populates a JComboBox with a list of materials based on the selected topic.
     * It clears the existing items in the JComboBox, adds a default item, and then adds materials from
     * the selected topic's subLinkedList to the JComboBox.
     */
    private void mDropdown() {
        // Clear the current items in the JComboBox
        materialDropdown.removeAllItems();

        // Add "Select Material" as the default item
        materialDropdown.addItem("Select Material");

        // Check if a topic is selected
        if (topicDropForOthers.getSelectedIndex() > 0) {
            // Get the selected topic (You need to define the selectedTopic variable)
            topicDetails selectedTopic = mainLinkedList.get(topicDropForOthers.getSelectedIndex() - 1);

            // Add materials from the selected topic's subLinkedList to the dropdown
            for (String material : selectedTopic.getSubLinkedList()) {
                materialDropdown.addItem(material);
            }
        }
    } // end of mDropdown method

    /**
     * The tDropdown method populates a JComboBox with a list of topics from a linked list.
     * It clears the existing items in the JComboBox, adds a default item, and then adds
     * each topic from the linked list to the JComboBox.
     */
    private void tDropdown() {
        //Clear the current items in the JComboBox
        topicDropForOthers.removeAllItems();

        //Add an empty or default item first
        topicDropForOthers.addItem("Select Topic");

        //Iterate through the linked list and add each topic to the JComboBox
        for (topicDetails topic : mainLinkedList) {
            topicDropForOthers.addItem(topic.getTopicName());
        }
    } // end of tDropdown method

    /**
     * Creates and adds a panel representing a material with
     * its label to the corresponding topic panel.
     *
     * @param materialToAdd The name of the material to be added.
     * @param selectedTopic The selected topic to which the material belongs.
     */

    private void createAndAddMaterialPanel(String materialToAdd, topicDetails selectedTopic) {
        // Create a small text box with the label of the inputted material
        materialBoxPanel = new JPanel();
        Color lightBlue = new Color(162,214,249);
        materialBoxPanel.setBackground(lightBlue);
        materialBoxPanel.setLayout(null);
        materialBoxPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        materialBoxPanel.setBounds(xOfMaterial, yOfMaterial, 100, 20);

        materialNameLabel = new JLabel(materialToAdd);
        materialNameLabel.setBounds(5, 5, 80, 10);
        materialBoxPanel.add(materialNameLabel);

        yOfMaterial += 22;
        if (yOfMaterial >= 66) {
            xOfMaterial += 110;
            yOfMaterial -= 66;
        }

        // Find the corresponding topic panel in the list
        JPanel panelToUpdate = null;
        for (JPanel topicPanel : topicPanels) {
            JLabel topicNameLabel = (JLabel) topicPanel.getComponent(2);
            if (topicNameLabel != null && topicNameLabel.getText().endsWith(selectedTopic.getTopicName())) {
                panelToUpdate = topicPanel;
                break;
            }
        }

        // Add the materialBoxPanel to the found topic panel
        if (panelToUpdate != null) {
            panelToUpdate.add(materialBoxPanel);
            panelToUpdate.revalidate();
            panelToUpdate.repaint();
        }
    } // end of createAndAddMaterialPanel method

    /**
     * The removeMaterialBox method removes the material box
     * associated with a specified material name from a topic panel.
     * */

    private void removeMaterialPanel(topicDetails selectedTopic, String materialName) {
        // Find the corresponding topic panel in the list
        JPanel panelToUpdate = null;
        for (JPanel topicPanel : topicPanels) {
            JLabel topicNameLabel = (JLabel) topicPanel.getComponent(2);
            if (topicNameLabel != null && topicNameLabel.getText().endsWith(selectedTopic.getTopicName())) {
                panelToUpdate = topicPanel;
                break;
            }
        }

        // Find and remove the material box from the topic panel
        if (panelToUpdate != null) {
            Component[] components = panelToUpdate.getComponents();
            for (Component component : components) {
                if (component instanceof JPanel) {
                    JPanel materialBoxPanel = (JPanel) component;
                    JLabel materialNameLabel = (JLabel) materialBoxPanel.getComponent(0);
                    if (materialNameLabel != null && materialNameLabel.getText().equals(materialName)) {
                        panelToUpdate.remove(materialBoxPanel);
                        panelToUpdate.revalidate();
                        panelToUpdate.repaint();
                        break;
                    }
                }
            }
        }
    } // end of removeMaterialPanel method

    /**
     * Updates the label of a material box within a topic panel.
     * @param selectedTopic  The selected topic containing the material box to be updated.
     * @param oldMaterialName The current name of the material to be updated.
     * @param newMaterialName The new name to set for the material.
     */
    private void updateMaterialPanelLabel(topicDetails selectedTopic, String oldMaterialName, String newMaterialName) {
        // Find the corresponding topic panel in the list
        JPanel panelToUpdate = null;
        for (JPanel topicPanel : topicPanels) {
            JLabel topicNameLabel = (JLabel) topicPanel.getComponent(2);
            if (topicNameLabel != null && topicNameLabel.getText().endsWith(selectedTopic.getTopicName())) {
                panelToUpdate = topicPanel;
                break;
            }
        }
        // Find and update the material box label in the topic panel
        if (panelToUpdate != null) {
            Component[] components = panelToUpdate.getComponents();
            for (Component component : components) {
                if (component instanceof JPanel) {
                    JPanel materialBoxPanel = (JPanel) component;
                    JLabel materialNameLabel = (JLabel) materialBoxPanel.getComponent(0);
                    if (materialNameLabel != null && materialNameLabel.getText().equals(oldMaterialName)) {
                        materialNameLabel.setText(newMaterialName);
                        panelToUpdate.revalidate();
                        panelToUpdate.repaint();
                        break;
                    }
                }
            }
        }
    } // end of updateMaterialPanelLabel method

    /**
     * The main method is the entry point for the Classroom application.
     * It creates and initializes the graphical user interface.
     */
    public static void main(String[] args) {
        // Execute the GUI initialization on the event dispatch thread
        SwingUtilities.invokeLater(() -> {
            Classroom gui = new Classroom(); // Create an instance of the Classroom GUI
        });
    } // end of main method

    /**
     * The RoundJTextField class represents a custom JTextField with a rectangular text field.
     * Rectangle Text Field
     */
    class RoundJTextField extends JTextField {
        public RoundJTextField(int size) {
            super(size);
            setOpaque(false);
        }

        protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
            super.paintComponent(g);
        }

        protected void paintBorder(Graphics g) {
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
        }
    } // end of the RoundJTextField method

    /**
     * Constructs a new RoundButton with the specified label.
     * Round Buttons
     */
    class RoundButton extends JButton {

        /**
         * Constructs a new RoundButton with the specified label.
         * @param label The label text displayed on the button.
         */
        public RoundButton(String label) {
            super(label);
            setContentAreaFilled(false);
            setFocusPainted(false); //Used for focus border painting
            setBorderPainted(false);
            setOpaque(false);
        }

        /**
         * Paints the background of the round button.
         * @param g The Graphics object used for painting.
         */
        protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // The last two arguments determine the roundness
            super.paintComponent(g);
        }

        /**
         * Paints the border of the round button.
         * @param g The Graphics object used for painting.
         */
        protected void paintBorder(Graphics g) {
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        }

        /**
         * Checks if a point (x, y) is within the boundaries of the round button.
         * Hit detection for round buttons
         * @return true if the point is within the button's shape, false otherwise.
         */
        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())){
                shape = new java.awt.geom.RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
            }
            return shape.contains(x, y);
        }
        private Shape shape;
    } // end of RoundButton class

}
