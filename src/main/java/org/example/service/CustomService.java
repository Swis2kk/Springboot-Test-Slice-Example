package org.example.service;

import org.example.anntatioins.CustomAnnotation;
import org.springframework.stereotype.Service;

@Service
@CustomAnnotation
public class CustomService {

    public void doSomething(String str) {
        System.out.println(str);
    }

}
