
CREATE TABLE IF NOT EXISTS policy_details (
    id uuid,
    date date,
    customerName text,
    policyAmount float,
    commission float,
    schemeNo int,
    agentNo int,
    policyNo int,
    PRIMARY KEY(id)
);
