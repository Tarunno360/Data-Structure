import java.util.Scanner;

class Patient {
    String name;
    Patient next, prev;

    public Patient(String name, Patient next, Patient prev) {
        this.name = name;
        this.next = next;
        this.prev = prev;
    }
}

class WRM {
    private Patient dh;
    private Patient tail;

    public WRM() {
        dh = new Patient(null, null, null);
        dh.next = dh;
        dh.prev = dh;
        tail = dh;
    }

    public void RegisterPatient(String id, String name, String age, String bloodGroup) {
        Patient newPatient = new Patient(name, dh, tail);
        tail.next = newPatient;
        tail = tail.next;
        dh.prev = tail;
        System.out.println("Success Registering Patient");
    }

    public void ServePatient() {
        if (dh.next == dh) {
            System.out.println("No patients to serve.");
            return;
        }
        Patient tbr = dh.next;
        Patient prevNode = tbr.prev;
        Patient nextNode = tbr.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        tbr.next = null;
        tbr.prev = null;
        if (dh.next == dh) {
            tail = dh;
        }
        System.out.println(tbr.name + " is served");
    }

    public void ShowAllPatient() {
        Patient temp = dh.next;
        if (temp == dh) {
            System.out.println("No patients available.");
            return;
        }
        while (temp != dh) {
            System.out.print(temp.name + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void CancelAll() {
        dh.next = dh;
        dh.prev = dh;
        tail = dh;
        System.out.println("All appointments cancelled");
    }

    public void CanDoctorGoHome() {
        if (dh.next == dh) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}

public class WaitingRoomManagement {
    public static void main(String[] args) {
        WRM x = new WRM();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n **Welcome to Waiting Room Management System**\n" +
                    "==Choose an Option==\n" +
                    "1. Register Patient\n" +
                    "2. Serve Patient\n" +
                    "3. Cancel All\n" +
                    "4. Can Doctor Go Home\n" +
                    "5. Show All Patients\n" +
                    "6. Exit\n" +
                    "===============");
            System.out.print("Enter your choice: ");
            String i = sc.nextLine();

            switch (i) {
                case "1":
                    System.out.print("Enter ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    String age = sc.nextLine();
                    System.out.print("Enter Blood Group: ");
                    String bloodGroup = sc.nextLine();
                    x.RegisterPatient(id, name, age, bloodGroup);
                    break;
                case "2":
                    x.ServePatient();
                    break;
                case "3":
                    x.CancelAll();
                    break;
                case "4":
                    x.CanDoctorGoHome();
                    break;
                case "5":
                    x.ShowAllPatient();
                    break;
                case "6":
                    System.out.println("Exit done");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }
}
