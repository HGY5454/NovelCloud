package red.mlz.appconsumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import red.mlz.module.utils.Response;

@FeignClient(name = "app")
public interface FileServiceClient {

    @RequestMapping(value = "/upload_file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    Response uploadFile(@RequestPart("file") MultipartFile file);
}