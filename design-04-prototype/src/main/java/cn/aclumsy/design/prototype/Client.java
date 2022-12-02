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

package cn.aclumsy.design.prototype;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Aclumsy
 * @version 1.0.0
 * @since 2020-09-07
 */
public class Client {

    public static void main(String[] args) throws Exception {
        RealizeType realizeType = new RealizeType();
        RealizeType cloneType = realizeType.clone();
        System.out.println("realizeType == cloneType ? " + (realizeType == cloneType));

        System.out.println("==========================================");

        Citation citation = new Citation();
        Student student = new Student();
        student.setName("张三");
        citation.setStudent(student);
        citation.show();

        ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(Paths.get("a.txt")));
        oos.writeObject(citation);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(Paths.get("a.txt")));
        Citation clone = (Citation) ois.readObject();
        ois.close();

        Student student1 = clone.getStudent();
        student1.setName("李四");
        clone.setStudent(student1);
        clone.show();

    }
}
