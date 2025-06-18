package com.dentalsoft.finantialManagement.entity.common;

import jakarta.persistence.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @CreatedBy
    @Column
    private String createdBy;

    @LastModifiedBy
    private String lastModifiedBy;
    @Version
    private Long version;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;

    private LocalDateTime deletedAt;

    private String modifiedIp;
    @Column(updatable = false)
    private String createdIp;

    @PrePersist
    public void onPrePersist() {
        ServletRequestAttributes attr=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attr!=null) {
            HttpServletRequest request=attr.getRequest();
            String ip=getClientIp(request);
            this.createdIp=ip;
            this.modifiedIp=ip;
        }else{
            if(this.createdIp==null || this.createdIp.isBlank()){
                this.createdIp="UNKNOWN";
            }
        }
    }
    @PreUpdate
    public void onPreUpdate() {
        ServletRequestAttributes attr=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        if (attr!=null) {
            HttpServletRequest request=attr.getRequest();
            String ip=getClientIp(request);
            this.modifiedIp=ip;
        }else{
            if(this.modifiedIp==null || this.modifiedIp.isBlank()){
                this.modifiedIp="UNKNOWN";
            }
        }
    }

    private String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
    if (ip != null && !ip.isBlank()) {
        return ip.split(",")[0];

        }
        return request.getRemoteAddr();
    }

    private String getServerIp() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return "UNKNOWN";
        }
    }

}
