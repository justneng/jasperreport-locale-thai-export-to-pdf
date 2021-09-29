import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;

public class App {

    public static void main(String[] args) {

        Locale localeTh = new Locale("th", "TH");
        Locale.setDefault(localeTh);

        System.out.println("app started...");
        try (InputStream jasper = new FileInputStream("src/main/resources/Blank_A4.jasper")) {
            HashMap<String, Object> params = new HashMap<>();
//            params.put(JRParameter.REPORT_LOCALE, localeTh);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasper, params, new JREmptyDataSource());
            JasperExportManager.exportReportToPdfFile(jasperPrint, "target/sample2.pdf");
            System.out.println("done.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
