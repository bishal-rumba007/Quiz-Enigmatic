import java.util.TimerTask;
public class CountDown extends TimerTask
{
    int i=20;
    public void run() {
        if(i>0)
        {
            System.out.print(i-- +" ");
        }
        else if(i==0)
        {
            System.out.println();
            System.out.println("Time's Up...");
            System.out.println("Choose One Option");
            i--;
        }
    }
}
