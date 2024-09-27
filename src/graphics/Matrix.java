package graphics;

public class Matrix {

	public static int[] multiplyMatrices(int[] m1, int[][] m2) {
		 if (m1.length != m2.length) {
		        throw new IllegalArgumentException("Incompatible dimensions for multiplication.");
		    }
		int[] newM = new int[m1.length];
		for(int i = 0; i<m1.length; i++) {
			for(int j = 0; j<m2[i].length; j++) {
				newM[i]=newM[i]+m1[j]*m2[i][j];
			}
		}
		return newM;
	}
	
	public static int[] multiplyMatrices(int[] m1, double[][] m2) {
		 if (m1.length != m2.length) {
		        throw new IllegalArgumentException("Incompatible dimensions for multiplication.");
		    }
		int[] newM = new int[m1.length];
		for(int i = 0; i<m1.length; i++) {
			for(int j = 0; j<m2[i].length; j++) {
				newM[i]=(int) (newM[i]+m1[j]*m2[i][j]);
			}
		}
		return newM;
	}
	
	public String toString(int[] matrix) {
		StringBuilder m = new StringBuilder();
		for(int i = 0; i<matrix.length; i++) {
			m.append(matrix[i]+"  ");
		}
		return m.toString();
	}
	
	public String toStringMatrix(int[][] matrix) {
		StringBuilder m = new StringBuilder();
		for(int i = 0; i<matrix.length; i++) {
			for(int j = 0; j<matrix[i].length; j++) {
				m.append(matrix[i][j]+"  ");
			}
			m.append("\n");
		}
		return m.toString();
	}
	
	public String toStringMatrix(double[][] matrix) {
		StringBuilder m = new StringBuilder();
		for(int i = 0; i<matrix.length; i++) {
			for(int j = 0; j<matrix[i].length; j++) {
				m.append(matrix[i][j]+"  ");
			}
			m.append("\n");
		}
		return m.toString();
	}
	
}
