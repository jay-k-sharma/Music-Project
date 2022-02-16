import org.firmata4j.firmata.FirmataDevice;
import org.firmata4j.IODevice;
import org.firmata4j.Pin;
import org.firmata4j.ssd1306.SSD1306;
import org.firmata4j.I2CDevice;

import java.util.Timer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String myPort = "/dev/cu.usbserial-0001";
        IODevice myBoard = new FirmataDevice(myPort);
        Scanner scannerObject = new Scanner(System.in);

        try {
            myBoard.start();
            myBoard.ensureInitializationIsDone();

            I2CDevice i2cObject = myBoard.getI2CDevice((byte) 0x3C);
            SSD1306 oledObject = new SSD1306(i2cObject, SSD1306.Size.SSD1306_128_64);
            oledObject.init();

            Pin buttonObject = myBoard.getPin(6);
            buttonObject.setMode(Pin.Mode.INPUT);

            Pin potObject = myBoard.getPin(14);
            potObject.setMode(Pin.Mode.ANALOG);

            Pin soundObject = myBoard.getPin(16);
            soundObject.setMode(Pin.Mode.ANALOG);

            Timer timerObject = new Timer();

            while(true) {
                System.out.println("Returned");
                System.out.print("Select Mode: \n-Piano\n-Musical Ear\n-Listen\nMode: ");
                String userMode = scannerObject.nextLine();

                if(userMode.equals("Listen")) {
                    System.out.println("Accessed Listen");


                } else {
                    System.out.println("Not valid");
                }
            }
        } catch(Exception ex) {
            System.out.println("Error!");
        }
    }
}
