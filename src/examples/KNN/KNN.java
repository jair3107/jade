package examples.KNN;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import examples.KNN.KnnFormula;
import examples.KNN.dataSet;

public class KNN extends Agent {

  protected void setup() {
    System.out.println("Agent " + getLocalName() + " started.");
    addBehaviour(new KNNBehaviour());
  }

  private class KNNBehaviour extends Behaviour {

    boolean condition = false;

    public void action() {
      System.out.println("Agent's action method is executed");

      KnnFormula knn = new KnnFormula();
      knn.Master();
      
      condition = true;
    }

    public boolean done() {
      if (condition)
        return true;
      else
        return false;
    }

    public int onEnd() {
      myAgent.doDelete();
      return super.onEnd();
    }
  } // END of inner class ...Behaviour
}
