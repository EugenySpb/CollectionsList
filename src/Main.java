import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<String> shoppingList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // выводим меню
            System.out.println("Выберите операцию:");
            System.out.println("1 - Добавить покупку");
            System.out.println("2 - Показать список покупок");
            System.out.println("3 - Удалить покупку");
            System.out.println("4 - Поиск");
            System.out.println("0 - Завершить программу");
            int choice;
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода! Введите число от 0 до 4.");
                scanner.next();
                continue;
            }
            if (choice == 0) {
                System.out.println("Программа завершена");
                break;
            }
            switch (choice) {
                case 1:
                    System.out.println("Какую покупку хотите добавить?");
                    scanner.nextLine();
                    String item = scanner.nextLine();
                    shoppingList.add(item); // добавляем новый элемент в список
                    System.out.println("Итого в списке покупок: " + shoppingList.size());
                    break;
                case 2:
                    System.out.println("Список покупок:");
                    for (int i = 0; i < shoppingList.size(); i++) {
                        System.out.println((i + 1) + ". " + shoppingList.get(i));
                    }
                    Thread.sleep(1000);
                    break;
                case 3:
                    System.out.println("Список покупок:");
                    for (int i = 0; i < shoppingList.size(); i++) {
                        System.out.println((i + 1) + ". " + shoppingList.get(i));
                    }
                    System.out.println("Какую хотите удалить? Введите номер или название");
                    scanner.nextLine(); // съедаем лишний перевод строки
                    String input = scanner.nextLine();
                    try {
                        int index = Integer.parseInt(input);
                        shoppingList.remove(index - 1); // удаляем по номеру
                        System.out.println("Покупка \"" + input + "\" удалена, список покупок:");
                    } catch (NumberFormatException e) {
                        if (shoppingList.remove(input)) { // удаляем по названию
                            System.out.println("Покупка \"" + input + "\" удалена, список покупок:");
                        } else {
                            System.out.println("Покупка \"" + input + "\" не найдена в списке покупок");
                        }
                    }
                    for (int i = 0; i < shoppingList.size(); i++) {
                        System.out.println((i + 1) + ". " + shoppingList.get(i));
                    }
                    Thread.sleep(1000);
                    break;
                case 4:
                    System.out.println("Введите текст для поиска:");
                    scanner.nextLine();
                    String query = scanner.nextLine().toLowerCase();
                    boolean foundQuery = false;
                    System.out.println("Найдено:");
                    for (int i = 0; i < shoppingList.size(); i++) {
                        String itemLower = shoppingList.get(i).toLowerCase();
                        if (itemLower.contains(query)) {
                            System.out.println((i + 1) + ". " + shoppingList.get(i));
                            foundQuery = true;
                        }
                    }
                    if (!foundQuery) {
                        System.out.println("Ничего не найдено.");
                    }
                    Thread.sleep(1000);
                    break;
                default:
                    System.out.println("Неверный выбор");
            }
        }
    }
}