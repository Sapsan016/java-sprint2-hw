public class YearlyRecord {         //Класс для хранения годового отчета
    int month;
    int amount;
    boolean isExpense;

    public YearlyRecord(int month, int amount, boolean isExpense) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }
}