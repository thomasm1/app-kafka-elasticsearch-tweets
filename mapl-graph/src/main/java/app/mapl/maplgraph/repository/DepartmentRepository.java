package app.mapl.maplgraph.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import app.mapl.maplgraph.entity.Department;

@Repository
public interface DepartmentRepository extends Neo4jRepository<Department, Long> {

}
