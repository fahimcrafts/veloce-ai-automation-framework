# Veloce.AI - Automation Framework

This repository contains a QA automation framework for an AI-powered fitness coaching platform.

## Project Overview
Veloce.AI is a QA automation framework built for a fictional AI-powered fitness coaching platform. The project simulates real-world test automation, including API testing, database validation, reporting, version control workflows, and CI/CD integration.

The framework is developed using Java, Maven, JUnit 5, Rest Assured, JDBC, MySQL, Allure Reporting, GitHub, and GitHub Actions. The goal of the project is to demonstrate practical QA engineering and SDET skills used in modern software organizations.

The framework validates application behavior across multiple layers:
- Unit validation tests for core logic
- API automation tests against Mockoon services
- SQL validation tests against a MySQL database
- CI-safe automated validation through GitHub Actions
- Test reporting through Allure

This repository is designed as a portfolio-quality automation framework that reflects industry-standard QA engineering practices.

## Technology Stack

| Technology     | Purpose                                             |
|----------------|-----------------------------------------------------|
| Java 21        | Programming language used for framework development |
| Maven          | Build and dependency management                     |
| JUnit 5        | Unit testing framework                              |
| Rest Assured   | Api automation testing                              |
| JDBC           | Database connectivity layer                                                    |
| MySQL          |  SQL validation environment                                                   |
| Mockoon        |        Mock API backend for testing                                             |
| Allure         |   Test reporting and result visualization                                                  |
| Git            |  Version control                                                   |
| GitHub         |      Source code management                                               |
| Github Actions |      Continuous Integration (CI) pipeline                                               |

## Framework Architecture
The framework follows a layered architecture consisting of unit tests, API tests, and database validation tests, supported by shared reusable components for maintainability and scalability.
### Test Layers
- Unit Tests
  - CoreValidationTests
  - UtilityTests
- API Tests
    - UserApiTest
    - WorkoutApiTest
    - MealApiTest
    - SubscriptionApiTest
- SQL Validation Tests
  - UserSqlValidationTest
  - SubscriptionSqlValidationTest
  - ProgressSqlValidationTest
### Shared Framework Components
- BaseTest
- ApiFactory
- SessionManager
- Assertion Classes
- Models
- Database Utilities

These components are executed within the CI pipeline to ensure consistent and repeatable test execution across environments.

## CI/CD Pipeline (GitHub Actions)

The Veloce.AI automation framework uses GitHub Actions to run continuous integration (CI) tests automatically on every code push or pull request.

### CI Workflow Overview

The pipeline is triggered on:
- Push to main branch
- Pull request creation or updates

GitHub Actions executes a Maven-based build pipeline using the following command:
```bash
mvn clean test
```
The pipeline flow is: code push -> GitHub Actions workflow trigger -> Maven build and test execution -> test result reporting in GitHub Actions.

## Branch Strategy
- main -> stable release branch
- feature/* -> isolated development work

## API Test Module
The API test suite validates core application endpoints including user workflows, workout management, meal tracking, and subscription services using Rest Assured-based automation.