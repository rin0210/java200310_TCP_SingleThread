package Client;

import java.net.Socket;

public class CMain {

	public static void main(String[] args) throws Exception {
		Socket withServer = null;
		
		withServer = new Socket("10.0.0.110",9999);
			
		new ClientChat(withServer);	// ������ ������ ������ �Ѱ��ش�.
	}
}
