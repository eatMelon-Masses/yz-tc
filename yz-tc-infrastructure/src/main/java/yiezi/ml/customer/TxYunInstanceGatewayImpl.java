package yiezi.ml.customer;

import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.lighthouse.v20200324.LighthouseClient;
import com.tencentcloudapi.lighthouse.v20200324.models.DescribeInstancesRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import yiezi.ml.convert.InstanceMapper;
import yiezi.ml.domain.instance.gateway.TxInstanceInfo;
import yiezi.ml.domain.instance.gateway.TxYunInstanceGateway;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhouye
 * @date 2022/9/12
 */
@Service
public class TxYunInstanceGatewayImpl implements TxYunInstanceGateway {
    @Value("${yun.tx.secret.key}")
    private String yunTxSecretKey;
    @Value("${yun.tx.secret.id:AKID5zd04rOedLmwpRmcHhtqY0C9rJVR7Xha}")
    private String yunTxSecretId;
    @Value("${yun.tx.secert.end.point:lighthouse.tencentcloudapi.com}")
    private String yunTxEndPoint;


    @Override
    public List<TxInstanceInfo> getTxInstanceInfoByRegion(List<String> regions) {
        // 实例化一个认证对象，入参需要传入腾讯云账户secretId，secretKey,此处还需注意密钥对的保密
        // 密钥可前往https://console.cloud.tencent.com/cam/capi网站进行获取
        Credential cred = new Credential(yunTxSecretId, yunTxSecretKey);
        // 实例化一个http选项，可选的，没有特殊需求可以跳过
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint(yunTxEndPoint);
        // 实例化一个client选项，可选的，没有特殊需求可以跳过
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);
        // 实例化要请求产品的client对象,clientProfile是可选的
        LighthouseClient client = new LighthouseClient(cred, "", clientProfile);
        return regions.stream().map(region -> {
            client.setRegion(region);
            System.out.printf(region);
            // 返回的resp是一个DescribeInstancesResponse的实例，与请求对象对应
            try {
                return Arrays.stream(client.DescribeInstances(new DescribeInstancesRequest()).getInstanceSet()).map(InstanceMapper.INSTANCE::instanceToInstanceInfo).collect(Collectors.toList());
            } catch (TencentCloudSDKException e) {
                throw new RuntimeException(e);
            }
        }).flatMap(Collection::stream).collect(Collectors.toList());


    }
}
