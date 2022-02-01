/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.rest;

import domain.Category;
import domain.Product;
import java.util.List;
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
import service.CategoryService;
import service.ProductService;
import service.dto.ProductDTO;
import service.mapper.ProductMapper;


@RestController
@RequestMapping(value = "/products")
public class ProductController {
    
    @Autowired
    ProductService productService;
    
    @Autowired
    CategoryService categoryService;
    
    @Autowired
    ProductMapper productMapper;
    
    @GetMapping
    public ResponseEntity<List<ProductDTO>> toList(){
        return new ResponseEntity<>(productMapper.toDtoList(productService.toList()), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<ProductDTO> add(@Validated @RequestBody ProductDTO productDTO){
        Category category = categoryService.toCategoryById(productDTO.getCategoryId());
        productDTO = productMapper.toDTO(productService.add(productMapper.toEntity(productDTO)));
        productDTO.setCategoryName(category.getName());
        return new ResponseEntity<>(productDTO, HttpStatus.CREATED);
    }
    
    @PutMapping(path = {"/{id}"})
    public ResponseEntity<ProductDTO> edit(@Validated @RequestBody ProductDTO productDTO, @PathVariable(value = "id") long id){
        productDTO.setId(id);
        return new ResponseEntity<>(productMapper.toDTO(productService.edit(productMapper.toEntity(productDTO))), HttpStatus.OK);
    }
    
    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<ProductDTO> delete(@PathVariable(value = "id") long id){
        return new ResponseEntity<>(productMapper.toDTO(productService.delete(id)), HttpStatus.OK);
    }
    
    @GetMapping(path = {"/{id}"})
    public ResponseEntity<ProductDTO> toListById(@PathVariable(value = "id") long id){
        return new ResponseEntity<>(productMapper.toDTO(productService.toListById(id)), HttpStatus.OK);
    }
}
