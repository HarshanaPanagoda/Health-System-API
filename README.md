
# Medical Records Management RESTful Web Service

## Introduction
This RESTful web service application is designed to manage medical records, prescriptions, and billing information. It provides a comprehensive API for interacting with patient data, doctor information, appointment scheduling, medical records management, prescription issuance, and billing management.

## Implementation Overview
The application is developed using Java with Jersey for JAX-RS implementation. It follows a modular structure, separating concerns into different layers to promote code organization and maintainability. The main components include:

### Model Classes

- `Person`
- `Patient`
- `Doctor`
- `Appointment`
- `MedicalRecord`
- `Prescription`
- `Billing`

### DAO Classes (Data Access Objects)

- `PersonDAO`
- `PatientDAO`
- `DoctorDAO`
- `AppointmentDAO`
- `MedicalRecordDAO`
- `PrescriptionDAO`
- `BillingDAO`

### Resource Classes

- `PersonResource`
- `PatientResource`
- `DoctorResource`
- `AppointmentResource`
- `MedicalRecordResource`
- `PrescriptionResource`
- `BillingResource`

### Logging Configuration
The application utilizes Logback for logging events. A Logback configuration file (`logback.xml`) is provided to define the logging behavior, including the log format and destination.



## Usage Instructions
1. Clone the repository to your local machine.
2. Import the project into your preferred Java IDE.
3. Ensure that the required dependencies specified in the `pom.xml` file are resolved.
4. Run the application on a local server (e.g., Apache Tomcat).
5. Use Postman or any other HTTP client to interact with the API endpoints.

###
- I have developed a RESTful web service as a part of my degree program. If you are considering using it in a production environment, replacing the static data with a database and implementing proper security measures would be best.

#
Feel free to make any changes you'd like, and don't hesitate to let me know if you're like this⭐!
