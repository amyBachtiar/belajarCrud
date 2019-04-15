package com.mycompany.belajarcrud.domain;

import com.eksad.ddms.common.util.object.EntityObject;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author alva
 */
@Entity
@Table(name = "TRX_STOCK")
public class Stock implements EntityObject<Stock> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @NotNull(message = "Stock Kode cannot be null")
    private String code;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "partCode", nullable = false)
    private Part part;

    private Integer quantity;

    private boolean status;

    public Stock() {

    }

    public Stock(String code, Part part, Integer quantity, boolean status) {
        this.code = code;
        this.part = part;
        this.quantity = quantity;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Part getPart() {
        return part;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean sameIdentityAs(Stock other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
