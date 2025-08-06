package red.mlz.appconsumer.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import red.mlz.appconsumer.client.NovelServiceFeign;
import red.mlz.module.utils.Response;

import java.math.BigInteger;
import java.util.List;

@RestController
public class NovelConsumerController {
    @Autowired
    private NovelServiceFeign novelServiceFeign;

    @RequestMapping("/novel/list")
    public Response listNovel(@RequestParam(name = "wp", required = false) String wp,
                                           @RequestParam(name = "keyWord", required = false) String keyWord){
        return new Response<>(1001,novelServiceFeign.novelList(wp, keyWord));
    }
    @RequestMapping("/novel/info")
    public Response infoNovel(@RequestParam(name = "id") BigInteger id){
        return new Response<>(1001,novelServiceFeign.novelInfo(id));
    }
    @RequestMapping("/novel/kinds")
    public Response kindsNovel(@RequestParam(name = "id") BigInteger id){
        return new Response<>(1001,novelServiceFeign.kinds(id));
    }
    @RequestMapping("/novel/children_kinds")
    public Response childrenKindsNovel(@RequestParam(name = "id") BigInteger id){
        return new Response<>(1001,novelServiceFeign.childrenKinds(id));
    }
}