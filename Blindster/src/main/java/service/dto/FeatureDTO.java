/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FeatureDTO implements Serializable{
    
    @JsonProperty("id")
    private long id;    
    
    @JsonProperty("active")
    private boolean active;    
    
    @NotNull
    @JsonProperty("code")
    private String code;
    
    @NotNull
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("position")
    private int position;    
    
    @NotNull
    @JsonProperty("type")
    private String type;    
   
    @JsonProperty("image")
    private String image;
     
    @JsonProperty("value")
    private String value;
    
    @JsonProperty("productId")
    private long productId;
        
    @JsonProperty("productName")
    private String productName;    
}
