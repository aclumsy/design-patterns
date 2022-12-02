
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
package cn.aclumsy.design.visitor.demo01;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public class Client {

    public static void main(String[] args) {

        Candy candy = new Candy("巧克力", 10, LocalDate.now());
        Wine wine = new Wine("红酒", 100, LocalDate.now());
        Fruit fruit = new Fruit("苹果", 5, LocalDate.now(), 4.5);

        DiscountVisitor visitor = new DiscountVisitor(LocalDate.of(2022, 1, 1));
        visitor.visit(candy);
        visitor.visit(wine);
        visitor.visit(fruit);

        List<Acceptable> list = Arrays.asList(
            new Fruit("香蕉", 100, LocalDate.now(), 5.0),
            new Candy("奶糖", 1000, LocalDate.of(2022, 2,3)),
            new Wine("啤酒", 44, LocalDate.of(2022, 2,3))
        );
        for (Acceptable product : list) {
            product.accept(visitor);
        }
    }
}
