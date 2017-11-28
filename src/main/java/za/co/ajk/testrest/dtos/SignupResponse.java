package za.co.ajk.testrest.dtos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignupResponse implements Serializable{
    
    private String clientKey;
    private String clientLocation;
    private String examLocation;
    private String status;
    
    private PersonalInfo personalIdentifiableInfo;
    
    public String getClientKey() {
        return clientKey;
    }
    
    public void setClientKey(String clientKey) {
        this.clientKey = clientKey;
    }
    
    public String getClientLocation() {
        return clientLocation;
    }
    
    public void setClientLocation(String clientLocation) {
        this.clientLocation = clientLocation;
    }
    
    public String getExamLocation() {
        return examLocation;
    }
    
    public void setExamLocation(String examLocation) {
        this.examLocation = examLocation;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public PersonalInfo getPersonalIdentifiableInfo() {
        return personalIdentifiableInfo;
    }
    
    public void setPersonalIdentifiableInfo(PersonalInfo personalIdentifiableInfo) {
        this.personalIdentifiableInfo = personalIdentifiableInfo;
    }
}
