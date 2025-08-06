package red.mlz.appconsumer.domain.novel;

import lombok.Data;

import java.math.BigInteger;

@Data
public class KindsVo {
    private BigInteger id;
    private String kindsName;
    private Image kindsImage;
    private BigInteger parentId;
}
