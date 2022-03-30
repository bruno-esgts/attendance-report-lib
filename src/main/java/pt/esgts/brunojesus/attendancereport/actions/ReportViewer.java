package pt.esgts.brunojesus.attendancereport.actions;

import net.sf.jasperreports.view.JasperViewer;

import java.util.function.Consumer;

/**
 * Opens a window displaying the provided {@link Report}
 *
 * @author Bruno Jesus
 * @version 1.0
 * @since 2022-03-30
 */
public class ReportViewer implements Consumer<Report> {

    /**
     * Open a window displaying the provided {@link Report}
     *
     * @param report the report to display
     */
    @Override
    public void accept(Report report) {
        JasperViewer.viewReport(report.getCompiledReport());
    }
}
