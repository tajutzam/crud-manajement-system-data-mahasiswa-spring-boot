package zam.dev.crudmanajementstudent.model.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import zam.dev.crudmanajementstudent.model.entity.Mahasiswa;

@Repository
public interface MahasiswaRepository extends CrudRepository<Mahasiswa , Long> {
    
    List<Mahasiswa> findByNameContains(String name);
}
