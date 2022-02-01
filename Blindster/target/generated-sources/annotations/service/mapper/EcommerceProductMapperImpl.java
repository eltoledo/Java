package service.mapper;

import domain.Category;
import domain.Feature;
import domain.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import service.dto.EcommerceProductCategoryDTO;
import service.dto.EcommerceProductDTO;
import service.dto.EcommerceProductFeatureDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-01T08:00:34-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16 (Oracle Corporation)"
)
@Component
public class EcommerceProductMapperImpl implements EcommerceProductMapper {

    @Override
    public EcommerceProductDTO toDTO(Product product) {
        if ( product == null ) {
            return null;
        }

        EcommerceProductDTO ecommerceProductDTO = new EcommerceProductDTO();

        ecommerceProductDTO.setCode( product.getCode() );
        ecommerceProductDTO.setName( product.getName() );
        ecommerceProductDTO.setDescription( product.getDescription() );
        ecommerceProductDTO.setCategory( categoryToEcommerceProductCategoryDTO( product.getCategory() ) );
        ecommerceProductDTO.setFeatures( featureListToEcommerceProductFeatureDTOList( product.getFeatures() ) );

        return ecommerceProductDTO;
    }

    protected EcommerceProductCategoryDTO categoryToEcommerceProductCategoryDTO(Category category) {
        if ( category == null ) {
            return null;
        }

        EcommerceProductCategoryDTO ecommerceProductCategoryDTO = new EcommerceProductCategoryDTO();

        ecommerceProductCategoryDTO.setCode( category.getCode() );
        ecommerceProductCategoryDTO.setName( category.getName() );

        return ecommerceProductCategoryDTO;
    }

    protected EcommerceProductFeatureDTO featureToEcommerceProductFeatureDTO(Feature feature) {
        if ( feature == null ) {
            return null;
        }

        EcommerceProductFeatureDTO ecommerceProductFeatureDTO = new EcommerceProductFeatureDTO();

        ecommerceProductFeatureDTO.setCode( feature.getCode() );
        ecommerceProductFeatureDTO.setName( feature.getName() );
        ecommerceProductFeatureDTO.setImage( feature.getImage() );
        ecommerceProductFeatureDTO.setValue( feature.getValue() );

        return ecommerceProductFeatureDTO;
    }

    protected List<EcommerceProductFeatureDTO> featureListToEcommerceProductFeatureDTOList(List<Feature> list) {
        if ( list == null ) {
            return null;
        }

        List<EcommerceProductFeatureDTO> list1 = new ArrayList<EcommerceProductFeatureDTO>( list.size() );
        for ( Feature feature : list ) {
            list1.add( featureToEcommerceProductFeatureDTO( feature ) );
        }

        return list1;
    }
}
