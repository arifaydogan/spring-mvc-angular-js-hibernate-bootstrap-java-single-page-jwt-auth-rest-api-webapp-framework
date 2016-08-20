package com.limos.model.repository;

import com.limos.framework.data.BaseJPARepository;
import com.limos.model.entity.Category;

import java.util.List;

/**
 * CRUD operations come from Base Repo but additional operations can be defined here.
 *
 * @author: arifaydogan
 */
public interface CategoryRepository extends BaseJPARepository<Category, Long> {
    /**
     * Finds a category with the given categoryName
     *
     * @param categoryName
     * @return
     */
    public Category findByCategoryName(String categoryName);

    /**
     * Finds a category with the given categoryPriority
     *
     * @param categoryPriority
     * @return
     */
    public Category findByCategoryPriority(Integer categoryPriority);

    /**
     * Finds sub categories with the given parentCategory
     *
     * @param parentCategory
     * @return
     */
    public List<Category> findSubCategories(Category parentCategory);
}
