package kr.co.rland.api.Repository;

import kr.co.rland.api.entity.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
