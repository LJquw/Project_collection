package naturalgas;

import java.util.Scanner;
public class GasMgr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gas dm=new Gas();          //创建GasMgr对象dm
		dm.initial();                    //调用GasMgr的initial方法进行初始化
		dm.startMenu();                  //调用开始菜单进行各项操作
	}

}

class Gas {
	
    class GasSet {
		private String[] gasname = new String[1000];//气田名
		private String[] gasregion = new String[1000];//气区
		private String[] gastype = new String[1000];//气藏类型
		private String[] gasdepth = new String[1000];//埋深类型
		private double[] gasreserve = new double[1000];//储量
	    
		public GasSet() {//无参构造
			
		}
		
	    public GasSet(String[] gasname,String[] gasregion,String[] gastype,String[] gasdepth,double[] fasreserve) {//有参构造
	    	this.gasname = gasname;
	    	this.gasregion = gasregion;
	    	this.gasregion = gasregion;
	    	this.gastype = gastype;
	    	this.gasreserve = gasreserve;
	    }
		
	    public String[] getGasname() {             //返回gasname值
			return gasname;
		}
		public void setGasname(String[] gasname) {//设置gasname值
			this.gasname = gasname;
		}
		public String[] getGasregion() {           //返回gasregion值
			return gasregion;
		}
		public void setGasregion(String[] gasregion) {//返回gasregion值
			this.gasregion = gasregion;
		}
		public String[] getGastype() {                 //返回gastype值
			return gastype;
		}
		public void setGastype(String[] gastype) {     //返回gastype值
			this.gastype = gastype;
		}
		public String[] getGasdepth() {                //返回gasdepth值
			return gasdepth;
		}
		public void setGasdepth(String[] gasdepth) {   //返回gasdepth值
			this.gasdepth = gasdepth;
		}
		public double[] getGasreserve() {              //返回gasreserve值
			return gasreserve;
		}
		public void setGasreserve(double[] gasreserve) {//返回gasreserve值
			this.gasreserve = gasreserve;
		}
	    
	    
	}

	GasSet naturagas=new GasSet();//创建气田对象
	public void initial() {//初始化气区
		naturagas.getGasname()[0]="苏里格";
		naturagas.getGasregion()[0]="陕甘宁盆地";
		naturagas.getGastype()[0]="常规气";
		naturagas.getGasdepth()[0]="中浅层气";
		naturagas.getGasreserve()[0]=5336.52;
		
		naturagas.getGasname()[1]="普光气田";
		naturagas.getGasregion()[1]="四川盆地";
		naturagas.getGastype()[1]="煤层气";
		naturagas.getGasdepth()[1]="浅层气";
		naturagas.getGasreserve()[1]=3879.98;
		
		naturagas.getGasname()[2]="涩北气田";
		naturagas.getGasregion()[2]="柴达木盆地";
		naturagas.getGastype()[2]="常规气";
		naturagas.getGasdepth()[2]="中浅气";
		naturagas.getGasreserve()[2]=2879.92;
		
		naturagas.getGasname()[3]="靖边气田";
		naturagas.getGasregion()[3]="陕甘宁盆地";
		naturagas.getGastype()[3]="页岩气";
		naturagas.getGasdepth()[3]="深层气";
		naturagas.getGasreserve()[3]=7836.22;
		
		naturagas.getGasname()[4]="克拉2气田";
		naturagas.getGasregion()[4]="塔里木盆地";
		naturagas.getGastype()[4]="致密气";
		naturagas.getGasdepth()[4]="浅层气";
		naturagas.getGasreserve()[4]=3484.38;
		
		naturagas.getGasname()[5] = "大牛地";
		naturagas.getGasregion()[5] = "陕甘宁盆地";
		naturagas.getGastype()[5] = "常规气";
		naturagas.getGasdepth()[5] = "浅层气";
		naturagas.getGasreserve()[5] = 5700.82;
	}
	
	public void startMenu() {//开始菜单
		System.out.println("欢迎使用天然气储量管理系统");
		System.out.println("--------------------------------");
		System.out.println("0. 退     出");     
		System.out.println("1.新增信息");	 
		System.out.println("2.删除信息");
		System.out.println("3.按气区查询");
		System.out.println("4.按气藏类型查询");
		System.out.println("5.按埋深类型查询");
		System.out.println("6.总储量");
		System.out.print("---------------------------------\n");
		
		System.out.println("请选择(0-6):");
		Scanner input = new Scanner(System.in);    //得到一个标准的数据流，并创建一个新的基于输入流的对象input
		int choice = input.nextInt();              //使用输入流对象input，调用nextInt()方法输入一个整数到choice中
		switch(choice) {                           //判断输入的数字进行对应的操作
			case 0:	                                 
				System.out.println("\n谢谢使用！");    //若输入为'0'时，退出操作
				break;                              //跳出当前循环
			case 1:			
				add();                             //若输入为'1'时，进入add()方法进行对应操作
				break;                             //跳出当前循环
			case 2:
				delete();                          //若输入为'2'时，进入delete()方法进行对应操作 
				break;                             //跳出当前循环
			case 3:
				search_gasregion();                 //若输入为'3'时，进入search_gasregion()方法进行对应操作
				break;                              //跳出当前循环
			case 4:
				search_gastype();                   //若输入为'4'时，进入search_gastype()方法进行对应操作
				break;                              //跳出当前循环
			case 5:
				searth_gasdepth();                   //若输入为'5'时，进入searth_gasdepth()方法进行对应操作
				break;                               //跳出当前循环
			case 6:
				sum_gasreserve();                     //若输入为'6'时，进入sum_gasreserve()方法进行对应操作
				break;                                 //跳出当前循环
		}	
	}
	
	
	public void returnMain() {//返回菜单
		Scanner input = new Scanner(System.in);  //得到一个标准的数据流，并创建一个新的基于输入流的对象input
		System.out.println("输入 0 返回: ");      //输入0返回提示
		if(input.nextInt() == 0) {           //如果输入的choice是0，则进入开始菜单
			startMenu();
		}else {                             //如果输入的choice不是0-6的数字，将会出现输入错误的提示，并终止运行
			System.out.println("输入错误, 异常终止！");
		}
	}
	
	public void add() {//添加气田信息
		Scanner input = new Scanner(System.in);             //得到一个标准的数据流，并创建一个新的基于输入流的对象input
        for (int i = 6; i < naturagas.getGasname().length; i++) {  //i从第六个开始添加，一直到gasname[max]
            if (naturagas.getGasname()[i] == null) {             //如果输入气田名的位置为空，进行以下操作
            	System.out.print("请输入气田名: ");
            	String gasname = input.next();                    //使用输入流对象input，调用nextInt()方法输入一个整数到gasname中
            	naturagas.getGasname()[i] = gasname;             //第i个气田名为输入的gasname
                
                System.out.print("请输入气区名: ");
                String gasregion = input.next();                 
                naturagas.getGasregion()[i] = gasregion;         //第i个气区名为输入的gasregion
                
                System.out.print("请输入气藏类型: ");
                String gastype = input.next();
                naturagas.getGastype()[i] = gastype;             //第i个气藏类型为输入的gastype
                
                System.out.print("请输入埋深类型: ");
                String gasdepth = input.next();
                naturagas.getGasdepth()[i] = gasdepth;           //第i个埋深类型为输入的gasdepth
                
                System.out.print("请输入储量(亿方): ");
                double gasreserve =input.nextDouble();    //使用输入流对象input，调用nextDouble()方法输入一个双精度实型到choice中
                naturagas.getGasreserve()[i] = gasreserve;        //第i个储量为输入的gasreserve
                
                System.out.println("新增“"+gasname+"”成功！");
                break;                                         //跳出当前循环
            }
        }
        
		System.out.println("**************************");
	   	returnMain();                                         //调用returnMain()方法
	}
	
	public void delete() {//删除气田信息
		System.out.println("请输入要删除的气田名字: ");
		Scanner input = new Scanner(System.in);
		String gasname = input.next();                //使用输入流对象input，调用nextInt()方法输入一个整数到gasname中
		boolean flag=false;//表示删除成功与否
		
		for(int i=0;i<naturagas.getGasname().length;i++) {
			if(naturagas.getGasname()[i].equals(gasname)){	//如果删除的气田名是初始化信息里面存在的，进行以下操作
				flag=true;                                  //表示可以删除
				int j=i;
      			for(j=i;j<naturagas.getGasname().length-1;j++) { //通过遍历，重构数组
      				naturagas.getGasname()[j] = naturagas.getGasname()[j+1];//修改删除元素gasname的下标
      				naturagas.getGasregion()[j] = naturagas.getGasregion()[j+1];
      				naturagas.getGastype()[j] = naturagas.getGastype()[j+1];
      				naturagas.getGasdepth()[j] = naturagas.getGasdepth()[j+1];
      				naturagas.getGasreserve()[j] = naturagas.getGasreserve()[j+1];
      			}
      			naturagas.getGasname()[j]=null;//将删除元素下标位置的值置为空,以下同理
      			naturagas.getGasregion()[j]=null;
      			naturagas.getGastype()[j]=null;
      			naturagas.getGasdepth()[j]=null;
      			naturagas.getGasreserve()[j]=0;
      			
      			System.out.println("删除“"+gasname+"”成功");              //删除成功提示
      			break;                                                //跳出循环
			}
		}
		if (!flag) {                                                 //如果输入的气田在初始化中不能找到，则不能执行删除操作
            System.out.println("没有找到匹配信息！");
        }
		System.out.println("**************************");
		returnMain();                                             //调用returnMain()方法
	}
	
	public void search_gasregion(){//根据气区查询天然气信息
		System.out.println("请输入气区的名字: ");       //提示输入气区名字
		Scanner input = new Scanner(System.in);
		String gasregion = input.next();            //创建新的气区对象
		System.out.println("气田名         气区         气藏类型         埋深类型        储量");
        for (int i = 0; naturagas.getGasregion()[i] != null; i++) {       //如果第i个位置的气区不为空，执行以下操作
            if (naturagas.getGasregion()[i].equals(gasregion)) {         //如果输入的气区在初始化信息中能够查询到，则执行以下操作
            	//依次输出查询气区的信息
                System.out.println(naturagas.getGasname()[i] + "    " + naturagas.getGasregion()[i] + "    " + naturagas.getGastype()[i] + "    " + naturagas.getGasdepth()[i] + "    " + naturagas.getGasreserve()[i]);
            }
        }
        System.out.println("**************************");
		returnMain();
	}
	
	public void search_gastype() {//根据气藏类型查询气区和储量信息
		String[] gasregion1 = new String[4];          //定义一个长度为4的数组gasregion1
		gasregion1[0] = "塔里木盆地";                    //对gasregion1数组进行赋值
		gasregion1[1] = "四川盆地";
		gasregion1[2] = "柴达木盆地";
		gasregion1[3] = "陕甘宁盆地";
        double[] sum = new double[4];                //定义一个长度为4的数组sum,存储各个气区的储量信息
        double gas_sum=0;                            //定义一个double型变量gas_sum,表示总储量
		
		System.out.println("请输入气藏类型: ");
		Scanner input = new Scanner(System.in);
		String gastype = input.next();
		
		for (int i = 0; naturagas.getGastype()[i] != null; i++) {
            if (naturagas.getGastype()[i].equals(gastype)) {     //如果输入的气藏类型能在初始化中匹配到，执行以下操作
                for (int j = 0; j < gasregion1.length; j++) {     
                    if(gasregion1[j].equals(naturagas.getGasregion()[i])){    //如果gasregion1中的第j个气藏类型与naturages中的gasregion相同，执行以下操作
                        sum[j]=sum[j]+naturagas.getGasreserve()[i];           //得到各个气区的天然气储量
                    }
                }
            }
        }

        System.out.println("气区       储量");       
        for (int i = 0; i < gasregion1.length; i++) {
            if ( gasregion1[i] != null) {     //如果第i个gasregion1的值不为空
            	gas_sum+=sum[i];              //计算各个气区的总储量
                System.out.println(gasregion1[i] + "    " + sum[i]);   //分别输出气藏类型以及各个气区的分别总储量
            }

        }
        
        System.out.println("中国"+gastype+"总储量: "+gas_sum+"亿方");     //得到每个气区加起来总的储量
        
        System.out.println("**************************");
		returnMain();
	}
	
	public void searth_gasdepth() {//根据埋深类型查询气区和储量信息
		String[] gasregion1 = new String[4];              //定义一个长度为4的数组gasregion1
		gasregion1[0] = "塔里木盆地";                        //对gasregion1数组进行赋值
		gasregion1[1] = "四川盆地";
		gasregion1[2] = "柴达木盆地";
		gasregion1[3] = "陕甘宁盆地";
        double[] sum = new double[4];                     //定义一个double型变量gas_sum,表示总储量
        double gas_sum=0;                                 //定义一个double型变量gas_sum,表示总储量
		
		System.out.println("请输入埋深类型: ");
		Scanner input = new Scanner(System.in);
		String gasdepth = input.next();
		
		for (int i = 0; naturagas.getGastype()[i] != null; i++) {
            if (naturagas.getGasdepth()[i].equals(gasdepth)) {     //如果输入的气藏类型能在初始化中匹配到，执行以下操作
                for (int j = 0; j < gasregion1.length; j++) {      
                    if(gasregion1[j].equals(naturagas.getGasregion()[i])){   //如果gasregion1中的第j个气藏类型与naturages中的gasregion相同，执行以下操作
                        sum[j]=sum[j]+naturagas.getGasreserve()[i];     //得到各个气区的天然气储量
                    }
                }
            }
        }

        System.out.println("气区       储量");
        for (int i = 0; i < gasregion1.length; i++) {
            if ( gasregion1[i] != null) {             //如果第i个gasregion1的值不为空
            	gas_sum+=sum[i];                      //计算各个气区的总储量
                System.out.println(gasregion1[i] + "    " + sum[i]);          //分别输出深埋类型以及各个气区的分别总储量
            }

        }
   
        System.out.println("中国"+gasdepth+"总储量: "+gas_sum+"亿方");           //得到每个气区加起来总的储量
        
        System.out.println("**************************");
		returnMain();
	}
	
	public void sum_gasreserve() {//计算总的天然气储量
	
        double sumgas = 0;            //定义一个double型变量sumgas计算中国总的天然气储量
        for (int temp = 0; temp < naturagas.getGasname().length; temp++) {
            if (naturagas.getGasname()[temp] != null) {   
                sumgas = sumgas + naturagas.getGasreserve()[temp];
            }
        }
        System.out.println("中国天然气总储量: "+sumgas+"亿方");
        System.out.println("**************************");
	   	returnMain();
	}
	
	
}
