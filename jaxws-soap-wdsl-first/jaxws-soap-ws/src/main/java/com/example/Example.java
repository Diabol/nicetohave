/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import com.example.jaxws.ExampleService;
import javax.jws.WebService;

/**
 *
 * @author danielgronberg
 */
@WebService(endpointInterface = "com.example.jaxws.ExampleService")
public class Example implements ExampleService{

    @Override
    public String sayHello(String name) {
        if(name != null && !name.equals("")) {
            return "Hello " + name + "!";
        } else {
            return "Hello!";
        }
    }
    
}
