package K23CNT3_HaQuangMinh_Prj3.service.impl;

import K23CNT3_HaQuangMinh_Prj3.entity.HqmUser;
import K23CNT3_HaQuangMinh_Prj3.repository.HqmUserRepository;
import K23CNT3_HaQuangMinh_Prj3.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private HqmUserRepository userRepository;

    @Override
    public List<HqmUser> getAll() {
        return userRepository.findAll();
    }

    @Override
    public HqmUser getById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public HqmUser getByUsername(String username) {
        return userRepository.findByUsername(username).orElse(null);
    }

    @Override
    public HqmUser save(HqmUser user) {
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
