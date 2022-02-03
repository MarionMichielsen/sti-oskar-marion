//package sti.oskar.marion.test.unit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sti.oskar.marion.domain.Student;
import sti.oskar.marion.service.StiService;

public class TestService {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:sti-oskar-marion-service.xml");

    private static StiService stiService;

    @Before
    public void before(){
        stiService = (StiService) applicationContext.getBean("stiServiceBean");
    }

    @Test
    public void testStiServiceDependencyInjection(){
        Student student = stiService.createStudent("Carl", "Johansson", 821, "Mac");
        Assert.assertNotNull(student);
    }

}