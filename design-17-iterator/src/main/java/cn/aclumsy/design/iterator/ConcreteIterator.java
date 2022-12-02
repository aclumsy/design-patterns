
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
package cn.aclumsy.design.iterator;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public class ConcreteIterator<E> implements Iterator<E> {

    private int cursor;

    private final ArrayList<E> list;

    public ConcreteIterator(ArrayList<E> list) {
        this.list = list;
        this.cursor = 0;
    }

    @Override
    public boolean hasNext() {
        return cursor != list.size();
    }

    @Override
    public void next() {
        if (cursor < list.size()) {
            cursor++;
        }
    }

    @Override
    public E currentItem() {
        if (cursor < list.size()) {
            return list.get(cursor);
        }
        throw new NoSuchElementException();
    }
}
