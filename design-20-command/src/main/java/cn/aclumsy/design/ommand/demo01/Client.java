
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
package cn.aclumsy.design.ommand.demo01;

/**
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public class Client {

    public static void main(String[] args) {
        Order order = new Order();
        order.setDiningTable(10);
        order.getFoodMap().put("鱼香肉丝", 2);
        order.getFoodMap().put("红烧肉", 1);
        order.getFoodMap().put("酸辣土豆丝", 3);

        Order order1 = new Order();
        order1.setDiningTable(11);
        order1.getFoodMap().put("sss", 2);

        Chef chef = new Chef();

        OrderCommand orderCommand = new OrderCommand(chef, order);
        OrderCommand orderCommand1 = new OrderCommand(chef, order1);

        Waiter waiter = new Waiter();
        waiter.addCommand(orderCommand);
        waiter.addCommand(orderCommand1);
        waiter.orderUp();
    }
}
