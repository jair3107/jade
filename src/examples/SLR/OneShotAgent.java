package examples.SLR;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;
import examples.SLR.DataSet;
import examples.SLR.Summations;
import examples.SLR.SimpleLinearRegression;

public class OneShotAgent extends Agent { 
  
  protected void setup() {
    System.out.println("Agent " + getLocalName() + " startewd.");
    addBehaviour(new MyOneShotBehaviour());
  }

  private class MyOneShotBehaviour extends OneShotBehaviour {
    
    public void action() {
      System.out.println("Agent's action method executed");
      DataSet dataset = new DataSet();
      Summations summations = new Summations();
      SimpleLinearRegression simplelinearregresion = new SimpleLinearRegression();
      int[] x = dataset.getX();
      int[] y = dataset.getY();
      double summationX = summations.summationX(x);
      double summationY = summations.summationY(y);
      double summationXY = summations.summationXY(x, y);
      double summationX2 = summations.summationX2(x);
      simplelinearregresion.calculateB1(summationX, summationY, summationXY, summationX2);
      simplelinearregresion.calculateB0(summationX, summationY);
      simplelinearregresion.display();
      simplelinearregresion.predict(80);
    }

    public int onEnd() {
      myAgent.doDelete();
      return super.onEnd();
    }
  } // END of inner class ...Behaviour
}
