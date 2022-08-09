package com.hit.product.domains.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hit.product.domains.entities.base.AbstractAuditingEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product_properties")
public class ProductProperties extends AbstractAuditingEntity {

    @Nationalized
    private String color;

    private Integer size;

    private String slugColor;

    private Integer currentNumber;

    private Double priceOld;

    private Double priceCurrent;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product")
    @JsonIgnore
    private Product product;
}
