package red.mlz.appconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import red.mlz.appconsumer.client.ExcelServiceFeign;


import javax.servlet.http.HttpServletResponse;

@RestController
public class ExcelConsumerController {
    @Autowired
    private ExcelServiceFeign excelServiceFeign;

    @PostMapping("/upload_excel")
    public String uploadExcel(@RequestParam("file") MultipartFile file) {
        return excelServiceFeign.uploadExcel(file);
    }

    @GetMapping("/get_excel/kinds")
    public void getKinds(HttpServletResponse response) {
        excelServiceFeign.getKinds(response);
    }

    @GetMapping("/get_allExcel")
    public void getAllExcel(HttpServletResponse response) {
        excelServiceFeign.getAllExcel(response);
    }
}