package com.mycompany.myapp.service.dto;


import java.time.LocalDate;
import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * A DTO for the Policy_details entity.
 */
public class Policy_detailsDTO implements Serializable {

    private UUID id;

    private LocalDate date;

    private String customerName;

    private Float policyAmount;

    private Float commission;

    private Integer schemeNo;

    private Integer agentNo;

    private Integer policyNo;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Float getPolicyAmount() {
        return policyAmount;
    }

    public void setPolicyAmount(Float policyAmount) {
        this.policyAmount = policyAmount;
    }

    public Float getCommission() {
        return commission;
    }

    public void setCommission(Float commission) {
        this.commission = commission;
    }

    public Integer getSchemeNo() {
        return schemeNo;
    }

    public void setSchemeNo(Integer schemeNo) {
        this.schemeNo = schemeNo;
    }

    public Integer getAgentNo() {
        return agentNo;
    }

    public void setAgentNo(Integer agentNo) {
        this.agentNo = agentNo;
    }

    public Integer getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(Integer policyNo) {
        this.policyNo = policyNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Policy_detailsDTO policy_detailsDTO = (Policy_detailsDTO) o;
        if(policy_detailsDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), policy_detailsDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Policy_detailsDTO{" +
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
