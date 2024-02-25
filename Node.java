import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Node {
    int coefficient;
    int exponent;
    Node next;

    public Node(int coefficient, int exponent) {
        this.coefficient = coefficient;
        this.exponent = exponent;
        this.next = null;
    }
}

class PolynomialLinkedList {
    Node head;

    public PolynomialLinkedList() {
        this.head = null;
    }

    public void insertTerm(int coefficient, int exponent) {
        Node newNode = new Node(coefficient, exponent);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.coefficient + "x^" + current.exponent);
            if (current.next != null) {
                System.out.print(" + ");
            }
            current = current.next;
        }
        System.out.println();
    }
}

public class PolynomialOperations {
    public static void main(String[] args) {
        PolynomialLinkedList poly1 = new PolynomialLinkedList();
        PolynomialLinkedList poly2 = new PolynomialLinkedList();

        // Read polynomials from file
        readPolynomialsFromFile("polynomials.txt", poly1, poly2);

        // Display polynomials
        System.out.println("Polynomial 1: ");
        poly1.display();
        System.out.println("Polynomial 2: ");
        poly2.display();

        // Perform operations based on user choice
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose operation:");
        System.out.println("1. Add");
        System.out.println("2. Subtract");
        int choice = scanner.nextInt();

        PolynomialLinkedList result = new PolynomialLinkedList();
        if (choice == 1) {
            result = addPolynomials(poly1, poly2);
            System.out.println("Result of addition: ");
        } else if (choice == 2) {
            result = subtractPolynomials(poly1, poly2);
            System.out.println("Result of subtraction: ");
        }

        result.display();
    }

    private static void readPolynomialsFromFile(String filename, PolynomialLinkedList poly1, PolynomialLinkedList poly2) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int polynomialNumber = 1;
            while ((line = br.readLine()) != null) {
                String[] terms = line.split("\\s+");
                for (int i = 0; i < terms.length; i += 2) {
                    int coefficient = Integer.parseInt(terms[i]);
                    int exponent = Integer.parseInt(terms[i + 1]);
                    if (polynomialNumber == 1) {
                        poly1.insertTerm(coefficient, exponent);
                    } else if (polynomialNumber == 2) {
                        poly2.insertTerm(coefficient, exponent);
                    }
                }
                polynomialNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static PolynomialLinkedList addPolynomials(PolynomialLinkedList poly1, PolynomialLinkedList poly2) {
        PolynomialLinkedList result = new PolynomialLinkedList();
        // Implement polynomial addition logic here
        return result;
    }

    private static PolynomialLinkedList subtractPolynomials(PolynomialLinkedList poly1, PolynomialLinkedList poly2) {
        PolynomialLinkedList result = new PolynomialLinkedList();
        // Implement polynomial subtraction logic here
        return result;
    }
}
