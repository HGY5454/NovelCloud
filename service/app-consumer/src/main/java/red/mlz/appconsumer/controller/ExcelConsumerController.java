package red.mlz.appconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import red.mlz.appconsumer.client.ExcelServiceClient;
import red.mlz.module.utils.Response;

import javax.servlet.http.HttpServletResponse;

@RestController
public class ExcelConsumerController {

    @Autowired
    private ExcelServiceClient excelServiceClient;

    @PostMapping(value = "/upload_excel", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Response uploadExcel(@RequestParam("file") MultipartFile file) {
        return excelServiceClient.uploadExcel(file);
    }

    @GetMapping("/get_excel/kinds")
    public void getKinds(HttpServletResponse response) {
        excelServiceClient.getKinds(response);
    }

    @GetMapping("/get_allExcel")
    public void getAllExcel(HttpServletResponse response) {
        excelServiceClient.getAllExcel(response);
    }
}