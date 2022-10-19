import java.util.Scanner;

public class DepositCalculator {

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double value = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundResult(value, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return roundResult(amount + amount * yearRate * depositPeriod, 2);
    }

    double roundResult(double value, int exponent) {  // Округлить значение
        double scale = Math.pow(10, exponent);
        return Math.round(value * scale) / scale;
    }

    void calculate() {
        int amount;
        int depositPeriod;
        int action;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        action = scanner.nextInt();
        double result = 0;
        if (action == 1) {
            result = calculateSimplePercent(amount, 0.06, depositPeriod);
        } else if (action == 2) {
            result = calculateComplexPercent(amount, 0.06, depositPeriod);
        }
        System.out.println("Результат вклада: " + amount + " за " + depositPeriod + " лет превратятся в " + result);
    }

    public static void main(String[] args) {
        new DepositCalculator().calculate();
    }


}