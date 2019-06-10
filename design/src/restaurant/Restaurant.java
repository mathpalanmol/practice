package restaurant;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Restaurant {
	private String name;
	private int open;
	private int close;
	private List<Table> tables = new ArrayList<Table>();

	public Restaurant(String name, int open, int close) {
		super();
		this.name = name;
		this.open = open;
		this.close = close;
		init();
	}

	private void init() {
		int small = 2;
		int mid = 4;
		int large = 6;
		int id = 1;
		for (int i = 0; i < 3; i++) {
			Table st = new Table(id++, small);
			Table mt = new Table(id++, mid);
			Table lt = new Table(id++, large);
			tables.add(st);
			tables.add(mt);
			tables.add(lt);
		}
	}

	public void addTable(Table table) {
		tables.add(table);
	}

	public void remvoveTable(Table table) {
		tables.remove(table);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getOpen() {
		return open;
	}

	public void setOpen(int open) {
		this.open = open;
	}

	public int getClose() {
		return close;
	}

	public void setClose(int close) {
		this.close = close;
	}

	public List<Table> getTables() {
		return tables;
	}

	public void setTables(List<Table> tables) {
		this.tables = tables;
	}

	public List<Table> getTables(Date date, Slot slot, int guestCount) {
		List<Table> res = new ArrayList<Table>();
		for (Table table : tables) {
			Map<Integer, Slot> slots = table.getSlots(date.toString());
			boolean isAvl = checkforGivenSlot(slots, slot);
			if (isAvl) {
				res.add(table);
				guestCount -= table.capacity; // once table is selected reduce it from guest count.
				// Idea is to achive 0 or less less count. 0 mean table(s) total capacity ==
				// guestcount
				// -ve means capacity is more... for booking both cases are ok.
			}
			// continue to look for other tables in the restaureant
			if (guestCount <= 0) // guest count is greate than capacity.
				break;
		}
		if (guestCount > 0) // guest count is greate than capacity.
			return null;

		return res;
	}

	private boolean checkforGivenSlot(Map<Integer, Slot> slots, Slot slot) {
		if (slots != null && slots.get(slot.getTo()) != null) {
			return false;
		}
		// slots.put(slot.getTo(), slot); // don't book it now... just checking...
		// booking will happen in bookTable

		return true;
	}

	public boolean bookTable(Date date, Slot slot, List<Table> tables) {
		for (Table table : tables) {
			Map<Integer, Slot> slots = table.getSlots(date.toString());
			if(slots == null) {
				slots = new HashMap<Integer, Slot> ();
			}
			int to = slot.getTo();
			while (to <= slot.getFrom()) {
				slots.put(to, slot);
				to++;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return "Restaurant [name=" + name + ", open=" + open + ", close=" + close + ", tables=" + tables + "]";
	}

}
