package red.mlz.appconsumer.domain.novel;

import lombok.Data;

import java.util.List;

@Data
public class ListVo {
    private String title;
    private Image image;
    private String author;
    private Float score;
    private String kindsName;
    private List<InfoVo> info;
}
