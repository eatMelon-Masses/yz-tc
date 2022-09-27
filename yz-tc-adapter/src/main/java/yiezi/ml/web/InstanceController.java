package yiezi.ml.web;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.SingleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yiezi.ml.api.InstanceServiceI;
import yiezi.ml.dto.data.TxInstanceDTO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author zhouye
 * @date 2022/9/12
 */
@RestController
@Slf4j
public class InstanceController {
    @Resource
    private InstanceServiceI instanceServiceI;

    @GetMapping(value = "/instances")
    public MultiResponse<TxInstanceDTO> listInstances() {
        return instanceServiceI.getInstanceAll();
    }

    @GetMapping(value = "/client/ip")
    public SingleResponse<String> getClientIp(HttpServletRequest request) {
        String ipAddress = null;
        ipAddress = request.getHeader("X-FORWARDED-FOR");   // proxy
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        log.info("IP Address: " + ipAddress);
        return SingleResponse.of(ipAddress);
    }
}
