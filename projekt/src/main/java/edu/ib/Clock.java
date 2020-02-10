package edu.ib;

import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.time.LocalTime;

public class Clock implements Runnable {
     public Text textIII;
    String info="I";
    private Thread thread;
    protected volatile boolean isRunning = false;
    private int interval;
    String stop ="IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII";
    Button buttonPrzejdzDalej;
    boolean connected;


    public Clock(Text weryfikacja, Button buttonPrzejdzDalej, boolean connected) {
        this.textIII = weryfikacja;
        this.buttonPrzejdzDalej=buttonPrzejdzDalej;
        this.interval=50;
        this.connected=connected;
    }

    public boolean isRunning(){
        return isRunning;
    }

    public void resume(){
        isRunning=true;
    }

    public void start() {
        thread = new Thread(this, "Clock thread");
        thread.start();
    }

    public void stop() {
        isRunning = false;

    }


    @Override
    public void run() {

        isRunning = true;
        while (isRunning) {
            info=info.concat("I");
            textIII.setText(info);
            if (info.equals(stop)){
                isRunning=false;
                if(connected) {
                    buttonPrzejdzDalej.setDisable(false);
                }





            }





            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {
                System.out.println("zle");
                e.printStackTrace();
            }

        }
    }

}
