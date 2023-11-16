package socket2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ex01 {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSk = new ServerSocket(10000);
		System.out.println("서버 연결 대기중... ");
		
		Socket clientSk = serverSk.accept();
		System.out.println("클라이언트가 연결됨");
		
		Scanner sc = new Scanner(clientSk.getInputStream());
		//-클라이언트가 입력한 데이터를 읽을 Scanner 
		//클라이언트가 연결을 끊으면 제거됨
		
		while(sc.hasNextLine())
		{
			System.out.println("받은 데이터: "+sc.nextLine());
		}
		
		clientSk.close();
		serverSk.close();
		System.out.println("연결 종료");
	}
}
