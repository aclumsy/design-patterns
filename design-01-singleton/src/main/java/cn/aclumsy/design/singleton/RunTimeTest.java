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

import java.io.IOException;
import java.io.InputStream;

/**
 * RunTime 类是一个单例类，它的构造方法是私有的，所以不能通过 new 来创建对象。
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public class RunTimeTest {

    public static void main(String[] args) throws IOException {

        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("ipconfig");
        InputStream in = process.getInputStream();
        byte[] bytes = new byte[1024 * 1024 * 100];
        int len = in.read(bytes);
        System.out.println(new String(bytes, 0, len, "GBK"));
    }
}
