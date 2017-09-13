package org.shobhank.design.spring.autodiscovery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * Created by shobhanksharma on 5/19/17.
 */
public class AutoDiscoveryDemo {
    public static void main(String[] args) {
//        ApplicationContext context = new FileSystemXmlApplicationContext("spring-autodiscovery.xml");
        AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        IPayService payService = (IPayService) context.getBean(PayServiceImpl.class);
        payService.performPayment();
    }
}

interface IPayService{
    void performPayment();
}

@Service
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

@Component
class CashPayment implements IPaymentStrategy{

    @Override
    public void pay(double amount) {
        System.out.println("Annotations Paying by cash " + amount);
    }
}
