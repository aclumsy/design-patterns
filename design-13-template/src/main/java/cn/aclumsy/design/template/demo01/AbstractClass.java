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

package cn.aclumsy.design.template.demo01;

/**
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public abstract class AbstractClass {

    public final void cookProcess() {
        //第一步：倒油
        this.pourOil();
        //第二步：热油
        this.heatOil();
        //第三步：倒蔬菜
        this.pourVegetable();
        //第四步：倒调味料
        this.pourSauce();
        //第五步：翻炒
        this.fry();
    }

    /**
     * 模板方法,倒油
     */
    public void pourOil() {
        System.out.println("倒油");
    }

    /**
     * 第二步：热油是一样的，所以直接实现
     */
    public void heatOil() {
        System.out.println("热油");
    }

    /**
     * 第三步：倒蔬菜是不一样的（一个下包菜，一个是下菜心）
     */
    public abstract void pourVegetable();

    /**
     * 第四步：倒调味料是不一样
     */
    public abstract void pourSauce();


    /**
     * 第五步：翻炒是一样的，所以直接实现
     */
    public void fry(){
        System.out.println("炒啊炒啊炒到熟啊");
    }

}
