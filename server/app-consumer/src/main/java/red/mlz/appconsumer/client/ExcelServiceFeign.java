package red.mlz.appconsumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import red.mlz.module.utils.Response;

import javax.servlet.http.HttpServletResponse;

@FeignClient(name = "app")
public interface ExcelServiceFeign {

    @PostMapping(value = "/upload_excel")
    String uploadExcel(@RequestParam("file") MultipartFile file);

    @GetMapping("/get_excel/kinds")
    void getKinds(HttpServletResponse response);

    @GetMapping("/get_allExcel")
    void getAllExcel(HttpServletResponse response);
}