package com.mycompany.myapp.domain;

import com.datastax.driver.mapping.annotations.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * A Policy_details.
 */
@Table(name = "policy_details")
public class Policy_details implements Serializable {

    private static final long serialVersionUID = 1L;

    @PartitionKey
    private UUID id;

    private LocalDate date;

    private String customerName;

    private Float policyAmount;

    private Float commission;

    private Integer schemeNo;

    private Integer agentNo;

    private Integer policyNo;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public Policy_details date(LocalDate date) {
        this.date = date;
        return this;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public Policy_details customerName(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Float getPolicyAmount() {
        return policyAmount;
    }

    public Policy_details policyAmount(Float policyAmount) {
        this.policyAmount = policyAmount;
        return this;
    }

    public void setPolicyAmount(Float policyAmount) {
        this.policyAmount = policyAmount;
    }

    public Float getCommission() {
        return commission;
    }

    public Policy_details commission(Float commission) {
        this.commission = commission;
        return this;
    }

    public void setCommission(Float commission) {
        this.commission = commission;
    }

    public Integer getSchemeNo() {
        return schemeNo;
    }

    public Policy_details schemeNo(Integer schemeNo) {
        this.schemeNo = schemeNo;
        return this;
    }

    public void setSchemeNo(Integer schemeNo) {
        this.schemeNo = schemeNo;
    }

    public Integer getAgentNo() {
        return agentNo;
    }

    public Policy_details agentNo(Integer agentNo) {
        this.agentNo = agentNo;
        return this;
    }

    public void setAgentNo(Integer agentNo) {
        this.agentNo = agentNo;
    }

    public Integer getPolicyNo() {
        return policyNo;
    }

    public Policy_details policyNo(Integer policyNo) {
        this.policyNo = policyNo;
        return this;
    }

    public void setPolicyNo(Integer policyNo) {
        this.policyNo = policyNo;
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
        Policy_details policy_details = (Policy_details) o;
        if (policy_details.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), policy_details.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Policy_details{" +
            "id=" + getId() +
            ", date='" + getDate() + "'" +
            ", customerName='" + getCustomerName() + "'" +
            ", policyAmount=" + getPolicyAmount() +
            ", commission=" + getCommission() +
            ", schemeNo=" + getSchemeNo() +
            ", agentNo=" + getAgentNo() +
            ", policyNo=" + getPolicyNo() +
            "}";
    }
}
