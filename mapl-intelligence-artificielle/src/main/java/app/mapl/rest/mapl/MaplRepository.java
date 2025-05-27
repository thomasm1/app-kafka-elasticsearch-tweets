package app.mapl.rest.mapl;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaplRepository extends JpaRepository <MaplTopic,UUID> {


}
