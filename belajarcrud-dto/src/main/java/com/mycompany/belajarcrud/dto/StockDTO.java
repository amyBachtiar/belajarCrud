package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;

/**
 *
 * @author amy
 */
public class StockDTO {

    private String code;
    private String partCode;
    private Integer quantity;
    private boolean status;

    public StockDTO() {
    }

    public StockDTO(String code, String partCode, Integer quantity, boolean status) {
        this.code = code;
        this.partCode = partCode;
        this.quantity = quantity;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPartCode() {
        return partCode;
    }

    public void setPartCode(String partCode) {
        this.partCode = partCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // create data dummy
    @JsonIgnore
    public StockDTO getInstance() {
        StockDTO dto = new StockDTO();
        dto.setCode(UUID.randomUUID().toString().substring(0, 6));
        dto.setPartCode(UUID.randomUUID().toString().substring(0, 6));
        dto.setQuantity(0);
        dto.setStatus(true);
        return dto;
    }
}
