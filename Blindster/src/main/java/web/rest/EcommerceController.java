/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.rest;

import domain.Category;
import domain.Feature;
import domain.Product;
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
import service.FeatureService;
import service.ProductService;
import service.dto.EcommerceCategoryDTO;
import service.dto.EcommerceCategoryProductDTO;
import service.dto.EcommerceProductCategoryDTO;
import service.dto.EcommerceProductDTO;
import service.dto.EcommerceProductFeatureDTO;
import service.mapper.CategoryMapper;
import service.mapper.EcommerceCategoryMapper;
import service.mapper.EcommerceProductMapper;
import service.mapper.ProductMapper;

@RestController
@RequestMapping(value = "/ecommerce")
public class EcommerceController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    FeatureService featureService;

    @Autowired
    EcommerceProductMapper ecommerceProductMapper;

    @Autowired
    CategoryMapper categoryMapper;

    @Autowired
    EcommerceCategoryMapper ecommerceCategoryMapper;

    @Autowired
    ProductMapper productMapper;

    @GetMapping(path = {"/categories"})
    public ResponseEntity<List<EcommerceCategoryDTO>> toListCategories() {
        List<Category> categories = categoryService.toListCategories();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(ecommerceCategoryMapper.toDTOList(new ArrayList<>()), HttpStatus.OK);
        } else {
            List<EcommerceCategoryDTO> result = new ArrayList<EcommerceCategoryDTO>();            
            
            for(Category item : categories){
                EcommerceCategoryDTO e = new EcommerceCategoryDTO();
                e.setCode(item.getCode());
                e.setName(item.getName());
                List<Product> temp = productService.findProductByCategoryIdActive(item.getId());
                List<EcommerceCategoryProductDTO> products = new ArrayList<EcommerceCategoryProductDTO>();
                for(Product p : temp){
                    EcommerceCategoryProductDTO ec = new EcommerceCategoryProductDTO();
                    ec.setCode(p.getCode());
                    ec.setName(p.getName());
                    products.add(ec);
                }
                e.setProducts(products);
                result.add(e);
            }
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @GetMapping(path = {"/product-details/{code}"})
    public ResponseEntity<EcommerceProductDTO> toListProducts(@PathVariable(value = "code") String code) {
        Product product = productService.findProductByCode(code);
        if (product == null) {
            return new ResponseEntity<>(ecommerceProductMapper.toDTO(new Product()), HttpStatus.NOT_FOUND);
        } else {
            
            Category category = categoryService.toCategoryById(product.getCategory().getId());
            long parentId = 0;
            if(category.getCategory() != null){
                parentId = category.getCategory().getId();
            }
            List<Category> categories = categoryService.toListCategoriesByParentId(category.getId(), parentId);            
            EcommerceProductDTO p = ecommerceProductMapper.toDTO(product);
            p.getCategories().removeAll(p.getCategories());
            EcommerceProductCategoryDTO e = new EcommerceProductCategoryDTO();
            e.setCode(category.getCode());
            e.setName(category.getName());
            p.getCategories().add(e);

            for (Category item : categories) {
                if (!e.getCode().equals(item.getCode())) {
                    EcommerceProductCategoryDTO ec = new EcommerceProductCategoryDTO();
                    ec.setCode(item.getCode());
                    ec.setName(item.getName());
                    p.getCategories().add(ec);
                }
            }

            List<Feature> feautures = featureService.toListProductIdActiveOrderBy(product.getId());
            p.getFeatures().removeAll(p.getFeatures());
            for (Feature item : feautures) {
                EcommerceProductFeatureDTO ePFDTO = new EcommerceProductFeatureDTO();
                ePFDTO.setCode(item.getCode());
                ePFDTO.setName(item.getName());
                ePFDTO.setType(item.getType().toString());
                ePFDTO.setImage(item.getImage());
                ePFDTO.setValue(item.getValue());
                p.getFeatures().add(ePFDTO);
            }

            return new ResponseEntity<>(p, HttpStatus.OK);
        }
    }
}
