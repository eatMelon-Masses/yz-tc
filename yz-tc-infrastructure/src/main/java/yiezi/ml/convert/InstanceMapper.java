package yiezi.ml.convert;

import com.tencentcloudapi.lighthouse.v20200324.models.Instance;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import yiezi.ml.domain.instance.gateway.TxInstanceInfo;
import yiezi.ml.dto.data.TxInstanceDTO;

/**
 * @author zhouye
 * @date 2022/9/12
 */
@Mapper
public interface InstanceMapper {
    InstanceMapper INSTANCE = Mappers.getMapper(InstanceMapper.class);


    //    @Mapping(source = "instanceId", target = "instanceId")
//    @Mapping(source = "InstanceName", target = "instanceName")
//    @Mapping(source = "PublicAddresses", target = "publicAddresses")
//    @Mapping(source = "Zone", target = "zone")
//    @Mapping(source = "InstanceRestrictState", target = "instanceRestrictState")
    TxInstanceInfo instanceToInstanceInfo(Instance instance);

    TxInstanceDTO instanceInfoToInstanceDTO(TxInstanceInfo instance);
}
