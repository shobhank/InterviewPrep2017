package java8.Lambda;

import com.sun.org.apache.xpath.internal.operations.Div;

public class Math {
    public static void main(String[] args) {
        MathOperation add = (a,b) -> (a+b);
        MathOperation sub = (a,b) -> a-b;
        MathOperation mult = (a,b) -> a*b;
        MathOperation div = (a,b) -> {
            if(b==0)
                return 0;
            return a/b;
        };
        System.out.println(new Math().operate(4,0,add));
        System.out.println(div.operate(4,3));
    }

    interface MathOperation {
        int operate(int x, int y);
    }

    int operate(int a, int b, MathOperation operation){
        return operation.operate(a,b);
    }
}



