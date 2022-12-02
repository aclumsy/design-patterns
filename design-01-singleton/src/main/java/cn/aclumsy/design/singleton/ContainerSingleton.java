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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 容器式单例
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public class ContainerSingleton {

    /**
     * 构造方法私有化
     */
    private ContainerSingleton() {}

    private static final Map<String, Object> IOC = new ConcurrentHashMap<>();

    public static Object getBean(String className) {
        // 防止线程安全问题
        // 对象方便管理，其实也属于懒加载
        synchronized (IOC) {
            if (!IOC.containsKey(className)) {
                Object bean = null;
                try {
                    bean = Class.forName(className).newInstance();
                    IOC.put(className, bean);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                // 不存在就创建一个，然后返回
                return bean;
            }
            // 存在就直接返回 object
            return IOC.get(className);
        }
    }
}
