/*
 * Copyright (c) 2022, Aclumsy.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *                _
 *      /\       | |
 *     /  \   ___| |_   _ _ __ ___  ___ _   _
 *    / /\ \ / __| | | | | '_ ` _ \/ __| | | |
 *   / ____ \ (__| | |_| | | | | | \__ \ |_| |
 *  /_/    \_\___|_|\__,_|_| |_| |_|___/\__, |
 *                                       __/ |
 *                                      |___/
 *  I'll think of you every step of the way.
 *  without your world, I don't want to stay for a moment.
 */

package cn.aclumsy.design.singleton;

/**
 * <p>
 * 知识点： 多线程下指令重排问题  volatile
 * (this) lazy = new LazyDoubleCheckSingleton();
 * cpu执行上面的时候会转换为JVM指令：1.分配内存给这个对象; 2.属性初始化; 3.引用指向对象
 * 上面语句为非原子性，所以上面可能会产生指令重排问题 即：正常情况下执行顺序为 1->2->3 但是实际情况下可能就是 1->3->2 <p>
 * <p>
 * (1)单线程情况下，指令重排没有影响； <p>
 * (2)但在多线程情况下，假如线程(1)执行 lazy = new LazyDoubleCheckSingleton()语句时先1 再 3， <p>
 * 但是此时系统调度线程(2)，没来得及执行步骤2，但此时已有引用指向对象
 * (即已经执行3 但是没有完成初始化2。此时对象处于半初始化状态，但对象此时已经不为null了。但是还没属性初始化)
 * 故线程2在第一次检查时不满足条件直接返回 lazy，此时 lazy虽然不为null 但是内部属性还没有完成初始化。
 * volatile 关键字可保证 lazy = new LazyDoubleCheckSingleton();的语句执行顺序为 1 2 3
 * 具体可以参考 volatile 的特性。这里就不做过多说明了
 * </p>
 *
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
@SuppressWarnings("unused")
public class LazyDoubleCheckSingleton {
    /**
     * LazyDoubleCheckSingleton 实例属性
     * volatile 关键字禁止指令重排, 即为第二层锁
     */
    private volatile static LazyDoubleCheckSingleton LAZY;

    /**
     * 构造方法私有化
     */
    private LazyDoubleCheckSingleton() {
        // 这个是为了防止 通过反射机制从而破坏了单例模式
        // 下一篇会做讲解
        if (LAZY != null) {
            throw new RuntimeException("不允许创建多个单例！");
        }
    }

    /**
     * 提供全局唯一访问点
     * <p>
     * synchronized 虽然在性能上已经有了优化，但是还是不可避免的产生内存的消耗
     * 下面会介绍更加好的单例模式
     * </p>
     *
     * @return lazy
     */
    public static LazyDoubleCheckSingleton getInstance() {
        // Double Check Lock 双重监察锁的机制来实现，（DCL）
        // 第一层检查，检查是否有引用指向对象，高并发情况下会有多个线程同时进入 的时候才创建单例，避免重复创建
        // lazy == null同时避免每个线程进来的时候首先竞争锁，从而消耗资源，这样每个线程进来先判断是否已经创建过，没创建对象的情况下才会竞争锁。这样对资源
        if (LAZY == null) {
            // synchronized 锁，synchronized保证只有一个线程进入
            synchronized (LazyDoubleCheckSingleton.class) {
                // 第二层检查，若不检查，那么第一个线程创建完对象释放锁后，后面进入对象也会创建对象，会产生多个对象
                if (LAZY == null) {
                    // 利用 volatile 关键字防止指令重排
                    LAZY = new LazyDoubleCheckSingleton();
                }
            }
        }
        return LAZY;
    }

    /**
     * 防止序列化破坏单例
     * 如果该单例实现了  Serializable 序列化接口，为了防止序列化破坏单例，需要重写 readResolve()方法
     * 下一篇会讲解序列化破坏单例
     *
     * @return SINGLETON
     */
    private Object readResolve() {
        return LAZY;
    }


}
