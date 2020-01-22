import java.util.Random;
public class Ship_Placer {
	//fields
	Random rand = new Random();
	private int bx1;
	private int by1;
	private int bx2;
	private int by2;
	int direction;
	
	//constructor
	public Ship_Placer(int column, int row){
		int bx1 = rand.nextInt(column-1);
	    int by1 = rand.nextInt(row-1);
	    int bx2 = 0;
	    int by2 = 0;
	}
	//methods
	public int[] location(int column, int row){
		direction = rand.nextInt(3);
		boolean done = false;
		if (bx1 == 0 && by1 == 0){
			direction = 3*rand.nextInt(1);
		}else if (bx1 == 0 && by1 == row-1){
			direction = 2*rand.nextInt(1);
		}else if (bx1 == column-1 && by1 == row-1){
			direction = rand.nextInt(1) + 1;
		}else if (bx1 == column-1 && by1 == 0){
			direction = 2*rand.nextInt(1)+1;
		}else if (bx1 == 0){
			while (!done){
				if (direction == 1){
					direction = rand.nextInt(3);
				}else{
					done = true;
				}
			}
		}else if (bx1 == column - 1){
			while (!done){
				if (direction == 0){
					direction = rand.nextInt(3);
				}else{
					done = true;
				}
			}
		}else if (by1 == 0){
			while (!done){
				if (direction == 2){
					direction = rand.nextInt(3);
				}else{
					done = true;
				}
			}
		}else if (by1 == row - 1){
			while (!done){
				if (direction == 3){
					direction = rand.nextInt(3);
				}else{
					done = true;
				}
			}
		}
		switch (direction){
		case 0://1,2
	            bx2 = bx1 + 1;
	            by2 = by1;
	            break;
		case 1://2,1
	            bx2 = bx1 - 1;
	            by2 = by1; 
	            break;
		case 2://2 //1
	            bx2 = bx1; 
	            by2 = by1 - 1;
	            break;
		case 3://1 //2
	            bx2 = bx1; 
	            by2 = by1 + 1;
	            break;
		}
		int [] send = {bx1,bx2,by1,by2};
	    return send;
	}	
}	
