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

package cn.aclumsy.design.composite.demo01;

/**
 * 菜单组件
 *
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public abstract class MenuComponent {

    /**
     * 菜单组件名称
     */
    protected String name;

    /**
     * 菜单组件层级
     */
    protected Integer level;

    /**
     * 添加菜单组件
     *
     * @param menuComponent 菜单组件
     */
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }


    /**
     * 删除
     *
     * @param menuComponent 菜单组件
     */
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取菜单组件
     *
     * @param index 索引
     *
     * @return 菜单组件
     */
    public MenuComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        return name;
    }

    /**
     * 打印菜单组件
     */
    public abstract void print();
}
