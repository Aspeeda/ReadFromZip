package tests;

import com.codeborne.pdftest.PDF;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ReadFromZip {

    ClassLoader cl = ReadFromZip.class.getClassLoader();

    @Test
    void readZipPDF() throws Exception {

        try (
                InputStream is = cl.getResourceAsStream("Desktop.zip");
                ZipInputStream zis = new ZipInputStream(is);
                ) {
            ZipEntry entry;

        while ((entry = zis.getNextEntry()) != null) {
            if (entry.getName().contains(".pdf")) {
                    PDF pdf = new PDF(zis);
                    assertThat(pdf.text).contains("John");
                } else if (entry.getName().contains(".xls")) {
                    XLS xls = new XLS(zis);
                    assertThat(xls.excel.getSheetAt(0).getRow(0).getCell(0).getStringCellValue()).isEqualTo("John");
                    assertThat(xls.excel.getSheetAt(0).getRow(0).getCell(1).getStringCellValue()).isEqualTo("Snow");
                } else {
                    CSVReader csvReader = new CSVReader(new InputStreamReader(zis));
                    List<String[]> csv = csvReader.readAll();
                    assertThat(csv.get(0)[0]).contains("John");
                    assertThat(csv.get(0)[0]).contains("Snow");
                }
            }
        }
    }
}
