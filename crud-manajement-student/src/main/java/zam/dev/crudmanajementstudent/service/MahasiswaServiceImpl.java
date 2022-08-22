package zam.dev.crudmanajementstudent.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zam.dev.crudmanajementstudent.model.entity.Mahasiswa;
import zam.dev.crudmanajementstudent.model.repo.MahasiswaRepository;

@Service
@Transactional
public class MahasiswaServiceImpl implements MahasiswaService {

    @Autowired
    private MahasiswaRepository mahasiswaRepository;

    @Override
    public Iterable<Mahasiswa> findAll() {
        return mahasiswaRepository.findAll();
    }

    @Override
    public Mahasiswa addMahasiswa(Mahasiswa mahasiswa) {
        // TODO Auto-generated method stub
        return mahasiswaRepository.save(mahasiswa);
    }

    @Override
    public Mahasiswa editMahasiswa(Mahasiswa mahasiswa) {
        // TODO Auto-generated method stub
        return mahasiswaRepository.save(mahasiswa);
    }

    @Override
    public void removeMahasiswa(long id) {
        // TODO Auto-generated method stub
        mahasiswaRepository.deleteById(id);
    }

    @Override
    public Mahasiswa findById(long id) {
        // TODO Auto-generated method stub
        Optional<Mahasiswa> optional = mahasiswaRepository.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

    @Override
    public List<Mahasiswa> findByName(String name) {
        return mahasiswaRepository.findByNameContains(name);
    }
    
}
