ALTER TABLE categories ADD COLUMN parent_id INTEGER;

ALTER TABLE categories
ADD CONSTRAINT fk_parent_category
FOREIGN KEY (parent_id)
REFERENCES categories (id)
ON DELETE CASCADE;