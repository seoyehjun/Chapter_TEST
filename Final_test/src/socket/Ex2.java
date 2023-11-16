package socket;

import java.io.IOException;
import java.net.Socket;

public class Ex2 {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("192.168.113.21", 10000);
		System.out.println("서버에 연결됨!!!");
		
		socket.close();
		System.out.println("\n연결이 종료되었습니다");
	}
}
