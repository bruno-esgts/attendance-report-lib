package pt.esgts.brunojesus.attendancereport.model;

import pt.esgts.brunojesus.attendancereport.actions.Report;

/**
 * The Attendance to be displayed in the {@link Report}
 *
 * @author Bruno Jesus
 * @version 1.0
 * @since 2022-03-30
 */
public class Attendance {

    private long number;
    private String name;
    private boolean present;

    public Attendance() {
    }

    /**
     * The person's number
     *
     * @return the person's number
     */
    public long getNumber() {
        return number;
    }

    /**
     * Set the person's number
     *
     * @param number the new person's number
     * @return the current object
     */
    public Attendance setNumber(long number) {
        this.number = number;
        return this;
    }

    /**
     * The person's name
     *
     * @return the person's name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the person's name
     *
     * @param name the new person's name
     * @return the current object
     */
    public Attendance setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Is this person present
     *
     * @return true if person is present
     */
    public boolean isPresent() {
        return present;
    }

    /**
     * Set person's present status
     *
     * @param present true if present, false if absent
     * @return the current object
     */
    public Attendance setPresent(boolean present) {
        this.present = present;
        return this;
    }
}
