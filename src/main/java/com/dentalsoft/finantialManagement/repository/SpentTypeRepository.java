package com.dentalsoft.finantialManagement.repository;

import com.dentalsoft.finantialManagement.entity.Spent;
import com.dentalsoft.finantialManagement.entity.SpentCategory;
import com.dentalsoft.finantialManagement.entity.SpentType;
import com.dentalsoft.finantialManagement.repository.common.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SpentTypeRepository extends BaseRepository<SpentType, Long> {

}
