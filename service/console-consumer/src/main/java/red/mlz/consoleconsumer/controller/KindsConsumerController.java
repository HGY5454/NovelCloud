package red.mlz.consoleconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import red.mlz.consoleconsumer.client.KindsServiceClient;
import red.mlz.module.utils.Response;

import java.math.BigInteger;

@RestController
public class KindsConsumerController {

    @Autowired
    private KindsServiceClient kindsServiceClient;

    @RequestMapping("/kinds/kinds_info")
    public Response getKinds(@RequestParam(name = "kindsId") BigInteger kindsId) {
        return kindsServiceClient.getKinds(kindsId);
    }

    @RequestMapping("/kinds/createKinds")
    public Response createKinds(
            @RequestParam(name = "kindsName") String kindsName,
            @RequestParam(name = "kindsImages") String kindsImages) {
        return kindsServiceClient.createKinds(kindsName, kindsImages);
    }

    @RequestMapping("/kinds/updateKinds")
    public Response updateKinds(
            @RequestParam(name = "kindsId") BigInteger kindsId,
            @RequestParam(name = "kindsName") String kindsName,
            @RequestParam(name = "kindsImages") String kindsImages) {
        return kindsServiceClient.updateKinds(kindsId, kindsName, kindsImages);
    }

    @RequestMapping("/kinds/deleteKinds")
    public Response deleteKinds(@RequestParam(name = "id") BigInteger id) {
        return kindsServiceClient.deleteKinds(id);
    }

    @RequestMapping("/kinds/kinds_tree")
    public Response kindsTree() {
        return kindsServiceClient.kindsTree();
    }
}