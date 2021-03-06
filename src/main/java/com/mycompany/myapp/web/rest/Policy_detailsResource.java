package com.mycompany.myapp.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.mycompany.myapp.domain.Policy_details;
import com.mycompany.myapp.domain.Scheme_master;
import com.mycompany.myapp.repository.Agent_masterRepository;
import com.mycompany.myapp.repository.Policy_detailsRepository;
import com.mycompany.myapp.repository.Scheme_masterRepository;
import com.mycompany.myapp.service.Policy_detailsService;
import com.mycompany.myapp.service.dto.AgentCommission;
import com.mycompany.myapp.service.dto.AgentSchemeCount;
import com.mycompany.myapp.service.dto.Agent_masterDTO;
import com.mycompany.myapp.service.mapper.Agent_masterMapper;
import com.mycompany.myapp.web.rest.errors.BadRequestAlertException;
import com.mycompany.myapp.web.rest.util.HeaderUtil;
import com.mycompany.myapp.service.dto.Policy_detailsDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * REST controller for managing Policy_details.
 */
@RestController
@RequestMapping("/api")
public class Policy_detailsResource {

    private final Logger log = LoggerFactory.getLogger(Policy_detailsResource.class);

    private static final String ENTITY_NAME = "policy_details";

    private final Policy_detailsService policy_detailsService;

    private final Agent_masterRepository agent_masterRepository;

    private final Scheme_masterRepository scheme_masterRepository;

    private final Policy_detailsRepository policy_detailsRepository;

    private final Agent_masterMapper agent_masterMapper;

    public Policy_detailsResource(Policy_detailsService policy_detailsService, Agent_masterRepository agent_masterRepository, Scheme_masterRepository scheme_masterRepository, Policy_detailsRepository policy_detailsRepository, Agent_masterMapper agent_masterMapper) {
        this.policy_detailsService = policy_detailsService;
        this.agent_masterRepository = agent_masterRepository;
        this.scheme_masterRepository = scheme_masterRepository;
        this.policy_detailsRepository = policy_detailsRepository;
        this.agent_masterMapper = agent_masterMapper;
    }

    /**
     * POST  /policy-details : Create a new policy_details.
     *
     * @param policy_detailsDTO the policy_detailsDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new policy_detailsDTO, or with status 400 (Bad Request) if the policy_details has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/policy-details")
    @Timed
    public ResponseEntity<Policy_detailsDTO> createPolicy_details(@RequestBody Policy_detailsDTO policy_detailsDTO) throws URISyntaxException {
        log.debug("REST request to save Policy_details : {}", policy_detailsDTO);
        if (policy_detailsDTO.getId() != null) {
            throw new BadRequestAlertException("A new policy_details cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Policy_detailsDTO result = policy_detailsService.save(policy_detailsDTO);
        return ResponseEntity.created(new URI("/api/policy-details/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /policy-details : Updates an existing policy_details.
     *
     * @param policy_detailsDTO the policy_detailsDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated policy_detailsDTO,
     * or with status 400 (Bad Request) if the policy_detailsDTO is not valid,
     * or with status 500 (Internal Server Error) if the policy_detailsDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/policy-details")
    @Timed
    public ResponseEntity<Policy_detailsDTO> updatePolicy_details(@RequestBody Policy_detailsDTO policy_detailsDTO) throws URISyntaxException {
        log.debug("REST request to update Policy_details : {}", policy_detailsDTO);
        if (policy_detailsDTO.getId() == null) {
            return createPolicy_details(policy_detailsDTO);
        }
        Policy_detailsDTO result = policy_detailsService.save(policy_detailsDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, policy_detailsDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /policy-details : get all the policy_details.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of policy_details in body
     */
    @GetMapping("/policy-details")
    @Timed
    public List<Policy_detailsDTO> getAllPolicy_details() {
        log.debug("REST request to get all Policy_details");
        return policy_detailsService.findAll();
        }

    /**
     * GET  /policy-details/:id : get the "id" policy_details.
     *
     * @param id the id of the policy_detailsDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the policy_detailsDTO, or with status 404 (Not Found)
     */
    @GetMapping("/policy-details/{id}")
    @Timed
    public ResponseEntity<Policy_detailsDTO> getPolicy_details(@PathVariable String id) {
        log.debug("REST request to get Policy_details : {}", id);
        Policy_detailsDTO policy_detailsDTO = policy_detailsService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(policy_detailsDTO));
    }

    /**
     * DELETE  /policy-details/:id : delete the "id" policy_details.
     *
     * @param id the id of the policy_detailsDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/policy-details/{id}")
    @Timed
    public ResponseEntity<Void> deletePolicy_details(@PathVariable String id) {
        log.debug("REST request to delete Policy_details : {}", id);
        policy_detailsService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id)).build();
    }

    @GetMapping("/dashboard/{agentNo}")
    @Timed
    public List<AgentCommission> agentCommision(@PathVariable String agentNo)
    {
        //Getting all Agents
        List<Agent_masterDTO> agent_masterDTOS = agent_masterRepository.findAll().stream()
            .map(agent_masterMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));

        //Declaring list of commission
        List<AgentCommission> agentCommissions = new ArrayList<>();

        //Calculation agent wise commissions
        for (Agent_masterDTO agent:agent_masterDTOS
            ) {
            AgentCommission agentCommission = new AgentCommission();
            agentCommission.setAgentNo(agent.getAgentNo());
            agentCommission.setCommission(agentCommission(agent.getAgentNo()));
            agentCommissions.add(agentCommission);
        }
        return agentCommissions;
    }

    public Double agentCommission(Integer agentNo)
    {
        double commission = 0.0;
        List<Policy_details> policy_details = policy_detailsRepository.findpolicyNo(agentNo);
        for (Policy_details policy: policy_details
             ) {
            commission = commission + policy.getCommission();
        }
        return commission;
    }

    @GetMapping("/dashboard")
    @Timed
    public List<AgentSchemeCount> allAgents()
    {
        //getting all agents
        List<Agent_masterDTO> agent_masterDTOS = agent_masterRepository.findAll().stream()
            .map(agent_masterMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));

        //Make a list of Agent Schemes
        List<AgentSchemeCount> agentSchemeCounts = new ArrayList<>();

        //Getting All Schemes
        List<Scheme_master> scheme_masters = scheme_masterRepository.findAll();

        //
        for (Agent_masterDTO agent:agent_masterDTOS
            ) {

            for (Scheme_master schemeMaster: scheme_masters
                ) {
                AgentSchemeCount agentSchemeCountObj = new AgentSchemeCount();
                Integer agentSchemeCount = agentSchemeCount(agent.getAgentNo(),schemeMaster.getSchemNo());
                agentSchemeCountObj.setPolicyNo(agentSchemeCount);
                agentSchemeCountObj.setSchemeNo(schemeMaster.getSchemNo());
                agentSchemeCountObj.setAgentNo(agent.getAgentNo());
                agentSchemeCounts.add(agentSchemeCountObj);
                System.out.println(agentSchemeCount+"POLICY NUMBER"+schemeMaster.getSchemNo());
            }

        }
        return agentSchemeCounts;
    }

    public Integer agentSchemeCount(Integer agentNo, Integer schemeNo)
    {
        return policy_detailsRepository.findpolicyNo(agentNo).stream().filter(policy_details1 -> policy_details1.getSchemeNo()==schemeNo).collect(Collectors.toList()).size();
    }
}
