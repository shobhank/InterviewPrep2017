package org.shobhank.matrix;

///*
// * http://www.careercup.com/question?id=6299074475065344
// */
public class MaximumRectangularSubmatrixOf1s {

    /*
    1. Create a stack
    2.a. Push to stack the index of current, if it is empty or if current element is >= top of stack
    2.b if not then pop from stack and calculate area.
        If stack is empty then area = a[top] * i this means there is no bar greater than this present in stack since we store only greater than bar in stack
        If stack is not empty then area = a[top] * (index between current and top in stack = i-s.peek()-1)
    3. If we reached to the end of histogram but stack is still not empty that means we can still get max area, so do as we did in 2.b
     */
    public static int maxHistogram(int a[]){
        java.util.Stack<Integer> s = new java.util.Stack<>();
        int maxArea = 0;
        int area = 0;
        int top = 0;
        int i=0;
        while(i < a.length){
            if(s.isEmpty() || a[i]>=a[s.peek()]){
                s.push(i++);
            } else {
                top = s.pop();

                if(!s.isEmpty())
                    area = a[top] * (i-s.peek()-1);
                else
                    area = a[top] * i;
                if(area>maxArea)
                        maxArea = area;
                }
        }

        while(!s.isEmpty()){
            top = s.pop();

            if(!s.isEmpty())
                area = a[top] * (i-s.peek()-1);
            else
                area = a[top] * i;
            if(area>maxArea)
                maxArea = area;
        }

        return maxArea;
    }

    /*
    Make histograms for values where it is 1
    if element is zero that means the complete bar will be zero so make bar in hist zero
    keep track of max area by calling maxhistogram
     */
    public static int maxRectangleAreaOf1s(int a[][]){

        int hist[] = new int[a[0].length];
        for(int j=0;j<a[0].length;j++){
            hist[j] = a[0][j];
        }

        int maxArea = maxHistogram(hist);
        for(int i=1;i<a.length;i++){
            for(int j=0;j<a[0].length;j++){
                if(a[i][j]==0)
                    hist[j] = 0;
                else
                    hist[j] = hist[j] + 1;
            }
            int area = maxHistogram(hist);
            if(area>maxArea)
                maxArea = area;
        }
        return maxArea;
    }

	public static void main(String args[]){
		int input[][] = {{1,1,1,0},
						 {1,1,1,1},
						 {0,1,1,0},
						 {0,1,1,1},
						 {1,0,0,1},
						 {1,1,1,1}};
//		MaximumRectangularSubmatrixOf1s mrs = new MaximumRectangularSubmatrixOf1s();
//		System.out.println(mrs.maximumFast(input));
//        int a[] = {5,3,0,2,4,1,0,1,8};
        System.out.println(maxRectangleAreaOf1s(input));
	}
}
