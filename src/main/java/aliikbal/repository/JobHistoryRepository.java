package aliikbal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import aliikbal.model.JobHistory;

@Repository
public interface JobHistoryRepository extends JpaRepository<JobHistory, Long> {
    List<JobHistory> findByEmployeeId(Long employeeId);
}
