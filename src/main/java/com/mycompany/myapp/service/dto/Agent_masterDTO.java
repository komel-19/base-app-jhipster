package com.mycompany.myapp.service.dto;


import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * A DTO for the Agent_master entity.
 */
public class Agent_masterDTO implements Serializable {

    private UUID id;

    private String agentName;

    private Integer agentNo;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Integer getAgentNo() {
        return agentNo;
    }

    public void setAgentNo(Integer agentNo) {
        this.agentNo = agentNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Agent_masterDTO agent_masterDTO = (Agent_masterDTO) o;
        if(agent_masterDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), agent_masterDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Agent_masterDTO{" +
            "id=" + getId() +
            ", agentName='" + getAgentName() + "'" +
            ", agentNo=" + getAgentNo() +
            "}";
    }
}
