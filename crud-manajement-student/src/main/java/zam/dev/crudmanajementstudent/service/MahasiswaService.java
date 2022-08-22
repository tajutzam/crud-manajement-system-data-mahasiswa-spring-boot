package zam.dev.crudmanajementstudent.service;

import java.util.List;

import zam.dev.crudmanajementstudent.model.entity.Mahasiswa;

public interface MahasiswaService {
 
    
    public Iterable<Mahasiswa> findAll();
    
    public Mahasiswa addMahasiswa(Mahasiswa mahasiswa);

    public Mahasiswa editMahasiswa(Mahasiswa mahasiswa);

    public void removeMahasiswa(long id);

    public Mahasiswa findById(long id);

    public List<Mahasiswa> findByName(String name);
}
