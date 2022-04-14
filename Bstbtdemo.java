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
    public int find(String name,String[] names){
        for(int i =0;i<names.length;i++){
            if(name.equals(names[i])){
                return i;
            }
        }
        return 0;    
    }
    private int number=0;
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
    private JDialog memberName=new JDialog(frameFirst,"制作人员",true);
    private JScrollPane memberScrollPane=new JScrollPane();
    private JTextArea names=new JTextArea(6,18);
    private JDialog frameMagicCodex=new JDialog(frameFirst,"魔典",true);
    private JMenuBar menuRules=new JMenuBar();
    private JMenu rules=new JMenu("游戏规则");
    private JDialog rulesShowing=new JDialog(frameMagicCodex,"规则",true);//展示规则
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
    private JDialog ability=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenu villagers=new JMenu("村民");
    private JMenu outsiders=new JMenu("外来者");
    private JMenu pawns=new JMenu("爪牙");
    private JMenu demon=new JMenu("恶魔");
    //用于点击时指定显示
    private String[] charactersList={"洗衣妇","图书馆员","僧侣","调查员","守鸦人","厨师","圣女","共情者","杀手","预言家","士兵","送葬者","镇长","管家","隐士","酒鬼","圣徒","毒师","间谍","荡妇","小恶魔"};
    private JMenuItem washerWoman=new JMenuItem("洗衣妇");
    private JDialog washerWomanState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox washerWomanHealth=new JCheckBox("健康",true);
    private JCheckBox washerWomanDeath=new JCheckBox("死亡",false);
    private JCheckBox washerWomanProtection=new JCheckBox("被保护",false);
    private JDialog washerWomanAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem librarian=new JMenuItem("图书馆员");
    private JDialog librarianState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox librarianHealth=new JCheckBox("健康",true);
    private JCheckBox librarianDeath=new JCheckBox("死亡",false);
    private JCheckBox librarianProtection=new JCheckBox("被保护",false);
    private JDialog librarianAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem monk=new JMenuItem("僧侣");
    private JDialog monkState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox monkHealth=new JCheckBox("健康",true);
    private JCheckBox monkDeath=new JCheckBox("死亡",false);
    private JCheckBox monkProtection=new JCheckBox("被保护",false);
    private JDialog monkAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem investigator=new JMenuItem("调查员");
    private JDialog investigatorState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox investigatorHealth=new JCheckBox("健康",true);
    private JCheckBox investigatorDeath=new JCheckBox("死亡",false);
    private JCheckBox investigatorProtection=new JCheckBox("被保护",false);
    private JDialog investigatorAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem ravenKeeper=new JMenuItem("守鸦人");
    private JDialog ravenKeeperState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox ravenKeeperHealth=new JCheckBox("健康",true);
    private JCheckBox ravenKeeperDeath=new JCheckBox("死亡",false);
    private JCheckBox ravenKeeperProtection=new JCheckBox("被保护",false);
    private JDialog ravenKeepeAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem chef=new JMenuItem("厨师");
    private JDialog chefState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox chefHealth=new JCheckBox("健康",true);
    private JCheckBox chefDeath=new JCheckBox("死亡",false);
    private JCheckBox chefProtection=new JCheckBox("被保护",false);
    private JDialog chefAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem virgin=new JMenuItem("圣女");
    private JDialog virginState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox virginHealth=new JCheckBox("健康",true);
    private JCheckBox virginDeath=new JCheckBox("死亡",false);
    private JCheckBox virginProtection=new JCheckBox("被保护",false);
    private JDialog virginAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem empath=new JMenuItem("共情者");
    private JDialog empathState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox empathHealth=new JCheckBox("健康",true);
    private JCheckBox empathDeath=new JCheckBox("死亡",false);
    private JCheckBox empathProtection=new JCheckBox("被保护",false);
    private JDialog empathAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem slayer=new JMenuItem("杀手");
    private JDialog slayerState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox slayerHealth=new JCheckBox("健康",true);
    private JCheckBox slayerDeath=new JCheckBox("死亡",false);
    private JCheckBox slayerProtection=new JCheckBox("被保护",false);
    private JDialog slayerAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem fortuneTeller=new JMenuItem("预言家");
    private JDialog fortuneTellerState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox fortuneTellerHealth=new JCheckBox("健康",true);
    private JCheckBox fortuneTellerDeath=new JCheckBox("死亡",false);
    private JCheckBox fortuneTellerProtection=new JCheckBox("被保护",false);
    private JDialog fortuneTellerAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem soldier=new JMenuItem("士兵");
    private JDialog soldierState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox soldierHealth=new JCheckBox("健康",true);
    private JCheckBox soldierDeath=new JCheckBox("死亡",false);
    private JCheckBox soldierProtection=new JCheckBox("被保护",false);
    private JDialog soldierAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem undertaker=new JMenuItem("送葬者");
    private JDialog undertakerState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox undertakerHealth=new JCheckBox("健康",true);
    private JCheckBox undertakerDeath=new JCheckBox("死亡",false);
    private JCheckBox undertakerProtection=new JCheckBox("被保护",false);
    private JDialog undertakerAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem mayor=new JMenuItem("镇长");
    private JDialog mayorState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox mayorHealth=new JCheckBox("健康",true);
    private JCheckBox mayorDeath=new JCheckBox("死亡",false);
    private JCheckBox mayorProtection=new JCheckBox("被保护",false);
    private JDialog mayorAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem butler=new JMenuItem("管家");
    private JDialog butlerState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox butlerHealth=new JCheckBox("健康",true);
    private JCheckBox butlerDeath=new JCheckBox("死亡",false);
    private JCheckBox butlerProtection=new JCheckBox("被保护",false);
    private JDialog butlerAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem recluse=new JMenuItem("隐士");
    private JDialog recluseState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox recluseHealth=new JCheckBox("健康",true);
    private JCheckBox recluseDeath=new JCheckBox("死亡",false);
    private JCheckBox recluseProtection=new JCheckBox("被保护",false);
    private JDialog recluseAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem drunk=new JMenuItem("酒鬼");
    private JDialog drunkState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox drunkHealth=new JCheckBox("健康",true);
    private JCheckBox drunkDeath=new JCheckBox("死亡",false);
    private JCheckBox drunkProtection=new JCheckBox("被保护",false);
    private JDialog drunkAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem saint=new JMenuItem("圣徒");
    private JDialog saintState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox saintHealth=new JCheckBox("健康",true);
    private JCheckBox saintDeath=new JCheckBox("死亡",false);
    private JCheckBox saintProtection=new JCheckBox("被保护",false);
    private JDialog saintAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem poisoner=new JMenuItem("毒师");
    private JDialog poisonerState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox poisonerHealth=new JCheckBox("健康",true);
    private JCheckBox poisonerDeath=new JCheckBox("死亡",false);
    private JCheckBox poisonerProtection=new JCheckBox("被保护",false);
    private JDialog poisonerAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem baron=new JMenuItem("男爵");
    private JDialog baronState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox baronHealth=new JCheckBox("健康",true);
    private JCheckBox baronDeath=new JCheckBox("死亡",false);
    private JCheckBox baronProtection=new JCheckBox("被保护",false);
    private JDialog baronAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem spy=new JMenuItem("间谍");
    private JDialog spyState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox spyHealth=new JCheckBox("健康",true);
    private JCheckBox spyDeath=new JCheckBox("死亡",false);
    private JCheckBox spyProtection=new JCheckBox("被保护",false);
    private JDialog spyAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem scarletWoman=new JMenuItem("荡妇");
    private JDialog scarletWomanState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox scarletWomanHealth=new JCheckBox("健康",true);
    private JCheckBox scarletWomanDeath=new JCheckBox("死亡",false);
    private JCheckBox scarletWomanProtection=new JCheckBox("被保护",false);
    private JDialog scarletWomanAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem imp=new JMenuItem("小恶魔");
    private JDialog impState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox impHealth=new JCheckBox("健康",true);
    private JCheckBox impDeath=new JCheckBox("死亡",false);
    private JCheckBox impProtection=new JCheckBox("被保护",false);
    private JDialog impAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    //用于点击时指定显示
    private JDialog[] charactersStatic={washerWomanState,librarianState,monkState,investigatorState,ravenKeeperState,chefState,virginState,empathState,slayerState,fortuneTellerState,soldierState,undertakerState,mayorState,butlerState,recluseState,drunkState,saintState,poisonerState,baronState,spyState,scarletWomanState,impState};
    private JPanel game=new JPanel();//玩家区域
    private JLabel white=new JLabel();//用来填充空白
    private JPanel rnt=new JPanel();//放置时间按钮返回按钮和提名投票按钮
    private JButton returning=new JButton("返回");
    private JButton nominationVoting=new JButton("提名投票");
    private JButton time=new JButton("白天");
    private JDialog nomination=new JDialog(frameMagicCodex,"提名",true);
    private JPanel nominate=new JPanel();
    private JPanel nominationOverReturning=new JPanel();//放置结束提名和返回按钮
    private JDialog voting=new JDialog(nomination,"投票",true);
    private JPanel vote=new JPanel();
    private JButton votingOver=new JButton("投票结束");
    private String cha="";//用来继承角色选择
    public void bindingCharacters(JButton but){//按钮绑定菜单,组装菜单
        int ownNumber=0;
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
                        charactersStatic[find(but.getText(),charactersList)].setVisible(true);
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
        //绑定按钮
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
        //组装状态菜单
        washerWomanState.add(washerWomanHealth,BorderLayout.NORTH);
        washerWomanState.add(washerWomanProtection,BorderLayout.CENTER);
        washerWomanState.add(washerWomanDeath,BorderLayout.SOUTH);
        librarianState.add(librarianHealth,BorderLayout.NORTH);
        librarianState.add(librarianProtection,BorderLayout.CENTER);
        librarianState.add(librarianDeath,BorderLayout.SOUTH);
        monkState.add(monkHealth,BorderLayout.NORTH);
        monkState.add(monkProtection,BorderLayout.CENTER);
        monkState.add(monkDeath,BorderLayout.SOUTH);
        investigatorState.add(investigatorHealth,BorderLayout.NORTH);
        investigatorState.add(investigatorProtection,BorderLayout.CENTER);
        investigatorState.add(investigatorDeath,BorderLayout.SOUTH);
        ravenKeeperState.add(recluseHealth,BorderLayout.NORTH);
        ravenKeeperState.add(recluseProtection,BorderLayout.CENTER);
        ravenKeeperState.add(recluseDeath,BorderLayout.SOUTH);
        chefState.add(chefHealth,BorderLayout.NORTH);
        chefState.add(chefProtection,BorderLayout.CENTER);
        chefState.add(chefDeath,BorderLayout.SOUTH);
        virginState.add(virginHealth,BorderLayout.NORTH);
        virginState.add(virginProtection,BorderLayout.CENTER);
        virginState.add(virginDeath,BorderLayout.SOUTH);
        empathState.add(empathHealth,BorderLayout.NORTH);
        empathState.add(empathProtection,BorderLayout.CENTER);
        empathState.add(empathDeath,BorderLayout.SOUTH);
        slayerState.add(slayerHealth,BorderLayout.NORTH);
        slayerState.add(slayerProtection,BorderLayout.CENTER);
        slayerState.add(slayerDeath,BorderLayout.SOUTH);
        fortuneTellerState.add(fortuneTellerHealth,BorderLayout.NORTH);
        fortuneTellerState.add(fortuneTellerProtection,BorderLayout.CENTER);
        fortuneTellerState.add(fortuneTellerDeath,BorderLayout.SOUTH);
        soldierState.add(soldierHealth,BorderLayout.NORTH);
        soldierState.add(soldierProtection,BorderLayout.CENTER);
        soldierState.add(soldierDeath,BorderLayout.SOUTH);
        undertakerState.add(undertakerHealth,BorderLayout.NORTH);
        undertakerState.add(undertakerProtection,BorderLayout.CENTER);
        undertakerState.add(undertakerDeath,BorderLayout.SOUTH);
        mayorState.add(mayorHealth,BorderLayout.NORTH);
        mayorState.add(mayorProtection,BorderLayout.CENTER);
        mayorState.add(mayorDeath,BorderLayout.SOUTH);
        butlerState.add(butlerHealth,BorderLayout.NORTH);
        butlerState.add(butlerProtection,BorderLayout.CENTER);
        butlerState.add(butlerDeath,BorderLayout.SOUTH);
        recluseState.add(recluseHealth,BorderLayout.NORTH);
        recluseState.add(recluseProtection,BorderLayout.CENTER);
        recluseState.add(recluseDeath,BorderLayout.SOUTH);
        drunkState.add(drunkHealth,BorderLayout.NORTH);
        drunkState.add(drunkProtection,BorderLayout.CENTER);
        drunkState.add(drunkDeath,BorderLayout.SOUTH);
        saintState.add(saintHealth,BorderLayout.NORTH);
        saintState.add(saintProtection,BorderLayout.CENTER);
        saintState.add(saintDeath,BorderLayout.SOUTH);
        poisonerState.add(poisonerHealth,BorderLayout.NORTH);
        poisonerState.add(poisonerProtection,BorderLayout.CENTER);
        poisonerState.add(poisonerDeath,BorderLayout.SOUTH);
        baron.add(baronHealth,BorderLayout.NORTH);
        baron.add(baronProtection,BorderLayout.CENTER);
        baron.add(baronDeath,BorderLayout.SOUTH);
        spyState.add(spyHealth,BorderLayout.NORTH);
        spyState.add(spyProtection,BorderLayout.CENTER);
        spyState.add(spyDeath,BorderLayout.SOUTH);
        scarletWomanState.add(scarletWomanHealth,BorderLayout.NORTH);
        scarletWomanState.add(scarletWomanProtection,BorderLayout.CENTER);
        scarletWomanState.add(scarletWomanHealth,BorderLayout.SOUTH);
        impState.add(impHealth,BorderLayout.NORTH);
        impState.add(impProtection,BorderLayout.CENTER);
        impState.add(impDeath,BorderLayout.SOUTH);

        //组装人物选择菜单

        //组装人物技能释放窗口
        washerWomanAbility.add(new JTextArea("请说书人指定两名玩家，并告诉洗衣妇他们之中的一个村民角色。"));
        librarianAbility.add(new JTextArea("第一天晚上，请说书人指两名玩家并告诉图书馆员他们之中一个的外来者角色，或者本局游戏没有外来者。"));
        monkAbility.add(new JTextArea("选择一名玩家进行保护，使得该玩家不会被恶魔杀死"),BorderLayout.SOUTH);
        JComboBox aim= new JComboBox<>();
        for(int i =1;i<=12;i++){
            aim.addItem(i);
        }
        monkAbility.add(aim,BorderLayout.CENTER);
        investigatorAbility.add(new JTextArea("第一天晚上，请说书人会指定两名玩家，并告诉调查员他们之中的一个爪牙角色。"));
        

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
        //添加按钮
        int k=0;//用于辅助添加按钮到区域中
        game.setLayout(new GridLayout(11,9));
        for(int i=0;i<=8;i++){
            game.add(white);
        }
        for(int i=0;i<=8;i++){
            if(i%2==1){
                game.add(players[k]);
                k+=1;
            }
            else{
                game.add(white);
                k+=1;
            }
        }
        for(int j=2;j<=10;j++){
            for(int i=0;i<=8;i++){
                if(j%2==0){
                    game.add(white);
                    k+=1;
                }
                else{
                    if(i==1||i==7){
                        game.add(players[k]);
                        k+=1;
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
