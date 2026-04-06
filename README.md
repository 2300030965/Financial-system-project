# 💰 Financial System Project

## 📌 Overview
The Financial System Project is a backend application developed using **Spring Boot** and **MySQL**.  
It provides a complete solution for managing financial operations such as transactions, loans, investments, and insurance with **role-based access control**.

---

## 🚀 Features

### 👤 Customer
- Register and Login
- Manage Wallet (Add / Withdraw Money)
- Perform Transactions
- Apply for Loans
- Invest Money
- Take Insurance
- View History

### 🛠 Admin
- Manage Users
- Approve / Reject Loans
- Manage Transactions
- Approve / Reject Insurance
- View Reports and Dashboard

### 👁 Viewer
- View Transactions
- View Loans
- View Investments
- View Insurance (Read-only)

---

## 🏗️ Tech Stack

- **Backend:** Spring Boot (Java)
- **Database:** MySQL (Railway)
- **Build Tool:** Maven
- **Security:** JWT Authentication
- **Deployment:** Railway / Render
- **API Testing:** Postman

---

## 📂 Project Structure
com.klef.fsad
│
├── controller
│ ├── admin
│ ├── customer
│ └── viewer
│
├── service
│ ├── admin
│ ├── customer
│ └── viewer
│
├── repository
├── entity
├── dto
├── security
└── config


---

## 🔐 Authentication APIs

| Method | Endpoint | Description |
|--------|---------|-------------|
| POST | /api/auth/register | Register new user |
| POST | /api/auth/login | Login user |

---

## 👤 Customer APIs

### Wallet
- GET `/api/customer/wallet`
- POST `/api/customer/wallet/add`

### Transactions
- POST `/api/customer/transactions`
- GET `/api/customer/transactions`

### Loan
- POST `/api/customer/loans`
- GET `/api/customer/loans`

### Insurance
- POST `/api/customer/insurance`
- GET `/api/customer/insurance`
- PUT `/api/customer/insurance/{id}`
- DELETE `/api/customer/insurance/{id}`

---

## 🛠 Admin APIs

### Users
- GET `/api/admin/users`

### Loans
- GET `/api/admin/loans`
- PUT `/api/admin/loans/{id}/approve`
- PUT `/api/admin/loans/{id}/reject`

### Insurance
- GET `/api/admin/insurance`
- PUT `/api/admin/insurance/{id}/approve`
- PUT `/api/admin/insurance/{id}/reject`
- DELETE `/api/admin/insurance/{id}`

---

## 👁 Viewer APIs

- GET `/api/viewer/transactions`
- GET `/api/viewer/loans`
- GET `/api/viewer/investments`
- GET `/api/viewer/insurance`

---

## 🔄 Workflow

### Insurance Flow
1. Customer applies insurance  
2. Status = PENDING  
3. Admin approves/rejects  
4. Viewer can only view  

### Loan Flow
1. Customer applies loan  
2. Admin approves/rejects  
3. Customer pays EMI  
4. Payments are tracked  

---

## 🗄️ Database Tables

- User
- Wallet
- Transaction
- Loan
- LoanPayment
- Investment
- Insurance
- KYC

---

## ⚙️ Setup Instructions

### 1. Clone Repository
```bash
git clone https://github.com/2300030965/Financial-system-project.git

2. Configure Database

Update application.properties:

spring.datasource.url=YOUR_DB_URL
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
3. Run Application
mvn spring-boot:run
