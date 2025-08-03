package red.mlz.consoleconsumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import red.mlz.module.utils.Response;

import java.math.BigInteger;

@FeignClient(name = "console")
public interface KindsServiceClient {

    @RequestMapping("/kinds/kinds_info")
    Response getKinds(@RequestParam(name = "kindsId") BigInteger kindsId);

    @RequestMapping("/kinds/createKinds")
    Response createKinds(
            @RequestParam(name = "kindsName") String kindsName,
            @RequestParam(name = "kindsImages") String kindsImages);

    @RequestMapping("/kinds/updateKinds")
    Response updateKinds(
            @RequestParam(name = "kindsId") BigInteger kindsId,
            @RequestParam(name = "kindsName") String kindsName,
            @RequestParam(name = "kindsImages") String kindsImages);

    @RequestMapping("/kinds/deleteKinds")
    Response deleteKinds(@RequestParam(name = "id") BigInteger id);

    @RequestMapping("/kinds/kinds_tree")
    Response kindsTree();
}