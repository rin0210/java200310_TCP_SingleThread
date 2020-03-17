package Server;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SMain {

	public static void main(String[] args) throws Exception {
		// 서버와 클라이언트와 양방향 통신 program ver 1.0
		
		// TCP 통신을 하기 위한 자원이 필요하다.
		// 서버가 되기 위한 소켓
		ServerSocket serverS = null;	// 대기하기 위함(하나만 있으면 된다.)
		// 통신하기 위한 자원(소켓)
		Socket withClient = null;	// 클라이언트와 연결(클라이언트 개수만큼 필요하다.클라이언트 연결마다 생성되는거야)
		
		serverS = new ServerSocket();
		serverS.bind(new InetSocketAddress("10.0.0.110",9999));
		
		ArrayList<Socket> cList = new ArrayList<>(); // 연결된 클라이언트들을 담을 배열

		while(true) {	// 서버가 종료되지 않고 다른 클라이언트의 연결이 가능케 하도록 while문을 넣어준다.
		System.out.println("서버 대기중");
		withClient = serverS.accept();	// 서버가 시작돼서 여기서 멈춘 상태가 된다.(클라이언트 연결되길 기다리는거야)
		             // serverS.accept() : 클라이언트 대기하는 것
		// accept상태인 서버의 소켓을 클라이언트로 리턴해준다.
		// 클라이언트와 통신하기 위한 소켓을 생성해준거야
		
		cList.add(withClient);
		System.out.println(cList);
		System.out.println(withClient.getInetAddress()+" 클라이언트 접속 됨");
							// withClient.getInetAddress() : 클라이언트의 아이피 주소
		new ServerChat(withClient);	// 만든 소켓을 넘겨줌(통신하도록 하기 위해서)
		
		}
	}
}
