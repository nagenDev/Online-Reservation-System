Got it 👍 I’ll include **all screenshots (681–693)** in the README under the 📸 Screenshots section.
Here’s the **final complete copiable README.md**:

---

```markdown
# 🛤️ Online Reservation System

![Project Banner](https://github.com/nagenDev/Online-Reservation-System/blob/main/Images3/Screenshot%20(681).png?raw=true)

This is a **Spring Boot 3 + Java 17 + MongoDB + JWT** based Online Reservation System.  
The system allows users to **register, login, make reservations, view reservations, and cancel tickets** using a secure API.  

---

## 📌 Features

- **User Authentication & Authorization**
  - JWT-based login & registration
- **Reservation System**
  - Book tickets with passenger details, train info, class, journey date, and stations
  - Auto-generated **PNR Number**
- **Cancellation System**
  - Cancel tickets with confirmation (`ok=true`)
- **MongoDB Integration**
  - Centralized database storage
- **Swagger/OpenAPI**
  - Easy API documentation at `/swagger-ui.html`
- **Global Exception Handling**
- **Unit Tests**
  - Ensures PNR generation works correctly

---

## 📂 Project Structure

```

online-reservation-system-mongo
┣ 📁 src/main/java/com/example/ors
┃ ┣ 📁 controllers
┃ ┣ 📁 services
┃ ┣ 📁 repositories
┃ ┣ 📁 security
┃ ┗ 📁 models
┣ 📁 src/test/java/com/example/ors
┗ 📄 application.properties

````

---

## 🚀 Run Locally

### 1️⃣ Start MongoDB  
Default connection: `mongodb://localhost:27017/ors`  
(You can change it in `src/main/resources/application.properties`)

### 2️⃣ Build & Run  
```bash
mvn spring-boot:run
````

### 3️⃣ Try API Flow

#### Register User

```http
POST /auth/register
```

```json
{ "username": "u1", "password": "secret123" }
```

#### Login User

```http
POST /auth/login
```

Response:

```json
{ "token": "..." }
```

Use header:

```
Authorization: Bearer <token>
```

#### Create Reservation

```http
POST /reservations
```

```json
{
  "passengerName": "Amit",
  "trainNumber": "12951",
  "trainName": "Rajdhani",
  "classType": "3A",
  "dateOfJourney": "2025-12-20",
  "fromStation": "NDLS",
  "toStation": "MMCT"
}
```

#### Get Reservation by PNR

```http
GET /reservations/{pnr}
```

#### List All Reservations

```http
GET /reservations
```

#### Cancel Reservation

```http
DELETE /reservations/{pnr}?ok=true
```

---

## 🧪 Testing

* Includes `ReservationServiceTest`
* Ensures **PNR number generation** works as expected

---

## 📖 Modules Overview

* **Login Form** → Secure login with username & password
* **Reservation Form** → Fill in passenger + train details to generate a PNR
* **Cancellation Form** → Cancel ticket using PNR number with confirmation

---

## 📸 Screenshots

Here are all project screenshots (681–693):

![Screenshot](https://github.com/nagenDev/Online-Reservation-System/blob/main/Images3/Screenshot%20\(681\).png?raw=true)
![Screenshot](https://github.com/nagenDev/Online-Reservation-System/blob/main/Images3/Screenshot%20\(682\).png?raw=true)
![Screenshot](https://github.com/nagenDev/Online-Reservation-System/blob/main/Images3/Screenshot%20\(683\).png?raw=true)
![Screenshot](https://github.com/nagenDev/Online-Reservation-System/blob/main/Images3/Screenshot%20\(684\).png?raw=true)
![Screenshot](https://github.com/nagenDev/Online-Reservation-System/blob/main/Images3/Screenshot%20\(685\).png?raw=true)
![Screenshot](https://github.com/nagenDev/Online-Reservation-System/blob/main/Images3/Screenshot%20\(689\).png?raw=true)
![Screenshot](https://github.com/nagenDev/Online-Reservation-System/blob/main/Images3/Screenshot%20\(690\).png?raw=true)
![Screenshot](https://github.com/nagenDev/Online-Reservation-System/blob/main/Images3/Screenshot%20\(691\).png?raw=true)
![Screenshot](https://github.com/nagenDev/Online-Reservation-System/blob/main/Images3/Screenshot%20\(692\).png?raw=true)
![Screenshot](https://github.com/nagenDev/Online-Reservation-System/blob/main/Images3/Screenshot%20\(693\).png?raw=true)

---

## 🔮 Future Enhancements

* Role-based Admin Endpoints (approve/manage reservations)
* Dockerfile & Compose (MongoDB + Spring Boot)
* JWT Refresh Tokens
* Postman Collection for quick testing

---

## 🤝 Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss what you’d like to change.

---
