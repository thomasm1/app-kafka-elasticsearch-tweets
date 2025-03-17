package xyz.cryptomaven.rest.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import jakarta.persistence.*;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Table(name = "attribute")
public class Attribute  extends AbstractDomainClass {
  private static final long serialVersionUID = 1L;
    @Id
    Long attrid;
    String attribute_value;
    String trait_type;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "metadata_coin_id")
    Metadata metadata;




}
