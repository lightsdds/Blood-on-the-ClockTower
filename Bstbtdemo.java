package BSTBT;
import javax.swing.*;
import javax.swing.event.MouseInputAdapter;

import java.awt.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.event.*;
import java.awt.image.BufferedImage;
public class Bstbtdemo {
    private JFrame frameFirst=new JFrame("血染钟楼");
    private JPanel singleMultiplayerExit=new JPanel();//放置单机多人退出三个按钮
    private JButton single=new JButton("单机");
    private JButton multiplayer=new JButton("多人");
    private JButton exit=new JButton(new AbstractAction("退出") {
        public void actionPerformed(ActionEvent e){
            System.exit(0);
        }
    });
    private JMenuBar startMenuBar=new JMenuBar();//下面是点击菜单显示制作人员名单
    private JMenu teamMembers=new JMenu("制作人员");
    private JDialog memberName=new JDialog(frameFirst,"制作人员");
    private JScrollPane memberScrollPane=new JScrollPane();
    private JTextArea names=new JTextArea(6,18);
    private JDialog frameMagicCodex=new JDialog(frameFirst,"魔典");
    private JMenuBar menuRules=new JMenuBar();
    private JMenu rules=new JMenu("游戏规则");
    private JDialog rulesShowing=new JDialog();//展示规则
    //private JScrollPane ruleScrollPane=new JScrollPane();
    //private JTextArea ruleTextArea=new JTextArea(10,25);
    private JButton players=new JButton("待选");
    private JPopupMenu characters=new JPopupMenu();
    private JPopupMenu ability=new JPopupMenu();
    private JPopupMenu state=new JPopupMenu();
    private JPanel game=new JPanel();//玩家区域
    private JPanel rnt=new JPanel();//放置时间按钮返回按钮和提名投票按钮
    private JButton returning=new JButton("返回");
    private JButton nominationVoting=new JButton("提名投票");
    private JButton time=new JButton("白天");
    private JDialog nomination=new JDialog(frameMagicCodex,"提名");
    private JPanel nominate=new JPanel();
    private JPanel nominationOverReturning=new JPanel();//放置结束提名和返回按钮
    private JDialog voting=new JDialog(nomination,"投票");
    private JPanel vote=new JPanel();
    private JButton votingOver=new JButton("投票结束");

    
    
    


    




    public void init(){
        frameFirst.setJMenuBar(startMenuBar);
        startMenuBar.add(teamMembers);
        teamMembers.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e){
                boolean flag = e.isPopupTrigger();
                if(!flag){
                    memberName.setVisible(true);
                }
            }
        });
        names.append("队长：黄启明\n队员：苏琪杰(图形化) 刘宇辰(后端) 陈博翰(后端)");
        memberScrollPane.add(names);
        memberName.add(memberScrollPane);
        singleMultiplayerExit.setLayout(new BoxLayout(singleMultiplayerExit,BoxLayout.Y_AXIS));
        singleMultiplayerExit.add(single);
        singleMultiplayerExit.add(multiplayer);
        singleMultiplayerExit.add(exit);
        single.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                Boolean flag= e.isPopupTrigger();
                if(!flag){
                    frameMagicCodex.setVisible(true);                
                }
            }
        });
        frameMagicCodex.setJMenuBar(menuRules);
        menuRules.add(rules);
        //ruleScrollPane.add(ruleTextArea);
        JFileChooser gamerule=new JFileChooser("BSTBT\\游戏简介.pdf");
        rules.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                Boolean flag= e.isPopupTrigger();
                if(!flag){
                      gamerule.showOpenDialog(frameMagicCodex);              
                }
            }
        });
        
        rules.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                Boolean flag= e.isPopupTrigger();
                if(!flag){
                    rulesShowing.setVisible(true);                
                }
            }
        });
        frameFirst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
        new Bstbtdemo().init();
    }
}
