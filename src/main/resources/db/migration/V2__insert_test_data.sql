CREATE
EXTENSION IF NOT EXISTS "pgcrypto";

INSERT INTO tasks (id, title, description, task_status, created_at, updated_at)
VALUES (gen_random_uuid(), 'Buy groceries', 'Milk, eggs, and bread', 'PENDING', now(), now()),
       (gen_random_uuid(), 'Fix login bug', 'Resolve 500 error on user login', 'IN_PROGRESS', now(), now()),
       (gen_random_uuid(), 'Read Spring docs', 'Study new features in Spring Boot 3.x', 'COMPLETED', now(), now()),
       (gen_random_uuid(), 'Prepare presentation', 'Slides for Monday meeting', 'PENDING', now(), now()),
       (gen_random_uuid(), 'Test REST API', 'Write Postman tests for all endpoints', 'IN_PROGRESS', now(), now()),
       (gen_random_uuid(), 'Deploy to production', 'Finalize and push release v1.0', 'COMPLETED', now(), now());
