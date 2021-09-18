package io.es.sample.es;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.io.Serializable;

/**
 * Bug工厂上层接口
 * <p>
 *     <ul>
 *         <li>用来生产同一族类中不同类型的Bug</li>
 *     </ul>
 * </p>
 *
 * @author lwj
 * @version 1.0
 * @date 2021-09-18 14:29
 */
@FunctionalInterface
public interface BugFactory<T extends Serializable, R extends Serializable> {
    /**
     * 制造Bug
     *
     * @param bug 你想制造的bug
     * @return 你制造bug后的期望的逾期
     */
    R makeBug(T bug);
}

/**
 * 期望返回
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
class Response implements Serializable {
    /**
     * bug输入
     */
    private String bug;
    /**
     * 期望结果
     */
    private String result;
}

/**
 * 制造bug
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
class MakeBug implements Serializable {
    /**
     * bug输入
     */
    private String bug;
}

class BugFactoryTest {

    public static void main(String[] args) {
        MakeBug makeBug = new MakeBug("害你加班的bug是我写的。");
        Response bugResponse = ((BugFactory<MakeBug, Response>) bug -> new Response(bug.getBug(), "成功的造了一个bug, bug数量+1"))
                .makeBug(makeBug);
        System.err.println(bugResponse);
    }
}

class BugFactoryTest1 {

    public static void main(String[] args) {
        MakeBug makeBug = new MakeBug("害你加班的bug是我写的。");


    }
}