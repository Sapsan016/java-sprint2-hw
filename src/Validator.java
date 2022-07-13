import java.util.Scanner;

public class Validator {
    static YearlyReport yearlyReport = new YearlyReport();
    static MonthlyReport monthlyReport = new MonthlyReport();

    Scanner scanner = new Scanner(System.in);

    public int checkIsInteger() {                                                       //Проверяем, что вводится число;

        while (!scanner.hasNextInt()) {
            System.out.println("Это не число! Введите число");
            scanner.next();
        }
        return scanner.nextInt();
    }
    public void getMonthlyRecords(){                                         //Подтверждение скачивание месячных отчетов
        monthlyReport.saveMonthlyReport();
        System.out.println("Данные по всем месячным отчетам считаны!");
    }
    public void getYearlyRecord(){                                          //Подтверждени скачивания годового отчета
        yearlyReport.saveYearlyReport(2021, "resources/y.2021.csv");
        System.out.println("Данные по годовому отчету считаны!");
    }
    public static void validateIncome() {                                                    //Сверяем доходы по месяцам
        if (yearlyReport.findIncome(1) == 0 ||
                monthlyReport.calculateTotalIncome(1) == 0) {                //Проверяем, если отчеты не считаны,
                                                                                    // то печать сообщения и возврат в меню
            System.out.println("Данные еще не считаны! Пожалуйста, сначала считайте данные!");
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (yearlyReport.findIncome(i) != monthlyReport.calculateTotalIncome(i)) {  //Проходим через цикл по всем отчетам
                System.out.println("Доход за " + 1 +                                    //Если данные в месячном и годовом отчете не совпадают
                        " месяц в годовом и месячном отчете не сходится!");             //печатаем номер месяца
            }
        }System.out.println("Сверка доходов завершена успешно!");
    }
    public static void validateExpense() {                                          //Сверяем расходы по месяцам
        if (yearlyReport.findExpense(1) == 0 ||
                monthlyReport.calculateTotalExpense(1) == 0) {            //Если отчеты не считаны возврат в меню
            return;
        }
        for (int i = 1; i <= 3; i++) {                                                      //Проходим через цикл по всем отчетам
            if (yearlyReport.findExpense(i) != monthlyReport.calculateTotalExpense(i)) {   //Если данные в месячном и годовом отчете не совпадают
                System.out.println("Расходы за " + i +                                     //печатаем номер месяца
                        " месяц в годовом и месячном отчете не сходятся!");
            }
        }System.out.println("Сверка расходов завершена успешно!");
    }
    public void printMonthlyReport() {                                           //Печать месячного отчета
     if (monthlyReport.calculateTotalExpense(1) == 0) {                 //Проверка на считывание
         System.out.println("Данные по месячным отчетам еще не считаны! Пожалуйста, сначала считайте данные!");
         return;
     }
            System.out.println("Январь:");
            monthlyReport.findMaxProfitItem(1);
            monthlyReport.findMaxExpenseItem(1);
            System.out.println("Февраль:");
            monthlyReport.findMaxProfitItem(2);
            monthlyReport.findMaxExpenseItem(2);
            System.out.println("Март:");
            monthlyReport.findMaxProfitItem(3);
            monthlyReport.findMaxExpenseItem(3);
        }

    void printYearlyReport() {                                               // Метод для вывода годового отчета
        if (yearlyReport.findIncome(1) == 0){                       //Проверка на считывание
            System.out.println("Данные по годовому отчету еще не считаны! Пожалуйста, сначала считайте данные!");
            return;
        }
        System.out.println("За 2021 год прибыль составила:" + "\n" +
                "Январь: " + yearlyReport.calculateProfit(1) + ".\n" +
                "Февраль: " + yearlyReport.calculateProfit(2) + ".\n" +
                "Март: " + yearlyReport.calculateProfit(3) + ".\n" +
                "Средний расход за все месяцы составил " + yearlyReport.calculateAverageExpense() + ".\n" +
                "Средний доход за все месяцы составил " + yearlyReport.calculateAverageIncome() + ".");
    }
}