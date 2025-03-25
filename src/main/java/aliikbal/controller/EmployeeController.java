package aliikbal.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;

import aliikbal.service.EmployeeService;

@RestController
@RequestMapping("/reports")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<byte[]> getEmployeeReport(
            @RequestParam String department,
            @RequestParam LocalDate startDate,
            @RequestParam LocalDate endDate) {
        byte[] report = employeeService.generateEmployeeReport(department, startDate, endDate);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=employee_report.pdf")
                .contentType(MediaType.APPLICATION_PDF)
                .body(report);
    }
}
