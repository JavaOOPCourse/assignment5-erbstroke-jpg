import java.util.*;

public class Assignment5_StringManipulation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== GRADED ASSIGNMENT 5: STRING MANIPULATION ===");
            System.out.println("Выберите задание (1-8) или 0 для выхода:");
            System.out.println("1 — Count Vowels");
            System.out.println("2 — Reverse a String");
            System.out.println("3 — Check Palindrome");
            System.out.println("4 — Count Words in a Sentence");
            System.out.println("5 — Remove All Spaces");
            System.out.println("6 — Capitalize First Letter of Each Word");
            System.out.println("7 — Find the Most Frequent Character");
            System.out.println("8 — Check Anagrams");
            System.out.print("Ваш выбор: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите число!");
                continue;
            }

            switch (choice) {
                case 1 -> task1(scanner);
                case 2 -> task2(scanner);
                case 3 -> task3(scanner);
                case 4 -> task4(scanner);
                case 5 -> task5(scanner);
                case 6 -> task6(scanner);
                case 7 -> task7(scanner);
                case 8 -> task8(scanner);
                case 0 -> {
                    System.out.println("До свидания! Удачи со сдачей задания :)");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Неверный выбор! Попробуйте снова.");
            }
        }
    }

    // ===================== TASK 1 =====================
    private static void task1(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Подсчитать количество гласных (a, e, i, o, u)
        int count = 0;
        for (char c:input.toCharArray()){
            if (c=='a'||c=='e'||c=='i'||c=='o'||c=='u'){
                count++;
            }
        }

        System.out.println("Number of vowels: " + count);
    }

    // ===================== TASK 2 =====================
    private static void task2(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Вывести строку в обратном порядке
        // StringBuilder лучший в работе со строками
        String reversed = new StringBuilder(input).reverse().toString();

        System.out.println(reversed);
    }

    // ===================== TASK 3 =====================
    private static void task3(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Проверить, является ли строка палиндромом (игнорировать регистр)
        boolean isPalindrome = false;
        String reversed = new StringBuilder(input).reverse().toString();
        if (input.equals(reversed)){
            isPalindrome = true;
        }
        System.out.println(isPalindrome ? "Yes" : "No");
    }

    // ===================== TASK 4 =====================
    private static void task4(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        // TODO: Подсчитать количество слов в предложении
        int wordCount = 0;
        for (String word: sentence.split(" ")){
            wordCount++;
        }
        System.out.println("Number of words: " + wordCount);
    }

    // ===================== TASK 5 =====================
    private static void task5(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Удалить все пробелы из строки
        String noSpaces = input.replace(" ","");

        System.out.println(noSpaces);
    }

    // ===================== TASK 6 =====================
    private static void task6(Scanner scanner) {
        System.out.print("Enter a sentence: ");
        String sentence = scanner.nextLine();

        // TODO: Преобразовать первую букву каждого слова в заглавную

        StringBuilder str = new StringBuilder();
        for (String word: sentence.split(" ")){
            if (!word.isEmpty()) {
                str.append(Character.toUpperCase(word.charAt(0)))
                        .append(word.substring(1))
                        .append(" ");
            }
        }
        String result = str.toString();

        System.out.println(result);
    }

    // ===================== TASK 7 =====================
    private static void task7(Scanner scanner) {
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // TODO: Найти символ, который встречается чаще всего
        char mostFrequent = ' ';
        int maxCount = 0;
        Map<Character, Integer> charFrequensy = new HashMap<>();
        for (char c:input.toCharArray()){
            charFrequensy.put(c, charFrequensy.getOrDefault(c,0)+1);
        }
        for (Map.Entry<Character, Integer> entry : charFrequensy.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostFrequent = entry.getKey();
            }
        }

        System.out.println("The most frequent character is: " + mostFrequent);
    }

    // ===================== TASK 8 =====================
    private static void task8(Scanner scanner) {
        System.out.print("Enter first string: ");
        String str1 = scanner.nextLine();
        System.out.print("Enter second string: ");
        String str2 = scanner.nextLine();

        String pureStr1 = str1.replaceAll("\\s", "").toLowerCase();
        String pureStr2 = str2.replaceAll("\\s", "").toLowerCase();

        boolean areAnagrams = false;

        if (pureStr1.length() == pureStr2.length()) {
            char[] chars1 = pureStr1.toCharArray();
            char[] chars2 = pureStr2.toCharArray();
            Arrays.sort(chars1);
            Arrays.sort(chars2);
            areAnagrams = Arrays.equals(chars1, chars2);
        }

        System.out.println(areAnagrams ? "Yes" : "No");
    }
}