package K23CNT3_HaQuangMinh_Prj3.service;

import K23CNT3_HaQuangMinh_Prj3.entity.HqmUser;

import java.util.List;

public interface UserService {
    List<HqmUser> getAll();

    HqmUser getById(Long id);

    HqmUser getByUsername(String username);

    HqmUser save(HqmUser user);

    void delete(Long id);
}
