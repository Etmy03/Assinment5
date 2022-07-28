/**
 * 
 * @author Etmy Barbosa
 *
 */
public class HolidayBonus extends TwoDimRaggedArrayUtility{
	public static double[] calculateHolidayBonus(double[][] data, double high,double low, double other) {
		//TwoDimRaggedArrayUtility store = new TwoDimRaggedArrayUtility();
		double[] bonus = new double[10];
		double[] total = new double[10];
		int h_index=0;
		int l_index=0;
		
		int r = 0;
		for(int col = 0; col<data[r].length;col++) {
			h_index = getHighestInColumnIndex(data, col);
			l_index = getLowestInColumnIndex(data, col);
			for(int row = 0; row<total.length;row++) {
				if(row == h_index) {
					bonus[row] += high;
				}
				else if(row == l_index) {
					bonus[row] += low;
				}
				else {
					bonus[row] += other;
				}
			}
		
		}
		return bonus;
	}
	public static double calculateTotalHolidayBonus(double[][] data,double high,double low,double other) {
		double[] bonus = calculateHolidayBonus(data,high,low,other);
		double total = 0;
		
		for(int row = 0; row<bonus.length;row++) {
			total += bonus[row];
		}
		return total;
	}
		
}