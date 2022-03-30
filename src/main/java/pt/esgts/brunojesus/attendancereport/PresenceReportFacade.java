package pt.esgts.brunojesus.attendancereport;

import pt.esgts.brunojesus.attendancereport.actions.Report;
import pt.esgts.brunojesus.attendancereport.actions.ReportCompiler;
import pt.esgts.brunojesus.attendancereport.actions.ReportViewer;
import pt.esgts.brunojesus.attendancereport.actions.exporter.array.ReportArrayExporter;
import pt.esgts.brunojesus.attendancereport.actions.exporter.file.ReportFileExporter;
import pt.esgts.brunojesus.attendancereport.model.ReportData;

/**
 * API for {@link Report} compilation and exporting
 *
 * @author Bruno Jesus
 * @version 1.0
 * @since 2022-03-30
 */
public class PresenceReportFacade {

    /**
     * Compiles a {@link Report} with a provided {@link ReportData}
     *
     * @param reportData the data to put in the report
     * @return a compiled {@link Report}
     */
    public Report compileReport(ReportData reportData) {
        final ReportCompiler compiler = new ReportCompiler();
        return compiler.apply(reportData);
    }

    /**
     * Opens a window displaying the {@link Report}
     *
     * @param report the {@link Report} to be displayed
     */
    public void viewReport(Report report) {
        final ReportViewer reportViewer = new ReportViewer();
        report.accept(reportViewer);
    }

    /**
     * Exports the {@link Report} to a file in the computer's filesystem
     *
     * @param report      the {@link Report} to be exported
     * @param exporter    the {@link ReportFileExporter} that will take care of exporting the {@link Report}
     * @param destination the destination of the file in the computer's filesystem
     */
    public void exportToFile(Report report, ReportFileExporter exporter, String destination) {
        exporter.accept(report, destination);
    }

    /**
     * Exports the {@link Report} to a byte[] representing the contents of the file
     *
     * @param report   the {@link Report} to be exported
     * @param exporter the {@link ReportFileExporter} that will take care of exporting the {@link Report}
     * @return a byte[] with the file contents
     */
    public byte[] exportToByteArray(Report report, ReportArrayExporter exporter) {
        return exporter.apply(report);
    }
}
