package za.co.ajk.testrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


/**
 * Configuration class defining the Spring package scanning. Is registered with RestTemplateTest as the 
 * configuration class to bootstrap the context.
 */
@Configuration
@ComponentScan("za.co.ajk")
public class RestTemplateFactory {
    
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate(getClientHttpRequestFactory());
    }
    
    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        int timeout = 5000;
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory
                = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(timeout);
        return clientHttpRequestFactory;
    }
    
}
