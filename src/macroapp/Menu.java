package macroapp;

import macroapp.config.SettingManagement;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static final int RANGE_MIN = 0;
    private static final int RANGE_MAX = 3;
    private static final int INVALID_INPUT = -1;
    private static final int EXIT_OPTION = 0;

    private final List<String> menuOptions = List.of(
            "-".repeat(35),
            "[1] - Instalar.",
            "[2] - Crear Backup.",
            "[3] - Desinstalar.",
            "-".repeat(35),
            "[0] - Finalizar Macro",
            "-".repeat(35)
    );
    private final Scanner scanner;
    private final SettingManagement settingManagement;

    public Menu(SettingManagement settingManagement) {
        this.settingManagement = settingManagement;
        this.scanner = new Scanner(System.in);
    }

    public void startApp() {
        int option;
        do {
            displayMenu();
            option = getUserInput();
            if (option == INVALID_INPUT) continue;
            processOption(option);
        } while (option != EXIT_OPTION);
        close();
    }

    private int getUserInput() {
        try {
            int opt = scanner.nextInt();
            scanner.nextLine();
            if (opt < RANGE_MIN || opt > RANGE_MAX) {
                System.out.printf("[ERROR]: Debes Ingresar valores en el rango [%d -%d]%n", RANGE_MIN, RANGE_MAX);
                return INVALID_INPUT;
            }
            return opt;
        } catch (InputMismatchException e) {
            System.out.printf(
                    "[ERROR]: Debes ingresar un número entero [%d - %d]%n", RANGE_MIN, RANGE_MAX
            );
            scanner.nextLine();
            return INVALID_INPUT;
        }
    }

    private void displayMenu() {
        System.out.printf(">> Ingresa valores entre: [%d - %d] <<%n", RANGE_MIN, RANGE_MAX);
        for (String options : menuOptions) {
            System.out.println(options);
        }
        System.out.print(">> Ingresa una opción: ");
    }

    private void processOption(int option) {
        switch (option) {
            case 1 -> {
                System.out.println("[1] - INSTALACIÓN");
                settingManagement.executeInstall();
            }
            case 2 -> {
                System.out.println("[2] - CREAR BACKUP");
                settingManagement.executeBackup();
            }
            case 3 -> {
                System.out.println("[3] - Desinstalar.");
                settingManagement.executeUninstall();
            }
            case 0 -> System.out.println("Macro finalizada");
            default -> System.out.println("Acción no implementada.");
        }
    }

    private void close() {
        scanner.close();
    }
}
