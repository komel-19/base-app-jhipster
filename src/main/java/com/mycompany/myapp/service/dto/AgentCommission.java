package com.mycompany.myapp.service.dto;

import java.io.Serializable;

public class AgentCommission implements Serializable {

    private Integer agentNo;

    private Double commission;

    public Integer getAgentNo() {
        return agentNo;
    }

    public void setAgentNo(Integer agentNo) {
        this.agentNo = agentNo;
    }

    public Double getCommission() {
        return commission;
    }

    public void setCommission(Double commission) {
        this.commission = commission;
    }
}
