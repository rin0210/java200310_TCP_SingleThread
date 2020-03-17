package Client;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientChat {
	private Socket withServer = null;
	private InputStream reMsg = null;
	private OutputStream sendMsg = null;
	private String id = null;
	private Scanner input = new Scanner(System.in);
	private String msg = null;

	ClientChat(Socket c) {	// 서버에 통신하기 위한 소켓을 넘겨받음
		this.withServer = c;
		streamSet();
	}

	private void streamSet() {
		try {
			System.out.println("ID를 입력하세요 >>");
			id = input.nextLine();	
			sendMsg = withServer.getOutputStream();	// 소켓의 getOutputStream을 OutputStream으로
			sendMsg.write(id.getBytes());
			
			reMsg = withServer.getInputStream(); 
			byte[] reBuffer = new byte[100];
			reMsg.read(reBuffer); // reMsg의 내용을 reBuffer에 읽어옴 
			msg = new String(reBuffer); // reBuffer를 스트링으로 바꿔준거야
			msg = msg.trim(); // 공백제거 : 바이트가 80만 왔다면 나머지 20은 제거해주기 위해서야

			System.out.println(msg);
			
		} catch (Exception e) {
			
		}
	}
}
