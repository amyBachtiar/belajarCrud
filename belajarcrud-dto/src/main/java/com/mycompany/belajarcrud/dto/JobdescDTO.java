
package com.mycompany.belajarcrud.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Reza Agika Putra
 */
public class JobdescDTO {
    
    private String jobdescId;
    private String name;
    private String description;

    public String getJobdescId() {
        return jobdescId;
    }

    public void setJobdescId(String jobdescId) {
        this.jobdescId = jobdescId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    //Create data Dummy
    @JsonIgnore
    public JobdescDTO getInstance(){
        JobdescDTO dto = new JobdescDTO();
        dto.setJobdescId("X-YYYY");
        dto.setName("Menyapu Lantai");
        dto.setDescription("Menyapu semua lantai di EKSAD TECHNOLOGY sampai bersih tidak ada debu");
        return dto;
    }
}
