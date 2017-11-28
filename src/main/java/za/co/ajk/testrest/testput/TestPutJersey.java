package za.co.ajk.testrest.testput;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import za.co.ajk.testrest.dtos.PersonalInfo;
import za.co.ajk.testrest.dtos.SignupRequest;
import za.co.ajk.testrest.dtos.SignupResponse;


@Component
public class TestPutJersey {
    
    public void testPut() {
        try {
            
            Client client = Client.create();
            
            WebResource webResource = client
                    .resource("http://localhost:7777/signup/clients");
            
            PersonalInfo info = new PersonalInfo();
            info.setAddress("1200 Langford Parkway");
            info.setCity("Atlanta");
            // info.setState("GA");
            info.setZip("12345");
            info.setDob(new Date());
            info.setFirstName("Lorid");
            info.setLastName("TestL");
            info.setPhone("1234567890");
            info.setSsn4("0012");
            
            SignupRequest request = new SignupRequest();
            request.setPersonalIdentifiableInfo(info);
            
            ObjectMapper mapper = new ObjectMapper();
            System.out.println(mapper.writeValueAsString(request));
            
            ClientResponse response = webResource.type("application/json")
                    .put(ClientResponse.class, mapper.writeValueAsString(request));
            
            System.out.println("Response code : " + response.getStatus());
            
            if (response.getStatus() >= 200 && response.getStatus() < 300) {
                SignupResponse signupResponse = response.getEntity(SignupResponse.class);
            } else {
                // Error responseError =  response.getEntity(Error.class);
            }
            
            System.out.println("Output from Server .... \n");
            String output = response.getEntity(String.class);
            System.out.println(output);
            
        } catch (Exception e) {
            
            e.printStackTrace();
            
        }
    }
}
