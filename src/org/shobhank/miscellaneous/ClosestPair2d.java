/**
 *@author
 *shsharma
 */
package org.shobhank.miscellaneous;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

class Point{
    double x;
    double y;
    Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return ("(" + x + "," + y + ")");
    }
}

class Pair
{
    public Point point1 = null;
    public Point point2 = null;
    public double distance = 0.0;

    public Pair(Point point1, Point point2)
    {
        this.point1 = point1;
        this.point2 = point2;
        dist(point1,point2);
    }

    public void dist(Point p1, Point p2){
        distance = Math.hypot((p1.x - p2.x),(p1.y - p2.y));
    }

    public String toString(){
        return "(" + point1.x + "," + point1.y + ") and (" + point2.x + "," + point2.y + ")";
    }
}

public class ClosestPair2d {


    public static void main(String[] args) {
    	List<Point> points = new ArrayList<>();
    	points.add(new Point(0, 2));
    	points.add(new Point(6, 67));
    	points.add(new Point(43, 71));
    	points.add(new Point(39, 107));
    	points.add(new Point(189, 140));

//        int numPoints = (args.length == 0) ? 1000 : Integer.parseInt(args[0]);
//        List<Point> points = new ArrayList<Point>();
//        Random r = new Random();
//        for (int i = 0; i < 5; i++)
//            points.add(new Point(r.nextFloat(), r.nextFloat()));

        System.out.println(bruteForce(points).distance);

        System.out.println(closest(points).distance);
    }

    public static Pair bruteForce(List<Point> points){
        double minDistance = Double.MAX_EXPONENT;
        Pair minPair = null;
        for(int i=0;i<points.size();i++){
            for(int j = i+1;j<points.size();j++){
                Pair pair = new Pair(points.get(i),points.get(j));
                double tempDistance = pair.distance;
                if(tempDistance < minDistance){
                    minDistance = tempDistance;
                    minPair = pair;
                }
            }
        }
        return minPair;
    }

    public static void sortByX(List<Point> points)
    {
        Collections.sort(points, new Comparator<Point>() {
                    public int compare(Point point1, Point point2)
                    {
                        if (point1.x < point2.x)
                            return -1;
                        if (point1.x > point2.x)
                            return 1;
                        return 0;
                    }
                }
        );
    }

    public static void sortByY(List<Point> points)
    {
        Collections.sort(points, new Comparator<Point>() {
                    public int compare(Point point1, Point point2)
                    {
                        if (point1.y < point2.y)
                            return -1;
                        if (point1.y > point2.y)
                            return 1;
                        return 0;
                    }
                }
        );
    }

    public static Pair closestUtil(List<Point> xP, List<Point> yP){

        int n = xP.size();
        // If number of points is less than 4 then use bruteforce
        if(n<=3)
            return bruteForce(xP);

        // 1. Get mid point along x axis and divide pY into pYL and pYR
        int mid = n/2;

        // 2. Get   xL ← points of xP from 1 to ⌈N/2⌉
        // 			xR ← points of xP from ⌈N/2⌉+1 to N
        List<Point> xL = xP.subList(0, mid);
        List<Point> xR = xP.subList(mid, n);

        // 3. find closest in left
        List<Point> tempList = new ArrayList<>(xL);
        sortByY(tempList);
        Pair closest = closestUtil(xL,tempList);

        // 4. find closest in right
        tempList.clear();
        tempList.addAll(xR);
        sortByY(tempList);
        Pair dR = closestUtil(xR, tempList);

        // 5. if dR<closest then dR is closest
        if(dR.distance < closest.distance)
            closest = dR;

        // 6. Find min distance from the delta strip
        // by brute force
        tempList.clear();
        double centerX = xR.get(0).x;
        for(Point p: yP){
            if(Math.abs(centerX) - p.x < closest.distance)
                tempList.add(p);
        }

        Pair closestInStrip = bruteForce(tempList);

        return closestInStrip.distance < closest.distance?closestInStrip:closest;

    }

    public static Pair closest(List<Point> points){
        List<Point> pX = new ArrayList<>(points);
        List<Point> pY = new ArrayList<>(points);

        sortByX(pX);
        sortByY(pY);

        return closestUtil(pX,pY);
    }

}

class ClosestPoints1d {

    public static void closestPoints(int a[]){
        int min = Integer.MAX_VALUE;
        int p=0,q=1;
        Arrays.sort(a);
        for(int i=1;i<a.length;i++){
            if(a[i]-a[i-1]<min){
                p = i-1;
                q = i;
                min = a[q]-a[p];
            }
        }
        System.out.println("Min Distance is "+min + " between " + a[p]
                + " and " + a[q]);
    }


}


