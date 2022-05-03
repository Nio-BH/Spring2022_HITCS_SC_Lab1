/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P2.turtle;

import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;


public class TurtleSoup {

    /**
     * Draw a square.
     * 
     * @param turtle the turtle context
     * @param sideLength length of each side
     */
    public static void drawSquare(Turtle turtle, int sideLength) {
//        throw new RuntimeException("implement me!");
    	turtle.forward(sideLength);
    	turtle.turn(90);
    	turtle.forward(sideLength);
    	turtle.turn(90);
    	turtle.forward(sideLength);
    	turtle.turn(90);
    	turtle.forward(sideLength);
    }

    /**
     * Determine inside angles of a regular polygon.
     * 
     * There is a simple formula for calculating the inside angles of a polygon;
     * you should derive it and use it here.
     * 
     * @param sides number of sides, where sides must be > 2
     * @return angle in degrees, where 0 <= angle < 360
     */
    public static double calculateRegularPolygonAngle(int sides) {
       // throw new RuntimeException("implement me!");
    	double result;
    	result=180-(360.0/Double.valueOf(sides));
    	return result;
    }

    /**
     * Determine number of sides given the size of interior angles of a regular polygon.
     * 
     * There is a simple formula for this; you should derive it and use it here.
     * Make sure you *properly round* the answer before you return it (see java.lang.Math).
     * HINT: it is easier if you think about the exterior angles.
     * 
     * @param angle size of interior angles in degrees, where 0 < angle < 180
     * @return the integer number of sides
     */
    public static int calculatePolygonSidesFromAngle(double angle) {
        //throw new RuntimeException("implement me!");
    	int result=0;
    	result=360/(int)(180-angle);
    	return result;
    }

    /**
     * Given the number of sides, draw a regular polygon.
     * 
     * (0,0) is the lower-left corner of the polygon; use only right-hand turns to draw.
     * 
     * @param turtle the turtle context
     * @param sides number of sides of the polygon to draw
     * @param sideLength length of each side
     */
    public static void drawRegularPolygon(Turtle turtle, int sides, int sideLength) {
       // throw new RuntimeException("implement me!");
    	double angle=180.0-calculateRegularPolygonAngle(sides);
    	for(int i=0;i<sides;i++) {
    		turtle.forward(sideLength);
    		turtle.turn(angle);
    	}
    }

    /**
     * Given the current direction, current location, and a target location, calculate the Bearing
     * towards the target point.
     * 
     * The return value is the angle input to turn() that would point the turtle in the direction of
     * the target point (targetX,targetY), given that the turtle is already at the point
     * (currentX,currentY) and is facing at angle currentBearing. The angle must be expressed in
     * degrees, where 0 <= angle < 360. 
     *
     * HINT: look at http://en.wikipedia.org/wiki/Atan2 and Java's math libraries
     * 
     * @param currentBearing current direction as clockwise from north
     * @param currentX current location x-coordinate
     * @param currentY current location y-coordinate
     * @param targetX target point x-coordinate
     * @param targetY target point y-coordinate
     * @return adjustment to Bearing (right turn amount) to get to target point,
     *         must be 0 <= angle < 360
     */
    public static double calculateBearingToPoint(double currentBearing, int currentX, int currentY,
                                                 int targetX, int targetY) {
        //throw new RuntimeException("implement me!");
    	int m,n,flag1=0,flag2=0;
    	double s,b;
    	if(targetX>=currentX) {
    		m=targetX-currentX;
    		flag1=0;
    	}
    	else {
    		m=currentX-targetX;
    		flag1=1;
    	}
    	if(targetY>=currentY) {
    		n=targetY-currentY;
    		flag2=0;
    	}
    	else {
    		n=currentY-targetY;
    		flag2=1;
    	}
    	s=Math.sqrt(Double.valueOf(m*m+n*n));
    	if(flag1==0&&flag2==0) {
    		b=Math.toDegrees(Math.asin(Double.valueOf(m)/s));
    		if(b>=currentBearing) {
    			return b-currentBearing;
    		}
    		else {
    			return 360-(currentBearing-b);
    		}
    	}
    	if(flag1==0&&flag2==1) {
    		b=90+Math.toDegrees(Math.asin(Double.valueOf(n)/s));
    		if(b>=currentBearing) {
    			return b-currentBearing;
    		}
    		else {
    			return 360-(currentBearing-b);
    		}
    	}
    	if(flag1==1&&flag2==1) {
    		b=360-(90+Math.toDegrees(Math.asin(Double.valueOf(n)/s)));
    		if(b>=currentBearing) {
    			return b-currentBearing;
    		}
    		else {
    			return 360-(currentBearing-b);
    		}
    	}
    	if(flag1==1&&flag2==0) {
    		b=360-Math.toDegrees(Math.asin(Double.valueOf(m)/s));
    		if(b>=currentBearing) {
    			return b-currentBearing;
    		}
    		else {
    			return 360-(currentBearing-b);
    		}
    	}
    	return 0;
    }
    public static double calculateBearingToPoint(double currentBearing, double currentX, double currentY,
            double targetX, double targetY) {
//throw new RuntimeException("implement me!");
double m,n,flag1=0,flag2=0;
double s,b;
if(targetX>=currentX) {
m=targetX-currentX;
flag1=0;
}
else {
m=currentX-targetX;
flag1=1;
}
if(targetY>=currentY) {
n=targetY-currentY;
flag2=0;
}
else {
n=currentY-targetY;
flag2=1;
}
s=Math.sqrt(Double.valueOf(m*m+n*n));
if(flag1==0&&flag2==0) {
b=Math.toDegrees(Math.asin(Double.valueOf(m)/s));
if(b>=currentBearing) {
return b-currentBearing;
}
else {
return 360-(currentBearing-b);
}
}
if(flag1==0&&flag2==1) {
b=90+Math.toDegrees(Math.asin(Double.valueOf(n)/s));
if(b>=currentBearing) {
return b-currentBearing;
}
else {
return 360-(currentBearing-b);
}
}
if(flag1==1&&flag2==1) {
b=360-(90+Math.toDegrees(Math.asin(Double.valueOf(n)/s)));
if(b>=currentBearing) {
return b-currentBearing;
}
else {
return 360-(currentBearing-b);
}
}
if(flag1==1&&flag2==0) {
b=360-Math.toDegrees(Math.asin(Double.valueOf(m)/s));
if(b>=currentBearing) {
return b-currentBearing;
}
else {
return 360-(currentBearing-b);
}
}
return 0;
}
    public static double calculateDistenseToPoint(double currentX, double currentY,
            double targetX, double targetY) {
    	double result=0,m,n;
    	if(targetX>=currentX) {
    		m=targetX-currentX;
    		}
    		else {
    		m=currentX-targetX;
    		}
    		if(targetY>=currentY) {
    		n=targetY-currentY;
    		}
    		else {
    		n=currentY-targetY;
    		}
    		result=Math.sqrt(Double.valueOf(m*m+n*n));
    		return result;
    }
    /**
     * Given a sequence of points, calculate the Bearing adjustments needed to get from each point
     * to the next.
     * 
     * Assumes that the turtle starts at the first point given, facing up (i.e. 0 degrees).
     * For each subsequent point, assumes that the turtle is still facing in the direction it was
     * facing when it moved to the previous point.
     * You should use calculateBearingToPoint() to implement this function.
     * 
     * @param xCoords list of x-coordinates (must be same length as yCoords)
     * @param yCoords list of y-coordinates (must be same length as xCoords)
     * @return list of Bearing adjustments between points, of size 0 if (# of points) == 0,
     *         otherwise of size (# of points) - 1
     */
    public static List<Double> calculateBearings(List<Integer> xCoords, List<Integer> yCoords) {
        //throw new RuntimeException("implement me!");
    	int n=xCoords.size()-1;
    	double CurrentBearing=0;
    	List<Double> result=new ArrayList<>();
    	for(int i=0;i<n;i++) {
    		if(i==0) {
    		result.add(calculateBearingToPoint(0,xCoords.get(i),yCoords.get(i),xCoords.get(i+1),yCoords.get(i+1)));
    		CurrentBearing+=result.get(i);
    		if(CurrentBearing>=360) {
    			CurrentBearing-=360;
    		}
    		}
    		else {
        		result.add(calculateBearingToPoint(CurrentBearing,xCoords.get(i),yCoords.get(i),xCoords.get(i+1),yCoords.get(i+1)));
        		CurrentBearing+=result.get(i);
        		if(CurrentBearing>=360) {
        			CurrentBearing-=360;
        		}
    		}
    		}
    	return result;
    }
    
    /**
     * Given a set of points, compute the convex hull, the smallest convex set that contains all the points 
     * in a set of input points. The gift-wrapping algorithm is one simple approach to this problem, and 
     * there are other algorithms too.
     * 
     * @param points a set of points with xCoords and yCoords. It might be empty, contain only 1 point, two points or more.
     * @return minimal subset of the input points that form the vertices of the perimeter of the convex hull
     */
    public static Set<Point> convexHull(Set<Point> points) {
        //throw new RuntimeException("implement me!");
    	int n=points.size(),i,minIndex;
    	//Set<Point> result=new HashSet<>();
    	if(n==0||n==1||n==2)return points;
    	List<Point> POINTS=new ArrayList<>(points);
    	List<Point> RESULT=new ArrayList<>();
    	int flag[]=new int[n];
    	double Bearing=360,currentBearing;
    	Point now = null;
    	for(i=0;i<n;i++) {	//找出x最小的点，一定在凸包里
    		if(i==0) {
    			now=POINTS.get(i);
    		}
    		else {
    			if(now.x()>=POINTS.get(i).x()) {
    				if(now.x()==POINTS.get(i).x()) {
    					if(now.y()>POINTS.get(i).y()) {
    						now=POINTS.get(i);
    					}
    					else continue;
    				}
    				else {
    				now=POINTS.get(i);
    				}
    			}
    		}
    	}
    	RESULT.add(now);
    	flag[POINTS.indexOf(now)]=1;
    	for(i=0,Bearing=360,minIndex=-1;i<n;i++) {
    		if(flag[i]==0&&(calculateBearingToPoint(0.0, now.x(), now.y(), POINTS.get(i).x(), POINTS.get(i).y())<=Bearing)) {
    			if(calculateBearingToPoint(0.0, now.x(), now.y(), POINTS.get(i).x(), POINTS.get(i).y())==Bearing) {
    				if(calculateDistenseToPoint(now.x(), now.y(), POINTS.get(i).x(), POINTS.get(i).y())>calculateDistenseToPoint(now.x(), now.y(), POINTS.get(minIndex).x(), POINTS.get(minIndex).y())) {
    					minIndex=i;
    					continue;
    				}
    				else {
    					continue;
    				}
    			}
    			Bearing=calculateBearingToPoint(0.0, now.x(), now.y(), POINTS.get(i).x(), POINTS.get(i).y());
    			minIndex=i;
    		}
    	}
    	RESULT.add(POINTS.get(minIndex));
    	flag[minIndex]=2;
    	now=POINTS.get(minIndex);
    	currentBearing=Bearing;
    	while(POINTS.get(minIndex)!=RESULT.get(0)) {
    		for(i=0,Bearing=360,minIndex=-1;i<n;i++) {
        		if(flag[i]!=2&&(calculateBearingToPoint(currentBearing, now.x(), now.y(), POINTS.get(i).x(), POINTS.get(i).y())<=Bearing)) {
        			if(calculateBearingToPoint(currentBearing, now.x(), now.y(), POINTS.get(i).x(), POINTS.get(i).y())==Bearing) {
        				if(calculateDistenseToPoint(now.x(), now.y(), POINTS.get(i).x(), POINTS.get(i).y())>calculateDistenseToPoint(now.x(), now.y(), POINTS.get(minIndex).x(), POINTS.get(minIndex).y())) {
        					minIndex=i;
        					continue;
        				}
        				else {
        					continue;
        				}
        			}
        			Bearing=calculateBearingToPoint(currentBearing, now.x(), now.y(), POINTS.get(i).x(), POINTS.get(i).y());
        			minIndex=i;
        		}
        	}
        	
        	if(flag[minIndex]==0) {
        		RESULT.add(POINTS.get(minIndex));
        		flag[minIndex]=2;}
        	now=POINTS.get(minIndex);
        	currentBearing=Bearing;
    	}
    	Set<Point> result=new HashSet<>(RESULT);
    	return result;
    }
    
    /**
     * Draw your personal, custom art.
     * 
     * Many interesting images can be drawn using the simple implementation of a turtle.  For this
     * function, draw something interesting; the complexity can be as little or as much as you want.
     * 
     * @param turtle the turtle context
     */
    public static void drawPersonalArt(Turtle turtle) {
        //throw new RuntimeException("implement me!");
    	int i=0,n=6;
    	double move=22.5;
    	for(;i<n;i++) {
    	turtle.color(PenColor.ORANGE);
    	turtle.forward(36);
    	turtle.turn(75);
    	turtle.forward(51);
    	turtle.turn(120);
    	turtle.forward(51);
    	turtle.turn(75);
    	turtle.forward(36);
    	turtle.turn(181);
    	turtle.color(PenColor.BLUE);
    	turtle.forward(36);
    	turtle.turn(75);
    	turtle.forward(51);
    	turtle.turn(120);
    	turtle.forward(51);
    	turtle.turn(75);
    	turtle.forward(36);
    	turtle.turn(181);
    	turtle.color(PenColor.MAGENTA);
    	turtle.forward(36);
    	turtle.turn(75);
    	turtle.forward(51);
    	turtle.turn(120);
    	turtle.forward(51);
    	turtle.turn(75);
    	turtle.forward(36);
    	turtle.turn(181);
    	turtle.color(PenColor.GREEN);
    	turtle.forward(36);
    	turtle.turn(75);
    	turtle.forward(51);
    	turtle.turn(120);
    	turtle.forward(51);
    	turtle.turn(75);
    	turtle.forward(36);
    	turtle.turn(181);
    	turtle.turn(move);
    	}
    }

    /**
     * Main method.
     * 
     * This is the method that runs when you run "java TurtleSoup".
     * 
     * @param args unused
     */
    public static void main(String args[]) {
        DrawableTurtle turtle = new DrawableTurtle();

        //drawSquare(turtle, 40);
       // drawRegularPolygon(turtle, 5, 60);
        // draw the window
        drawPersonalArt(turtle);
        turtle.draw();
    }

}
