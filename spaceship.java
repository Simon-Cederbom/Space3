import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.*;



public class spaceship{

	double shipX, shipY, deltaX, deltaY, boostX, boostY, shipDegree, radie, hpX, hpY;
	int boostKey, Right, Left, Shoot;
	double Xscale = 2500;
	double Yscale = 1800;
	String shipPNG;
	String shipNoFirePNG;
	String laserPNG;
	String stonePNG;
	ArrayList<Double> laserX = new ArrayList<Double>();
	ArrayList<Double> laserY = new ArrayList<Double>();
	ArrayList<Double> laserDegree = new ArrayList<Double>();
	double laserDelta = 12;
	boolean hit = false;
	boolean scoreB = true;
	int laserhit = 0;
	int score = 0;
	double stoneX = Math.random()*Xscale;
	double stoneY = Math.random()*Yscale;
	double deltastoneX = (Math.random()*20)-10;
	double deltastoneY = (Math.random()*20)-10;
	
	public void printShip(){
		if(!hit){
		if(StdDraw.isKeyPressed(boostKey)){
			StdDraw.picture(shipX + deltaX,shipY + deltaY,shipPNG,shipDegree -90);
		}
		else{ StdDraw.picture(shipX + deltaX,shipY + deltaY,shipNoFirePNG,shipDegree -90);
		}
		}
		else{ StdDraw.picture(shipX + deltaX,shipY + deltaY,"explosion.png",shipDegree -90);
			deltaX = 0;
			deltaY = 0;
		}
	}
	public void moveShip(){
		if(!hit){
			if(StdDraw.isKeyPressed(boostKey)){
				deltaY = deltaY + boostY;
				deltaX = deltaX + boostX;
			
			}
			deltaX = deltaX*0.97;
			deltaY = deltaY*0.97;
			
			shipX = shipX + deltaX;
			shipY = shipY + deltaY;
		
		}
	}
	
	public void boost(){
		boostX = 3 * Math.cos(Math.toRadians(shipDegree));
		boostY = 3 * Math.sin(Math.toRadians(shipDegree));
	}
	
	public void degree(){
		if(!hit){
			if(StdDraw.isKeyPressed(Left)){
				shipDegree = shipDegree + 10;
			}
			if(StdDraw.isKeyPressed(Right)){
				shipDegree = shipDegree - 10;
			}
		}
	}
	public void side(){
		if(shipX > Xscale+100) shipX = -100;
		if(shipX < -100) shipX = Xscale +100;
		
		if(shipY > Yscale+100) shipY = -100;
		if(shipY < -100) shipY = Yscale +100;
		
	}
	
	public void shipCanon(){
		
		if(StdDraw.isKeyPressed(Shoot) && !hit){
			laserX.add(shipX + boostX);
			laserY.add(shipY + boostY);
			laserDegree.add(shipDegree);
		}
	}
	
	public void moveLaser(){
		if(!hit){	
			for(int i = laserX.size()-1; i>0 ;i--){
				StdDraw.picture(laserX.get(i-1),laserY.get(i-1),laserPNG,laserDegree.get(i-1));
			}
		}
		for(int i = laserX.size(); i>0 ;i--){
			if(laserX.get(i-1) < Xscale + 10 && laserX.get(i-1) > -10 && laserY.get(i-1) < Yscale +10 &&laserY.get(i-1) > -10){
				laserX.add((laserX.get(i-1) + 200*(Math.cos(Math.toRadians(laserDegree.get(i-1)))))+(Math.random())*5);
				laserY.add((laserY.get(i-1) + 200*(Math.sin(Math.toRadians(laserDegree.get(i-1)))))+(Math.random())*5);
				laserDegree.add(laserDegree.get(i-1));
			}
			laserX.remove(i-1);
			laserY.remove(i-1);
			laserDegree.remove(i-1);
		}
	}
	
	public void moveStones(){
		stoneX = stoneX + deltastoneX;
		stoneY = stoneY + deltastoneY;
		if(!hit && laserhit>0){
		StdDraw.picture(stoneX,stoneY,stonePNG);
		}		
	}
		public void sideStone(){
		if(stoneX > Xscale+radie) stoneX = -radie;
		if(stoneX < -radie) stoneX = Xscale +radie;
		
		if(stoneY > Yscale+radie) stoneY = -radie;
		if(stoneY < -radie) stoneY = Yscale +radie;
	}

	public void hp(){
		if(laserhit>0){
			StdDraw.filledRectangle(hpX,hpY,Math.abs(laserhit)*12,20);
		}
	}
}