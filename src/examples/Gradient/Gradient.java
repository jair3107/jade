package examples.Gradient;

import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;

public class Gradient extends Agent {

    protected void setup() {
        System.out.println("Agent " + getLocalName() + " started.");
        addBehaviour(new MyOneShotBehaviour());
    }

    private class MyOneShotBehaviour extends OneShotBehaviour {

        public void action() {
            GradiantFunction  linear = new GradiantFunction();
            linear.GradiantFunction();
            linear.LinearRegression();
            System.out.println("y = Beta0: " + String.valueOf(linear.getBeta0()) +
                    " + (" + " Beta1: "+String.valueOf(linear.getBeta1()) +
                    ")("+String.valueOf(linear.getxValue()) + ")");
            System.out.println("y = " + String.valueOf(linear.getResult()));
        }

        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }

    }    // END of inner class ...Behaviour
}