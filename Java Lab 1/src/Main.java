import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Lab_1 lab = new Lab_1();

        //Дробная часть
        System.out.print("Введите вещественное число: ");
        double number = scanner.nextDouble();
        scanner.nextLine();

        if (number != 0) {
            double result = lab.fraction(number);
            System.out.println("Дробная часть: " + result);
        } else {
            System.out.println("Ошибка! Пожалуйста, введите корректное число.");
        }
        System.out.println();

        // Букву в число
        char inputChar;
        System.out.print("Введите цифру (0-9): ");
        String input = scanner.nextLine();

        if (input.length() == 1 && input.charAt(0) >= '0' && input.charAt(0) <= '9') {
            inputChar = input.charAt(0);
            int result2 = lab.charToNum(inputChar);
            System.out.println("Символ '" + inputChar + "' преобразован в число: " + result2);
        } else {
            System.out.println("Ошибка! Введите ровно одну цифру.");
        }
        System.out.println();

        // Двузначное
        System.out.print("Введите целое число: ");
        int number1 = scanner.nextInt();
        scanner.nextLine();

        boolean result3 = lab.is2Digits(number1);
        System.out.println("Число " + number1 + " является двузначным: " + result3);
        System.out.println();

        // Диапазон
        System.out.print("Введите левую границу (a): ");
        int left = scanner.nextInt();
        System.out.print("Введите правую границу (b): ");
        int right = scanner.nextInt();
        System.out.print("Введите число для проверки (num): ");
        int num = scanner.nextInt();
        scanner.nextLine();

        boolean result4 = lab.isInRange(left, right, num);
        System.out.println("Число " + num + " входит в заданный диапазон " + result4);
        System.out.println();

        // Равенство
        System.out.print("Введите число a: ");
        int a = scanner.nextInt();
        System.out.print("Введите число b: ");
        int b = scanner.nextInt();
        System.out.print("Введите число c: ");
        int c = scanner.nextInt();
        scanner.nextLine();

        boolean result = lab.isEqual(a, b, c);
        System.out.println("Все три числа равны: " + result);
        System.out.println();

        // Модуль числа
        System.out.print("Введите целое число: ");
        int number2 = scanner.nextInt();
        scanner.nextLine();

        int result6 = lab.abs(number2);
        System.out.println("Модуль числа " + number2 + " = " + result6);
        System.out.println();

        // Тридцать пять
        System.out.print("Введите целое число: ");
        int number3 = scanner.nextInt();
        scanner.nextLine();

        boolean result7 = lab.is35(number3);
        System.out.println("Число " + number3 + " делится на 3 ИЛИ на 5 (но не на оба): " + result7);
        System.out.println();

        // Тройной максимум
        System.out.print("Введите число x: ");
        int x = scanner.nextInt();
        System.out.print("Введите число y: ");
        int y = scanner.nextInt();
        System.out.print("Введите число z: ");
        int z = scanner.nextInt();
        scanner.nextLine();

        int result8 = lab.max3(x, y, z);
        System.out.println("Максимальное число: " + result8);
        System.out.println();

        // Двойная сумма
        System.out.print("Введите число x: ");
        int x1 = scanner.nextInt();
        System.out.print("Введите число y: ");
        int y1 = scanner.nextInt();
        scanner.nextLine();

        int result9 = lab.sum2(x1, y1);
        System.out.println("Результат: " + result9);
        System.out.println();

        // День недели
        System.out.print("Введите номер дня недели (1-7): ");
        int dayNumber = scanner.nextInt();
        scanner.nextLine();

        String result10 = lab.day(dayNumber);
        System.out.println("Результат: " + result10);
        System.out.println();

        // Числа подряд
        System.out.print("Введите число x: ");
        int x3 = scanner.nextInt();
        scanner.nextLine();

        String result11 = lab.listNums(x3);
        System.out.println("Результат: " + result11);
        System.out.println();

        // Четные числа
        System.out.print("Введите число x: ");
        int x4 = scanner.nextInt();
        scanner.nextLine();

        String result12 = lab.chet(x4);
        System.out.println("Результат: " + result12);
        System.out.println();

        // Длина числа
        System.out.print("Введите число: ");
        int number4 = scanner.nextInt();
        scanner.nextLine();

        int result13 = lab.numLen(number4);
        System.out.println("Количество цифр: " + result13);
        System.out.println();

        // Квадрат
        System.out.print("Введите размер квадрата: ");
        int size = scanner.nextInt();
        scanner.nextLine();
        lab.square(size);
        System.out.println();

        // Правый треугольник
        System.out.print("Введите высоту треугольника: ");
        int height = scanner.nextInt();
        scanner.nextLine();

        lab.rightTriangle(height);
        System.out.println();

        // Поиск первого значения
        int[] arr = {1, 2, 3, 4, 2, 2, 5};

        System.out.print("Введите число для поиска: ");
        int x5 = scanner.nextInt();
        scanner.nextLine();

        int result16 = lab.findFirst(arr, x5);
        System.out.println("Индекс первого вхождения: " + result16);
        System.out.println();

        // Поиск максимального
        int[] arr2 = {1, -2, -7, 4, 2, 2, 5};

        int result17 = lab.maxAbs(arr2);
        System.out.println("Максимальное по модулю значение: " + result17);

        // Добавление массива в массив
        int[] arr3 = {1, 2, 3, 4, 5};
        int[] ins = {7, 8, 9};
        int pos = 3;

        int[] result18 = lab.add(arr3, ins, pos);

        System.out.print("Результат: [");
        for (int i = 0; i < result18.length; i++) {
            System.out.print(result18[i]);
            if (i < result18.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        System.out.println();

        // Возвратный реверс
        int[] arr4 = {1, 2, 3, 4, 5};
        int[] result19 = lab.reverseBack(arr4);

        System.out.print("Исходный массив: [");
        for (int i = 0; i < arr4.length; i++) {
            System.out.print(arr4[i]);
            if (i < arr4.length - 1) System.out.print(", ");
        }
        System.out.println("]");

        System.out.print("Реверсивный массив: [");
        for (int i = 0; i < result19.length; i++) {
            System.out.print(result19[i]);
            if (i < result19.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        System.out.println();

        // Все вхождения
        int[] arr5 = {1, 2, 3, 8, 2, 2, 9};
        int x6 = 2;
        int[] result20 = lab.findAll(arr5, x6);

        System.out.print("Индексы вхождений числа " + x6 + ": [");
        for (int i = 0; i < result20.length; i++) {
            System.out.print(result20[i]);
            if (i < result20.length - 1) System.out.print(", ");
        }
        System.out.println("]");
        scanner.close();
    }
}