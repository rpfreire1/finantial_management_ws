package com.dentalsoft.finantialManagement.repository;

import com.dentalsoft.finantialManagement.entity.Spent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SpentRepository extends JpaRepository<Spent, Long> {
    @Query("FROM Spent e " +
            //"WHERE e.deletedAt IS NULL " +
            //"OR e.deletedAt > CURRENT_TIMESTAMP" +
            " WHERE e.spentId  = ?1 " )
    Optional<Spent> getValidById(Long id);

    @Query("FROM Spent e ")
    /*+
            "WHERE e.deletedAt IS NULL " +
            "OR e.deletedAt > CURRENT_TIMESTAMP")*/
    List<Spent> getAllValid();
}
