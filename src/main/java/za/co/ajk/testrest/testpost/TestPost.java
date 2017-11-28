package za.co.ajk.testrest.testpost;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;


public class TestPost {
    
    public void test() {
        
        final String uri = "http://localhost:9090/ajax/follow-user.html";
        
        FollowUserForm followUserForm = new FollowUserForm();
        followUserForm.setFollow(true);
        followUserForm.setFollowId(51l);
        
        HttpHeaders headers = new HttpHeaders();
        
        HttpEntity request = new HttpEntity(followUserForm, headers);
        
        RestTemplate restTemplate = new RestTemplate();
        
        restTemplate.getMessageConverters().
                
                add(new StringHttpMessageConverter());
        
        FollowUserForm updateTrack = restTemplate.postForObject(uri, request, FollowUserForm.class);
    }
}
