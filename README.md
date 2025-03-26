# Test Case 
## Description 
 API ini menyediakan laporan dalam format JasperReports untuk menampilkan Job History dan Employee Report berdasarkan parameter tertentu.


# API Documentation

## Overview
API ini menyediakan laporan dalam format JasperReports untuk menampilkan Job History dan Employee Report berdasarkan parameter tertentu.

## Base URL
```
http://localhost:8080/reports
```

## Endpoints

### 1. Job History Report
**Endpoint:**
```
POST /history
```
**Description:**
Menghasilkan laporan Job History dalam format PDF berdasarkan `employeeId`.

**Example Request:**
```
POST http://localhost:8080/reports/history?employeeId=2
```

**Response:**
- **200 OK**: File PDF laporan Job History
---

### 2. Employee Report
**Endpoint:**
```
POST /employees
```
**Description:**
Menghasilkan laporan Employee berdasarkan department dan rentang tanggal tertentu.

**Example Request:**
```
POST http://localhost:8080/reports/employees?department=Finance&startDate=2020-01-01&endDate=2024-01-01
```

**Response:**
- **200 OK**: File PDF laporan Employee


