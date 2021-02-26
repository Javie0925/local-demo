package pri.jv.channeldemo;

import com.sun.xml.internal.ws.util.ByteArrayBuffer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;

/**
 * @ClassName Demo
 * @Dscription
 * @Date 2020/8/7
 * @Author JV
 **/
public class Demo {

    public static void main(String[] args) throws Exception {
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        RandomAccessFile from = new RandomAccessFile("/Users/qudian/Desktop/from.txt", "rw");
        RandomAccessFile to = new RandomAccessFile("/Users/qudian/Desktop/to.txt", "rw");
        FileChannel fromChannel = from.getChannel();
        FileChannel toChannel = to.getChannel();
        long size = fromChannel.size();
        fromChannel.transferTo(0,size,fromChannel);
//        Thread.sleep(1000L);
        toChannel.transferFrom(fromChannel,0,fromChannel.size());
    }
}
