import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
public class Application {
    private String firstName;
    private String lastName;
    private String middleName;
    private String birthDate;
    private long phoneNumber;
    private char gen;
    private final Scanner scan = new Scanner(System.in);

    private void inputFirstName() {
        boolean askUser = true;
        while(askUser) {
            try{
                System.out.println("Введите имя:");
                firstName = scan.nextLine();
                if (firstName.isEmpty()) {
                    throw new RuntimeException("Пустые строки вводить нельзя");
                }
                System.out.println("Вы ввели: " + firstName);
                askUser = false;
            }
            catch (Exception e) {
                System.out.println(e);
                }
            }
        }

    private void inputLastName() {
        boolean askUser = true;
        while(askUser) {
            try{
                System.out.println("Введите фамилию:");
                lastName = scan.nextLine();
                if (lastName.isEmpty()) {
                    throw new RuntimeException("Пустые строки вводить нельзя");
                }
                System.out.println("Вы ввели: " + lastName);
                askUser = false;
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void inputMiddleName() {
        boolean askUser = true;
        while(askUser) {
            try{
                System.out.println("Введите отчество:");
                middleName = scan.nextLine();
                if (middleName.isEmpty()) {
                    throw new RuntimeException("Пустые строки вводить нельзя");
                }
                System.out.println("Вы ввели: " + middleName);
                askUser = false;
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void inputBirthdate() {
        boolean askUser = true;
        while(askUser) {
            try{
                System.out.println("Введите день рождение в формате дд.мм.гггг:");
                birthDate = scan.nextLine();
                if (birthDate.isEmpty()) {
                    throw new RuntimeException("Пустые строки вводить нельзя");
                }
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                LocalDate ld = LocalDate.parse(birthDate, dtf);
                System.out.println("Вы ввели: " + ld);
                askUser = false;
            }
            catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void InputPhoneNumber() {
        boolean askUser = true;
        while(askUser) {
            try {
                System.out.println("Введите телефон:");
                String number = scan.nextLine();
                if (number.isEmpty()) {
                    throw new RuntimeException("Пустые строки вводить нельзя");
                }
                phoneNumber = Long.parseLong(number);
                System.out.println("Вы ввели: " + phoneNumber);
                askUser = false;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void checkGender() {
        boolean askUser = true;
        while(askUser) {
            try {
                System.out.println("Введите пол f или m (f - женский, m - мужской):");
                String gender;
                String f = "f";
                String m = "m";
                gender = scan.nextLine();
                if (gender.isEmpty()) {
                    throw new RuntimeException("Пустые строки вводить нельзя");
                }
                if (gender.length() > 1) {
                    throw new RuntimeException("Введено больше двух символов");
                }
                if (gender.equals(f) || gender.equals(m)) {
                    gen= gender.charAt(0);
                    askUser = false;
                } else {
                    throw new RuntimeException("Введен неверный символ");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    public void writeData() {
        inputFirstName();
        inputLastName();
        inputMiddleName();
        inputBirthdate();
        InputPhoneNumber();
        checkGender();
        String file = lastName + ".txt";
        try (FileWriter fw = new FileWriter(file, true)) {
            fw.write("<" + firstName + "> " + "<" + lastName + "> " + "<" + middleName + "> " + "<" + birthDate + "> " + "<" + phoneNumber + "> " + "<" + gen + ">\n");
            System.out.println("Данные записаны в файл");
        } catch (Exception e) {
            System.out.println("Закралась ошибка");
        }
    }
}