# Naukari Selenium Java Automation Framework

A robust test automation framework built with Selenium WebDriver and Java for testing Naukari.com job portal functionality including login, profile management, and file upload capabilities.

## 🚀 Framework Overview

This framework is specifically designed to automate Naukari.com web application testing with focus on user authentication, profile management, resume upload, and profile update verification. It follows industry-standard Page Object Model (POM) design pattern and provides comprehensive test reporting.

## 🛠️ Technologies & Tools

- **Java** - Core programming language
- **Selenium WebDriver** - Web automation framework
- **TestNG** - Testing framework with annotations
- **Page Object Model (POM)** - Design pattern for maintainability
- **Allure Reports** - Advanced test reporting
- **Jenkins** - Continuous Integration/Deployment
- **Git/GitHub** - Version control system
- **Maven** - Build automation and dependency management
- **ChromeDriver** - Browser automation driver

## 📁 Project Structure

```
Naukari/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── org/example/
│   │           ├── base/
│   │           │   └── CommonToAllPages.java
│   │           ├── driver/
│   │           │   └── DriverManager.java
│   │           ├── POM/
│   │           │   ├── DashboardPage.java
│   │           │   ├── LoginPage.java
│   │           │   └── ViewProfile.java
│   │           └── utils/
│   │               └── PropertiesReader.java
│   ├── test/
│   │   └── java/
│   │       └── org/example/
│   │           ├── Sample/
│   │           │   └── Naukari.java
│   │           ├── base/
│   │           │   └── CommonToAllTest.java
│   │           └── test/
│   │               └── LoginToNaukari.java
│   └── resources/
│       ├── data.properties
│       └── Navaneeth H.K.pdf
├── allure-results/
├── target/
├── .gitignore
├── pom.xml
└── README.md
```

## 🎯 Key Features

- **Naukari Login Automation** - Secure login functionality testing
- **Profile Management** - View and update profile information
- **Resume Upload** - File upload functionality with validation
- **Dashboard Navigation** - Complete dashboard testing
- **Profile Update Verification** - Verify "updated today" status
- **Cross-browser Support** - Chrome, Firefox, Edge compatibility
- **Data-driven Testing** - External test data management
- **Allure Integration** - Rich HTML reports with screenshots
- **Jenkins CI/CD** - Automated pipeline integration
- **Page Object Model** - Maintainable and scalable architecture

## 🔧 Setup Instructions

### Prerequisites

1. **Java 8 or higher** installed
2. **Maven 3.6+** installed
3. **Git** installed
4. **Chrome Browser** latest version
5. **Valid Naukari account** for testing

### Installation Steps

1. **Clone the Repository**
   ```bash
   git clone https://github.com/navanethhk20/Naukari.git
   cd Naukari
   ```

2. **Install Dependencies**
   ```bash
   mvn clean install
   ```

3. **Configure Test Data**
    - Update `data.properties` with your test credentials
    - Place test resume file in `resources` folder

4. **Verify Setup**
   ```bash
   mvn clean compile
   ```

## 🏃‍♂️ Running Tests

### Command Line Execution

```bash
# Run all tests
mvn clean test

# Run specific test class
mvn clean test -Dtest=LoginToNaukari

# Run tests with custom browser
mvn clean test -Dbrowser=chrome

# Run tests in headless mode
mvn clean test -Dheadless=true

# Run with parallel execution
mvn clean test -DthreadCount=2
```

### IDE Execution

Right-click on test classes or methods in your IDE and select "Run as TestNG Test"

## 📊 Test Reporting

### Allure Reports

1. **Generate Test Results**
   ```bash
   mvn clean test
   ```

2. **Generate Allure Report**
   ```bash
   allure generate allure-results --clean -o allure-report
   ```

3. **Serve Report**
   ```bash
   allure serve allure-results
   ```

### TestNG Reports

HTML reports are automatically generated in `target/surefire-reports/` directory.

## 🧪 Test Scenarios

### Authentication Tests
- ✅ Valid login credentials verification
- ✅ Invalid credentials handling
- ✅ Password field masking validation
- ✅ Remember me functionality
- ✅ Logout functionality

### Profile Management Tests
- ✅ View profile information
- ✅ Edit profile details
- ✅ Profile picture update
- ✅ Contact information validation
- ✅ Profile completion status

### Resume/File Upload Tests
- ✅ Resume upload functionality
- ✅ File format validation (PDF, DOC, DOCX)
- ✅ File size limit testing
- ✅ Upload progress verification
- ✅ Resume replacement testing

### Dashboard Tests
- ✅ Dashboard elements verification
- ✅ Job recommendations display
- ✅ Profile update notifications
- ✅ "Updated Today" status verification
- ✅ Navigation menu functionality

## 📄 Configuration

### data.properties
```properties
# Application Configuration
naukariUrl=https://www.naukri.com
loginUrl=https://www.naukri.com/nlogin/login

# Browser Configuration
browser=chrome
headless=false
implicitWait=10
pageLoadTimeout=30

# Test Credentials
email=your.email@example.com
password=yourpassword
expectedUsername=Your Name

# File Upload
resumePath=src/test/resources/Navaneeth H.K.pdf
allowedFileTypes=pdf,doc,docx
maxFileSize=2MB
```

### Sample Test Implementation

```java
@Test(priority = 1, description = "Login to Naukari with valid credentials")
public void loginToNaukari() {
    LoginPage loginPage = new LoginPage(driver);
    DashboardPage dashboard = loginPage.performLogin(
        PropertiesReader.readKey("email"),
        PropertiesReader.readKey("password")
    );
    Assert.assertTrue(dashboard.isDashboardDisplayed(), "Dashboard not loaded");
}

@Test(priority = 2, description = "Upload resume and verify profile update")
public void uploadResumeAndVerifyUpdate() {
    ViewProfile profilePage = new ViewProfile(driver);
    profilePage.uploadResume(PropertiesReader.readKey("resumePath"));
    Assert.assertTrue(profilePage.isProfileUpdatedToday(), "Profile not updated today");
}
```

## 🔄 CI/CD Integration

### Jenkins Pipeline Configuration

```groovy
pipeline {
    agent any
    
    tools {
        maven 'Maven-3.8.1'
        jdk 'JDK-11'
    }
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', 
                    url: 'https://github.com/navanethhk20/Naukari.git'
            }
        }
        
        stage('Compile') {
            steps {
                sh 'mvn clean compile'
            }
        }
        
        stage('Test') {
            steps {
                sh 'mvn clean test -Dbrowser=chrome -Dheadless=true'
            }
            post {
                always {
                    publishTestResults testResultsPattern: 'target/surefire-reports/*.xml'
                }
            }
        }
        
        stage('Generate Report') {
            steps {
                allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'allure-results']]
                ])
            }
        }
    }
    
    post {
        always {
            cleanWs()
        }
    }
}
```

## 🏗️ Page Object Classes

### LoginPage.java
```java
public class LoginPage extends CommonToAllPages {
    
    @FindBy(id = "emailTxt")
    private WebElement emailField;
    
    @FindBy(id = "pwd1")
    private WebElement passwordField;
    
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement loginButton;
    
    public DashboardPage performLogin(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
        return new DashboardPage(driver);
    }
}
```

### ViewProfile.java
```java
public class ViewProfile extends CommonToAllPages {
    
    @FindBy(id = "attachCV")
    private WebElement uploadResumeButton;
    
    @FindBy(className = "updated-today")
    private WebElement updatedTodayIndicator;
    
    public void uploadResume(String filePath) {
        uploadResumeButton.sendKeys(filePath);
        waitForUploadComplete();
    }
    
    public boolean isProfileUpdatedToday() {
        return updatedTodayIndicator.isDisplayed();
    }
}
```

## 🐛 Troubleshooting

### Common Issues & Solutions

1. **Login Failures**
    - Verify credentials in data.properties
    - Check for CAPTCHA requirements
    - Ensure stable internet connection

2. **File Upload Issues**
    - Verify file path is correct
    - Check file size limits (max 2MB)
    - Ensure supported file formats (PDF, DOC, DOCX)

3. **Element Not Found**
    - Update element locators if UI changes
    - Increase wait times for slow loading elements
    - Verify page is fully loaded before interaction

4. **Browser Driver Issues**
    - Update ChromeDriver to latest version
    - Check browser and driver compatibility
    - Use WebDriverManager for automatic driver management

## 📈 Best Practices Implemented

- **Page Object Model** for better maintainability
- **Explicit waits** for reliable element interactions
- **Data-driven approach** using properties files
- **Modular test design** for reusability
- **Comprehensive assertions** for validation
- **Screenshot capture** on test failures
- **Detailed logging** for debugging
- **Clean code principles** following Java standards

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/enhancement`)
3. Commit your changes (`git commit -m 'Add new feature'`)
4. Push to the branch (`git push origin feature/enhancement`)
5. Create a Pull Request

## 📞 Support & Contact

- **Repository:** [GitHub - Naukari Automation](https://github.com/navanethhk20/Naukari)
- **Issues:** Create an issue in the GitHub repository
- **Author:** Navaneeth H.K (navanethhk20)

## 📋 Test Execution Checklist

- [ ] Valid test credentials configured
- [ ] Resume file available in resources
- [ ] Browser drivers updated
- [ ] Internet connection stable
- [ ] Jenkins pipeline configured (if using CI/CD)
- [ ] Allure reporting setup complete

## 📜 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

**Happy Testing with Naukari Automation! 🎯**

*Last Updated: 2 weeks ago by navanethhk20*