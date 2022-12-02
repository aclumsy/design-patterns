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

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 享元工厂，负责生产和管理享元对象
 *
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public class FlyweightFactory {

    private static final Map<String, Flyweight> FLYWEIGHT_MAP = new ConcurrentHashMap<>();

    static {
        FLYWEIGHT_MAP.put("X", new ConcreteFlyweight("X"));
        FLYWEIGHT_MAP.put("Y", new ConcreteFlyweight("Y"));
        FLYWEIGHT_MAP.put("Z", new ConcreteFlyweight("Z"));
    }

    /**
     * 获取享元对象
     *
     * @param key 享元对象的key
     *
     * @return 享元对象
     */
    public static Flyweight getFlyweight(String key) {
        if (FLYWEIGHT_MAP.containsKey(key)) {
            return FLYWEIGHT_MAP.get(key);
        }
        ConcreteFlyweight flyweight = new ConcreteFlyweight(key);
        FLYWEIGHT_MAP.put(key, flyweight);
        return flyweight;
    }
}
