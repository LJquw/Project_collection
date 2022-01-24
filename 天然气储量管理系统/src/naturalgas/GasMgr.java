package naturalgas;

import java.util.Scanner;
public class GasMgr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Gas dm=new Gas();          //����GasMgr����dm
		dm.initial();                    //����GasMgr��initial�������г�ʼ��
		dm.startMenu();                  //���ÿ�ʼ�˵����и������
	}

}

class Gas {
	
    class GasSet {
		private String[] gasname = new String[1000];//������
		private String[] gasregion = new String[1000];//����
		private String[] gastype = new String[1000];//��������
		private String[] gasdepth = new String[1000];//��������
		private double[] gasreserve = new double[1000];//����
	    
		public GasSet() {//�޲ι���
			
		}
		
	    public GasSet(String[] gasname,String[] gasregion,String[] gastype,String[] gasdepth,double[] fasreserve) {//�вι���
	    	this.gasname = gasname;
	    	this.gasregion = gasregion;
	    	this.gasregion = gasregion;
	    	this.gastype = gastype;
	    	this.gasreserve = gasreserve;
	    }
		
	    public String[] getGasname() {             //����gasnameֵ
			return gasname;
		}
		public void setGasname(String[] gasname) {//����gasnameֵ
			this.gasname = gasname;
		}
		public String[] getGasregion() {           //����gasregionֵ
			return gasregion;
		}
		public void setGasregion(String[] gasregion) {//����gasregionֵ
			this.gasregion = gasregion;
		}
		public String[] getGastype() {                 //����gastypeֵ
			return gastype;
		}
		public void setGastype(String[] gastype) {     //����gastypeֵ
			this.gastype = gastype;
		}
		public String[] getGasdepth() {                //����gasdepthֵ
			return gasdepth;
		}
		public void setGasdepth(String[] gasdepth) {   //����gasdepthֵ
			this.gasdepth = gasdepth;
		}
		public double[] getGasreserve() {              //����gasreserveֵ
			return gasreserve;
		}
		public void setGasreserve(double[] gasreserve) {//����gasreserveֵ
			this.gasreserve = gasreserve;
		}
	    
	    
	}

	GasSet naturagas=new GasSet();//�����������
	public void initial() {//��ʼ������
		naturagas.getGasname()[0]="�����";
		naturagas.getGasregion()[0]="�¸������";
		naturagas.getGastype()[0]="������";
		naturagas.getGasdepth()[0]="��ǳ����";
		naturagas.getGasreserve()[0]=5336.52;
		
		naturagas.getGasname()[1]="�չ�����";
		naturagas.getGasregion()[1]="�Ĵ����";
		naturagas.getGastype()[1]="ú����";
		naturagas.getGasdepth()[1]="ǳ����";
		naturagas.getGasreserve()[1]=3879.98;
		
		naturagas.getGasname()[2]="ɬ������";
		naturagas.getGasregion()[2]="���ľ���";
		naturagas.getGastype()[2]="������";
		naturagas.getGasdepth()[2]="��ǳ��";
		naturagas.getGasreserve()[2]=2879.92;
		
		naturagas.getGasname()[3]="��������";
		naturagas.getGasregion()[3]="�¸������";
		naturagas.getGastype()[3]="ҳ����";
		naturagas.getGasdepth()[3]="�����";
		naturagas.getGasreserve()[3]=7836.22;
		
		naturagas.getGasname()[4]="����2����";
		naturagas.getGasregion()[4]="����ľ���";
		naturagas.getGastype()[4]="������";
		naturagas.getGasdepth()[4]="ǳ����";
		naturagas.getGasreserve()[4]=3484.38;
		
		naturagas.getGasname()[5] = "��ţ��";
		naturagas.getGasregion()[5] = "�¸������";
		naturagas.getGastype()[5] = "������";
		naturagas.getGasdepth()[5] = "ǳ����";
		naturagas.getGasreserve()[5] = 5700.82;
	}
	
	public void startMenu() {//��ʼ�˵�
		System.out.println("��ӭʹ����Ȼ����������ϵͳ");
		System.out.println("--------------------------------");
		System.out.println("0. ��     ��");     
		System.out.println("1.������Ϣ");	 
		System.out.println("2.ɾ����Ϣ");
		System.out.println("3.��������ѯ");
		System.out.println("4.���������Ͳ�ѯ");
		System.out.println("5.���������Ͳ�ѯ");
		System.out.println("6.�ܴ���");
		System.out.print("---------------------------------\n");
		
		System.out.println("��ѡ��(0-6):");
		Scanner input = new Scanner(System.in);    //�õ�һ����׼����������������һ���µĻ����������Ķ���input
		int choice = input.nextInt();              //ʹ������������input������nextInt()��������һ��������choice��
		switch(choice) {                           //�ж���������ֽ��ж�Ӧ�Ĳ���
			case 0:	                                 
				System.out.println("\nллʹ�ã�");    //������Ϊ'0'ʱ���˳�����
				break;                              //������ǰѭ��
			case 1:			
				add();                             //������Ϊ'1'ʱ������add()�������ж�Ӧ����
				break;                             //������ǰѭ��
			case 2:
				delete();                          //������Ϊ'2'ʱ������delete()�������ж�Ӧ���� 
				break;                             //������ǰѭ��
			case 3:
				search_gasregion();                 //������Ϊ'3'ʱ������search_gasregion()�������ж�Ӧ����
				break;                              //������ǰѭ��
			case 4:
				search_gastype();                   //������Ϊ'4'ʱ������search_gastype()�������ж�Ӧ����
				break;                              //������ǰѭ��
			case 5:
				searth_gasdepth();                   //������Ϊ'5'ʱ������searth_gasdepth()�������ж�Ӧ����
				break;                               //������ǰѭ��
			case 6:
				sum_gasreserve();                     //������Ϊ'6'ʱ������sum_gasreserve()�������ж�Ӧ����
				break;                                 //������ǰѭ��
		}	
	}
	
	
	public void returnMain() {//���ز˵�
		Scanner input = new Scanner(System.in);  //�õ�һ����׼����������������һ���µĻ����������Ķ���input
		System.out.println("���� 0 ����: ");      //����0������ʾ
		if(input.nextInt() == 0) {           //��������choice��0������뿪ʼ�˵�
			startMenu();
		}else {                             //��������choice����0-6�����֣������������������ʾ������ֹ����
			System.out.println("�������, �쳣��ֹ��");
		}
	}
	
	public void add() {//���������Ϣ
		Scanner input = new Scanner(System.in);             //�õ�һ����׼����������������һ���µĻ����������Ķ���input
        for (int i = 6; i < naturagas.getGasname().length; i++) {  //i�ӵ�������ʼ��ӣ�һֱ��gasname[max]
            if (naturagas.getGasname()[i] == null) {             //���������������λ��Ϊ�գ��������²���
            	System.out.print("������������: ");
            	String gasname = input.next();                    //ʹ������������input������nextInt()��������һ��������gasname��
            	naturagas.getGasname()[i] = gasname;             //��i��������Ϊ�����gasname
                
                System.out.print("������������: ");
                String gasregion = input.next();                 
                naturagas.getGasregion()[i] = gasregion;         //��i��������Ϊ�����gasregion
                
                System.out.print("��������������: ");
                String gastype = input.next();
                naturagas.getGastype()[i] = gastype;             //��i����������Ϊ�����gastype
                
                System.out.print("��������������: ");
                String gasdepth = input.next();
                naturagas.getGasdepth()[i] = gasdepth;           //��i����������Ϊ�����gasdepth
                
                System.out.print("�����봢��(�ڷ�): ");
                double gasreserve =input.nextDouble();    //ʹ������������input������nextDouble()��������һ��˫����ʵ�͵�choice��
                naturagas.getGasreserve()[i] = gasreserve;        //��i������Ϊ�����gasreserve
                
                System.out.println("������"+gasname+"���ɹ���");
                break;                                         //������ǰѭ��
            }
        }
        
		System.out.println("**************************");
	   	returnMain();                                         //����returnMain()����
	}
	
	public void delete() {//ɾ��������Ϣ
		System.out.println("������Ҫɾ������������: ");
		Scanner input = new Scanner(System.in);
		String gasname = input.next();                //ʹ������������input������nextInt()��������һ��������gasname��
		boolean flag=false;//��ʾɾ���ɹ����
		
		for(int i=0;i<naturagas.getGasname().length;i++) {
			if(naturagas.getGasname()[i].equals(gasname)){	//���ɾ�����������ǳ�ʼ����Ϣ������ڵģ��������²���
				flag=true;                                  //��ʾ����ɾ��
				int j=i;
      			for(j=i;j<naturagas.getGasname().length-1;j++) { //ͨ���������ع�����
      				naturagas.getGasname()[j] = naturagas.getGasname()[j+1];//�޸�ɾ��Ԫ��gasname���±�
      				naturagas.getGasregion()[j] = naturagas.getGasregion()[j+1];
      				naturagas.getGastype()[j] = naturagas.getGastype()[j+1];
      				naturagas.getGasdepth()[j] = naturagas.getGasdepth()[j+1];
      				naturagas.getGasreserve()[j] = naturagas.getGasreserve()[j+1];
      			}
      			naturagas.getGasname()[j]=null;//��ɾ��Ԫ���±�λ�õ�ֵ��Ϊ��,����ͬ��
      			naturagas.getGasregion()[j]=null;
      			naturagas.getGastype()[j]=null;
      			naturagas.getGasdepth()[j]=null;
      			naturagas.getGasreserve()[j]=0;
      			
      			System.out.println("ɾ����"+gasname+"���ɹ�");              //ɾ���ɹ���ʾ
      			break;                                                //����ѭ��
			}
		}
		if (!flag) {                                                 //�������������ڳ�ʼ���в����ҵ�������ִ��ɾ������
            System.out.println("û���ҵ�ƥ����Ϣ��");
        }
		System.out.println("**************************");
		returnMain();                                             //����returnMain()����
	}
	
	public void search_gasregion(){//����������ѯ��Ȼ����Ϣ
		System.out.println("����������������: ");       //��ʾ������������
		Scanner input = new Scanner(System.in);
		String gasregion = input.next();            //�����µ���������
		System.out.println("������         ����         ��������         ��������        ����");
        for (int i = 0; naturagas.getGasregion()[i] != null; i++) {       //�����i��λ�õ�������Ϊ�գ�ִ�����²���
            if (naturagas.getGasregion()[i].equals(gasregion)) {         //�������������ڳ�ʼ����Ϣ���ܹ���ѯ������ִ�����²���
            	//���������ѯ��������Ϣ
                System.out.println(naturagas.getGasname()[i] + "    " + naturagas.getGasregion()[i] + "    " + naturagas.getGastype()[i] + "    " + naturagas.getGasdepth()[i] + "    " + naturagas.getGasreserve()[i]);
            }
        }
        System.out.println("**************************");
		returnMain();
	}
	
	public void search_gastype() {//�����������Ͳ�ѯ�����ʹ�����Ϣ
		String[] gasregion1 = new String[4];          //����һ������Ϊ4������gasregion1
		gasregion1[0] = "����ľ���";                    //��gasregion1������и�ֵ
		gasregion1[1] = "�Ĵ����";
		gasregion1[2] = "���ľ���";
		gasregion1[3] = "�¸������";
        double[] sum = new double[4];                //����һ������Ϊ4������sum,�洢���������Ĵ�����Ϣ
        double gas_sum=0;                            //����һ��double�ͱ���gas_sum,��ʾ�ܴ���
		
		System.out.println("��������������: ");
		Scanner input = new Scanner(System.in);
		String gastype = input.next();
		
		for (int i = 0; naturagas.getGastype()[i] != null; i++) {
            if (naturagas.getGastype()[i].equals(gastype)) {     //�������������������ڳ�ʼ����ƥ�䵽��ִ�����²���
                for (int j = 0; j < gasregion1.length; j++) {     
                    if(gasregion1[j].equals(naturagas.getGasregion()[i])){    //���gasregion1�еĵ�j������������naturages�е�gasregion��ͬ��ִ�����²���
                        sum[j]=sum[j]+naturagas.getGasreserve()[i];           //�õ�������������Ȼ������
                    }
                }
            }
        }

        System.out.println("����       ����");       
        for (int i = 0; i < gasregion1.length; i++) {
            if ( gasregion1[i] != null) {     //�����i��gasregion1��ֵ��Ϊ��
            	gas_sum+=sum[i];              //��������������ܴ���
                System.out.println(gasregion1[i] + "    " + sum[i]);   //�ֱ�������������Լ����������ķֱ��ܴ���
            }

        }
        
        System.out.println("�й�"+gastype+"�ܴ���: "+gas_sum+"�ڷ�");     //�õ�ÿ�������������ܵĴ���
        
        System.out.println("**************************");
		returnMain();
	}
	
	public void searth_gasdepth() {//�����������Ͳ�ѯ�����ʹ�����Ϣ
		String[] gasregion1 = new String[4];              //����һ������Ϊ4������gasregion1
		gasregion1[0] = "����ľ���";                        //��gasregion1������и�ֵ
		gasregion1[1] = "�Ĵ����";
		gasregion1[2] = "���ľ���";
		gasregion1[3] = "�¸������";
        double[] sum = new double[4];                     //����һ��double�ͱ���gas_sum,��ʾ�ܴ���
        double gas_sum=0;                                 //����һ��double�ͱ���gas_sum,��ʾ�ܴ���
		
		System.out.println("��������������: ");
		Scanner input = new Scanner(System.in);
		String gasdepth = input.next();
		
		for (int i = 0; naturagas.getGastype()[i] != null; i++) {
            if (naturagas.getGasdepth()[i].equals(gasdepth)) {     //�������������������ڳ�ʼ����ƥ�䵽��ִ�����²���
                for (int j = 0; j < gasregion1.length; j++) {      
                    if(gasregion1[j].equals(naturagas.getGasregion()[i])){   //���gasregion1�еĵ�j������������naturages�е�gasregion��ͬ��ִ�����²���
                        sum[j]=sum[j]+naturagas.getGasreserve()[i];     //�õ�������������Ȼ������
                    }
                }
            }
        }

        System.out.println("����       ����");
        for (int i = 0; i < gasregion1.length; i++) {
            if ( gasregion1[i] != null) {             //�����i��gasregion1��ֵ��Ϊ��
            	gas_sum+=sum[i];                      //��������������ܴ���
                System.out.println(gasregion1[i] + "    " + sum[i]);          //�ֱ�������������Լ����������ķֱ��ܴ���
            }

        }
   
        System.out.println("�й�"+gasdepth+"�ܴ���: "+gas_sum+"�ڷ�");           //�õ�ÿ�������������ܵĴ���
        
        System.out.println("**************************");
		returnMain();
	}
	
	public void sum_gasreserve() {//�����ܵ���Ȼ������
	
        double sumgas = 0;            //����һ��double�ͱ���sumgas�����й��ܵ���Ȼ������
        for (int temp = 0; temp < naturagas.getGasname().length; temp++) {
            if (naturagas.getGasname()[temp] != null) {   
                sumgas = sumgas + naturagas.getGasreserve()[temp];
            }
        }
        System.out.println("�й���Ȼ���ܴ���: "+sumgas+"�ڷ�");
        System.out.println("**************************");
	   	returnMain();
	}
	
	
}
