package yiezi.ml.domain.instance.gateway;

import java.util.List;

/**
 * @author zhouye
 * @date 2022/9/12
 */
public interface TxYunInstanceGateway {
    public List<TxInstanceInfo> getTxInstanceInfoByRegion(List<String> regions);
}
