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

package cn.aclumsy.design.strategy.demo02;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public class ReceiptBuilder {

    public static List<Receipt> buildReceipts() {
        List<Receipt> receiptList = new ArrayList<>();
        receiptList.add(new Receipt("MT1101回执信息", "MT1101"));
        receiptList.add(new Receipt("MT1102回执信息", "MT1102"));
        receiptList.add(new Receipt("MT1103回执信息", "MT1103"));
        receiptList.add(new Receipt("MT1104回执信息", "MT1104"));
        return receiptList;
    }
}
