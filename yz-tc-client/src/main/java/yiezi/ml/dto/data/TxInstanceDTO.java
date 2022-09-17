package yiezi.ml.dto.data;

import lombok.Data;

/**
 * @author zhouye
 * @date 2022/9/12
 */
@Data
public class TxInstanceDTO {
    private String instanceId;
    private String instanceName;
    private String[] publicAddresses;
    private String zone;
    private String instanceRestrictState;
}
