CREATE TABLE ninjas_registry (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(40) NOT NULL,
    village VARCHAR(50) NOT NULL,
    clan VARCHAR(20) NOT NULL,
    rank_ninja VARCHAR(6) NOT NULL DEFAULT 'GENIN',
    chakra_nature VARCHAR(10) NOT NULL,
    ninja_status VARCHAR(10) NOT NULL DEFAULT 'ACTIVE',
    CHECK (ninja_status IN ('ACTIVE','DECEASED','MISSING','ROGUE')),
    CHECK (rank_ninja IN ('GENIN','CHUNIN','JOUNIN','SANNIN','KAGE'))
);

CREATE TABLE missions_registry (
    id BIGSERIAL PRIMARY KEY,
    title VARCHAR(20) NOT NULL,
    description VARCHAR(100) NOT NULL,
    village VARCHAR(50) NOT NULL,
    mission_rank VARCHAR(1) DEFAULT 'E',
    mission_status VARCHAR(10) NOT NULL DEFAULT 'OPEN',
    CHECK (mission_status IN ('OPEN','FULFILLED','FAILED','CANCELED')),
    CHECK (mission_rank IN ('S','A','B','C','D','E'))
);

CREATE TABLE ninja_mission_registry (
    id BIGSERIAL PRIMARY KEY,
    mission_id BIGSERIAL NOT NULL,
    ninja_id BIGSERIAL NOT NULL,
    assignment VARCHAR(10) NOT NULL,
    assignment_date DATE NOT NULL DEFAULT CURRENT_DATE,
    CHECK (assignment IN ('LEADER','ATTACK','SUPPORT','SENSORIAL','MEDICAL','DEFENSE')),
    UNIQUE(ninja_id, mission_id)
);
