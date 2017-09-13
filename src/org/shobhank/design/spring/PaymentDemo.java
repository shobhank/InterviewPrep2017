package org.shobhank.design.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by shobhanksharma on 5/18/17.
 */
public class PaymentDemo {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("spring-context.xml");
        IPaymentService paymentService = (IPaymentService) context.getBean("payservice");
        paymentService.pay();
    }
}

interface IPayment{
    public void processPayment();
}

class CashPaymentImpl implements IPayment{

    @Override
    public void processPayment() {
        System.out.println("Paying in cash");
    }
}

interface IPaymentService{
    public void pay();
}

class PaymentServiceImpl implements IPaymentService{

    IPayment payment;

    PaymentServiceImpl(IPayment payment){
        this.payment = payment;
    }

    @Override
    public void pay() {
        payment.processPayment();
    }
}
