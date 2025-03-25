package aliikbal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aliikbal.model.PerformanceEvaluation;

@Repository
public interface PerformanceEvaluationRepository extends JpaRepository<PerformanceEvaluation, Long> {
    List<PerformanceEvaluation> findByEmployeeId(Long employeeId);

}
