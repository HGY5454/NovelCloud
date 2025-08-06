package red.mlz.appconsumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import red.mlz.appconsumer.domain.novel.ChildrenKindsVo;
import red.mlz.appconsumer.domain.novel.KindsListVo;
import red.mlz.appconsumer.domain.novel.NovelListVo;
import red.mlz.appconsumer.domain.novel.NovelVo;

import java.math.BigInteger;
import java.util.List;

@FeignClient(name = "app")
public interface NovelServiceFeign {

    @RequestMapping("/novel/list")
    NovelListVo novelList(
            @RequestParam(name = "wp", required = false) String wp,
            @RequestParam(name = "keyWord", required = false) String keyWord);

    @RequestMapping("/novel/info")
    NovelVo novelInfo(@RequestParam(name = "novelId") BigInteger novelId);

    @RequestMapping("/novel/kinds")
    List<KindsListVo>  kinds(@RequestParam(name = "kindsId") BigInteger kindsId);

    @RequestMapping("/novel/children_kinds")
    ChildrenKindsVo childrenKinds(@RequestParam(name = "kindsId") BigInteger kindsId);
}