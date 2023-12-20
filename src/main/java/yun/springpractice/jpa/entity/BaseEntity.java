package yun.springpractice.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.util.Date;

@MappedSuperclass
public class BaseEntity {
    private Date createdDate;
    private Date lastModifiedDate;
}
