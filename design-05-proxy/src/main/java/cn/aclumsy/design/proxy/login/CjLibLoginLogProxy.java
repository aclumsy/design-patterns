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

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public class CjLibLoginLogProxy implements MethodInterceptor {

    private final LoginServiceImpl loginService = new LoginServiceImpl();

    public LoginServiceImpl getLoginService() {
        // 1.创建 Enhancer 对象. 类似于JDK代理中的 Proxy 类
        Enhancer enhancer = new Enhancer();
        // 2.设置父类的字节码对象，代理生成的类属于目标类的子类
        enhancer.setSuperclass(LoginServiceImpl.class);
        // 3.设置回调函数，代理对象的方法调用会被转发到 Callback 对象的 intercept() 方法
        enhancer.setCallback(this);
        // 4.创建代理对象
        return (LoginServiceImpl)enhancer.create();
    }

    /**
     * 具体执行的方法
     * @param o 代理对象
     * @param method 目标方法
     * @param objects 目标方法参数
     * @param methodProxy 代理方法
     * @return 目标方法返回值
     * @throws Throwable 异常
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("CjLib动态代理");
        try {
            return method.invoke(loginService, objects);
        } catch (Exception e) {
            throw e;
        } finally {
            System.out.println("CjLib动态代理结束， 记录到数据库" + "username: " + objects[0]);
        }
    }
}
