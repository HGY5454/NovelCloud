package red.mlz.consoleconsumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import red.mlz.module.module.kinds.entity.Kinds;
import red.mlz.module.utils.Response;

import java.math.BigInteger;

@FeignClient(name = "console")
public interface KindsServiceFeign {

    @RequestMapping("/kinds/kinds_info")
    Kinds getKinds(@RequestParam(name = "kindsId") BigInteger kindsId);

    @RequestMapping("/kinds/createKinds")
    String createKinds(
            @RequestParam(name = "kindsName") String kindsName,
            @RequestParam(name = "kindsImages") String kindsImages);

    @RequestMapping("/kinds/updateKinds")
    String updateKinds(
            @RequestParam(name = "kindsId") BigInteger kindsId,
            @RequestParam(name = "kindsName") String kindsName,
            @RequestParam(name = "kindsImages") String kindsImages);

    @RequestMapping("/kinds/deleteKinds")
    Response deleteKinds(@RequestParam(name = "id") BigInteger id);

    @RequestMapping("/kinds/kinds_tree")
    Response kindsTree();
}