/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service.mapper;

import domain.Product;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import service.dto.EcommerceProductDTO;

@Mapper(componentModel = "spring")
public interface EcommerceProductMapper {

    EcommerceProductMapper INSTANCE = Mappers.getMapper(EcommerceProductMapper.class);

    EcommerceProductDTO toDTO(Product product);    
}
