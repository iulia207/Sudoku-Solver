
package Muresan.Iulia.Sudoku;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


public class Alternatives {
	private int i;
	private int j;

	Queue<Integer> values;
	private int current;
	
	public Alternatives(int i, int j, Set<Integer> values) {
		this.i = i;
		this.j = j;
		this.values = new LinkedList<>(values);
		this.current = -1;
	}

	
	public boolean hasNext() {
		return !values.isEmpty();
	}

	public int next() {
		if (values.isEmpty()) {
			throw new IllegalStateException("There are no alternatives");
		}
		current = values.poll();
		return current;
	}
	
	public int getRow() {
		return i;
	}
	
	public int getColumn() {
		return j;
	}

	@Override
	public String toString() {
		return "("+getRow()+","+getColumn()+"): "+current+"-"+values;
	}
	
	
}