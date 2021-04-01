package controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import data.Ad;
import enums.RequestParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import service.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UploadController{
    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    public String startUpload(Model model) {
        model.addAttribute("ads", adService.getAll());

        return "upload";
    }

    private final AdService adService;
    private final CityService cityService;
    private final MessageService messageService;
    private final RubricService rubricService;
    private final FileService fileService;

    @Autowired
    public UploadController(AdService adService, CityService cityService,
                            MessageService messageService, RubricService rubricService,
                            FileService fileService) {
        this.adService = adService;
        this.cityService = cityService;
        this.messageService = messageService;
        this.rubricService = rubricService;
        this.fileService = fileService;
    }


    // Handler Method for file upload
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String uploadFile(
            HttpServletResponse resp, HttpServletRequest req,
            @RequestParam("file") MultipartFile file,
            @RequestParam("idAd") String id,
            Model model) {
        Ad ad = adService.getById(id);
       // Ad ad = adService.getById(req.getParameter(RequestParameter.IDAD.getValue()));
        String msg= "";
        if(!file.isEmpty()) {
            BufferedOutputStream bos =null;
            try {

                byte[] fileBytes = file.getBytes();
                ad.setClobfield(fileBytes);
                adService.update(ad);
                //adService.updateImg(id,fileBytes);
                //
                // location to save the file
                //String fileName = "G:\\Test\\"+file.getOriginalFilename();
               // bos = new BufferedOutputStream(new FileOutputStream(new File(fileName)));
               // bos.write(fileBytes);
                msg = "Upload successful for " + file.getName();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }finally {
                if(bos != null) {
                    try {
                        bos.close();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }else {
            msg = "Upload failed for " + file.getName() + " as file is empty";
        }
        model.addAttribute("message", msg);
        model.addAttribute("file", file);
        model.addAttribute("idAd",id);
        return "upload";
    }

}