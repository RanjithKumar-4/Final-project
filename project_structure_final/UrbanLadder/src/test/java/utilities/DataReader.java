package utilities;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DataReader {

    public static void writeBookshelvesData(WebDriver driver, int count) throws IOException {

        List<WebElement> names = driver.findElements(By.className("XxwSy"));
        List<WebElement> prices = driver.findElements(By.className("UYQNp"));

        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Bookshelves");

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Product Name");
        header.createCell(1).setCellValue("Price");

        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setBold(true);
        style.setFont(font);

        header.getCell(0).setCellStyle(style);
        header.getCell(1).setCellStyle(style);

        for (int i = 0; i < count; i++) {

            Row row = sheet.createRow(i + 1);

            row.createCell(0).setCellValue(names.get(i).getText());
            row.createCell(1).setCellValue(prices.get(i).getText());
        }

        sheet.autoSizeColumn(0);
        sheet.autoSizeColumn(1);

        String file = System.getProperty("user.dir") + "/testdata/bookshelves.xlsx";

        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);

        workbook.close();
        fos.close();

        System.out.println("✅ Bookshelves Excel Created");
    }

    public static void writeCollectionsData(WebDriver driver) throws IOException {

        List<WebElement> names = driver.findElements(By.className("XxwSy"));
        List<WebElement> prices = driver.findElements(By.className("UYQNp"));

        Workbook workbook = new XSSFWorkbook();

        Sheet best = workbook.createSheet("BestSellers");
        Sheet newArrivals = workbook.createSheet("NewArrivals");

        writeSheet(best, names, prices, 0, 6);   // first 6
        writeSheet(newArrivals, names, prices, 6, names.size()); // rest

        String file = System.getProperty("user.dir") + "/testdata/collections.xlsx";

        FileOutputStream fos = new FileOutputStream(file);
        workbook.write(fos);

        workbook.close();
        fos.close();

        System.out.println("✅ Collections Excel Created");
    }

    private static void writeSheet(Sheet sheet,
                                   List<WebElement> names,
                                   List<WebElement> prices,
                                   int start,
                                   int end) {

        Row header = sheet.createRow(0);
        header.createCell(0).setCellValue("Product Name");
        header.createCell(1).setCellValue("Price");

        for (int i = start; i < end; i++) {

            Row row = sheet.createRow(i - start + 1);

            row.createCell(0).setCellValue(names.get(i).getText());
            row.createCell(1).setCellValue(prices.get(i).getText());
        }
    }
}