package model;

public class Message {
	private long id;
	private String content;

	public Message(long id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + "]";
	}

}
