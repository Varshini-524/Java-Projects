import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
/** Application that does the Randomizing
 * @author Varshini Selvadurai
 * @author Team ROCK
 */
public class Application{
	/**Location of File
	 */
    private static final String FILE_NAME = "/Users/VarshiniSelvadurai/Documents/Play Cards.xlsx";
    /**Number of plays
	 */
    private static int numOfPlays = 78;
    private static FileInputStream excelFile;
    private static Workbook workbook;
    private static Sheet sheet;
    /**Stores data 
	 */
    private static String[][] data;
    private static int rownum;
    private static Row row;
    /**Opens the file
	 */
    public Application() throws IOException{
    	try{
    		excelFile = new FileInputStream(new File(FILE_NAME));
    	}catch(FileNotFoundException e){
    		e.printStackTrace();
    	}
    	workbook = new XSSFWorkbook(excelFile);
    	sheet = null;
    	data = readPlays();
    	rownum = 0;
    	row = null;
    }
    /**Writes the List to the Excel File
     * Private 
	 */
    private static void printList(){
    	sheet = workbook.getSheetAt(1);
		row = null;
		rownum = 0;
		for(int i = 0 ; i<78; i++){	
        	row = sheet.createRow(rownum++);
	        Cell cell = row.createCell(0);
	        //System.out.print(i + " " + data[i][0]);
        	cell.setCellValue(data[i][0]);
        	cell = row.createCell(1);
        	//System.out.println(data[i][1]);
        	cell.setCellValue(data[i][1]);
        }
		try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
        	e.printStackTrace();
        }
		System.out.println("Print List: DONE");
    }
    /** Reads form the Excel sheet
     * @return String[][] with Play Number and Name
	 */
    private static String[][] readPlays(){
    	sheet = workbook.getSheetAt(1);
		Iterator<Row> iterator = sheet.iterator();
		String[][] data = new String[numOfPlays][3];
		int r = 0;
		while (iterator.hasNext()) {
			int c = 0;
			Row currentRow = iterator.next();
			Iterator<Cell> cellIterator = currentRow.iterator();
			while (cellIterator.hasNext()) {
				Cell currentCell = cellIterator.next();
				if (currentCell.getCellTypeEnum() == CellType.STRING) {
					data[r][c] = currentCell.getStringCellValue();
                } else if (currentCell.getCellTypeEnum() == CellType.NUMERIC) {
                	data[r][c] = String.valueOf((int)currentCell.getNumericCellValue());
                }
				c++;
			}
			r++;
		}
		System.out.println("Read Plays: DONE");
		return data;
    }
    /**Randomize Play Number
     * Also creates a Random List
	 */
    public static void randomizePlayNum(){
		for(int i = 0; i < data.length; i++){
			data[i][2] = String.valueOf(Math.random());
		}
		for (int pass = 0; pass<data.length; pass++){
			int min = pass;
			for(int i = pass; i<data.length; i++){
				if (data[min][2].compareTo(data[i][2]) > 0){
					min = i;
				}					
			}
			String play = data[pass][1];
			data[pass][1] = data[min][1];
			data[min][1] = play;
			String ran = data[pass][2];
			data[pass][2] = data[min][2];
			data[min][2] = ran;
		}
		sheet = workbook.getSheetAt(0);
		rownum = 0;
		row = null;
        System.out.println("Changing Numbering");
        for(int i = 0 ; i<13; i++){	
        	row = sheet.createRow(rownum++);
        	Cell cell = row.createCell(0);
	        cell.setCellValue(data[i][0]);
	        cell = row.createCell(1);
	        cell.setCellValue(data[i][1]);
		    cell = row.createCell(2);
	        cell.setCellValue(data[i+13][0]);
	        cell = row.createCell(3);
	        cell.setCellValue(data[i+13][1]);
        }
        rownum++;
        rownum++;
        rownum++;
        rownum++;
        for(int i = 26 ; i<39; i++){	
        	row = sheet.createRow(rownum++);
        	Cell cell = row.createCell(0);
	        cell.setCellValue(data[i][0]);
	        cell = row.createCell(1);
	        cell.setCellValue(data[i][1]);
		    cell = row.createCell(2);
	        cell.setCellValue(data[i+13][0]);
	        cell = row.createCell(3);
	        cell.setCellValue(data[i+13][1]);
        }
        rownum++;
        rownum++;
        rownum++;
        rownum++;
        for(int i = 52 ; i < 65; i++){
        	row = sheet.createRow(rownum++);
        	Cell cell = row.createCell(0);
	        cell.setCellValue(data[i][0]);
	        cell = row.createCell(1);
	        cell.setCellValue(data[i][1]);
		    cell = row.createCell(2);
	        cell.setCellValue(data[i+13][0]);
	        cell = row.createCell(3);
	        cell.setCellValue(data[i+13][1]);
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
        	e.printStackTrace();
        }
        printList();
        randomizeOrder();
		System.out.println("Randomize Plays: DONE");
    }
    /**Creates Randomized List
     * For practices: EXTRA FEATURE
	 */
    public static void randomizeOrder(){
    	for(int i = 0; i < data.length; i++){
			data[i][2] = String.valueOf(Math.random());
		}
		for (int pass = 0; pass<data.length; pass++){
			int min = pass;
			for(int i = pass; i<data.length; i++){
				if (data[min][2].compareTo(data[i][2]) > 0){
					min = i;
				}					
			}
			String num = data[pass][0];
			data[pass][0] = data[min][0];
			data[min][0] = num;
			String play = data[pass][1];
			data[pass][1] = data[min][1];
			data[min][1] = play;
			String ran = data[pass][2];
			data[pass][2] = data[min][2];
			data[min][2] = ran;
		}
		sheet = workbook.getSheetAt(2);
        rownum = 0;
        System.out.println("Creating excel");
        row = null;
        for (String[] x : data) {
            row = sheet.createRow(rownum++);
            int colNum = 0;
            for (String s : x) {
                Cell cell = row.createCell(colNum++);
                if(colNum != 3){
                	cell.setCellValue(s);
                }
                
            }
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(FILE_NAME);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
        	e.printStackTrace();
        }
		System.out.println("Randomize Order: DONE");
    }
    /*public static void main(String[] arg) throws IOException{
    	Application app = new Application();
    	app.randomizePlayNum();
    }*/
}