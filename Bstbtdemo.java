package BSTBT;
import javax.swing.*;
import javax.swing.event.MenuDragMouseEvent;
import javax.swing.event.MouseInputAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.beans.Visibility;
public class Bstbtdemo {
    //数组排序去重
    //用来联系角色的各方面
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
    private JMenu team=new JMenu("制作人员");
    private JMenuItem teamMembers=new JMenuItem("人员名单");
    private JDialog memberName=new JDialog(frameFirst,"制作人员",true);
    private JScrollPane memberScrollPane=new JScrollPane();
    private JTextArea names=new JTextArea(6,18);
    private JDialog frameMagicCodex=new JDialog(frameFirst,"魔典",true);
    private JMenuBar menuRules=new JMenuBar();
    private JMenu rules=new JMenu("游戏规则");
    private JMenuItem ruleShow=new JMenuItem("规则");
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
    private JPopupMenu[] characters=new JPopupMenu[12];//十二个侧边菜单
    private JDialog ability=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenu[] villagers=new JMenu[12];//12个村民
    private JMenu[] outsiders=new JMenu[12];//12个外来者
    private JMenu[] pawns=new JMenu[12];//十二个爪牙
    private JMenu[] demon=new JMenu[12];//12个恶魔
    //用于点击时指定显示
    private String[] charactersList={"洗衣妇","图书馆员","僧侣","调查员","守鸦人","厨师","圣女","共情者","杀手","预言家","士兵","送葬者","镇长","管家","隐士","酒鬼","圣徒","毒师","男爵","间谍","荡妇","小恶魔"};
    private JMenuItem[] washerWoman=new JMenuItem[12];//12个洗衣妇
    private JDialog washerWomanState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox washerWomanHealth=new JCheckBox("健康",true);
    private JCheckBox washerWomanDeath=new JCheckBox("死亡",false);
    private JCheckBox washerWomanProtection=new JCheckBox("被保护",false);
    private JDialog washerWomanAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem[] librarian=new JMenuItem[12];
    private JDialog librarianState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox librarianHealth=new JCheckBox("健康",true);
    private JCheckBox librarianDeath=new JCheckBox("死亡",false);
    private JCheckBox librarianProtection=new JCheckBox("被保护",false);
    private JDialog librarianAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem[] monk=new JMenuItem[12];
    private JDialog monkState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox monkHealth=new JCheckBox("健康",true);
    private JCheckBox monkDeath=new JCheckBox("死亡",false);
    private JCheckBox monkProtection=new JCheckBox("被保护",false);
    private JDialog monkAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem[] investigator=new JMenuItem[12];
    private JDialog investigatorState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox investigatorHealth=new JCheckBox("健康",true);
    private JCheckBox investigatorDeath=new JCheckBox("死亡",false);
    private JCheckBox investigatorProtection=new JCheckBox("被保护",false);
    private JDialog investigatorAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem[] ravenKeeper=new JMenuItem[12];
    private JDialog ravenKeeperState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox ravenKeeperHealth=new JCheckBox("健康",true);
    private JCheckBox ravenKeeperDeath=new JCheckBox("死亡",false);
    private JCheckBox ravenKeeperProtection=new JCheckBox("被保护",false);
    private JDialog ravenKeeperAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem[] chef=new JMenuItem[12];
    private JDialog chefState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox chefHealth=new JCheckBox("健康",true);
    private JCheckBox chefDeath=new JCheckBox("死亡",false);
    private JCheckBox chefProtection=new JCheckBox("被保护",false);
    private JDialog chefAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem[] virgin=new JMenuItem[12];
    private JDialog virginState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox virginHealth=new JCheckBox("健康",true);
    private JCheckBox virginDeath=new JCheckBox("死亡",false);
    private JCheckBox virginProtection=new JCheckBox("被保护",false);
    private JDialog virginAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem[] empath=new JMenuItem[12];
    private JDialog empathState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox empathHealth=new JCheckBox("健康",true);
    private JCheckBox empathDeath=new JCheckBox("死亡",false);
    private JCheckBox empathProtection=new JCheckBox("被保护",false);
    private JDialog empathAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem[] slayer=new JMenuItem[12];
    private JDialog slayerState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox slayerHealth=new JCheckBox("健康",true);
    private JCheckBox slayerDeath=new JCheckBox("死亡",false);
    private JCheckBox slayerProtection=new JCheckBox("被保护",false);
    private JDialog slayerAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem[] fortuneTeller=new JMenuItem[12];
    private JDialog fortuneTellerState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox fortuneTellerHealth=new JCheckBox("健康",true);
    private JCheckBox fortuneTellerDeath=new JCheckBox("死亡",false);
    private JCheckBox fortuneTellerProtection=new JCheckBox("被保护",false);
    private JDialog fortuneTellerAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem[] soldier=new JMenuItem[12];
    private JDialog soldierState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox soldierHealth=new JCheckBox("健康",true);
    private JCheckBox soldierDeath=new JCheckBox("死亡",false);
    private JCheckBox soldierProtection=new JCheckBox("被保护",false);
    private JDialog soldierAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem[] undertaker=new JMenuItem[12];
    private JDialog undertakerState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox undertakerHealth=new JCheckBox("健康",true);
    private JCheckBox undertakerDeath=new JCheckBox("死亡",false);
    private JCheckBox undertakerProtection=new JCheckBox("被保护",false);
    private JDialog undertakerAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem[] mayor=new JMenuItem[12];
    private JDialog mayorState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox mayorHealth=new JCheckBox("健康",true);
    private JCheckBox mayorDeath=new JCheckBox("死亡",false);
    private JCheckBox mayorProtection=new JCheckBox("被保护",false);
    private JDialog mayorAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem[] butler=new JMenuItem[12];
    private JDialog butlerState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox butlerHealth=new JCheckBox("健康",true);
    private JCheckBox butlerDeath=new JCheckBox("死亡",false);
    private JCheckBox butlerProtection=new JCheckBox("被保护",false);
    private JDialog butlerAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem[] recluse=new JMenuItem[12];
    private JDialog recluseState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox recluseHealth=new JCheckBox("健康",true);
    private JCheckBox recluseDeath=new JCheckBox("死亡",false);
    private JCheckBox recluseProtection=new JCheckBox("被保护",false);
    private JDialog recluseAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem[] drunk=new JMenuItem[12];
    private JDialog drunkState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox drunkHealth=new JCheckBox("健康",true);
    private JCheckBox drunkDeath=new JCheckBox("死亡",false);
    private JCheckBox drunkProtection=new JCheckBox("被保护",false);
    private JDialog drunkAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem[] saint=new JMenuItem[12];
    private JDialog saintState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox saintHealth=new JCheckBox("健康",true);
    private JCheckBox saintDeath=new JCheckBox("死亡",false);
    private JCheckBox saintProtection=new JCheckBox("被保护",false);
    private JDialog saintAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem[] poisoner=new JMenuItem[12];
    private JDialog poisonerState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox poisonerHealth=new JCheckBox("健康",true);
    private JCheckBox poisonerDeath=new JCheckBox("死亡",false);
    private JCheckBox poisonerProtection=new JCheckBox("被保护",false);
    private JDialog poisonerAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem[] baron=new JMenuItem[12];
    private JDialog baronState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox baronHealth=new JCheckBox("健康",true);
    private JCheckBox baronDeath=new JCheckBox("死亡",false);
    private JCheckBox baronProtection=new JCheckBox("被保护",false);
    private JDialog baronAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem[] spy=new JMenuItem[12];
    private JDialog spyState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox spyHealth=new JCheckBox("健康",true);
    private JCheckBox spyDeath=new JCheckBox("死亡",false);
    private JCheckBox spyProtection=new JCheckBox("被保护",false);
    private JDialog spyAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem[] scarletWoman=new JMenuItem[12];
    private JDialog scarletWomanState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox scarletWomanHealth=new JCheckBox("健康",true);
    private JCheckBox scarletWomanDeath=new JCheckBox("死亡",false);
    private JCheckBox scarletWomanProtection=new JCheckBox("被保护",false);
    private JDialog scarletWomanAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    private JMenuItem[] imp=new JMenuItem[12];
    private JDialog impState=new JDialog(frameMagicCodex,"状态",true);//状态
    private JCheckBox impHealth=new JCheckBox("健康",true);
    private JCheckBox impDeath=new JCheckBox("死亡",false);
    private JCheckBox impProtection=new JCheckBox("被保护",false);
    private JDialog impAbility=new JDialog(frameMagicCodex,"释放技能",true);//技能
    //用于点击时指定显示，状态和技能与名字数组一一对应
    private JDialog[] charactersStatic={washerWomanState,librarianState,monkState,investigatorState,ravenKeeperState,chefState,virginState,empathState,slayerState,fortuneTellerState,soldierState,undertakerState,mayorState,butlerState,recluseState,drunkState,saintState,poisonerState,baronState,spyState,scarletWomanState,impState};
    private JDialog[] charactersAbility={washerWomanAbility,librarianAbility,monkAbility,investigatorAbility,ravenKeeperAbility,chefAbility,virginAbility,empathAbility,slayerAbility,fortuneTellerAbility,soldierAbility,undertakerAbility,mayorAbility,butlerAbility,recluseAbility,drunkAbility,saintAbility,poisonerAbility,baronAbility,spyAbility,scarletWomanAbility,impAbility};
    private JCheckBox[] charactersHealth={washerWomanHealth,librarianHealth,monkHealth,investigatorHealth,ravenKeeperHealth,chefHealth,virginHealth,empathHealth,slayerHealth,fortuneTellerHealth,soldierHealth,undertakerHealth,mayorHealth,butlerHealth,recluseHealth,drunkHealth,saintHealth,poisonerHealth,baronHealth,spyHealth,scarletWomanHealth,impHealth};
    private JCheckBox[] charactersProtection={washerWomanProtection,librarianProtection,monkProtection,investigatorProtection,ravenKeeperProtection,chefProtection,virginProtection,empathProtection,slayerProtection,fortuneTellerProtection,soldierProtection,undertakerProtection,mayorProtection,butlerProtection,recluseProtection,drunkProtection,saintProtection,poisonerProtection,baronProtection,spyProtection,scarletWomanProtection,impProtection};
    private JCheckBox[] charactersDeath={washerWomanDeath,librarianDeath,monkDeath,investigatorDeath,ravenKeeperDeath,chefDeath,virginDeath,empathDeath,slayerDeath,fortuneTellerDeath,soldierDeath,undertakerDeath,mayorDeath,butlerDeath,recluseDeath,drunkDeath,saintDeath,poisonerDeath,baronDeath,spyDeath,scarletWomanDeath,impDeath};
    private JPanel game=new JPanel();//玩家区域
    private JLabel white=new JLabel();//用来填充空白
    private JPanel rntc=new JPanel();//放置时间按钮返回按钮和提名投票按钮
    private JButton returningFirst=new JButton("返回");
    private JButton nominationVoting=new JButton("提名投票");
    private JButton time=new JButton("白天");
    private JDialog nomination=new JDialog(frameMagicCodex,"提名",false);
    private JPanel nominate=new JPanel();//用来放置提名栏
    private JComboBox[] nomainateJComboBoxs=new JComboBox[12];//提名栏组
    private JButton nominatingOver=new JButton("提名结束");
    private JButton returningMagicCodex=new JButton("返回");
    private JPanel nominationOverReturning=new JPanel();//放置结束提名和返回按钮
    private JDialog voting=new JDialog(nomination,"投票",false);
    private JTextArea nominateResult=new JTextArea(2,20);//用来在投票窗口提示说书人下面投票栏的玩家分别是哪些
    private JPanel vote=new JPanel();//用来放置投票栏
    private JPanel votingOverResults=new JPanel();//用来放置结束按钮和结果框
    private JButton votingOver=new JButton("投票结束");
    private JTextArea votingResults=new JTextArea(3,12);//用来显示投票结果
    private String cha="";//用来继承角色选择
    /*public void bindingCharacters(JButton but){//按钮绑定菜单,组装菜单
        int ownNumber=0;
        but.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                boolean flag=e.isPopupTrigger();
                if(but.getText()=="待选"){
                    if(!flag){
                        frameMagicCodex.add(characters);
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
                        charactersAbility[find(but.getText(),charactersList)].setVisible(true);
                    }
                }
            }
        });
    }*/
    
    
    


    




    public void init(){
        //拼装独立的22组角色选择框
        for(int i=0;i<=11;i++){
            characters[i]=new JPopupMenu();
            villagers[i]=new JMenu("村民");
            outsiders[i]=new JMenu("外来者");
            pawns[i]=new JMenu("爪牙");
            demon[i]=new JMenu("恶魔");
            washerWoman[i]=new JMenuItem("洗衣妇");
            librarian[i]=new JMenuItem("图书馆员");
            monk[i]=new JMenuItem("僧侣");
            investigator[i]=new JMenuItem("调查员");
            ravenKeeper[i]=new JMenuItem("养鸦人");
            chef[i]=new JMenuItem("厨师");
            virgin[i]=new JMenuItem("圣女");
            empath[i]=new JMenuItem("共情者");
            slayer[i]=new JMenuItem("杀手");
            fortuneTeller[i]=new JMenuItem("预言家");
            soldier[i]=new JMenuItem("士兵");
            undertaker[i]=new JMenuItem("送葬者");
            mayor[i]=new JMenuItem("镇长");
            butler[i]=new JMenuItem("管家");
            recluse[i]=new JMenuItem("隐士");
            drunk[i]=new JMenuItem("酒鬼");
            saint[i]=new JMenuItem("圣徒");
            poisoner[i]=new JMenuItem("毒师");
            baron[i]=new JMenuItem("男爵");
            spy[i]=new JMenuItem("间谍");
            scarletWoman[i]=new JMenuItem("荡妇");
            imp[i]=new JMenuItem("小恶魔");
        }
        for(int i=0;i<=11;i++){
            characters[i].add(villagers[i]);
            characters[i].add(outsiders[i]);
            characters[i].add(pawns[i]);
            characters[i].add(demon[i]);
            villagers[i].add(washerWoman[i]);
            villagers[i].add(librarian[i]);
            villagers[i].add(monk[i]);
            villagers[i].add(investigator[i]);
            villagers[i].add(ravenKeeper[i]);
            villagers[i].add(chef[i]);
            villagers[i].add(virgin[i]);
            villagers[i].add(empath[i]);
            villagers[i].add(slayer[i]);
            villagers[i].add(fortuneTeller[i]);
            villagers[i].add(soldier[i]);
            villagers[i].add(undertaker[i]);
            villagers[i].add(mayor[i]);
            outsiders[i].add(butler[i]);
            outsiders[i].add(recluse[i]);
            outsiders[i].add(drunk[i]);
            outsiders[i].add(saint[i]);
            pawns[i].add(poisoner[i]);
            pawns[i].add(baron[i]);
            pawns[i].add(spy[i]);
            pawns[i].add(scarletWoman[i]);
            demon[i].add(imp[i]);
        }
        //这里组装开始界面
        frameFirst.setJMenuBar(startMenuBar);
        startMenuBar.add(team);
        team.add(teamMembers);
        teamMembers.addMouseListener(new MouseAdapter() {
            public void mouseReleased(MouseEvent e){
                boolean flag = e.isPopupTrigger();
                if(!flag){
                    memberName.setVisible(true);
                }
            }
        });
        names.append("队长：黄启明\n队员：苏琪杰(图形化) 刘宇辰(后端) 陈博翰(后端)");
        
        memberName.add(names,BorderLayout.CENTER);
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
                    for(int i=0;i<=11;i++){
                        players[i].setText("待选");
                    }
                    frameMagicCodex.setVisible(true);                
                }
            }
        });
        frameFirst.add(singleMultiplayerExit,BorderLayout.CENTER);
        //这里组装魔典界面
        frameMagicCodex.setJMenuBar(menuRules);
        menuRules.add(rules);
        rules.add(ruleShow);
        rulesShowing.add(ruleTextArea);
        ruleTextArea.setText("你可以访问：https://bloodontheclocktower.com 来获取规则");
        ruleShow.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                boolean flag = e.isPopupTrigger();
                if(!flag){
                    rulesShowing.setVisible(true);                
                }
            }
        });
        returningFirst.addMouseListener(new MouseAdapter(){
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
                        for(int i=0;i<=21;i++){
                            charactersProtection[i].setSelected(false);
                        }
                    }
                }
            }
        });
        //这里组装魔典下面的操作按钮条
        JButton changeToImp=new JButton("变成恶魔");//设置变成恶魔的窗口
        JComboBox chooseToChange=new JComboBox<>();
        for(int i =1;i<=12;i++){
            chooseToChange.addItem(i);
        }
        /*chooseToChange.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
              String numb=e.getActionCommand();
              chooseToChange.addMouseListener(new MouseAdapter(){
                  public void mouseReleased(MouseEvent e){
                      boolean flag=e.isPopupTrigger();
                      if(!flag){
                          players[Integer.parseInt(numb)-1].setText("恶魔");
                      }
                  }
              });
            }
        });*/
        changeToImp.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                boolean flag=e.isPopupTrigger();
                if(!flag){
                    players[(int)chooseToChange.getSelectedItem()-1].setText("小恶魔");
                }
            }
        });
        JPanel change=new JPanel();
        change.add(chooseToChange);
        change.add(changeToImp);
        nominationVoting.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                boolean flag=e.isPopupTrigger();
                if(!flag){
                    nomination.setVisible(true);
                }
            }
        });
        rntc.add(returningFirst);
        rntc.add(nominationVoting);
        rntc.add(time);
        rntc.add(change);
        frameMagicCodex.add(rntc,BorderLayout.SOUTH);
        frameMagicCodex.add(game,BorderLayout.CENTER);
        //下面组装人物区域
        //绑定按钮
        /*ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();
                cha=actionCommand;
                player1.setText(cha);
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
        imp.addActionListener(listener);*/
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
        /*for(int i=0;i<=11;i++){
            new Bstbtdemo().bindingCharacters(players[i]);//按钮绑定右键弹出角色菜单
        }*/
        
        for(int i=0;i<=11;i++){//绑定按钮有关事件
            int[] i1={i};
            players[i].addMouseListener(new MouseAdapter(){
                public void mouseReleased(MouseEvent e){
                    boolean flag=e.isPopupTrigger();
                    if(players[i1[0]].getText()=="待选"){
                        if(!flag){
                            frameMagicCodex.add(characters[i1[0]]);
                            characters[i1[0]].show(players[i1[0]],e.getX(),e.getY());
                            /*ActionListener listener = new ActionListener() {
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
                            imp.addActionListener(listener);*/
                            ActionListener listener = new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent e) {
                                    String actionCommand = e.getActionCommand();
                                    cha=actionCommand;
                                    players[i1[0]].setText(cha);
                                }
                            };
                            washerWoman[i1[0]].addActionListener(listener);
                            librarian[i1[0]].addActionListener(listener);
                            monk[i1[0]].addActionListener(listener);
                            investigator[i1[0]].addActionListener(listener);
                            ravenKeeper[i1[0]].addActionListener(listener);
                            chef[i1[0]].addActionListener(listener);
                            virgin[i1[0]].addActionListener(listener);
                            empath[i1[0]].addActionListener(listener);
                            slayer[i1[0]].addActionListener(listener);
                            fortuneTeller[i1[0]].addActionListener(listener);
                            soldier[i1[0]].addActionListener(listener);
                            undertaker[i1[0]].addActionListener(listener);
                            mayor[i1[0]].addActionListener(listener);
                            butler[i1[0]].addActionListener(listener);
                            recluse[i1[0]].addActionListener(listener);
                            drunk[i1[0]].addActionListener(listener);
                            saint[i1[0]].addActionListener(listener);
                            poisoner[i1[0]].addActionListener(listener);
                            baron[i1[0]].addActionListener(listener);
                            spy[i1[0]].addActionListener(listener);
                            scarletWoman[i1[0]].addActionListener(listener);
                            imp[i1[0]].addActionListener(listener);
                        }
                    }
                    else{
                        if(flag){
                            charactersStatic[find(players[i1[0]].getText(),charactersList)].pack();
                            charactersStatic[find(players[i1[0]].getText(),charactersList)].setVisible(true);
                        }
                        else{
                            charactersAbility[find(players[i1[0]].getText(),charactersList)].pack();
                            charactersAbility[find(players[i1[0]].getText(),charactersList)].setVisible(true);
                        }
                    }
                }
            });
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
        baronState.add(baronHealth,BorderLayout.NORTH);
        baronState.add(baronProtection,BorderLayout.CENTER);
        baronState.add(baronDeath,BorderLayout.SOUTH);
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
        /*characters.add(villagers);
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
        demon.add(imp);*/
        //组装人物技能释放窗口
        washerWomanAbility.add(new JTextArea("请说书人指定两名玩家，并告诉洗衣妇他们之中的一个村民角色。"));
        librarianAbility.add(new JTextArea("第一天晚上，请说书人指两名玩家并告诉图书馆员他们之中一个的外来者角色，或者本局游戏没有外来者。"));
        monkAbility.add(new JTextArea("选择一名玩家进行保护，使得该玩家不会被恶魔杀死。"),BorderLayout.SOUTH);
        JButton monk=new JButton("释放技能");
        JComboBox aimMonk= new JComboBox<>();//按钮要释放事件
        //添加选择角色
        aimMonk.addItem("洗衣妇");
        aimMonk.addItem("图书馆员");
        aimMonk.addItem("僧侣");
        aimMonk.addItem("调查员");
        aimMonk.addItem("养鸦人");
        aimMonk.addItem("厨师");
        aimMonk.addItem("圣女");
        aimMonk.addItem("共情者");
        aimMonk.addItem("杀手");
        aimMonk.addItem("预言家");
        aimMonk.addItem("士兵");
        aimMonk.addItem("送葬者");
        aimMonk.addItem("镇长");
        aimMonk.addItem("管家");
        aimMonk.addItem("隐士");
        aimMonk.addItem("酒鬼");
        aimMonk.addItem("圣徒");
        aimMonk.addItem("毒师");
        aimMonk.addItem("男爵");
        aimMonk.addItem("间谍");
        aimMonk.addItem("荡妇");
        aimMonk.addItem("小恶魔");
        aimMonk.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
              String chari=e.getActionCommand();
              monk.addMouseListener(new MouseAdapter(){
                  public void mouseReleased(MouseEvent e){
                      boolean flag=e.isPopupTrigger();
                      if(!flag){
                          charactersProtection[find(chari,charactersList)].setSelected(true);
                      }
                  }
              });
            }
        });
        monkAbility.add(aimMonk,BorderLayout.CENTER);
        investigatorAbility.add(new JTextArea("第一天晚上，请说书人会指定两名玩家，并告诉调查员他们之中的一个爪牙角色。"));
        ravenKeeperAbility.add(new JTextArea("若在夜晚死去，请说书人告诉其任选的一名玩家的角色。"));
        chefAbility.add(new JTextArea("请说书人在第一个晚上告诉厨师有多少对邪恶阵营玩家为邻座。"));
        virginAbility.add(new JTextArea("当圣女第一次被提名时，处决提名你的村名玩家，立刻进入黑夜。"));
        empathAbility.add(new JTextArea("请每个夜晚时，说书人告知共情者其左右两侧最靠近他的存活玩家有几个是邪恶阵营的。"));
        slayerAbility.add(new JTextArea("每局游戏限一次，白天是，杀手可以公开选择一名玩家发动击杀，若该玩家为恶魔，则击杀有效"),BorderLayout.SOUTH);
        JButton slayer=new JButton("释放技能");
        JComboBox aimSlayer=new JComboBox<>();//按钮要释放事件
        aimSlayer.addItem("洗衣妇");
        aimSlayer.addItem("图书馆员");
        aimSlayer.addItem("僧侣");
        aimSlayer.addItem("调查员");
        aimSlayer.addItem("养鸦人");
        aimSlayer.addItem("厨师");
        aimSlayer.addItem("圣女");
        aimSlayer.addItem("共情者");
        aimSlayer.addItem("杀手");
        aimSlayer.addItem("预言家");
        aimSlayer.addItem("士兵");
        aimSlayer.addItem("送葬者");
        aimSlayer.addItem("镇长");
        aimSlayer.addItem("管家");
        aimSlayer.addItem("隐士");
        aimSlayer.addItem("酒鬼");
        aimSlayer.addItem("圣徒");
        aimSlayer.addItem("毒师");
        aimSlayer.addItem("男爵");
        aimSlayer.addItem("间谍");
        aimSlayer.addItem("荡妇");
        aimSlayer.addItem("小恶魔");
        aimSlayer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
              String chari=e.getActionCommand();
              monk.addMouseListener(new MouseAdapter(){
                  public void mouseReleased(MouseEvent e){
                      boolean flag=e.isPopupTrigger();
                      if(!flag&&chari.equals("小魔鬼")){
                          charactersDeath[find(chari,charactersList)].setSelected(true);
                      }
                  }
              });
            }
        });
        slayerAbility.add(aimSlayer,BorderLayout.NORTH);
        slayerAbility.add(slayer,BorderLayout.CENTER);
        fortuneTellerAbility.add(new JTextArea("每个夜晚，告诉其任选的两位玩家中是否有恶魔。"));
        soldierAbility.add(new JTextArea("晚上士兵不会被恶魔杀死，除非喝醉或中毒"));
        undertakerAbility.add(new JTextArea("请说书人告诉送葬者今天白天被处决的玩家的角色"));
        mayorAbility.add(new JTextArea("若白天只有三名玩家存活且没有执行处决，镇长的善良阵营获胜。如果镇长在夜晚死去，说书人可指定另一位玩家(替罪羊)可能会代替他死去。"));
        butlerAbility.add(new JTextArea("每个夜晚可以选择一位除自己以外的玩家，明天只能在那位玩家参与投票的处决中投票"));
        recluseAbility.add(new JTextArea("当要知道隐士的阵营或者成为其他技能的目标时，说书人可以选择隐士是善良或邪恶"));
        drunkAbility.add(new JTextArea("酒鬼将自己当做一个村民角色，但其其实是外来者"));
        saintAbility.add(new JTextArea("若圣徒白天被处决，则善良阵营失败"));
        poisonerAbility.add(new JTextArea("每个夜晚可以选择一名玩家添加中毒状态，持续到明天晚上开始时消失"));
        baronAbility.add(new JTextArea("若本场游戏选择了男爵角色，则去掉两位村民角色，新增两位外来者角色"));
        spyAbility.add(new JTextArea("每个夜晚，给间谍一段时间使其获得说书人视角，了解场上的真实情况"));
        scarletWomanAbility.add(new JTextArea("若有五名及以上除外来者以外的玩家存活且恶魔死去，你会变成恶魔"));
        //可做按钮
        impAbility.add(new JTextArea("夜晚选择杀死一位玩家，如果自杀，存活的玩家会变成新的恶魔"));

        

        /*ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();
                cha=actionCommand;
            }
        };*/
        
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
        //组装人物按钮
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

            }
        }
        for(int j=2;j<=10;j++){
            for(int i=0;i<=8;i++){
                if(j%2==0){
                    game.add(white);
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
        //组装提名界面
        nomination.add(new JTextArea("序号顺序为从左往右从上到下"),BorderLayout.NORTH);
        for(int i=0;i<=11;i++){
            nomainateJComboBoxs[i]=new JComboBox<>();
            for(int j=0;j<=12;j++){
                nomainateJComboBoxs[i].addItem(j);
            }
        }
        nominate.setLayout(new GridLayout(2,6));
        int n=0;
        for(int i=1;i<=2;i++){
            for(int j=1;j<=6;j++){
                nominate.add(nomainateJComboBoxs[n]);
                n+=1;
            }
        }
        /*nominationOverReturning.setLayout(new BoxLayout(nomina, axis));*/
        returningMagicCodex.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                boolean flag=e.isPopupTrigger();
                if(!flag){
                    nomination.dispose();
                }
            }
        });
        nominatingOver.addMouseListener(new MouseAdapter(){
            public void mouseReleased(MouseEvent e){
                boolean flag=e.isPopupTrigger();
                if(!flag){
                    vote.removeAll();
                    int n1=0;//记录有多少个被提名的
                    for(int i=0;i<=11;i++){
                        if(!(nomainateJComboBoxs[i].getSelectedItem().equals(0))){
                            n1+=1;
                        }
                    }
                    int[] nomainated=new int[n1];//记录被提名的人
                    int u=0;
                    for(int i=0;i<=11;i++){
                        if(!(nomainateJComboBoxs[i].getSelectedItem().equals(0))){
                            nomainated[u]=(int)nomainateJComboBoxs[i].getSelectedItem();
                            u+=1;
                        }
                    }
                    int z,r;//辅助排序去重
                    for(int i=0;i<=n1-2;i++){
                        z=i;
                        for(int j=i+1;j<=n1-1;j++){
                            if(nomainated[z]>nomainated[j]){
                                z=j;
                            }
                        }
                        r=nomainated[i];
                        nomainated[i]=nomainated[z];
                        nomainated[z]=r;
                    }
                    z=1;
                    for(int i=1;i<=n1-1;i++){
                        if(nomainated[i]!=nomainated[i-1]){
                            z+=1;
                        }
                    }
                    int[] realNomainted=new int[z];
                    int y=1;
                    realNomainted[0]=nomainated[0];//最终被提名的人
                    for(int i=1;i<=n1-1;i++){
                        if(nomainated[i]!=nomainated[i-1]){
                            realNomainted[y]=nomainated[i];
                            y+=1;
                        }
                    }
                    nominateResult.setText("从左往右依次为: ");
                    for(int i=0;i<=z-1;i++){
                        nominateResult.append(String.valueOf(realNomainted[i]));
                        nominateResult.append(" ");
                    }
                    vote.setLayout(new GridLayout(1,z));
                    JComboBox[] voteBoxs=new JComboBox[z];
                    for(int i=0;i<=z-1;i++){
                        voteBoxs[i]=new JComboBox<>();
                        for(int j=0;j<=12;j++){
                            voteBoxs[i].addItem(j);
                        }
                        vote.add(voteBoxs[i]);
                    }
                    int[] z1={z};
                    votingOver.addMouseListener(new MouseAdapter(){//统计投票结果
                        public void mouseReleased(MouseEvent e){
                            boolean flag=e.isPopupTrigger();
                            if(!flag){
                                int[] votednum=new int[z1[0]];
                                for(int i=0;i<=z1[0]-1;i++){
                                    votednum[i]=(int)voteBoxs[i].getSelectedItem();
                                }
                                int z=0;
                                for(int i=0;i<=z1[0]-1;i++){
                                    if(votednum[i]>votednum[z]){
                                        z=i;
                                    }
                                }
                                int t,r;
                                for(int i=0;i<=z1[0]-3;i++){
                                    t=i;
                                    for(int j=i+1;i<=z1[0]-2;j++){
                                        if(votednum[t]<votednum[j]){
                                            t=j;
                                        }
                                    }
                                    r=votednum[i];
                                    votednum[i]=votednum[t];
                                    votednum[t]=r;
                                }
                                boolean highestSame=false;
                                if(votednum[0]==votednum[1]&&votednum[0]!=0){
                                    highestSame=true;
                                }
                                boolean zero=true;
                                for(int i=0;i<=z1[0]-1;i++){
                                    if(votednum[i]!=0){
                                        zero=false;
                                        break;
                                    }
                                }
                                if(zero==true){
                                    votingResults.setText("无人投票，请退出");
                                }
                                else if(highestSame==true){
                                    votingResults.setText("最高分两人分数相同，都不处决，请退出并重新提名后再次投票");
                                }
                                else{
                                    votingResults.setText("投票最多的玩家为：");
                                    votingResults.append(String.valueOf(realNomainted[z]));
                                }
                            }
                        }
                    });
                    votingOverResults.add(votingOver);
                    votingOverResults.add(votingResults);
                    voting.add(nominateResult,BorderLayout.NORTH);
                    voting.add(vote,BorderLayout.CENTER);
                    voting.add(votingOverResults,BorderLayout.SOUTH);
                    voting.pack();
                    voting.setVisible(true);
                }
            }
        });
        nomination.add(nominate,BorderLayout.CENTER);
        nominationOverReturning.add(returningMagicCodex);
        nominationOverReturning.add(nominatingOver);
        nomination.add(nominationOverReturning,BorderLayout.SOUTH);
        frameMagicCodex.pack();
        nomination.pack();
        frameFirst.pack();;
        frameFirst.setVisible(true);
    }
        
    public static void main(String[] args){
        new Bstbtdemo().init();
    }
}
