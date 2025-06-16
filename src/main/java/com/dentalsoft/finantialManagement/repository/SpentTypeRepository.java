package com.dentalsoft.finantialManagement.repository;

import com.dentalsoft.finantialManagement.entity.SpentCategory;
import com.dentalsoft.finantialManagement.entity.SpentType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SpentTypeRepository extends JpaRepository<SpentType, Long> {
    @Query("FROM SpentType e " +
            //"WHERE e.deletedAt IS NULL " +
            //"OR e.deletedAt > CURRENT_TIMESTAMP" +
            "WHERE e.id = ?1 " )
    Optional<SpentType> getValidById(Long id);

    @Query("FROM SpentType e ")
    /*+
            "WHERE e.deletedAt IS NULL " +
            "OR e.deletedAt > CURRENT_TIMESTAMP")*/
    List<SpentType> getAllValid();
}
