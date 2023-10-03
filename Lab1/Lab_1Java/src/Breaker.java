import java.util.Arrays;
public class Breaker implements Runnable
{

        private Counter[] _conters;

        public Breaker(Counter[] counters)
        {
            _conters = counters;
            Arrays.sort(_conters);
        }

        @Override
        public void run()
        {
            long currentWaitedTime = 0;

            for (int i = 0; i<_conters.length;i++){
                long waitingTime = _conters[i].getTimeOfWork() - currentWaitedTime;
                try {
                    Thread.sleep(waitingTime);
                    currentWaitedTime += waitingTime;
                    _conters[i].CanStop();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
}
