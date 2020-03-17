package Server;

import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SMain {

	public static void main(String[] args) throws Exception {
		// ������ Ŭ���̾�Ʈ�� ����� ��� program ver 1.0
		
		// TCP ����� �ϱ� ���� �ڿ��� �ʿ��ϴ�.
		// ������ �Ǳ� ���� ����
		ServerSocket serverS = null;	// ����ϱ� ����(�ϳ��� ������ �ȴ�.)
		// ����ϱ� ���� �ڿ�(����)
		Socket withClient = null;	// Ŭ���̾�Ʈ�� ����(Ŭ���̾�Ʈ ������ŭ �ʿ��ϴ�.Ŭ���̾�Ʈ ���Ḷ�� �����Ǵ°ž�)
		
		serverS = new ServerSocket();
		serverS.bind(new InetSocketAddress("10.0.0.110",9999));
		
		ArrayList<Socket> cList = new ArrayList<>(); // ����� Ŭ���̾�Ʈ���� ���� �迭

		while(true) {	// ������ ������� �ʰ� �ٸ� Ŭ���̾�Ʈ�� ������ ������ �ϵ��� while���� �־��ش�.
		System.out.println("���� �����");
		withClient = serverS.accept();	// ������ ���۵ż� ���⼭ ���� ���°� �ȴ�.(Ŭ���̾�Ʈ ����Ǳ� ��ٸ��°ž�)
		             // serverS.accept() : Ŭ���̾�Ʈ ����ϴ� ��
		// accept������ ������ ������ Ŭ���̾�Ʈ�� �������ش�.
		// Ŭ���̾�Ʈ�� ����ϱ� ���� ������ �������ذž�
		
		cList.add(withClient);
		System.out.println(cList);
		System.out.println(withClient.getInetAddress()+" Ŭ���̾�Ʈ ���� ��");
							// withClient.getInetAddress() : Ŭ���̾�Ʈ�� ������ �ּ�
		new ServerChat(withClient);	// ���� ������ �Ѱ���(����ϵ��� �ϱ� ���ؼ�)
		
		}
	}
}
