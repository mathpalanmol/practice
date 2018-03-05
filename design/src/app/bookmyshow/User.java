package app.bookmyshow;

public class User {
	private String name;
	private String mailId;

	public User(String name, String mailId) {
		this.name = name;
		this.mailId = mailId;
	}

	public String getName() {
		return name;
	}

	public String getMailId() {
		return mailId;
	}

}
