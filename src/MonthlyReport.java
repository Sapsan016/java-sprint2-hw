import java.util.ArrayList;

public class MonthlyReport {

    ArrayList<MonthlyRecord> rows = new ArrayList<>();                  //Список для хранения данных


    public void saveMonthlyReport() {                                      //Считываем все месячные отчеты

        int months = 3;

        for (int i = 1; i <= months; i++) {                                         //Цикл для имени файла
            String fileName = "resources/m.20210" + i + ".csv";                     //Получаем имя файла
            String fileContents = CsvFileReader.readFileContentsOrNull(fileName);

            assert fileContents != null;
            String[] lines = fileContents.split("\n");                        //Делим строку по линиям

            for (int j = 1; j < lines.length; j++) {
                String line = lines[j];

                String[] parts = line.split(",");                               //Делим линии по запятым

                String itemName = parts[0];                                            //Передаем  данные
                boolean isExpense = Boolean.parseBoolean(parts[1]);
                int quantity = Integer.parseInt(parts[2]);
                int sumOfOne = Integer.parseInt(parts[3]);

                rows.add(new MonthlyRecord(i, itemName, isExpense, quantity, sumOfOne));   //Сохраняем данные,
                                                                                            // где i это номер месяца
            }
        }
    }
    public int calculateTotalExpense(int monthNum){         //Считаем общий расход по месяцам
        int sumExpense = 0;
        if (monthNum == 1) {
            for (MonthlyRecord row : rows) {
                if (row.monthNum == 1 && (row.isExpense)){
                    sumExpense += (row.sumOfOne * row.quantity); //Общий расход за Январь
                }
            }return sumExpense;
        }else if (monthNum == 2) {
            for (MonthlyRecord row : rows) {
                if (row.monthNum == 2 && (row.isExpense)) {
                    sumExpense += (row.sumOfOne * row.quantity); //Общий расход за Февраль
                }
            }return sumExpense;
        }else {
            for (MonthlyRecord row : rows) {
                if (row.monthNum == 3 && (row.isExpense)) {
                    sumExpense += (row.sumOfOne * row.quantity); //Общий расход за Март
                }
            }
        } return sumExpense;
    }

    public int calculateTotalIncome(int monthNum) {                 //Считаем общий доход по месяцам
        int sumIncome = 0;
        if (monthNum == 1) {
            for (MonthlyRecord row : rows) {
                if (row.monthNum == 1 && (!row.isExpense)) {
                    sumIncome += (row.sumOfOne * row.quantity); //Общий доход за Январь
                    }
                }return sumIncome;
            }else if (monthNum == 2) {
            for (MonthlyRecord row : rows) {
                if (row.monthNum == 2 && (!row.isExpense)) {
                    sumIncome += (row.sumOfOne * row.quantity); //Общий доход за Февраль
                    }
                }return sumIncome;
            } else {
            for (MonthlyRecord row : rows) {
                if (row.monthNum == 3 && (!row.isExpense)) {
                    sumIncome += (row.sumOfOne * row.quantity); //Общий доход за Март
                }
            }
        }return sumIncome;
    }

    public void findMaxProfitItem(int monthNum) {        // Находим самый прибыльный товар по месяцам
        int sumMaxProfitItem = 0;
        String maxProfitItem = null;
        if (monthNum == 1) {                                //Январь
            for (MonthlyRecord row : rows) {
                if (row.monthNum == 1 && (!row.isExpense)) {
                    if ((row.sumOfOne * row.quantity) > sumMaxProfitItem) {
                        sumMaxProfitItem = (row.sumOfOne * row.quantity);
                        maxProfitItem = row.itemName;
                    }
                }
            }
            System.out.println("Самый прибыльный товар: " + maxProfitItem + ". Выручена сумма: " + sumMaxProfitItem);
        } else if (monthNum == 2) {                             //Февраль

            for (MonthlyRecord row : rows) {
                if (row.monthNum == 2 && (!row.isExpense)) {
                    if ((row.sumOfOne * row.quantity) > sumMaxProfitItem) {
                        sumMaxProfitItem = (row.sumOfOne * row.quantity);
                        maxProfitItem = row.itemName;
                    }
                }
            }
            System.out.println("Самый прибыльный товар: " + maxProfitItem + ". Выручена сумма: " + sumMaxProfitItem);
        } else {
            for (MonthlyRecord row : rows) {                                //Март
                if (row.monthNum == 3 && (!row.isExpense)) {
                    if ((row.sumOfOne * row.quantity) > sumMaxProfitItem) {
                        sumMaxProfitItem = (row.sumOfOne * row.quantity);
                        maxProfitItem = row.itemName;
                    }
                }
            }
            System.out.println("Самый прибыльный товар: " + maxProfitItem + ". Выручена сумма: " + sumMaxProfitItem);
        }
    }
    public void findMaxExpenseItem(int monthNum) {    //Находим самую большую трату по месяцам
        int sumMaxExpenseItem = 0;
        String maxExpenseItem = null;
        if (monthNum == 1) {                                            //Январь
            for (MonthlyRecord row : rows) {
                if (row.monthNum == 1 && (row.isExpense)) {
                    if ((row.sumOfOne * row.quantity) > sumMaxExpenseItem) {
                        sumMaxExpenseItem = (row.sumOfOne * row.quantity);
                        maxExpenseItem = row.itemName;
                    }
                }
            }
            System.out.println("Самый большая трата: " + maxExpenseItem + ". Потрачена сумма: " + sumMaxExpenseItem);
        } else if (monthNum == 2) {                                                 //Февраль

            for (MonthlyRecord row : rows) {
                if (row.monthNum == 2 && (row.isExpense)) {
                    if ((row.sumOfOne * row.quantity) > sumMaxExpenseItem) {
                        sumMaxExpenseItem = (row.sumOfOne * row.quantity);
                        maxExpenseItem = row.itemName;
                    }
                }
            }
            System.out.println("Самый большая трата: " + maxExpenseItem + ". Потрачена сумма: " + sumMaxExpenseItem);
        } else {
            for (MonthlyRecord row : rows) {                                    //Март
                if (row.monthNum == 3 && (row.isExpense)) {
                    if ((row.sumOfOne * row.quantity) > sumMaxExpenseItem) {
                        sumMaxExpenseItem = (row.sumOfOne * row.quantity);
                        maxExpenseItem = row.itemName;
                    }
                }
            }
            System.out.println("Самый большая трата: " + maxExpenseItem + ". Потрачена сумма: " + sumMaxExpenseItem);
        }
    }
}
