package socket2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;


public class Ex01client {
	public static void main(String[] args) throws  IOException {
		Socket socket = new Socket("192.168.113.21", 10000);
		System.out.println("서버에 연결됨");
		
		PrintWriter pw = new PrintWriter(socket.getOutputStream(),true);
		Scanner sc = new Scanner(System.in);
		String msg;
		
		do
		{
			System.out.println("입력(0 : 종료) ");
			msg = sc.nextLine();
			
			pw.println(msg);
		}while(!"0".equals(msg));
		
		
		pw.println(msg);
		
		socket.close();
		sc.close();
		System.out.println("연결이 종료 되었습니다");
	}
}
