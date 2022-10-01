package yiezi.ml.instance.executor.query;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import yiezi.ml.convert.InstanceMapper;
import yiezi.ml.domain.instance.gateway.TxYunInstanceGateway;
import yiezi.ml.dto.data.TxInstanceDTO;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author zhouye
 * @date 2022/9/12
 */
@Component
public class InstanceListByReginQryExe {
    @Resource
    private TxYunInstanceGateway instanceGateway;
    @Value("${yun.tx.regions:ap-guangzhou,ap-hongkong}")
    private List<String> regions = new ArrayList<>();
    @Value("${yun.tx.cache:true}")
    private Boolean isCache;
    private List<TxInstanceDTO> cache = null;

    public List<TxInstanceDTO> getInstances() {
        if (isCache && Objects.nonNull(cache)) {
            return cache;
        } else {
            cache = instanceGateway.getTxInstanceInfoByRegion(regions).stream().map(InstanceMapper.INSTANCE::instanceInfoToInstanceDTO).collect(Collectors.toList());
        }
        return cache;
    }
}
