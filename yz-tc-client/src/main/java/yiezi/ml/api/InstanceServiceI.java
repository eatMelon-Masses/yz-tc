package yiezi.ml.api;

import com.alibaba.cola.dto.MultiResponse;
import yiezi.ml.dto.data.TxInstanceDTO;

/**
 * @author zhouye
 * @date 2022/9/12
 */
public interface InstanceServiceI {
    public MultiResponse<TxInstanceDTO> getInstanceAll();

}
