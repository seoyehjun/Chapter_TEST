package chapter_test;

public class Member implements Comparable<Member> {
	protected String id,ps,name;
	
	Member(String id, String ps, String name)
	{
		this.id = id;
		this.ps = ps;
		this.name = name;
	}
	
	public String getId()
	{
		return id;
	}

	public void output_inform()
	{
		System.out.print("이름 : "+name+" 아이디: "+id);
	}
	
	@Override
	public int compareTo(Member o)
	{
		return this.name.compareTo(o.name);
	}
}
