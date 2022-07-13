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
    public int findIncome(int monthNum) {                           //Находим и возвращаем доход по месяцам
       int income = 0;
       for (YearlyRecord row : rows) {
           if (row.month == monthNum && (!row.isExpense)) {         //Номер месяца передаем в цикл
                    income = row.amount;                            //Доход за месяц
                }
            }return income;
        }

    public int findExpense(int monthNum){                                   //Находим и возвращаем расходы по месяцам
        int expense = 0;
        for (YearlyRecord row : rows) {
            if (row.month == monthNum && (row.isExpense)) {                 //Передаем номер месяца в цикл
                    expense = row.amount;                                   //Расход за месяц
                }
            }return expense;
        }

    public int calculateProfit(int monthNum) {                               //Находим и возвращаем прибыль по месяцам
        return findIncome(monthNum) - findExpense(monthNum);
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
