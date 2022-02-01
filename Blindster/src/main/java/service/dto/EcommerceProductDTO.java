/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EcommerceProductDTO implements Serializable {

    private String code;

    private String name;

    private String description;
    
    private EcommerceProductCategoryDTO category;
    
    private List<EcommerceProductFeatureDTO> features = new ArrayList<>();
}
