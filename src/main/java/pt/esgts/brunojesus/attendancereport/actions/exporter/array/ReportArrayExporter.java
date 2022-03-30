package pt.esgts.brunojesus.attendancereport.actions.exporter.array;

import pt.esgts.brunojesus.attendancereport.actions.Report;

import java.util.function.Function;

/**
 * Interface defining a {@link Report} exporter
 * <br>
 * The output should be a byte[] that may be written to a file
 *
 * @author Bruno Jesus
 * @version 1.0
 * @since 2022-03-30
 */
public interface ReportArrayExporter extends Function<Report, byte[]> {

    /**
     * Exports the report as a byte[]
     *
     * @param report the report to export
     * @return the report as a byte[], ready to be saved as a file
     */
    @Override
    byte[] apply(Report report);
}
