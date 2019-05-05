package guet.ty.member.service;

import guet.ty.member.entity.Manager;

public interface ManagerService {
    Manager getManager(String username);

    void editManager(Manager manager);
}
