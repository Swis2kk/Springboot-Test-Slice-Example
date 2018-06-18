package org.example.service;

import org.example.common.custom.CustomTestAnnotation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@CustomTestAnnotation
public class CustomServiceTest {

    @Autowired
    private CustomService service;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void methodShouldPerform() {
        service.doSomething("Something is done...");
    }
}
