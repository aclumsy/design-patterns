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
 * 静态内部类实现单例模式
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
@SuppressWarnings("unused")
public class LazyInnerClassSingleton {
    /**
     * 构造方法私有化
     */
    private LazyInnerClassSingleton() {
        // 这个是为了防止 通过反射机制从而破坏了单例模式
        // 下一篇会做讲解
        if (LazyHolder.LAZY != null) {
            throw new RuntimeException("不允许创建多个单例！");
        }
    }

    /**
     * 全局唯一访问点
     * static 是为了使单例的空间共享
     * final 保证这个方法不会被重写，重载
     *
     * @return LazyHolder.LAZY
     */
    public static LazyInnerClassSingleton getInstance() {
        // 在返回结果以前，一定会先加载内部类
        return LazyHolder.LAZY;
    }

    /**
     * 静态内部类 利用了静态内部类 加载时的特性
     * 内部静态类不会自动初始化，只有调用静态内部类的方法，静态域，或者构造方法的时候才会加载静态内部类。
     * JVM 底层的逻辑，完美避免了线程安全问题
     */
    private static class LazyHolder {
        private static final LazyInnerClassSingleton LAZY = new LazyInnerClassSingleton();
    }

    /**
     * 防止序列化破坏单例
     * 如果该单例实现了  Serializable 序列化接口，为了防止序列化破坏单例，需要重写 readResolve()方法
     * 下一篇会讲解序列化破坏单例
     *
     * @return SINGLETON
     */
    private Object readResolve() {
        return LazyHolder.LAZY;
    }
}
