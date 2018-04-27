package com.mycompany.myapp.service.dto;


import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * A DTO for the Scheme_master entity.
 */
public class Scheme_masterDTO implements Serializable {

    private UUID id;

    private String schemeName;

    private Float commission;

    private Integer schemNo;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public Float getCommission() {
        return commission;
    }

    public void setCommission(Float commission) {
        this.commission = commission;
    }

    public Integer getSchemNo() {
        return schemNo;
    }

    public void setSchemNo(Integer schemNo) {
        this.schemNo = schemNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Scheme_masterDTO scheme_masterDTO = (Scheme_masterDTO) o;
        if(scheme_masterDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), scheme_masterDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Scheme_masterDTO{" +
            "id=" + getId() +
            ", schemeName='" + getSchemeName() + "'" +
            ", commission=" + getCommission() +
            ", schemNo=" + getSchemNo() +
            "}";
    }
}
