package com.fiverr.app.infrastructure.db.postgres.repositories;

import com.fiverr.app.infrastructure.db.postgres.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepositoryAdapter extends JpaRepository<CategoryEntity, Long> {

    List<CategoryEntity> findByParentIsNull();
}
