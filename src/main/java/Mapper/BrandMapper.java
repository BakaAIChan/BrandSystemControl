package Mapper;

import Domain.Brand;

import java.util.List;

public interface BrandMapper {
    List<Brand> SelectAllBrand();
    void addBrand(Brand brand);
    void deleteBrand(int id);

    Brand SelectOneById(int id);

    void updateBrand(Brand brand);
}
