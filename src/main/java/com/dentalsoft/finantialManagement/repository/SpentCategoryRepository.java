package com.dentalsoft.finantialManagement.repository;

import com.dentalsoft.finantialManagement.entity.SpentCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SpentCategoryRepository extends JpaRepository<SpentCategory, Long> {
    @Query("FROM SpentCategory e " +
            //"WHERE e.deletedAt IS NULL " +
            //"OR e.deletedAt > CURRENT_TIMESTAMP" +
            "")
    Optional<SpentCategory> getValidById(Long id);

    @Query("FROM SpentCategory e ")
    /*+
            "WHERE e.deletedAt IS NULL " +
            "OR e.deletedAt > CURRENT_TIMESTAMP")*/
    List<SpentCategory> getAllValid();
}
