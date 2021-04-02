package service;

import dao.AdDao;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

@Service
public class FileService {
    private final AdDao adDao;

    public FileService(AdDao adDao) {
        this.adDao = adDao;    }

    public byte[] toByte(InputStream is) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int reads = is.read() ;
        while(reads != -1){
            baos.write(reads);
            reads = is.read();
        }
        return baos.toByteArray();
    }


    public String getFileExtend(String filName){

             return   filName.substring(filName.lastIndexOf(".")+1);

    }

    public boolean checkFileExtend (String filName) {
        if ( (filName.substring(filName.lastIndexOf(".")) != "-1")
                || (filName.substring(filName.lastIndexOf(".")) != "0"))
    {

            return true;
        }
        return false;
    }


}
