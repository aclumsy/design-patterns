
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
package cn.aclumsy.design.memento.demo01;

/**
 * 发起人角色
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public class Originator {

    private String state = "原始对象";

    private String id;

    private String name;

    public Memento createMemento(){
        return new Memento(id, name);
    }

    public void restoreMemento(Memento memento) {
        this.state = memento.getState();
        this.id = memento.getId();
        this.name = memento.getName();
    }

    public Originator(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Originator{" +
            "state='" + state + '\'' +
            ", id='" + id + '\'' +
            ", name='" + name + '\'' +
            '}';
    }
}
