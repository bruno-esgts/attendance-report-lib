package pt.esgts.brunojesus.attendancereport.actions.exporter.file;

import pt.esgts.brunojesus.attendancereport.actions.exporter.array.ReportArrayExporter;
import pt.esgts.brunojesus.attendancereport.actions.exporter.array.ReportArrayXmlExporter;
import pt.esgts.brunojesus.attendancereport.actions.Report;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Exports the provided {@link Report} to XML and saves it in the filesystem.
 *
 * @author Bruno Jesus
 * @version 1.0
 * @since 2022-03-30
 */
public class ReportFileXmlExporter implements ReportFileExporter {

    private final ReportArrayExporter reportArrayExporter;

    public ReportFileXmlExporter() {
        reportArrayExporter = new ReportArrayXmlExporter();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void accept(Report report, String targetFileName) {
        try {
            Files.write(
                    Path.of(targetFileName),
                    reportArrayExporter.apply(report)
            );
        } catch (IOException e) {
            throw new RuntimeException("Error exporting XML report");
        }
    }
}
