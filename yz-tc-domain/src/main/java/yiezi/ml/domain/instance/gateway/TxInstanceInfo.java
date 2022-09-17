package yiezi.ml.domain.instance.gateway;

import lombok.Data;

/**
 * @author zhouye
 * @date 2022/9/12
 */
@Data
public class TxInstanceInfo {
    private String instanceId;
    private String instanceName;
    private String[] publicAddresses;
    private String zone;
    private String instanceRestrictState;
}
