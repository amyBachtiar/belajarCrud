package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;

/**
 *
 * @author amy
 */
public class BizparDTO {

    private String key;
    private String value;
    private boolean status;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    // create data dummy
    @JsonIgnore
    public BizparDTO getInstance() {
        BizparDTO dto = new BizparDTO();
        dto.setKey(UUID.randomUUID().toString().substring(0, 6));
        dto.setValue("Isi Value");
        dto.setStatus(true);
        return dto;
    }
}
