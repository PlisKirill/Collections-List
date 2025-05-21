import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static List<String> menu;
    public static List<String> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        list = new ArrayList<>();
        List<String> forRemoved = new ArrayList<>();

        menu = new ArrayList<>();
        menu.add("Выход из программы");
        menu.add("Добавить дело");
        menu.add("Показать дела");
        menu.add("Удалить дело по номеру");
        menu.add("Удалить дело по названию");
        menu.add("Удалить дело по ключевому слову");

        while (true) {
            menu();
            System.out.print("Ваш выбор: ");
            int pointNamber = Integer.parseInt(sc.nextLine());
            System.out.println();

            switch (pointNamber) {
                case 1:
                    System.out.print("Введите название задачи: ");
                    boolean isAdd = list.add(sc.nextLine());
                    if (isAdd) {
                        System.out.println("Добавлено!");
                        printList();
                    }
                    break;
                case 2:
                    printList();
                    break;
                case 3:
                    System.out.print("Введите номер для удаления: ");
                    int point = Integer.parseInt(sc.nextLine());
                    boolean isRemove = list.remove(list.get(point));
                    if (isRemove) {
                        System.out.println("Удалено!");
                        printList();
                    } else System.out.println("Дела с таким номером нет!");
                    break;
                case 4:
                    System.out.print("Введите задачу для удаления: ");
                    boolean isRemove1 = list.remove(sc.nextLine());
                    if (isRemove1) {
                        System.out.println("Удалено!");
                        printList();
                    } else System.out.println("Дела с таким текстом нет!");
                    break;
                case 5:
                    System.out.print("Введите ключевое слово для удаления: ");
                    String word = sc.nextLine();
                    int count = 0;
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).toLowerCase().contains(word.toLowerCase())) {
                             forRemoved.add(list.get(i));
                             count++;
                        }
                    }
                    if (count != 0){
                        for (int i = 0; i < forRemoved.size(); i++) {
                            list.remove(forRemoved.get(i));
                        }
                        forRemoved.clear();
                        System.out.println("Удалено!");
                    } else System.out.println("Совпадений не найдено!");
                    printList();
                    break;
            }

            if (pointNamber == 0) {
                System.out.println("Программа завершена!");
                return;
            }
        }
    }

    public static void menu () {
        System.out.println("Выберите операцию:");
        for (int i = 0; i < menu.size(); i++){
            System.out.println(( i ) + ". " + menu.get(i));
        }
    }

    public static void printList() {
        System.out.println("Ваш список дел:");
        for (int i = 0; i < list.size(); i++){
            System.out.println(( i + 1 ) + ". " + list.get(i));
        }
        System.out.println();
    }
}
