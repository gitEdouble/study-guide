package com.ps.util;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import com.ps.config.PetConfigClass2;
import com.ps.config.TestAppConfig2;

//@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestAppConfig2.class, PetConfigClass2.class})

public class ContextLogger {
    private Logger logger = LoggerFactory.getLogger(ContextLogger.class);

    private ConfigurableApplicationContext ctx;

    
    @Test
    public void listBeans(){
    	ctx = new ClassPathXmlApplicationContext("classpath:spring/test-cfg.xml");
    	for (String beanName : ctx.getBeanDefinitionNames()){
	    	logger.info("Bean " + beanName + " of type " + ctx.getBean(beanName).getClass().getSimpleName());
	    }
    }
}
