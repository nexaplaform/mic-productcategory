CREATE TABLE categories (
    id SERIAL PRIMARY KEY,
    name VARCHAR(120),
    description VARCHAR(255),
    type VARCHAR(100),
    enabled BOOLEAN,
    create_by VARCHAR(100),
    create_at TIMESTAMP WITH TIME ZONE,
    last_modified_by VARCHAR(100),
    last_modified_date TIMESTAMP WITH TIME ZONE
);