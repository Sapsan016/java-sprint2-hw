import java.util.ArrayList;

public class YearlyReport {
    int year;
    ArrayList<YearlyRecord> rows = new ArrayList<>();                      //Список для хранения данных

    public void saveYearlyReport(int year, String path) {                   //Считать годовой отчёт

        this.year = year;
        String fileContents = CsvFileReader.readFileContentsOrNull(path);    //Считываем файл
        assert fileContents != null;
        String[] lines = fileContents.split("\n");              //Делим строку по линиям
        for (int i = 1; i < lines.length; i++) {
            String line = lines[i];
            String[] parts = line.split(",");                     // Делим строку по запятым
            int month = Integer.parseInt(parts[0]);                     //Передаем первую колонку
            int amount = Integer.parseInt(parts[1]);                    //Передаем вторую колонку
            boolean isExpense = Boolean.parseBoolean(parts[2]);         //Передаем третью колонку
            rows.add(new YearlyRecord(month, amount, isExpense));       //Сохраняем данные
        }
    }
    public int findIncome(int monthNum) {                  //Находим и возвращаем доход по месяцам
        int income = 0;
        if (monthNum == 1) {                                            //Январь
            for (YearlyRecord row : rows) {
                if (row.month == 1 && (!row.isExpense)) {
                    income = row.amount;
                }
            }return income;
        } else if (monthNum == 2) {                                     //Февраль
            for (YearlyRecord row : rows) {
                if (row.month == 2 && (!row.isExpense)) {
                    income = row.amount;
                }
            }return income;
       }else                                                            //Март
            for (YearlyRecord row : rows) {
                if (row.month == 3 && (!row.isExpense)) {
                    income = row.amount;
                }
            }return income;
    }
    public int findExpense(int monthNum){                  //Находим и возвращаем расходы по месяцам
        int expense = 0;
        if (monthNum == 1) {                                            //Январь
            for (YearlyRecord row : rows) {
                if (row.month == 1 && (row.isExpense)) {
                    expense = row.amount;
                }
            }return expense;
        } else if (monthNum == 2) {                                     //Февраль
            for (YearlyRecord row : rows) {
                if (row.month == 2 && (row.isExpense)) {
                    expense = row.amount;
                }
            }return expense;
        }else                                                            //Март
            for (YearlyRecord row : rows) {
                if (row.month == 3 && (row.isExpense)) {
                    expense = row.amount;
                }
        }return expense;
    }
    public int calculateProfit(int monthNum) {                                //Находим и возвращаем прибыль по месяцам
      int profit;
        if (monthNum == 1){                                                           //Январь
            profit = findIncome(1) - findExpense(1);
            return profit;
            }else if (monthNum == 2) {                                                //Февраль
            profit= findIncome(2) - findExpense(2);
            return profit;
            }else {                                                                      //Март
                   profit = findIncome(3) - findExpense(3);
            return profit;
        }
    }
    public int calculateAverageIncome() {    //Метод для подсчета среднего дохода за год
        int sum = 0;
        int month = 3;
        for (YearlyRecord row : rows) {
            if (!row.isExpense) {
                sum += row.amount;
                }
            }return sum / month;
    }
    int calculateAverageExpense() {  //Метод для подсчета среднего расхода за год
        int sum = 0;
        int month = 3;
        for (YearlyRecord row : rows) {
            if (row.isExpense) {
                sum += row.amount;
            }
        }return sum / month;
    }
}
