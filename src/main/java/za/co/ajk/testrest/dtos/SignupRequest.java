package za.co.ajk.testrest.dtos;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import za.co.ajk.testrest.dtos.PersonalInfo;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class SignupRequest implements Serializable{
    
    private String ss9;
    
    private PersonalInfo personalIdentifiableInfo;
    
    public String getSs9() {
        return ss9;
    }
    
    public void setSs9(String ss9) {
        this.ss9 = ss9;
    }
    
    public PersonalInfo getPersonalIdentifiableInfo() {
        return personalIdentifiableInfo;
    }
    
    public void setPersonalIdentifiableInfo(PersonalInfo personalIdentifiableInfo) {
        this.personalIdentifiableInfo = personalIdentifiableInfo;
    }
}
