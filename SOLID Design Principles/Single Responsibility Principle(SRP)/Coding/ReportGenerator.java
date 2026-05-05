import java.util.List;
import java.util.Map;

class Report{
    String title;
    List<Map<String, Object>> data;
    String type;


}

interface generateReport{
    public void genrate(Report report);
}

class PDFReportGenerator implements generateReport{
    public void genrate(Report report){
        System.err.println("Generate in PDF");
    }
}



class ReportGenerator{
	
}

