/*

This is an example menu that is set up to show you a way of structuring your project.
this doesn't have all requirements in it please refer to the sprint doc to view all requirements
 */

package src.models;
import java.time.LocalDate;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {
        MedicationTrackingSystem system = new MedicationTrackingSystem();
        boolean exit = false;


        while (!exit){
            Scanner scanner = new Scanner(System.in);
            System.out.println(" ");
            System.out.println("=====Welcome To The Pharmacy Med Tracking System=====");
            System.out.println("What would you like to do? ");
            System.out.println("1: Adding A New Doctor/ Patient/ Medication/ Process Prescription");
            System.out.println("2: Print all Scripts for a Specific Doctor/ Patient");
            System.out.println("3: Edit Doctor/Patient/Medication");
            System.out.println("4: Delete Doctor/Patient/Medication");
            System.out.println("5: Check If Meds Are Expired");
            System.out.println("6: Restock the drugs in the pharmacy");
            System.out.println("7: Print System Report");
            System.out.println("8: Exit");

            System.out.print("Enter your choice: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    addRecordsMenu(scanner, system);
                    break;
                case 2:
                    printPrescriptionsMenu(scanner, system);
                    break;
                case 3:
                    editRecordsMenu(scanner, system);
                    break;
                case 4:
                    deleteRecordsMenu(scanner, system);
                    break;
                case 5:
                    checkExpiredMeds(system);
                    break;
                case 6:
                    restockPharmacyDrugs(scanner, system);
                    break;
                case 7:
                    printPharmacyReport(system);
                    break;
                case 8:
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }


    private static void addRecordsMenu(Scanner scanner, MedicationTrackingSystem system) {
        System.out.println("\n--- Add Records ---");
        System.out.println("1: Add a New Doctor");
        System.out.println("2: Add a New Patient");
        System.out.println("3: Add a New Medication");
        System.out.println("4: Process a New Prescription");


        System.out.print("Select an option: ");
        int addOption = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (addOption) {
            case 1:
                addANewDoctor(scanner, system);
                break;
            case 2:
                addPatient(scanner, system);
                break;
            case 3:
                addNewMedicationToPharmacy(scanner, system);
                break;
            case 4:
                processANewScript(scanner, system);
                break;
            default:
                System.out.println("Invalid option.");
        }

    }



    private static void printPrescriptionsMenu(Scanner scanner, MedicationTrackingSystem system) {
        System.out.println("\n--- Print Prescriptions ---");
        System.out.println("1: Print All Scripts for a Specific Doctor");
        System.out.println("2: Print All Scripts for a Specific Patient");


        System.out.print("Select an option: ");
        int prescriptionOption = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (prescriptionOption) {
            case 1:
                printScriptsForSpecificDoctor(scanner, system);
                break;
            case 2:
                printAllScriptsForPatientByName(scanner, system);
                break;
            default:
                System.out.println("Invalid option.");
        }
        scanner.nextLine(); // Clear buffer
    }

    private static void editRecordsMenu(Scanner scanner, MedicationTrackingSystem system) {
        System.out.println("\n--- Edit Records ---");
        System.out.println("1: Edit Doctor");
        System.out.println("2: Edit Patient");
        System.out.println("3: Edit Medication");

        System.out.print("Select an option: ");
        int editOption = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (editOption) {
            case 1:
                editDoctor(scanner, system);
                break;
            case 2:
                editPatient(scanner, system);
                break;
            case 3:
                editMedication(scanner, system);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void deleteRecordsMenu(Scanner scanner, MedicationTrackingSystem system) {
        System.out.println("\n--- Delete Records ---");
        System.out.println("1: Delete Doctor");
        System.out.println("2: Delete Patient");
        System.out.println("3: Delete Medication");

        System.out.print("Select an option: ");
        int deleteOption = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (deleteOption) {
            case 1:
                deleteDoctor(scanner, system);
                break;
            case 2:
                deletePatient(scanner, system);
                break;
            case 3:
                deleteMedication(scanner, system);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }


    private static void addPatient(Scanner scanner, MedicationTrackingSystem system) {
        System.out.println("Enter Patient ID: ");
        String id = scanner.nextLine();

        System.out.println("Enter Patient Name: ");
        String name = scanner.nextLine();

        System.out.println("Enter Patient Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter Patient Phone Number: ");
        String phone = scanner.nextLine();

        Patient patient = new Patient(id, name, age, phone);
        system.addPatient(patient);

        System.out.print("Enter Doctor ID to assign the patient to: ");
        String doctorId = scanner.nextLine();


        system.addPatientToDoctor(doctorId, patient);
        System.out.println("Patient added successfully!");

    }

    private static void addANewDoctor(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter Doctor ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Doctor Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Doctor Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Doctor Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Enter Specialization: ");
        String specialization = scanner.nextLine();

        Doctor doctor = new Doctor(id, name, age, phoneNumber, specialization);
        system.addDoctor(doctor);
        System.out.println("Doctor added successfully!");
    }

    private static void addNewMedicationToPharmacy(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter Medication ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Medication Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Dosage: ");
        String dosage = scanner.nextLine();

        System.out.print("Enter Quantity in Stock: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Expiry Date (YYYY-MM-DD): ");
        LocalDate expiryDate = LocalDate.parse(scanner.nextLine());

        Medication medication = new Medication(id, name, quantity, dosage, expiryDate);
        system.addMedication(medication);
        System.out.println("Medication added successfully!");
    }

    private static void printPharmacyReport(MedicationTrackingSystem system) {
        system.generateSystemReport();
    }

    private static void checkExpiredMeds(MedicationTrackingSystem system) {
        system.checkForExpiredMedications();
    }

    private static void processANewScript(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter Prescription ID: ");
        String prescriptionId = scanner.nextLine();

        System.out.print("Enter Doctor ID: ");
        String doctorId = scanner.nextLine();

        System.out.print("Enter Patient ID: ");
        String patientId = scanner.nextLine();

        System.out.print("Enter Medication ID: ");
        String medicationId = scanner.nextLine();

        System.out.print("Enter Prescription Expiry Date (YYYY-MM-DD): ");
        LocalDate prescriptionExpiry = LocalDate.parse(scanner.nextLine());

        system.acceptPrescription(prescriptionId, doctorId, patientId, medicationId, prescriptionExpiry);
        System.out.println("Prescription processed successfully!");

    }

    private static void printScriptsForSpecificDoctor(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter Doctor ID: ");
        String doctorId = scanner.nextLine();
        system.printPrescriptionsByDoctor(doctorId);
    }

    private static void restockPharmacyDrugs(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter Medication ID to restock: ");
        String medicationId = scanner.nextLine();

        System.out.print("Enter quantity to add: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        system.restockMedication(medicationId, quantity);  // Pass arguments here
        System.out.println("Medications restocked successfully!");
    }

    private static void printAllScriptsForPatientByName(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter Patient Name: ");
        String name = scanner.nextLine();
        system.searchPatientByName(name);
    }


    private static void deletePatient(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter Patient ID to delete: ");
        String patientId = scanner.nextLine();
        system.deletePatient(patientId);

    }

    private static void deleteDoctor(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter Doctor ID to delete: ");
        String doctorId = scanner.nextLine();
        system.deleteDoctor(doctorId);

    }

    private static void deleteMedication(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter Medication ID to delete: ");
        String medicationId = scanner.nextLine();
        system.deleteMedication(medicationId);

    }

    private static void editPatient(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter Patient ID to edit: ");
        String patientId = scanner.nextLine();
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new age: ");
        int newAge = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new phone number: ");
        String newPhone = scanner.nextLine();

        system.editPatient(patientId, newName, newAge, newPhone);
        System.out.println("Patient updated successfully!");
    }

    private static void editDoctor(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter Doctor ID to edit: ");
        String doctorId = scanner.nextLine();
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new age: ");
        int newAge = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new phone number: ");
        String newPhone = scanner.nextLine();
        System.out.print("Enter new specialization: ");
        String newSpecialization = scanner.nextLine();

        system.editDoctor(doctorId, newName, newAge, newPhone, newSpecialization);
        System.out.println("Doctor updated successfully!");
    }

    private static void editMedication(Scanner scanner, MedicationTrackingSystem system) {
        System.out.print("Enter Medication ID to edit: ");
        String medicationId = scanner.nextLine();
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        System.out.print("Enter new dosage: ");
        String newDosage = scanner.nextLine();
        System.out.print("Enter new quantity: ");
        int newQuantity = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter new expiry date (YYYY-MM-DD): ");
        LocalDate newExpiry = LocalDate.parse(scanner.nextLine());

        system.editMedication(medicationId, newName, newQuantity, newDosage, newExpiry);
        System.out.println("Medication updated successfully!");
    }


}
