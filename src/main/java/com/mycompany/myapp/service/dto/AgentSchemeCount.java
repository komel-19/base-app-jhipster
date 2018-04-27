package com.mycompany.myapp.service.dto;

import java.io.Serializable;

public class AgentSchemeCount implements Serializable{

    private Integer agentNo;

    private Integer schemeNo;

    private Integer policyNo;

    public Integer getPolicyNo() {
        return policyNo;
    }

    public void setPolicyNo(Integer policyNo) {
        this.policyNo = policyNo;
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
}
