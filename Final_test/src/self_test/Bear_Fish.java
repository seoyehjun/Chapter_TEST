package self_test;

import java.util.Scanner;

public class Bear_Fish
{
	public static void main(String[] args) {
		Bear bear = new Bear(0,0,2);
		Fish fish = new Fish(15,9,1);
		Scanner sc = new Scanner(System.in);
		
		char dir_list[] = {'동','서','남','북'};
		int random_dir = (int) (Math.random() * 4);
		
		
		int count = 0;// count가 5가 되었을시 반복문 마지막에 0으로 초기화 해준다. 
		Boolean indicator = false;
		do
		{
			count ++;
			if(count>=4)fish.move(dir_list[random_dir]);
			
			System.out.println("가고싶은 방향을 입력하세요(동, 서, 남, 북) : ");
			bear.move(sc.next().charAt(0));//곰이 가고자하는 방향 설정
			
			indicator = bear.coolide(fish);
			
			count =0;
		}while(indicator);//충돌 감지하는 indicator가 true라면 반복문 종료
			
		
	}
}