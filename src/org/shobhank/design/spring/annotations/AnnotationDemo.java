package org.shobhank.design.spring.annotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by shobhanksharma on 5/19/17.
 */
public class AnnotationDemo {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("spring-context.xml");
        IPayService payService = (IPayService) context.getBean("payServiceANN");
        payService.performPayment();
    }
}

interface IPayService{
    void performPayment();
}

class PayServiceImpl implements IPayService{

    @Autowired
    private IPaymentStrategy paymentStrategy;
    private double amount;

    @Override
    public void performPayment() {
        paymentStrategy.pay(amount);
    }

    /*
    Note that no need of setters now
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }
}

interface IPaymentStrategy{
    void pay(double amount);
}

class CashPayment implements IPaymentStrategy{

    @Override
    public void pay(double amount) {
        System.out.println("Annotations Paying by cash " + amount);
    }
}
