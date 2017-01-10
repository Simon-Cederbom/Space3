public class spaceSupport{

	public static boolean hitOrMiss(double x1, Double x2, double y1, Double y2, int r1, int r2){
		
		if(Math.abs(x1 -x2) < r1 && Math.abs(y1-y2) < r2){
			return true;
		}
		else return false;
			
	}
	
	public static boolean hitOrMiss(int counter, double x1, double x2, double y1, double y2 ,double r1, double r2){
		
		if(counter>0 && Math.abs(x1-x2)<r1 && Math.abs(y1-y2)<r2){
			return true;
		}
		else return false;

	}
}
