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
public class ProductDTO implements Serializable {

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

    @NotNull
    @JsonProperty("description")
    private String description;

    @JsonProperty("position")
    private int position;

    @JsonProperty("categoryId")
    private long categoryId;

    @JsonIgnore
    @JsonProperty("categoryName")
    private String categoryName;
}
