package com.fiverr.app.infrastructure.db.postgres.repositories;

import com.fiverr.app.infrastructure.db.postgres.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryJpaRepository extends JpaRepository<CategoryEntity, Long> {
}
