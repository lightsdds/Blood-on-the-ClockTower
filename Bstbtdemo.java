package BSTBT;
import javax.swing.*;
import javax.swing.event.MenuDragMouseEvent;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.beans.Visibility;
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
    private JTextArea ruleTextArea=new JTextArea(10,25);
    private JButton player1=new JButton("待选");
    private JButton player2=new JButton("待选");
    private JButton player3=new JButton("待选");
    private JButton player4=new JButton("待选");
    private JButton player5=new JButton("待选");
    private JButton player6=new JButton("待选");
    private JButton player7=new JButton("待选");
    private JButton player8=new JButton("待选");
    private JButton player9=new JButton("待选");
    private JButton player10=new JButton("待选");
    private JButton player11=new JButton("待选");
    private JButton player12=new JButton("待选");
    private JButton[] players=new JButton[12];
    private JPopupMenu characters=new JPopupMenu();
    private JPopupMenu ability=new JPopupMenu();//技能
    private JPopupMenu state=new JPopupMenu();//状态
    private JCheckBox health=new JCheckBox("健康",true);
    private JCheckBox drunkenness=new JCheckBox("醉酒",false);
    private JCheckBox poisoning=new JCheckBox("中毒",false);
    private JCheckBox death=new JCheckBox("死亡",false);
    private JMenu villagers=new JMenu("村民");
    private JMenu outsiders=new JMenu("外来者");
    private JMenu pawns=new JMenu("爪牙");
    private JMenu demon=new JMenu("恶魔");
    private JMenuItem washerWoman=new JMenuItem("洗衣妇");
    private JMenuItem librarian=new JMenuItem("图书馆源");
    private JMenuItem monk=new JMenuItem("僧侣");
    private JMenuItem investigator=new JMenuItem("调查员");
    private JMenuItem ravenKeeper=new JMenuItem("守鸦人");
    private JMenuItem chef=new JMenuItem("厨师");
    private JMenuItem virgin=new JMenuItem("圣女");
    private JMenuItem empath=new JMenuItem("共情者");
    private JMenuItem slayer=new JMenuItem("杀手");
    private JMenuItem fortuneTeller=new JMenuItem("预言家");
    private JMenuItem soldier=new JMenuItem("士兵");
    private JMenuItem undertaker=new JMenuItem("送葬者");
    private JMenuItem mayor=new JMenuItem("镇长");
    private JMenuItem butler=new JMenuItem("管家");
    private JMenuItem recluse=new JMenuItem("隐士");
    private JMenuItem drunk=new JMenuItem("酒鬼");
    private JMenuItem saint=new JMenuItem("圣徒");
    private JMenuItem poisoner=new JMenuItem("毒师");
    private JMenuItem baron=new JMenuItem("男爵");
    private JMenuItem spy=new JMenuItem("间谍");
    private JMenuItem scarletWoman=new JMenuItem("荡妇");
    private JMenuItem imp=new JMenuItem("小恶魔");
    private JPanel game=new JPanel();//玩家区域
    private JLabel white=new JLabel();//用来填充空白
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
    private String cha="";//用来继承角色选择
    public void bindingCharacters(JButton but){//按钮绑定菜单,组装菜单
        but.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                boolean flag=e.isPopupTrigger();
                if(but.getText()=="待选"){
                    if(!flag){
                        characters.show(but,e.getX(),e.getY());
                        ActionListener listener = new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String actionCommand = e.getActionCommand();
                                cha=actionCommand;
                            }
                        };
                        washerWoman.addActionListener(listener);
                        librarian.addActionListener(listener);
                        monk.addActionListener(listener);
                        investigator.addActionListener(listener);
                        ravenKeeper.addActionListener(listener);
                        chef.addActionListener(listener);
                        virgin.addActionListener(listener);
                        empath.addActionListener(listener);
                        slayer.addActionListener(listener);
                        fortuneTeller.addActionListener(listener);
                        soldier.addActionListener(listener);
                        undertaker.addActionListener(listener);
                        mayor.addActionListener(listener);
                        butler.addActionListener(listener);
                        recluse.addActionListener(listener);
                        drunk.addActionListener(listener);
                        saint.addActionListener(listener);
                        poisoner.addActionListener(listener);
                        baron.addActionListener(listener);
                        spy.addActionListener(listener);
                        scarletWoman.addActionListener(listener);
                        imp.addActionListener(listener);
                        but.setText(cha);
                    }
                }
                else{
                    if(flag){
                        state.show(but,e.getX(),e.getY());
                    }
                    else{
                        ability.show(but,e.getX(),e.getY());
                    }
                }
            }
        });
    }
    
    
    


    




    public void init(){
        //这里组装开始界面
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
        exit.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                Boolean flag= e.isPopupTrigger();
                if(!flag){
                    System.exit(0);                
                }
            }
        });
        single.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                Boolean flag= e.isPopupTrigger();
                if(!flag){
                    frameMagicCodex.setVisible(true);                
                }
            }
        });
        //这里组装魔典界面
        frameMagicCodex.setJMenuBar(menuRules);
        menuRules.add(rules);
        rulesShowing.add(ruleTextArea);
        ruleTextArea.setText("你可以访问：https://bloodontheclocktower.com 来获取规则");
        rules.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                boolean flag = e.isPopupTrigger();
                if(!flag){
                    rulesShowing.setVisible(true);                
                }
            }
        });
        returning.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                boolean flag = e.isPopupTrigger();
                if(!flag){
                    frameMagicCodex.dispose();
                }
            }
        });
        time.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                boolean flag = e.isPopupTrigger();
                if(!flag){
                    if(time.getText()=="白天"){
                        time.setText("晚上");
                    }
                    else{
                        time.setText("白天");
                    }
                }
            }
        });
        rnt.add(returning);
        rnt.add(nominationVoting);
        rnt.add(time);
        frameMagicCodex.add(rnt,BorderLayout.SOUTH);
        frameMagicCodex.add(game,BorderLayout.CENTER);
        //下面组装人物区域

        //组装状态菜单

        //组装人物选择菜单
        players[0]=player1;
        players[1]=player2;
        players[2]=player3;
        players[3]=player4;
        players[4]=player5;
        players[5]=player6;
        players[6]=player7;
        players[7]=player8;
        players[8]=player9;
        players[9]=player10;
        players[10]=player11;
        players[11]=player12;
        for(int i=0;i<=11;i++){
            new Bstbtdemo().bindingCharacters(players[i]);//按钮绑定右键弹出角色菜单
        }
        /*ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();
                cha=actionCommand;
            }
        };*/
        characters.add(villagers);
        characters.add(outsiders);
        characters.add(pawns);
        characters.add(demon);
        villagers.add(washerWoman);
        villagers.add(librarian);
        villagers.add(monk);
        villagers.add(investigator);
        villagers.add(ravenKeeper);
        villagers.add(chef);
        villagers.add(virgin);
        villagers.add(empath);
        villagers.add(slayer);
        villagers.add(fortuneTeller);
        villagers.add(soldier);
        villagers.add(undertaker);
        villagers.add(mayor);
        outsiders.add(butler);
        outsiders.add(recluse);
        outsiders.add(drunk);
        outsiders.add(saint);
        pawns.add(poisoner);
        pawns.add(baron);
        pawns.add(spy);
        pawns.add(scarletWoman);
        demon.add(imp);
        /*players.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                boolean flag = e.isPopupTrigger();
                if(players.getText()=="待选"){
                    if(!flag){
                        players.setText("");
                    }
                }
            }
        });*/
        game.setLayout(new GridLayout(11,9));
        for(int i=0;i<=8;i++){
            game.add(white);
        }
        for(int i=0;i<=8;i++){
            if(i%2==1){
                game.add(players);
            }
            else{
                game.add(white);
            }
        }
        for(int j=2;j<=10;j++){
            for(int i=0;i<=8;i++){
                if(j%2==0){
                    game.add(white);
                }
                else{
                    if(i==1||i==7){
                        game.add(players);
                    }
                    else
                        game.add(white);
                }
            }
        }

        
        frameFirst.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
        new Bstbtdemo().init();
    }
}
