/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.integrationtest;

import com.example.jaxws.ExampleService;
import com.example.jaxws.ExampleService_Service;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import junit.framework.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author danielgronberg
 */
@RunWith(Arquillian.class)
public class ExampleServiceTest {
    private static ExampleService_Service service;
    private static ExampleService port;
    private static String wsdlUrl = "http://127.0.0.1:8080/epsos-wsgen-1.0-SNAPSHOT/ExampleService";
    
    @Deployment(testable = false)
    public static Archive<WebArchive> getArchive() {
        return ShrinkWrap.createFromZipFile(WebArchive.class, new File("../jaxws-soap-ws/target/jaxws-soap-ws-1.0-SNAPSHOT.war"));
    }
    
    @BeforeClass
    public static void prepare() throws MalformedURLException {   
        service = new ExampleService_Service(new URL(wsdlUrl), new QName("http://example.com/", "ExampleService"));
        port = service.getExamplePort();
    }
    
    @Test
    public void testSayHelloWithName() {
        String name = "my little friend";
        String response = port.sayHello(name);
        Assert.assertTrue(response.equals("Hello " + name + "!"));
    }
}
