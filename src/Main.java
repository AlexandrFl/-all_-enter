public class Main {

    public static void main(String[] args) {

        ATS ats = new ATS();
        Operator operator = new Operator(ats);
        Thread call = new Thread(null, ats::generateCall, "Пользователь");

        Thread operator_1 = new Thread(null, operator::callProcessing, "Оператор 1");
        Thread operator_2 = new Thread(null, operator::callProcessing, "Оператор 2");
        Thread operator_3 = new Thread(null, operator::callProcessing, "Оператор 3");
        Thread operator_4 = new Thread(null, operator::callProcessing, "Оператор 4");

        call.start();

        operator_1.start();
        operator_2.start();
        operator_3.start();
        operator_4.start();
    }
}








