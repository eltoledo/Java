/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.rest;

import domain.Feature;
import domain.Product;
import java.util.List;
import service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.ProductService;
import service.dto.FeatureDTO;
import service.mapper.FeatureMapper;

@RestController
@RequestMapping(value = "/products/{productId}/features")
public class FeatureController {
    
    @Autowired
    FeatureService featureService;
    
    @Autowired
    ProductService productService;
    
    @Autowired
    FeatureMapper featureMapper;
    
    @GetMapping
    public ResponseEntity<List<FeatureDTO>> toListFeatures(@PathVariable(value = "productId") long productId){
        return new ResponseEntity<>(featureMapper.toDtoList(featureService.toListFeatures(productId)), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<FeatureDTO> add(@Validated @RequestBody FeatureDTO featureDTO, @PathVariable(value = "productId") long productId){
        Product product = productService.toListById(productId);
        featureDTO = featureMapper.toDTO(featureService.add(featureMapper.toEntity(featureDTO)));
        featureDTO.setProductName(product.getName());
        return new ResponseEntity<>(featureDTO, HttpStatus.CREATED);
    }
    
    @PutMapping(path = {"/{id}"})
    public ResponseEntity<FeatureDTO> edit(@Validated @RequestBody FeatureDTO featureDTO, @PathVariable(value = "id") long id){
        featureDTO.setId(id);
        return new ResponseEntity<>(featureMapper.toDTO(featureService.edit(featureMapper.toEntity(featureDTO))), HttpStatus.OK);
    }
    
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<FeatureDTO> delete(@PathVariable(value = "id") long id){
        return new ResponseEntity<>(featureMapper.toDTO(featureService.delete(id)), HttpStatus.OK);
    }
}
