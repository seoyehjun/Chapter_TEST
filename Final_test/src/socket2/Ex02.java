package socket2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Ex02 {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSk = new ServerSocket(10001);
		System.out.println("서버On. 연결 대기중...");
		
		Socket clientSk = serverSk.accept();
		System.out.println("클라이언트 연결됨");

		PrintWriter output = new PrintWriter(clientSk.getOutputStream(), true);
		Scanner input = new Scanner(clientSk.getInputStream());
		
		Scanner sc = new Scanner(System.in);
		String msg;
		
		while (input.hasNextLine()) {
			System.out.println("입력 받은 데이터 : " + input.nextLine());
			
			System.out.print("\n입력 (0 : 종료) ");
			msg = sc.nextLine();
			
			if ("0".equals(msg)) { break; }
			
			output.println(msg);
		}
		
		serverSk.close();
		clientSk.close();
		sc.close();
		System.out.println("\n연결이 종료 되었습니다");
	}
}

