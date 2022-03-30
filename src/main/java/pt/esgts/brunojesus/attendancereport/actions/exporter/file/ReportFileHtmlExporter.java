package pt.esgts.brunojesus.attendancereport.actions.exporter.file;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import pt.esgts.brunojesus.attendancereport.actions.Report;

/**
 * Exports the provided {@link Report} to HTML and saves it in the filesystem
 *
 * @author Bruno Jesus
 * @version 1.0
 * @since 2022-03-30
 */
public class ReportFileHtmlExporter implements ReportFileExporter {

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(Report report, String targetFileName) {
        try {
            JasperExportManager.exportReportToHtmlFile(
                    report.getCompiledReport(),
                    targetFileName
            );
        } catch (JRException e) {
            throw new RuntimeException("Error exporting report", e);
        }
    }
}
