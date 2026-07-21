# 🌐 Feedify

A social media platform that connects users through posts, follows, personalized feeds, and community moderation.

## ✨ Features

### 🔐 Authentication & Authorization
- User registration and login
- Google OAuth signup and login
- Forgot password flow with OTP verification
- Admin promotion and demotion

---

### 👤 User Features & Settings
- Update username, password, and profile picture
- Manage personal interests
- View account settings and info
- Follow / unfollow other users
- View followers, following, and their counts
- Check if a user is followed

---

### 🔍 Search & Discovery
- Search for users by username (case-insensitive)
- Search for users by email (case-insensitive)

---

### 📰 Feed
- Personal profile feed
- Following feed (posts from followed users)
- Topics feed (posts by interest)

---

### 📝 Posts & Reposts
- Create posts with optional image upload
- Retrieve post types
- Retrieve a single post by ID
- Repost existing posts to your profile
- View a list of all users who reposted a specific post

---

### 🚩 Reporting & Moderation
- Report a post or user
- Admin: view all post/user reports
- Admin: approve (remove content) or deny reports
- Admin: view all users and all admins

---

## 📡 REST API

### Authentication
| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/signup` | Register a new user |
| POST | `/login` | User login |
| POST | `/api/auth/signupGoogle` | Register via Google |
| POST | `/api/auth/loginGoogle` | Login via Google |
| POST | `/request-password-reset` | Request OTP for password reset |
| POST | `/verify-otp` | Verify password reset OTP |
| POST | `/change-password` | Change password after OTP verification |

---

### Admin
| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/admin/users` | Retrieve all users |
| GET | `/admin/admins` | Retrieve all admins |
| POST | `/admin/promote` | Promote a user to admin |
| POST | `/admin/demote` | Demote an admin to user |

---

### Reports
| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `report/post/newReport` | Report a post |
| POST | `report/user/newReport` | Report a user |
| GET | `/admin/report/post/all` | Retrieve all post reports |
| DELETE | `/admin/report/post/approve/{reportID}` | Approve report and remove post |
| DELETE | `/admin/report/post/deny/{reportID}` | Deny a post report |
| GET | `/admin/report/user/all` | Retrieve all user reports |
| DELETE | `/admin/report/user/approve/{reportID}` | Approve report and remove user |
| DELETE | `/admin/report/user/deny/{reportID}` | Deny a user report |

---

### Follow System
| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/follow` | Follow a user |
| POST | `/unfollow` | Unfollow a user |
| GET | `/following` | Retrieve list of followed users |
| GET | `/followers` | Retrieve list of followers |
| GET | `/following-count` | Retrieve following count |
| GET | `/follower-count` | Retrieve follower count |
| POST | `/is-followed` | Check if a user is followed |

---

### Search
| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/search/username/{username}` | Search users by username |
| GET | `/search/email/{email}` | Search users by email |

---

### Feed
| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/userProfile/profileFeed` | Retrieve a user's profile feed |
| GET | `/userProfile/followingFeed` | Retrieve feed from followed users |
| GET | `/userProfile/topicsFeed` | Retrieve feed by topics/interests |

---

### Posts
| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/post/createPost` | Create a new post (with optional image) |
| GET | `/post/getTypes` | Retrieve all post types |
| GET | `/post/{postID}` | Retrieve a post by ID |

---

### Reposts
| Method | Endpoint | Description |
|---------|----------|-------------|
| POST | `/api/reposts/repost` | Repost a post |
| POST | `/api/reposts/users` | Retrieve users who reposted a post |

---

### User Settings
| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/userSettings/info` | Retrieve user account info |
| GET | `/userSettings/interests` | Retrieve user interests |
| POST | `/userSettings/changeInterests` | Update user interests |
| PUT | `/userSettings/changeUsername` | Change username |
| PUT | `/userSettings/changePassword` | Change password |
| PUT | `/userSettings/changeProfilePic` | Change profile picture |
| DELETE | `/userSettings/removeProfilePic` | Remove profile picture |

---

## 🛠️ Tech Stack
- Java
- Spring Boot
- RESTful APIs
- React.js
- Multipart file upload (profile pictures & post images)
- Gson

---

## 🔒 Security & Architecture
- Role-based access (User, Admin)
- Custom exception handling for auth, follow, report, and OTP flows
- Google OAuth integration
- Strategy Design Pattern implemented for scalable user search

---

## 📈 Core Functionalities
- User authentication (standard + Google)
- Password recovery via OTP
- User discovery via username and email search
- Post creation, retrieval, and reposting capabilities
- Follow / unfollow system
- Personalized feeds (profile, following, topics)
- Content moderation via user & post reporting
- Admin management (promote/demote, view reports)
- User settings management (username, password, profile picture, interests)
