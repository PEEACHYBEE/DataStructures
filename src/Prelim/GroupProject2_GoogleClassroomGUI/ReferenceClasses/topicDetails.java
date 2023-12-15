package Prelim.GroupProject2_GoogleClassroomGUI.ReferenceClasses;

import java.util.LinkedList;
/**
 * The `topicDetails` class represents details about a specific topic within a course.
 * It stores information about the course name, course number, topic name, and related materials.
 */
public class topicDetails {
    private String courseName;
    private String courseNumber;
    private String topicName;
    private java.util.LinkedList<String> subLinkedList; // A subLinkedList for materials
    private java.util.LinkedList<String> materials;

    /**
     * Constructs an instance of the `topicDetails` class with an empty list of materials.
     */

    public topicDetails() {
        this.subLinkedList = new java.util.LinkedList<>();
    }

    /**
     * Constructs an instance of the `topicDetails` class with the specified course name, course number, and topic name.
     *
     * @param courseName   The name of the course.
     * @param courseNumber The course number.
     * @param topicName    The name of the topic.
     */

    public topicDetails(String courseName, String courseNumber, String topicName) {
        this.courseName = courseName;
        this.courseNumber = courseNumber;
        this.topicName = topicName;
        this.subLinkedList = new java.util.LinkedList<>();
        this.materials = new java.util.LinkedList<>();
    }

    /**
     * Gets the list of materials associated with this topic.
     *
     * @return A linked list of material names.
     */

    public java.util.LinkedList<String> getMaterials() {
        return materials;
    }

    /**
     * Gets the sub-linked list of materials associated with this topic.
     *
     * @return A linked list of sub-material names.
     */

    public LinkedList<String> getSubLinkedList() {
        return subLinkedList;
    }

    /**
     * Adds a material to the sub-linked list of materials associated with this topic.
     *
     * @param materialName The name of the material to add.
     */

    public void addMaterial(String materialName) {
        subLinkedList.add(materialName);
    }

    /**
     * Gets the name of the course.
     *
     * @return The course name.
     */

    public String getCourseName() {
        return courseName;
    }

    /**
     * Gets the course number.
     *
     * @return The course number.
     */

    public String getCourseNumber() {
        return courseNumber;
    }

    /**
     * Gets the name of the topic.
     *
     * @return The topic name.
     */

    public String getTopicName() {
        return topicName;
    }

    /**
     * Sets the name of the course.
     *
     * @param courseName The course name to set.
     */

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * Sets the course number.
     *
     * @param courseNumber The course number to set.
     */

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    /**
     * Sets the name of the topic.
     *
     * @param topicName The topic name to set.
     */

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    /**
     * Returns a string representation of the topic details.
     *
     * @return A string containing the course name, course number, and topic name.
     */

    @Override
    public String toString() {
        return courseName + courseNumber + topicName;
    }
}
