package com.wang7x.demo;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/business-config.xml",
        "classpath:spring/mvc-core-config.xml"})
@WebAppConfiguration
@ActiveProfiles("test")
public abstract class BaseTest {
}
