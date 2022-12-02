
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
package cn.aclumsy.design.interpreter.demo01;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 表达式解析器
 *
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public class ExpressionInterpreter {

    /**
     * 双向队列，可以从队列两端增加或者删除元素
     */
    private static final Deque<Long> numbers = new LinkedList<>();

    /**
     * 解析表达式
     *
     * @param expression 表达式
     *
     * @return 解析结果
     */
    public static long interpreter(String expression) {

        // 9 5 7 3 - + *
        String[] elements = expression.split(" ");

        int length = elements.length;

        // 获取表达式中的数字
        for (int i = 0; i < (length + 1) / 2; i++) {
            numbers.addLast(Long.valueOf(elements[i]));
        }

        // 获取表达式中的运算符
        for (int i = (length + 1) / 2; i < length; i++) {
            String operator = elements[i];
            long result;
            long number1 = numbers.pollFirst();
            long number2 = numbers.pollFirst();
            switch (operator) {
                case "+":
                    result = number1 + number2;
                    break;
                case "-":
                    result = number1 - number2;
                    break;
                case "*":
                    result = number1 * number2;
                    break;
                case "/":
                    result = number1 / number2;
                    break;
                default:
                    throw new IllegalArgumentException("运算符错误");
            }
            numbers.addFirst(result);
        }
        return numbers.pollFirst();
    }

    public static void main(String[] args) {
        System.out.println(interpreter("9 5 7 3 - + *"));;
    }

}
