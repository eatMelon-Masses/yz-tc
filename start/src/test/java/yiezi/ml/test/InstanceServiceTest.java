package yiezi.ml.test;

import yiezi.ml.api.InstanceServiceI;

import javax.annotation.Resource;

/**
 * @author zhouye
 * @date 2022/9/12
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class InstanceServiceTest {
    @Resource
    private InstanceServiceI instanceService;

    // @Test
    public void getInstanceAllTest() {
        System.out.println(instanceService.getInstanceAll());
    }
}
