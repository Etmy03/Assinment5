/**
 * 
 *@author Etmy Barbosa
 *
 */
import java.io.BufferedReader; //d
import java.io.FileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TwoDimRaggedArrayUtility {

	
	//all get methods
	public static double getAverage(double[][] d) {
		double average; 
		double sum=0;
		int count = 0;
		for(int row=0; row<d.length; row++) {
			for(int col=0; col<d[row].length; col++) {
				sum += d[row][col];
				count++;
			}
		}
		average = sum/count;
		return average;
	}
	
	public static double getColumnTotal(double[][] d, int col) {
		double columnTotal = 0;
		for(int row=0; row<d.length; row++) {
			if(d[row].length >= col+1) {
				columnTotal += d[row][col];
			}
			
		}
		
		return columnTotal;
	}
	
	public static double getHighestInArray(double[][] d) {
		double highestInArray = d[0][0];
		for(int row=0; row<d.length; row++) {
			for(int col=0; col<d[row].length; col++) {
				if((d[row][col]) > highestInArray) {
					highestInArray = d[row][col];
				}
			}
		}
		return highestInArray;
	}
	
	public static double getHighestInColumn(double[][] d, int col) {
		double highestInColumn = d[0][col];
		for(int row=0; row<d.length; row++) {
			if(d[row].length >= col+1) {
				if((d[row][col]) > highestInColumn) {
					highestInColumn = d[row][col];
				}
			}
			
		}
		return highestInColumn;
	}
	
	public static int getHighestInColumnIndex(double[][] d, int col) {
		int highestInColumnIndex = 0;
		double num = getHighestInColumn(d, col);
		for(int row=0; row<d.length; row++) {
			if(d[row].length >= col+1) {
				if((d[row][col]) == num) {
					highestInColumnIndex = row;
			}
			
			}
		}
		return highestInColumnIndex;
	}
	
	public static double getHighestInRow(double[][] d, int row) {
		double highestInRow = d[row][0];
		for(int col=0; col<d[row].length; col++) {
			if((d[row][col]) > highestInRow) {
				highestInRow = d[row][col];
			}
		}
		return highestInRow;
	}
	
	public static int getHighestInRowIndex(double[][] d, int row) {
		int highestInRowIndex = 0;
		double num = getHighestInRow(d, row);
		for(int col=0; col<d[row].length; col++) {
			if((d[row][col]) == num) {
				highestInRowIndex = col;
			}
			
		}
		return highestInRowIndex;
	}
	
	public static double getLowestInArray(double[][] d) {
		double lowestInArray = d[0][0];
		for(int row=0; row<d.length; row++) {
			for(int col=0; col<d[row].length; col++) {
				if((d[row][col]) <lowestInArray) {
					lowestInArray = d[row][col];
				}
			}
		}
		return lowestInArray;
	}
	
	public static double getLowestInColumn(double[][] d, int col) {
		double lowestInColumn = d[0][col];
		for(int row=0; row<d.length; row++) {
			if(d[row].length >= col+1) {
				if((d[row][col]) < lowestInColumn) {
					lowestInColumn = d[row][col];
				}
			}
			
		}
		return lowestInColumn;
	}
	
	public static int getLowestInColumnIndex(double[][] d, int col) {
		int lowestInColumnIndex = 0;
		double num = getLowestInColumn(d, col);
		for(int row=0; row<d.length; row++) {
			if(d[row].length >= col+1) {
				if((d[row][col]) == num) {
					lowestInColumnIndex = row;
				}
			}
			
		}
		return lowestInColumnIndex;
	}
	
	public static double getLowestInRow(double[][] d, int row) {
		double lowestInRowe = d[row][0];
		for(int col=0; col<d[row].length; col++) {
			if((d[row][col]) < lowestInRowe) {
				lowestInRowe = d[row][col];
			}
		}
		return lowestInRowe;
	}
	
	public static int getLowestInRowIndex(double[][] d, int row) {
		int lowestInRowIndex = 0;
		double num = getLowestInRow(d, row);
		for(int col=0; col<d[row].length; col++) {
			if((d[row][col]) == num) {
				lowestInRowIndex = col;
				
			}
		}
		return lowestInRowIndex;
	}
	
	public static double getRowTotal(double[][] d, int row) {
		double rowTotal = 0;
		for(int col=0; col<d[row].length; col++) {
			rowTotal += d[row][col];
		}
		return rowTotal;
	}
	
	public static double getTotal(double[][] d) {
		double total=0;
		for(int row=0; row<d.length; row++) {
			for(int col=0; col<d[row].length; col++) {
				total += d[row][col];
			}
		}
		return total;
	}
	
	public static double[][] readFile(File file) throws FileNotFoundException{
		String[][]dataStr = new String[10][10];
		double[][]data;
		String[]line;
		int r = 0;
		int c = 0;
		Scanner scan = new Scanner(file);
		
		while(scan.hasNextLine()) {
			line = scan.nextLine().split(" ");
			for(int col = 0; col<line.length;col++){
				dataStr[r][col] = line[col];
			}
			r++;
		}
		data = new double[r][];
		for(int row = 0; row< data.length;row++) {
			c = 0;
			for(int col = 0; col<dataStr[row].length; col++) {
				if(dataStr[row][col] == null) {
					break;
				}
				c++;
			}
			data[row] = new double[c];
		}
		
		for(int row = 0; row< data.length;row++) {
			for(int col = 0; col< data[row].length;col++) {
				data[row][col] = Double.parseDouble(dataStr[row][col]);
			}
		}
				
				
		return data;
	}
	
	public static void writeToFile(double[][] d, File outputFile) throws FileNotFoundException{
		String str = "";
		PrintWriter output = new PrintWriter(outputFile);
		
		for(int row=0; row<d.length; row++) {
			for(int col=0; col<d[row].length; col++) {
				if((row == (d.length-2)) && (col == (d[row].length-2))) {
					str += d[row][col] + "\n";
				}
				else {
					str += d[row][col] + " ";
				}
				
			}
			
		}
		
		output.print(String.format(str));
		output.close();
	}
	
	
	//readFile & writeToFile
	

}
