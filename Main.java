import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Contact arr[] = new Contact[10];f
    static int index = 0;
    static int nul = 0;

    public static void main(String[] args) {


        while (true) {

            System.out.println("\t\t\n\t>>>>>MENU<<<<<<");
            System.out.println("\n1. ContactList");
            System.out.println("2. Add Contact");
            System.out.println("3. Search by phone");
            System.out.println("4. Search by name");
            System.out.println("5. Search by surname");
            System.out.println("6. Delete Contact");

            System.out.println("0. Exit");

            Scanner input = new Scanner(System.in);
            System.out.print("\nEnter an action : ");
            int action = input.nextInt();

            switch (action) {

                case 1:
                    sortOfname();
                    showContact();
                    break;

                case 2:
                    addingContact();

                    break;

                case 3:
                    searchingPhone();
                    break;

                case 4:
                    searchingName();
                    break;

                case 5:
                    searchingSurname();
                    break;


                case 6:
                    deletingContact();
                    break;

                case 0:
                    System.out.println("\nThe program finished!");
                    return;

                default:
                    System.out.println("\nIncorrect action ! Please enter a correct action ! ");
                    break;
            }

        }
    }

    public static Contact[] addingContact() {

        Contact contact = new Contact();
        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter a name : ");
        String name = input.nextLine();

        System.out.print("Enter a surname : ");
        String surname = input.nextLine();

        System.out.print("Enter a phone like this (+99897-123-45-67) : ");
        String phone = input.nextLine();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].getPhone().equals(phone)) {
                System.out.println("\nYou cannot add this contact because of there's this contact !");
                return null;
            }
        }

        contact.setName(name);
        contact.setSurname(surname);
        contact.setPhone(phone);
        arr[index++] = contact;
        System.out.println("\nThis contact has been added successfully ! ");
        return arr;

    }

    public static void showContact() {

        nul = 0;
        System.out.println("\t\t\t\n>>>>>Contacts<<<<<<<");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                Contact contact1 = arr[i];
                System.out.println(contact1);
            }

            if (arr[i] == null) {
                nul++;
            }
        }
        if (nul == arr.length) {
            System.out.println("\nIt is empty ! Please add contact ");
        }
    }

    public static void searchingName() {

        Contact contact = new Contact();
        Scanner input = new Scanner(System.in);

        System.out.println("\t\t\t\n>>>>Search by Name<<<<<");
        System.out.print("\n Enter a name : ");
        String name = input.nextLine();


        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                if (name.equalsIgnoreCase(arr[i].getName())) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
        System.out.println("\nIt is not exist !");
    }

    public static void searchingPhone() {

        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter a phone number : ");
        String phone = input.nextLine();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null && arr[i].getPhone().equals(phone)) {
                System.out.println(arr[i]);
                return;
            }
        }
        System.out.println("\nIt is not exist in contacts !");

    }

    public static void deletingContact() {

        Scanner input = new Scanner(System.in);
        System.out.print("\nEnter a contact that wanted to delete : ");
        String phone = input.nextLine();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                if (phone.equals(arr[i].getPhone())) {
                    arr[i] = null;
                    System.out.println("\nThis contact has been deleted successfully !");
                    return;
                }
            }

        }
        System.out.println("\nIt is not exist !");
    }

    public static void searchingSurname() {
        /*   Contact contact = new Contact();*/
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a surname : ");
        String surname = input.nextLine();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                if (arr[i].getSurname().equalsIgnoreCase(surname)) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }

        System.out.println("\nIt is not exist !");
    }

    public static void sortOfname() {

        for (int i = 0; i < arr.length; i++) {
            for (int i1 = 0; i1 < arr.length; i1++) {
                if (arr[i].getName() != null || arr[i1].getName() != null) {

                    if (arr[i].getName().compareTo(arr[i1].getName()) > 0) {
                        Contact temp = arr[i];
                        arr[i] = arr[i1];
                        arr[i1] = temp;
                    }

                }
            }
        }
    }
}
