package K23CNT3_HaQuangMinh_Prj3.service.impl;

import K23CNT3_HaQuangMinh_Prj3.entity.HqmProduct;
import K23CNT3_HaQuangMinh_Prj3.repository.HqmProductRepository;
import K23CNT3_HaQuangMinh_Prj3.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private HqmProductRepository productRepository;

    @Override
    public List<HqmProduct> searchByName(String name) {
        return productRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public List<HqmProduct> searchByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<HqmProduct> searchByPrice(Double min, Double max) {
        return productRepository.findByPriceBetween(min, max);
    }

    @Override
    public List<HqmProduct> getAll() {
        return productRepository.findAll();
    }

    @Override
    public HqmProduct getById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public HqmProduct save(HqmProduct product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
