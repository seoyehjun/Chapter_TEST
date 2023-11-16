package chapter_test;


import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;




public class Controller {
	//이름과 고객 리스트를 주면 Member객체로 반환해주는 함수
	public Member findUsingEnhancedForLoop(String id, List<Member> members) 
	{
		    for (Member member : members) {
		        if (member.getId().equals(id)) {
		            return member;
		        }
		    }
		    return null;
	}
	//맴버 리스트
	List<Member> list = new ArrayList<Member>();
	//그냥 스캐너
	Scanner sc = new Scanner(System.in);
	
	//실행기
	public void run()
	{
		int menu=-1;
		
		
		do {
			System.out.println("--------------메뉴-------------");
			System.out.println("\t 1. 회원 생성");
			System.out.println("\t 2. 회원탈퇴");
			System.out.println("\t 3. 전체목록 조회");
			System.out.println("\t 4. 단일 검색");
			System.out.println("\t 5. 정렬");
			System.out.println("\t 0. 프로그램 종료");
			
			
			try
			{
				System.out.print(">>>");
				//Scanner 객체를 반복문안에 입력하자
				//->잘못된 타입을 전달하면 버퍼안의 값을 할당 안하기 때문에
				menu = new Scanner(System.in).nextInt();
				switch(menu)
				{
				case 1:
					create();
					break;
				case 2:
					delete();
					break;
				case 3:
					list();
					break;
				case 4:
					search();
					break;
				case 5:
					sort();
					break;
				case 0:
					System.out.println("--프로그램 종료--");
					break;
				default:
					System.out.println("※※※목록 안의 숫자를 입력하세요※※※\n");
					break;
				}
			}
			catch(InputMismatchException e)
			{
				System.out.println("※※※제대로 된 값을 입력하세요(숫자 입력 바람)※※※\n");
			}
			
			
		}while(menu != 0);
	}
	
	//case1 맴버 생성
		public void create()
		{
			String name, id, ps ;
			
			
			
			int count =0;
			do{
				
				try
				{
					count =0;//0으로 설정해둔 count는 1,2이외의 숫자가 들어왔을때 증가하여
					//다시 반복해준다
					System.out.print("고객이름 입력: ");
					name = new Scanner(System.in).next();	
					System.out.print("아이디 입력: ");
					id = new Scanner(System.in).next();
					System.out.print("비밀번호 입력: ");
					ps = new Scanner(System.in).next();
					
					System.out.print("구매자 - 1 , 판매자 - 2:");
					int choice = new Scanner(System.in).nextInt();
				
				
					if(choice ==1)
					{
						System.out.print("구매자 주소 입력:");
						list.add(new Customer(id,ps,name,sc.next()));
					}
					else if(choice ==2)
					{
						System.out.print("판매자 가게이름 입력: ");
						list.add(new Seller(id,ps,name,sc.next()));
					}
					else 
					{
						System.out.println("※※※1혹은 2를 선택하세요※※※\n");
						++count;
					}
				}
				catch(InputMismatchException e)
				{
					System.out.println("※※※숫자가 아닙니다※※※\n");
					++count;
				}
			}while(count ==1);
		}
	//case2 맴버 삭제
		public void delete()
		{
			int end_count=0;
			do
			{	
				try
				{
					System.out.print("삭제하고자하는 아이디 입력: ");
					String target_id = sc.next();
					Member target_member=findUsingEnhancedForLoop(target_id,
							list);
					System.out.println(target_member.name+"이(가) 삭제 되었습니다");
					list.remove(list.indexOf(target_member));
					++end_count;//반복문 종료
					}
					catch(NullPointerException e)
					{
						System.out.println("※※※사용자를 찾을 수 없습니다※※※");
					}
			}while(end_count==0);
		}
	//case3 맴버 나열
		public void list()
		{
			Iterator<Member> iterator = list.iterator();
			
			System.out.println("--------------------§ 회원 목록 §--------------------\n");
			while(iterator.hasNext())
			{
				iterator.next().output_inform();
			}
			System.out.println("\n\n");
		}
	//case4맴버 검색
		public void search()
		{
			int end_count=0;
			do
			{	
				try
				{
					System.out.print("찾고자 하는 id 입력: ");
					Scanner sc = new Scanner(System.in);
					String target_id = sc.next();
					
					Member target_member = findUsingEnhancedForLoop(target_id,list);
			
					target_member.output_inform();
					++end_count;
				}
				catch(NullPointerException e)
				{
					System.out.println("※※※사용자를 찾을 수 없습니다※※※");
				}
			}while(end_count==0);
		}
	//case5맴버 정렬
		public void sort()
		{
			Collections.sort(list);
			list();
		}
}
