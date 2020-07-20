package com.nlmk.evteev.tm;

import java.util.Scanner;

import static com.nlmk.evteev.tm.util.TerminalConst.*;

/**
 * Основной класс
 */
public class AppMain {

    /**
     * Точка входа
     *
     * @param args дополнительные аргументы запуска
     */
    public static void main(String[] args) {
        displayWelcome();
        run(args);
        final Scanner scanner = new Scanner(System.in);
        String command = "";
        while (!CMD_EXIT.equals(command))
        {
            command = scanner.nextLine();
            run(command);
            System.out.println();
        }
    }

    /**
     * Основной метод исполнения
     *
     * @param args дополнительные параметры запуска
     */
    private static void run(final String[] args) {
        if (args == null || args.length < 1) return;
        final String param = args[0];
        run(param);
    }

    /**
     * Обработка консольного ввода
     *
     * @param cmdString команда с консоли
     * @return код выполнения
     */
    private static int run(final String cmdString) {
        if (cmdString == null) return -1;
        switch (cmdString)
        {
            case CMD_VERSION:
                return displayVersion();
            case CMD_HELP:
                return displayHelp();
            case CMD_ABOUT:
                return displayAbout();
            case CMD_EXIT:
                displayExit();
            default:
                return displayError();
        }
    }

    /**
     * Показ сообщения об ошибке
     */
    private static int displayError() {
        System.out.println("Неподдерживаемый аргумент. наберите команду help для получения списка доступных команд...");
        return -1;
    }

    /**
     * Показ сведений о ключах
     */
    private static int displayHelp() {
        System.out.println("version - Информация о версии.");
        System.out.println("about - Информация о разработчике.");
        System.out.println("help - Информация о доступных командах.");
        System.out.println("exit - Завершение работы приложения");
        return 0;
    }

    /**
     * Показ сведений о версиях
     */
    private static int displayVersion() {
        System.out.println("1.0.0");
        return 0;
    }

    /**
     * Показ сведений об авторе
     */
    private static int displayAbout() {
        System.out.println("Author: Sergey Evteev");
        System.out.println("e-mail: sergey@evteev.ru");
        return 0;
    }

    /**
     * Показ приветствия
     */
    private static void displayWelcome() {
        System.out.println("** WELCOME TO TASK MANAGER **");
    }

    /**
     * Стандартный выход
     *
     * @return код стандартного выхода
     */
    private static void displayExit() {
        System.out.println("Получена команда завершения работы...");
        System.exit(0);
    }

}
