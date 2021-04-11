package com.user.api.userAPi.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Getter(AccessLevel.PROTECTED)
@Setter(AccessLevel.PROTECTED)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
abstract class BasicEntity<U>{

    @CreatedBy
    @Column(name="created_by",nullable = false,updatable = false)
    protected @NonNull U createdBy;

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="created_date",nullable = false,updatable = false)
    protected @NonNull Date createdDate;

    @LastModifiedBy
    @Column(name="last_modified_by",nullable = false)
    protected U lastModifiedBy;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_modified_date",nullable = false)
    protected Date lastModifiedDate;
}
