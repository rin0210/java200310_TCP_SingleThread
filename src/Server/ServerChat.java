package Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class ServerChat {
	// �������� Ŭ���̾�Ʈ�� ����ϱ� ���� Ŭ����

	private Socket withClient = null; // null ���� ���� : � Ŭ���̾�Ʈ�� ������� �� �� ���� ������
	private InputStream reMsg = null; // ������ ���ؼ� �޼����� ���� �� �ֵ��� ���� �ڿ�
	private OutputStream sendMsg = null;
	private String id = null;

	ServerChat(Socket c) { // ������� ������ �޾ƿ´�.
		this.withClient = c;
		streamSet();
	}

	private void streamSet() {
		try {
			// �������κ��� �޼����� �ޱ� ���� �ڵ�
			reMsg = withClient.getInputStream(); 
			byte[] reBuffer = new byte[100];
			reMsg.read(reBuffer); // reMsg�� ������ reBuffer�� �о�� 
			id = new String(reBuffer); // reBuffer�� ��Ʈ������ �ٲ��ذž�
			id = id.trim(); // �������� : ����Ʈ�� 80�� �Դٸ� ������ 20�� �������ֱ� ���ؼ���

			InetAddress c_ip = withClient.getInetAddress(); // withClient�������κ��� �����Ǹ� ������
			String ip = c_ip.getHostAddress();

			System.out.println(id + "�� �α���(" + ip + ")");
			
			String reMsg = "�������ӵǾ����ϴ�."; 
			sendMsg = withClient.getOutputStream();	
			sendMsg.write(reMsg.getBytes());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
