package minesweeper;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Window extends JFrame implements ActionListener {

    Game game;
    mainPanel mPanel;
    JButton[][] boxButtonList;
    GameTimer gameTimer;

    Dimension BoxDimension=new Dimension(32,32);
    ImageIcon closeBoxIcon=new ImageIcon("src\\All_PNG\\CloseBox.png");
    ImageIcon closeBoxIcon2= new ImageIcon("src\\All_PNG\\CloseBox2.png");
    ImageIcon emptyBoxIcon=new ImageIcon("src\\All_PNG\\EmptyBox.png");
    ImageIcon mineBoxIcon=new ImageIcon("src\\All_PNG\\Mine.png");
    ImageIcon box1Icon=new ImageIcon("src\\All_PNG\\Box1.png");
    ImageIcon box2Icon=new ImageIcon("src\\All_PNG\\Box2.png");
    ImageIcon box3Icon=new ImageIcon("src\\All_PNG\\Box3.png");
    ImageIcon box4Icon=new ImageIcon("src\\All_PNG\\Box4.png");
    ImageIcon box5Icon=new ImageIcon("src\\All_PNG\\Box5.png");
    ImageIcon box6Icon=new ImageIcon("src\\All_PNG\\Box6.png");
    ImageIcon box7Icon=new ImageIcon("src\\All_PNG\\Box7.png");
    ImageIcon box8Icon=new ImageIcon("src\\All_PNG\\Box8.png");
    ImageIcon lightFlaggedBoxIcon=new ImageIcon("src\\All_PNG\\lightFlaggedBoxIcon.png");
    ImageIcon darkFlaggedBoxIcon=new ImageIcon("src\\All_PNG\\darkFlaggedBoxIcon.png");

    public static final int Width_Of_Frame=800;
    public static final int Height_Of_Frame=800;
    public static final int X_Of_Frame=(1920-Width_Of_Frame)/2;
    public static final int Y_Of_Frame=(1080-Height_Of_Frame)/2;

    public static final int PixelOfCloseBox=32;

    public static final int Easy_GameRow=8;
    public static final int Easy_GameColon=7;
    public static final int Easy_SizeOfSmallEdge=Easy_GameColon*PixelOfCloseBox; //160
    public static final int Easy_SizeOfLongEdge=Easy_GameRow*PixelOfCloseBox; //320
    public static final int Easy_NumberOfBox=Easy_GameColon*Easy_GameRow;
    public static final int Easy_XofPanel=(Width_Of_Frame-Easy_SizeOfSmallEdge)/2; //(800-160)/2
    public static final int Easy_YofPanel=(Height_Of_Frame-Easy_SizeOfLongEdge)/2;

    public static final int Medium_GameRow=10;
    public static final int Medium_GameColon=8;
    public static final int Medium_SizeOfSmallEdge=Medium_GameColon*PixelOfCloseBox;
    public static final int Medium_SizeOLongEdge=Medium_GameRow*PixelOfCloseBox;
    public static final int Medium_NumberOfBox=Medium_GameColon*Medium_GameRow;
    public static final int Medium_XofPanel=(Width_Of_Frame-Medium_SizeOfSmallEdge)/2;
    public static final int Medium_YofPanel=(Height_Of_Frame-Medium_SizeOLongEdge)/2;

    public static final int Hard_GameRow=13;
    public static final int Hard_GameColon=11;
    public static final int Hard_SizeOfSmallEdge=Hard_GameColon*PixelOfCloseBox;
    public static final int Hard_SizeOfLongEdge=Hard_GameRow*PixelOfCloseBox;
    public static final int Hard_NumberOfBox=Hard_GameColon*Hard_GameRow;
    public static final int Hard_XofPanel=(Width_Of_Frame-Hard_SizeOfSmallEdge)/2;
    public static final int Hard_YofPanel=(Height_Of_Frame-Hard_SizeOfLongEdge)/2;

    JLabel tittleLabel,lb,flaglb,timerlb;
    JPanel tittlePanel,StartButtonPanel,ChoiceButtonPanel,GameDifficultyButtonPanel,gamePanel,p,flagp,timerp;
    JButton StartButton,PlayButton,BestScoreButton,ExitButton,CloseBoxButton,finishGameButton;
    JButton HardGameButton,MediumGameButton,EasyGameButton,BackButton;

    Font tittleFont=new Font("Times New Roman",Font.PLAIN,80);
    Font normalFont=new Font("Times New Roman",Font.PLAIN,30);

    public Window(String tittle)
    {
        super(tittle);
        setResizable(false);
        setVisible(true);
        setBackground(getPanelColor());
        setBounds(X_Of_Frame,Y_Of_Frame,Width_Of_Frame,Height_Of_Frame);
        setSize(Width_Of_Frame, Height_Of_Frame);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(getPanelColor());
        setLayout(null);
        mPanel= new mainPanel();
        add(mPanel);

        CreateTittle();
        CreateStartButton();
    }

    public void CreateTittle()
    {
        tittleLabel=new JLabel("MİNESWEEPER");
        tittleLabel.setFont(tittleFont);
        tittleLabel.setForeground(Color.BLACK);

        tittlePanel=new JPanel();
        tittlePanel.setBounds(100,150,600,100);
        tittlePanel.setBackground(getPanelColor());
        tittlePanel.add(tittleLabel);

        mPanel.add(tittlePanel);
    }

    public void CreateStartButton()
    {
        StartButton=new JButton("START");
        StartButton.setBackground(Color.black);
        StartButton.setForeground(Color.white);
        StartButton.setFont(normalFont);
        StartButton.addActionListener(this);

        StartButtonPanel=new JPanel();
        StartButtonPanel.setBounds(300,450,200,60);
        StartButtonPanel.setBackground(getPanelColor());
        StartButtonPanel.add(StartButton);

        mPanel.add(StartButtonPanel);
    }

    public void CreateChoiceButtons()
    {   
        PlayButton=new JButton("PLAY");
        PlayButton.setFont(normalFont);
        PlayButton.setBackground(getButtonBackgroundColor());
        PlayButton.setForeground(getButtonForegroundColor());
        PlayButton.addActionListener(this);

        BestScoreButton=new JButton("BEST SCORE");
        BestScoreButton.setFont(normalFont);
        BestScoreButton.setBackground(getButtonBackgroundColor());
        BestScoreButton.setForeground(getButtonForegroundColor());
        BestScoreButton.addActionListener(this);

        ExitButton=new JButton("EXİT");
        ExitButton.setFont(normalFont);
        ExitButton.setBackground(getButtonBackgroundColor());
        ExitButton.setForeground(getButtonForegroundColor());
        ExitButton.addActionListener(this);

        ChoiceButtonPanel=new JPanel();
        ChoiceButtonPanel.setLayout(new GridLayout(3, 1));
        ChoiceButtonPanel.setBackground(getPanelColor());
        ChoiceButtonPanel.setBounds(250,450,300,150);
        ChoiceButtonPanel.add(PlayButton);
        ChoiceButtonPanel.add(BestScoreButton);
        ChoiceButtonPanel.add(ExitButton);

        mPanel.add(ChoiceButtonPanel);
    }
    
    public void CreateGameDifficultySelectionButtons()
    {
        HardGameButton= new JButton("HARD");
        HardGameButton.setBackground(getButtonBackgroundColor());
        HardGameButton.setForeground(getButtonForegroundColor());
        HardGameButton.setFont(normalFont);
        HardGameButton.addActionListener(this);
        HardGameButton.setFocusPainted(false);
        
        MediumGameButton= new JButton("MEDIUM");
        MediumGameButton.setBackground(getButtonBackgroundColor());
        MediumGameButton.setForeground(getButtonForegroundColor());
        MediumGameButton.setFont(normalFont);
        MediumGameButton.addActionListener(this);

        EasyGameButton = new JButton("EASY");
        EasyGameButton.setBackground(getButtonBackgroundColor());
        EasyGameButton.setForeground(getButtonForegroundColor());
        EasyGameButton.setFont(normalFont);
        EasyGameButton.addActionListener(this);
        
        BackButton = new JButton("BACK");
        BackButton.setBackground(getButtonBackgroundColor());
        BackButton.setForeground(getButtonForegroundColor());
        BackButton.setFont(normalFont);
        BackButton.addActionListener(this);

        GameDifficultyButtonPanel = new JPanel();
        GameDifficultyButtonPanel.setLayout(new GridLayout(4, 1));
        GameDifficultyButtonPanel.setBackground(getPanelColor());
        GameDifficultyButtonPanel.setBounds(250,450,300,150);
        GameDifficultyButtonPanel.add(HardGameButton);
        GameDifficultyButtonPanel.add(MediumGameButton);
        GameDifficultyButtonPanel.add(EasyGameButton);
        GameDifficultyButtonPanel.add(BackButton);

        mPanel.add(GameDifficultyButtonPanel);
    }

    public void addfinishGameButton()
    {
        finishGameButton= new JButton("Finish");
        finishGameButton.setBounds(650,700,110,40);
        finishGameButton.setBackground(getButtonBackgroundColor());
        finishGameButton.setForeground(getButtonForegroundColor());
        finishGameButton.setFont(normalFont);
        finishGameButton.addActionListener(this);
        finishGameButton.setFocusPainted(false);

        mPanel.add(finishGameButton);
    }

    public void createLoseText()
    {
        p=new JPanel();
        lb = new JLabel("MINE EXPLODED GAME OVER !");
        lb.setFont(normalFont);
        lb.setForeground(Color.white);
        lb.setSize(lb.getPreferredSize().width,lb.getPreferredSize().height);
        p.add(lb);
        p.setBounds((Width_Of_Frame-lb.getWidth())/2,100,p.getPreferredSize().width,p.getPreferredSize().height);
        p.setBackground(getPanelColor());
        mPanel.add(p);
        mPanel.repaint();
    }

    public void createWinText()
    {
        p = new JPanel();
        lb = new JLabel("AWESOME YOU WİN");
        lb.setFont(normalFont);
        lb.setForeground(Color.white);
        lb.setSize(lb.getPreferredSize().width,lb.getPreferredSize().height);
        p.add(lb);
        p.setBounds((Width_Of_Frame-lb.getWidth())/2,100,p.getPreferredSize().width,p.getPreferredSize().height);
        p.setBackground(getPanelColor());
        mPanel.add(p);
        mPanel.repaint();
    }

    public void CreateHardGame()
    {
        game = new Game();
        game.createHardGame();
        addfinishGameButton();
        fillBoxWithButton();
        createAndFillPanelWithBox(Hard_XofPanel,Hard_YofPanel,Hard_SizeOfSmallEdge,Hard_SizeOfLongEdge,Hard_GameRow,Hard_GameColon);
        gamePanel.repaint();
        mPanel.repaint();
    }

    public void CreateMediumGame()
    {
        game = new Game();
        game.createMediumGame();;
        addfinishGameButton();
        fillBoxWithButton();
        createAndFillPanelWithBox(Medium_XofPanel,Medium_YofPanel,Medium_SizeOfSmallEdge,Medium_SizeOLongEdge,Medium_GameRow,Medium_GameColon);
        gamePanel.repaint();
        mPanel.repaint();
    }

    public void CreateEasyGame()
    {
        game = new Game();
        game.createEasyGame();
        addfinishGameButton();
        fillBoxWithButton();
        createAndFillPanelWithBox(Easy_XofPanel,Easy_YofPanel,Easy_SizeOfSmallEdge,Easy_SizeOfLongEdge,Easy_GameRow,Easy_GameColon);
        gamePanel.repaint();
        mPanel.repaint();
    }


    public void createAndFillPanelWithBox(int XofPanel,int YofPanel,int SizeofSmalledge,int SizeOfLongEdge,int GameRow,int GameColon)
    {
        int numberOfBoxListColumns=game.getBoxlist()[0].length;
        int numberOfBoxListRows=game.getBoxlist().length;
        gamePanel = new JPanel();
        gamePanel.setBackground(getPanelColor());
        gamePanel.setBounds(XofPanel,YofPanel,SizeofSmalledge,SizeOfLongEdge);

        for(int i=0;i<numberOfBoxListRows;i++)
        {
            for(int k=0;k<numberOfBoxListColumns;k++)
            {
                gamePanel.add(game.getBoxlist()[i][k].getBoxButton());
            }
        }

        gamePanel.setLayout(new GridLayout(GameRow,GameColon));
        mPanel.add(gamePanel);
    }

    public void fillBoxWithButton()
    {
        int numberOfBoxListColumns=game.getBoxlist()[0].length;
        int numberOfBoxListRows=game.getBoxlist().length;
        for(int i=0;i<numberOfBoxListRows;i++)
        {
            for(int k=0;k<numberOfBoxListColumns;k++)
            {
                CloseBoxButton = new JButton();
                CloseBoxButton.addActionListener(closeBoxButtonListener(i,k));
                CloseBoxButton.addMouseListener(rightClickListener(i,k));
                game.getBoxlist()[i][k].setBoxButton(CloseBoxButton);

                if(i%2==0)
                {
                    if(k%2==1)
                    {
                        game.getBoxlist()[i][k].getBoxButton().setIcon(closeBoxIcon);
                        game.getBoxlist()[i][k].getBoxButton().setDisabledIcon(closeBoxIcon);
                    }  
                    else
                        game.getBoxlist()[i][k].getBoxButton().setIcon(closeBoxIcon2);
                }
                else
                {
                    if(k%2==0)
                        game.getBoxlist()[i][k].getBoxButton().setIcon(closeBoxIcon);
                    else
                        game.getBoxlist()[i][k].getBoxButton().setIcon(closeBoxIcon2);
                }

            }
        }
    }

    public void gameOverProccess()
    {
        openAndInactiveAllMines();
        createLoseText();
        gameTimer.stopTimer();
    }

    public void gameWinProccess()
    {
        InactiveAllBoxButtons();
        createWinText();
        gameTimer.stopTimer();
    }

    public void openAndInactiveAllMines()
    {
        int maxRow=game.getBoxlist().length;
        int maxColumn=game.getBoxlist()[0].length;
        for(int i=0;i<maxRow;i++)
        {
            for(int k=0;k<maxColumn;k++)
            {
                if(game.getBoxlist()[i][k] instanceof MineBoxes)
                    game.getBoxlist()[i][k].getBoxButton().setIcon(mineBoxIcon);
                game.getBoxlist()[i][k].getBoxButton().setDisabledIcon(game.getBoxlist()[i][k].getBoxButton().getIcon());
                game.getBoxlist()[i][k].getBoxButton().setEnabled(false);
            }
        }
    }

    public void InactiveAllBoxButtons()
    {
        int maxRow=game.getBoxlist().length;
        for(int i=0;i<maxRow;i++)
        {
            for(Boxes obj:game.getBoxlist()[i])
            {
                obj.boxButton.setDisabledIcon(obj.boxButton.getIcon());
                obj.boxButton.setEnabled(false);
            }
        }
    }

    public void openEmptyBoxAround(int row,int column)
    {
        for(int i=(row-1);i<=(row+1);i++)
        {
            if(i<0 || i==game.getBoxlist().length)
                continue;

            for(int k=(column-1);k<=(column+1);k++)
            {
                if(k<0 || k==game.getBoxlist()[0].length)
                    continue;

                if(!(game.getBoxlist()[i][k].getisItOpen()))
                {
                    setOpenBoxIcon(game.getBoxlist()[i][k]);
                    game.getBoxlist()[i][k].setisItOpen(true);

                    if(game.checkTheBoxAround(i,k)==0)
                    {
                        openEmptyBoxAround(i, k);
                    }
                }

            }

        }
    }

    public void setOpenBoxIcon(Boxes obj)
    {
        obj.setisItOpen(true); 
        game.setOpenedBoxCount(game.getOpenedBoxCount()+1);

        switch (game.checkTheBoxAround(obj.getrowNum(), obj.getcolumnNum()))
        {
            case 0 : obj.clearButtonIcon(); obj.getBoxButton().setIcon(emptyBoxIcon); break;
            case 1 : obj.clearButtonIcon(); obj.getBoxButton().setIcon(box1Icon); break;
            case 2 : obj.clearButtonIcon(); obj.getBoxButton().setIcon(box2Icon); break;
            case 3 : obj.clearButtonIcon(); obj.getBoxButton().setIcon(box3Icon); break;
            case 4 : obj.clearButtonIcon(); obj.getBoxButton().setIcon(box4Icon); break;
            case 5 : obj.clearButtonIcon(); obj.getBoxButton().setIcon(box5Icon); break;
            case 6 : obj.clearButtonIcon(); obj.getBoxButton().setIcon(box6Icon); break;
            case 7 : obj.clearButtonIcon(); obj.getBoxButton().setIcon(box7Icon); break;
            case 8 : obj.clearButtonIcon(); obj.getBoxButton().setIcon(box8Icon); break;
        }
    }

    public void toggleFlag(Boxes obj)
    {   
        if(!(obj.isItOpen))
        {
            if(!(obj.isItFlagged))
            {
                if(game.getFlagCount()!=0)
                {
                    updateFlagCountText('-');
                    obj.isItFlagged=true;
                    if(obj.getBoxButton().getIcon().equals(closeBoxIcon))
                    {
                        obj.clearButtonIcon();
                        obj.getBoxButton().setIcon(lightFlaggedBoxIcon);
                    }
                    else
                    {
                        obj.clearButtonIcon();
                        obj.getBoxButton().setIcon(darkFlaggedBoxIcon);
                    }
                }
            }
            else
            {
                updateFlagCountText('+');
                obj.isItFlagged=false;
                if(obj.getBoxButton().getIcon().equals(lightFlaggedBoxIcon))
                {
                    obj.clearButtonIcon();
                    obj.getBoxButton().setIcon(closeBoxIcon);
                }
                else if(obj.getBoxButton().getIcon().equals(darkFlaggedBoxIcon))
                {
                    obj.clearButtonIcon();
                    obj.getBoxButton().setIcon(closeBoxIcon2);
                }
            }
        }
    }

    public boolean isItWin()
    {
        if(game.getOpenedBoxCount() == (game.getRow()*game.getColumn())-game.getMineCount())
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void displayFlagCount()
    {
        flagp = new JPanel();
        flaglb =  new JLabel("FLAG: "+game.getFlagCount());
        flaglb.setFont(normalFont);
        flaglb.setForeground(Color.white);
        flaglb.setSize(flaglb.getPreferredSize().width,flaglb.getPreferredSize().height);
        flagp.add(flaglb);
        flagp.setBounds(gamePanel.getX()-(flaglb.getWidth()+10),gamePanel.getY(),flaglb.getWidth(),flaglb.getHeight());
        flagp.setBackground(getPanelColor());
        mPanel.add(flagp);
    }

    public void updateFlagCountText(char c)
    {
        if(c=='+')
        {
            game.setFlagCount(game.getFlagCount()+1);
            flaglb.setText("FLAG: "+game.getFlagCount());
            flagp.repaint();
        }
        else if(c=='-')
        {
            game.setFlagCount(game.getFlagCount()-1);
            flaglb.setText("FLAG: "+game.getFlagCount());
            flagp.repaint();
        }
    }

    public void displayAndStartGameTimer()
    {
        timerp = new JPanel();
        timerlb = new JLabel("TIME:   ");
        timerlb.setFont(normalFont);
        timerlb.setForeground(Color.white);
        timerlb.setSize(timerlb.getPreferredSize().width,timerlb.getPreferredSize().height);
        timerp.add(timerlb);
        timerp.setBounds(gamePanel.getX()-(timerlb.getWidth()+20),flagp.getY()+timerlb.getHeight(),timerlb.getWidth()+15,timerlb.getHeight());
        timerp.setBackground(getPanelColor());
        mPanel.add(timerp);
        gameTimer = new GameTimer(timerlb); gameTimer.startTimer();
    }


    public ActionListener closeBoxButtonListener(int row, int column)
    {
        return e ->
        {
            if(!(game.isItMine(row, column)) && game.checkTheBoxAround(row, column)==0 && !(game.getBoxlist()[row][column].isItOpen))
            {
                openEmptyBoxAround(row, column);
                if(isItWin())
                    gameWinProccess();
            }

            if(!(game.isItMine(row, column)) && game.checkTheBoxAround(row, column)!=0 && !(game.getBoxlist()[row][column].isItOpen))
            {
                setOpenBoxIcon(game.getBoxlist()[row][column]);
                if(isItWin())
                    gameWinProccess();
            }

            if(game.isItMine(row,column))
            {
                gameOverProccess();
            }
                
        };
        
    }
    
    public MouseListener rightClickListener(int row,int column)
    {
        return new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e)
            {
                if(e.getButton()==MouseEvent.BUTTON3)
                {
                    toggleFlag(game.getBoxlist()[row][column]);
                }
            }
        };
    }

    public void actionPerformed(ActionEvent clickedButton)
    {
        if(clickedButton.getSource()==StartButton)
        {
            StartButtonPanel.setVisible(false);
            CreateChoiceButtons();
        }

        else if(clickedButton.getSource()==PlayButton)
        {
            ChoiceButtonPanel.setVisible(false);
            CreateGameDifficultySelectionButtons();
        }

        else if(clickedButton.getSource()==BestScoreButton)
        {
            System.out.println("Best Scores Button Performed");
        }

        else if(clickedButton.getSource()==ExitButton)
        {
            System.out.println("Exit Button Performed");
            System.exit(0);
        }

        else if(clickedButton.getSource()==HardGameButton)
        {
            tittlePanel.setVisible(false);
            GameDifficultyButtonPanel.setVisible(false);
            CreateHardGame();
            displayFlagCount();
            displayAndStartGameTimer();
        }

        else if(clickedButton.getSource()==MediumGameButton)
        {
            tittlePanel.setVisible(false);
            GameDifficultyButtonPanel.setVisible(false);
            CreateMediumGame();
            displayFlagCount();
            displayAndStartGameTimer();
        }

        else if(clickedButton.getSource()==EasyGameButton)
        {
            tittlePanel.setVisible(false);
            GameDifficultyButtonPanel.setVisible(false);
            CreateEasyGame();
            displayFlagCount();
            displayAndStartGameTimer();
        }

        else if(clickedButton.getSource()==BackButton)
        {
            GameDifficultyButtonPanel.setVisible(false);
            ChoiceButtonPanel.setVisible(true);
        }

        else if(clickedButton.getSource()==finishGameButton)
        {
            gamePanel.setVisible(false);
            finishGameButton.setVisible(false);
            remove(finishGameButton);

            if(p!=null)
            {   
                p.setVisible(false);
                remove(lb);
                remove(p);
            }

            flagp.setVisible(false);
            remove(flagp);
            remove(flaglb);

            timerp.setVisible(false);
            remove(timerp);
            remove(timerlb);
            if(gameTimer != null)
            {
                gameTimer.stopTimer();
                gameTimer = null;
            }

            game.clearTheList();
            game=null;

            GameDifficultyButtonPanel.setVisible(true);
            tittlePanel.setVisible(true);
            mPanel.repaint();
        }

    }


    public Color getButtonBackgroundColor()
    {
        return Color.black;
    }

    public Color getButtonForegroundColor()
    {
        return Color.white;
    }

    public Color getPanelColor()
    {
        return Color.gray;
    }

}
