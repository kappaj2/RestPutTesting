package za.co.ajk.testrest.testput;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import za.co.ajk.testrest.dtos.PersonalInfo;
import za.co.ajk.testrest.dtos.SignupRequest;


@Component
public class TestPutRestTemplate {
    
    private RestTemplate restTemplate;
    
    @Autowired
    public TestPutRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    
    public void testPut() throws IOException {
        
        PersonalInfo info = new PersonalInfo();
        info.setAddress("1200 Langford Parkway");
        info.setCity("Atlanta");
        info.setState("GA");
        info.setZip("12345");
        info.setDob(new Date());
        info.setFirstName("Lorid");
        info.setLastName("TestL");
        info.setPhone("1234567890");
        info.setSsn4("0012");
        
        SignupRequest signupRequest = new SignupRequest();
        signupRequest.setPersonalIdentifiableInfo(info);
        
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        String resourceUrl = "http://localhost:7777/signup/clients";
        
        HttpEntity<SignupRequest> requestEntity = new HttpEntity<>(signupRequest, headers);

        try {
            ResponseEntity<String> response = restTemplate
                    .exchange(resourceUrl, 
                            HttpMethod.PUT, 
                            requestEntity, 
                            String.class);
            
            response.getStatusCode();
            String responseBody = response.getBody();
            
        } catch (HttpClientErrorException hte) {
            
            System.out.println("Response code : "+hte.getStatusCode());
            
            String resp = hte.getResponseBodyAsString();
            System.out.println(resp);
    
            ObjectMapper mapper = new ObjectMapper();
            JsonNode actualObj = mapper.readTree(resp);
    
            System.out.println("Jason is : "+actualObj);

        }catch(HttpServerErrorException hse){
            System.out.println(hse.getMessage());
            System.out.println(hse.getStatusCode());
            String errorMes = hse.getResponseBodyAsString();
        }
    }
    
    private RequestCallback requestCallback(final SignupRequest signupRequest) {
        return clientHttpRequest -> {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(clientHttpRequest.getBody(), signupRequest);
            clientHttpRequest.getHeaders().add(
                    HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        };
    }
    
}
