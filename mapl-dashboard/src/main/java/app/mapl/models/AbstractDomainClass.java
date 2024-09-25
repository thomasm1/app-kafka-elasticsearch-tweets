package app.mapl.models;

import lombok.Data;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import java.util.Date;

@Data
public class AbstractDomainClass implements DomainObject {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Integer id;

        @Version
        private Integer version;
        private Date dateCreated;
        private Date lastUpdated;

}
