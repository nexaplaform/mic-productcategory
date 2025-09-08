package com.fiverr.app.domain.repository;

import com.fiverr.app.domain.Category;

public interface CategoryRepository extends BaseRepository<Category, Long>{

    default Category update(Category model) { return null; }

    default Category getSubCategory(Long id) { return null; }
}
