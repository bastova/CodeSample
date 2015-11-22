package project.datacollection.utils;


import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {
        TestConfig.class
})
public class AspectTest {
    
    @Inject
    private AspectUtilClient aspectClient;

    @Test
    public void assertTestConfigIsActive() {
       String message = "Hello";
       String expected = AspectUtil.MESSAGE;
       String actual = aspectClient.applyMessage(message);
       assertEquals(expected, actual);
   }

}
