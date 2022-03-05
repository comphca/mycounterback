package com.comphca.mycounterback.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

/**
 * @Created by comphca
 * @Date 2022/2/28 7:26
 * @Description TODO
 */

public class JsonUtils {
    public static String obj2String(Object ob){
        return JSON.toJSONString(ob);
    }

    public static <T> Object string2Obj(String obj,Class<T> clazz){
        return JSON.parseObject(obj,clazz);
    }


    /*
    *
    * 序列化测试
    * */





    class  user{
        private String name;
        private int age;
        public user(String name,int age){
            this.age = age;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }


    public static void main(String[] args) {
        class  user{
            private String name;
            private int age;

            public String getName() {
                return name;
            }

            public int getAge() {
                return age;
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setAge(int age) {
                this.age = age;
            }

            @Override
            public String toString() {
                return "user{" +
                        "name='" + name + '\'' +
                        ", age=" + age +
                        '}';
            }
        }
        
        user u = new user();
        u.setAge(27);
        u.setName("glj");
        System.out.println(JsonUtils.string2Obj(JsonUtils.obj2String(u),user.class).toString());

        user1 u1 = new user1("glj",28);
        System.out.println(JsonUtils.string2Obj(JsonUtils.obj2String(u1),user.class).toString());

    }

    static class  user1{
        private String name;
        private int age;
        public user1(String name,int age){
            this.age = age;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "user{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
