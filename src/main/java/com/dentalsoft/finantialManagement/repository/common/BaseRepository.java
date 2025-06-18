package com.dentalsoft.finantialManagement.repository.common;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<T,I> extends JpaRepository<T, I>, JpaSpecificationExecutor<T> {
    @Query("FROM #{#entityName} e " +
            "WHERE e.deletedAt IS NULL " +
            "OR e.deletedAt > CURRENT_TIMESTAMP")
    List<T> getAllValid();

    @Query("FROM #{#entityName} e " +
            "WHERE e.id = ?1 " +
            "AND (e.deletedAt IS NULL OR e.deletedAt > CURRENT_TIMESTAMP)")
    Optional<T> getValidById(I id);
}
