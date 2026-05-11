import java.util.List;
import java.util.Map;

class Report {
    private final String title;
    private final List<Map<String, Object>> data;

    public Report(String title, List<Map<String, Object>> data) {
        this.title = title;
        this.data = data;
    }

    public String getTitle() {
        return title;
    }

    public List<Map<String, Object>> getData() {
        return data;
    }
}

interface ReportGenerator {
    String generate(Report report);
}

class PDFReportGenerator implements ReportGenerator {

    @Override
    public String generate(Report report) {
        return "Generating PDF Report for: " + report.getTitle();
    }
}

class ExcelReportGenerator implements ReportGenerator {

    @Override
    public String generate(Report report) {
        return "Generating Excel Report for: " + report.getTitle();
    }
}

class HTMLReportGenerator implements ReportGenerator {

    @Override
    public String generate(Report report) {
        return "Generating HTML Report for: " + report.getTitle();
    }
}

interface ReportSaver {
    void save(String generatedReport);
}

class FileReportSaver implements ReportSaver {

    @Override
    public void save(String generatedReport) {
        System.out.println("Saving Report: " + generatedReport);
    }
}

class ReportService {

    private final ReportGenerator reportGenerator;
    private final ReportSaver reportSaver;

    public ReportService(ReportGenerator reportGenerator,
                         ReportSaver reportSaver) {
        this.reportGenerator = reportGenerator;
        this.reportSaver = reportSaver;
    }

    public void processReport(Report report) {

        if (report.getData() == null || report.getData().isEmpty()) {
            throw new IllegalArgumentException("Report data is empty");
        }

        String generatedReport = reportGenerator.generate(report);

        reportSaver.save(generatedReport);
    }
}

public class Main {

    public static void main(String[] args) {

        Report report = new Report(
                "Sales Report",
                List.of(Map.of("Revenue", 10000))
        );

        ReportGenerator generator = new PDFReportGenerator();

        ReportSaver saver = new FileReportSaver();

        ReportService reportService =
                new ReportService(generator, saver);

        reportService.processReport(report);
    }
}