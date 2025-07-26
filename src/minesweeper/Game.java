package minesweeper;

import java.util.Random;

public class Game {

    private Boxes[][] boxlist;
    private Random random= new Random();
    private MineBoxes mineBox;
    private NonMineBoxes nonMineBox;
    private int row=0;
    private int column=0;
    private int mineCount=0;
    private int openedBoxCount=0;
    private int flagCount=0;


    public void setBoxlist(Boxes[][] boxlist) {
        this.boxlist = boxlist;
    }
    public Boxes[][] getBoxlist() {
        return boxlist;
    }

    public MineBoxes getMineBox() {
        return mineBox;
    }
    public void setMineBox(MineBoxes mineBox) {
        this.mineBox = mineBox;
    }

    public NonMineBoxes getNonMineBox() {
        return nonMineBox;
    }
    public void setNonMineBox(NonMineBoxes nonMineBox) {
        this.nonMineBox = nonMineBox;
    }

    public int getRow() {
        return row;
    }
    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }
    public void setColumn(int column) {
        this.column = column;
    }

    public int getMineCount() {
        return mineCount;
    }
    public void setMineCount(int mineCount) {
        this.mineCount = mineCount;
    }

    public int getOpenedBoxCount() {
        return openedBoxCount;
    }
    public void setOpenedBoxCount(int openedBoxCount) {
        this.openedBoxCount = openedBoxCount;
    }

    public int getFlagCount() {
        return flagCount;
    }
    public void setFlagCount(int flagCount) {
        this.flagCount = flagCount;
    }


    public void createEasyGame()
    {
        mineCount=7;
        flagCount=mineCount;
        row=8;
        column=7;
        boxlist = new Boxes[row][column];
        fillRandom(boxlist, mineCount);
    }

    public void createMediumGame()
    {
        mineCount=13;
        flagCount=mineCount;
        row=10;
        column=8;
        boxlist = new Boxes[row][column];
        fillRandom(boxlist,mineCount);
    }

    public void createHardGame()
    {
        mineCount=23;
        flagCount=mineCount;
        row = 13;
        column = 11;
        boxlist= new Boxes[row][column];
        fillRandom(boxlist, mineCount);
    }

    public void fillRandom(Boxes[][] boxList,int mineNum)
    {
        for(int i=0;i<mineNum;i++)
        {
            int c = random.nextInt((boxList.length)*(boxlist[0].length));
            int row=c/(boxlist[0].length);
            int column=c%(boxList[0].length);
            if(boxlist[row][column]==null)
            {
                mineBox = new MineBoxes(row, column,null);
                boxlist[row][column]= mineBox;
            }
            else
                i--;
        }

        for(int i=0;i<boxlist.length;i++)
        {
            for(int k=0;k<boxList[0].length;k++)
            {
                if(boxlist[i][k]==null)
                {
                    nonMineBox= new NonMineBoxes(i, k,null);
                    boxlist[i][k]=nonMineBox;
                }
            }
        }
    }

    public int checkTheBoxAround(int row,int column)
    {
        int numofMine=0;
        for(int i=(row-1);i<=(row+1);i++)
        {
            if(i<0 || i==boxlist.length)
                continue;
            else
            {
                for(int k=(column-1);k<=(column+1);k++)
                {
                    if(k<0 || k==boxlist[0].length)
                        continue;
                    else
                    {
                        if(boxlist[i][k] instanceof MineBoxes)
                            numofMine++;
                    }
                }
            }
        }
        return numofMine;
    }

    public boolean isItMine(int row,int column)
    {
        if(boxlist[row][column] instanceof MineBoxes)
            return true;
        else
            return false;
    }

    public void clearTheList()
    {   
        for(int i=0;i<boxlist.length;i++)
        {
            for(int k=0;k<boxlist[0].length;k++)
            {
                boxlist[i][k].boxButton.removeAll();
                boxlist[i][k]=null;
            }
        }
        boxlist=null;
    }


}
