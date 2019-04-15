package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.UUID;

/**
 *
 * @author amy
 */
public class PartDTO {

    private String code;
    private String description;
    private boolean status;

    public PartDTO() {
    }

    public PartDTO(String code, String description, boolean status) {
        this.code = code;
        this.description = description;
        this.status = status;
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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // create data dummy
    @JsonIgnore
    public PartDTO getInstance() {
        PartDTO dto = new PartDTO();
        dto.setCode(UUID.randomUUID().toString().substring(0, 6));
        dto.setDescription("Isi Description");
        dto.setStatus(true);
        return dto;
    }
}
