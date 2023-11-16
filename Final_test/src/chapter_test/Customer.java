package chapter_test;

public class Customer extends Member {
	protected String delivery_address;

	public Customer(String id, String ps, String name, String delivery_address)
	{
		super(id, ps, name);
		this.delivery_address = delivery_address;
	}
	
	@Override
	public void output_inform()
	{
		super.output_inform();
		System.out.println(" delivery_address: "+delivery_address);
	}
}
