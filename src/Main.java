public class Main {

    public static void main(String[] args) {
        Validator validator = new Validator();

        while (true) {
            printMenu();

            int userInput = validator.checkIsInteger();

            if (userInput == 1) {                                                // Считать все месячные отчёты
                validator.getMonthlyRecords();
            } else if (userInput == 2) {                                         //Считать годовой отчёт
                validator.getYearlyRecord();

            } else if (userInput == 3) {                                         //Сверить отчёты
                Validator.validateIncome();                                      //Сверяем доходы в годовом и меячных отчетах
                Validator.validateExpense();                                     //Сверяем расходы в годовом и меячных отчетах

            } else if (userInput == 4) {                                        //Вывести информацию о всех месячных отчётах
                validator.printMonthlyReport();

            } else if (userInput == 5) {                                        //Вывести информацию о годовом отчёте
                validator.printYearlyReport();

            } else if (userInput == 0) {                                        // Выход
                return;
            } else {
                System.out.println("Такой команды нет!");
            }
        }
    }

    private static void printMenu() {
        System.out.println("Пожалуйста, введите номер команды.");
        System.out.println("1. Считать все месячные отчёты.");
        System.out.println("2. Считать годовой отчёт.");
        System.out.println("3. Сверить отчёты.");
        System.out.println("4. Вывести информацию о всех месячных отчётах.");
        System.out.println("5. Вывести информацию о годовом отчёте.");
        System.out.println("0. Завершить работу.");

    }
}
