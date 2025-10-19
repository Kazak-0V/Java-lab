public class Lab_1 {
    public double fraction(double x) {
        if (x < 0) {
            return -(-x - Math.floor(-x));
        }
        return x - Math.floor(x);
    }

    public int charToNum(char x) {
        return x - '0';
    }

    public boolean is2Digits(int x) {
        return (x >= 10 && x <= 99) || (x <= -10 && x >= -99);
    }

    public boolean isInRange(int a, int b, int num) {
        if (a < b) {
            return num >= a && num <= b;
        } else {
            return num >= b && num <= a;
        }
    }

    public boolean isEqual(int a, int b, int c) {
        return a == b && b == c;
    }

    public int abs(int x) {
        if (x < 0) {
            return -x;
        }
        return x;
    }

    public boolean is35(int x) {
        boolean divBy3 = (x % 3 == 0);
        boolean divBy5 = (x % 5 == 0);
        return (divBy3 || divBy5) && !(divBy3 && divBy5);
    }

    public int max3(int x, int y, int z) {
        int max = x;
        if (y > max) {
            max = y;
        }
        if (z > max) {
            max = z;
        }
        return max;
    }

    public int sum2(int x, int y) {
        int sum = x + y;
        if (sum >= 10 && sum <= 19) {
            return 20;
        }
        return sum;
    }

    public String day(int x) {
        switch (x) {
            case 1:
                return "понедельник";
            case 2:
                return "вторник";
            case 3:
                return "среда";
            case 4:
                return "четверг";
            case 5:
                return "пятница";
            case 6:
                return "суббота";
            case 7:
                return "воскресенье";
            default:
                return "это не день недели";
        }
    }

    public String listNums(int x) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= x; i++) {
            result.append(i);
            if (i < x) {
                result.append(" ");
            }
        }
        return result.toString();
    }

    public String chet(int x) {
        StringBuilder result = new StringBuilder("0");
        for (int i = 2; i <= x; i += 2) {
            result.append(" ").append(i);
        }
        return result.toString();
    }

    public int numLen(int x) {
        if (x == 0) {
            return 1;
        }

        int count = 0;
        int num = Math.abs(x);

        while (num > 0) {
            num = num / 10;
            count++;
        }
        return count;
    }

    public void square(int x) {
        for (int i = 0; i < x; i++) { // Строки
            for (int j = 0; j < x; j++) { // Столбцы
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public void rightTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            // Печатаем пробелы
            for (int j = 0; j < x - i; j++) {
                System.out.print(" ");
            }
            // Печатаем звездочки
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1;
    }

    public int maxAbs(int[] arr) {
        if (arr.length == 0) {
            return 0; // или можно бросить исключение
        }

        int maxAbsValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (Math.abs(arr[i]) > Math.abs(maxAbsValue)) {
                maxAbsValue = arr[i];
            }
        }
        return maxAbsValue;
    }

    public int[] add(int[] arr, int[] ins, int pos) {
        int[] result = new int[arr.length + ins.length];

        // Копируем часть до pos
        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }

        // Вставляем массив ins
        for (int i = 0; i < ins.length; i++) {
            result[pos + i] = ins[i];
        }

        // Копируем часть после pos
        for (int i = pos; i < arr.length; i++) {
            result[ins.length + i] = arr[i];
        }

        return result;
    }

    public int[] reverseBack(int[] arr) {
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }

        return result;
    }

    public int[] findAll(int[] arr, int x) {
        // Сначала подсчитаем количество вхождений
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                count++;
            }
        }

        // Создаем массив нужного размера
        int[] result = new int[count];

        // Заполняем массив индексами
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                result[index] = i;
                index++;
            }
        }

        return result;
    }
}


