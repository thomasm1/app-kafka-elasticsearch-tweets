package app.mapl.models;

import lombok.Data;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;

import java.io.Serializable;
import java.util.Date;

@Data
public class AbstractDomainClass implements Serializable {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        Integer id;

        @Version
        private Integer version;
        private Date dateCreated;
        private Date lastUpdated;

}
