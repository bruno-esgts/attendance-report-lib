package pt.esgts.brunojesus.attendancereport.model;

import pt.esgts.brunojesus.attendancereport.actions.Report;

import java.time.LocalDate;
import java.util.List;

/**
 * The data to be used to fill the {@link Report}
 *
 * @author Bruno Jesus
 * @version 1.0
 * @since 2022-03-30
 */
public class ReportData {

    private List<Attendance> attendances;
    private String courseName;
    private String className;
    private int academicYear;
    private LocalDate date;

    /**
     * Creates a new and empty ReportData
     */
    public ReportData() {
    }

    /**
     * Creates a new ReportData
     *
     * @param attendances  the attendance list
     * @param courseName   the name of the course
     * @param className    the name of the class
     * @param academicYear the academic year
     * @param date         the date of the class
     */
    public ReportData(List<Attendance> attendances, String courseName, String className, int academicYear, LocalDate date) {
        this.attendances = attendances;
        this.courseName = courseName;
        this.className = className;
        this.academicYear = academicYear;
        this.date = date;
    }

    /**
     * List containing the attendances to fill in the report
     *
     * @return the attendance list
     */
    public List<Attendance> getAttendances() {
        return attendances;
    }

    /**
     * Set the attendance list
     *
     * @return the current object
     */
    public ReportData setAttendances(List<Attendance> attendances) {
        this.attendances = attendances;
        return this;
    }

    /**
     * The course name, is displayed in the report header
     *
     * @return a String with the name of the course
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * Set the course name that is displayed in the report header
     *
     * @param courseName the new course name
     * @return the current object
     */
    public ReportData setCourseName(String courseName) {
        this.courseName = courseName;
        return this;
    }

    /**
     * The class name, is displayed in the report header
     *
     * @return a String with the name of the class
     */
    public String getClassName() {
        return className;
    }

    /**
     * Set the class name that is displayed in the report header
     *
     * @param className the new class name
     * @return the current object
     */
    public ReportData setClassName(String className) {
        this.className = className;
        return this;
    }

    /**
     * The academic year, is displayed in the report header
     *
     * @return an int with the academic year
     */
    public int getAcademicYear() {
        return academicYear;
    }

    /**
     * Set the academic year that is displayed in the report header
     *
     * @param academicYear the new academic year to be displayed
     * @return the current object
     */
    public ReportData setAcademicYear(int academicYear) {
        this.academicYear = academicYear;
        return this;
    }

    /**
     * The date that is displayed in the report header
     *
     * @return the date to be displayed
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Set the date that is displayed in the report header
     *
     * @param date the new date to be displayed
     * @return the current object
     */
    public ReportData setDate(LocalDate date) {
        this.date = date;
        return this;
    }
}
