package com.alibaba.ttl

import com.alibaba.*
import com.alibaba.ttl.testmodel.Task
import org.junit.Test

/**
 * @author Yang Fang (snoop dot fy at gmail dot com)
 */
class NoInheritableTTLTest {

    @Test
    fun test_noInheritable_asyncRunByNewThread() {
        val ttlInstances = createParentTtlInstances(noInherit = true)

        val task = Task("1", ttlInstances)
        val thread1 = Thread(task)

        // create after new Task, won't see parent value in in task!
        createParentTtlInstancesAfterCreateChild(ttlInstances)


        thread1.start()
        thread1.join()


        // child Inheritable
        assertChildTtlValuesWithParentCreateAfterCreateChild("1", task.copied, noInherit = true)

        // child do not effect parent
        assertParentTtlValues(copyTtlValues(ttlInstances))
    }

}