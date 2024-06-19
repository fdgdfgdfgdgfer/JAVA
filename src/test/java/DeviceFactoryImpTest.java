import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.designPattern.Adapter.asfa;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author jfz
 * @Date 2024/2/19 15:52
 * @PackageName:org.example
 * @ClassName: DeviceFactoryImpTest
 */
@Data
@NoArgsConstructor
public class DeviceFactoryImpTest {
    @Autowired
    private asfa asfa;
    @Test
    public void s() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
       asfa.sda();
    }
}