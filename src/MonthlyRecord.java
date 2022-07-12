public class MonthlyRecord {            //Класс для хранения месячных отчетов
    int monthNum;
    String itemName;
    boolean isExpense;
    int quantity;

    int sumOfOne;

    public MonthlyRecord(int monthNum, String itemName,  boolean isExpense, int quantity, int sumOfOne) {


        this.monthNum = monthNum;
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;

    }
}



