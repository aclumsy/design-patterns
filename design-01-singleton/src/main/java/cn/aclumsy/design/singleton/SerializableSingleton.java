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

import java.io.Serializable;

/**
 * 可以序列化的单例
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public class SerializableSingleton implements Serializable  {

    private static final long serialVersionUID = -8749934649286917507L;

    private static final SerializableSingleton SINGLETON ;

    static {
        SINGLETON = new SerializableSingleton();
    }

    private SerializableSingleton() {
        // 防止反射破坏单例
        if (SINGLETON != null) {
            throw new RuntimeException("不允许创建多个实例！");
        }
    }

    public static SerializableSingleton getInstance() {
        return SINGLETON;
    }
}
