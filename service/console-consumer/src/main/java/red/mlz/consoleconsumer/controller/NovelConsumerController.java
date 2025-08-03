package red.mlz.consoleconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import red.mlz.consoleconsumer.client.NovelServiceClient;
import red.mlz.module.utils.Response;

import java.math.BigInteger;

@RestController
public class NovelConsumerController {

    @Autowired
    private NovelServiceClient novelServiceClient;

    @RequestMapping("/novel/novelList")
    public Response novelList(
            @RequestParam(name = "page") Integer page,
            @RequestParam(name = "titleKeyWord", required = false) String titleKeyWord) {
        return novelServiceClient.novelList(page, titleKeyWord);
    }

    @RequestMapping("/novel/create")
    public Response createNovel(
            @RequestParam(name = "title") String title,
            @RequestParam(name = "images") String images,
            @RequestParam(name = "author") String author,
            @RequestParam(name = "score", required = false, defaultValue = "0") Float score,
            @RequestParam(name = "wordCount") Integer wordCount,
            @RequestParam(name = "synopsis") String synopsis,
            @RequestParam(name = "kindsId") BigInteger kindsId,
            @RequestParam(name = "tags") String tags,
            @RequestParam(name = "infoType") String infoType,
            @RequestParam(name = "infoContent") String infoContent) {
        return novelServiceClient.createNovel(title, images, author, score, wordCount, synopsis, kindsId, tags, infoType, infoContent);
    }

    @RequestMapping("/novel/update")
    public Response updateNovel(
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
            @RequestParam(name = "infoContent") String infoContent) {
        return novelServiceClient.updateNovel(novelId, title, images, author, score, wordCount, synopsis, kindsId, tags, infoType, infoContent);
    }

    @RequestMapping("/novel/delete")
    public Response deleteNovel(@RequestParam(name = "novelId") BigInteger novelId) {
        return novelServiceClient.deleteNovel(novelId);
    }
}