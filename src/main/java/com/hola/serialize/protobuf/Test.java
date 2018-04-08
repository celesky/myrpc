package com.hola.serialize.protobuf;

import com.hola.serialize.protobuf.AddressBookProtos.Person;
public class Test {

    public static void main(String[] args) throws Exception {
        Person john =
                Person.newBuilder()
                        .setId(1234)
                        .setName("John Doe")
                        .setEmail("jdoe@example.com")
                        .addPhones(
                                Person.PhoneNumber.newBuilder()
                                        .setNumber("555-4321")
                                        .setType(Person.PhoneType.HOME))
                        .addPhones(Person.PhoneNumber.newBuilder()
                                .setNumber("382-3321")
                                .setType(Person.PhoneType.HOME))
                        .build();

        //序列化 转换成byte
        byte[] bytes = john.toByteArray();
        System.out.println("序列化成 bytes = " + bytes.length);

        //反序列化 转换成
        Person person =  Person.parseFrom(bytes);
        System.out.println("反序列化 person\n" + person.toString());

    }
}
