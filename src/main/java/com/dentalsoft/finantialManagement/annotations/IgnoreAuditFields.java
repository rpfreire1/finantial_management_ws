package com.dentalsoft.finantialManagement.annotations;

import org.mapstruct.Mapping;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Mapping(target = "version", ignore = true)
@Mapping(target = "createdBy", ignore = true)
@Mapping(target = "createdDate", ignore = true)
@Mapping(target = "lastModifiedBy", ignore = true)
@Mapping(target = "lastModifiedDate", ignore = true)
@Mapping(target = "modifiedIp", ignore = true)
@Mapping(target = "deletedAt", ignore = true)
@Mapping(target = "createdIp", ignore = true)
public @interface IgnoreAuditFields {

}
