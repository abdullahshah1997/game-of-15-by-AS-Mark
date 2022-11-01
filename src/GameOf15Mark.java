import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class GameOf15Mark extends JFrame implements ActionListener {
    JPanel gamePanel = new JPanel();
    JPanel resetPanel = new JPanel();
    JButton new_game_b = new JButton("Start New Game");
    //JButton emptybutton=new JButton("");
    ArrayList<JButton> buttons_list = new ArrayList<>();
    //JButton[] buttons = new JButton[16];

    public JButton placeholder(JButton emptybutton) {
        return emptybutton;
    }

    public GameOf15Mark() {
        setLayout(new BorderLayout());
        add(gamePanel, "Center");
        add(resetPanel, "North");
        resetPanel.add(new_game_b);
        //gamePanel.add(emptybutton);
        gamePanel.setLayout(new GridLayout(4, 4));
        //String nr = "";
        for (int i = 0; i < 16; i++) {
            buttons_list.add(new JButton());
            if (i != 15 /*buttons.length - 1*/) {
                buttons_list.get(i).setText(Integer.toString(i + 1));
            }
            //buttons[i].addActionListener(this);

            gamePanel.add(buttons_list.get(i));
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500, 500);
        new_game_b.addActionListener(this);
        buttons_list.get(15).setText("");
        for (JButton buttons : buttons_list) {
            buttons.addActionListener(this);
        }
        //Collections.addAll(buttons_list, buttons);


    }
    /* public int emptytile_index () {
         int indxnr = 0;
         for (int i = 0; i < buttons_list.size(); i++) {
             buttons_list.get(i).getText();
             if (buttons_list.get(i).getText().trim().equalsIgnoreCase("")) {
                 indxnr = i;
             }
         }
         return indxnr;
     }*/
    @Override
    public void actionPerformed(ActionEvent e) {
        //int indxnr=0;

        if (e.getSource() == new_game_b) {
            Collections.shuffle(/*Arrays.asList(buttons)*/buttons_list);
            for (JButton button : buttons_list/*buttons*/) {
                gamePanel.add(button);
            }
            gamePanel.revalidate();
        }

        if (e.getSource() != new_game_b ||
                e.getSource() != buttons_list.get(emptytile_index())) {
            int choiceindex=0;

            if (e.getSource()==buttons_list.get(emptytile_index()-1)
                    ||e.getSource()==buttons_list.get(emptytile_index()+1)
                    ||e.getSource()==buttons_list.get(emptytile_index()-4)
                    ||e.getSource()==buttons_list.get(emptytile_index()+4)){
                String tilenr_str=placeholder((JButton) e.getSource()).getText();
                for (JButton b : buttons_list) {

                    if (b.getText().trim().equalsIgnoreCase(tilenr_str)){
                        break;
                    }
                    choiceindex++;
                }

                Collections.swap(buttons_list,choiceindex,emptytile_index());
                //choiceindex++;
                for (JButton button : buttons_list/*buttons*/) {
                    gamePanel.add(button);
                }
                gamePanel.revalidate();
            }

        }

    }
    /*else if (e.getSource()!=buttons[16]){
        Collections.swap(Arrays.asList(buttons),e.hashCode(),15);
        for (JButton button : buttons) {
            gamePanel.add(button);
        }
        gamePanel.revalidate();
    }*/

    public int emptytile_index () {
        int indxnr = 0;
        for (int i = 0; i < buttons_list.size(); i++) {
            //buttons_list.get(i).getText();
            if (buttons_list.get(i).getText().trim().equalsIgnoreCase("")) {
                indxnr = i;
            }

        }
        return indxnr;
    }
}