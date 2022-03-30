package pt.esgts.brunojesus.attendancereport.actions.exporter.array;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import pt.esgts.brunojesus.attendancereport.actions.Report;

/**
 * Exports the provided {@link Report} to XML
 * <br>
 * The output is byte[] that can be saved as an XML file
 *
 * @author Bruno Jesus
 * @version 1.0
 * @since 2022-03-30
 */
public class ReportArrayXmlExporter implements ReportArrayExporter {

    /**
     * {@inheritDoc}
     */
    @Override
    public byte[] apply(Report report) {
        try {
            String xmlContent = JasperExportManager.exportReportToXml(report.getCompiledReport());
            return xmlContent.getBytes();
        } catch (JRException e) {
            throw new RuntimeException("Error exporting report", e);
        }
    }
}
