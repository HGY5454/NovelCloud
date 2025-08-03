package red.mlz.appconsumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import red.mlz.module.utils.Response;

import java.math.BigInteger;

@FeignClient(name = "app")
public interface NovelServiceClient {

    @RequestMapping("/novel/list")
    Response novelList(
            @RequestParam(name = "wp", required = false) String wp,
            @RequestParam(name = "keyWord", required = false) String keyWord);

    @RequestMapping("/novel/info")
    Response novelInfo(@RequestParam(name = "novelId") BigInteger novelId);

    @RequestMapping("/novel/kinds")
    Response kinds();

    @RequestMapping("/novel/children_kinds")
    Response childrenKinds(@RequestParam(name = "kindsId") BigInteger kindsId);
}
