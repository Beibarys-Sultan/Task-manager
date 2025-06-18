CREATE TABLE tasks
(
    id          UUID         NOT NULL,
    title       VARCHAR(100) NOT NULL,
    description VARCHAR(255),
    task_status VARCHAR(255),
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_tasks PRIMARY KEY (id)
);