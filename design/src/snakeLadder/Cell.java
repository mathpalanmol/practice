package snakeLadder;

public class Cell {
	private int id;
	private Cell destination;
	private Mark mark;
	
	public Cell(int id) {
		this(id, Mark.NONE,null);	
	}
	public Cell(int id, Mark mark, Cell destination) {
		this.id = id;
	    this.mark = mark;
	    this.destination = destination;
	}
	
	public void setLadder(Cell destination) {
		mark = Mark.LADDER;
		this.destination = destination;
	}
	
	public void setSnake(Cell destination) {
		mark = Mark.SNAKE;
		this.destination = destination;
	}
	public int getId() {
		return id;
	}
	public Cell getDestination() {
		return destination;
	}
	public Mark getMark() {
		return mark;
	}
}
