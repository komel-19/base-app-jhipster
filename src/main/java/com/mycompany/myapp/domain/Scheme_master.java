package com.mycompany.myapp.domain;

import com.datastax.driver.mapping.annotations.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * A Scheme_master.
 */
@Table(name = "scheme_master")
public class Scheme_master implements Serializable {

    private static final long serialVersionUID = 1L;

    @PartitionKey
    private UUID id;

    private String schemeName;

    private Float commission;

    private Integer schemNo;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSchemeName() {
        return schemeName;
    }

    public Scheme_master schemeName(String schemeName) {
        this.schemeName = schemeName;
        return this;
    }

    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    public Float getCommission() {
        return commission;
    }

    public Scheme_master commission(Float commission) {
        this.commission = commission;
        return this;
    }

    public void setCommission(Float commission) {
        this.commission = commission;
    }

    public Integer getSchemNo() {
        return schemNo;
    }

    public Scheme_master schemNo(Integer schemNo) {
        this.schemNo = schemNo;
        return this;
    }

    public void setSchemNo(Integer schemNo) {
        this.schemNo = schemNo;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Scheme_master scheme_master = (Scheme_master) o;
        if (scheme_master.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), scheme_master.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Scheme_master{" +
            "id=" + getId() +
            ", schemeName='" + getSchemeName() + "'" +
            ", commission=" + getCommission() +
            ", schemNo=" + getSchemNo() +
            "}";
    }
}
