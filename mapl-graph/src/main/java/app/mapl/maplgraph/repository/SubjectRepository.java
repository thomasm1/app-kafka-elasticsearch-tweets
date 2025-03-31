package app.mapl.maplgraph.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import app.mapl.maplgraph.entity.Subject;

@Repository
public interface SubjectRepository extends Neo4jRepository<Subject, Long> {

}
