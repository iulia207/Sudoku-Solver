
package Muresan.Iulia.Sudoku;


public class Main {
	
	public static final int[][] MODEL = new int[][] {
		new int[] { 0, 0, 0, 0, 0, 0, 0, 5, 0 } ,
		new int[] { 0, 0, 1, 0, 0, 9, 3, 0, 0 } ,
		new int[] { 9, 0, 0, 7, 0, 1, 0, 0, 0 } ,
		new int[] { 0, 0, 5, 0, 9, 0, 4, 0, 7 } ,
		new int[] { 6, 0, 0, 0, 2, 0, 0, 0, 3 } ,
		new int[] { 2, 0, 9, 0, 4, 0, 6, 0, 0 } ,
		new int[] { 0, 0, 0, 5, 0, 2, 0, 0, 1 } ,
		new int[] { 0, 0, 4, 8, 0, 0, 2, 0, 0 } ,
		new int[] { 0, 1, 0, 0, 0, 0, 0, 0, 0 } 
	};
	
	
	public static void main(String[] argv) {
		Solver solver = new Solver();
		SudokuModel sudokuModel = new SudokuModel(3,MODEL);
		solver.solve(sudokuModel);
		for(int i = 0; i< sudokuModel.getRange(); i++) {
			for(int j = 0; j< sudokuModel.getRange() ; j++) {
				if(j == 3 || j==6 )
					System.out.print('|'+" ");
				System.out.print( " " + sudokuModel.getValue(i, j) + " " );
			}
			System.out.println();
			if(i == 2 || i==5 || i==8)
				System.out.println("_______________________________" + " ");
		}
	}

}
