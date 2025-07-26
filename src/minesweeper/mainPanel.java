package minesweeper;

import java.awt.Color;

import javax.swing.JPanel;

public class mainPanel extends JPanel{

    mainPanel()
    {
        setBounds(0,0,Window.Width_Of_Frame,Window.Height_Of_Frame);
        setBackground(Color.gray);
        setLayout(null);
    }

}
