package minesweeper;

import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTimer {

    private int time=0;
    private Timer timer;
    private JLabel timerLabel;

    GameTimer(JLabel timerLabel)
    {
        this.timerLabel=timerLabel;

        timer = new Timer(1000,new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                time++;
                timerLabel.setText("TIME: "+time);
            }
            
        });
    }

    public void startTimer()
    {
        time=0;
        timer.start();
    }

    public void stopTimer()
    {
        timer.stop();
    }

    public int getTime() {
        return time;
    }

}
