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
import service.dto.EcommerceCategoryDTO;

@Mapper(componentModel = "spring")
public interface EcommerceCategoryMapper {
    
    EcommerceCategoryMapper INSTANCE = Mappers.getMapper(EcommerceCategoryMapper.class);
    
    EcommerceCategoryDTO toDTO(Category category);
    
    @Mappings({        
        @Mapping(target = "category.code", source = "code"),
        @Mapping(target = "category.name", source = "name"),
        @Mapping(target = "category.products.code", source = "products.code"),
        @Mapping(target = "category.products.name", source = "products.name"),
    })
    default List<EcommerceCategoryDTO> toDTOList(List<Category> categories) {
        if (categories == null) {
            return new ArrayList<>();
        }
        return categories.stream().map(this::toDTO).collect(Collectors.toList());
    }
}
