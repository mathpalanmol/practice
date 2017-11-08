package test.thoughtworks;

public class Board {
	CellIfc[] cells;
	public Board(CellIfc[] cells) {
		super();
		this.cells = cells;
	}
	public CellIfc[] getCells() {
		return cells;
	}
	public void setCells(CellIfc[] cells) {
		this.cells = cells;
	}
	
	public CellIfc getCell(int index){
		return cells[index];
	}
	
	
}
