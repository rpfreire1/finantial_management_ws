package com.dentalsoft.finantialManagement.mapper.common;

public interface EntityMapper<T, D> {
    D toDto(T entity);
}

