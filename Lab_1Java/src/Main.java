public class Main {
    public static void main(String[] args)
    {
        Counter[] counters =
                {
                        new Counter(1, 1L, 1000),
                        new Counter(2, 2L, 6000),
                        new Counter(3, 4L, 2000),
                        new Counter(4, 6L, 3000),
                        new Counter(5, 8L, 5000),
                        new Counter(6, 10L, 4000),
                        new Counter(7, 12L, 7000),
                        new Counter(8, 14L, 8000),
                };

        Thread[] threads = new Thread[counters.length];
        Breaker breaker = new Breaker(counters);

        for (int i = 0; i < counters.length; i++)
        {
            threads[i] = new Thread(counters[i]);
            threads[i].start();
        }
        new Thread(breaker).start();
    }
}