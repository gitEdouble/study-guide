package com.ps.repo;

import static org.junit.Assert.assertNotNull;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ps.config.TestFileConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestFileConfig.class})
@ActiveProfiles("dev")
public class TestDbLoadFiles {

	@Autowired DataSource dataSource;
	
    @Test
    public void setUp() {
        assertNotNull(dataSource);
    }

}
