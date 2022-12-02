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

import java.lang.reflect.Constructor;

/**
 * 反射破坏单例
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public class ReflectionTest {

    public static void main(String[] args) {
        try {
            // 反射来获取对象
            Class<?> clazz = LazyInnerClassSingleton.class;
            Constructor<?> c = clazz.getDeclaredConstructor(null);
            // 授权，因为构造方法为私有的，强吻
            c.setAccessible(true);
            // 反射获取单例
            Object o1 = c.newInstance();
            // 正常获取单例获取
            Object o2 = LazyInnerClassSingleton.getInstance();
            System.out.println(o1);
            System.out.println(o2);
            // 比较o1和o2的内存地址 结果为 false
            System.out.println(o1 == o2);
            // 即 o1和o2不是同一个对象。单例就被破坏了
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
