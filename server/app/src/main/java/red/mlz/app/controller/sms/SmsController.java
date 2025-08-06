package red.mlz.app.controller.sms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import red.mlz.app.SmsSender;
import red.mlz.module.module.sms.service.SmsRecordService;
import red.mlz.module.module.sms.service.SmsTaskService;
import red.mlz.module.utils.Response;

import java.math.BigInteger;


@RestController
public class SmsController {
    @Autowired
    private SmsTaskService smsTaskService;
    @Autowired
    private SmsRecordService smsRecordService;

    @RequestMapping("/send")
    public String send(@RequestParam(name = "phone") BigInteger phone) {
        String result = "失败";
        try {
            if (SmsSender.sendSms(phone).getBody().getCode().equals("ok")) {
                boolean success = false;
                int retryCount = 0;
                while (!success && retryCount < 3) {
                    try {
                        result = "成功";
                        smsRecordService.insertSmsRecordWithOptimisticLock(phone, 1);
                        success = true;
                    } catch (RuntimeException e) {
                        if (e.getMessage().contains("Optimistic lock conflict")) {
                            retryCount++;
                            if (retryCount >= 3) {
                                result = "操作过于频繁，请稍后再试";
                                throw e;
                            }
                            Thread.sleep(100);
                        } else {
                            throw e;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (result == "操作过于频繁，请稍后再试") {
                return result;
            }
        }
        return result;
    }


    @RequestMapping("/creat_task")
    public String creatTask(@RequestParam(name = "phone") BigInteger phone){
        if (smsTaskService.insertSmsTask(phone)==1){
            return "成功";
        }else {
            return "失败";
        }
    }
}
