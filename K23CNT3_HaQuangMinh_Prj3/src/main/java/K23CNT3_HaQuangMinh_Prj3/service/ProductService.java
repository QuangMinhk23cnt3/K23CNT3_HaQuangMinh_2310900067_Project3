package K23CNT3_HaQuangMinh_Prj3.service;

import K23CNT3_HaQuangMinh_Prj3.entity.HqmProduct;

import java.util.List;

public interface ProductService {
    List<HqmProduct> searchByName(String name);

    List<HqmProduct> searchByCategory(Long categoryId);

    List<HqmProduct> searchByPrice(Double min, Double max);

    List<HqmProduct> getAll();

    HqmProduct getById(Long id);

    HqmProduct save(HqmProduct product);

    void delete(Long id);
}
