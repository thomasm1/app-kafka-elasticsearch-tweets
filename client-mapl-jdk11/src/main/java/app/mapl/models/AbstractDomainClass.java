package app.mapl.models;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;
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
