package aliikbal.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import aliikbal.model.Employee;
import aliikbal.repository.EmployeeRepository;
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

    public byte[] generateEmployeeReport(String department, LocalDate startDate, LocalDate endDate) {
        try {
            List<Employee> employees = employeeRepository.findByDepartmentAndHireDateBetween(department, startDate,
                    endDate);
            File file = ResourceUtils.getFile("classpath:reports/employee_report.jrxml");
            InputStream input = new FileInputStream(file);

            JasperReport jasperReport = JasperCompileManager.compileReport(input);
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("department", department);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
            return JasperExportManager.exportReportToPdf(jasperPrint);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
