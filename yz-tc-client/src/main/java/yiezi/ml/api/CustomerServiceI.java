package yiezi.ml.api;

import com.alibaba.cola.dto.MultiResponse;
import com.alibaba.cola.dto.Response;
import yiezi.ml.dto.CustomerAddCmd;
import yiezi.ml.dto.CustomerListByNameQry;
import yiezi.ml.dto.data.CustomerDTO;

public interface CustomerServiceI {

    public Response addCustomer(CustomerAddCmd customerAddCmd);

    public MultiResponse<CustomerDTO> listByName(CustomerListByNameQry customerListByNameQry);
}
