package org.shobhank.design.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by shobhanksharma on 5/18/17.
 */
public class ScopeDemo {
    public static void main(String[] args) {
        ApplicationContext context = new FileSystemXmlApplicationContext("spring-context.xml");
        DatabaseConnection connectionS = (DatabaseConnection) context.getBean("dbconn-singleton");
        System.out.println(connectionS.getURLString());
        connectionS.setPort(1432);
        DatabaseConnection connectionS2 = (DatabaseConnection) context.getBean("dbconn-singleton");
        System.out.println(connectionS2.getURLString());

        DatabaseConnection connectionP = (DatabaseConnection) context.getBean("dbconn-proto");
        System.out.println(connectionP.getURLString());
        connectionS.setPort(1432); // this wont affect the bean as it is prototype so not same bean will be returned next time
        DatabaseConnection connectionP2 = (DatabaseConnection) context.getBean("dbconn-proto");
        System.out.println(connectionP2.getURLString());
    }
}

class DatabaseConnection{
    String url;
    int port;
    String user;
    String password;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getURLString(){
        return user+"@"+url+":"+port;
    }
}
