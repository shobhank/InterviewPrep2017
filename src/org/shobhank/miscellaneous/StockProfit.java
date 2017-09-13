package org.shobhank.miscellaneous;

/**
 * Created by shobhanksharma on 3/25/17.
 */

/*
the best profit I could have made from 1 purchase and 1 sale of 1 Apple stock yesterday.
have to buy before sell
 */
public class StockProfit {
    public static void main(String as[]){
        int a[] = {100, 180, 260, 310, 40, 535, 695};
        System.out.println(maxProfit(a));
        System.out.println(efficientMaxProfit(a));
    }

    public static int maxProfit(int a[]){
        int maxProfit = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            int buyPrice = a[i];
            for(int j=i+1;j<a.length;j++){
                int profit = a[j]-buyPrice;
                if(profit>maxProfit)
                    maxProfit = profit;
            }
        }
        return maxProfit;
    }

    public static int efficientMaxProfit(int a[]){
        int minElement = a[0];
        int maxProfit = Integer.MIN_VALUE;
        for(int i=0;i<a.length;i++){
            if(a[i]-minElement > maxProfit)
                maxProfit = a[i]-minElement;
            if(a[i]<minElement)
                minElement = a[i];
        }
        return maxProfit;
    }
}
