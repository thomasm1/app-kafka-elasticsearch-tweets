package app.mapl.rest.mapl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MaplRepository extends JpaRepository <MaplTopic,UUID> {


}
