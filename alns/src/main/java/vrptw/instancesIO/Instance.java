package vrptw.instancesIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by LiuCui on 2020/12/7
 */
public class Instance {
    private int[] vehicleInfo;
    private int[][] customerInfo;
    private String name;
    private String type;
    private Random r;
    private List<Node> customers;
    private int vehicleNr;   // 货车
    private int vehicleCapacity;
    private double[][] distanceMatrix;
    private int numberOfNodes;   // 节点数量

    public Random getRandom() {
        return this.r;
    }

    public void setR(Random r) {
        this.r = r;
    }

    public List<Node> getCustomers() {
        return new ArrayList(this.customers);
    }

    public double[][] getDistanceMatrix() {
        return this.distanceMatrix;
    }

    public int getVehicleNr() {
        return this.vehicleNr;
    }

    public void setVehicleNr(int nr) {
        this.vehicleNr = nr;
    }

    public int getVehicleCapacity() {
        return this.vehicleCapacity;
    }

    public int getCustomerNr() {
        return this.vehicleNr;
    }

    public int[] getVehicleInfo() {
        return this.vehicleInfo;
    }

    public int[][] getCustomerInfo() {
        return this.customerInfo;
    }

    public String getName() {
        return this.name;
    }

    public Instance(int size, String name, String instanceType) throws IOException {
        this.name = name;
        this.type = instanceType;
        this.importVehicleData(size, name);
        this.customers = new ArrayList<Node>();
        this.importCustomersData(size, name);
        this.distanceMatrix = new double[size + 5][size + 5];
        this.createDistanceMatrix();
        this.r = new Random();
        this.r.setSeed(-1L);


    }

    private void importCustomersData(int size, String name) throws IOException {
        String dataFileName = "";
        if (this.type.equals("Homberger")) {
            dataFileName = "C:\\Users\\15301\\Desktop\\ALNS\\alns\\src\\main\\resources\\homberger\\homberger_" + size + "/" + name + ".txt";
        } else if (this.type.equals("Solomon")) {
            dataFileName = "C:\\Users\\15301\\Desktop\\ALNS\\alns\\src\\main\\resources\\solomon\\solomon_" + size + "/" + name + ".txt";
        }

        BufferedReader bReader = new BufferedReader(new FileReader(dataFileName));

        String line;
        for(int data_in_x_lines = 2147483647; (line = bReader.readLine())!=null; --data_in_x_lines){
            String[] datavalue = line.split("\\s+");
            if(datavalue.length > 0 && datavalue[0].equals("CUST")){
                data_in_x_lines = 2;
            }
            if(datavalue.length > 0 && data_in_x_lines < 1){
                Node customer = new Node();
                customer.setId(Integer.parseInt(datavalue[1]));
                customer.setX(Double.parseDouble(datavalue[2]));
                customer.setY(Double.parseDouble(datavalue[3]));
                customer.setDemand(Double.parseDouble(datavalue[4]));
                customer.setTimeWindows(Double.parseDouble(datavalue[5]), Double.parseDouble(datavalue[6]));
                customer.setServiceTime(Double.parseDouble(datavalue[7]));
                this.customers.add(customer);
            }
        }
        bReader.close();
        this.numberOfNodes=this.customers.size();
        System.out.println("Input customers success !");
    }
    // C:\Users\15301\Desktop\ALNS\alns\src\main\resources\homberger\homberger_400\C1_4_2.TXT
    private void importVehicleData(int size, String name) throws IOException {
        String dataFileName = "";
        if (this.type.equals("Homberger")) {
            dataFileName = "C:\\Users\\15301\\Desktop\\ALNS\\alns\\src\\main\\resources\\homberger\\homberger_" + size + "/" + name + ".txt";
        } else if (this.type.equals("Solomon")) {
            dataFileName = "C:\\Users\\15301\\Desktop\\ALNS\\alns\\src\\main\\resources\\solomon\\solomon_" + size + "/" + name + ".txt";
        }
        BufferedReader bReader = new BufferedReader(new FileReader(dataFileName));

        String line;
        for(int row=0; (line=bReader.readLine())!=null; ++row){
            String[] datavalue = line.split("\\s+");
            if(row==4){
                this.vehicleNr = Integer.valueOf(datavalue[1]);
                this.vehicleCapacity = Integer.valueOf(datavalue[2]);
                break;
            }
        }

        bReader.close();
        System.out.println("Input customers success !");
    }

    private void createDistanceMatrix() {
        for (int i = 0; i < this.numberOfNodes; ++i) {
            Node n1 = (Node)this.customers.get(i);
            for (int j = 0; j < this.numberOfNodes; ++j) {
                Node n2 = (Node)this.customers.get(j);
                this.distanceMatrix[i][j] = (double) Math.round(Math.sqrt(Math.pow(n1.getX()- n2.getX(),2.0D)+ Math.pow(n1.getY()-n2.getY(),2.0D)) *100.0D)/100.0D;
            }
        }

    }

    /** 算例 读取
     * @param args
     * @throws IOException
     */
/*    public static void main(String[] args) throws IOException {
        int size = 100;
        String name = "C208";
        String instanceType = "Solomon";
        Instance instance = new Instance(size, name, instanceType);

        instance.createDistanceMatrix();
        System.out.println(instance.distanceMatrix[1][2]);
    }*/

}
