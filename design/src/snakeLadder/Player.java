package snakeLadder;

public class Player {
	private String name;
	Cell cell;
	
	public Player(String name) {
		this.name = name;
	}
	
	public Cell getCell() {
		return cell;
	}
	
	public void setCell(Cell cell) {
		this.cell = cell;
	}
	
	public String getName() {
		return name;
	}

}
