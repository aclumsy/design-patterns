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

package cn.aclumsy.design.proxy.login;

import java.lang.reflect.Proxy;

/**
 * jdk动态代理
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public class JdkLoginLogProxy {

    private final LoginService loginService = new LoginServiceImpl();

    /**
     * 利用 JDK 获取代理对象
     * @return 代理对象
     */
    public LoginService getLoginService() {
        return (LoginService) Proxy.newProxyInstance(
            // 类加载器，用于加载代理类，可以通过目标对象获取类加载器
            loginService.getClass().getClassLoader(),
            // 代理类的接口的字节码对象
            loginService.getClass().getInterfaces(),
            // 代理对象的调用处理逻辑，我们对方法前后进行增强的就是在这里进行
            // proxy == ShellTickets， 我们基本不用这个参数
            // method == sell() 方法封装
            // args == 方法参数
            // return 的就是 sell() 方法的返回值
            (proxy, method, args) -> {
                // 方法前增强
                System.out.println("登录前增强, name: " + args[0] + ", password: " + args[1]);
                try {
                    return method.invoke(loginService, args);
                } catch (Exception e) {
                    throw e;
                } finally {
                    // 方法后增强
                    System.out.println("登录后增强, 记录到数据库 name: " + args[0] + ", password: " + args[1]);
                }
            }
        );
    }

}
