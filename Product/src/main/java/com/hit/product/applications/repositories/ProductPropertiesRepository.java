package com.hit.product.applications.repositories;

import com.hit.product.domains.entities.ProductProperties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductPropertiesRepository extends JpaRepository<ProductProperties, Long> {

}
