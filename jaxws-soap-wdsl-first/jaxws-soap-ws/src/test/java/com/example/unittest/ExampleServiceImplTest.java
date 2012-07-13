/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.unittest;

import com.example.Example;
import junit.framework.Assert;
import org.junit.Test;

/**
 *
 * @author danielgronberg
 */
public class ExampleServiceImplTest {
    
    Example serviceImpl = new Example();
    @Test
    public void testSayHelloNullAsName() {
        String result = serviceImpl.sayHello(null);
        Assert.assertTrue(result.equals("Hello!"));
    }
    
    @Test
    public void testSayHello() {
        String result = serviceImpl.sayHello("Diabol");
        Assert.assertTrue(result.equals("Hello Diabol!"));
    }
}
