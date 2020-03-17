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

	ClientChat(Socket c) {	// ������ ����ϱ� ���� ������ �Ѱܹ���
		this.withServer = c;
		streamSet();
	}

	private void streamSet() {
		try {
			System.out.println("ID�� �Է��ϼ��� >>");
			id = input.nextLine();	
			sendMsg = withServer.getOutputStream();	// ������ getOutputStream�� OutputStream����
			sendMsg.write(id.getBytes());
			
			reMsg = withServer.getInputStream(); 
			byte[] reBuffer = new byte[100];
			reMsg.read(reBuffer); // reMsg�� ������ reBuffer�� �о�� 
			msg = new String(reBuffer); // reBuffer�� ��Ʈ������ �ٲ��ذž�
			msg = msg.trim(); // �������� : ����Ʈ�� 80�� �Դٸ� ������ 20�� �������ֱ� ���ؼ���

			System.out.println(msg);
			
		} catch (Exception e) {
			
		}
	}
}
