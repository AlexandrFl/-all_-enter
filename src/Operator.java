public class Operator {

    private final int SLEEP = 3000;
    protected int callCount = 0;

    ATS ats;

    public Operator(ATS ats) {
        this.ats = ats;
    }

    public void callProcessing() {
        try {
            while (ats.status || ats.queue.size() > 0) {
                    if (ats.queue.poll() != null) {
                        Thread.sleep(SLEEP);
                        System.out.println(" ✔ " + Thread.currentThread().getName() + " обработал звонок " + ++callCount + " ✔");
                    }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
