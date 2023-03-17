package poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import poc.model.Hospital;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {
}
