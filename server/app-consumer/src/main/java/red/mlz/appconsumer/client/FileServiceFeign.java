package red.mlz.appconsumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import red.mlz.module.utils.Response;

@FeignClient(name = "app")
public interface FileServiceFeign {

    @RequestMapping(value = "/upload_file")
    String uploadFile(@RequestPart("file") MultipartFile file);
}