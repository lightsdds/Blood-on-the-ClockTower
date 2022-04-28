import java.nio.channels.spi.SelectorProvider;
import java.util.*;

import javax.lang.model.util.ElementScanner6;

    

public class Manual{

    static int playNumbers=21;
    static boolean night=false;
    static int hide;//spy to be character
    static int outunderstand;//recluse be  is  character
    static int fantasy;//drunk  is character
    static int hatee;//A thorn in the eye
    static int master;// master of servant
    static String[] names=new String[22];
    static boolean[] health=new boolean[22];
    static boolean[] death=new boolean[22];
    static boolean[] protection=new boolean[22];
    static String[] camp=new String[22];
    static int[] ID=new int[playNumbers];
    

    public static void getNumber()//Enter the number of visitors
    {
        System.out.println("`````````````````````Enter the number of visitors");
        Scanner input=new Scanner(System.in);
        int temp=Integer.parseInt(input.nextLine());
        playNumbers=temp;
    }
    
    public static void dayswitch()//Switch between day and night
    {
        if(night==false)
        {
            night=true;
            System.out.println("`````````````````````It's day");
        }
        else
        {
            night=false;
            System.out.println("`````````````````````It's night");
        }
    }

    public static void chooseCharacter()//Select role
    {
        Scanner input=new Scanner(System.in);
        System.out.print("1.lmp\t2.barons\t3.poisoner\t4.scarLetwoman\n5.spy\t6.butler\t7.drunk\t8.recluse\n9.saint\t10.cbef\t11.empath\t12.fortuneTeller\n13.investigator\t14.liberian\t15.mayor\t16.monk\n17.ravenKeeper\t18.slayer\t19.soldier\t20.underTaker\t21.virgin\n22.wasberWoman");

        for(int i=0;i<playNumbers;i++)
        {
            int chooser=Integer.parseInt(input.nextLine())-1;
            death[chooser]=false;
            health[chooser]=true;
            if(chooser==6)
            {
                health[chooser]=false;
            }
            ID[i]=chooser;
        }
    }

    public static void switchCharacter(int id)//Replace the character (character ` Sid needs to be replaced, and the character ` s number after replacement)
    {
        Scanner input=new Scanner(System.in);
        System.out.print("1.lmp\t2.barons\t3.poisoner\t4.scarLetwoman\n5.spy\t6.butler\t7.drunk\t8.recluse\n9.saint\t10.cbef\t11.empath\t12.fortuneTeller\n13.investigator\t14.liberian\t15.mayor\t16.monk\n17.ravenKeeper\t18.slayer\t19.soldier\t20.underTaker\t21.virgin\n22.wasberWoman");
        int chooser=Integer.parseInt(input.nextLine());
        death[chooser]=false;
        health[chooser]=true;
        if(chooser==6)
        {
            health[chooser]=false;
        }
        ID[id]=chooser;
    }

    public static void poison(int id)//Poison
    {
        System.out.println("ID is"+ID[id]+"character is"+names[ID[id]]+"be Poison");
        health[ID[id]]=false;
    }

    public static void poisonOut(int id)//Detoxification
    {
        System.out.println("ID is"+ID[id]+"character is"+names[ID[id]]+"be Detoxification");
        health[ID[id]]=true;
    }

    public static void protect(int id)//protected
    {
        System.out.println("ID is"+ID[id]+"character is"+names[ID[id]]+"be protected");
        protection[ID[id]]=true;
    }

    public static void protectOut(int id)//out of protected
    {
        System.out.println("ID is"+ID[id]+"character is"+names[ID[id]]+"be out of protected");
        protection[ID[id]]=false;
    }

    public static void dead(int id)//Cause to die
    {
        System.out.println("ID is"+ID[id]+"character is"+names[ID[id]]+"be died");
        death[ID[id]]=true;
    }

    public static void vote()//vote
    {
        int[] vote=new int[playNumbers];
        Scanner input=new Scanner(System.in);
        for(int i=0;i<playNumbers;i++)
        {
            System.out.println("`````````````````````input Nominee's ID\n");
            int id=Integer.parseInt(input.nextLine());//nomination
            System.out.println(names[ID[id]]+"be Nomined");
            System.out.println("`````````````````````Whether to cancel the nomination of the nominated person, enter 1 to skip and enter 2 to continue voting\n");
            int counttt=Integer.parseInt(input.nextLine());
            if(counttt==1)
            {
                continue;
            }
            if(counttt==2)
            {

            }
            System.out.println("`````````````````````input vote\n");
            vote[i]=Integer.parseInt(input.nextLine());
            System.out.println("`````````````````````votes is\n"+vote[i]);
            System.out.println("`````````````````````Whether to end all voting, enter 1 to end, and enter 2 to continue voting\n");
            if(Integer.parseInt(input.nextLine())==1)
            {
                break;
            }
        }
        for(int i=0;i<playNumbers;i++)//Output voting results
        {
            if(vote[i]>0)
            {
                System.out.println("ID is"+ID[i]+"votes is"+vote[i]);
            }
        }
    }

    //Spy concealment
    public static void spyy()//
    {
        Scanner input=new Scanner(System.in);
        System.out.print("1.lmp\t2.barons\t3.poisoner\t4.scarLetwoman\n5.spy\t6.butler\t7.drunk\t8.recluse\n9.saint\t10.cbef\t11.empath\t12.fortuneTeller\n13.investigator\t14.liberian\t15.mayor\t16.monk\n17.ravenKeeper\t18.slayer\t19.soldier\t20.underTaker\t21.virgin\n22.wasberWoman");
        hide=Integer.parseInt(input.nextLine());
        System.out.println("Spy disguised as is"+names[hide]);
    }

    //recluse be  is的character
    public static void reclusee()//
    {
        Scanner input=new Scanner(System.in);
        System.out.print("1.lmp\t2.barons\t3.poisoner\t4.scarLetwoman\n5.spy\t6.butler\t7.drunk\t8.recluse\n9.saint\t10.cbef\t11.empath\t12.fortuneTeller\n13.investigator\t14.liberian\t15.mayor\t16.monk\n17.ravenKeeper\t18.slayer\t19.soldier\t20.underTaker\t21.virgin\n22.wasberWoman");
        outunderstand=Integer.parseInt(input.nextLine());
        System.out.println("recluse be wrong is"+names[outunderstand]);
    }

    //drunk  is like character
    public static void drunkk()//
    {
        Scanner input=new Scanner(System.in);
        System.out.print("1.lmp\t2.barons\t3.poisoner\t4.scarLetwoman\n5.spy\t6.butler\t7.drunk\t8.recluse\n9.saint\t10.cbef\t11.empath\t12.fortuneTeller\n13.investigator\t14.liberian\t15.mayor\t16.monk\n17.ravenKeeper\t18.slayer\t19.soldier\t20.underTaker\t21.virgin\n22.wasberWoman");
        fantasy=Integer.parseInt(input.nextLine());
        System.out.println("drunk think self is"+names[fantasy]);
    }

    //A thorn in the eye
    public static void hatee()
    {
        Scanner input=new Scanner(System.in);
        System.out.print("1.lmp\t2.barons\t3.poisoner\t4.scarLetwoman\n5.spy\t6.butler\t7.drunk\t8.recluse\n9.saint\t10.cbef\t11.empath\t12.fortuneTeller\n13.investigator\t14.liberian\t15.mayor\t16.monk\n17.ravenKeeper\t18.slayer\t19.soldier\t20.underTaker\t21.virgin\n22.wasberWoman");
        hatee=Integer.parseInt(input.nextLine());
        System.out.println("A thorn in the eye is"+names[hatee]);
    }

    //choose master
    public static void masterr()
    {
        Scanner input=new Scanner(System.in);
        System.out.print("1.lmp\t2.barons\t3.poisoner\t4.scarLetwoman\n5.spy\t6.butler\t7.drunk\t8.recluse\n9.saint\t10.cbef\t11.empath\t12.fortuneTeller\n13.investigator\t14.liberian\t15.mayor\t16.monk\n17.ravenKeeper\t18.slayer\t19.soldier\t20.underTaker\t21.virgin\n22.wasberWoman");
        master=Integer.parseInt(input.nextLine());
        System.out.println("servant`s master is"+names[master]);
    }


    public static void show()//Display ID status
    {
            Scanner input=new Scanner(System.in);
        boolean countt=true;
        while(countt==true){
            System.out.print("1.IDcharacter\t2.IDhealth\t3.IDdeath\t4.IDprotected\n5.IDcamp\t6.spy tp be\t7.drunk is\t8.recluse be  is\n9.A thorn in the eye\t10.servant`smaster\t11.exit\n");
            int count=Integer.parseInt(input.nextLine());
            if(count==1){for(int i=0;i<playNumbers;i++)
                {
                    System.out.println("ID"+i+"character is"+names[ID[i]]);
                }}
            if(count==2){for(int i=0;i<playNumbers;i++)
                {
                    System.out.println("ID"+i+"health is"+health[ID[i]]);
                }}
            if(count==3){for(int i=0;i<playNumbers;i++)
                {
                    System.out.println("ID"+i+"death is"+death[ID[i]]);
                }}
            if(count==4){for(int i=0;i<playNumbers;i++)
                {
                    System.out.println("ID"+i+"protected is"+protection[ID[i]]);
                }}
            if(count==5){for(int i=0;i<playNumbers;i++)
                {
                    System.out.println("ID"+i+"camp is"+camp[ID[i]]);
                }}
            if(count==6){System.out.println("hide is"+names[hide]);}
            if(count==7){System.out.println("drunk  is"+names[fantasy]);}
            if(count==8){System.out.println("recluse be  is"+names[outunderstand]);}
            if(count==9){System.out.println("A thorn in the eye is"+names[hatee]);}
            if(count==10){System.out.println("servant`s master is"+names[master]);}
            if(count==11){countt=false;}
        }
    }



    public static void main(String[] args)
    {

        //Initialization data
    names[0]="lmp";
    names[1]="barons";
    names[2]="poisoner";
    names[3]="scarLetwoman";
    names[4]="spy";
    names[5]="butler";
    names[6]="drunk";
    names[7]="recluse";
    names[8]="saint";
    names[9]="cbef";
    names[10]="empath";
    names[11]="fortuneTeller";
    names[12]="investigator";
    names[13]="liberian";
    names[14]="mayor";
    names[15]="monk";
    names[16]="ravenKeeper";
    names[17]="slayer";
    names[18]="soldier";
    names[19]="underTaker";
    names[20]="virgin";
    names[21]="wasberWoman";
    for(int i=0;i<22;i++)
    {
        health[i]=true;
    }
    health[6]=false;

    for(int i=0;i<22;i++)
    {
        death[i]=true;
    }

    for(int i=0;i<22;i++)
    {
        protection[i]=false;
    }

    for(int i=5;i<22;i++)
    {
        camp[i]="bad";
    }
    for(int i=0;i<5;i++)
    {
        camp[i]="good";
    }
    
        boolean end=true;
        while(end==true)
        {

            System.out.print("Please operate in order\n1.Enter the number of visitors\t2.Enter roles by ID\t3.Change role\t4.Do not apply health status\n5.Unserviceable health status\t6.do protected\t7.do out protected\t8.make death\n9.vote\t10.spy hide`s character\t11.recluse be is\t12.drunk is character\n13.A thorn in the eye\t14.choose master\t15show ID state\t16switch day night\n17all end\n");
            Scanner input=new Scanner(System.in);
            int count= Integer.parseInt(input.nextLine());
            if(count==1){getNumber();}
            if(count==2){chooseCharacter();}
            if(count==3){System.out.println("input change character`sID\n");
                switchCharacter(Integer.parseInt(input.nextLine()));}
            if(count==4){System.out.println("input to be unhealthcharacter`sID\n");
                poison(Integer.parseInt(input.nextLine()));}
            if(count==5){System.out.println("input to be healthcharacter`sID\n");
                poisonOut(Integer.parseInt(input.nextLine()));}
            if(count==6){System.out.println("input to be protectedcharacter`sID\n");
                protect(Integer.parseInt(input.nextLine()));}
            if(count==7){System.out.println("input to be out protectedcharacter`sID\n");
                protectOut(Integer.parseInt(input.nextLine()));}
            if(count==8){System.out.println("input to be deathcharacter`sID\n");
                dead(Integer.parseInt(input.nextLine()));}
            if(count==9){vote();}
            if(count==10){spyy();}
            if(count==11){reclusee();}
            if(count==12){drunkk();}
            if(count==13){hatee();}
            if(count==14){masterr();}
            if(count==15){show();}
            if(count==16){dayswitch();}
            if(count==17){end=false;}
              
            

               
            
        }
    }
    
}

    