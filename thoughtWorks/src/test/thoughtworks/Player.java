package test.thoughtworks;

import java.util.ArrayList;
import java.util.List;

public class Player {
	String playerName;
	int player_ptr;
	int playerCurrentBalance;
	List<Hotel> hotels = new ArrayList<Hotel>();
	
	

	public Player(String playerName, int player_ptr, int playerCurrentBalance) {
		super();
		this.playerName = playerName;
		this.player_ptr = player_ptr;
		this.playerCurrentBalance = playerCurrentBalance;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayer_ptr() {
		return player_ptr;
	}

	public void setPlayer_ptr(int player_ptr) {
		this.player_ptr = player_ptr;
	}

	public int getPlayerCurrentBalance() {
		return playerCurrentBalance;
	}

	public void setPlayerCurrentBalance(int playerCurrentBalance) {
		this.playerCurrentBalance = playerCurrentBalance;
	}

	public List<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(List<Hotel> hotels) {
		this.hotels = hotels;
	}
	
	void addHotel(Hotel hotel){
		this.hotels.add(hotel);
	}

	public void addBalance(int amount) {
		this.playerCurrentBalance = this.playerCurrentBalance + amount;
		
	}
	public void subBalance(int amount) {
		this.playerCurrentBalance = this.playerCurrentBalance - amount;
		
	}

}
