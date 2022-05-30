package examples.SLR;

public class SimpleLinearRegression {
  double beta0;
  double beta1;

  public SimpleLinearRegression() {
    beta0 = 0;
    beta1 = 0;
  }

  public void calculateB0(double summationX, double summationY) {
    beta0 = (summationY - beta1 * summationX) / 9;
  }

  public void calculateB1(double summationX, double summationY, double summationXY, double summationX2) {
    beta1 = (summationXY - summationX * summationY) / (summationX2 - summationX * summationX);
  }

  public void display() {
    System.out.println(beta0 + " + " + beta1 + " * X");
  }

  public void predict(double value) {
    double ans = 0;
    ans = beta0 + beta1 * value;
    System.out.println(ans);
  }
}
