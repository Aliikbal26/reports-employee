package aliikbal.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import aliikbal.model.Employee;
import aliikbal.model.JobHistory;
import aliikbal.repository.EmployeeRepository;
import aliikbal.repository.JobHistoryRepository;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private JobHistoryRepository jobHistoryRepository;

    public byte[] generateEmployeeReport(String department, LocalDate startDate, LocalDate endDate) {
        try {
            List<Employee> employees = employeeRepository.findByDepartmentAndHireDateBetween(department, startDate,
                    endDate);
            File file = ResourceUtils.getFile("classpath:reports/employee_report.jrxml");
            InputStream input = new FileInputStream(file);
            JasperReport jasperReport = JasperCompileManager.compileReport(input);

            File jobHistoryFile = ResourceUtils.getFile("classpath:reports/job_history.jrxml");
            JasperReport jobHistoryReport = JasperCompileManager.compileReport(new FileInputStream(jobHistoryFile));

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("department", department);
            parameters.put("jobHistoryReport", jobHistoryReport);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public byte[] generateJobHistoryReport(Long employeeId) {
        try {
            List<JobHistory> jobHistories = jobHistoryRepository.findByEmployee_Id(employeeId);
            if (jobHistories.isEmpty()) {
                return null;
            }

            File jobHistoryFile = ResourceUtils.getFile("classpath:reports/job_history.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(new FileInputStream(jobHistoryFile));

            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(jobHistories);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("employeeId", employeeId);

            // Mengisi laporan
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
