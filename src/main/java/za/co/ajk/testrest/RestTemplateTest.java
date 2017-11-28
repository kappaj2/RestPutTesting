package za.co.ajk.testrest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import za.co.ajk.testrest.config.RestTemplateFactory;
import za.co.ajk.testrest.testput.TestPutJersey;
import za.co.ajk.testrest.testput.TestPutRestTemplate;


/**
 * Class to run the application locally. 
 */
public class RestTemplateTest {
    
    private static TestPutRestTemplate testPutRestTemplate;
    private static TestPutJersey testPutJersey;
    
    public static void main(String[] args) throws Exception{
        
        ApplicationContext context = new AnnotationConfigApplicationContext(RestTemplateFactory.class);
        
        /*
            Wire both Jersey and RestTemplate based components.
         */
        testPutRestTemplate = (TestPutRestTemplate)context.getBean("testPutRestTemplate");
        testPutJersey = (TestPutJersey)context.getBean("testPutJersey");
        
        /*
            Test with RestTemplate
         */
        testPutRestTemplate.testPut();
    
        /*
            Test with Jersey base client
         */
       // testPutJersey.testPut();
    }
}
