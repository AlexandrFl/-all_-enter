import java.util.concurrent.ConcurrentLinkedQueue;

public class ATS {
    private final int SLEEP = 1000;
    protected final int CALL_COUNT = 10;
    protected boolean status = true;

    protected ConcurrentLinkedQueue<Call> queue = new ConcurrentLinkedQueue<>();

    public void generateCall() {
        int i = 0;
        try {
            while (!Thread.currentThread().isInterrupted()) {
                if (i < CALL_COUNT) {
                    Thread.sleep(SLEEP);
                    queue.add(new Call());
                    System.out.println("\uD83D\uDCDE Поступил входящий звонок № " + ++i + " \uD83D\uDCDE");
                } else {
                    status = false;
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("\n*** Входящие звонки больше не принимаются ***\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
