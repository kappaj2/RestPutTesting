package za.co.ajk.testrest.dtos;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class Error implements Serializable{
    
    private List<String> codes;
    
    public List<String> getCodes() {
        return codes;
    }
    
    public void setCodes(List<String> codes) {
        this.codes = codes;
    }
}
