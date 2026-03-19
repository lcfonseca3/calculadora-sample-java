package com.calculadora;

import java.util.Scanner;

/**
 * Ponto de entrada da Calculadora de 8 Dígitos.
 */
public class Main {

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        Scanner scanner = new Scanner(System.in);

        System.out.println("╔══════════════════════════════╗");
        System.out.println("║   Calculadora de 8 Dígitos   ║");
        System.out.println("╚══════════════════════════════╝");

        while (true) {
            System.out.println("\nOperações disponíveis:");
            System.out.println("  1 → Soma        (+)");
            System.out.println("  2 → Subtração   (-)");
            System.out.println("  3 → Multiplicação (×)");
            System.out.println("  4 → Divisão     (÷)");
            System.out.println("  0 → Sair");
            System.out.print("\nEscolha a operação: ");

            int opcao;
            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida! Digite um número de 0 a 4.");
                continue;
            }

            if (opcao == 0) {
                System.out.println("Encerrando a calculadora. Até logo!");
                break;
            }

            if (opcao < 1 || opcao > 4) {
                System.out.println("Opção inválida! Escolha entre 1 e 4.");
                continue;
            }

            double a, b;
            try {
                System.out.print("Digite o primeiro número: ");
                a = Double.parseDouble(scanner.nextLine().trim());

                System.out.print("Digite o segundo número: ");
                b = Double.parseDouble(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida! Por favor, insira números válidos.");
                continue;
            }

            try {
                double resultado;
                String simbolo;

                switch (opcao) {
                    case 1:
                        resultado = calc.somar(a, b);
                        simbolo = "+";
                        break;
                    case 2:
                        resultado = calc.subtrair(a, b);
                        simbolo = "-";
                        break;
                    case 3:
                        resultado = calc.multiplicar(a, b);
                        simbolo = "×";
                        break;
                    case 4:
                        resultado = calc.dividir(a, b);
                        simbolo = "÷";
                        break;
                    default:
                        continue;
                }

                System.out.println("┌─────────────────────────────┐");
                System.out.printf("│  %.8s %s %.8s = %s%n", String.valueOf(a), simbolo, String.valueOf(b), calc.formatar(resultado));
                System.out.println("└─────────────────────────────┘");

            } catch (ArithmeticException e) {
                System.out.println("⚠️  " + e.getMessage());
            }
        }

        scanner.close();
    }
}
