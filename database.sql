INSERT INTO employees (name, department, salary, hire_date) VALUES
('Ali Ikbal', 'IT', 12000.00, '2020-05-15'),
('Budi Santoso', 'Finance', 9000.00, '2019-07-10'),
('Citra Dewi', 'HR', 8500.00, '2021-02-20'),
('Dewi Lestari', 'IT', 13000.00, '2018-11-05'),
('Eko Prasetyo', 'Finance', 7500.00, '2022-06-18');

INSERT INTO job_history (employee_id, position, salary, start_date, end_date) VALUES
(1, 'Junior Developer', 8000.00, '2020-05-15', '2021-06-01'),
(1, 'Mid Developer', 10000.00, '2021-06-02', '2022-08-30'),
(1, 'Senior Developer', 12000.00, '2022-09-01', NULL),
(2, 'Junior Accountant', 6000.00, '2019-07-10', '2020-09-15'),
(2, 'Accountant', 7500.00, '2020-09-16', '2022-05-01'),
(2, 'Senior Accountant', 9000.00, '2022-05-02', NULL),
(3, 'HR Assistant', 7000.00, '2021-02-20', '2022-03-30'),
(3, 'HR Specialist', 8500.00, '2022-04-01', NULL),
(4, 'IT Support', 10000.00, '2018-11-05', '2020-01-15'),
(4, 'System Analyst', 12000.00, '2020-01-16', '2022-07-10'),
(4, 'IT Manager', 13000.00, '2022-07-11', NULL),
(5, 'Finance Assistant', 6000.00, '2022-06-18', '2023-01-30'),
(5, 'Finance Executive', 7500.00, '2023-02-01', NULL);

INSERT INTO performance_evaluations (employee_id, year, rating, feedback) VALUES
(1, 2021, 4, 'Consistently meets expectations'),
(1, 2022, 5, 'Outstanding performance and leadership'),
(1, 2023, 5, 'Exceptional technical skills and problem-solving'),
(2, 2020, 3, 'Satisfactory performance with room for improvement'),
(2, 2021, 4, 'Good performance with increased responsibility'),
(2, 2022, 5, 'Excellent analytical and accounting skills'),
(3, 2022, 2, 'Needs improvement in conflict resolution'),
(3, 2023, 3, 'Slight improvement in HR management'),
(4, 2019, 3, 'Meets expectations but lacks innovation'),
(4, 2020, 4, 'Good technical skills and problem-solving'),
(4, 2021, 4, 'Reliable and efficient in IT management'),
(4, 2022, 5, 'Excellent strategic planning and IT leadership'),
(5, 2023, 3, 'Average performance, needs improvement in financial reporting');

SELECT * FROM employees WHERE department = 'IT' AND hire_date BETWEEN '2020-01-01' AND '2024-01-01';
