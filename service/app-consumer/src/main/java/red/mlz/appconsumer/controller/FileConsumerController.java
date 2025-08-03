package red.mlz.appconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import red.mlz.appconsumer.client.FileServiceClient;
import red.mlz.module.utils.Response;

@RestController
public class FileConsumerController {

    @Autowired
    private FileServiceClient fileServiceClient;

    @RequestMapping(value = "/upload_file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Response uploadFile(@RequestPart("file") MultipartFile file) {
        return fileServiceClient.uploadFile(file);
    }
}