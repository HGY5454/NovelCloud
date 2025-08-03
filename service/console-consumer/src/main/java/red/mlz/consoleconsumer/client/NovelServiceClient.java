package red.mlz.consoleconsumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import red.mlz.module.utils.Response;

import java.math.BigInteger;

@FeignClient(name = "console")
public interface NovelServiceClient {

    @RequestMapping("/novel/novelList")
    Response novelList(
            @RequestParam(name = "page") Integer page,
            @RequestParam(name = "titleKeyWord", required = false) String titleKeyWord);

    @RequestMapping("/novel/create")
    Response createNovel(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "images") String images,
            @RequestParam(name = "author") String author,
            @RequestParam(name = "score", required = false, defaultValue = "0") Float score,
            @RequestParam(name = "wordCount") Integer wordCount,
            @RequestParam(name = "synopsis") String synopsis,
            @RequestParam(name = "kindsId") BigInteger kindsId,
            @RequestParam(name = "tags") String tags,
            @RequestParam(name = "infoType") String infoType,
            @RequestParam(name = "infoContent") String infoContent);

    @RequestMapping("/novel/update")
    Response updateNovel(
            @RequestParam(name = "novelId") BigInteger novelId,
            @RequestParam(name = "title", required = false) String title,
            @RequestParam(name = "images", required = false) String images,
            @RequestParam(name = "author", required = false) String author,
            @RequestParam(name = "score", required = false, defaultValue = "0") Float score,
            @RequestParam(name = "wordCount", required = false) Integer wordCount,
            @RequestParam(name = "synopsis", required = false) String synopsis,
            @RequestParam(name = "kindsId", required = false) BigInteger kindsId,
            @RequestParam(name = "tags", required = false) String tags,
            @RequestParam(name = "infoType") String infoType,
            @RequestParam(name = "infoContent") String infoContent);

    @RequestMapping("/novel/delete")
    Response deleteNovel(@RequestParam(name = "novelId") BigInteger novelId);
}