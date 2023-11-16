package socket2;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Ex02Client {
	public static void main(String[] args) throws IOException {
		Socket socket = new Socket("localhost", 10001);
		System.out.println("서버에 연결됨");
		
		PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
		Scanner input = new Scanner(socket.getInputStream());
		
		Scanner sc = new Scanner(System.in);
		String msg;
		
		do {
			System.out.print("\n입력 (0 : 종료) ");
			msg = sc.nextLine();
			
			output.println(msg);
			
			if (input.hasNextLine()) {
				System.out.println("입력 받은 데이터 : " + input.nextLine());
			}
			
		} while (!"0".equals(msg));
		
		
		socket.close();
		sc.close();
		System.out.println("\n 연결이 종료 되었습니다");
	}
}