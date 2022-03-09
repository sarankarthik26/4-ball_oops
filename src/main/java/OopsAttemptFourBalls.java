import processing.core.PApplet;
import java.util.ArrayList;

class Ball{
    private int xaxis = 0;
    private int yaxis = 0;

    Ball(int yaxis){
        this.yaxis = yaxis;
    }

    public int[] getPos(){
        return new int[]{this.xaxis, this.yaxis};
    }

    public void modifyXPos(int x){
        this.xaxis += x;
    }
}


public class OopsAttemptFourBalls extends PApplet {
    public static final int WIDTH = 640;
    public static final int HEIGHT = 480;
    final int WIDTHOFBALL = 20;
    final int HEIGHTOFBALL = 20;
    ArrayList<Ball> Bag1 = BallBag(4);

    public static void main(String[] args) {
        PApplet.main("OopsAttemptFourBalls",args);
    }

    @Override
    public void settings() {
        super.settings();
        size(WIDTH,HEIGHT);
    }

    @Override
    public void setup() {
        super.setup();
    }

    @Override
    public void draw() {
        for (int n = 0; n < Bag1.size(); n++) {
            Ball nthBall = getNthBall(n);
            DrawEllipse(nthBall);
            MoveTheBall(n, nthBall);
        }
    }


    public ArrayList<Ball> BallBag(int count){
        ArrayList<Ball> BallBag = new ArrayList<>(count);
        for (int i = 1; i <= count ; i++) {
            BallBag.add(new Ball(HEIGHT*i/5));
        }
        return BallBag;
    }

    private void MoveTheBall(int i, Ball nthBall) {
        nthBall.modifyXPos(i +1);
    }

    private void DrawEllipse(Ball nthBall) {
        ellipse(nthBall.getPos()[0], nthBall.getPos()[1], WIDTHOFBALL, HEIGHTOFBALL );
    }

    private Ball getNthBall(int i) {
        return Bag1.get(i);
    }
}
