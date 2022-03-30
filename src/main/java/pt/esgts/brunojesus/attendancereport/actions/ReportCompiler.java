package pt.esgts.brunojesus.attendancereport.actions;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import pt.esgts.brunojesus.attendancereport.model.ReportData;

import java.io.InputStream;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Compiles and fills a report with the given {@link ReportData}
 *
 * @author Bruno Jesus
 * @version 1.0
 * @since 2022-03-30
 */
public class ReportCompiler implements Function<ReportData, Report> {

    /**
     * Compiles and fills a report with the given {@link ReportData}
     *
     * @param reportData the report data to include in the report
     * @return The compiled and filled {@link Report}
     */
    @Override
    public Report apply(ReportData reportData) {
        final JasperReport compiledReport = compile();
        final JasperPrint filledReport = fill(compiledReport, reportData);

        return new Report(filledReport);
    }

    private JasperReport compile() {
        InputStream is = getClass().getClassLoader().getResourceAsStream("presencas.jrxml");

        JasperReport jasperReport;

        try {
            JasperDesign jasperDesign = JRXmlLoader.load(is);
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
        } catch (JRException e) {
            throw new RuntimeException("Error compiling report", e);
        }

        return jasperReport;
    }

    private JasperPrint fill(JasperReport report, ReportData relatorioInput) {
        JasperPrint jasperPrint;
        try {
            jasperPrint = JasperFillManager.fillReport(
                    report,
                    buildParameters(relatorioInput),
                    new JREmptyDataSource()
            );
        } catch (JRException e) {
            throw new RuntimeException("Error while filling report", e);
        }

        return jasperPrint;
    }

    private Map<String, Object> buildParameters(ReportData relatorio) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("attendance", new JRBeanCollectionDataSource(relatorio.getAttendances()));
        parameters.put("course", relatorio.getCourseName());
        parameters.put("academicYear", formatSchoolYear(relatorio.getAcademicYear()));
        parameters.put("date", relatorio.getDate().format(DateTimeFormatter.ISO_DATE));
        parameters.put("class", relatorio.getClassName());

        parameters.put("logo", getClass().getClassLoader().getResource("logo.png"));

        return parameters;
    }

    private String formatSchoolYear(int anoLectivo) {
        return String.format("%d/%d", anoLectivo, anoLectivo + 1);
    }
}
