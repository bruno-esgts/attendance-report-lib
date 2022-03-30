package pt.esgts.brunojesus.attendancereport.actions;

import net.sf.jasperreports.engine.JasperPrint;
import pt.esgts.brunojesus.attendancereport.actions.exporter.array.ReportArrayExporter;
import pt.esgts.brunojesus.attendancereport.actions.exporter.file.ReportFileExporter;

import java.util.function.Consumer;

/**
 * The compiled report
 * <br>
 * Wraps a {@link JasperPrint} report
 *
 * @author Bruno Jesus
 * @version 1.0
 * @since 2022-03-30
 */
public class Report {

    private final JasperPrint compiledReport;

    public Report(JasperPrint compiledReport) {
        this.compiledReport = compiledReport;
    }

    public JasperPrint getCompiledReport() {
        return compiledReport;
    }

    /**
     * Accepts and executes a {@link ReportFileExporter} in order to export to a file
     *
     * @param reportFileExporter The exporter object
     * @param filename           The save path
     */
    public void accept(ReportFileExporter reportFileExporter, String filename) {
        reportFileExporter.accept(this, filename);
    }

    /**
     * Accepts and executes a {@link ReportArrayExporter} in order to export as a byte[]
     *
     * @param reportArrayExporter The exporter object
     * @return The byte array
     */
    public byte[] apply(ReportArrayExporter reportArrayExporter) {
        return reportArrayExporter.apply(this);
    }

    /**
     * Accepts and executes a {@link Consumer<Report>}
     *
     * @param consumer The consumer to execute
     */
    public void accept(Consumer<Report> consumer) {
        consumer.accept(this);
    }
}
