package app.mapl.models;

import app.mapl.exception.ApiException;
import app.mapl.models.auth.RequestContext;
import app.mapl.models.auth.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.util.AlternativeJdkIdGenerator;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static java.time.LocalTime.now;

@Setter
@Getter
@MappedSuperclass
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt"}, allowGetters = true )
public abstract class  BaseModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "primary_key_seq", sequenceName = "primary_key_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_key_seq")
    @Column(name="id", updatable = false )
    private Long id;

    private String referenceId = new AlternativeJdkIdGenerator().generateId().toString();


    @Version
    private Integer version; // for optimistic locking

    @NotNull
    private Long createdBy;
    @NotNull
    private Long updatedBy;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @CreatedDate
    @Column(name = "updated_at", nullable = false )
    private LocalDateTime updatedAt;

    @Column(name = "date_created",   updatable = false)
    @CreatedDate
    private LocalDate dateCreated;

    @Column(name = "last_updated")
    @UpdateTimestamp
    private Timestamp lastUpdated;

    /*
    * Owner of the entity
     */
    @OneToMany
    @JoinColumn(
            name="owner_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "fk_user_owner", value=ConstraintMode.CONSTRAINT)
    )
    private List<User> owner; // instances of same user, multiple user-logins owned by user
    @PrePersist
    public void beforePersist() {
        var usesrId =  RequestContext.getUserId();
        if((usesrId != 1) && (usesrId > 0)) {
            setCreatedBy(usesrId);
            setUpdatedBy(usesrId);
            setCreatedAt(LocalDateTime.from(now()));
            setUpdatedAt(LocalDateTime.now());
            setLastUpdated(Timestamp.valueOf(LocalDateTime.now()));
            setDateCreated(LocalDate.now());

        } else {
            throw new ApiException("User not found");
        }
    }
    @PreUpdate
    public void beforeUpdate() {
        var usesrId =  RequestContext.getUserId();
        if((usesrId != null) && (usesrId > 0)) {
            setUpdatedBy(usesrId);
            setUpdatedAt(LocalDateTime.now());
            setLastUpdated(Timestamp.valueOf(LocalDateTime.now()));
        } else {
            throw new ApiException(String.format("Cannot update if User  %s not found", usesrId));
        }
        setUpdatedAt(LocalDateTime.now());
        setLastUpdated(Timestamp.valueOf(LocalDateTime.now()));
    }


}
