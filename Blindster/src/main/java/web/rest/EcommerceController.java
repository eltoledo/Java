/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.rest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.CategoryService;
import service.ProductService;
import service.dto.EcommerceCategoryDTO;
import service.dto.EcommerceProductDTO;
import service.mapper.EcommerceCategoryMapper;
import service.mapper.EcommerceProductMapper;

@RestController
@RequestMapping(value = "/ecommerce")
public class EcommerceController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    EcommerceProductMapper ecommerceProductMapper;

    @Autowired
    EcommerceCategoryMapper ecommerceCategoryMapper;

    @GetMapping(path = {"/categories"})
    public ResponseEntity<List<EcommerceCategoryDTO>> toListCategories() {
        if (categoryService.toListCategories().isEmpty()) {
            return new ResponseEntity<>(ecommerceCategoryMapper.toDTOList(new ArrayList<>()), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(ecommerceCategoryMapper.toDTOList(categoryService.toListCategories()), HttpStatus.OK);
        }
    }

    @GetMapping(path = {"/product-details/{code}"})
    public ResponseEntity<List<EcommerceProductDTO>> toListProducts(@PathVariable(value = "code") String code) {
        if (productService.toListProducts(code).isEmpty()) {
            return new ResponseEntity<>(ecommerceProductMapper.toDTOList(new ArrayList<>()), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(ecommerceProductMapper.toDTOList(productService.toListProducts(code)), HttpStatus.OK);
        }
    }
}
