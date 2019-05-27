import com.fazecast.jSerialComm.*;

public class RFID {

    public static int packetSize = 8; //packet size in bytes

    //searches for and opens the right serial comm
    public static void comPortConnection(){

        int len = SerialPort.getCommPorts().length;
        String arduinoPortDescriptiveName = "USB-SERIAL CH340";
        SerialPort arduinoPort = null;
        SerialPort[] serialPorts = new SerialPort[len];

        serialPorts = SerialPort.getCommPorts();

        for(int i = 0; i < len; i++){
            String tmpPortDescriptiveName = serialPorts[i].getDescriptivePortName();
            if(tmpPortDescriptiveName.contains(arduinoPortDescriptiveName)){
                arduinoPort = serialPorts[i];
                arduinoPort.openPort();
                System.out.println("connected to: " + arduinoPort.getDescriptivePortName());
            }
        }

        PacketListener listener = new PacketListener();
        arduinoPort.addDataListener(listener);

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        GUI gui = new GUI();
        comPortConnection();
        DB db = new DB();
        //DataBank db = new DataBank();
    }
}