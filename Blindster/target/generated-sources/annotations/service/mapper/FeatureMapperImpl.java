package service.mapper;

import domain.Feature;
import domain.Product;
import domain.Type;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import service.dto.FeatureDTO;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-01T08:00:34-0500",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 16 (Oracle Corporation)"
)
@Component
public class FeatureMapperImpl implements FeatureMapper {

    @Override
    public Feature toEntity(FeatureDTO featureDTO) {
        if ( featureDTO == null ) {
            return null;
        }

        Feature feature = new Feature();

        feature.setId( featureDTO.getId() );
        feature.setActive( featureDTO.isActive() );
        feature.setCode( featureDTO.getCode() );
        feature.setName( featureDTO.getName() );
        feature.setPosition( featureDTO.getPosition() );
        if ( featureDTO.getType() != null ) {
            feature.setType( Enum.valueOf( Type.class, featureDTO.getType() ) );
        }
        feature.setImage( featureDTO.getImage() );
        feature.setValue( featureDTO.getValue() );
        feature.setProductId( featureDTO.getProductId() );

        return feature;
    }

    @Override
    public FeatureDTO toDTO(Feature feature) {
        if ( feature == null ) {
            return null;
        }

        FeatureDTO featureDTO = new FeatureDTO();

        featureDTO.setProductName( featureProductName( feature ) );
        featureDTO.setId( feature.getId() );
        featureDTO.setActive( feature.isActive() );
        featureDTO.setCode( feature.getCode() );
        featureDTO.setName( feature.getName() );
        featureDTO.setPosition( feature.getPosition() );
        if ( feature.getType() != null ) {
            featureDTO.setType( feature.getType().name() );
        }
        featureDTO.setImage( feature.getImage() );
        featureDTO.setValue( feature.getValue() );
        featureDTO.setProductId( feature.getProductId() );

        return featureDTO;
    }

    private String featureProductName(Feature feature) {
        if ( feature == null ) {
            return null;
        }
        Product product = feature.getProduct();
        if ( product == null ) {
            return null;
        }
        String name = product.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
