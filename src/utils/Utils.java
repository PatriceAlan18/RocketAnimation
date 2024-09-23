package utils;

public class Utils {

	public static int getRandom(int min, int max) {
	    return (int) (Math.random() * (max - min + 1) + min);
	}

	public static boolean percentChance(int percentage) {
	    if (percentage < 0 || percentage > 100) {
	        throw new IllegalArgumentException("Percentage must be between 0 and 100.");
	    }
	    return Math.random() < (percentage / 100.0);
	}
	
}
