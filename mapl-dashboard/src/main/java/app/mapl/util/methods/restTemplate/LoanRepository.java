package app.mapl.util.methods.restTemplate;

import org.springframework.data.jpa.repository.JpaRepository;

//@Repository
public interface LoanRepository extends JpaRepository<LoanApplication, Integer> {

}
