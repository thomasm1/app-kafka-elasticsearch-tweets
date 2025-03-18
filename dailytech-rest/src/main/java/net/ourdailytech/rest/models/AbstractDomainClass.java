package net.ourdailytech.rest.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import lombok.Data;

import java.util.Date;

@Data
public class AbstractDomainClass  {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Long id;

        @Version
        private Integer version;
        private Date dateCreated;
        private Date lastUpdated;

}
