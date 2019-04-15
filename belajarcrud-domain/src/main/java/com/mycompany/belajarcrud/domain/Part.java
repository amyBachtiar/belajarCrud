package com.mycompany.belajarcrud.domain;

import com.eksad.ddms.common.util.object.EntityObject;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author alva
 */
@Entity
@Table(name = "MST_PART")
@Inheritance(strategy = InheritanceType.JOINED)
public class Part implements EntityObject<Part> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    @NotNull(message = "part code cannot be null")
    private String code;
    private String description;
    private boolean status;
    @OneToMany(mappedBy = "part", cascade = CascadeType.ALL)
    private Set<Stock> stocks;

    public Part() {
    }

    public Part(String code, String description, boolean status, Set<Stock> stocks) {
        this.code = code;
        this.description = description;
        this.status = status;
        this.stocks = stocks;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<Stock> stocks) {
        this.stocks = stocks;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public boolean sameIdentityAs(Part other) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
