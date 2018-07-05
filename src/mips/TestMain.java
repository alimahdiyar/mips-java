package mips;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestMain {

    public static void main(String[] args) throws IOException {



        byte[] b = new byte[8];
        b[0] = 0x00;
        b[1] = 0x00;
        b[2] = 0x00;
        b[3] = 0x00;
        b[4] = (byte) 0xFC;
        b[5] = 0x00;
        b[6] = 0x00;
        b[7] = 0x00;

        //00000001 00101010 01000000 00100000
        //2 50 64 32
        FileOutputStream output = new FileOutputStream("/home/alideb/Desktop/mipsjava/out/production/mipsjava/mips/test.txt");
        output.write(b);
        output.close();
        // create a new input stream
        FileInputStream input = new FileInputStream("/home/alideb/Desktop/mipsjava/out/production/mipsjava/mips/test.txt");

        // create a place to store the words we read in

        // read in the data in the given file

        b = new byte[4];
        while (input.read(b) != -1) {
            for (byte bi: b){
                System.out.println(bi);
            }
            // create a word from the 4 bytes
            long word = getUnsignedValue(b[0]);
            word += getUnsignedValue(b[1]) << 8;
            word += getUnsignedValue(b[2]) << 16;
            word += getUnsignedValue(b[3]) << 24;

            // add the word to our memory store
            System.out.println(Long.toBinaryString(word));
        }

    }

    public static long getUnsignedValue(byte b) {
        if (b >= 0) { return b; }

        return 256 + b;
    }
}
