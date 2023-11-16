package chapter_test;

public class Seller extends Member {
	protected String store_name;
	
	public Seller(String id, String ps, String name, String store_name)
	{
		super(id, ps, name);
		this.store_name = store_name;
	}
	
	@Override 
	public void output_inform()
	{
		super.output_inform();
		System.out.println(" Store_name: "+store_name);
	}
}
