/*
 Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
 и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения,
 вместо этого, необходимо повторно запросить у пользователя ввод данных.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class task1 {
    public static void main(String[] args) {
        boolean askUser = true;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while(askUser){
            System.out.print("Введите дробное число: ");
            try{
                float num = Float.parseFloat(reader.readLine());
                System.out.printf("Вы ввели число %.2f\n", num);
                askUser = false;
            } catch (IOException | NumberFormatException e) {
                System.out.println("Ошибка ввода. Введите дробное число.");
            }
        }
    }
}
