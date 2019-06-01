package com.hyperchain.spring_boot.design.abstractFactory;

public interface IFactory {

    IUser createUser();

    IDepartment createDepartment();
}
