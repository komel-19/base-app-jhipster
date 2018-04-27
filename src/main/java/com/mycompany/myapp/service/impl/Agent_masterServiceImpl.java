package com.mycompany.myapp.service.impl;

import com.mycompany.myapp.domain.Policy_details;
import com.mycompany.myapp.domain.Scheme_master;
import com.mycompany.myapp.repository.Policy_detailsRepository;
import com.mycompany.myapp.repository.Scheme_masterRepository;
import com.mycompany.myapp.service.Agent_masterService;
import com.mycompany.myapp.domain.Agent_master;
import com.mycompany.myapp.repository.Agent_masterRepository;
import com.mycompany.myapp.service.dto.Agent_masterDTO;
import com.mycompany.myapp.service.dto.Scheme_masterDTO;
import com.mycompany.myapp.service.mapper.Agent_masterMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing Agent_master.
 */
@Service
public class Agent_masterServiceImpl implements Agent_masterService {

    private final Logger log = LoggerFactory.getLogger(Agent_masterServiceImpl.class);

    private final Agent_masterRepository agent_masterRepository;

    private final Agent_masterMapper agent_masterMapper;

    private final Policy_detailsRepository policy_detailsRepository;

    private final Scheme_masterRepository scheme_masterRepository;

    public Agent_masterServiceImpl(Agent_masterRepository agent_masterRepository, Agent_masterMapper agent_masterMapper, Policy_detailsRepository policy_detailsRepository, Scheme_masterRepository scheme_masterRepository) {
        this.agent_masterRepository = agent_masterRepository;
        this.agent_masterMapper = agent_masterMapper;
        this.policy_detailsRepository = policy_detailsRepository;
        this.scheme_masterRepository = scheme_masterRepository;
    }

    /**
     * Save a agent_master.
     *
     * @param agent_masterDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public Agent_masterDTO save(Agent_masterDTO agent_masterDTO) {
        log.debug("Request to save Agent_master : {}", agent_masterDTO);
        Agent_master agent_master = agent_masterMapper.toEntity(agent_masterDTO);
        agent_master = agent_masterRepository.save(agent_master);
        return agent_masterMapper.toDto(agent_master);
    }

    /**
     * Get all the agent_masters.
     *
     * @return the list of entities
     */
    @Override
    public List<Agent_masterDTO> findAll() {
        log.debug("Request to get all Agent_masters");
        List<Agent_masterDTO> agent_masterDTOS = agent_masterRepository.findAll().stream()
            .map(agent_masterMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));

        for (Agent_masterDTO agent:agent_masterDTOS
             ) {
            List<Scheme_master> scheme_masters = scheme_masterRepository.findAll();

            for (Scheme_master schemeMaster: scheme_masters
                 ) {
                Integer agentSchemeCount = agentSchemeCount(agent.getAgentNo(),schemeMaster.getSchemNo());
                System.out.println(agentSchemeCount+"POLICY NUMBER"+schemeMaster.getSchemNo());
            }

        }
        return agent_masterDTOS;
    }

    public Integer agentSchemeCount(Integer agentNo, Integer schemeNo)
    {
        return policy_detailsRepository.findpolicyNo(agentNo).stream().filter(policy_details1 -> policy_details1.getSchemeNo()==schemeNo).collect(Collectors.toList()).size();
    }

    /**
     * Get one agent_master by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    public Agent_masterDTO findOne(String id) {
        log.debug("Request to get Agent_master : {}", id);
        Agent_master agent_master = agent_masterRepository.findOne(UUID.fromString(id));
        return agent_masterMapper.toDto(agent_master);
    }

    /**
     * Delete the agent_master by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete Agent_master : {}", id);
        agent_masterRepository.delete(UUID.fromString(id));
    }
}
