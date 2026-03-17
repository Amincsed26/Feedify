# 🌐 Feedify

> Your Friendly Neighborhood Social-Media Platform

Feedify is a full-stack social media web application built with a **Java Spring Boot** backend and a **React** frontend. It supports user interactions typical of a modern social platform, backed by a relational MySQL database with auto-managed schema via Spring Boot.

---

## 🛠️ Tech Stack

| Layer    | Technology              |
|----------|-------------------------|
| Backend  | Java 23, Spring Boot, Maven |
| Frontend | React, JavaScript, CSS (Vite/npm) |
| Database | MySQL                   |

---

## 📁 Project Structure

```
Feedify/
├── backend/        # Spring Boot application
├── frontend/       # React frontend (Vite)
├── .github/        # CI/CD workflows
├── package.json
└── README.md
```

---

## ⚙️ Setup

### Prerequisites

Make sure you have the following installed:

- **Java 23**
- **MySQL**
- **Node.js & npm**
- **Maven**

Verify your installations:

```bash
java --version
mysql --version
node --version
npm --version
```

---

### 1. Database Setup

Open your MySQL shell and run:

```sql
CREATE DATABASE feedify;
CREATE USER 'feedify_admin'@'localhost' IDENTIFIED BY 'Admin@123';
GRANT ALL PRIVILEGES ON feedify.* TO 'feedify_admin'@'localhost';
FLUSH PRIVILEGES;
```

> Spring Boot will automatically create and manage the tables on startup.

---

### 2. Backend Setup

From the project root:

```bash
cd backend
mvn clean install
mvn spring-boot:run
```

---

### 3. Frontend Setup

```bash
cd frontend
npm install
npm run dev
```

The frontend dev server will start, typically at `http://localhost:5173`.

---

## 📝 Important Notes

- Spring Boot auto-creates database tables on startup — do **not** run the app while actively editing an entity class.
- If you made a mistake in an entity, drop the table and restart:

  ```sql
  DROP TABLE IF EXISTS <table_name>;
  ```

- To inspect the database schema:

  ```sql
  SHOW TABLES;
  DESCRIBE <table_name>;
  ```

---

## 🤝 Contributing

Please read [CONTRIBUTERS.md](./CONTRIBUTERS.md) for branch naming and commit message conventions before opening a PR.

### Branch Naming

| Type | Pattern |
|------|---------|
| Milestone branch | `milestone{number}` |
| Feature branch | `milestone{number}/feat-[JIRA_ID]-[description]` |

### Commit Convention

```
feat: add user follow feature
fix: resolve feed pagination bug
refactor: clean up post service logic
chore: update dependencies
```

---

## 📄 License

This project is licensed under the [GNU General Public License v3.0](./LICENSE).
