package yiezi.ml.instance;

import com.alibaba.cola.dto.MultiResponse;
import org.springframework.stereotype.Service;
import yiezi.ml.api.InstanceServiceI;
import yiezi.ml.dto.data.TxInstanceDTO;
import yiezi.ml.instance.executor.query.InstanceListByReginQryExe;

import javax.annotation.Resource;

/**
 * @author zhouye
 * @date 2022/9/12
 */
@Service
public class InstanceServiceIImpl implements InstanceServiceI {
    @Resource
    private InstanceListByReginQryExe instanceListByReginQryExe;

    @Override
    public MultiResponse<TxInstanceDTO> getInstanceAll() {
        return MultiResponse.of(instanceListByReginQryExe.getInstances());
    }

}
