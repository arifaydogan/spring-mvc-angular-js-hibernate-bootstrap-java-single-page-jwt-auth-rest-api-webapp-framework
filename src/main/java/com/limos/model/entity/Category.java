package com.limos.model.entity;

import com.limos.framework.data.JPAEntity;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Category Entity
 *
 * Created by arifaydogan on 01/08/2016.
 */
@Entity
@Table(indexes = {  @Index(name="name_idx", columnList = "name", unique = true),
        @Index(name="priority_idx", columnList = "priority"),
        @Index(name="parentCategory_idx", columnList = "parent_category")})
public class Category extends JPAEntity<Long> {
    private String name;
    private Integer priority;
    private Category parentCategory;

    @NotNull @NotBlank
    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    @Column
    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    public Category getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(Category parentCategory) {
        this.parentCategory = parentCategory;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                ", parentCategory=" + parentCategory +
                '}';
    }
}
