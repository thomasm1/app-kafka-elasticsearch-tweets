package app.mapl.models;

import app.mapl.exception.ApiException;
import app.mapl.util.Shareable;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.AlternativeJdkIdGenerator;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Setter
@Getter
@MappedSuperclass
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true )
public abstract class  BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", updatable = false, nullable = false)
    private long id;

    private String referenceId = new AlternativeJdkIdGenerator().generateId().toString();


    @Version
    private Integer version; // for optimistic locking

    @NotNull
    private Long createdBy;
    @NotNull Long updatedBy;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "updated_at")
    @UpdateTimestamp
    private Timestamp updatedAt;

    @CreatedDate
    @Column(name = "date_created", nullable = false, updatable = false)
    private LocalDateTime dateCreated;

    @CreatedDate
    @Column(name = "last_updated", nullable = false )
    private LocalDateTime lastUpdated;

    @PrePersist
    public void beforePersist() {
        var usesrId = RequestContext.getUserId();
        if(usesrId != null) {
            this.createdBy = usesrId;
            this.updatedBy = usesrId;
        } else {
            throw new ApiException("User not found");
        }
        this.dateCreated = LocalDateTime.now();
        this.lastUpdated = LocalDateTime.now();
    }
    @PreUpdate
    public void beforeUpdate() {
        var usesrId = RequestContext.getUserId();
        if(usesrId != null) {
            this.updatedBy = usesrId;
        } else {
            throw new ApiException("Cannot update if User not found");
        }
        this.lastUpdated = LocalDateTime.now();
    }


}
