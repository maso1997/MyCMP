package com.example.demo.mapper;

import com.example.demo.Domain.Product;
import com.example.demo.modal.dto.ProductDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDto, Product> {
    @Mapping(target = "description", source = "description")
    @Mapping(target = "id", source = "id")
    @Mapping (target = "name", source= "name")
    @Mapping (target = "motif", source= "motif")
    @Mapping (target = "porteurProjet", source= "porteurProjet")
    @Mapping (target = "porteurMetier", source= "porteurMetier")
    @Mapping (target = "coordinateurCNP", source= "coordinateurCNP")
    @Mapping (target = "sponsorM", source= "sponsorM")
    @Mapping(target = "statut", source = "statut")

    ProductDto toDto (Product product);



}
