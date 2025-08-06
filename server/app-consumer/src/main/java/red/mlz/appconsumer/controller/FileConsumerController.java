package red.mlz.appconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import red.mlz.appconsumer.client.FileServiceFeign;

@RestController
public class FileConsumerController {

    @Autowired
    private FileServiceFeign fileServiceFeign;

    @RequestMapping(value = "/upload_file")
    public String uploadFile(@RequestPart("file") MultipartFile file) {
        return fileServiceFeign.uploadFile(file);
    }
}