import java.io.*;
import java.net.*;


public class Client {

	private Socket socket;
	
	public Client() {
		
	}
	
	public void start(String host){
		try {
			this.socket = new Socket(host, 80);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			OutputStream out = this.socket.getOutputStream();
			OutputStreamWriter stream = new OutputStreamWriter(out);
			BufferedWriter buffer = new BufferedWriter(stream);
			buffer.write("");
			buffer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String read(){
		String response = null;
		try {
			InputStream in = this.socket.getInputStream();
			InputStreamReader stream = new InputStreamReader(in);
			BufferedReader buffer = new BufferedReader(stream);
			while(buffer != null){
				response = buffer.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
		
	}
	
	public void show(String response){
		System.out.println(response);
	}
	
	public static void main(String[] args) {
		Client client = new Client();
		client.start("127.0.0.1");
		String response = client.read();
		client.show(response);
	}
}
