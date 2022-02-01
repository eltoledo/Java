/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.mapper;

import domain.Category;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;
import service.dto.CategoryDTO;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    Category toEntity(CategoryDTO categotyDTO);
    
    @Mappings({
        @Mapping(target = "parentName", source = "category.name")
    })
    CategoryDTO toDTO(Category category);
    
    
    @Mappings({
        @Mapping(target = "parentName", source = "category.name")
    })
    CategoryDTO toDTOProducts(Category category);

    
    default List<CategoryDTO> toDTOList(List<Category> categories) {
        if (categories == null) {
            return new ArrayList<>();
        }
        return categories.stream().map(this::toDTOProducts).collect(Collectors.toList());
    }
}
