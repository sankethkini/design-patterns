package dp;

import java.util.ArrayList;
import java.util.Iterator;
  
// Implemented by Cricket data to communicate
// with observers
interface Subject
{
    public void registerObserver(Observer o);
    public void unregisterObserver(Observer o);
    public void notifyObservers();
}
  
class CricketData implements Subject
{
    int runs;
    int wickets;
    float overs;
    ArrayList<Observer> observerList;
  
    public CricketData() {
        observerList = new ArrayList<Observer>();
    }
  
    @Override
    public void registerObserver(Observer o) {
        observerList.add(o);
    }
  
    @Override
    public void unregisterObserver(Observer o) {
        observerList.remove(observerList.indexOf(o));
    }
  
    @Override
    public void notifyObservers()
    {
        for (Iterator<Observer> it =
              observerList.iterator(); it.hasNext();)
        {
            Observer o = it.next();
            o.update(runs,wickets,overs);
        }
    }
  
    // get latest runs from stadium
    private int getLatestRuns()
    {
        // return 90 for simplicity
        return 90;
    }
  
    // get latest wickets from stadium
    private int getLatestWickets()
    {
        // return 2 for simplicity
        return 2;
    }
  
    // get latest overs from stadium
    private float getLatestOvers()
    {
        // return 90 for simplicity
        return (float)10.2;
    }
  
    // This method is used update displays
    // when data changes
    public void dataChanged()
    {
        //get latest data
        runs = getLatestRuns();
        wickets = getLatestWickets();
        overs = getLatestOvers();
  
        notifyObservers();
    }
}
  
// This interface is implemented by all those
// classes that are to be updated whenever there
// is an update from CricketData
interface Observer
{
    public void update(int runs, int wickets,
                      float overs);
}
  
class AverageScoreDisplay implements Observer
{
    private float runRate;
    private int predictedScore;
  
    public void update(int runs, int wickets,
                       float overs)
    {
        this.runRate =(float)runs/overs;
        this.predictedScore = (int)(this.runRate * 50);
        display();
    }
  
    public void display()
    {
        System.out.println("\nAverage Score Display: \n"
                           + "Run Rate: " + runRate +
                           "\nPredictedScore: " +
                           predictedScore);
    }
}
  
class CurrentScoreDisplay implements Observer
{
    private int runs, wickets;
    private float overs;
  
    public void update(int runs, int wickets,
                       float overs)
    {
        this.runs = runs;
        this.wickets = wickets;
        this.overs = overs;
        display();
    }
  
    public void display()
    {
        System.out.println("\nCurrent Score Display:\n"
                           + "Runs: " + runs +
                           "\nWickets:" + wickets +
                           "\nOvers: " + overs );
    }
}

public class Observerpat {
	public static void main(String[] args) {
		CricketData c=new CricketData();
		Observer a=new AverageScoreDisplay();
		c.registerObserver(a);
		Observer b=new CurrentScoreDisplay();
		c.registerObserver(b);
		c.dataChanged();
		c.unregisterObserver(b);
		c.dataChanged();
	}

}
//in a runtime where memory is managed automatically like Java or C#, the subject holds a strong reference to 
//the observers, keeping them alive. The strong reference from the subject (the observed object) to the observer
//, prevents the observer (and any objects it references) from being garbage collected until the observer is 
//unregistered. A memory leak happens, if the observer fails to unregister from the subject when it no longer 
//needs to receive notifications. In our countdown timer example if observers do not call unregister when 
//they become invisible, they will receive notifications and waste CPU cycles updating invisible UI elements.
//This issue is called Lapsed Listener Problem.