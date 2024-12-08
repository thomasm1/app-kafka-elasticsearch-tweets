package com.friendsofgroot.app.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
public class BaseModel implements Serializable {
        @Serial
        private static final long serialVersionUID = 1L;

        @Version
        private Integer version;


        //
        @CreationTimestamp
        @Column(name = "date_created", nullable = false, updatable = false)
        private Date dateCreated;

        @CreationTimestamp
        @Column(name = "created_date", nullable = false, updatable = false)
        private LocalDateTime createdDate;


        @UpdateTimestamp
        @Column(name = "last_updated")
        private LocalDateTime lastUpdated;

        @Column(name = "updated_at")
        @UpdateTimestamp
        private Timestamp updatedAt;
}
