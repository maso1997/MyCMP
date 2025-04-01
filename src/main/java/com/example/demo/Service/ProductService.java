package com.example.demo.Service;


import com.example.demo.Domain.Product;
import com.example.demo.Domain.User;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Service.impl.ProductImpl;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.modal.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService  implements ProductImpl {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final RiskEvaluationService riskEvaluationService;
    private final UserService userService;
    private final DemandeQualificationRepository demandeQualificationRepository;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper, RiskEvaluationService riskEvaluationService, UserService userService, DemandeQualificationRepository demandeQualificationRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.riskEvaluationService = riskEvaluationService;
        this.userService = userService;
        this.demandeQualificationRepository = demandeQualificationRepository;
    }

    public Product getProductById(Long productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        return productOptional.orElse(null);
    }

    public void save(ProductDto productDto) {
        DemandeQualification demandeQualification = demandeQualificationRepository.findById(productDto.getId()).orElseThrow(() -> new NotFoundException("DemandeQualification not found"));

        User sponsor = userService.getUserById(productDto.getSponsorsMIds());
        User porteursMetier = userService.getUserById(productDto.getPorteursMetierIds());
        User porteursProjet = userService.getUserById(productDto.getPorteursProjetIds());
        User coordinateurCNP = userService.getUserById(productDto.getCoordinateurCNP());

        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setDateLancement(productDto.getDateLancement());
        product.setMotif(productDto.getMotif());
        product.setPorteurProjet(porteursProjet);
        product.setPorteurMetier(porteursMetier);
        product.setCoordinateurCNP(coordinateurCNP);
        product.setSponsorM(sponsor);
        product.setStatut(productDto.getStatut());

        Product product1 = productRepository.save(product);
        demandeQualification.productRepository.(product);
        demandeQualification.setProduct(product)
        demandeQualificationRepository.save(demandeQualification);
        riskEvaluationService.createOrUpdateRiskEvaluations(Product1);
    }

    public ProductDto findByName(String name) {
        List<Product> product = new ArrayList<>();
        List<String> name1 = new ArrayList<>();
        for (int i = 0; i < product.size(); i++) {
            name1.add(product.get(i).getName());
        }
        Product product = productRepository.findbyName(name);
        return productMapper.toDto(product);
    }


    public void update(ProductDto productDto) {


        User sponsor = userService.getUserById(productDto.getSponsorsMIds());
        User porteursMetier = userService.getUserById(productDto.getPorteursMetierIds());
        User porteursProjet = userService.getUserById(productDto.getPorteursProjetIds());
        User coordinateurCNP = userService.getUserById(productDto.getCoordinateurCNP());
        Product product = productRepository.findById(productDto.getId())
                .orElseThrow(() -> new NotFoundException("Product not found"));

        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setDateLancement(productDto.getDateLancement());
        product.setMotif(productDto.getMotif());
        product.setPorteurProjet(porteursProjet);
        product.setPorteurMetier(porteursMetier);
        product.setCoordinateurCNP(coordinateurCNP);
        product.setSponsorM(sponsor);
        product.setStatut("En cours");

        productRepository.save(product);
    }
}

}
