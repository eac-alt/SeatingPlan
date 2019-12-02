package main;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	
	public class WriteToExcel {

		public void fileWriter(String [][] seatLocation) throws IOException, InvalidFormatException {
			String[] columns =  {" ", "Seat_1", "Seat_2", "Seat_3", "Seat_4", "Seat_5", "Seat_6" };

			
			Workbook workbook = new XSSFWorkbook();

			CreationHelper createHelper = workbook.getCreationHelper();

			// Create a Sheet
			Sheet sheet = workbook.createSheet("Seating_Plan");

			// Create a Font for styling header cells
			Font headerFont = workbook.createFont();
			headerFont.setItalic(true);
			headerFont.setFontHeightInPoints((short) 14);

			// Create a CellStyle with the font
			CellStyle headerCellStyle = workbook.createCellStyle();
			headerCellStyle.setFont(headerFont);

			Row boardRow = sheet.createRow(0);
			String boardName = "Board";
			Cell board = boardRow.createCell(4);
			board.setCellValue(boardName);
			board.setCellStyle(headerCellStyle);

			Row headerRow = sheet.createRow(1);

			for (int i = 0; i < columns.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(columns[i]);
				cell.setCellStyle(headerCellStyle);
			}
			int numberOfRows = seatLocation.length;
			for (int rowNumber = 0; rowNumber < numberOfRows; rowNumber++) { 
				Row row = sheet.createRow(rowNumber+2);
				String rowName = "Row_" + (rowNumber+1);
				Cell rowNameCell = row.createCell(0);
				rowNameCell.setCellValue(rowName);
				rowNameCell.setCellStyle(headerCellStyle);
				
				int seatsPerRow = seatLocation[rowNumber].length;
				int windowRow = 0;
				String windowName = "Window";
				if (rowNumber == windowRow) {
					Cell rowCell = row.createCell(seatsPerRow + 1);
					rowCell.setCellValue(windowName);
					rowCell.setCellStyle(headerCellStyle);

				}

							
				for (int seat = 0; seat < seatsPerRow; seat++) {
					

					row.createCell(seat+1).setCellValue(seatLocation[rowNumber][seat]);

				}
			

			}

			// Resize all columns to fit the content size
			for (int i = 0; i < columns.length; i++) {
				sheet.autoSizeColumn(i);
			}

			// Write the output to a file
			FileOutputStream fileOut = new FileOutputStream("Seating_Plan.xlsx");
			workbook.write(fileOut);
			fileOut.close();

			// Closing the workbook
			workbook.close();
		}
	}