package minesweeper;

import javax.swing.JButton;

public abstract class Boxes{

    protected JButton boxButton;
    protected int rowNum;
    protected int columnNum;
    protected boolean isItOpen;
    protected boolean isItFlagged;
    
    Boxes(int rowNum, int columnNum,JButton boxButton)
    {
        this.rowNum=rowNum;
        this.columnNum=columnNum;
        this.boxButton=boxButton;
        isItOpen=false;
        isItFlagged=false;
    }

    public JButton getBoxButton() {
        return boxButton;
    }
    public void setBoxButton(JButton boxButton) {
        this.boxButton = boxButton;
    }

    public int getcolumnNum() {
        return columnNum;
    }
    public void setcolumnNum(int columnNum) {
        this.columnNum = columnNum;
    }

    public int getrowNum() {
        return rowNum;
    }
    public void setrowNum(int rowNum) {
        this.rowNum = rowNum;
    }

    public boolean getisItOpen()
    {
        return isItOpen;
    }
    public void setisItOpen(boolean b)
    {
        isItOpen=b;
    }

    public void clearButtonIcon()
    {
        boxButton.setIcon(null);
    }

    public void clearButtonComponents()
    {
        boxButton.removeAll();
    }

}
