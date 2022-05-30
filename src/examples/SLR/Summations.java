package examples.SLR;

public class Summations{

    public double summationXY(int[] x, int[] y){
        double ans = 0;
        for(int i=0; i<9; i++){
          ans = ans + (9 * x[i] * y[i]);
        }
        return ans; 
      }
  
      public double summationX(int[] x){
        double ans = 0;
        for(int i=0; i<9; i++){
          ans = ans + x[i];
        }
        return ans; 
      }
  
      public double summationY(int[] y){
        double ans = 0;
        for(int i=0; i<9; i++){
          ans = ans + y[i];
        }
        return ans; 
      }
  
      public double summationX2(int[] x){
        double ans = 0;
        for(int i=0; i<9; i++){
          ans = ans + (9 * (x[i] * x[i]));
        }
        return ans; 
      }
}