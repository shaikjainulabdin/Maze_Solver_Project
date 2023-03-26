package maze_solver;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;


public class Maze_grid extends JFrame
{
    private int[][] maze = {
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
            {1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1},
            {1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 0, 1},
            {1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1},
            {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9, 1},
            {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}
    };

    public List<Integer> path = new ArrayList<>();
    JButton button;


    public Maze_grid() {
        button = new JButton("start");
        button.setBounds(250,400,100,30);
        button.setBackground(Color.CYAN);
        button.setBorderPainted(false);

        this.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DepthFirst_Search.searchPath(maze,1,1,path);
                repaint();
            }
        });

        setTitle("Maze Solver");
        setSize(640, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

    }

    @Override
    public void paint(Graphics g) {
        g.translate(100,100);
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                Color color;
                switch (maze[i][j]) {
                    case 1:
                        color = Color.BLACK;
                        break;
                    case 9:
                        color = Color.RED;
                        break;
                    default:
                        color = Color.WHITE;
                        break;
                }
                g.setColor(color);
                g.fillRect(30*j,30*i,30,30);
                g.setColor(color.RED);
                g.drawRect(30*j,30*i,30,30);
            }
        }
        for(int i=0; i<path.size(); i+=2){
            int xCordinate = path.get(i);
            int yCordinate = path.get(i+1);

            g.setColor(Color.GREEN);
            g.fillRect(30*xCordinate,30*yCordinate,20,30);
        }
    }
    public static void main(String[] args)
    {
       Maze_grid view= new Maze_grid();
       view.setVisible(true);
    }
}
