package com.fiverr.app.infrastructure.db.postgres.repositories;

import com.fiverr.app.infrastructure.db.postgres.entity.SubCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryJpaRepository extends JpaRepository<SubCategoryEntity, Long> {
}
