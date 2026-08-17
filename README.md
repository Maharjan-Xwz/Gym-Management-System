# 🏋️ Gym Member Management System

A Java Swing desktop application designed to manage gym memberships, track attendance, calculate loyalty points, and manage distinct plan tiers using Object-Oriented Programming (OOP) principles.

---

## 📌 Project Overview

The **Gym Member Management System** provides an interactive Graphical User Interface (GUI) to handle two main categories of gym memberships: **Regular Members** and **Premium Members**[cite: 1]. It features registration handling, attendance tracking with loyalty reward mechanisms, plan upgrades, and payment tracking[cite: 1, 3, 4].

---

## ✨ Features

* **Multi-Panel GUI Layout**: Built using Java Swing (`JFrame`, `JPanel`, `JButton`, `JComboBox`, `JTextField`)[cite: 1].
* **Member Registration**: Register regular and premium members with full personal details and flexible start dates[cite: 1].
* **Tiered Membership Options**:
  * **Regular Members**: Choice of Basic (6,500), Standard (12,500), or Deluxe (18,500) plans with attendance-based upgrade eligibility[cite: 4].
  * **Premium Members**: Fixed premium plan (50,000) supporting full/partial payment tracking and discount calculations[cite: 3].
* **Attendance & Rewards**:
  * Regular Member: +1 attendance, +5 loyalty points[cite: 4].
  * Premium Member: +1 attendance, +10 loyalty points[cite: 3].
* **Member Management**: Membership activation, deactivation, and revert operations[cite: 1, 2].
* **Input Validation & Data Checks**: Prevents duplicate IDs and handles input parsing safely using Swing dialog alerts (`JOptionPane`)[cite: 1].

---

## 🏗️ Object-Oriented Architecture

The system demonstrates fundamental OOP principles:

| Principle | Implementation in Code |
| :--- | :--- |
| **Abstraction** | `GymMember` is defined as an abstract parent class containing shared member properties and abstract methods[cite: 2]. |
| **Inheritance** | `RegularMember` and `PremiumMember` extend `GymMember` to reuse common fields (`id`, `name`, `phone`, `email`, etc.)[cite: 2, 3, 4]. |
| **Polymorphism** | Method overriding applied to `markAttendance()` and `display()` across subclasses[cite: 3, 4]. |
| **Encapsulation** | Sensitive fields are kept `private` or `protected`, exposed via public accessors (`getters`) and mutator logic[cite: 2, 3, 4]. |

---
## 📁 Class Structure
**`GymMember.java`**: Abstract parent class holding base member details, attendance count, and loyalty logic[cite: 2].
* **`RegularMember.java`**: Subclass managing regular plan tiers, upgrade conditions, and referral sources[cite: 4].
* **`PremiumMember.java`**: Subclass managing premium pricing, trainer assignment, payment status, and discounts[cite: 3].
* **`GymGUI.java`**: Entry point (`main`) handling Swing rendering, event dispatching, and list state[cite: 1].

## 🛠️ Requirements & Prerequisites

* **Java Development Kit (JDK)**: Version 8 or higher
* **IDE**: NetBeans, Eclipse, IntelliJ IDEA, or VS Code (with Java Extension Pack)

---

## 🚀 How to Run

1. **Clone the repository**:
   ```bash
   git clone [https://github.com/YOUR_USERNAME/Gym-Management-System.git](https://github.com/YOUR_USERNAME/Gym-Management-System.git)
   cd Gym-Management-System
2. **Compile the Java Files**:
   ```bash
   javac src/*.java
3. **Run the Application**:
   ```bash
   java -cp src GymGUI


