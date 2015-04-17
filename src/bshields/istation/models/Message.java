package bshields.istation.models;

/**
 * A simple immutable message object
 * 
 * @author Brian
 */
public class Message {
	private String message;
	private Object tag;
	
	/**
	 * Creates a new message
	 * 
	 * @param message the contents of the message
	 * @see #Message(String, Object)
	 */
	public Message(String message) { this(message, null); }
	/**
	 * Creates a new message with a tagged bit of data
	 * 
	 * @param message the contents of the message
	 * @param tag an arbitrary tagged object
	 */
	public Message(String message, Object tag) {
		this.message = message;
		this.tag = tag;
	}
	
	public Object getTag() { return tag; }
	
	@Override
	public String toString() { return message; }
}
