package com.leopoldodev.bookstore.repositories;

import com.leopoldodev.bookstore.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface CategoryRepository extends JpaRepository<Category, Integer> {
}
