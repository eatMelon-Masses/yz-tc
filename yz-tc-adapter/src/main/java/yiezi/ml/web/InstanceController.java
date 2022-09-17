package yiezi.ml.web;

import com.alibaba.cola.dto.MultiResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yiezi.ml.api.InstanceServiceI;
import yiezi.ml.dto.data.TxInstanceDTO;

import javax.annotation.Resource;

/**
 * @author zhouye
 * @date 2022/9/12
 */
@RestController
public class InstanceController {
    @Resource
    private InstanceServiceI instanceServiceI;

    @GetMapping(value = "/instances")
    public MultiResponse<TxInstanceDTO> listInstances() {
        return instanceServiceI.getInstanceAll();
    }
}
