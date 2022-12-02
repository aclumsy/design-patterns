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
 * 饿汉式单例模式 <br>
 * 饿汉式单例  在类加载的时候就立即初始化，并且创建单例对象。绝对线程安全，在线程还没出现以前就是实例化了，不可能存在线程安全问题
 *
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
@SuppressWarnings("unused")
public class HungrySingleton {

    /**
     * 定义该单例属性
     */
    private static final HungrySingleton HUNGRY_SINGLETON;

    static {
        HUNGRY_SINGLETON = new HungrySingleton();
    }

    /**
     * 构造方法私有化
     */
    private HungrySingleton() {
        // 防止反射破坏单例，下一篇会介绍
        if (HUNGRY_SINGLETON != null) {
            throw new RuntimeException("不允许创建多个单例");
        }
    }

    /**
     * 提供全局唯一访问点
     *
     * @return HUNGRY_SINGLETON
     */
    public static HungrySingleton getInstance() {
        return HUNGRY_SINGLETON;
    }

    /**
     * 防止序列化破坏单例
     * 如果该单例实现了  Serializable 序列化接口，为了防止序列化破坏单例，需要重写 readResolve()方法
     *
     * @return SINGLETON
     */
    private Object readResolve() {
        return HUNGRY_SINGLETON;
    }

}
