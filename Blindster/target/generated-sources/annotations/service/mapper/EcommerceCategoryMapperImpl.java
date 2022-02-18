package service.mapper;

import domain.Category;
import domain.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import service.dto.EcommerceCategoryDTO;
import service.dto.EcommerceCategoryProductDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-10T07:53:37-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16 (Oracle Corporation)"
)
@Component
public class EcommerceCategoryMapperImpl implements EcommerceCategoryMapper {

    @Override
    public EcommerceCategoryDTO toDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        EcommerceCategoryDTO ecommerceCategoryDTO = new EcommerceCategoryDTO();

        ecommerceCategoryDTO.setCode( category.getCode() );
        ecommerceCategoryDTO.setName( category.getName() );
        ecommerceCategoryDTO.setProducts( productListToEcommerceCategoryProductDTOList( category.getProducts() ) );

        return ecommerceCategoryDTO;
    }

    protected EcommerceCategoryProductDTO productToEcommerceCategoryProductDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        EcommerceCategoryProductDTO ecommerceCategoryProductDTO = new EcommerceCategoryProductDTO();

        ecommerceCategoryProductDTO.setCode( product.getCode() );
        ecommerceCategoryProductDTO.setName( product.getName() );

        return ecommerceCategoryProductDTO;
    }

    protected List<EcommerceCategoryProductDTO> productListToEcommerceCategoryProductDTOList(List<Product> list) {
        if ( list == null ) {
            return null;
        }

        List<EcommerceCategoryProductDTO> list1 = new ArrayList<EcommerceCategoryProductDTO>( list.size() );
        for ( Product product : list ) {
            list1.add( productToEcommerceCategoryProductDTO( product ) );
        }

        return list1;
    }
}
