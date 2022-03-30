package pt.esgts.brunojesus.attendancereport.actions.exporter.array;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import pt.esgts.brunojesus.attendancereport.actions.Report;

/**
 * Exports the provided {@link Report} to PDF
 * <br>
 * The output is byte[] that can be saved as a PDF file
 *
 * @author Bruno Jesus
 * @version 1.0
 * @since 2022-03-30
 */
public class ReportArrayPdfExporter implements ReportArrayExporter {

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] apply(Report report) {
        try {
            return JasperExportManager.exportReportToPdf(report.getCompiledReport());
        } catch (JRException e) {
            throw new RuntimeException("Error exporting report", e);
        }
    }
}
