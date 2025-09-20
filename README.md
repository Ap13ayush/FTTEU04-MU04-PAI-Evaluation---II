
---

## Setup Instructions

2. **Ensure you have [Java JDK 11+](https://adoptopenjdk.net/) and [Maven](https://maven.apache.org/) installed.**

3. **Install dependencies:**
    ```bash
    mvn clean install
    ```

---

## Test Scenarios Implemented

### 1. **Form Submission & Assertions**
- Fill and submit the "Text Box" form.
- Assert the output contains submitted user data.
- Expand tree and select "Documents" checkbox in "Check Box" section.

### 2. **Handling Complex UI Elements**
- Handle browser alerts (accept them).
- Switch to iframes and assert text inside.

### 3. **Data-Driven Testing**
- Fill and submit the "Practice Form" with multiple sets of user data using TestNG’s `@DataProvider`.
- Assert confirmation message contains correct details.

---

## How to Run the Tests

- To run all tests:
    ```bash
    mvn test
    ```

- To run a specific class:
    ```bash
    mvn -Dtest=FormTests test
    ```

- To use TestNG groups, add `-Dgroups=<groupname>`:
    ```bash
    mvn test -Dgroups=Regression
    ```

---

## Dependencies

- [Selenium Java](https://www.selenium.dev/)
- [TestNG](https://testng.org/doc/)
- [WebDriverManager](https://github.com/bonigarcia/webdrivermanager)
- Managed by Maven (see [pom.xml](pom.xml) for versions).

---

## Contribution

Contributions are welcome! Please create issues or pull requests for improvements or bug fixes.

---

## License

This project is open-source and free to use for learning and demonstration purposes.

---

*Happy Testing! 😃*

