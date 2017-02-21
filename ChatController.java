package datShat;

public class ChatController {

	private ShatServer server = new ShatServer(1337, this);
	private ChatClient client;
	// private ChatGUI gui;

	public ChatController(ChatClient client) {

		this.client = client;
		client.setController(this);
		client.connect();
	}

	public void connected() {
		System.out.println("Connected");
	}

	public void newClient(String userName) {

	}

	public static void main(String[] args) {
		ChatClient client = new ChatClient();
		ChatController controller = new ChatController(client);
	}

}
