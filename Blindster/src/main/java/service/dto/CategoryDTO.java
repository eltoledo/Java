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
public class CategoryDTO implements Serializable {

    @JsonProperty("id")
    private long id;

    @NotNull
    @JsonProperty("code")    
    public String code;

    @NotNull
    @JsonProperty("name")
    private String name;

    @JsonProperty("position")
    private int position;

    @JsonProperty("parentId")
    private long parentId;
    
    @JsonProperty("parentName")
    private String parentName;    
}
