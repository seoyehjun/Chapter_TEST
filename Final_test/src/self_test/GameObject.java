package self_test;

public abstract class GameObject
{
	protected int distance;
	protected int x, y;
	public GameObject(int startX, int startY, int distance)
	{
		this.x = startX;
		this.y = startY;
		this.distance = distance;
	}
	
	public int getX() {return x;}
	public int getY() {return y;}
	//충돌 여부이다 move함수 호출 뒤에 불러주면 될것.
	public boolean coolide(GameObject p)
	{
		if(this.x == p.getX() && this.y == p.getY())
			return true;
		else
			return false;
	}
	public abstract void move(char direction);
	public abstract char getShape();
}