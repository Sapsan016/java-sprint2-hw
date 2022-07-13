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
    public int calculateTotalExpense(int monthNum){                 //Считаем общий расход по месяцам
        int sumExpense = 0;
            for (MonthlyRecord row : rows) {
                if (row.monthNum == monthNum && (row.isExpense)){       //Номер месяца передается в цикл
                    sumExpense += (row.sumOfOne * row.quantity);        //Сумма общего расхода за месяц
                }
            }return sumExpense;
        }

    public int calculateTotalIncome(int monthNum) {                 //Считаем общий доход по месяцам
        int sumIncome = 0;
            for (MonthlyRecord row : rows) {
                if (row.monthNum == monthNum && (!row.isExpense)) {         //Номер месяца передается в цикл
                    sumIncome += (row.sumOfOne * row.quantity);             //Сумма дохода за месяц
                    }
                        }return sumIncome;
    }

    public void findMaxProfitItem(int monthNum) {        // Находим самый прибыльный товар по месяцам
        int sumMaxProfitItem = 0;
        String maxProfitItem = null;
            for (MonthlyRecord row : rows) {
                if (row.monthNum == monthNum && (!row.isExpense)) {         //Номер месяца передается в цикл
                    if ((row.sumOfOne * row.quantity) > sumMaxProfitItem) {
                        sumMaxProfitItem = (row.sumOfOne * row.quantity);       //Сумма самого прибыльного товара
                        maxProfitItem = row.itemName;                           //Название самого прибыльного товара
                    }
                }
            }
        System.out.println("Самый прибыльный товар: " + maxProfitItem + ". Выручена сумма: " + sumMaxProfitItem);
    }

    public void findMaxExpenseItem(int monthNum) {    //Находим самую большую трату по месяцам
        int sumMaxExpenseItem = 0;
        String maxExpenseItem = null;
            for (MonthlyRecord row : rows) {
                if (row.monthNum == monthNum && (row.isExpense)) {                  //Номер месяца передается в цикл
                    if ((row.sumOfOne * row.quantity) > sumMaxExpenseItem) {
                        sumMaxExpenseItem = (row.sumOfOne * row.quantity);         //Сумма наибольшей траты
                        maxExpenseItem = row.itemName;                             //Название самой дорогой траты
                    }
                }
            }
        System.out.println("Самый большая трата: " + maxExpenseItem + ". Потрачена сумма: " + sumMaxExpenseItem);
        }
    }