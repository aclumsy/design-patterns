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

package cn.aclumsy.design.flyweight.demo01;

/**
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public class ConcreteFlyweight extends Flyweight {

    /**
     * 内部状态， 同一个享元对象内部状态是一致的
     */
    private final String inState;

    public ConcreteFlyweight(String inState) {
        this.inState = inState;
    }

    /**
     * 设置外部状态，外部状态是不一致的，通常是通过参数传入
     * @param state 外部状态
     */
    @Override
    public void operation(String state) {
        System.out.println("内部状态：" + inState);
        System.out.println("外部状态：" + state);
    }
}
