package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ServerChat {
	// 서버에서 클라이언트와 통신하기 위한 클래스

	private Socket withClient = null; // null 잡은 이유 : 어떤 클라이언트와 통신할지 알 수 없기 때문에
	private InputStream reMsg = null; // 소켓을 통해서 메세지가 들어올 수 있도록 만든 자원
	private OutputStream sendMsg = null;
	private String id = null;

	ServerChat(Socket c) { // 만들어진 소켓을 받아온다.
		this.withClient = c;
		streamSet();
	}

	private void streamSet() {
		try {
			// 소켓으로부터 메세지를 받기 위한 코딩
			reMsg = withClient.getInputStream(); 
			byte[] reBuffer = new byte[100];
			reMsg.read(reBuffer); // reMsg의 내용을 reBuffer에 읽어옴 
			id = new String(reBuffer); // reBuffer를 스트링으로 바꿔준거야
			id = id.trim(); // 공백제거 : 바이트가 80만 왔다면 나머지 20은 제거해주기 위해서야

			InetAddress c_ip = withClient.getInetAddress(); // withClient소켓으로부터 아이피를 가져옴
			String ip = c_ip.getHostAddress();

			System.out.println(id + "님 로그인(" + ip + ")");
			
			String reMsg = "정상접속되었습니다."; 
			sendMsg = withClient.getOutputStream();	
			sendMsg.write(reMsg.getBytes());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
