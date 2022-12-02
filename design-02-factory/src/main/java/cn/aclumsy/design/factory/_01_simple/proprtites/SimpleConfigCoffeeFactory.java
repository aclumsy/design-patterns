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

package cn.aclumsy.design.factory._01_simple.proprtites;

import cn.aclumsy.design.factory._01_simple.coffee.Coffee;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public class SimpleConfigCoffeeFactory {

    private static final Map<String, Coffee> COFFEE_MAP = new ConcurrentHashMap<>();

    static {
        // 读取配置文件
        try (InputStream in = SimpleConfigCoffeeFactory.class.getClassLoader().getResourceAsStream("bean.properties")) {
            Properties properties = new Properties();
            properties.load(in);
            for (Object key : properties.keySet()) {
                String value = properties.getProperty((String) key);
                Coffee coffee = (Coffee)Class.forName(value).newInstance();
                COFFEE_MAP.put((String) key, coffee);
            }
        } catch (IOException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 根据配置文件中的配置，返回对应的咖啡
     * @param type 咖啡类型
     * @return 咖啡
     */
    public static Coffee createCoffee(String type) {
        return COFFEE_MAP.get(type);
    }
}
