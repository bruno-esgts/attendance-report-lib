package pt.esgts.brunojesus.attendancereport.actions.exporter.file;

import pt.esgts.brunojesus.attendancereport.actions.Report;

import java.util.function.BiConsumer;

/**
 * Interface defining a {@link Report} exporter
 * <br>
 * The exported result is saved as a file in the machine's filesystem, path is specified as a string
 *
 * @author Bruno Jesus
 * @version 1.0
 * @since 2022-03-30
 */
public interface ReportFileExporter extends BiConsumer<Report, String> {

    /**
     * Exports the {@link Report} to a file in the machine's filesystem
     *
     * @param report         the Report to export
     * @param targetFileName the path for the destination file
     */
    @Override
    void accept(Report report, String targetFileName);
}
