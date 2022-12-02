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

package cn.aclumsy.design.proxy._02_dynamic._01_dk;

import cn.aclumsy.design.proxy._01_static.ShellTickets;
import cn.aclumsy.design.proxy._01_static.TrainStation;

import java.lang.reflect.Proxy;

/**
 * 获取代理对象的工厂
 *
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public class ProxyFactory {

    /**
     * 需要代理的类，即目标类，需要增强的类
     */
    private final TrainStation trainStation = new TrainStation();

    public ShellTickets getProxy(){
        // 返回代理对象
        return (ShellTickets) Proxy.newProxyInstance(
            // 类加载器，用于加载代理类，可以通过目标对象获取类加载器
            trainStation.getClass().getClassLoader(),
            // 代理类的接口的字节码对象
            trainStation.getClass().getInterfaces(),
            // 代理对象的调用处理逻辑，我们对方法前后进行增强的就是在这里进行
            // proxy == ShellTickets， 我们基本不用这个参数
            // method == sell() 方法封装
            // args == 方法参数
            // return 的就是 sell() 方法的返回值
            (proxy, method, args) -> {
                // 方法前增强
                System.out.println("invoke 方法执行了");
                try {
                    return method.invoke(trainStation, args);
                } catch (Exception e) {
                    System.out.println("invoke 方法执行异常");
                    throw e;
                } finally {
                    // 方法后增强
                    System.out.println("invoke finally 执行了");
                }
            }
        );
    }

}
