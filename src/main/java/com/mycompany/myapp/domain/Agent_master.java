package com.mycompany.myapp.domain;

import com.datastax.driver.mapping.annotations.*;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

/**
 * A Agent_master.
 */
@Table(name = "agent_master")
public class Agent_master implements Serializable {

    private static final long serialVersionUID = 1L;

    @PartitionKey
    private UUID id;

    private String agentName;

    private Integer agentNo;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAgentName() {
        return agentName;
    }

    public Agent_master agentName(String agentName) {
        this.agentName = agentName;
        return this;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public Integer getAgentNo() {
        return agentNo;
    }

    public Agent_master agentNo(Integer agentNo) {
        this.agentNo = agentNo;
        return this;
    }

    public void setAgentNo(Integer agentNo) {
        this.agentNo = agentNo;
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
        Agent_master agent_master = (Agent_master) o;
        if (agent_master.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), agent_master.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Agent_master{" +
            "id=" + getId() +
            ", agentName='" + getAgentName() + "'" +
            ", agentNo=" + getAgentNo() +
            "}";
    }
}
