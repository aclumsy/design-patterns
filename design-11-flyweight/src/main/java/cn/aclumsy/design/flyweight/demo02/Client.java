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

package cn.aclumsy.design.flyweight.demo02;

/**
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public class Client {

    public static void main(String[] args) {
        GoFlyweightFactory factory = GoFlyweightFactory.getInstance();

        GoFlyweight black = factory.getGoFlyweight("black");
        black.display();
        GoFlyweight black1 = factory.getGoFlyweight("black");
        black1.display();

        GoFlyweight white = factory.getGoFlyweight("white");
        white.display();
        GoFlyweight white1 = factory.getGoFlyweight("white");
        white1.display();

        System.out.println("黑色棋子是否相同：" + (black == black1));
        System.out.println("白色棋子是否相同：" + (white == white1));

    }
}
