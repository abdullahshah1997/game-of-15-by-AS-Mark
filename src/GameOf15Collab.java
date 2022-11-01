import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

public class GameOf15Collab extends JFrame implements ActionListener {

    JPanel gamePanel = new JPanel();
    JPanel newGamePanel = new JPanel();
    JButton newGameButton = new JButton("Start new game");
    ArrayList<JButton> buttonList = new ArrayList<JButton>();

    public JButton placeholder(JButton emptybutton) {
        return emptybutton;
    }
    public GameOf15Collab(){
        setLayout(new BorderLayout());
        add(gamePanel,BorderLayout.CENTER);
        add(newGamePanel,BorderLayout.NORTH);
        newGamePanel.add(newGameButton);
        gamePanel.setLayout(new GridLayout(4,4));
        for(int i = 0;i<15;i++){
            buttonList.add(new JButton(String.valueOf(i+1)));
            }
        buttonList.add(new JButton());
        Collections.shuffle(buttonList);

        newGameButton.addActionListener(this);

        for(JButton button:buttonList){
            button.addActionListener(this);
            gamePanel.add(button);
        }

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setSize(500,500);




    }

    public int emptytileIndex () {
        int index = 0;
        for (int i = 0; i < buttonList.size(); i++) {
            if (buttonList.get(i).getText().trim().isBlank()) {
                index = i;
            }

        }
        return index;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int currentTileIndex = 0;
        JButton pushedButton = (JButton) e.getSource();
        for(int i =0;i<buttonList.size();i++){
            if(pushedButton.getText().equals(buttonList.get(i).getText()))
                currentTileIndex = i;
        }
        if(e.getSource()==newGameButton){
            Collections.shuffle(buttonList);
            for(JButton button:buttonList){
                gamePanel.add(button);

            }
            gamePanel.revalidate();
        }

        if(e.getSource()!=newGameButton&&e.getSource()!=buttonList.get(emptytileIndex())){
            int choiceindex=0;
            if(emptytileIndex()==5||emptytileIndex()==6||emptytileIndex()==9||emptytileIndex()==10){
                if(e.getSource()==buttonList.get(emptytileIndex()-1)
                        ||e.getSource()==buttonList.get(emptytileIndex()+1)
                        ||e.getSource()==buttonList.get(emptytileIndex()-4)
                        ||e.getSource()==buttonList.get(emptytileIndex()+4)){
                    Collections.swap(buttonList,currentTileIndex,emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }
            }
            else if(emptytileIndex()==0){
                if(e.getSource()==buttonList.get(1)||e.getSource()==buttonList.get(4)) {
                    Collections.swap(buttonList, currentTileIndex, emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }

            }
            else if(emptytileIndex()==1||emptytileIndex()==2){
                if(e.getSource()==buttonList.get(emptytileIndex()-1)||e.getSource()==buttonList.get(emptytileIndex()+1)
                        ||e.getSource()==buttonList.get(emptytileIndex()+4)){
                    Collections.swap(buttonList, currentTileIndex, emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }

            }

            else if(emptytileIndex()==3){
                if(e.getSource()==buttonList.get(2)||e.getSource()==buttonList.get(7)){
                    Collections.swap(buttonList, currentTileIndex, emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }

            }

            else if(emptytileIndex()==4||emptytileIndex()==8){
                if(e.getSource()==buttonList.get(emptytileIndex()-4)||e.getSource()==buttonList.get(emptytileIndex()+4)
                ||e.getSource()==buttonList.get(emptytileIndex()+1)){
                    Collections.swap(buttonList, currentTileIndex, emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }

            }

            else if(emptytileIndex()==7||emptytileIndex()==11){
                if(e.getSource()==buttonList.get(emptytileIndex()-4)||e.getSource()==buttonList.get(emptytileIndex()+4)
                        ||e.getSource()==buttonList.get(emptytileIndex()-1)){
                    Collections.swap(buttonList, currentTileIndex, emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }

            }

            else if(emptytileIndex()==12){
                if(e.getSource()==buttonList.get(emptytileIndex()-4)||e.getSource()==buttonList.get(emptytileIndex()+1)){
                    Collections.swap(buttonList, currentTileIndex, emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }

            }

            else if(emptytileIndex()==13||emptytileIndex()==14){
                if(e.getSource()==buttonList.get(emptytileIndex()-4)||e.getSource()==buttonList.get(emptytileIndex()+1)
                ||e.getSource()==buttonList.get(emptytileIndex()-1)){
                    Collections.swap(buttonList, currentTileIndex, emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }

            }

            else if(emptytileIndex()==15){
                if(e.getSource()==buttonList.get(emptytileIndex()-4)||e.getSource()==buttonList.get(emptytileIndex()-1)){
                    Collections.swap(buttonList, currentTileIndex, emptytileIndex());
                    for (JButton button : buttonList) {
                        gamePanel.add(button);
                    }
                    gamePanel.revalidate();
                }

            }

        }
    }


}


