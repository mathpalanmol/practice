package taxiBookingSystem.model;

import java.util.ArrayList;
import java.util.List;

public class UserManagement {
	List<User> activeUsers = new ArrayList<User>();

	long getActiveUserCount() {
		return activeUsers.size();
	}

	public void addUser(User user) {
		activeUsers.add(user);
	}

	public void removeUser(User user) {
		activeUsers.remove(user);
	}

	
}
