package com.fiverr.app.domain.repository;

import com.fiverr.app.domain.SubCategory;

public interface SubCategoryRepository extends BaseRepository<SubCategory, Long>{

    default SubCategory update(SubCategory model) { return null; }
}
