
package Muresan.Iulia.Sudoku;
import java.util.Stack;


public class Solver implements SolverInterface {

	@Override
	public boolean solve(SudokuModel sudokuModel) {
		Stack<Alternatives> stack = new Stack<>();
		Alternatives current = select(0,0, sudokuModel);
		while (current!=null) {
			if (current.hasNext()) {
				int row = current.getRow();
				int column = current.getColumn();
				int v = current.next();
				sudokuModel.set(row, column, v);
				stack.push(current);
				current = select(row,column, sudokuModel);
			} else {
				current = (stack.isEmpty()?null:stack.pop());
				sudokuModel.clear(current.getRow(),current.getColumn());
			}
		}
		return sudokuModel.isFull();
	}
	
	private Alternatives select(int row, int column, SudokuModel sudokuModel) {
		while (row< sudokuModel.getRange()) {
			if (sudokuModel.isEmpty(row,column)) {
				return new Alternatives(row, column, sudokuModel.validValuesAt(row, column));
			}
			column++;
			if (column == sudokuModel.getRange()) {
				row++;
				column = 0;
			}
		}
		return null;
	}
	
}
