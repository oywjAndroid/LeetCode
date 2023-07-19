package com.allen.knowledge;

import com.allen.knowledge.tree.BFS.OpenLock2;

import org.junit.Test;

/**
 * <pre>
 *     author : allenjones
 *     e-mail : weijunouyang@lerke.cn
 *     time   : 2023/07/15
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class OpenLockUnitTest {

    @Test
    public void runOpenLock2() {
        OpenLock2 openLock = new OpenLock2();
        //int depth = openLock.openLock(new String[]{"1234", "5678"}, "0009");
        int depth = openLock.openLock(
                new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"},
                "8888"
        );
        System.out.println("depth=" + depth);
    }

}
