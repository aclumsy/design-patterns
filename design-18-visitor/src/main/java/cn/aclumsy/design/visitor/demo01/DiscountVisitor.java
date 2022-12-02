
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

/**
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public class DiscountVisitor implements Visitor {

    private LocalDate billDate;

    public DiscountVisitor(LocalDate billDate) {
        this.billDate = billDate;
    }

    @Override
    public void visit(Wine wine) {
        System.out.println(wine.toString());
        System.out.println("不打折");
    }

    @Override
    public void visit(Candy candy) {
        System.out.println(candy.toString());
        long days = billDate.toEpochDay() - candy.getDate().toEpochDay();
        if (days > 180) {
            System.out.println("过期");
        } else {
            double real = candy.getPrice() * 0.9;
            System.out.println("real: " + real);
        }
    }

    @Override
    public void visit(Fruit fruit) {
        System.out.println(fruit.toString());
        long days = billDate.toEpochDay() - fruit.getDate().toEpochDay();
        if (days > 7) {
            System.out.println("过期");
        } else {
            double real = fruit.getPrice() * 0.5;
            System.out.println("real: " + real);
        }
    }
}
