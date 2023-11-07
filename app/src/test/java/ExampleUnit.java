import com.allen.example.dp.Example001;
import com.allen.example.dp.Example002;

import org.junit.Test;

/**
 * @Description TODO
 * @Author Allen
 * @Date 11-01-2023 周三 11:32
 */
public class ExampleUnit {

    @Test
    public void runExample001() {
        Example001 example001 = new Example001();

        long fib_1_start = System.currentTimeMillis();
        int fib_1 = example001.fib_1(15);
        long fib_1_end = System.currentTimeMillis();
        System.out.println("fib_1=" + fib_1 + ",cons time:" + (fib_1_end - fib_1_start));

        long fib_2_start = System.currentTimeMillis();
        int fib_2 = example001.fib_2(15);
        long fib_2_end = System.currentTimeMillis();
        System.out.println("fib_2=" + fib_2 + ",cons time:" + (fib_2_end - fib_2_start));

        long fib_3_start = System.currentTimeMillis();
        int fib_3 = example001.fib_3(15);
        long fib_3_end = System.currentTimeMillis();
        System.out.println("fib_3=" + fib_3 + ",cons time:" + (fib_3_end - fib_3_start));
    }

    @Test
    public void runExample002() {
        Example002 example002 = new Example002();

        int coin_change_1 = example002.coinChange_1(new int[]{3}, 7);
        System.out.println("coin_change_1=" + coin_change_1);
    }
}
