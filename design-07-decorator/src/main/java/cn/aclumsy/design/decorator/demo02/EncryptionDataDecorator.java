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

package cn.aclumsy.design.decorator.demo02;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * 具体的装饰着类，对原来的文件读写进行加密
 *
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public class EncryptionDataDecorator extends DataLoaderDecorator {

    public EncryptionDataDecorator(DataLoader dataLoader) {
        super(dataLoader);
    }

    @Override
    public String read() {

        return decode(super.read());
    }

    @Override
    public void write(String data) {
        super.write(encode(data));
    }

    /**
     * 加密
     * @param data 文件内容
     * @return 加密后的文件内容
     */
    private String encode(String data) {
        try {
            Base64.Encoder encoder = Base64.getEncoder();
            byte[] bytes = data.getBytes(StandardCharsets.UTF_8);
            return encoder.encodeToString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 解密操作
     * @param data 加密后的数据
     * @return 解密后的数据
     */
    private String decode(String data) {
        try {
            Base64.Decoder decoder = Base64.getDecoder();
            return new String(decoder.decode(data), StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
