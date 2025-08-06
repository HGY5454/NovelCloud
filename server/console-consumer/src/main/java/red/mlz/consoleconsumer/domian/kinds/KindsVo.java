package red.mlz.consoleconsumer.domian.kinds;

import lombok.Data;

import java.math.BigInteger;

@Data
public class KindsVo {
    private BigInteger id;
    private String kindsImage;
    private String kindsName;
}
