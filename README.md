# Feedify - The Personalized Social Media Platform

![Feedify Logo](https://img.shields.io/badge/Feedify-%23FF6F61?style=for-the-badge&logo=feedify&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![React](https://img.shields.io/badge/React-61DAFB?style=for-the-badge&logo=react&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

**Join our growing community of 0+ developers!** ⭐ [Star this repo](https://github.com/yourusername/Feedify) to show your support!

---

## 🚀 Overview

Feedify is a modern, personalized social media platform designed to deliver content tailored to your interests. Built with a powerful backend using **Spring Boot** and a responsive frontend with **React**, Feedify offers a seamless experience for users to create, share, and discover content.

### Key Features:
✅ **Personalized Feeds** - AI-driven content recommendations based on user preferences
✅ **Real-time Interactions** - Instant notifications and WebSocket support
✅ **Role-based Access Control** - Admin dashboard for content moderation
✅ **Social Engagement** - Like, comment, and repost functionality
✅ **Google OAuth Integration** - Secure and easy login with Google
✅ **Responsive Design** - Works perfectly on all devices
✅ **Content Moderation** - Robust reporting system for posts and users

### Who is this for?
- Developers looking to build a modern social media platform
- Tech enthusiasts interested in full-stack Java/React applications
- Anyone wanting to create a personalized content experience

---

## ✨ Features

### Core Features
- **User Authentication**: Secure login with email/password and Google OAuth
- **Personalized Feeds**: Dynamic content based on user interests and activity
- **Social Interactions**: Like, comment, and repost functionality
- **Real-time Notifications**: Instant updates via WebSockets
- **Admin Dashboard**: Comprehensive tools for content moderation and user management

### Advanced Features
- **Role-based Access Control**: Fine-grained permissions for different user roles
- **Content Reporting System**: Users can report inappropriate content
- **Profile Customization**: Users can edit their profiles and interests
- **Password Recovery**: Secure OTP-based password reset system
- **Responsive UI**: Beautiful, mobile-friendly interface

### Technical Features
- **Microservices Architecture**: Modular backend components
- **Database Optimization**: MySQL for efficient data storage
- **CI/CD Pipeline**: Automated testing and deployment with GitHub Actions
- **Containerization**: Docker support for easy deployment
- **Security**: JWT authentication and role-based authorization

---

## 🛠️ Tech Stack

### Backend
- **Language**: Java 23
- **Framework**: Spring Boot 3.4.0
- **Database**: MySQL 8.0
- **Authentication**: JWT (JSON Web Tokens)
- **Security**: Spring Security
- **Build Tool**: Maven
- **Testing**: JUnit 5
- **API**: RESTful endpoints

### Frontend
- **Framework**: React 18.3.1
- **State Management**: React Context API
- **Styling**: CSS Modules, Styled Components
- **Routing**: React Router 7.0.1
- **Authentication**: Google OAuth 2.0
- **Build Tool**: Vite
- **UI Components**: Font Awesome, Lucide React

### DevOps & Tools
- **CI/CD**: GitHub Actions
- **Containerization**: Docker
- **Version Control**: Git
- **Project Management**: Jira
- **Design**: Figma (for UI/UX)

### System Requirements
- **Java 23** (or compatible version)
- **Node.js 20+** (for frontend)
- **MySQL 8.0+** (or compatible database)
- **Git** (for version control)

---

## 📦 Installation

### Prerequisites

Before you begin, ensure you have the following installed:
- [Java JDK 23](https://www.oracle.com/java/technologies/javase-jdk13-downloads.html)
- [Node.js 20+](https://nodejs.org/)
- [MySQL 8.0+](https://dev.mysql.com/downloads/)
- [Git](https://git-scm.com/downloads)
- [Maven](https://maven.apache.org/install.html)

### Quick Start

#### 1. Clone the Repository
```bash
git clone https://github.com/yourusername/Feedify.git
cd Feedify
```

#### 2. Set Up the Database
Create a MySQL database named `feedify` and update the database configuration in `backend/src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/feedify
spring.datasource.username=your_username
spring.datasource.password=your_password
```

#### 3. Configure Environment Variables
Create a `.env` file in the `frontend` directory with your environment variables:
```env
VITE_API_BASE_URL=http://localhost:8080
```

#### 4. Install Dependencies
```bash
# Install backend dependencies
cd backend
./mvnw clean install

# Install frontend dependencies
cd ../frontend
npm install
```

#### 5. Run the Application
```bash
# Start the backend server
cd backend
./mvnw spring-boot:run

# In a new terminal, start the frontend
cd ../frontend
npm run dev
```

#### 6. Access the Application
Open your browser and navigate to:
```
http://localhost:5173
```

---

## 🎯 Usage

### Basic Usage

#### Creating a Post
```jsx
// Example of creating a post from the CreatePost component
const handlePostSubmit = async (e) => {
    e.preventDefault();

    const postData = {
        content: "This is my new post!",
        types: [{ id: 1, name: "Technology" }],
        imageURL: ""
    };

    try {
        const response = await fetch("http://localhost:8080/post/newPost", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Authorization": `Bearer ${localStorage.getItem("jwttoken")}`
            },
            body: JSON.stringify(postData)
        });

        if (response.ok) {
            console.log("Post created successfully!");
        } else {
            console.error("Failed to create post");
        }
    } catch (error) {
        console.error("Error creating post:", error);
    }
};
```

#### Reporting a User
```jsx
// Example of reporting a user from the ReportDialog component
const reportUser = () => {
    axios.post('http://localhost:8080/report/user/newReport',
        {
            reportedID: userId,
            reason: "Inappropriate content"
        },
        {
            headers: {
                "Authorization": "Bearer " + localStorage.getItem("jwttoken"),
            }
        }
    )
    .then(response => {
        console.log("Report submitted successfully!");
    })
    .catch(error => {
        console.error("Error submitting report:", error);
    });
};
```

#### Admin: Promoting a User
```java
// Example of promoting a user from the backend AdminController
@PostMapping("/promote")
public ResponseEntity<String> promoteUser(@RequestBody Map<String, Long> request) {
    Long userId = request.get("userId");
    try {
        adminService.promoteUser(userId);
        return ResponseEntity.ok("User promoted successfully");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Failed to promote user: " + e.getMessage());
    }
}
```

### Advanced Usage

#### Customizing the Feed Algorithm
The feed algorithm can be customized by modifying the `UserProfileService` in the backend. You can adjust the weights for different factors like user interests, post engagement, and recency.

#### Implementing New Content Types
To add a new content type (e.g., "Sports"), follow these steps:

1. **Backend**:
   - Add the new type to the `PostType` entity in the database
   - Update the `PostTypeRepository` and `PostTypeService`
   - Add the new type to the `Post` entity

2. **Frontend**:
   - Add the new type to the list of available types in `CreatePost.jsx`
   - Update the UI components to display the new type

#### Setting Up Docker

1. Create a `docker-compose.yml` file:
```yaml
version: '3.8'

services:
  backend:
    build: ./backend
    ports:
      - "8080:8080"
    environment:
      - SPRING_DATASOURCE_URL=jdbc:mysql://db:3306/feedify
      - SPRING_DATASOURCE_USERNAME=admin
      - SPRING_DATASOURCE_PASSWORD=admin
    depends_on:
      - db

  frontend:
    build: ./frontend
    ports:
      - "5173:5173"
    depends_on:
      - backend

  db:
    image: mysql:8.0
    environment:
      - MYSQL_ROOT_PASSWORD=rootpass
      - MYSQL_DATABASE=feedify
      - MYSQL_USER=admin
      - MYSQL_PASSWORD=admin
    ports:
      - "3306:3306"
    volumes:
      - mysql_data:/var/lib/mysql

volumes:
  mysql_data:
```

2. Build and run the containers:
```bash
docker-compose up --build
```

---

## 📁 Project Structure

```
Feedify/
├── backend/                  # Spring Boot backend
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/feedify/  # Java source code
│   │   │   ├── resources/                  # Configuration files
│   │   │   └── ...
│   │   └── test/                      # Test files
│   ├── pom.xml                     # Maven build file
│   └── ...
├── frontend/                 # React frontend
│   ├── public/                    # Static files
│   ├── src/
│   │   ├── components/             # React components
│   │   ├── styles/                 # CSS files
│   │   ├── contexts/               # React context
│   │   ├── services/               # API services
│   │   ├── App.jsx                 # Main app component
│   │   └── main.jsx                # Entry point
│   ├── package.json               # Node.js dependencies
│   └── ...
├── .github/                   # GitHub workflows
│   └── workflows/
├── .gitignore                  # Git ignore rules
├── LICENSE                     # License file
├── README.md                   # This file
└── ...
```

---

## 🔧 Configuration

### Environment Variables

#### Backend Configuration
Create a `.env` file in the `backend` directory for local development:
```env
# Database Configuration
SPRING_DATASOURCE_URL=jdbc:mysql://localhost:3306/feedify
SPRING_DATASOURCE_USERNAME=feedify_admin
SPRING_DATASOURCE_PASSWORD=Admin@123

# JWT Configuration
JWT_SECRET=your_jwt_secret_key
JWT_EXPIRATION_DAYS=7

# Mailing Service
SENDGRID_API_KEY=your_sendgrid_key
EMAIL_SENDER=your_email@example.com

# File Upload Configuration
SPRING_SERVLET_MULTIPART_MAX_FILE_SIZE=10MB
SPRING_SERVLET_MULTIPART_MAX_REQUEST_SIZE=10MB
```

#### Frontend Configuration
Create a `.env` file in the `frontend` directory:
```env
VITE_API_BASE_URL=http://localhost:8080
VITE_GOOGLE_CLIENT_ID=your_google_client_id
```

### Customization Options

#### Theme Customization
To change the theme colors, modify the CSS variables in `frontend/src/index.css`:
```css
:root {
  --primary-color: #FF6F61;
  --secondary-color: #F67D94;
  --background-color: #f0faff;
  --text-color: #333;
  --card-bg: #fff;
  --border-color: #ddd;
}
```

#### Feed Algorithm Customization
The feed algorithm can be adjusted in the `UserProfileService` class. Modify the weights for different factors:
```java
public List<Post> getPersonalizedFeed(Long userId) {
    // Customize the weights for different factors
    double interestWeight = 0.4;
    double engagementWeight = 0.3;
    double recencyWeight = 0.3;

    // Your algorithm implementation here
}
```

---

## 🤝 Contributing

We welcome contributions from the community! Here's how you can get involved:

### Development Setup

1. **Fork the Repository**
   - Click the "Fork" button on the top right of this repository.

2. **Clone Your Fork**
   ```bash
   git clone https://github.com/yourusername/Feedify.git
   cd Feedify
   ```

3. **Set Up the Environment**
   - Follow the [Installation](#installation) instructions above.

4. **Create a New Branch**
   ```bash
   git checkout -b feature/your-feature-name
   ```

### Code Style Guidelines

- **Java**:
  - Follow the [Spring Boot Coding Conventions](https://docs.spring.io/spring-boot/docs/current/reference/html/using.html#using.build-tool-plugins-maven-java-formatting)
  - Use Lombok annotations for boilerplate code
  - Keep methods under 20 lines where possible

- **React**:
  - Use functional components with hooks
  - Follow the [Airbnb JavaScript Style Guide](https://github.com/airbnb/javascript)
  - Keep components modular and focused on a single responsibility

- **General**:
  - Write clear, concise commit messages
  - Follow the [Conventional Commits](https://www.conventionalcommits.org/) specification
  - Add tests for new features and bug fixes

### Pull Request Process

1. **Write Your Code**
   - Implement your feature or fix a bug.
   - Ensure your code follows the style guidelines.

2. **Write Tests**
   - Add unit tests for new functionality.
   - Run the tests locally to ensure they pass.

3. **Commit Your Changes**
   - Follow the [commit message conventions](CONTRIBUTORS.md) in the repository.

4. **Push to Your Branch**
   ```bash
   git add .
   git commit -m "feat: add new feature"
   git push origin feature/your-feature-name
   ```

5. **Open a Pull Request**
   - Go to the original repository and click "New Pull Request".
   - Select your branch and create the pull request.
   - Provide a clear description of your changes and why they should be merged.

6. **Review Process**
   - Our maintainers will review your pull request.
   - Address any feedback or requests for changes.
   - Once approved, your changes will be merged!

---

## 📝 License

This project is licensed under the **GNU General Public License v3.0**. See the [LICENSE](LICENSE) file for more details.
