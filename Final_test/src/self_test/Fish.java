package self_test;

public class Fish extends GameObject {

	public Fish(int startX, int startY, int distance) {
		super(startX, startY, distance);
	}

	@Override
	public void move(char direction) {
		
		do
		{
		switch(direction)
		{
			case '동':
				if(super.x + (super.distance)>=20);//배열 20인덱스는 존재하지 않는다..
				System.out.println("범위를 벗어났습니다");
				continue;
			case '서':
				if(super.x-(super.distance)<0);//0인덱스 밑으로는 자리가 없다.
				System.out.println("범위를 벗어났습니다");
				continue;
			case '남':
				if(super.y+(super.distance)>=10);//남쪽은 y값증가  
				System.out.println("범위를 벗어났습니다");
				continue;
			case '북':
				if(super.y-(super.distance)<0);
				System.out.println("범위를 벗어났습니다");
				continue;
		}
		
		switch(direction)
		{
			case '동':
				super.x = super.x + this.distance;
				
			case '서':
				super.x = super.x - this.distance;
			case '남':
				super.y = super.y + this.distance;
			case '북':
				super.y = super.y -this.distance;
		}
		
		}while(true);
	}

	@Override
	public char getShape() {
		return 'F';
	}

}
