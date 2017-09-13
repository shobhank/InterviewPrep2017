package org.shobhank.design.spring.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by shobhanksharma on 5/19/17.
 */
public class AutowireDemo {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("spring-context.xml");
        IPayService payService = (IPayService) context.getBean("payServiceAW");
        payService.performPayment();
    }
}

interface IPayService{
    void performPayment();
}

class PayServiceImpl implements IPayService{
    private IPaymentStrategy paymentStrategy;
    private double amount;

    @Override
    public void performPayment() {
        paymentStrategy.pay(amount);
    }

    public IPaymentStrategy getPaymentStrategy() {
        return paymentStrategy;
    }

    public void setPaymentStrategy(IPaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public double getAmount() {
        return amount;
    }

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
        System.out.println("Paying by cash " + amount);
    }
}
