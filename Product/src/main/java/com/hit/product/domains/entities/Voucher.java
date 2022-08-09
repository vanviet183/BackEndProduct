package com.hit.product.domains.entities;

import com.hit.product.domains.entities.base.AbstractAuditingEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "vouchers")
public class Voucher extends AbstractAuditingEntity {

    private static final int EXPIRATION_TIME = 24;

    private Double percent;

    private String description;

    private Date expirationTime;

    private String urlImage;

    public Voucher() {
        super();
        this.expirationTime = calculateExpirationDate(EXPIRATION_TIME);
    }

    public Voucher(Double percent) {
        super();
        this.expirationTime = calculateExpirationDate(EXPIRATION_TIME);
    }

    private Date calculateExpirationDate(int expirationTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(new Date().getTime());
        calendar.add(Calendar.HOUR, expirationTime);
        return new Date(calendar.getTime().getTime());
    }

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_event")
    private Event event;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_product")
    private Product product;
}
