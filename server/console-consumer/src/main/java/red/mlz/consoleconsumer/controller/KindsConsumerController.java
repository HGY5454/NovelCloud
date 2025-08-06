package red.mlz.consoleconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import red.mlz.consoleconsumer.client.KindsServiceFeign;
import red.mlz.module.utils.Response;

import java.math.BigInteger;

@RestController
public class KindsConsumerController {

    @Autowired
    private KindsServiceFeign kindsServiceFeign;

    @RequestMapping("/kinds/kinds_info")
    public Response getKinds(@RequestParam(name = "kindsId") BigInteger kindsId) {
        return new Response<>(1001,kindsServiceFeign.getKinds(kindsId));
    }

    @RequestMapping("/kinds/createKinds")
    public String createKinds(
            @RequestParam(name = "kindsName") String kindsName,
            @RequestParam(name = "kindsImages") String kindsImages) {
        return kindsServiceFeign.createKinds(kindsName, kindsImages);
    }

    @RequestMapping("/kinds/updateKinds")
    public String updateKinds(
            @RequestParam(name = "kindsId") BigInteger kindsId,
            @RequestParam(name = "kindsName") String kindsName,
            @RequestParam(name = "kindsImages") String kindsImages) {
        return kindsServiceFeign.updateKinds(kindsId, kindsName, kindsImages);
    }

    @RequestMapping("/kinds/deleteKinds")
    public Response deleteKinds(@RequestParam(name = "id") BigInteger id) {
        return kindsServiceFeign.deleteKinds(id);
    }

    @RequestMapping("/kinds/kinds_tree")
    public Response kindsTree() {
        return kindsServiceFeign.kindsTree();
    }
}