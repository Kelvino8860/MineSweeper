import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.*;
import java.awt.Color;

public class MineSweeper extends JFrame implements MouseListener{

    int row = 4;
    int col = 5;
    int selectRow = 0;
    int selectCol = 0;
    JPanel[][] panels = new JPanel[row][col];
    JLabel[][] labels = new JLabel[row][col];
    Container con = getContentPane();

    public MineSweeper(){

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,5,2,2));
        setBackground(Color.CYAN);

        //Initialize panels and labels
        //Make them mouseListeners
        initializePanels(panels,labels);

        //Set bombs on the panels randomly
        setBombs(panels,labels);
    }

    @Override
    public void mouseClicked(MouseEvent e){

        Object source = e.getComponent();
        JPanel selectedPanel = (JPanel)source;

        //Get index of the selected panel
        for(int row = 0; row < panels.length; ++row)
        {
            for(int col = 0; col < panels[row].length; ++col)
            {
                if(selectedPanel == panels[row][col])
                {
                     selectRow = row;
                     selectCol = col;
                     break;
                }
            }
        }

        if((labels[selectRow][selectCol].getText()).equals("Bomb"))
        {
            endGame(panels,labels);
        }
        else
        {
            displayNumOfAdjacentBombs(panels,labels);
        }
    }
    @Override
    public void mouseEntered(MouseEvent e){

    }
    @Override
    public void mouseExited(MouseEvent e){

    }
    @Override
    public void mousePressed(MouseEvent e){

    }
    @Override
    public void mouseReleased(MouseEvent e){

    }

    public void endGame(JPanel[][] panels, JLabel[][] labels){
      
        //3 checks
        //Panel at [0][0]
        int countOO = 0;
       if((labels[0][1].getText()).equals("Bomb"))
       {
         countOO++;
       }
       if((labels[1][1].getText()).equals("Bomb"))
       {
           countOO++;
       }
       if((labels[1][0].getText()).equals("Bomb"))
       {
          countOO++;
       }
       if(!(labels[0][0].getText()).equals("Bomb"))
         labels[0][0].setText(String.valueOf(countOO));

       //Panel at [0][4]
       int countOW = 0;
       if((labels[0][3].getText()).equals("Bomb"))
       {
         countOW++;
       }
       if((labels[1][3].getText()).equals("Bomb"))
       {
           countOW++;
       }
       if((labels[1][4].getText()).equals("Bomb"))
       {
          countOW++;
       }
       if(!(labels[0][4].getText()).equals("Bomb"))
         labels[0][4].setText(String.valueOf(countOW));

       //Panel at [3][0]
       int countOE = 0;
       if((labels[2][0].getText()).equals("Bomb"))
       {
         countOE++;
       }
       if((labels[2][1].getText()).equals("Bomb"))
       {
           countOE++;
       }
       if((labels[3][1].getText()).equals("Bomb"))
       {
          countOE++;
       }
       if(!(labels[3][0].getText()).equals("Bomb"))
         labels[3][0].setText(String.valueOf(countOE));

       //Panel at [3][4]
       int countOR = 0;
       if((labels[2][3].getText()).equals("Bomb"))
       {
         countOR++;
       }
       if((labels[2][4].getText()).equals("Bomb"))
       {
           countOR++;
       }
       if((labels[3][3].getText()).equals("Bomb"))
       {
          countOR++;
       }
       if(!(labels[3][4].getText()).equals("Bomb"))
         labels[3][4].setText(String.valueOf(countOR));

       //5 checks
       //Panel at [0][1]
       int countO5 = 0;
       if((labels[0][2].getText()).equals("Bomb"))
       {
          countO5++;
       }
       if((labels[1][2].getText()).equals("Bomb"))
       {
          countO5++;
       } 
       if((labels[1][1].getText()).equals("Bomb"))
       {
          countO5++;
       }
       if((labels[1][0].getText()).equals("Bomb"))
       {
          countO5++;
       }
       if((labels[0][0].getText()).equals("Bomb"))
       {
          countO5++;
       }
       if(!(labels[0][1].getText()).equals("Bomb"))
         labels[0][1].setText(String.valueOf(countO5));

       //Panel at [0][2]
       int countO2 = 0;
       if((labels[0][3].getText()).equals("Bomb"))
       {
          countO2++;
       }
       if((labels[1][3].getText()).equals("Bomb"))
       {
          countO2++;
       } 
       if((labels[1][2].getText()).equals("Bomb"))
       {
          countO2++;
       }
       if((labels[1][1].getText()).equals("Bomb"))
       {
          countO2++;
       }
       if((labels[0][1].getText()).equals("Bomb"))
       {
          countO2++;
       }
       if(!(labels[0][2].getText()).equals("Bomb"))
         labels[0][2].setText(String.valueOf(countO2));

       //Panel at [0][3]
       int countO3 = 0;
       if((labels[0][4].getText()).equals("Bomb"))
       {
          countO3++;
       }
       if((labels[1][4].getText()).equals("Bomb"))
       {
          countO3++;
       } 
       if((labels[1][3].getText()).equals("Bomb"))
       {
          countO3++;
       }
       if((labels[1][2].getText()).equals("Bomb"))
       {
          countO3++;
       }
       if((labels[0][2].getText()).equals("Bomb"))
       {
          countO3++;
       }
       if(!(labels[0][3].getText()).equals("Bomb"))
         labels[0][3].setText(String.valueOf(countO3));

       //Panel at [1][0]
       int countO4 = 0;
       if((labels[1][1].getText()).equals("Bomb"))
       {
          countO4++;
       }
       if((labels[2][1].getText()).equals("Bomb"))
       {
          countO4++;
       } 
       if((labels[2][0].getText()).equals("Bomb"))
       {
          countO4++;
       }
       if((labels[0][1].getText()).equals("Bomb"))
       {
          countO4++;
       }
       if((labels[0][0].getText()).equals("Bomb"))
       {
          countO4++;
       }
       if(!(labels[1][0].getText()).equals("Bomb"))
         labels[1][0].setText(String.valueOf(countO4));

       //Panel at [2][0]
       int countO6 = 0;
       if((labels[1][0].getText()).equals("Bomb"))
       {
          countO6++;
       }
       if((labels[3][0].getText()).equals("Bomb"))
       {
          countO6++;
       } 
       if((labels[1][1].getText()).equals("Bomb"))
       {
          countO6++;
       }
       if((labels[2][1].getText()).equals("Bomb"))
       {
          countO6++;
       }
       if((labels[3][1].getText()).equals("Bomb"))
       {
          countO6++;
       }
       if(!(labels[2][0].getText()).equals("Bomb"))
         labels[2][0].setText(String.valueOf(countO6));

       //Panel at [1][4]
       int countO7 = 0;
       if((labels[0][4].getText()).equals("Bomb"))
       {
          countO7++;
       }
       if((labels[2][4].getText()).equals("Bomb"))
       {
          countO7++;
       } 
       if((labels[2][3].getText()).equals("Bomb"))
       {
          countO7++;
       }
       if((labels[1][3].getText()).equals("Bomb"))
       {
          countO7++;
       }
       if((labels[0][3].getText()).equals("Bomb"))
       {
          countO7++;
       }
       if(!(labels[1][4].getText()).equals("Bomb"))
         labels[1][4].setText(String.valueOf(countO7));

       //Panel at [2][4]
       int countO8 = 0;
       if((labels[1][4].getText()).equals("Bomb"))
       {
          countO8++;
       }
       if((labels[3][4].getText()).equals("Bomb"))
       {
          countO8++;
       } 
       if((labels[3][3].getText()).equals("Bomb"))
       {
          countO8++;
       }
       if((labels[2][3].getText()).equals("Bomb"))
       {
          countO8++;
       }
       if((labels[1][3].getText()).equals("Bomb"))
       {
          countO8++;
       }
       if(!(labels[2][4].getText()).equals("Bomb"))
         labels[2][4].setText(String.valueOf(countO8));

      //Panel at [3][1]
      int countO1 = 0;
      if((labels[3][0].getText()).equals("Bomb"))
       {
          countO1++;
       }
       if((labels[2][0].getText()).equals("Bomb"))
       {
          countO1++;
       } 
       if((labels[2][1].getText()).equals("Bomb"))
       {
          countO1++;
       }
       if((labels[2][2].getText()).equals("Bomb"))
       {
          countO1++;
       }
       if((labels[3][2].getText()).equals("Bomb"))
       {
          countO1++;
       }
       if(!(labels[3][1].getText()).equals("Bomb"))
         labels[3][1].setText(String.valueOf(countO1));      
       
      //Panel at [3][2]
      int countO9 = 0;
      if((labels[3][1].getText()).equals("Bomb"))
       {
          countO9++;
       }
       if((labels[2][1].getText()).equals("Bomb"))
       {
          countO9++;
       } 
       if((labels[2][2].getText()).equals("Bomb"))
       {
          countO9++;
       }
       if((labels[2][3].getText()).equals("Bomb"))
       {
          countO9++;
       }
       if((labels[3][3].getText()).equals("Bomb"))
       {
          countO9++;
       }
       if(!(labels[3][2].getText()).equals("Bomb"))
         labels[3][2].setText(String.valueOf(countO9));

      //Panel at [3][3]
      int count10 = 0;
      if((labels[3][2].getText()).equals("Bomb"))
       {
          count10++;
       }
       if((labels[2][2].getText()).equals("Bomb"))
       {
          count10++;
       } 
       if((labels[2][3].getText()).equals("Bomb"))
       {
          count10++;
       }
       if((labels[2][4].getText()).equals("Bomb"))
       {
          count10++;
       }
       if((labels[3][4].getText()).equals("Bomb"))
       {
          count10++;
       }
       if(!(labels[3][3].getText()).equals("Bomb"))
         labels[3][3].setText(String.valueOf(count10));

      //8 checks
      //Panel at [1][1]
      int cout1 = 0;
      if(labels[0][0].getText().equals("Bomb"))
      {
         cout1++;
      }
      if(labels[0][1].getText().equals("Bomb"))
      {
         cout1++;
      }
      if(labels[0][2].getText().equals("Bomb"))
      {
         cout1++;
      }
      if(labels[1][0].getText().equals("Bomb"))
      {
         cout1++;
      }
      if(labels[1][2].getText().equals("Bomb"))
      {
         cout1++;
      }
      if(labels[2][0].getText().equals("Bomb"))
      {
         cout1++;
      }
      if(labels[2][1].getText().equals("Bomb"))
      {
         cout1++;
      }
      if(labels[2][2].getText().equals("Bomb"))
      {
         cout1++;
      }
      if(!(labels[1][1].getText()).equals("Bomb"))
         labels[1][1].setText(String.valueOf(cout1));

      //Panel at [1][2]
      int cout2 = 0;
      if(labels[0][1].getText().equals("Bomb"))
      {
         cout2++;
      }
      if(labels[0][2].getText().equals("Bomb"))
      {
         cout2++;
      }
      if(labels[0][3].getText().equals("Bomb"))
      {
         cout2++;
      }
      if(labels[1][1].getText().equals("Bomb"))
      {
         cout2++;
      }
      if(labels[1][3].getText().equals("Bomb"))
      {
         cout2++;
      }
      if(labels[2][1].getText().equals("Bomb"))
      {
         cout2++;
      }
      if(labels[2][2].getText().equals("Bomb"))
      {
         cout2++;
      }
      if(labels[2][3].getText().equals("Bomb"))
      {
         cout2++;
      }
      if(!(labels[1][2].getText()).equals("Bomb"))
         labels[1][2].setText(String.valueOf(cout2));

      //panel at [1][3]
      int cout3 = 0;
      if(labels[0][2].getText().equals("Bomb"))
      {
         cout3++;
      }
      if(labels[0][3].getText().equals("Bomb"))
      {
         cout3++;
      }
      if(labels[0][4].getText().equals("Bomb"))
      {
         cout3++;
      }
      if(labels[1][2].getText().equals("Bomb"))
      {
         cout3++;
      }
      if(labels[1][4].getText().equals("Bomb"))
      {
         cout3++;
      }
      if(labels[2][2].getText().equals("Bomb"))
      {
         cout3++;
      }
      if(labels[2][3].getText().equals("Bomb"))
      {
         cout3++;
      }
      if(labels[2][4].getText().equals("Bomb"))
      {
         cout3++;
      }
      if(!(labels[1][3].getText()).equals("Bomb"))
         labels[1][3].setText(String.valueOf(cout3));

      //Panel at [2][1]
      int cout4 = 0;
      if(labels[1][0].getText().equals("Bomb"))
      {
         cout4++;
      }
      if(labels[1][1].getText().equals("Bomb"))
      {
         cout4++;
      }
      if(labels[1][2].getText().equals("Bomb"))
      {
         cout4++;
      }
      if(labels[2][0].getText().equals("Bomb"))
      {
         cout4++;
      }
      if(labels[2][2].getText().equals("Bomb"))
      {
         cout4++;
      }
      if(labels[3][0].getText().equals("Bomb"))
      {
         cout4++;
      }
      if(labels[3][1].getText().equals("Bomb"))
      {
         cout4++;
      }
      if(labels[3][2].getText().equals("Bomb"))
      {
         cout4++;
      }
      if(!(labels[2][1].getText()).equals("Bomb"))
         labels[2][1].setText(String.valueOf(cout4));

      //Panel at [2][2]
      int cout5 = 0;
      if(labels[1][1].getText().equals("Bomb"))
      {
         cout5++;
      }
      if(labels[1][2].getText().equals("Bomb"))
      {
         cout5++;
      }
      if(labels[1][2].getText().equals("Bomb"))
      {
         cout5++;
      }
      if(labels[2][1].getText().equals("Bomb"))
      {
         cout5++;
      }
      if(labels[2][3].getText().equals("Bomb"))
      {
         cout5++;
      }
      if(labels[3][1].getText().equals("Bomb"))
      {
         cout5++;
      }
      if(labels[3][2].getText().equals("Bomb"))
      {
         cout5++;
      }
      if(labels[3][3].getText().equals("Bomb"))
      {
         cout5++;
      }
      if(!(labels[2][2].getText()).equals("Bomb"))
         labels[2][2].setText(String.valueOf(cout5));

      //Panel at [2][3]
      int cout6 = 0;
      if(labels[1][2].getText().equals("Bomb"))
      {
         cout6++;
      }
      if(labels[1][3].getText().equals("Bomb"))
      {
         cout6++;
      }
      if(labels[1][4].getText().equals("Bomb"))
      {
         cout6++;
      }
      if(labels[2][2].getText().equals("Bomb"))
      {
         cout6++;
      }
      if(labels[2][4].getText().equals("Bomb"))
      {
         cout6++;
      }
      if(labels[3][2].getText().equals("Bomb"))
      {
         cout6++;
      }
      if(labels[3][3].getText().equals("Bomb"))
      {
         cout6++;
      }
      if(labels[3][4].getText().equals("Bomb"))
      {
         cout6++;
      }
      if(!(labels[2][3].getText()).equals("Bomb"))
         labels[2][3].setText(String.valueOf(cout6));

      //Display all panels
      for(int i = 0; i < panels.length; ++i)
      {
          for(int j = 0; j < panels[i].length; ++j)
          {
              
              labels[i][j].setVisible(true);
          }
      }
    }

    public void displayNumOfAdjacentBombs(JPanel[][] panels, JLabel[][] labels){

       //3 checks
        //Panel at [0][0]
        int countOO = 0;
       if((labels[0][1].getText()).equals("Bomb"))
       {
         countOO++;
       }
       if((labels[1][1].getText()).equals("Bomb"))
       {
           countOO++;
       }
       if((labels[1][0].getText()).equals("Bomb"))
       {
          countOO++;
       }
       if(!(labels[0][0].getText()).equals("Bomb"))
         labels[0][0].setText(String.valueOf(countOO));

       //Panel at [0][4]
       int countOW = 0;
       if((labels[0][3].getText()).equals("Bomb"))
       {
         countOW++;
       }
       if((labels[1][3].getText()).equals("Bomb"))
       {
           countOW++;
       }
       if((labels[1][4].getText()).equals("Bomb"))
       {
          countOW++;
       }
       if(!(labels[0][4].getText()).equals("Bomb"))
         labels[0][4].setText(String.valueOf(countOW));

       //Panel at [3][0]
       int countOE = 0;
       if((labels[2][0].getText()).equals("Bomb"))
       {
         countOE++;
       }
       if((labels[2][1].getText()).equals("Bomb"))
       {
           countOE++;
       }
       if((labels[3][1].getText()).equals("Bomb"))
       {
          countOE++;
       }
       if(!(labels[3][0].getText()).equals("Bomb"))
         labels[3][0].setText(String.valueOf(countOE));

       //Panel at [3][4]
       int countOR = 0;
       if((labels[2][3].getText()).equals("Bomb"))
       {
         countOR++;
       }
       if((labels[2][4].getText()).equals("Bomb"))
       {
           countOR++;
       }
       if((labels[3][3].getText()).equals("Bomb"))
       {
          countOR++;
       }
       if(!(labels[3][4].getText()).equals("Bomb"))
         labels[3][4].setText(String.valueOf(countOR));

       //5 checks
       //Panel at [0][1]
       int countO5 = 0;
       if((labels[0][2].getText()).equals("Bomb"))
       {
          countO5++;
       }
       if((labels[1][2].getText()).equals("Bomb"))
       {
          countO5++;
       } 
       if((labels[1][1].getText()).equals("Bomb"))
       {
          countO5++;
       }
       if((labels[1][0].getText()).equals("Bomb"))
       {
          countO5++;
       }
       if((labels[0][0].getText()).equals("Bomb"))
       {
          countO5++;
       }
       if(!(labels[0][1].getText()).equals("Bomb"))
         labels[0][1].setText(String.valueOf(countO5));

       //Panel at [0][2]
       int countO2 = 0;
       if((labels[0][3].getText()).equals("Bomb"))
       {
          countO2++;
       }
       if((labels[1][3].getText()).equals("Bomb"))
       {
          countO2++;
       } 
       if((labels[1][2].getText()).equals("Bomb"))
       {
          countO2++;
       }
       if((labels[1][1].getText()).equals("Bomb"))
       {
          countO2++;
       }
       if((labels[0][1].getText()).equals("Bomb"))
       {
          countO2++;
       }
       if(!(labels[0][2].getText()).equals("Bomb"))
         labels[0][2].setText(String.valueOf(countO2));

       //Panel at [0][3]
       int countO3 = 0;
       if((labels[0][4].getText()).equals("Bomb"))
       {
          countO3++;
       }
       if((labels[1][4].getText()).equals("Bomb"))
       {
          countO3++;
       } 
       if((labels[1][3].getText()).equals("Bomb"))
       {
          countO3++;
       }
       if((labels[1][2].getText()).equals("Bomb"))
       {
          countO3++;
       }
       if((labels[0][2].getText()).equals("Bomb"))
       {
          countO3++;
       }
       if(!(labels[0][3].getText()).equals("Bomb"))
         labels[0][3].setText(String.valueOf(countO3));

       //Panel at [1][0]
       int countO4 = 0;
       if((labels[1][1].getText()).equals("Bomb"))
       {
          countO4++;
       }
       if((labels[2][1].getText()).equals("Bomb"))
       {
          countO4++;
       } 
       if((labels[2][0].getText()).equals("Bomb"))
       {
          countO4++;
       }
       if((labels[0][1].getText()).equals("Bomb"))
       {
          countO4++;
       }
       if((labels[0][0].getText()).equals("Bomb"))
       {
          countO4++;
       }
       if(!(labels[1][0].getText()).equals("Bomb"))
         labels[1][0].setText(String.valueOf(countO4));

       //Panel at [2][0]
       int countO6 = 0;
       if((labels[1][0].getText()).equals("Bomb"))
       {
          countO6++;
       }
       if((labels[3][0].getText()).equals("Bomb"))
       {
          countO6++;
       } 
       if((labels[1][1].getText()).equals("Bomb"))
       {
          countO6++;
       }
       if((labels[2][1].getText()).equals("Bomb"))
       {
          countO6++;
       }
       if((labels[3][1].getText()).equals("Bomb"))
       {
          countO6++;
       }
       if(!(labels[2][0].getText()).equals("Bomb"))
         labels[2][0].setText(String.valueOf(countO6));

       //Panel at [1][4]
       int countO7 = 0;
       if((labels[0][4].getText()).equals("Bomb"))
       {
          countO7++;
       }
       if((labels[2][4].getText()).equals("Bomb"))
       {
          countO7++;
       } 
       if((labels[2][3].getText()).equals("Bomb"))
       {
          countO7++;
       }
       if((labels[1][3].getText()).equals("Bomb"))
       {
          countO7++;
       }
       if((labels[0][3].getText()).equals("Bomb"))
       {
          countO7++;
       }
       if(!(labels[1][4].getText()).equals("Bomb"))
         labels[1][4].setText(String.valueOf(countO7));

       //Panel at [2][4]
       int countO8 = 0;
       if((labels[1][4].getText()).equals("Bomb"))
       {
          countO8++;
       }
       if((labels[3][4].getText()).equals("Bomb"))
       {
          countO8++;
       } 
       if((labels[3][3].getText()).equals("Bomb"))
       {
          countO8++;
       }
       if((labels[2][3].getText()).equals("Bomb"))
       {
          countO8++;
       }
       if((labels[1][3].getText()).equals("Bomb"))
       {
          countO8++;
       }
       if(!(labels[2][4].getText()).equals("Bomb"))
         labels[2][4].setText(String.valueOf(countO8));

      //Panel at [3][1]
      int countO1 = 0;
      if((labels[3][0].getText()).equals("Bomb"))
       {
          countO1++;
       }
       if((labels[2][0].getText()).equals("Bomb"))
       {
          countO1++;
       } 
       if((labels[2][1].getText()).equals("Bomb"))
       {
          countO1++;
       }
       if((labels[2][2].getText()).equals("Bomb"))
       {
          countO1++;
       }
       if((labels[3][2].getText()).equals("Bomb"))
       {
          countO1++;
       }
       if(!(labels[3][1].getText()).equals("Bomb"))
         labels[3][1].setText(String.valueOf(countO1));      
       
      //Panel at [3][2]
      int countO9 = 0;
      if((labels[3][1].getText()).equals("Bomb"))
       {
          countO9++;
       }
       if((labels[2][1].getText()).equals("Bomb"))
       {
          countO9++;
       } 
       if((labels[2][2].getText()).equals("Bomb"))
       {
          countO9++;
       }
       if((labels[2][3].getText()).equals("Bomb"))
       {
          countO9++;
       }
       if((labels[3][3].getText()).equals("Bomb"))
       {
          countO9++;
       }
       if(!(labels[3][2].getText()).equals("Bomb"))
         labels[3][2].setText(String.valueOf(countO9));

      //Panel at [3][3]
      int count10 = 0;
      if((labels[3][2].getText()).equals("Bomb"))
       {
          count10++;
       }
       if((labels[2][2].getText()).equals("Bomb"))
       {
          count10++;
       } 
       if((labels[2][3].getText()).equals("Bomb"))
       {
          count10++;
       }
       if((labels[2][4].getText()).equals("Bomb"))
       {
          count10++;
       }
       if((labels[3][4].getText()).equals("Bomb"))
       {
          count10++;
       }
       if(!(labels[3][3].getText()).equals("Bomb"))
         labels[3][3].setText(String.valueOf(count10));

      //8 checks
      //Panel at [1][1]
      int cout1 = 0;
      if(labels[0][0].getText().equals("Bomb"))
      {
         cout1++;
      }
      if(labels[0][1].getText().equals("Bomb"))
      {
         cout1++;
      }
      if(labels[0][2].getText().equals("Bomb"))
      {
         cout1++;
      }
      if(labels[1][0].getText().equals("Bomb"))
      {
         cout1++;
      }
      if(labels[1][2].getText().equals("Bomb"))
      {
         cout1++;
      }
      if(labels[2][0].getText().equals("Bomb"))
      {
         cout1++;
      }
      if(labels[2][1].getText().equals("Bomb"))
      {
         cout1++;
      }
      if(labels[2][2].getText().equals("Bomb"))
      {
         cout1++;
      }
      if(!(labels[1][1].getText()).equals("Bomb"))
         labels[1][1].setText(String.valueOf(cout1));

      //Panel at [1][2]
      int cout2 = 0;
      if(labels[0][1].getText().equals("Bomb"))
      {
         cout2++;
      }
      if(labels[0][2].getText().equals("Bomb"))
      {
         cout2++;
      }
      if(labels[0][3].getText().equals("Bomb"))
      {
         cout2++;
      }
      if(labels[1][1].getText().equals("Bomb"))
      {
         cout2++;
      }
      if(labels[1][3].getText().equals("Bomb"))
      {
         cout2++;
      }
      if(labels[2][1].getText().equals("Bomb"))
      {
         cout2++;
      }
      if(labels[2][2].getText().equals("Bomb"))
      {
         cout2++;
      }
      if(labels[2][3].getText().equals("Bomb"))
      {
         cout2++;
      }
      if(!(labels[1][2].getText()).equals("Bomb"))
         labels[1][2].setText(String.valueOf(cout2));

      //panel at [1][3]
      int cout3 = 0;
      if(labels[0][2].getText().equals("Bomb"))
      {
         cout3++;
      }
      if(labels[0][3].getText().equals("Bomb"))
      {
         cout3++;
      }
      if(labels[0][4].getText().equals("Bomb"))
      {
         cout3++;
      }
      if(labels[1][2].getText().equals("Bomb"))
      {
         cout3++;
      }
      if(labels[1][4].getText().equals("Bomb"))
      {
         cout3++;
      }
      if(labels[2][2].getText().equals("Bomb"))
      {
         cout3++;
      }
      if(labels[2][3].getText().equals("Bomb"))
      {
         cout3++;
      }
      if(labels[2][4].getText().equals("Bomb"))
      {
         cout3++;
      }
      if(!(labels[1][3].getText()).equals("Bomb"))
         labels[1][3].setText(String.valueOf(cout3));

      //Panel at [2][1]
      int cout4 = 0;
      if(labels[1][0].getText().equals("Bomb"))
      {
         cout4++;
      }
      if(labels[1][1].getText().equals("Bomb"))
      {
         cout4++;
      }
      if(labels[1][2].getText().equals("Bomb"))
      {
         cout4++;
      }
      if(labels[2][0].getText().equals("Bomb"))
      {
         cout4++;
      }
      if(labels[2][2].getText().equals("Bomb"))
      {
         cout4++;
      }
      if(labels[3][0].getText().equals("Bomb"))
      {
         cout4++;
      }
      if(labels[3][1].getText().equals("Bomb"))
      {
         cout4++;
      }
      if(labels[3][2].getText().equals("Bomb"))
      {
         cout4++;
      }
      if(!(labels[2][1].getText()).equals("Bomb"))
         labels[2][1].setText(String.valueOf(cout4));

      //Panel at [2][2]
      int cout5 = 0;
      if(labels[1][1].getText().equals("Bomb"))
      {
         cout5++;
      }
      if(labels[1][2].getText().equals("Bomb"))
      {
         cout5++;
      }
      if(labels[1][2].getText().equals("Bomb"))
      {
         cout5++;
      }
      if(labels[2][1].getText().equals("Bomb"))
      {
         cout5++;
      }
      if(labels[2][3].getText().equals("Bomb"))
      {
         cout5++;
      }
      if(labels[3][1].getText().equals("Bomb"))
      {
         cout5++;
      }
      if(labels[3][2].getText().equals("Bomb"))
      {
         cout5++;
      }
      if(labels[3][3].getText().equals("Bomb"))
      {
         cout5++;
      }
      if(!(labels[2][2].getText()).equals("Bomb"))
         labels[2][2].setText(String.valueOf(cout5));

      //Panel at [2][3]
      int cout6 = 0;
      if(labels[1][2].getText().equals("Bomb"))
      {
         cout6++;
      }
      if(labels[1][3].getText().equals("Bomb"))
      {
         cout6++;
      }
      if(labels[1][4].getText().equals("Bomb"))
      {
         cout6++;
      }
      if(labels[2][2].getText().equals("Bomb"))
      {
         cout6++;
      }
      if(labels[2][4].getText().equals("Bomb"))
      {
         cout6++;
      }
      if(labels[3][2].getText().equals("Bomb"))
      {
         cout6++;
      }
      if(labels[3][3].getText().equals("Bomb"))
      {
         cout6++;
      }
      if(labels[3][4].getText().equals("Bomb"))
      {
         cout6++;
      }
      if(!(labels[2][3].getText()).equals("Bomb"))
         labels[2][3].setText(String.valueOf(cout6));


           labels[selectRow][selectCol].setVisible(true);
    }

    public void setBombs(JPanel[][] panels, JLabel[][] labels){

        for(int i = 0; i < 4; ++i)
        {
            int k = (int)(Math.random()*4);
            int p = (int)(Math.random()*5);
            labels[k][p].setText("Bomb");
        }
    }

    public void initializePanels(JPanel[][] panels, JLabel[][] labels){

        //Initialize panels and add them to the frame
        //Initializes JLabels and adds them to the panels
        //Register panels as mouseListeners
        for(int i = 0; i < panels.length; ++i)
        {
            for(int j = 0; j < panels[i].length; ++j)
            {
                panels[i][j] = new JPanel();
                add(panels[i][j]);
                panels[i][j].setBackground(Color.BLUE);
                panels[i][j].addMouseListener(this);
                labels[i][j] = new JLabel("");
                panels[i][j].add(labels[i][j]);
                labels[i][j].setVisible(false);
            }
        }
    }
    public static void main(String[] args){

        MineSweeper frame = new MineSweeper();
        frame.setTitle("MineSweeper");
        frame.setBounds(300,300,350,350);
        frame.setVisible(true);
    }
}