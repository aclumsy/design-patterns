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
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public class Client {

    public static void main(String[] args) {

        MenuComponent menu = new Menu("菜单管理", 2);
        MenuComponent menu1 = new Menu("权限管理", 2);
        MenuComponent menu2 = new Menu("角色管理", 2);
        menu.add(new MenuItem("页面访问", 3));
        menu.add(new MenuItem("展开菜单", 3));
        menu.add(new MenuItem("编辑菜单", 3));
        menu.add(new MenuItem("删除菜单", 3));
        menu.add(new MenuItem("新增菜单", 3));

        menu1.add(new MenuItem("页面访问", 3));
        menu1.add(new MenuItem("提交保存", 3));

        menu2.add(new MenuItem("页面访问", 3));
        menu2.add(new MenuItem("新增角色", 3));
        menu2.add(new MenuItem("修改角色", 3));

        MenuComponent menuComponent = new Menu("系统管理", 1);
        menuComponent.add(menu);
        menuComponent.add(menu1);
        menuComponent.add(menu2);

        menuComponent.print();
    }
}
