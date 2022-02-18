/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web.rest;

import domain.Category;
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
import service.dto.CategoryDTO;
import service.mapper.CategoryMapper;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryMapper categoryMapper;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> toList() {
        return new ResponseEntity<>(categoryMapper.toDTOList(categoryService.toList()), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> add(@Validated @RequestBody CategoryDTO categoryDTO) {
        if (categoryDTO.getParentId() == 0) {
            return new ResponseEntity<>(categoryMapper.toDTO(categoryService.add(categoryMapper.toEntity(categoryDTO))), HttpStatus.CREATED);
        } else {
            Category cat = categoryService.toCategoryById(categoryDTO.getParentId());
            Category category = categoryMapper.toEntity(categoryDTO);
            category.setCategory(cat);
            categoryDTO = categoryMapper.toDTO(categoryService.add(category));
            categoryDTO.setParentName(cat.getName());
            categoryDTO.setParentId(cat.getId());
            return new ResponseEntity<>(categoryDTO, HttpStatus.CREATED);
        }
    }

    @PutMapping(path = {"/{id}"})
    public ResponseEntity<CategoryDTO> edit(@Validated @RequestBody CategoryDTO categoryDTO, @PathVariable(value = "id") long id) {
        categoryDTO.setId(id);
        return new ResponseEntity<>(categoryMapper.toDTO(categoryService.edit(categoryMapper.toEntity(categoryDTO))), HttpStatus.OK);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<CategoryDTO> delete(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(categoryMapper.toDTO(categoryService.delete(id)), HttpStatus.OK);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<CategoryDTO> toCategoryById(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(categoryMapper.toDTO(categoryService.toCategoryById(id)), HttpStatus.OK);
    }
}
