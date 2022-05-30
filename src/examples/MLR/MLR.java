package examples.MLR;

import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import examples.MLR.DataSet;
import examples.MLR.MLRFormula;

public class MLR extends Agent {

    protected void setup() {
        System.out.println("Agent " + getLocalName() + "started");
        addBehaviour(new MLRBehaviour());
    }

    private class MLRBehaviour extends Behaviour {
        boolean flag = false;

        public void action() {
            System.out.println("Ejecutando agente");
            DataSet dataset = new DataSet();
            MLRFormula mlrFormula = new MLRFormula();

            double[][] x = dataset.getX();
            double[][] y = dataset.getY();

            mlrFormula.calculateBetas(x, y);
            mlrFormula.display();
            mlrFormula.predict(80);
            //mlr 82.5, 31.2
            flag = true;
        }

        public boolean done() {
            if (flag)
                return true;
            else
                return false;
        }

        public int onEnd() {
            myAgent.doDelete();
            return super.onEnd();
        }

    }
}
