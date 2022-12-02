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

/**
 * 添加日志的登录代理
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public class LoginLogProxy implements LoginService{

    private final LoginService loginService = new LoginServiceImpl();

    @Override
    public boolean login(String username, String password) {
        try {
            // 登录前增强
            System.out.println("name: " + username + ", password: " + password + " 登录");
            // 登录
            return loginService.login(username, password);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("name: " + username + ", password: " + password + " 登录最后，记录到数据库");
        }
    }
}
